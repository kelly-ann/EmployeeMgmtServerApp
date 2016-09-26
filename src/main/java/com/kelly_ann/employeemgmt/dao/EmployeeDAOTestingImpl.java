package com.kelly_ann.employeemgmt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.kelly_ann.employeemgmt.annotation.TestingDAO;
import com.kelly_ann.employeemgmt.domain.Employee;

// the @Alternative annotation tells JBoss that this is not the default EmployeeDAO interface implementation.
//@Stateless //- this class doesn't need to be and EJB so this is optional.
@Alternative
@TestingDAO
public class EmployeeDAOTestingImpl implements EmployeeDAO {
	
	@Override
	public void insert(Employee newEmployee) {
		// no-op
	}
	
	@Override
	public List<Employee> findAll() {
		Employee e1 = new Employee("Carly", "Fiorina", "Businesswoman", 500);
		Employee e2 = new Employee("Ted", "Cruz", "Governor", 150);
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		return employees;
	}
	
	@Override
	public List<Employee> findByLastName(String lastName) {
		return null;
	}
	
}
