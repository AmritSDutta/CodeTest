package com.authentication.rules;

import com.authentication.exceptions.MinimumLengthValidationException;

/**
 * Rule to explore minimum length of  the password passed is 9
 */
public class PasswordValidatorMinimumLengthRule extends AbstractPasswordValidationRule{
    @Override
    protected boolean validateRule(String stringToBeValidated) throws MinimumLengthValidationException {
        if(stringToBeValidated != null &&  stringToBeValidated.trim().length() > 8) {
            return true;
        } else {
            throw new MinimumLengthValidationException("Minimum length of credential should be 8 chars.");
        }
    }
}
