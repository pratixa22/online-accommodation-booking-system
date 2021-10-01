package com.sunbeam.models;

public class ChangePassword {
	private int id;
	private String oldPassword;
	private String newPassword;
	public ChangePassword() {
	}
	public ChangePassword(int id, String oldPassword, String newPassword) {
		this.id = id;
		//oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldpassword(String oldpassword) {
		oldPassword = oldpassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "ChangePassword [id=" + id + ", Oldpassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
	
	
}
