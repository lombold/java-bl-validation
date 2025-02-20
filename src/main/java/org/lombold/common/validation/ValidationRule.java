package org.lombold.common.validation;

import java.util.function.Predicate;

public class ValidationRule<T> {
    private final String failureMessage;
    private final Predicate<T> rule;

    private ValidationRule(final String failureMessage, final Predicate<T> rule) {
        this.failureMessage = failureMessage;
        this.rule = rule;
    }

    public static <F> ValidationRule<F> rule(final String failureMessage, final Predicate<F> rule) {
        return new ValidationRule<>(failureMessage, rule);
    }

    public void validate(final T testee) {
        if (!rule.test(testee)) {
            throw new ValidationException(failureMessage, testee);
        }
    }

}
