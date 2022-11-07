package com.authentication.rules;

import com.authentication.exceptions.UppercaseValidationException;


/**
 * Rule to explore presence of at least one uppercase in the password passed
 */
public class PasswordValidatorUppercaseRule extends AbstractPasswordValidationRule{

    @Override
    protected boolean validateRule(String stringToBeValidated) throws UppercaseValidationException {
        if(stringToBeValidated.matches(".*[A-Z].*")) {
            return true;
        } else {
            throw new UppercaseValidationException("Credential should contain at least one uppercase char");
        }

    }
}
