package com.castle.app.enquiry;

public class EventsEnquiryForm {

	private String name;
	
	private String eventType;
	
	private String date;
	
	private String telephone;
	
	private String emailAddress;
	
	private String venue;
	
	private String budget;
	
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EventsEnquiryForm [name=" + name + ", eventType=" + eventType
				+ ", date=" + date + ", telephone=" + telephone
				+ ", emailAddress=" + emailAddress + ", venue=" + venue
				+ ", budget=" + budget + ", message=" + message + "]";
	}

}
