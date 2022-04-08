package com.bvr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bvr.bean.PropertyAccessBean;
import com.bvr.bean.PropertyAccessValue;

@RestController
@RequestMapping("/access")
public class PropertyFileAccessController {

	public PropertyFileAccessController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	PropertyAccessBean propertyAccessBean;
	
	
	@GetMapping("accessPropertyfile")
	public PropertyAccessValue accessPropertyFile() {
		
		refreshActuator();
		return new PropertyAccessValue(propertyAccessBean.getName(), propertyAccessBean.getDescription());
	}
	
	
	public void refreshActuator() {
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseurl = "http://localhost:8100/actuator/refresh";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("Content-Type", "application/json");
		
		HttpEntity entity = new HttpEntity(headers);
		
		
		ResponseEntity<String> results = restTemplate.postForEntity(baseurl, entity, String.class);
	}
}
