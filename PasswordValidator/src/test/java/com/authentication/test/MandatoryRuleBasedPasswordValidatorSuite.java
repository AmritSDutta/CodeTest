package com.authentication.test;

import com.authentication.rules.*;
import com.authentication.validator.MandatoryRuleBasedPasswordValidator;
import org.junit.Assert;
import org.junit.Test;

public class MandatoryRuleBasedPasswordValidatorSuite {
    @Test
    public void testPasswordValidatorPositiveCase(){
        MandatoryRuleBasedPasswordValidator mandatoryRuleBasedPasswordValidator = prepareSubsetOfRulesPasswordValidator();
        boolean response = mandatoryRuleBasedPasswordValidator.validate("TEST@5abc");
        Assert.assertTrue(response);
    }

    @Test
    public void testPasswordValidatorNegativeCase(){
        MandatoryRuleBasedPasswordValidator mandatoryRuleBasedPasswordValidator = prepareSubsetOfRulesPasswordValidator();
        boolean response = mandatoryRuleBasedPasswordValidator.validate("TEST@12345");
        Assert.assertFalse(response);
    }


    private MandatoryRuleBasedPasswordValidator prepareSubsetOfRulesPasswordValidator() {
        MandatoryRuleBasedPasswordValidator threeRulesPasswordValidator = new MandatoryRuleBasedPasswordValidator(3);
        threeRulesPasswordValidator.addRules(new PasswordValidatorNotNullRule());
        threeRulesPasswordValidator.addRules(new PasswordValidatorNumberRule());
        AbstractPasswordValidationRule rule  = new PasswordValidatorLowercaseRule();
        rule.setMandatory(true);
        threeRulesPasswordValidator.addRules(rule);

        threeRulesPasswordValidator.addRules(new PasswordValidatorUppercaseRule());
        threeRulesPasswordValidator.addRules(new PasswordValidatorMinimumLengthRule());

        return threeRulesPasswordValidator;
    }

}
