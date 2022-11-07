package com.authentication.test;

import com.authentication.rules.*;
import com.authentication.validator.BasicPasswordValidator;
import org.junit.Assert;
import org.junit.Test;

public class BasicUseCaseValidationSuite {

    @Test
    public void testPasswordValidatorPositiveCase(){
        BasicPasswordValidator basicPasswordValidator = prepareBasicPasswordValidator();
        boolean response = basicPasswordValidator.validate("Test@4680");
        Assert.assertTrue(response);
    }


    @Test
    public void testPasswordValidatorNoUppercase(){
        BasicPasswordValidator basicPasswordValidator = prepareBasicPasswordValidator();
        boolean response = basicPasswordValidator.validate("test@4680");
        Assert.assertFalse(response);
    }

    @Test
    public void testPasswordValidatorNoLowerCase(){
        BasicPasswordValidator basicPasswordValidator = prepareBasicPasswordValidator();
        boolean response = basicPasswordValidator.validate("TEST@4680");
        Assert.assertFalse(response);
    }

    @Test
    public void testPasswordValidatorNoNumber(){
        BasicPasswordValidator basicPasswordValidator = prepareBasicPasswordValidator();
        boolean response = basicPasswordValidator.validate("Test@test");
        Assert.assertFalse(response);
    }

    @Test
    public void testPasswordValidatorNull(){
        BasicPasswordValidator basicPasswordValidator = prepareBasicPasswordValidator();
        boolean response = basicPasswordValidator.validate(null);
        Assert.assertFalse(response);
    }

    @Test
    public void testPasswordValidatorLessThanMinimumLength(){
        BasicPasswordValidator basicPasswordValidator = prepareBasicPasswordValidator();
        boolean response = basicPasswordValidator.validate("Test4680");
        Assert.assertFalse(response);
    }





    private BasicPasswordValidator prepareBasicPasswordValidator(){
        BasicPasswordValidator basicPasswordValidator = new BasicPasswordValidator();
        basicPasswordValidator.addRules(new PasswordValidatorNotNullRule());
        basicPasswordValidator.addRules(new PasswordValidatorNumberRule());
        basicPasswordValidator.addRules(new PasswordValidatorLowercaseRule());
        basicPasswordValidator.addRules(new PasswordValidatorUppercaseRule());
        basicPasswordValidator.addRules(new PasswordValidatorMinimumLengthRule());
         return basicPasswordValidator;
    }
}
