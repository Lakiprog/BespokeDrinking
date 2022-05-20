package com.bespoke.drinking.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private boolean processed;
	
	@Column
	private String text;
	
	@ElementCollection(fetch=FetchType.EAGER)
    @Column(name="answers")
    @CollectionTable(name="question_answers", joinColumns=@JoinColumn(name="question_id"))
	private List<Answer> answers;
	
	@OneToOne
	private Answer selectedAnswer;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public Answer getSelectedAnswer() {
		return selectedAnswer;
	}
	
	public void setSelectedAnswer(Answer selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", processed=" + processed + ", text=" + text + ", answers=" + answers
				+ ", selectedAnswer=" + selectedAnswer + "]";
	}
}
