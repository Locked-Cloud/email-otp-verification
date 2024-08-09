/*package com.arjuncodes.springemaildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class SpringEmailDemoApplication {
    static class OTPGenerator {
        public static String generateOTP() {
            // Generate a 6-digit OTP
            Random random = new Random();
            int otp = 100000 + random.nextInt(900000);
            return String.valueOf(otp);
        }
    }
    @Service
     class EmailSenderService {
        public JavaMailSender getMailSender() {
            return mailSender;
        }

        public void setMailSender(JavaMailSender mailSender) {
            this.mailSender = mailSender;
        }

        public String getTomail() {
            return tomail;
        }

        public void setTomail(String tomail) {
            this.tomail = tomail;
        }


        @Autowired
        public JavaMailSender mailSender;
        String tomail ;

        public void sendSimpleEmail(String toEmail, String subject, String body) {
            SimpleMailMessage message = new SimpleMailMessage();


            message.setFrom(tomail);
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);
            System.out.println("Mail Send...");


        }

    }
    private void getEmailAddress() {
        System.out.print("Enter your email: ");

        Scanner scanner = new Scanner(System.in);
        toEmail = scanner.nextLine();
    }

    private String toEmail;

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailDemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerOTP() {
        getEmailAddress();
        String otp = OTPGenerator.generateOTP();
        sendOTPByEmail(otp);

        // Allow user to enter OTP for verification
        verifyOTP(otp);
    }

    private void verifyOTP(String otpSent) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP sent to your email: ");
        String otpEntered = scanner.nextLine();

        if (otpSent.equals(otpEntered)) {
            System.out.println("OTP Verified successfully.");
        } else {
            System.out.println("Incorrect OTP. Please try again.");
            verifyOTP(otpSent); // Recursive call if OTP is incorrect
        }
    }

    private void sendOTPByEmail(String otp) {
        String subject = "OTP for Transaction";
        String body = "Your OTP for the transaction is: " + otp;
        senderService.sendSimpleEmail(toEmail, subject, body);
        System.out.println("OTP Sent to " + toEmail);
    }


}*/
