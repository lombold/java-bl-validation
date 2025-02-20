package org.lombold.common.validation;

import java.util.List;

public class Validator {
    public static <T> void validate(final T t, final List<ValidationRule<T>> validationRules) {
        validationRules.forEach(rule -> rule.validate(t));
    }

}
