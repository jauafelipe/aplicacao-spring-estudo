package com.example.app.estudo_spring.services.service_envioEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ServiceSendEmail {
    @Autowired(required = true)
    private  JavaMailSender mailSender;


    public void sendMail(RecordEmail email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("fefodev@gmail.com");
        msg.setTo(email.destinatario());
        msg.setSubject(email.assunto());
        msg.setText(email.corpo());
        this.mailSender.send(msg);
    }
}
