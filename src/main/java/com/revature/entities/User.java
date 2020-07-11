package com.revature.entities;
<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> c4d1e574063e675c81d45e016e5d3bbecaac95f2

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


=======
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
>>>>>>> c4d1e574063e675c81d45e016e5d3bbecaac95f2

@Entity
@Table(name = "users")
public class User {

	@Id
<<<<<<< HEAD
	@NotNull
	@Column(unique = true, name = "user_id")
	private int userID;
	
	@Column(name = "account_id")
	private int RSSAccountId;
	
	@Column(name = "points")
	private int points;
	
	@Column(name = "admin")
	private boolean admin;
	
	@Column(name = "profile_picture")
	private byte[] profilePicture;
	
	@Valid
	@NotBlank @Email(message = "Should be a valid email") @Column(name="email",unique=true, nullable=false)
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Transient
	private String jwt;
=======
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
>>>>>>> c4d1e574063e675c81d45e016e5d3bbecaac95f2

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotNull int userID, int rSSAccountId, int points, boolean admin, byte[] profilePicture,
			@Valid @NotBlank @Email(message = "Should be a valid email") String email, String firstName,
			String lastName) {
		super();
		this.userID = userID;
		RSSAccountId = rSSAccountId;
		this.points = points;
		this.admin = admin;
		this.profilePicture = profilePicture;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", RSSAccountId=" + RSSAccountId + ", points=" + points + ", admin=" + admin
				+ ", profilePicture=" + Arrays.toString(profilePicture) + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", jwt=" + jwt + "]";
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
<<<<<<< HEAD
		result = prime * result + RSSAccountId;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((jwt == null) ? 0 : jwt.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + points;
		result = prime * result + Arrays.hashCode(profilePicture);
		result = prime * result + userID;
=======
		result = prime * result + addressId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + points;
		result = prime * result + roleId;
		result = prime * result + userID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
>>>>>>> c4d1e574063e675c81d45e016e5d3bbecaac95f2
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
<<<<<<< HEAD
		if (RSSAccountId != other.RSSAccountId)
			return false;
		if (admin != other.admin)
=======
		if (addressId != other.addressId)
>>>>>>> c4d1e574063e675c81d45e016e5d3bbecaac95f2
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
<<<<<<< HEAD
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (jwt == null) {
			if (other.jwt != null)
				return false;
		} else if (!jwt.equals(other.jwt))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (points != other.points)
			return false;
		if (!Arrays.equals(profilePicture, other.profilePicture))
			return false;
		if (userID != other.userID)
=======
		if (id != other.id)
>>>>>>> c4d1e574063e675c81d45e016e5d3bbecaac95f2
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

<<<<<<< HEAD
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRSSAccountId() {
		return RSSAccountId;
	}

	public void setRSSAccountId(int rSSAccountId) {
		RSSAccountId = rSSAccountId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


	
=======
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

>>>>>>> c4d1e574063e675c81d45e016e5d3bbecaac95f2
}
