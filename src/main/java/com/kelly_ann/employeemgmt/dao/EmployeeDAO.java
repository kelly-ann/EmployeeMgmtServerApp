package com.kelly_ann.employeemgmt.dao;

import java.util.List;

import javax.ejb.Local;

import com.kelly_ann.employeemgmt.domain.Employee;

// the @Local annotation tells JBoss that this is an EJB that does not need networking
// b/c it is located on the same machine as the other EJBs/code that calls it.
@Local
public interface EmployeeDAO {
	
	public void insert (Employee newEmployee);
	
	public List<Employee> findAll();
	
	public List<Employee> findByLastName(String lastName);

}
