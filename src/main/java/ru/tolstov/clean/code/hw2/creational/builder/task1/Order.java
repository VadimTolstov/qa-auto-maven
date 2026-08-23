package ru.tolstov.clean.code.hw2.creational.builder.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final int discount;
    private final List<String> product;
    private final PaymentMethod paymentMethod;

    private Order(OrderBuilder orderBuilder) {
        this.discount = orderBuilder.discount;
        this.product = orderBuilder.product;
        this.paymentMethod = orderBuilder.paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "discount=" + discount +
                ", product='" + product + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    static class OrderBuilder {
        private int discount;
        private final List<String> product = new ArrayList<>();
        private PaymentMethod paymentMethod;

        public OrderBuilder setDiscount(int discount) {
            this.discount = discount;
            return this;
        }

        public OrderBuilder setProduct(String... product) {
            this.product.addAll(Arrays.asList(product));
            return this;
        }

        public OrderBuilder setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
