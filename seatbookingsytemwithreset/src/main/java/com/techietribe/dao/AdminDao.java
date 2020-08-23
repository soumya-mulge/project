package com.techietribe.dao;

import com.techietribe.model.Admin;

public interface AdminDao {

	Admin findByEmailId(String emailId);
	void saveorUpdateAdmin(Admin admin);
	Admin findByEmailIdAndPassword(String emailId,String password);
}
