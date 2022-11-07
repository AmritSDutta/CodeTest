package com.authentication.validator;

import com.authentication.exceptions.ValidationException;
import com.authentication.rules.AbstractPasswordValidationRule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Basic Class for wrapping specific password validation methodology.
 * It should be extended in case complex password validation required.
 */
public class BasicPasswordValidator {
    protected final List<AbstractPasswordValidationRule> rulesToBeValidated = new ArrayList<>();

    public boolean validate(final String stringToBeValidated){

        boolean response = true;
        for(AbstractPasswordValidationRule rules: rulesToBeValidated){
            try {
                rules.validate(stringToBeValidated);
            } catch (ValidationException validationException) {
                System.out.printf("Validation failed: " +validationException.getMessage());
                response = false;
                break;
            }
        }
        return response;
    }

    public void addRules(AbstractPasswordValidationRule rules){
        rulesToBeValidated.add(rules);
    }
}


