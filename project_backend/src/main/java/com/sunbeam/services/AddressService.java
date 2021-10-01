package com.sunbeam.services;

import com.sunbeam.entities.Address;

public interface AddressService {	
		Address save(Address a);
		Address findById(int id);
		void deleteById(int id);	
}
