package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.CustomerDao;

import com.sunbeam.entities.User;
import com.sunbeam.models.ChangePassword;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User findByEmail(String email) {
		return customerDao.findByEmail(email);
	}
	@Override
	public List<User> findAll() {
		return customerDao.findAll();
	}
	@Override
	public User authenticate(String email, String password) {
		User customer = findByEmail(email);
		
		if(customer != null && passwordEncoder.matches(password, customer.getPassword()))
			return customer;
		return null;
	}
	@Override
	public boolean changepw(ChangePassword pw) {
		User c = findById(pw.getId());
		if(passwordEncoder.matches(pw.getOldPassword(), c.getPassword())) {
			c.setPassword(pw.getNewPassword());
			save(c);
			return true;
		}
		return false;
	}
	
	@Override
	public User findById(int t_id) {
		Optional<User> t = customerDao.findById(t_id);
		return t.orElse(null);
	}

	@Override
	public User save(User customer) {
		String encPassword = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encPassword);
		return customerDao.save(customer);
	}

	@Override
	public User update(User t) {
		return customerDao.save(t);
	}

	@Override
	public void deleteById(int t_id) {
			customerDao.deleteById(t_id);
	}
	@Override
	public List<User> findAllByRole(String role) {
		return customerDao.findAllByRole(role);
	}
}
