package com.example.formbinding.repository;

import com.example.formbinding.model.Mail;

public interface IMailRepository {
    public void update(Mail mail);
    public Mail getInfo();
}
