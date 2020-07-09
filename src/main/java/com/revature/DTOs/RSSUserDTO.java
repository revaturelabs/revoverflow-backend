package com.revature.DTOs;

import java.util.Arrays;

public class RSSUserDTO {
	
	/* User Class Fields - along with the usual Generated methods */
	
	private int Id;
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastNameString;
	
	private String isAdmin;
	
	private byte[] profilePic;

	public RSSUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RSSUserDTO( String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public RSSUserDTO(int id, String email, String password, String firstName, String lastNameString, String isAdmin,
			byte[] profilePic) {
		super();
		Id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastNameString = lastNameString;
		this.isAdmin = isAdmin;
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "UserDTO [Id=" + Id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastNameString=" + lastNameString + ", isAdmin=" + isAdmin + ", profilePic="
				+ Arrays.toString(profilePic) + "]";
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
		result = prime * result + Arrays.hashCode(profilePic);
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
		RSSUserDTO other = (RSSUserDTO) obj;
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
		if (!Arrays.equals(profilePic, other.profilePic))
			return false;
		return true;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNameString() {
		return lastNameString;
	}

	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	
	
	
}
