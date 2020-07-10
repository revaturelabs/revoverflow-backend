package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// add the not null check in the service layer
	private int roleId;
	
	@Min(value = 0, message = "Points must be greate than -1")
	private int points;
	
	// add the not null check in the service layer
	@Column(name = "user_id")
	private int userID;
	
	@NotBlank(message = "Username must be a string value")
	private String userName;
	
	@NotBlank(message = "Email must have a string value")
	private String email;
	
	@NotBlank(message = "Password must have a string value")
	private String password;
	
	private int addressId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + points;
		result = prime * result + roleId;
		result = prime * result + userID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (addressId != other.addressId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (points != other.points)
			return false;
		if (roleId != other.roleId)
			return false;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", roleId=" + roleId + ", points=" + points + ", userID=" + userID + ", userName="
				+ userName + ", email=" + email + ", password=" + password + ", addressId=" + addressId + "]";
	}

	public User(int id, int roleId, int points, int userID, String userName, String email, String password,
			int addressId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.points = points;
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.addressId = addressId;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
