package com.techietribe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techietribe.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
	Admin findByAdminEmailId(String adminEmailId);
	Admin findByAdminEmailIdAndAdminPassword(String adminEmailId,String adminPassword);
	//Admin forgotPassword(String adminEmailId);
}
