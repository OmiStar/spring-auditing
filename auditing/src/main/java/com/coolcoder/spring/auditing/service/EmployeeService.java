package com.coolcoder.spring.auditing.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coolcoder.spring.auditing.dao.EmployeeRepository;
import com.coolcoder.spring.auditing.dto.InputRequest;
import com.coolcoder.spring.auditing.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String saveEmployee(InputRequest<Employee> request) {
		
		String curreUser=request.getLoggedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		Employee employee=request.getEmployee();
		employee.setCreatedBy(curreUser);
		employeeRepository.save(employee);
		return "EMployee Saved SuccessFully.....";
	}
	
	public String updateEmployee(int id,double salary,InputRequest<Employee> request) {
		Employee employee=employeeRepository.findById(id).get();
		if(employee !=null) {
			employee.setSalary(salary);
			employee.setModifiedBy(request.getLoggedInUser());
			employeeRepository.saveAndFlush(employee);
		}else {
			throw new RuntimeException("Employee Not Found with id "+ id);
		}
		return "Employee Updated Successfully";
	}
}
