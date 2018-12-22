package com.jeffborda.twiliotest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioTestApplication {

	public static final String ACCOUNT_SID = "ACccbd38382a9a7f1e91bc50397b8e17d7";
	public static final String AUTH_TOKEN = "46df4f8a4c82e06da60971cf5232f6d8";

	public static void main(String[] args) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		/* First number is the TO number, must be a verified number in Twilio
		 * Second number is our Twilio number that CANNOT be changed
		 */
		Message message = Message.creator(new PhoneNumber("+12069313616"),
				/*  This is our Twilio number, DO NOT CHANGE: */new PhoneNumber("+12062028535"),
				"The hot water tank just exploded, you need to come home NOW!!").create();

		System.out.println(message.getSid());

		//SpringApplication.run(TwilioTestApplication.class, args);
	}

}

