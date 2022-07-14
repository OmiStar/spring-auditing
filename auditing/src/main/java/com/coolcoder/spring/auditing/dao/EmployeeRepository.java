package com.coolcoder.spring.auditing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coolcoder.spring.auditing.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
