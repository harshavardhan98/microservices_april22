package com.bvr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	public PathologyResource() {
		// TODO Auto-generated constructor stub
	}
	
	List<Disease> diseases = Arrays.asList(  
			new Disease("D1", "Astama", "Warm Water Bath"),
			new Disease("D2", "HeadAche", "Hot Water Vapour"),
			new Disease("D3", "Corona ", "Wash Hands and stay safe")
			);
	
	
	
	@RequestMapping("/diseases")
	public DiseaseList diseases() {
		DiseaseList diseaseList = new DiseaseList();
		
		diseaseList.setDiseases(diseases);
		
		return diseaseList;
		
		
	}

	
	@RequestMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id")String id) {
		Disease e = diseases.stream()
				.filter(disease -> id.equals(disease.getId()))
				.findAny()
				.orElse(null);
		
		return e;
	}

	
}
