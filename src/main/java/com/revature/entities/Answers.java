package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answers {
	@Id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Answers other = (Answers) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}

	public Answers(int id) {
		super();
		this.id = id;
	}

	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}
}
