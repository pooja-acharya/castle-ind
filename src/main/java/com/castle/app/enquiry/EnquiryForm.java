package com.castle.app.enquiry;

public class EnquiryForm {

	private String name;
	
	private String position;
	
	private String companyName;
	
	private String telephone;
	
	private String emailAddress;
	
	private String website;
	
	private String modeOfContact;
	
	private String enquiringRelatedTo;
	
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getModeOfContact() {
		return modeOfContact;
	}

	public void setModeOfContact(String modeOfContact) {
		this.modeOfContact = modeOfContact;
	}

	public String getEnquiringRelatedTo() {
		return enquiringRelatedTo;
	}

	public void setEnquiringRelatedTo(String enquiringRelatedTo) {
		this.enquiringRelatedTo = enquiringRelatedTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EnquiryForm [name=" + name + ", position=" + position
				+ ", companyName=" + companyName + ", telephone=" + telephone
				+ ", emailAddress=" + emailAddress + ", website=" + website
				+ ", modeOfContact=" + modeOfContact + ", enquiringRelatedTo="
				+ enquiringRelatedTo + ", message=" + message + "]";
	}
	
}
