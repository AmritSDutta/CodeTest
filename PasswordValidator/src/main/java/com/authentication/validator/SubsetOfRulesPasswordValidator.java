package com.authentication.validator;

import com.authentication.exceptions.ValidationException;
import com.authentication.rules.AbstractPasswordValidationRule;

public class SubsetOfRulesPasswordValidator extends BasicPasswordValidator{

    private int noOfSubset=-1;
    private boolean foundThreePositives = false;


    public SubsetOfRulesPasswordValidator(int noOfSubset) {
        this.noOfSubset = noOfSubset;
    }


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
            } catch (ValidationException e) {
                System.out.printf("Validation failed: " +e.getMessage());
            }
        }
        return response;
    }

    private void checkIfFurtherProcessingNeeded() {
        this.noOfSubset--;
        if(this.noOfSubset == 0){
            foundThreePositives = true;
        }
    }
}
