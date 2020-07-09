package com.revature.DTOs;

public class UserDTO {
	
	/* User Class Fields - along with the usual Generated methods */
	
	private int Id;
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastNameString;
	
	private String isAdmin;

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastNameString
	 */
	public String getLastNameString() {
		return lastNameString;
	}

	/**
	 * @param lastNameString the lastNameString to set
	 */
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}

	/**
	 * @return the isAdmin
	 */
	public String getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
		result = prime * result + ((lastNameString == null) ? 0 : lastNameString.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (Id != other.Id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isAdmin == null) {
			if (other.isAdmin != null)
				return false;
		} else if (!isAdmin.equals(other.isAdmin))
			return false;
		if (lastNameString == null) {
			if (other.lastNameString != null)
				return false;
		} else if (!lastNameString.equals(other.lastNameString))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [Id=" + Id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastNameString=" + lastNameString + ", isAdmin=" + isAdmin + "]";
	}

	public UserDTO(int id, String email, String password, String firstName, String lastNameString, String isAdmin) {
		super();
		Id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastNameString = lastNameString;
		this.isAdmin = isAdmin;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
