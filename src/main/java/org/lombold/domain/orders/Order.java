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
        LocalDateTime orderDateTime,
        BigDecimal totalPrice,
        BigDecimal discount,
        BigDecimal tax,
        String currency,
        String orderStatus,
        String paymentMethod,
        String shippingMethod,
        List<String> items,
        List<Integer> itemQuantities,
        List<BigDecimal> itemPrices,
        String trackingNumber,
        LocalDateTime shipmentDate,
        LocalDateTime deliveryDate,
        Map<String, String> additionalInfo,
        boolean gift,
        String giftMessage,
        int rewardPoints,
        String couponCode,
        BigDecimal shippingCost,
        String storeLocation,
        boolean expedited,
        String customerEmail,
        String customerPhone
) {}
