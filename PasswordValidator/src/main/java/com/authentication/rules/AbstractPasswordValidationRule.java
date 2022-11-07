package com.authentication.rules;

import com.authentication.exceptions.ValidationException;

/**
 * Abstract class for rules.
 */
public abstract class AbstractPasswordValidationRule {

    public final boolean validate(final String stringToBeValidated) throws ValidationException{
        return validateRule(stringToBeValidated);
    }

    protected abstract boolean validateRule(final String stringToBeValidated) throws ValidationException;
}
