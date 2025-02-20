package org.lombold;

import org.lombold.common.validation.Validator;
import org.lombold.domain.orders.Order;
import org.lombold.domain.orders.OrderValidationRules;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final var order = new Order(
                "123",
                "456",
                "John Doe",
                "123 Main St",
                "456 Main St",
                LocalDate.of(2021, 1, 1),
                new BigDecimal("100.00")
        );

        final var validationRules = OrderValidationRules.forCreation();
        Validator.validate(order, validationRules);

        final var order2 = new Order(
                null,
                "456",
                "John Doe",
                "123 Main St",
                null,
                LocalDate.of(2021, 1, 1),
                new BigDecimal("100.00")
        );

        Validator.validate(order2, validationRules);
    }
}