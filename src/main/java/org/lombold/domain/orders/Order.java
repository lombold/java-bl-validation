package org.lombold.domain.orders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record Order(
        String orderId,
        String customerId,
        String customerName,
        String shippingAddress,
        String billingAddress,
        LocalDate orderDate,
        BigDecimal totalPrice
) {}
