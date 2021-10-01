package com.sunbeam.services;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.daos.AccommodationDao;
import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.User;
import com.sunbeam.utils.StorageService;

@Transactional
@Service
public class AccommodationServiceImpl implements AccommodationService {
	
	@Autowired
	AccommodationDao ad;	
	@Autowired
	StorageService ss;
	
	@Override
	public Accommodations save(Accommodations a) {		
		return ad.save(a);
	}

	@Override
	public List<Accommodations> findAll() {	
		return ad.findAll();
	}

	@Override
	public Accommodations findById(int id) {
		return ad.findById(id);
	}
	
	@Override
	public List<Accommodations> findAllByHost(User host) {
		return ad.findAllByHost(host);
	}

	@Override
	public Accommodations saveAcco(Accommodations acco, MultipartFile thumbnail) {
		String fileName = ss.store(thumbnail);
		acco.setThumbnail(fileName);
		return ad.save(acco);
	}

	@Override
	public List<Accommodations> findAllByLocation(String location) {
		return ad.findAllByLocation(location);
	}

	@Override
	public void deleteById(int id) {
		ad.deleteById(id);
	}

	@Override
	public List<Accommodations> findByStatus(Boolean boolean1) {
	
		return ad.findByStatus(boolean1);
	}
	
}
