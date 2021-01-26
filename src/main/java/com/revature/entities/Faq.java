package com.revature.entities;

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
	private int faqId;
	
	@OneToOne
    @JoinColumn(name = "question_id")
	private Question questionId;
	
	
	@OneToOne
    @JoinColumn(name = "answer_id")
	private Answer answerId;
	
	@Column(name = "location")
	private String location;


	public int getFaqId() {
		return faqId;
	}


	public void setFaqId(int faqId) {
		this.faqId = faqId;
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		result = prime * result + faqId;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		if (faqId != other.faqId)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
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
		return "Faq [faqId=" + faqId + ", questionId=" + questionId + ", answerId=" + answerId + ", location="
				+ location + "]";
	}


	public Faq(int faqId, Question questionId, Answer answerId, String location) {
		super();
		this.faqId = faqId;
		this.questionId = questionId;
		this.answerId = answerId;
		this.location = location;
	}


	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
