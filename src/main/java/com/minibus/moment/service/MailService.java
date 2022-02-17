package com.minibus.moment.service;

import com.minibus.moment.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendMail(User user) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("[미니버스] " + user.getNickname() + "닝믜 비밀번호 찾기 메일입니다.");
        simpleMailMessage.setText("임시비밀번호 : " + user.getPassword());

        javaMailSender.send(simpleMailMessage);
    }
}
