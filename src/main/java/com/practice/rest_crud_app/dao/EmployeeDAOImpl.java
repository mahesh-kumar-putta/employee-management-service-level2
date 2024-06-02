package com.practice.rest_crud_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.rest_crud_app.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
		
		return query.getResultList();
	}

	@Override
	public Employee findById(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}
	
	@Override
	public Employee save(Employee emp) {
		Employee employee = entityManager.merge(emp);
		return employee;
	}

	@Override
	public void delete(int id) {
		Employee emp = findById(id);
		entityManager.remove(emp);
	}


}
