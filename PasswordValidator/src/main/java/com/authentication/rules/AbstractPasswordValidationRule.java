package com.authentication.rules;

import com.authentication.exceptions.ValidationException;

/**
 * Abstract class for rules.
 */
public abstract class AbstractPasswordValidationRule {

    protected boolean isMandatory =false;
    protected int priority = 1;

    public final boolean validate(final String stringToBeValidated) throws ValidationException{
        return validateRule(stringToBeValidated);
    }

    protected abstract boolean validateRule(final String stringToBeValidated) throws ValidationException;

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
        if(this.isMandatory){
            this.setPriority(10);
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if(priority > 10 || priority < 1){
            throw new RuntimeException("improper priority");
        }
        this.priority = priority;
    }
}
