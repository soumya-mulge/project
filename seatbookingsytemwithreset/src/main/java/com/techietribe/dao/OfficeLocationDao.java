package com.techietribe.dao;
import com.techietribe.model.OfficeLocation;

public interface OfficeLocationDao {
	OfficeLocation  findByLocationNameAndBranchNameAndFloorNo(String locationName,String branchName,int floorNo);
	}

