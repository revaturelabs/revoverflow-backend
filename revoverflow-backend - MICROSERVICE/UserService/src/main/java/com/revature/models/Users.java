package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Users {

	@Id
	@Column(unique = true, name = "user_id")
	private int userID;
	
	@Column(name = "account_id")
	private int RSSAccountId;
	
	@Column(name = "points")
	private int points;
	
	@Column(name = "admin_role")
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
}
