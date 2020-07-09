package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Questions {
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
		Questions other = (Questions) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}

	public Questions(int id) {
		super();
		this.id = id;
	}

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
}
