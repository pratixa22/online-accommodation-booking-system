package com.sunbeam.controllers;


import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sunbeam.entities.User;
import com.sunbeam.models.AccommodationInDTO;
import com.sunbeam.models.Response;
import com.sunbeam.models.UpdateUser;
import com.sunbeam.models.UserDTO;
import com.sunbeam.services.CustomerService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	CustomerService cs;

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){

		User user = cs.findById(id);		
		return ResponseEntity.ok(user);	
	}
	
	@GetMapping("/hostAll")
	public ResponseEntity<?> getHostByRole(){
		List<User> list = cs.findAllByRole("host");	
		Stream<UserDTO> result = list.stream().map(User -> UserDTO.fromEntity(User));
		return Response.success(result);
	
	}
	
	@GetMapping("/userAll")
	public ResponseEntity<?> getUserByRole(){
		List<User> list = cs.findAllByRole("user");	
		Stream<UserDTO> result = list.stream().map(User -> UserDTO.fromEntity(User));
		return Response.success(result);
	
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody UpdateUser u){
		User user = cs.findById(u.getId());
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setPhoneNo(u.getPhoneNo());
		user.setDob(u.getDob());
		user.setIdProof(u.getIdProof());
		
		cs.update(user);
		return ResponseEntity.ok("Profile updated");	
	}
	
	@PutMapping("/approveUser/{id}")
	public ResponseEntity<String> updateAprrove( @PathVariable("id") int id ){
		User user = cs.findById(id);
		user.setApprovalStatus("approved");	
		cs.update(user);
		return ResponseEntity.ok("approved");
	}
	
	// Delete User by User Id
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(AccommodationInDTO dto, @PathVariable("id") int id ){	
			cs.deleteById(id);
			return ResponseEntity.ok("User deleted");
		}
}