package com.techietribe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="off_loc_tbl")
public class OfficeLocation {
	@Id
	@Column(name="locationID",unique=true,nullable=false)
	private long locationID;

	@Column(name="locationName")
	private String loactionName;

	@Column(name="branchName")
	private String branchName;

	@Column(name="floorNo")
	private int floorNo;
	OfficeLocation(){}
	public OfficeLocation(long locationID, String loactionName, String branchName, int floorNo) {
		super();
		this.locationID = locationID;
		this.loactionName = loactionName;
		this.branchName = branchName;
		this.floorNo = floorNo;
	}
	public long getLocationID() {
		return locationID;
	}
	public void setLocationID(long locationID) {
		this.locationID = locationID;
	}
	public String getLoactionName() {
		return loactionName;
	}
	public void setLoactionName(String loactionName) {
		this.loactionName = loactionName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
}
