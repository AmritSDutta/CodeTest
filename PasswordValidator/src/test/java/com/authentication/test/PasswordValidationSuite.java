package com.authentication.test;

import com.authentication.rules.*;
import com.authentication.validator.BasicPasswordValidator;
import org.junit.Assert;
import org.junit.Test;

public class PasswordValidationSuite {


    @Test
    public void testPasswordValidator(){
        BasicPasswordValidator basicPasswordValidator = new BasicPasswordValidator();
        boolean response = basicPasswordValidator.validate("stringtobetested");
        Assert.assertTrue(response);
    }

    @Test
    public void testPasswordValidatorLowercase(){
        BasicPasswordValidator basicPasswordValidator = new BasicPasswordValidator();
        basicPasswordValidator.addRules(new PasswordValidatorLowercaseRule());
        boolean response = basicPasswordValidator.validate("lowercase");
        Assert.assertTrue(response);
    }

    @Test
    public void testPasswordValidatorUppercase(){
        BasicPasswordValidator basicPasswordValidator = new BasicPasswordValidator();
        basicPasswordValidator.addRules(new PasswordValidatorUppercaseRule());
        boolean response = basicPasswordValidator.validate("UPPERCASE");
        Assert.assertTrue(response);
    }

    @Test
    public void testPasswordValidatorMinimumLength(){
        BasicPasswordValidator basicPasswordValidator = new BasicPasswordValidator();
        basicPasswordValidator.addRules(new PasswordValidatorMinimumLengthRule());
        boolean response = basicPasswordValidator.validate("thisismorethaneightchar");
        Assert.assertTrue(response);
    }

    @Test
    public void testPasswordValidatorNotNull(){
        BasicPasswordValidator basicPasswordValidator = new BasicPasswordValidator();
        basicPasswordValidator.addRules(new PasswordValidatorNotNullRule());
        boolean response = basicPasswordValidator.validate("notnull");
        Assert.assertTrue(response);
    }

    @Test
    public void testPasswordValidatorNumberRule(){
        BasicPasswordValidator basicPasswordValidator = new BasicPasswordValidator();
        basicPasswordValidator.addRules(new PasswordValidatorNumberRule());
        boolean response = basicPasswordValidator.validate("12345678");
        Assert.assertTrue(response);
    }
}
