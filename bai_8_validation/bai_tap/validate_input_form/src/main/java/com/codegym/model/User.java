package com.codegym.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class User implements Validator {
    @NotEmpty
    @Size(min=5, max = 45)
    private String firstName;

    @NotEmpty
    @Size(min=5, max = 45)
    private String lastName;

    private String phoneNumber;

    @Min(18)
    private int age;

    private String email;

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
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String number = user.getPhoneNumber();
        String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        if (number.length() > 11 || number.length() <10){
            errors.rejectValue("number","number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number","number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number","number.matches");
        }
        if(!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$")){
            errors.rejectValue("email","email.matches");
        }
    }
}
