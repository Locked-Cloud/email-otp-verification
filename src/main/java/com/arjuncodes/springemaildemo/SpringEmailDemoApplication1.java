package com.arjuncodes.springemaildemo;
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
class SpringEmailDemoApplication {
    @Service
    static class EmailService {
        private final JavaMailSender mailSender;

        @Autowired
        public EmailService(JavaMailSender mailSender) {
            this.mailSender = mailSender;
        }

        public void sendSimpleEmail(String toEmail, String subject, String body) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
            System.out.println("Mail Sent to " + toEmail);
        }
    }

    private final EmailService emailService;
    private final Scanner scanner;

    @Autowired
    public SpringEmailDemoApplication(EmailService emailService) {
        this.emailService = emailService;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailDemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendOtpOnAppReady() {
        String toEmail = promptForEmail();
        String otp = generateOtp();
        sendOtpByEmail(toEmail, otp);
        verifyOtp(otp);
    }

    private String promptForEmail() {
        System.out.print("Enter your email: ");
        return scanner.nextLine();
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    private void verifyOtp(String sentOtp) {
        int maxAttempts = 3;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter the OTP sent to your email: ");
            String enteredOtp = scanner.nextLine();
            if (sentOtp.equals(enteredOtp)) {
                System.out.println("OTP Verified successfully.");
                return;
            } else {
                System.out.println("Incorrect OTP. Please try again.");
            }
        }
        System.out.println("Maximum attempts reached. Please contact support.");
    }

    private void sendOtpByEmail(String toEmail, String otp) {
        String subject = "OTP for Transaction";
        String body = "Your OTP for the transaction is: " + otp;
        emailService.sendSimpleEmail(toEmail, subject, body);
    }
}

