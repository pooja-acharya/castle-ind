package com.castle.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.castle.app.enquiry.EnquiryForm;
import com.castle.app.enquiry.EventsEnquiryForm;
import com.castle.app.enquiry.SendEmail;


@RestController
public class EnquiryController {
	
	@Autowired
	SendEmail emailSender;
	
private static final Logger LOGGER = LoggerFactory.getLogger(EnquiryController.class);
	
	@RequestMapping( value = "/enquiry", method = RequestMethod.POST)
	public String enquiryForm(@RequestBody EnquiryForm enquiry, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("EnquiryController >> enquiryForm :: {}", enquiry.toString());
		return emailSender.sendEnquiryForm(enquiry);
		
	}
	
	@RequestMapping( value = "/enquiry/events", method = RequestMethod.POST)
	public String enquiryEventsForm(@RequestBody EventsEnquiryForm enquiry, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("EnquiryController >> enquiryEventsForm :: {}", enquiry.toString());
		return emailSender.sendEventsEnquiryForm(enquiry);
		
	}
	
}
