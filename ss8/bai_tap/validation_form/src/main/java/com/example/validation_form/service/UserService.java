package com.example.validation_form.service;

import com.example.validation_form.model.User;
import com.example.validation_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
