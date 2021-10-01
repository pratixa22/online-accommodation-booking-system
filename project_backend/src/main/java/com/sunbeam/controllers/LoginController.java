package com.sunbeam.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunbeam.entities.User;
import com.sunbeam.models.ChangePassword;
import com.sunbeam.models.Credentials;
import com.sunbeam.models.UserRedux;
import com.sunbeam.services.AccommodationService;
import com.sunbeam.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController {
		
	@Autowired
	CustomerService cs;
	AccommodationService as;

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody Credentials cred, BindingResult res){
		if(res.hasFieldErrors("email")) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is invalid" );
		if(res.hasFieldErrors("password")) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password size should be between 6 to 15" );
		if (cs.findByEmail(cred.getEmail()) == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not register" );
		User t = cs.authenticate(cred.getEmail(), cred.getPassword());
		if(t != null) {
			UserRedux user = new UserRedux(t.getId(), t.getFirstName(), t.getLastName(), t.getEmail(),t.getRole(),t.getApprovalStatus() );	
			System.out.println(user);
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong password" );	
	}
	@PutMapping("/changepw")
	public ResponseEntity<?> passwordChange(@RequestBody ChangePassword pw){
		boolean status = cs.changepw(pw);
		if(status) {
			
			return ResponseEntity.ok("Password Changed");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Old password is wrong" );
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User c){
		User newUser = cs.findByEmail(c.getEmail());
		if(newUser != null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is Already registered" );
		cs.save(c);
		return ResponseEntity.ok("registered");
		
	}
}
