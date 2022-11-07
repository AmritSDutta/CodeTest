package com.authentication.validator;

import com.authentication.exceptions.ValidationException;
import com.authentication.rules.AbstractPasswordValidationRule;

public class SubsetOfRulesPasswordValidator extends BasicPasswordValidator{

    protected int noOfSubset=-1;
    protected boolean foundThreePositives = false;


    public SubsetOfRulesPasswordValidator(int noOfSubset) {
        this.noOfSubset = noOfSubset;
    }

     @Override
    public boolean validate(final String stringToBeValidated){

        boolean response = false;
        for(AbstractPasswordValidationRule rules: rulesToBeValidated){
            try {
                rules.validate(stringToBeValidated);
                checkIfFurtherProcessingNeeded();
                if ( foundThreePositives){
                    response = true;
                    break;
                }
            } catch (ValidationException validationException) {
                System.out.printf("Validation failed: " +validationException.getMessage());
            }
        }
        return response;
    }

    protected void checkIfFurtherProcessingNeeded() {
        this.noOfSubset--;
        if(this.noOfSubset == 0){
            foundThreePositives = true;
        }
    }
}
