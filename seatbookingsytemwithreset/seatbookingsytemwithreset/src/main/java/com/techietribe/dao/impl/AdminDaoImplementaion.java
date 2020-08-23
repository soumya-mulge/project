package com.techietribe.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techietribe.dao.AdminDao;
import com.techietribe.model.Admin;
import com.techietribe.repository.AdminRepository;
@Service
public class AdminDaoImplementaion implements AdminDao{
	@Autowired
	private AdminRepository AdminRepository;

	@Override
	public Admin findByEmailId(String adminEmailId) {
		return AdminRepository.findByAdminEmailId(adminEmailId);
	}

	@Override
	public void saveorUpdateAdmin(Admin admin) {
		AdminRepository.save(admin);
	}

	@Override
	public Admin findByEmailIdAndPassword(String adminEmailId, String adminPassword) {
		return AdminRepository.findByAdminEmailIdAndAdminPassword(adminEmailId, adminPassword);
	}

	//@Override
	/*public Admin forgotPassword(String adminEmailId) {
		return AdminRepository.forgotPassword(adminEmailId);
		
	}*/
}
