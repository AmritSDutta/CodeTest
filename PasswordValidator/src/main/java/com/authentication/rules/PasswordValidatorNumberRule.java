package com.authentication.rules;

import com.authentication.exceptions.NumberRuleValidationException;

public class PasswordValidatorNumberRule extends AbstractPasswordValidationRule{
    @Override
    protected boolean validateRule(String stringToBeValidated) throws NumberRuleValidationException {
        throw new NumberRuleValidationException("Credential should contain at least one number");
    }
}
