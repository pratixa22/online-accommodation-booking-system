package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Accommodations;
import com.sunbeam.entities.Address;
import com.sunbeam.models.AddressDTO;
import com.sunbeam.services.AccommodationService;
import com.sunbeam.services.AddressService;

@RequestMapping("/acc/address")
@CrossOrigin
@RestController
public class AddressController {
		
	@Autowired
	AccommodationService as;	
	@Autowired
	AddressService ads;
	
	//create address for an accommodation
	@PostMapping("/new")
	public ResponseEntity<String> save(@RequestBody AddressDTO dto){
		Accommodations acco = as.findById(dto.getAccoId());
		Address address = AddressDTO.toEntity(dto);
		address.setAcco(acco);
		acco.setAddress(address);
		ads.save(address);
		return ResponseEntity.ok("Address added");
		
	}
	
	//Modify / update address by Accommodation id
	@PutMapping("/update/{acc_id}")
	public ResponseEntity<String> updateAddress(AddressDTO dto, @PathVariable("acc_id") int acc_id ){
		Accommodations acco = as.findById(acc_id);
		Address address = AddressDTO.toEntity(dto);
		address = acco.getAddress();
		if(dto.getAddressLine1() != null)
			address.setAddressLine1(dto.getAddressLine1());
		if(dto.getAddressLine2() != null)
			address.setAddressLine2(dto.getAddressLine2());
		if(dto.getCity() != null)
			address.setCity(dto.getCity());
		if(dto.getState() != null)
			address.setState(dto.getState());
		if(dto.getPincode() != 0)
			address.setPincode(dto.getPincode());			
		ads.save(address);
		return ResponseEntity.ok("Address updated");
	}
	
//	// Delete Address by accommodation Id
//		@DeleteMapping("/delete/{acc_id}")
//		public ResponseEntity<String> delete(@PathVariable("acc_id") int acc_id ){	
//			Accommodations acco = as.findById(acc_id);
//			System.out.println(acco.getAddress().getId());
//			ads.deleteById(acco.getAddress().getId());
//			return ResponseEntity.ok("accommodation deleted");
//		}
}
