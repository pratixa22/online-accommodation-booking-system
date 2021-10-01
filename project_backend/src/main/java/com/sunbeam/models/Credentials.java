package com.sunbeam.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Credentials {
	@NotBlank(message = "Email cannot be Blank")
	@Email(message = "Invalid Email")
	private String email;
	@NotBlank(message = "Password cannot be Blank")
	@Size(min = 4, max = 15, message = "Password size should be between 4 to 15")
	private String password;

	public Credentials() {
	}

	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credentials [email=" + email + ", password=" + password + "]";
	}

}
