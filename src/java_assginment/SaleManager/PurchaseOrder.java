
package java_assginment.SaleManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

 class PurchaseOrder {
     
     String orderID;
     String itemID;
     String itemName;
     String supplierID;
     int quantity;
     double unitPrice;
     double totalPrice;
     String date;
     String paymentStatus;
     String deliveryStatus;
     private ArrayList<PurchaseOrder> Plist= new ArrayList<PurchaseOrder>();


    public PurchaseOrder() {
    }

    public PurchaseOrder(String orderID, String itemID, String itemName, String supplierID, int quantity, double unitPrice, double totalPrice, String date, String paymentStatus, String deliveryStatus) {
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

    @Override
    public String toString() {
        return "PurchaseOrder{" + "orderID=" + orderID + ", itemID=" + itemID + ", itemName=" + itemName + ", supplierID=" + supplierID + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", date=" + date + ", paymentStatus=" + paymentStatus + ", deliveryStatus=" + deliveryStatus + '}';
    }
     
     public static PurchaseOrder fromString(String line) {
    // Split the line into parts using commas
    String[] parts = line.split(",");

    // Parse each part of the string array to initialize variables
    String orderID = parts[0].trim();
    String itemID = parts[1].trim();
    String itemName = parts[2].trim();
    String supplierID = parts[3].trim();
    int quantity = Integer.parseInt(parts[4].trim());
    double unitPrice = Double.parseDouble(parts[5].trim());
    double totalPrice = Double.parseDouble(parts[6].trim());
    String date = parts[7].trim();
    String paymentStatus = parts[8].trim();
    String deliveryStatus = parts[9].trim();

    // Return a new PurchaseOrder object
    return new PurchaseOrder(orderID, itemID, itemName, supplierID, quantity, unitPrice, totalPrice, date, paymentStatus, deliveryStatus);
}
     
     public ArrayList<PurchaseOrder> getSlist() {
        return Plist;
    }
     
     public ArrayList<PurchaseOrder> loadPurchaseOrder() {
    ArrayList<PurchaseOrder> Plist = new ArrayList<>();
    File Flist = new File("src/User_data/PurchaseOrders.txt");

    try (Scanner Sc = new Scanner(Flist)) {
        while (Sc.hasNextLine()) {
            String Line = Sc.nextLine();
            String[] parts = Line.split(",");

            // Ensure the array has the expected number of elements (10 in this case)
            if (parts.length == 10) {
                String OrderID = parts[0].trim();
                String ItemID = parts[1].trim();
                String ItemName = parts[2].trim();
                String SupplierID = parts[3].trim();
                int Quantity = Integer.parseInt(parts[4].trim());

                // Parse prices after removing 'RM'
                double UnitPrice = Double.parseDouble(parts[5].replace("RM", "").trim());
                double TotalPrice = Double.parseDouble(parts[6].replace("RM", "").trim());

                String Date = parts[7].trim();
                String PaymentStatus = parts[8].trim();
                String DeliveryStatus = parts[9].trim();

                // Use the correct constructor for PurchaseOrder
                PurchaseOrder Temp = new PurchaseOrder(
                    OrderID, ItemID, ItemName, SupplierID, Quantity, UnitPrice, TotalPrice, Date, PaymentStatus, DeliveryStatus
                );

                Plist.add(Temp);

                // Debug print to verify data
                System.out.println("Loaded: " + Temp);
            } else {
                System.err.println("Skipping malformed line: " + Line);
            }
        }
    } catch (Exception Ex) {
        System.err.println("Error reading file: " + Ex.getMessage());
    }

    return Plist;
}


    
}
