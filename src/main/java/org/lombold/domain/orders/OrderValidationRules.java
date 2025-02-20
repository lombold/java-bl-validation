package org.lombold.domain.orders;

import org.lombold.common.validation.ValidationRule;

import java.math.BigDecimal;
import java.util.List;

import static org.lombold.common.validation.ValidationRule.rule;

public class OrderValidationRules {

    public static List<ValidationRule<Order>> forCreation() {
        return List.of(
                rule("Order ID cannot be blank", OrderValidationRules::isOrderIdValid),
                rule("Customer ID cannot be blank", OrderValidationRules::isCustomerIdValid),
                rule("Customer name cannot be blank", OrderValidationRules::isCustomerNameValid),
                rule("Shipping address cannot be blank", OrderValidationRules::isShippingAddressValid),
                rule("Billing address cannot be blank", OrderValidationRules::isBillingAddressValid),
                rule("Total Price must be greater than 0", OrderValidationRules::isTotalPriceValid)
        );
    }

    private static List<ValidationRule<Order>> commonRules() {
        return List.of(
        );
    }

    public static boolean isOrderIdValid(final Order order) {
        return order.orderId() != null && !order.orderId().isBlank();
    }

    public static boolean isCustomerIdValid(final Order order) {
        return order.customerId() != null && !order.customerId().isBlank();
    }

    public static boolean isCustomerNameValid(final Order order) {
        return order.customerName() != null && !order.customerName().isBlank();
    }

    public static boolean isShippingAddressValid(final Order order) {
        return order.shippingAddress() != null && !order.shippingAddress().isBlank();
    }

    public static boolean isBillingAddressValid(final Order order) {
        return order.billingAddress() != null && !order.billingAddress().isBlank();
    }

    public static boolean isTotalPriceValid(final Order order) {
        final var price = order.totalPrice();
        return price != null && price.compareTo(BigDecimal.ZERO) >= 0;
    }
}
