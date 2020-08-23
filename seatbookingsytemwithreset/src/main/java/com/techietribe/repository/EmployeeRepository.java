package com.techietribe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.techietribe.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmailId(String emailId);

	Employee findByEmailIdAndPassword(String emailId, String password);

	// new methods here
	Optional<Employee> findEmployeeByEmailId(String emailId);

	Optional<Employee> findByResetToken(String resetToken);
	//Employee updateEmployee(String emailId,Employee employee);
}
