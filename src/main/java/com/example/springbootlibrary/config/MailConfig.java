package com.example.springbootlibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Configure the mail sender properties
        mailSender.setHost("mail.server.com");
        mailSender.setPort(587);
        mailSender.setUsername("username");
        mailSender.setPassword("password");
        return mailSender;
    }

}
