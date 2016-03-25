package com.kelly_ann.employeemgmt.domain;

import java.io.Serializable;

// serializable means the class can be transmitted across the network.
@SuppressWarnings("serial")
public class Employee implements Serializable {
	
	private String firstName;
	private String lastName;
	private String jobRole;
	private int salary;
	
	// constructor
	public Employee(String firstName, String lastName, String jobRole, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobRole = jobRole;
		this.salary = salary;
	}
	
	// instance methods
	@Override
	public String toString() {
		return "Employee: " + this.firstName + " " + this.lastName + " makes " 
				+ this.salary + " as a " + this.jobRole + ".";
	}
	
	// getters and setters
	public String getFirstName() {
		
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}

	
	public String getLastName() {
		
		return lastName;
	}

	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}

	
	public String getJobRole() {
		
		return jobRole;
	}

	
	public void setJobRole(String jobRole) {
		
		this.jobRole = jobRole;
	}

	
	public int getSalary() {
		
		return salary;
	}

	
	public void setSalary(int salary) {
		
		this.salary = salary;
	}
	
	
	
	
}
