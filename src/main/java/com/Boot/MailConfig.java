package com.Boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Configure the mail sender properties here
        mailSender.setHost("your_host");
        mailSender.setPort(587);
        mailSender.setUsername("your_username");
        mailSender.setPassword("your_password");
        return mailSender;
    }
}