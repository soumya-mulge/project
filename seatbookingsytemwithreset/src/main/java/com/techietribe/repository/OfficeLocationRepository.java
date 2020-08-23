package com.techietribe.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techietribe.model.OfficeLocation;
public interface OfficeLocationRepository  extends JpaRepository<OfficeLocation,Integer>{
	
	OfficeLocation  findByLocationNameAndBranchNameAndFloorNo(String locationName,String branchName,int floorNo);
}
