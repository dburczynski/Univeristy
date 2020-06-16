package com.example.zad7_2.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Controller
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;
    @GetMapping("/send_mail")
    public String sendMessage()throws Exception {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail,true);
            helper.setTo("dburczynski97@gmail.com");
            helper.setReplyTo("dburczynski97@gmail.com");
            helper.setFrom("dburczynski97@gmail.com");
            helper.setSubject("someting");
            helper.setText("something",true);

        }
        catch (MessagingException e){
            e.printStackTrace();
        }
        javaMailSender.send(mail);

        return "redirect:/";
    }
}
