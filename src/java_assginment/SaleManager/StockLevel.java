package java_assginment.SaleManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class StockLevel {
    private String filePath;
    private List<Item> items;

    public StockLevel(String filePath) {
        this.filePath=filePath;
        this.items = new ArrayList<>();
        loadItemsFromFile(filePath);
    }

    private void loadItemsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Assuming comma-separated values
                if (parts.length == 7) { // Ensure there are 7 parts
                    String itemId = parts[0].trim();
                    String itemName = parts[1].trim();
                    String supplierId = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim().replace("RM", "").trim());
                    String dimensions = parts[4].trim();
                    int reorderLevel = Integer.parseInt(parts[5].trim());
                    int quantityInStock = Integer.parseInt(parts[6].trim());

                    items.add(new Item(itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }

    // Check stock levels against reorder levels
    public void checkStockLevels() {
        System.out.println("\n=== Stock Levels ===");
        for (Item item : items) {
            if (item.getQuantityInStock() < item.getReorderLevel()) {
                System.out.println(item.getItemId() + " is below reorder level. Current Stock: " +
                        item.getQuantityInStock() + ", Reorder Level: " +
                        item.getReorderLevel());
            }
        }
    }

    // Display current stock levels
    public void displayStockLevels() {
        System.out.println("\n=== Current Stock Levels ===");
        if (items.isEmpty()) {
            System.out.println("No items found."); // Handle empty item list
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }

    // Method to get items below reorder level
    public List<Item> getItemsBelowReorderLevel() {
        List<Item> belowReorderLevel = new ArrayList<>();
        for (Item item : items) {
            if (item.getQuantityInStock() < item.getReorderLevel()) {
                belowReorderLevel.add(item);
            }
        }
        return belowReorderLevel;
    }

    // Create a requisition manually
    public void createRequisition(String requisitionsFilePath) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Creating Requisitions ===");
        System.out.print("Enter Item ID for requisition: ");
        String itemId = scanner.nextLine().trim();

        Item selectedItem = null;
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem == null) {
            System.out.println("Item ID not found.");
            return;
        }

        System.out.print("Enter quantity to order: ");
        int quantityToOrder = Integer.parseInt(scanner.nextLine().trim());

        if (quantityToOrder <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        // Generate a new requisition ID
        String requisitionId = generateRequisitionId(requisitionsFilePath);

        // Create requisition
        Requisition requisition = new Requisition(
                requisitionId,
                selectedItem.getItemId(),
                selectedItem.getItemName(),
                selectedItem.getSupplierId(),
                quantityToOrder
        );

        // Save requisition to file
        Requisition.saveToFile(requisition, requisitionsFilePath);

        System.out.println("Requisition created: " + requisition);
    }

    // Generate unique requisition ID
    private String generateRequisitionId(String requisitionsFilePath) {
        int lastId = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(requisitionsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].startsWith("REQ")) {
                    String numericPart = parts[0].substring(3); // Extract numeric part of REQ ID
                    lastId = Math.max(lastId, Integer.parseInt(numericPart));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading requisitions file for ID generation: " + e.getMessage());
        }
        return "REQ" + String.format("%03d", lastId + 1);
    }
}


