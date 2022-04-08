package com.bvr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndPoints {

	@RequestMapping("/mypage")
	public String myString() {
		return "First Example Microservices ";
	}
	
	
	@RequestMapping("/second")
	public String sayHello(@RequestParam String name ) {
		return "Welcome : " + name;
	}
	
	@RequestMapping(path="/secondpathvar/{name}")
	public String sayHello2(@PathVariable String name) {
		return "Path definitions  : " + name;
	}
	
	
	@GetMapping(path="/secondBeanSample")
	public SecondSampleBean secondSampleBean() {
		return new SecondSampleBean("For Oracle Bangalore");
	}
	
}
