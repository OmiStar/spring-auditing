package com.coolcoder.spring.auditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coolcoder.spring.auditing.dto.InputRequest;
import com.coolcoder.spring.auditing.model.Employee;
import com.coolcoder.spring.auditing.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody InputRequest<Employee> request) {
		return service.saveEmployee(request);	
	}
	
	@PutMapping("updateEmployee/{id}/{salary}")
	public String updateEmployeeSalary(@PathVariable int id,double salary,
			InputRequest<Employee>request) {
		return service.updateEmployee(id, salary, request);
		
	}
	
}
