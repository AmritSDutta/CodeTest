package com.authentication.test;

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
}
