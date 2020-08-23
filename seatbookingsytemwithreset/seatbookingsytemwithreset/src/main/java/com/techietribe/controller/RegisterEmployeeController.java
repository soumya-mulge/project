package com.techietribe.controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techietribe.dao.EmployeeDao;
import com.techietribe.dao.impl.EmployeeDaoImplementation;
import com.techietribe.email.EmailHandler;
import com.techietribe.model.Employee;

@RestController
@RequestMapping("/employee")
public class RegisterEmployeeController {
	@Autowired
	private EmployeeDaoImplementation employeeDaoImplementation;

	@GetMapping(value = "/{emailId}")
	public Employee getByemailId(@PathVariable String emailId) {
		// if (employeeDaoImplementation.findByEmailId(emailId) != null) {
		return employeeDaoImplementation.findByEmailId(emailId);

		// } else {
		// return null;
		// }
	}

	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		employeeDaoImplementation.saveorUpdateEmployee(employee);
		return new ResponseEntity("Registered successfully", HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<?> employeeLogin(@RequestBody Employee employee) {
		Employee employee1 = employeeDaoImplementation.findByEmailIdAndPassword(employee.getEmailId(),
				employee.getPassword());
		if (employee1 != null) {
			return new ResponseEntity("Login successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not found in db", HttpStatus.NOT_FOUND);
		}

	}

	// password reset start here
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String processForgotPasswordForm(@RequestParam("email") String userEmail, HttpServletRequest request) {
		Optional<Employee> optional = employeeDaoImplementation.findEmployeeByEmailId(userEmail);

		if (!optional.isPresent()) {
			System.out.println("There is no record exist for the email id");
			return "invalid";
		} else {

			Employee emp = optional.get();
			emp.setResetToken(UUID.randomUUID().toString());
			// Save token to database
			employeeDaoImplementation.saveorUpdateEmployee(emp);
			
			String appUrl = request.getScheme() + "://" + request.getServerName();
			
			String resetUrl = appUrl + ":2222/employee/reset?token=" + emp.getResetToken();
			EmailHandler sender = new EmailHandler();
			sender.mailSender("singhawesome545@gmail.com", emp.getEmailId(), "Awesome834003", "subject",
					"Click the link for reset password", resetUrl);
		}

		return "link sent successfully";

	}

	// Display form to reset password
		@RequestMapping(value = "/reset", method = RequestMethod.GET)
		public String displayResetPasswordPage(@RequestParam("token") String token) {
			Optional<Employee> emp = employeeDaoImplementation.findByResetToken(token);
			if (emp.isPresent()) { // Token found in DB
			} else { // Token not found in DB
				System.out.println("not exist");
			}
			return "password exist";
		}
		
		@RequestMapping(value = "/reset", method = RequestMethod.POST)
		public String setNewPassword(@RequestParam Map<String, String> requestParams) {
			System.err.println("atleast here");
			// Find the user associated with the reset token
			Optional<Employee> user = employeeDaoImplementation.findByResetToken(requestParams.get("token"));
			// This should always be non-null but we check just in case
			String resposne;
			if (user.isPresent()) {

				Employee resetEmp = user.get();

				// Set new password
				resetEmp.setPassword(requestParams.get("password"));

				// Set the reset token to null so it cannot be used again
				resetEmp.setResetToken(null);

				// Save user
				employeeDaoImplementation.saveorUpdateEmployee(resetEmp);
				resposne = "Resetting the password is successfull";

			} else {
				resposne = "Issue in ressting the password";
			}

			return resposne;
		}

	
}
