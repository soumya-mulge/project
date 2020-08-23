package com.techietribe.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techietribe.dao.OfficeLocationDao;
import com.techietribe.model.OfficeLocation;
import com.techietribe.repository.OfficeLocationRepository;
@Service
public class OfficeLocationDaoImplementation implements OfficeLocationDao{
	
	@Autowired
	private OfficeLocationRepository officeLocationRepository;
	
	@Override
	public OfficeLocation findByLocationNameAndBranchNameAndFloorNo(String locationName,String branchName, int floorNo) {
		
		return officeLocationRepository.findByLocationNameAndBranchNameAndFloorNo(locationName, branchName, floorNo);
	}
}