package com.techietribe.dao;

import com.techietribe.model.Admin;

public interface AdminDao {

	Admin findByEmailId(String adminEmailId);
	void saveorUpdateAdmin(Admin admin);
	Admin findByEmailIdAndPassword(String adminEmailId, String adminPassword);
//	Admin forgotPassword(String adminEmailId);
}
