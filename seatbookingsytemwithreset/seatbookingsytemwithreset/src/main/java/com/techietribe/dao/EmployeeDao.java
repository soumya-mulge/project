package com.techietribe.dao;

import java.util.Optional;

import com.techietribe.model.Employee;

public interface EmployeeDao {

	Employee findByEmailId(String emailId);
	void saveorUpdateEmployee(Employee employee);
	Employee findByEmailIdAndPassword(String emailId,String password);
	
	//new method here
	Optional<Employee> findEmployeeByEmailId(String emailId);
	Optional<Employee> findByResetToken(String resetToken);
	 

}
