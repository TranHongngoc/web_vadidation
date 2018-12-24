package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Email implements Validator {

    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Email.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Email email = (Email) target;
        String e = email.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");

        if (!e.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number","number.matches");
        }



    }
}
