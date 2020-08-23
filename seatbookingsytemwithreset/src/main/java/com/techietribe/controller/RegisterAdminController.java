package com.techietribe.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techietribe.dao.impl.AdminDaoImplementaion;
import com.techietribe.model.Admin;
@RestController
@RequestMapping("/admin")
public class RegisterAdminController {
	@Autowired
	private AdminDaoImplementaion adminDaoImplementation;
	@GetMapping(value="/{adminEmailId}")
	public Admin getByadminEmailId(@PathVariable String adminEmailId ) {
		return adminDaoImplementation.findByEmailId(adminEmailId);
	}

	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Admin admin){
		adminDaoImplementation.saveorUpdateAdmin(admin);
		return new ResponseEntity("Registered successfully", HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@RequestBody Admin admin){  
		Admin admin1=adminDaoImplementation.findByEmailIdAndPassword(admin.getEmailId(),admin.getPassword());
		if (admin1 !=null) {
			return new ResponseEntity("Login successfully",HttpStatus.OK);}
		else {
			return new ResponseEntity<String>("Not found in db", HttpStatus.NOT_FOUND);
		}
	}

}
