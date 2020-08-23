package com.techietribe.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techietribe.dao.AdminDao;
import com.techietribe.model.Admin;
import com.techietribe.repository.AdminRepository;
@Service
public class AdminDaoImplementaion implements AdminDao
{
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin findByEmailId(String emailId) {
		return adminRepository.findByEmailId(emailId);
	}

	@Override
	public void saveorUpdateAdmin(Admin admin) {
		adminRepository.save(admin);
	}

	@Override
	public Admin findByEmailIdAndPassword(String emailId,String password) {
		return adminRepository.findByEmailIdAndPassword(emailId, password);
	}

}
	