package com.bespoke.drinking.model;

import java.util.List;

public class Question {
	String text;
	List<Answer> answers;
	Answer selectedAnswer;
	
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
}
