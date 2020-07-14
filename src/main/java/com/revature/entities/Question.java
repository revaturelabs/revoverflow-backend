package com.revature.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "accepted_id")
	private int acceptedId;

	@NotBlank(message = "Title requires a string value")
	private String title;

	@NotBlank(message = "Content requires a string value")
	private String content;

	// add the not null check in the service layer
	@Column(name = "creation_date")
	private LocalDate creationDate;

	@Column(name = "edit_date")
	private LocalDate editDate;

	private boolean status;

	// add the not null check in the service layer
	@Column(name = "user_id")
	private int userID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcceptedId() {
		return acceptedId;
	}

	public void setAcceptedId(int acceptedId) {
		this.acceptedId = acceptedId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getEditDate() {
		return editDate;
	}

	public void setEditDate(LocalDate editDate) {
		this.editDate = editDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acceptedId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((editDate == null) ? 0 : editDate.hashCode());
		result = prime * result + id;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Question other = (Question) obj;
		if (acceptedId != other.acceptedId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (editDate == null) {
			if (other.editDate != null)
				return false;
		} else if (!editDate.equals(other.editDate))
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", acceptedId=" + acceptedId + ", title=" + title + ", content=" + content
				+ ", creationDate=" + creationDate + ", editDate=" + editDate + ", status=" + status + ", userID="
				+ userID + "]";
	}

	public Question(int id, int acceptedId, String title, String content, LocalDate creationDate, LocalDate editDate,
			boolean status, int userID) {
		super();
		this.id = id;
		this.acceptedId = acceptedId;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.editDate = editDate;
		this.status = status;
		this.userID = userID;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

}
