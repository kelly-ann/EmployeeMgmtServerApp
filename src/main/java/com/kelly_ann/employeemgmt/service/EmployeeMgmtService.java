package com.kelly_ann.employeemgmt.service;

import java.util.List;

import javax.ejb.Remote;

import com.kelly_ann.employeemgmt.domain.Employee;

//the @Remote annotation tells the app server (JBoss) that implementations can be invoked by a remote client
@Remote
public interface EmployeeMgmtService {
	
	public void registerEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchByLastName(String lastName);
	
}
