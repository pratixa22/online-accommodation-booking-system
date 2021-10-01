	package com.sunbeam.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.User;
import com.sunbeam.models.AccommodationDTO;
import com.sunbeam.models.AccommodationDTOAll;
import com.sunbeam.models.AccommodationInDTO;
import com.sunbeam.models.Response;
import com.sunbeam.services.AccommodationService;
import com.sunbeam.services.AddressService;
import com.sunbeam.services.CustomerService;
import com.sunbeam.utils.StorageService;

@RequestMapping("/acc")
@CrossOrigin
@RestController
public class ListController {
		
	@Autowired
	CustomerService cs;
	@Autowired
	AccommodationService as;
	@Autowired
	AddressService ads;
	@Autowired
	StorageService ss;
	
	//get list of all the accommodations
	@GetMapping("/listAll")
	public ResponseEntity<?> findAll(){
		List<Accommodations> list = as.findAll();
		Stream<AccommodationDTOAll> result = list.stream().map(Accommodations -> AccommodationDTOAll.fromEntity(Accommodations));
		return Response.success(result);	
	}
	
	@GetMapping("/lists/verified")
	public ResponseEntity<?> verifiedList(){
		List<Accommodations> list = as.findByStatus(true);
		Stream<AccommodationDTOAll> result = list.stream().map(Accommodations -> AccommodationDTOAll.fromEntity(Accommodations));
		return Response.success(result);	
	}
	
	// find accommodation by accommodation Id
	@GetMapping("/accId/{id}")
	public ResponseEntity<?> findAccommodationById(@PathVariable("id") int id){
		Accommodations acco = as.findById(id);
		AccommodationDTO result = AccommodationDTO.fromEntity(acco);
		return Response.success(result);
	}
	
	@GetMapping("/{location}")
	public ResponseEntity<?> findAccommodationByLocation(@PathVariable("location") String location){
		List<Accommodations> list = as.findAllByLocation(location);
		Stream<AccommodationDTO> result = list.stream().map(Accommodations -> AccommodationDTO.fromEntity(Accommodations));
		return Response.success(result);
	}
	
	//find all the accommodations of a host with the help of user_id
	@GetMapping("/userAcco/{userId}")
	public ResponseEntity<?> findAccByUserId(@PathVariable("userId") int userId){
		User host = cs.findById(userId);
		 List<Accommodations> list = as.findAllByHost(host);
		 Stream<AccommodationDTO> result = list.stream().map(Accommodations -> AccommodationDTO.fromEntity(Accommodations));
		return Response.success(result);
	}
	//add new Accommodation with image
	@PostMapping("addAcco")
	public ResponseEntity<?> save(AccommodationInDTO dto){
		User c = cs.findById(dto.getUserId());
		if(("user").equals(c.getRole()))
			c.setRole("host");
		dto.setHost(c);
		Accommodations acco = AccommodationInDTO.toEntity(dto);
		acco = as.saveAcco(acco , dto.getThumbnail());
		return Response.success(acco);
		
	}
	
	@PutMapping("/editAcco/{id}")
	public ResponseEntity<String> updateAcco(AccommodationInDTO dto, @PathVariable("id") int id ){
		Accommodations acco = as.findById(dto.getId());
		if(dto.getDescription() != null)
			acco.setDescription(dto.getDescription());
		if(dto.getGuest() != 0)
			acco.setGuest(dto.getGuest());
		if(dto.getTitle() != null)
			acco.setTitle(dto.getTitle());
		if(dto.getPrice() != 0)
		acco.setPrice(dto.getPrice());	
		if(dto.getThumbnail() != null)
			acco = as.saveAcco(acco , dto.getThumbnail());				
		as.save(acco);
		return ResponseEntity.ok("accommodation updated");
	}
	@PutMapping("/approveAcco/{id}")
	public ResponseEntity<String> updateAprrove( @PathVariable("id") int id ){
		Accommodations acco = as.findById(id);
		acco.setStatus(true);			
		as.save(acco);
		return ResponseEntity.ok("accommodation approved");
	}
	
	// Delete Accommodation by accommodation Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(AccommodationInDTO dto, @PathVariable("id") int id ){	
		//Address address = ads.findById(dto.getAddressId());
//		Accommodations acco = as.findById(dto.getId());
//		acco.setAddress(null);
//		User host = cs.findById(id);
//		List<Accommodations> list = as.findAllByHost(host);	
//		System.out.println(list);
//		if(list == null)
//			host.setRole("user");
//		dto.setHost(host);
		as.deleteById(id);
		return ResponseEntity.ok("accommodation deleted");
	}
}
