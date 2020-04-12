package com.expression.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXPRESSIONEVAL")
public class ExpressionEval {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String input;
	private int output;

	public ExpressionEval() {
	}

	public ExpressionEval(int id, String input, int output) {
		super();
		this.id = id;
		this.input = input;
		this.output = output;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public int getOutput() {
		return output;
	}

	public void setOutput(int output) {
		this.output = output;
	}

}

