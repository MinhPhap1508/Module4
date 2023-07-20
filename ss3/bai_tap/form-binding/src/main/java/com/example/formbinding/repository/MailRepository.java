package com.example.formbinding.repository;

import com.example.formbinding.model.Mail;

public class MailRepository implements IMailRepository{

    private static Mail mailDetails = new Mail();

    static {
        mailDetails.setLanguages("English");
        mailDetails.setPageSize(25);
        mailDetails.setFilter(true);
        mailDetails.setSignature("King, Asgard");
    }
    @Override
    public void update(Mail mail) {
        mailDetails = mail;
    }

    @Override
    public Mail getInfo() {
        return mailDetails;
    }
}
