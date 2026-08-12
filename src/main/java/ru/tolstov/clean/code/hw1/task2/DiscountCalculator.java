package ru.tolstov.clean.code.hw1.task2;

public class DiscountCalculator {
    private static final double LOYAL_FIRST_PRICE_MULTIPLIER = 0.90;
    private static final double LOYAL_PRICE_MULTIPLIER = 0.95;
    private static final double COUPON_PRICE_MULTIPLIER = 0.93;
    private static final double DEFAULT_PRICE_MULTIPLIER  = 0.98;

    public double calculateDiscount(double price, boolean isLoyalCustomer, boolean isFirstPurchase, boolean hasCoupon) {
        if (isLoyalCustomer && isFirstPurchase) {
            return price * LOYAL_FIRST_PRICE_MULTIPLIER;
        }
        if (isLoyalCustomer) {
            return price * LOYAL_PRICE_MULTIPLIER;
        }

        if (hasCoupon) {
            return price * COUPON_PRICE_MULTIPLIER;
        }
        return price * DEFAULT_PRICE_MULTIPLIER;
    }
}
