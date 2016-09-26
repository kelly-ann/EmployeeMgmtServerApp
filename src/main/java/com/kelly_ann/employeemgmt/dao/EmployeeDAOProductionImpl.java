package com.kelly_ann.employeemgmt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.kelly_ann.employeemgmt.annotation.ProductionDAO;
import com.kelly_ann.employeemgmt.domain.Employee;

//the @Default annotation tells JBoss that this is the default EmployeeDAO interface implementation.
@Stateless
@Default
@ProductionDAO
public class EmployeeDAOProductionImpl implements EmployeeDAO {
	
	// @PeristenceContext tells WildFly/JBoss that once this EJB has been deployed, JBoss MUST 
	// create a NEW entity mgr every time a method in this class is called. 
	// This is important b/c an em should only represent 1 transaction/unit of work.  
	// Therefore, at the end of EACH method, the app server (WildFly/JBoss) will make sure that 
	// the entity manager is closed and discarded.  Also, transactions will be automatically managed.
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insert(Employee newEmployee) {
		em.persist(newEmployee);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		
		Query q = em.createQuery("select employee from Employee employee");
		List<Employee> employees = q.getResultList();
		return employees;
		/*
		Employee e1 = new Employee("Hillary", "Clinton", "Politician", 500);
		Employee e2 = new Employee("Donald", "Trump", "Businessman", 150);
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		return employees;
		*/
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByLastName(String lastName) {
		Query q = em.createQuery("select employee from Employee employee where employee.lastName = :lastName");
		q.setParameter("lastName", lastName);
		return q.getResultList();
	}
	
}
