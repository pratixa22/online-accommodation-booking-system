package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.User;
import com.sunbeam.models.ChangePassword;

public interface CustomerService {
		User findByEmail(String email);
		User authenticate(String email, String password);
		User findById(int id);
		User save(User c);
		User update (User t);
		void deleteById(int t_id);
		public List<User> findAll();
		List<User> findAllByRole (String role);
		public boolean changepw(ChangePassword pw);

}
