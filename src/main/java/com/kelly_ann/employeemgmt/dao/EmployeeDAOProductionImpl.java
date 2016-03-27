package com.kelly_ann.employeemgmt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.kelly_ann.employeemgmt.annotation.ProductionDAO;
import com.kelly_ann.employeemgmt.domain.Employee;

//the @Default annotation tells JBoss that this is the default EmployeeDAO interface implementation.
@Stateless
@Default
@ProductionDAO
public class EmployeeDAOProductionImpl implements EmployeeDAO {
	
	@Override
	public void insert(Employee newEmployee) {
		// no-op
	}
	
	@Override
	public List<Employee> findAll() {
		Employee e1 = new Employee("Donald", "Trump", "Businessman", 1700);
		Employee e2 = new Employee("Hillary", "Clinton", "Secretary of State", 2100);
		Employee e3 = new Employee("Bernie", "Sanders", "Politician", 900);
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		return employees;
	}
	
	@Override
	public List<Employee> findByLastName(String lastName) {
		return null;
	}
	
}
