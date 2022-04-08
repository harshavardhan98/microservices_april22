package com.bvr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	public HrResource() {
		// TODO Auto-generated constructor stub
	}
	
	
	List<Employee> employees = (List<Employee>) Arrays.asList( 
			new Employee("E1", "RAM", "KUMAR", "MEDTECH"),
			new Employee("E2", "RAJ", "KUMAR", "SURGERY"),
			new Employee("E3", "ANIL", "KUMAR", "DENTISTRY")
			
			
			);
	
	
	@RequestMapping("/employees")
	public EmployeeList getEmployees() {
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.setEmployee(employees);
		return employeeList;
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id")String id) {
		Employee e = employees.stream()
				.filter(employee -> id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		
		return e;
	}

}
