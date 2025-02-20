package org.lombold.domain.orders;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Order(
        String orderId,
        String customerId,
        String personName,
        String companyName,
        String shippingAddress,
        String billingAddress,
        LocalDate orderDate,
        BigDecimal totalPrice
) {
}
