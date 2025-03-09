package com.dev.backend.services;


import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration fmConfiguration;
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
public void enviar (String destinatario,String titulo,Map<String,Object>propriedades){
    MimeMailMessage mimeMailMessage=javaMailSender.createMimeMessage();

    try{
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMailMessage,true);
        mimeMessageHelper.setSubject(titulo);
        mimeMessageHelper.setFrom("tarcisiorodrigues454@gmail.com");
        mimeMessageHelper.setTo(destinatario);
        mimeMessageHelper.setText(getContentFromTemplate(propriedades),true);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}


public  String getContentFromTemplate(Map<String,Object>model){
    StringBuffer content=new StringBuffer();
    try {
        content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate("email-temaplate"),))
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}
