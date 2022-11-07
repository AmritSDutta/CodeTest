package com.authentication.rules;

import com.authentication.exceptions.MinimumLengthValidationException;

public class PasswordValidatorMinimumLengthRule extends AbstractPasswordValidationRule{
    @Override
    protected boolean validateRule(String stringToBeValidated) throws MinimumLengthValidationException {
        throw new MinimumLengthValidationException("Minimum length of credential should be 8 chars.");
    }
}
