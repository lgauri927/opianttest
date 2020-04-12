package com.expression.pojo;

public class ExpressionEvalPojo {
	private Integer id;
	private String input;
	private int output;

	public ExpressionEvalPojo() {

	}

	public ExpressionEvalPojo(Integer id, String input, int output) {
		this.id = id;
		this.input = input;
		this.output = output;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "ExpressionEvalPojo [input=" + input + ", output=" + output + "]";
	}

}
