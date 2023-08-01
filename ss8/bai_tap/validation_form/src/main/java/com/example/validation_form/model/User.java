package com.example.validation_form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @NotEmpty
//    @Size(min = 5, max = 45)
    private String firstName;
//    @NotEmpty
//    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^[0-9]{10}$", message = "Wrong number phone format")
    private String phoneNumber;
    @Min(18)
    private int age;
    @NotEmpty
    @Email
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(user.getFirstName().equals("")){
            errors.rejectValue("firstName",null,"Name Cannot Empty");
        } else if (!user.getFirstName().matches("^[a-zA-Z ]{5,45}$")) {
            errors.rejectValue("firstName", null,"Wrong Name Format");
        }
        if(user.getLastName().equals("")){
            errors.rejectValue("lastName",null,"Name Cannot Empty");
        } else if (!user.getLastName().matches("^[a-zA-Z ]{5,45}$")) {
            errors.rejectValue("lastName", null,"Wrong Name Format");
        }
    }
}
