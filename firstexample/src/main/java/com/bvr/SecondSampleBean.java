package com.bvr;

public class SecondSampleBean {

	private String message;

	public SecondSampleBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SecondSampleBean [message=" + message + "]";
	}
	
}
