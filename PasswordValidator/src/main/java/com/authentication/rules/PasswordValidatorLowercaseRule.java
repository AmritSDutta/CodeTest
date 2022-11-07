package com.authentication.rules;

import com.authentication.exceptions.LowercaseValidationException;

/**
 * Rule to explore presence of at least one lowercase in the password passed
 */
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
