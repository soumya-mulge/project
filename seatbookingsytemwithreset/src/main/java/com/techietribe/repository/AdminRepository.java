package com.techietribe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techietribe.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	Admin findByEmailId(String  emailId);
	Admin findByEmailIdAndPassword(String emailId, String password);
}
