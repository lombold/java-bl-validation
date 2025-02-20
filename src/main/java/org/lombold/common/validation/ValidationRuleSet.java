package org.lombold.common.validation;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidationRuleSet<T> {
    private final ArrayList<ValidationRule<T>> rules;

    private ValidationRuleSet(final ArrayList<ValidationRule<T>> rules) {
        this.rules = rules;
    }

    public static <T> ValidationRuleSet<T> ruleSet(final ValidationRule<T>... rules) {
        return new ValidationRuleSet<T>(new ArrayList<>(Arrays.asList(rules)));
    }

    public void validate(final T t) {
        rules.forEach(rule -> rule.validate(t));
    }

    public ValidationRuleSet<T> and(final ValidationRuleSet<T> other) {
        rules.addAll(other.rules);
        return this;
    }

}
