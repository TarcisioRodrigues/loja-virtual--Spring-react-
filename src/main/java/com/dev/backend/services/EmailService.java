package com.dev.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String remetente;
public String sendEmailText(String title,String mensagem){
    try{

    SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
    simpleMailMessage.setFrom(remetente);
    simpleMailMessage.setSubject(title);
    simpleMailMessage.setText(mensagem);
    javaMailSender.send(simpleMailMessage);
    return "email enviado!";
    }catch (Exception e){
        return "Erro ao enviar o email";
    }

}

}
