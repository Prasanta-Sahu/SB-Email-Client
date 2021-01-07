package com.codebuffer.sbemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class SbEmailClientApplication {

	@Autowired
	private EmailSenderService service;
	public static void main(String[] args) {
		SpringApplication.run(SbEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail()throws MessagingException, FileNotFoundException
	{
		/*	service.sendSimpleEmail("prsntsahu99@gmail.com",
									"Hi, Prasanta....",
									"Re:Forwaded Resume of PKSAHU...."
		); */

		service.sendEmailWithAttachment("prsntsahu99@gmail.com",
				"Please Find the Attachment Herewith.....",
		 		"Re:Find Attached Documents Along With the mail...",
				"C:\\Users\\USER\\Documents\\RESUME.docx"
				);

	}
}
