package com.kelly_ann.employeemgmt.external;

import javax.ejb.Stateless;

import com.kelly_ann.employeemgmt.domain.Employee;
import com.kelly_ann.employeemgmt.exception.ServiceUnavailableException;

@Stateless
public class ExternalPayrollSystem {
	
	public void enrollEmployee(Employee newEmployee) throws ServiceUnavailableException {
		
		// randomly throw exceptions -- sometimes
		double test = Math.random();
		
		if (test < 0.5) {
			throw new ServiceUnavailableException();
		}
		else {
			// do some complex processing
		}
	}

}
