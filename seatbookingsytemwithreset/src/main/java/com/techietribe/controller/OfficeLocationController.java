package com.techietribe.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techietribe.dao.impl.OfficeLocationDaoImplementation;
import com.techietribe.model.OfficeLocation;

@RestController
@RequestMapping("/emplyee/searching")
public class OfficeLocationController {
	
	@Autowired
	private OfficeLocationDaoImplementation officeLocationDaoImplementation; 
	
	@GetMapping(value="/{locationName}/{branchName}/{floorNo}")

    public OfficeLocation getByfloorNo(@PathVariable String locationName,@PathVariable String branchName,@PathVariable int floorNo) {

        return officeLocationDaoImplementation.findByLocationNameAndBranchNameAndFloorNo(locationName, branchName, floorNo);

    }
	}
