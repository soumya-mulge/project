package com.techietribe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking_tbl")
public class Booking {
	@Id
	@Column(name="bookingID",unique=true,nullable=false)
	private long bookingID;
	
	@Column(name="bookingDate")
	private Date bookingDate;
	Booking(){}
	public Booking(long bookingID, Date bookingDate) {
		super();
		this.bookingID = bookingID;
		this.bookingDate = bookingDate;
	}
	public long getBookingID() {
		return bookingID;
	}
	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
}
