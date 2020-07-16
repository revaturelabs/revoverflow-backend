package com.revature.DTOs;

public class RSSAccountDTO {
	
	private int accId;
    private int userId;
    private int accTypeId;
	private int points;
	
	public RSSAccountDTO() {
		super();
	}

	public RSSAccountDTO(int accId, int userId, int accTypeId, int points) {
		super();
		this.accId = accId;
		this.userId = userId;
		this.accTypeId = accTypeId;
		this.points = points;
	}
	public RSSAccountDTO( int userId, int points) {
		super();
		this.userId = userId;
		this.accTypeId = 3;
		this.points = points;
	}



	public RSSAccountDTO(int userId) {
		super();
		this.userId = userId;
		this.accTypeId=3;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accId;
		result = prime * result + accTypeId;
		result = prime * result + points;
		result = prime * result + userId;
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
		RSSAccountDTO other = (RSSAccountDTO) obj;
		if (accId != other.accId)
			return false;
		if (accTypeId != other.accTypeId)
			return false;
		if (points != other.points)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountDTO [accId=" + accId + ", userId=" + userId + ", accTypeId=" + accTypeId + ", points=" + points
				+ "]";
	}

}
