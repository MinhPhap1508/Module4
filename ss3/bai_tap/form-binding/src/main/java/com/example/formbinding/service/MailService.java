package com.example.formbinding.service;

import com.example.formbinding.model.Mail;
import com.example.formbinding.repository.IMailRepository;
import com.example.formbinding.repository.MailRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IMailService {
    private static IMailRepository mailRepository = new MailRepository();

    @Override
    public void update(Mail mail) {
       mailRepository.update(mail);
    }

    @Override
    public Mail getInfo() {
       return mailRepository.getInfo();
    }
}
