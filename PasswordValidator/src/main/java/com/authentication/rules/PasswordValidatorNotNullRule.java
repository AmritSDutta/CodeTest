package com.authentication.rules;

import com.authentication.exceptions.NotNullValidationException;

public class PasswordValidatorNotNullRule extends AbstractPasswordValidationRule{
    @Override
    protected boolean validateRule(String stringToBeValidated) throws NotNullValidationException {
        throw new NotNullValidationException("Credential should not be null.");
    }
}
