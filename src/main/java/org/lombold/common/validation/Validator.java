package org.lombold.common.validation;

import java.util.List;

public class  Validator <T> {
    public void validate(T t, List<ValidationRule<T>> validationRules) {
        validationRules.forEach(rule -> rule.validate(t));
    }

}
