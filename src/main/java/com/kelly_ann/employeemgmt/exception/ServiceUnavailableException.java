package com.kelly_ann.employeemgmt.exception;

import javax.ejb.ApplicationException;

// the @ApplicationException annotation says to always force a rollback whenever this exception is thrown.
// this is much simpler to do than the forcing a rollback individually method using try/catch blocks as 
// is done in EmployeeMgmtImpl.java in the registerEmployee() method.
// This is however not as customizable as the individualized method b/c there may be times when we want to use
// multiple catch statements before rolling back, etc.

@SuppressWarnings("serial")
@ApplicationException(rollback=true)
public class ServiceUnavailableException extends Exception {
	
}
