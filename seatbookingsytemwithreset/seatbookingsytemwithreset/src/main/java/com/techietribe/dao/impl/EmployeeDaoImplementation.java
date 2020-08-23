package com.techietribe.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techietribe.dao.EmployeeDao;
import com.techietribe.model.Employee;
import com.techietribe.repository.EmployeeRepository;

@Service
public class EmployeeDaoImplementation implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findByEmailId(String emailId) {
		return employeeRepository.findByEmailId(emailId);
	}

	@Override
	public void saveorUpdateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee findByEmailIdAndPassword(String emailId, String password) {
		return employeeRepository.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public Optional<Employee> findByResetToken(String resetToken) {
		return employeeRepository.findByResetToken(resetToken);
	}

	@Override
	public Optional<Employee> findEmployeeByEmailId(String emailId) {

		return employeeRepository.findEmployeeByEmailId(emailId);
	}

}
