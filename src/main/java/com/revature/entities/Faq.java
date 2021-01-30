package com.revature.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class Faq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "question_id")
	private Question questionId;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "answer_id")
	private Answer answerId;
	
    @JoinColumn(name = "location_id")
	private int locationId;
 
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}

	public Answer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Answer answerId) {
		this.answerId = answerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		result = prime * result + id;
		result = prime * result + locationId;
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
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
		Faq other = (Faq) obj;
		if (answerId == null) {
			if (other.answerId != null)
				return false;
		} else if (!answerId.equals(other.answerId))
			return false;
		if (id != other.id)
			return false;
		if (locationId != other.locationId)
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faq [id=" + id + ", questionId=" + questionId + ", answerId=" + answerId + ", locationId=" + locationId
				+ "]";
	}

	public Faq(int id, Question questionId, Answer answerId, int locationId) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.answerId = answerId;
		this.locationId = locationId;
	}

	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}

}
