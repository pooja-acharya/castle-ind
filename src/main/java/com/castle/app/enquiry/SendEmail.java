package com.castle.app.enquiry;

import java.util.ArrayList;
import java.util.Arrays;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SendEmail {

	@Autowired
	JavaMailSender sender;

	public String sendEnquiryForm(EnquiryForm enquiry) {
		MimeMessage message = sender.createMimeMessage();
	      
	    MimeMessageHelper helper = null;
		//SimpleMailMessage message = new SimpleMailMessage();
	    
		try {
			helper =  new MimeMessageHelper(message, true);
			String[] emailList = new String[3];
			emailList[0] = "ajay@castleind.in";
			emailList[1] = "ashok@castleind.in";
			//emailList[2] = "pooji3344@gmail.com";
			
			helper.setTo(emailList);
		    helper.setFrom("info@castleind.in");
		    helper.setSubject("Enquiry Form Request from Castle");
		    String formMsg = "<html><body><span><h4><b>There is a new enquiry!!</b></h4></span><br/>"
		    		+ "<label>Name: </label><span>"+enquiry.getName()+"</span><br/><label>Position: </label><span> "+enquiry.getPosition()+" </span><br/><label>Company Name: </label>"
		    				+ "<span> "+enquiry.getCompanyName()
		    		+"</span><br/><label>Telephone: </label><span> "+enquiry.getTelephone()+"</span><br/><label>Email Address: </label><span> "+enquiry.getEmailAddress()+
		    		"</span><br/><label>Website: </label><span> "+enquiry.getWebsite()
		    		+"</span><br/><label>Contact Mode: </label><span> "+enquiry.getModeOfContact()+"</span><br/><label>Enquiry related to? </label><span> "+enquiry.getEnquiringRelatedTo()
		    		+"</span><br/><label>Message: </label><span> "+enquiry.getMessage()+"</span></body></html>";
		    message.setContent(formMsg, "text/html");
			sender.send(message);
			return "{\"msg\": \"Your request has been submitted. We'll get back to you soon!!\",\"code\":\"200\",\"cssClass\":\"success\"}";
		} catch (Exception e) {
			System.out.println("Exception e "+e);
			return "{\"msg\": \"Your request could not be processed. Please try again later\",\"code\":\"500\",\"cssClass\":\"error\"}";
		}
	}

	public String sendEventsEnquiryForm(EventsEnquiryForm enquiry) {
		MimeMessage message = sender.createMimeMessage();
	      
	    MimeMessageHelper helper = null;
		//SimpleMailMessage message = new SimpleMailMessage();
	    
		try {
			helper =  new MimeMessageHelper(message, true);
			helper.setTo("ajay@castleind.in");
		    helper.setFrom("info@castleind.in");
		    helper.setSubject("Enquiry Form Request from Castle");
		    String formMsg = "<html><body><span><h4><b>There is a new events enquiry!!</b></h4></span><br/>"
		    		+ "<label>Name: </label><span>"+enquiry.getName()+"</span><br/><label>Event Type: </label><span> "+enquiry.getEventType()+" </span><br/><label>Venue: </label>"
		    				+ "<span> "+enquiry.getVenue()
		    		+"</span><br/><label>Telephone: </label><span> "+enquiry.getTelephone()+"</span><br/><label>Email Address: </label><span> "+enquiry.getEmailAddress()+
		    		"</span><br/><label>Budget: </label><span> "+enquiry.getBudget()
		    		+"</span><br/><label>Date (MM/DD/YYYY): </label><span> "+enquiry.getDate()
		    		+"</span><br/><label>Message: </label><span> "+enquiry.getMessage()+"</span></body></html>";

		    message.setContent(formMsg, "text/html");
			sender.send(message);
			return "{\"msg\": \"Your request has been submitted. We'll get back to you soon!!\",\"code\":\"200\",\"cssClass\":\"success\"}";
		} catch (Exception e) {
			
			return "{\"msg\": \"Your request could not be processed. Please try again later\",\"code\":\"500\",\"cssClass\":\"error\"}";
		}
	}
}
