package com.practice.rest_crud_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.rest_crud_app.dao.EmployeeDAO;
import com.practice.rest_crud_app.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDAO.save(emp);
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDAO.delete(id);
	}

}
