package com.authentication.test;

import com.authentication.rules.*;
import com.authentication.validator.SubsetOfRulesPasswordValidator;
import org.junit.Assert;
import org.junit.Test;

public class SubsetRuleValidationSuite {

    @Test
    public void testPasswordValidatorPositiveCase(){
        SubsetOfRulesPasswordValidator basicPasswordValidator = prepareSubsetOfRulesPasswordValidator();
        boolean response = basicPasswordValidator.validate("Test@test");
        Assert.assertTrue(response);
    }

    @Test
    public void testPasswordValidatorNegativeCase(){
        SubsetOfRulesPasswordValidator basicPasswordValidator = prepareSubsetOfRulesPasswordValidator();
        boolean response = basicPasswordValidator.validate("TEST");
        Assert.assertFalse(response);
    }

    @Test
    public void testPasswordValidatorNegativeCase2(){
        SubsetOfRulesPasswordValidator basicPasswordValidator = prepareSubsetOfRulesPasswordValidator();
        boolean response = basicPasswordValidator.validate("TEST1");
        Assert.assertTrue(response);
    }

    private SubsetOfRulesPasswordValidator prepareSubsetOfRulesPasswordValidator() {
        SubsetOfRulesPasswordValidator threeRulesPasswordValidator = new SubsetOfRulesPasswordValidator(3);
        threeRulesPasswordValidator.addRules(new PasswordValidatorNotNullRule());
        threeRulesPasswordValidator.addRules(new PasswordValidatorNumberRule());
        threeRulesPasswordValidator.addRules(new PasswordValidatorLowercaseRule());
        threeRulesPasswordValidator.addRules(new PasswordValidatorUppercaseRule());
        threeRulesPasswordValidator.addRules(new PasswordValidatorMinimumLengthRule());

        return threeRulesPasswordValidator;
    }

}
