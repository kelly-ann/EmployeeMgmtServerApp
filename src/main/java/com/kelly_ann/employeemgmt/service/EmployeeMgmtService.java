package com.kelly_ann.employeemgmt.service;

import java.util.List;

import javax.ejb.Remote;

import com.kelly_ann.employeemgmt.domain.Employee;
import com.kelly_ann.employeemgmt.exception.ServiceUnavailableException;

//the @Remote annotation tells the app server (JBoss) that this implementation can be invoked on the server by
//a remote client
@Remote
public interface EmployeeMgmtService {
	
	public void registerEmployee(Employee employee) throws ServiceUnavailableException;
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchByLastName(String lastName);

	double dummyInMemoryNoTransactionNeededMethod();
	
}
