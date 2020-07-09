package com.revature.entities;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "users")
public class User {

	@Id
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
	
	@Transient
	private String jwt;

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

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + RSSAccountId;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + points;
		result = prime * result + Arrays.hashCode(profilePicture);
		result = prime * result + userID;
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
		if (RSSAccountId != other.RSSAccountId)
			return false;
		if (admin != other.admin)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (points != other.points)
			return false;
		if (!Arrays.equals(profilePicture, other.profilePicture))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", RSSAccountId=" + RSSAccountId + ", points=" + points + ", admin=" + admin
				+ ", profilePicture=" + Arrays.toString(profilePicture) + ", email=" + email + ", jwt=" + jwt + "]";
	}

	public User(@NotNull int userID, int rSSAccountId, int points, boolean admin, byte[] profilePicture,
			@Valid @NotBlank @Email(message = "Should be a valid email") String email) {
		super();
		this.userID = userID;
		RSSAccountId = rSSAccountId;
		this.points = points;
		this.admin = admin;
		this.profilePicture = profilePicture;
		this.email = email;
	}

	public User(@NotNull int userID, int rSSAccountId, int points, boolean admin, byte[] profilePicture,
			@Valid @NotBlank @Email(message = "Should be a valid email") String email, String jwt) {
		super();
		this.userID = userID;
		RSSAccountId = rSSAccountId;
		this.points = points;
		this.admin = admin;
		this.profilePicture = profilePicture;
		this.email = email;
		this.jwt = jwt;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	
}
