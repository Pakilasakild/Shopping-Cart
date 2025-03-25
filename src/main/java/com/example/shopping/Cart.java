package com.example.shopping;

public class Cart {
    private String customerName;
    private String productName;
    private int quantity;
    private double pricePerItem;
    private double totalAmount;

    public Cart(String customerName, String productName, int quantity, double pricePerItem, double totalAmount) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
        this.totalAmount = totalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
