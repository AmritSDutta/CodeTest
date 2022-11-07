package com.authentication.rules;

import com.authentication.exceptions.LowercaseValidationException;

public class PasswordValidatorLowercaseRule extends AbstractPasswordValidationRule{
    @Override
    protected boolean validateRule(String stringToBeValidated) throws LowercaseValidationException {
        if(stringToBeValidated.matches(".*[a-z].*")) {
            return true;
        } else {
            throw new LowercaseValidationException("Credential should contain at least one lowercase char");
        }
    }
}
