package com.bvr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		return new PropertyAccessValue(propertyAccessBean.getName(), propertyAccessBean.getDescription());
	}
	
	
	
}
