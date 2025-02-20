package org.lombold.common.validation;

import java.util.function.Predicate;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static <T> Predicate<T> xor(final Predicate<T> pred1, final Predicate<T> pred2) {
        return value -> pred1.test(value) ^ pred2.test(value);
    }
}