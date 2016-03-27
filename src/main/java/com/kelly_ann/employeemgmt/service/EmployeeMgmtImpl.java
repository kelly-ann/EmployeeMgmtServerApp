package com.kelly_ann.employeemgmt.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.kelly_ann.employeemgmt.annotation.ProductionDAO;
import com.kelly_ann.employeemgmt.annotation.TestingDAO;
import com.kelly_ann.employeemgmt.dao.EmployeeDAO;
import com.kelly_ann.employeemgmt.domain.Employee;

//the @Stateless annotation tells the app server (JBoss) that 
//this is an EJB that can be RE-USED by other clients hence new EJBs do not have 
//to be instantiated each time the client app calls the app server (i.e. most instantiated).
@Stateless
public class EmployeeMgmtImpl implements EmployeeMgmtService {
	
	// the @Inject annotation marks this EJB so that WildFly/JBoss app server knows that
	// the value of this object is another EJB that we have already deployed.
	// the @TestingDAO annotation is a QUALIFIER.  it tells Java that we want to 
	// inject the EmployeeMgmtTestingImpl vs. the EmployeeMgmtProductionImpl (default) class/obj in this instance.
	// note: the qualifier-annotation MUST come after the @Inject annotation b/c it is telling WHICH class we want to inject.
	@Inject
	@ProductionDAO	// this annotation can be changed to either @TestingDAO or @ProductionDAO to run that EJB instead.
	private EmployeeDAO dao;	//CDI (context & dependency injection)
	
	@Override
	public void registerEmployee(Employee employee) {
		dao.insert(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
			return dao.findAll();
	}
	
	@Override
	public List<Employee> searchByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}
	
}
