/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.configuration;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author Bibek
 */
@Configuration
public class WebConfiguration {
    
    @Bean
    public MailSender getMailSender(){
        JavaMailSenderImpl mailer = new JavaMailSenderImpl();
        mailer.setHost("smtp.gmail.com");
        mailer.setPort(587);
        
        mailer.setUsername("nidan2400@gmail.com");
        mailer.setPassword("nidan123@");
        
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        
        mailer.setJavaMailProperties(properties);
        return mailer;
    }
    
}
