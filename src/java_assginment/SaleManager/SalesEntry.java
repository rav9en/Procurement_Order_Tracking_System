package java_assginment.SaleManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SalesEntry {
    private String salesEntryId;  // New Sales Entry ID
    private String itemId;
    private String itemName;
    private String supplierId;
    private double price;
    private String dimensions;
    private int reorderLevel;
    private int quantityInStock;
    private int quantitySold;
    private ArrayList<SalesEntry> SElist= new ArrayList<SalesEntry>();

    public SalesEntry() {
    }

    // Constructor
    public SalesEntry(String salesEntryId, String itemId, String itemName, String supplierId,
                      double price, String dimensions, int reorderLevel, int quantityInStock, int quantitySold) {
        this.salesEntryId = salesEntryId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.supplierId = supplierId;
        this.price = price;
        this.dimensions = dimensions;
        this.reorderLevel = reorderLevel;
        this.quantityInStock = quantityInStock;
        this.quantitySold = quantitySold;
    }

    // Getter methods
    public String getSalesEntryId() {
        return salesEntryId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSupplierId() {
        return supplierId;
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

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    // Setter for quantitySold
    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    // Convert a line from the sales file to a SalesEntry object
    public static SalesEntry fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 9) {
            throw new IllegalArgumentException("Incorrect number of fields in sales entry: " + line);
        }
        return new SalesEntry(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]),
                parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7]),
                Integer.parseInt(parts[8]));
    }

    @Override
public String toString() {
    return String.format("%s,%s,%s,%s,%.2f,%s,%d,%d,%d",
            salesEntryId, itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock, quantitySold);
}  
    
    public ArrayList<SalesEntry> loadSalesEntries() {
    ArrayList<SalesEntry> salesEntries = new ArrayList<>();
    File file = new File("src/User_data/sales_entries.txt");
    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            if (parts.length == 9) { // Ensure the format matches
                SalesEntry entry = new SalesEntry(
                    parts[0], parts[1], parts[2], parts[3], 
                    Double.parseDouble(parts[4]), parts[5], 
                    Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), 
                    Integer.parseInt(parts[8])
                );
                salesEntries.add(entry);
            }
        }
    } catch (Exception e) {
        System.err.println("Error loading sales entries: " + e.getMessage());
    }
    return salesEntries;
      
}
    
    // Generate unique requisition ID
    private String generateSalesEntryId(String sales_entriesFilePath) {
        int lastId = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(sales_entriesFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].startsWith("SE")) {
                    String numericPart = parts[0].substring(3); // Extract numeric part of REQ ID
                    lastId = Math.max(lastId, Integer.parseInt(numericPart));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading sales entries file for ID generation: " + e.getMessage());
        }
        return "SE" + String.format("%03d", lastId + 1);
    }
    
// Static method to save all sales entries to a file
    public static void saveSalesEntriesToFile(ArrayList<SalesEntry> salesEntries) {
    // Specify the file path directly
    String filePath = "src/User_data/sales_entries.txt";
    File file = new File(filePath);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        // Iterate over each SalesEntry object and write it to the file
        for (SalesEntry entry : salesEntries) {
            // Ensure the toString method is correctly formatting the data
            writer.write(entry.toString());
            writer.newLine();  // Write a newline after each entry
        }
    } catch (IOException e) {
        System.err.println("Error saving sales entries: " + e.getMessage());
    }
}



}
