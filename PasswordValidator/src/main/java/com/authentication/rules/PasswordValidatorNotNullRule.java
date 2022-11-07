package com.authentication.rules;

import com.authentication.exceptions.NotNullValidationException;


/**
 * Rule to explore nullability of the password, if it it is so, then fail it
 */
public class PasswordValidatorNotNullRule extends AbstractPasswordValidationRule{

    public PasswordValidatorNotNullRule() {
        this.priority = 9 ;
    }

    @Override
    protected boolean validateRule(String stringToBeValidated) throws NotNullValidationException {
        if(stringToBeValidated != null ) {
            return true;
        } else {
            throw new NotNullValidationException("Credential should not be null.");
        }
    }
}
