package org.lombold.domain.orders;

import org.lombold.common.validation.ValidationRule;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import static org.lombold.common.validation.ValidationRule.rule;

public class OrderValidationRules {

    public static List<ValidationRule<Order>> forCreation() {
        return List.of(
                rule("Order ID cannot be blank", OrderValidationRules::isOrderIdValid),
                rule("Customer ID cannot be blank", OrderValidationRules::isCustomerIdValid),
                rule("Customer name cannot be blank", OrderValidationRules::isCustomerNameValid),
                rule("Shipping address cannot be blank", OrderValidationRules::isShippingAddressValid),
                rule("Billing address cannot be blank", OrderValidationRules::isBillingAddressValid)
        );
    }

    private static List<ValidationRule<Order>> commonRules() {
        return List.of(
                rule("Order date and order date/time must be non-null and match", OrderValidationRules::isOrderDatesValid),
                rule("Total price must be non-negative", OrderValidationRules::isTotalPriceValid),
                rule("Discount must be non-negative", OrderValidationRules::isDiscountValid),
                rule("Tax must be non-negative", OrderValidationRules::isTaxValid),
                rule("Currency cannot be blank", OrderValidationRules::isCurrencyValid),
                rule("Order status cannot be blank", OrderValidationRules::isOrderStatusValid),
                rule("Payment method cannot be blank", OrderValidationRules::isPaymentMethodValid),
                rule("Shipping method cannot be blank", OrderValidationRules::isShippingMethodValid),
                rule("Order must contain at least one item", OrderValidationRules::isItemsValid),
                rule("Item quantities cannot be empty", OrderValidationRules::isItemQuantitiesValid),
                rule("Item prices cannot be empty", OrderValidationRules::isItemPricesValid),
                rule("Tracking number cannot be blank", OrderValidationRules::isTrackingNumberValid),
                rule("Shipment and delivery dates must be non-null and delivery date cannot be before shipment date", OrderValidationRules::isShipmentAndDeliveryDatesValid),
                rule("Gift flag must be non-null and if true, gift message cannot be blank", OrderValidationRules::isGiftFieldsValid),
                rule("Reward points cannot be negative", OrderValidationRules::isRewardPointsValid),
                rule("Coupon code, if provided, cannot be blank", OrderValidationRules::isCouponCodeValid),
                rule("Shipping cost must be non-negative", OrderValidationRules::isShippingCostValid),
                rule("Store location cannot be blank", OrderValidationRules::isStoreLocationValid),
                rule("Expedited flag cannot be null", OrderValidationRules::isExpeditedValid),
                rule("Customer email cannot be blank", OrderValidationRules::isCustomerEmailValid),
                rule("Customer phone cannot be blank", OrderValidationRules::isCustomerPhoneValid)
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

    public static boolean isOrderDatesValid(final Order order) {
        final var date = order.orderDate();
        final var dateTime = order.orderDateTime();
        return date != null && dateTime != null && date.equals(dateTime.toLocalDate());
    }

    public static boolean isTotalPriceValid(final Order order) {
        final var price = order.totalPrice();
        return price != null && price.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isDiscountValid(final Order order) {
        final var discount = order.discount();
        return discount != null && discount.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isTaxValid(final Order order) {
        final var tax = order.tax();
        return tax != null && tax.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isCurrencyValid(final Order order) {
        return order.currency() != null && !order.currency().isBlank();
    }

    public static boolean isOrderStatusValid(final Order order) {
        return order.orderStatus() != null && !order.orderStatus().isBlank();
    }

    public static boolean isPaymentMethodValid(final Order order) {
        return order.paymentMethod() != null && !order.paymentMethod().isBlank();
    }

    public static boolean isShippingMethodValid(final Order order) {
        return order.shippingMethod() != null && !order.shippingMethod().isBlank();
    }

    public static boolean isItemsValid(final Order order) {
        return order.items() != null && !order.items().isEmpty();
    }

    public static boolean isItemQuantitiesValid(final Order order) {
        return order.itemQuantities() != null && !order.itemQuantities().isEmpty();
    }

    public static boolean isItemPricesValid(final Order order) {
        return order.itemPrices() != null && !order.itemPrices().isEmpty();
    }

    public static boolean isTrackingNumberValid(final Order order) {
        return order.trackingNumber() != null && !order.trackingNumber().isBlank();
    }

    public static boolean isShipmentAndDeliveryDatesValid(final Order order) {
        final var shipment = order.shipmentDate();
        final var delivery = order.deliveryDate();
        return shipment != null && delivery != null && !delivery.isBefore(shipment);
    }

    public static boolean isGiftFieldsValid(final Order order) {
        final var gift = order.gift();
        if (gift == null) {
            return false;
        }
        return !gift || (order.giftMessage() != null && !order.giftMessage().isBlank());
    }

    public static boolean isRewardPointsValid(final Order order) {
        return order.rewardPoints() >= 0;
    }

    public static boolean isCouponCodeValid(final Order order) {
        return order.couponCode() == null || !order.couponCode().isBlank();
    }

    public static boolean isShippingCostValid(final Order order) {
        final var cost = order.shippingCost();
        return cost != null && cost.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isStoreLocationValid(final Order order) {
        return order.storeLocation() != null && !order.storeLocation().isBlank();
    }

    public static boolean isExpeditedValid(final Order order) {
        return order.expedited() != null;
    }

    public static boolean isCustomerEmailValid(final Order order) {
        return order.customerEmail() != null && !order.customerEmail().isBlank();
    }

    public static boolean isCustomerPhoneValid(final Order order) {
        return order.customerPhone() != null && !order.customerPhone().isBlank();
    }
}
