package com.kelly_ann.employeemgmt.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.kelly_ann.employeemgmt.annotation.ProductionDAO;
import com.kelly_ann.employeemgmt.dao.EmployeeDAO;
import com.kelly_ann.employeemgmt.domain.Employee;
import com.kelly_ann.employeemgmt.exception.ServiceUnavailableException;
import com.kelly_ann.employeemgmt.external.ExternalPayrollSystem;

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
	
	@Inject
	private ExternalPayrollSystem payrollSystem;
	
	// the @Resource annotation tells the app server (JBoss/WildFly) to inject the current instance of JBoss into the context "ctx" variable.
	// the "ctx" variable allows us to send the app server commands from the Java code.
	@Resource
	private SessionContext ctx;
	
	@Override
	public void registerEmployee(Employee employee) throws ServiceUnavailableException {
		dao.insert(employee);
		payrollSystem.enrollEmployee(employee);
		
// Forces a rollback in this instance only but not always:		
//		try {
//			payrollSystem.enrollEmployee(employee);
//		}
//		catch (ServiceUnavailableException e) {
//			// force a rollback
//			ctx.setRollbackOnly();
//			throw e;
//		}
		
		// this tests rollbacks b/c it simulates some process (e.g. a call to another DAO, the opening of a file, 
		// adding a msg to an MQ, etc.) failing. 
		// Therefore, the entire registerEmployee() call will be rolled back and will NOT be committed to the database.
		// You can confirm this is the case by re-checking the Derby DB's employee table for no new inserts.
		//throw new NullPointerException(); 
	}
	
	@Override
	public List<Employee> getAllEmployees() {
			return dao.findAll();
	}
	
	@Override
	public List<Employee> searchByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}
	
	// this demonstrates a method in an EJB3 that does not need a Java EE transaction attached to it.
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public double dummyInMemoryNoTransactionNeededMethod() {
		return 123.45678;
	}
	
}
