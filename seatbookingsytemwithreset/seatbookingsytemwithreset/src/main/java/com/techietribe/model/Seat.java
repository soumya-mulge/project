package com.techietribe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seat_tbl")
public class Seat {
	@Id
	@Column(name="seatID",unique=true,nullable=false)
	private long seatID;
	
	@Column(name="seatNo")
	private int seatNo;

}
