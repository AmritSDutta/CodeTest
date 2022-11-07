package com.authentication.rules;

import com.authentication.exceptions.NumberRuleValidationException;

public class PasswordValidatorNumberRule extends AbstractPasswordValidationRule{
    @Override
    protected boolean validateRule(String stringToBeValidated) throws NumberRuleValidationException {
        if(stringToBeValidated.matches(".*[1-9].*")) {
            return true;
        } else {
            throw new NumberRuleValidationException("Credential should contain at least one number");
        }
    }
}
