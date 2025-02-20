package org.lombold;

import org.lombold.domain.orders.Order;
import org.lombold.domain.orders.OrderValidationRules;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final var order = new Order(
                null,
                "456",
                "John Doe",
                null,
                "123 Main St",
                "456 Main St",
                LocalDate.of(2021, 1, 1),
                new BigDecimal("100.00")
        );

        final var order2 = new Order(
                null,
                "456",
                null,
                "ACME Corp",
                "123 Main St",
                "asdfadf",
                LocalDate.of(2021, 1, 1),
                new BigDecimal("100.00")
        );

        final var order3 = new Order(
                null,
                "456",
                "John Doe",
                "ACME Corp",
                "123 Main St",
                "asdfadf",
                LocalDate.of(2021, 1, 1),
                new BigDecimal("100.00")
        );


        OrderValidationRules.forCreate().validate(order);
        OrderValidationRules.forCreate().validate(order2);
        OrderValidationRules.forCreate().validate(order3);
    }
}