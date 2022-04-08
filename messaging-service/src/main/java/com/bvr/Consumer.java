package com.bvr;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	
	@JmsListener(destination="sample.queue")
	public void receiveQueue(String text) {
		
		
		System.out.println("Message from consumer : " +  text);
	}

}
