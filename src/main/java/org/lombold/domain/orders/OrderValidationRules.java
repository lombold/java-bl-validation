package org.lombold.domain.orders;

import org.lombold.common.validation.ValidationRuleSet;

import java.math.BigDecimal;

import static java.util.function.Predicate.not;
import static org.lombold.common.validation.ValidationRule.rule;
import static org.lombold.common.validation.ValidationRuleSet.ruleSet;
import static org.lombold.common.validation.ValidationUtils.xor;

public class OrderValidationRules {

    public static ValidationRuleSet<Order> forCreate() {
        return ruleSet(
                rule("Order ID must be blank", not(OrderValidationRules::isOrderIdSet))
        ).and(commonRules());
    }

    public static ValidationRuleSet<Order> forUpdate() {
        return ruleSet(
                rule("Order ID cannot be blank", OrderValidationRules::isOrderIdSet)
        ).and(commonRules());
    }

    private static ValidationRuleSet<Order> commonRules() {
        return ruleSet(
                rule("Customer ID cannot be blank", OrderValidationRules::isCustomerIdValid),
                rule("Either person or company name must be set", xor(OrderValidationRules::isPersonNameSet, OrderValidationRules::isCompanyNameSet)),
                rule("Shipping address cannot be blank", OrderValidationRules::isShippingAddressValid),
                rule("Billing address cannot be blank", OrderValidationRules::isBillingAddressValid),
                rule("Total Price must be greater than 0", OrderValidationRules::isTotalPriceValid)
        );
    }

    public static boolean isOrderIdSet(final Order order) {
        return order.orderId() != null && !order.orderId().isBlank();
    }

    public static boolean isCustomerIdValid(final Order order) {
        return order.customerId() != null && !order.customerId().isBlank();
    }

    public static boolean isPersonNameSet(final Order order) {
        return order.personName() != null && !order.personName().isBlank();
    }

    public static boolean isCompanyNameSet(final Order order) {
        return order.companyName() != null && !order.companyName().isBlank();
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
