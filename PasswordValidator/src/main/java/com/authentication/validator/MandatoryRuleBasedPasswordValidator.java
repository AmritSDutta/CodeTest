package com.authentication.validator;

import com.authentication.exceptions.ValidationException;
import com.authentication.rules.AbstractPasswordValidationRule;

import java.util.Collections;
import java.util.Comparator;


/**
 * This algo verifies at least n validations are okay.
 * It also checks if there are any mandatory validation present,
 * it must be processed as priority. Kind of fail-fast scenario.
 */
public class MandatoryRuleBasedPasswordValidator extends SubsetOfRulesPasswordValidator{
    public MandatoryRuleBasedPasswordValidator(int noOfSubset) {
        super(noOfSubset);
    }

    @Override
    public boolean validate(final String stringToBeValidated){

        boolean response = false;
        Collections.sort(rulesToBeValidated,
                Comparator.comparing(AbstractPasswordValidationRule::getPriority).reversed() );
        for(AbstractPasswordValidationRule rule: rulesToBeValidated){
            try {
                rule.validate(stringToBeValidated);
                checkIfFurtherProcessingNeeded();
                if ( foundThreePositives){
                    response = true;
                    break;
                }
            } catch (ValidationException validationException) {
                if(rule.isMandatory()) {
                    System.out.printf("Encountered mandatory rule, validation fails");
                    break;
                }
                System.out.printf("Validation failed: " +validationException.getMessage());
            }
        }
        return response;
    }
}
