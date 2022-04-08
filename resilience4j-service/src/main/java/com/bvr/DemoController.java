package com.bvr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	public DemoController() {
		// TODO Auto-generated constructor stub
	}
	
	Logger LOG = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private HttpBinService httpBin;
	
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;


	public DemoController(HttpBinService httpBin, CircuitBreakerFactory circuitBreakerFactory) {
		super();
		this.httpBin = httpBin;
		this.circuitBreakerFactory = circuitBreakerFactory;
	}
	
	
	@GetMapping("/get")
	public Map get() {
		return httpBin.get();
		
	}

	
	@GetMapping("/delay/{seconds}")
	public Map delay(@PathVariable int seconds) {
		return circuitBreakerFactory.create("delay").run(httpBin.delaySupplier(seconds), t -> {
			LOG.warn("Delay call failed Error", t);
			
			Map<String, String> fallback = new HashMap<>();
			
			fallback.put("Hello", "Oracle - custom fallback message");
			return fallback;
		});
	}
	
	
}
