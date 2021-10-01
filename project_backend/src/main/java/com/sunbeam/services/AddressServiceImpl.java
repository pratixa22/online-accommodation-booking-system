package com.sunbeam.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.AddressDao;
import com.sunbeam.entities.Address;


@Transactional
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDao ad;	
	
	@Override
	public Address save(Address a) {		
		return ad.save(a);
	}

	@Override
	public void deleteById(int id) {
		ad.deleteById(id);	
	}

	@Override
	public Address findById(int id) {
		return ad.findById(id);
	}

}
