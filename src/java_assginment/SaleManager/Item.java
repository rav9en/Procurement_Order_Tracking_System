package java_assginment.SaleManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    private String itemId;
    private String itemName;
    private String supplierId;
    private double price;
    private String dimensions;
    private int reorderLevel;
    private int quantityInStock;
    private ArrayList<Item> Ilist= new ArrayList<Item>();

    public Item() 
    {
        
    }
    
    public Item(String itemId, String itemName, String supplierId, double price, String dimensions, int reorderLevel, int quantityInStock) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.supplierId = supplierId;
        this.price = price;
        this.dimensions = dimensions;
        this.reorderLevel = reorderLevel;
        this.quantityInStock = quantityInStock;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSupplierId() {
        return supplierId; // Make sure this method exists
    }

    public double getPrice() {
        return price;
    }

    public String getDimensions() {
        return dimensions;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.2f,%s,%d,%d",
                itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock);
    }


    
    public static Item fromString(String line) {
    String[] parts = line.split(",\\s*"); // Split by comma followed by optional space
    if (parts.length != 7) { // Adjust the number based on your attributes
        throw new IllegalArgumentException("Invalid item format: " + line);
    }
    String itemId = parts[0];
    String itemName = parts[1];
    String supplierId = parts[2];
    double price = Double.parseDouble(parts[3].replace("RM", "").trim()); // Remove "RM" and parse
    String dimensions = parts[4];
    int reorderLevel = Integer.parseInt(parts[5]);
    int quantityInStock = Integer.parseInt(parts[6]);
    return new Item(itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock);
}




    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }


    
    public ArrayList<Item> getSlist() {
        return Ilist;
    }
    
    public ArrayList<Item> loadItem() {
    ArrayList<Item> Slist = new ArrayList<>();
    File Flist = new File("src/User_data/items.txt");

    if (!Flist.exists()) {
        System.err.println("File not found: " + Flist.getAbsolutePath());
        return Slist;
    }

    try {
        Scanner Sc = new Scanner(Flist);
        while (Sc.hasNextLine()) {
            String Line = Sc.nextLine();
            String[] parts = Line.split(",");

            // Ensure the array has the expected number of elements (7 in this case)
            if (parts.length == 7) {
                String ItID = parts[0].trim();
                String ItName = parts[1].trim();
                String SupID = parts[2].trim();

                // Remove the 'RM' and parse the price value
                String priceStr = parts[3].replace("RM", "").trim(); // Remove "RM" symbol
                double price = Double.parseDouble(priceStr);

                String dimensions = parts[4].trim();
                int reorderLevel = Integer.parseInt(parts[5].trim());
                int quantityInStock = Integer.parseInt(parts[6].trim());

                Item Temp = new Item(ItID, ItName, SupID, price, dimensions, reorderLevel, quantityInStock);
                Slist.add(Temp);

                // Debug print to verify data
                System.out.println("Loaded: " + Temp);
            } else {
                System.err.println("Skipping malformed line: " + Line);
            }
        }
        Sc.close();
    } catch (Exception Ex) {
        System.err.println("Error reading file: " + Ex.getMessage());
    }
    return Slist;
}


}
