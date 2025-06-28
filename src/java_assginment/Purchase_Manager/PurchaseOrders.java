/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_assginment.Purchase_Manager;
import java.util.ArrayList;

public class PurchaseOrders {
    private String orderID;
    private String itemID;
    private String itemName;
    private String supplierID;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String date;
    private String paymentStatus;
    private String deliveryStatus;
    ArrayList<PurchaseOrders> myPurchaseOrdersList = new ArrayList<PurchaseOrders>();
    public PurchaseOrders(String orderID, String itemID, String itemName, String supplierID, int quantity, double unitPrice, double totalPrice, String date, String paymentStatus, String deliveryStatus) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.itemName = itemName;
        this.supplierID = supplierID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.date = date;
        this.paymentStatus = paymentStatus;
        this.deliveryStatus = deliveryStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getDate() {
        return date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    
    public void loadPurchaseOrders()
    {
        //
    }
    
}
