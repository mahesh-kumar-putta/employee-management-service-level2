package com.practice.rest_crud_app.dao;

import java.util.List;

import com.practice.rest_crud_app.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee emp);
		
	void delete(int id);
}
