package uk.co.nazire.model;

import java.util.Date;

public class ErrorDetails {
	
	private String message;
	private String details;
	private Date timeStamp;
	private Integer status;
	
	public ErrorDetails() {
		super();
	}
	
	public ErrorDetails(String message,String details,Date timeStamp,Integer status) {
		this.message=message;
		this.details=details;
		this.timeStamp=timeStamp;
		this.status=status;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message=message;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details=details;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp=timeStamp;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status=status;
	}
	
	
	
	
	
	
}
