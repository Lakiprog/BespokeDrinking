package com.bespoke.drinking.dto;

import com.bespoke.drinking.model.Flavour;

public class NewQuestion {

	private String text;
	
	private Flavour firstAnswerKey;
	
	private Double firstAnswerValue;
	
	private Flavour secondAnswerKey;
	
	private Double secondAnswerValue;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Flavour getFirstAnswerKey() {
		return firstAnswerKey;
	}

	public void setFirstAnswerKey(Flavour firstAnswerKey) {
		this.firstAnswerKey = firstAnswerKey;
	}

	public Double getFirstAnswerValue() {
		return firstAnswerValue;
	}

	public void setFirstAnswerValue(Double firstAnswerValue) {
		this.firstAnswerValue = firstAnswerValue;
	}

	public Flavour getSecondAnswerKey() {
		return secondAnswerKey;
	}

	public void setSecondAnswerKey(Flavour secondAnswerKey) {
		this.secondAnswerKey = secondAnswerKey;
	}

	public Double getSecondAnswerValue() {
		return secondAnswerValue;
	}

	public void setSecondAnswerValue(Double secondAnswerValue) {
		this.secondAnswerValue = secondAnswerValue;
	}
	
	public void addQuotesToText() {
		this.text =  "\"" + this.text + "\"";
	}
}
