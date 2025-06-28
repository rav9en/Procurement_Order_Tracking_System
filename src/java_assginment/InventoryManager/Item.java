/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package java_assginment.InventoryManager;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Item {
    private static int itemCounter = 1;

    private static String getSupplierIdByName(String supplierName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String itemId;
    private String itemName;
    private String supplierId;
    private double price;
    private String dimensions;
    private int reorderLevel;
    private int quantityInStock;

    //Constructor for initialization
    public Item(String itemName, String supplierId, double price, String dimensions, int reorderLevel, int quantityInStock) {
        this.itemId = generateItemId();
        this.itemName = itemName;
        this.supplierId = supplierId;
        this.price = price;
        this.dimensions = dimensions;
        this.reorderLevel = reorderLevel;
        this.quantityInStock = quantityInStock;
    }

    //Constructor for reading from file
    public Item(String itemId, String itemName, String supplierId, double price, String dimensions, int reorderLevel, int quantityInStock) {
        this.itemId = itemId; // Use the provided itemId from the file
        this.itemName = itemName;
        this.supplierId = supplierId;
        this.price = price;
        this.dimensions = dimensions;
        this.reorderLevel = reorderLevel;
        this.quantityInStock = quantityInStock;
    }

    //Generate item ID automatically
    private static String generateItemId() {
        String id = "I" + String.format("%02d", itemCounter);
        itemCounter++;
        return id;
    }

    //Getters
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

    // Setters
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return itemId + ", " + itemName + ", " + supplierId + ", " + price + ", " + dimensions + ", " + reorderLevel + ", " + quantityInStock;
    }

    

    //Static List for Predefined items
    public static List<Item> predefinedItems = new ArrayList<>();
    
    //Initialization for predefined items
    static {
        predefinedItems.add(new Item("Electric rice steamer", "S01", 180.0, "2kg/25x25x25cm", 10, 5));
        predefinedItems.add(new Item("Smart doorbell", "S02", 500.0, "0.8kg/10x10x5cm", 6, 2));
        predefinedItems.add(new Item("Microwave oven", "S01", 480.0, "12kg/50x40x35cm", 5, 2));
        predefinedItems.add(new Item("Air conditioner(1.5 HP)", "S02", 1200.0, "30kg/80x60x40cm", 3, 2));
        predefinedItems.add(new Item("Washing machine(7kg)", "S04", 1400.0, "35kg/60x55x85cm", 2, 1));
        predefinedItems.add(new Item("Refrigerator(400L)", "S04", 2000.0, "60kg/80x70x60cm", 2, 1));
        predefinedItems.add(new Item("Blender", "S03", 180.0, "2kg/15x15x30cm", 8, 5));
        predefinedItems.add(new Item("Electric kettle", "S08", 90.0, "1.5kg/20x20x20cm", 10, 6));
        predefinedItems.add(new Item("Outdoor security camera", "S07", 750.0, "2kg/25x15x15cm", 4, 3));
        predefinedItems.add(new Item("Electric shaver", "S08", 220.0, "0.5kg/10x5x3cm", 15, 10));
        predefinedItems.add(new Item("Electric blanket", "S06", 380.0, "2kg/200x150cm", 4, 2));
        predefinedItems.add(new Item("Hair dryer", "S03", 100.0, "1kg/20x10x10cm", 20, 15));
        predefinedItems.add(new Item("Coffee maker", "S08", 350.0, "4kg/30x20x20cm", 5, 1));
        predefinedItems.add(new Item("Smart thermostat", "S07", 450.0, "0.5kg/15x10x5cm", 5, 4));
        predefinedItems.add(new Item("Portable generator", "S06", 1800.0, "20kg/50x50x50cm", 2, 1));
        predefinedItems.add(new Item("Surge protector", "S11", 140.0, "1kg/30x15x10cm", 8, 7));
        predefinedItems.add(new Item("Extension cord(5 sockets)", "S12", 45.0, "0.5kg/20x10x5cm", 25, 5));
        predefinedItems.add(new Item("Smart light bulb", "S09", 60.0, "0.2kg/10x10x5cm", 20, 15));
        predefinedItems.add(new Item("Electric drill", "S06", 290.0, "3kg/25x20x15cm", 6, 4));
        predefinedItems.add(new Item("Powerbank", "S09", 120.0, "0.3kg/10x5x2cm", 15, 9));
        predefinedItems.add(new Item("Laptop", "S10", 3400.0, "2kg/35x25x2cm", 4, 2));
        predefinedItems.add(new Item("Smartphone", "S05", 2500.0, "0.3kg/15x8x1cm", 5, 3));
        predefinedItems.add(new Item("Bluetooth speaker", "S09", 240.0, "1kg/15x10x10cm", 12, 6));
        predefinedItems.add(new Item("Smart watch", "S09", 700.0, "0.2kg/5x5x2cm", 6, 4));
        predefinedItems.add(new Item("Air fryer", "S01", 380.0, "4kg/35x30x30cm", 6, 5));
        predefinedItems.add(new Item("Ceiling fan", "S06", 250.0, "4kg/60x60x30cm", 5, 2));
        predefinedItems.add(new Item("Iron", "S08", 120.0, "1.5kg/25x12x12cm", 10, 3));
        predefinedItems.add(new Item("LED TV(40 inches)", "S04", 1900.0, "15kg/100x60x10cm", 4, 3));
        predefinedItems.add(new Item("Vacuum cleaner", "S02", 600.0, "5kg/40x30x25cm", 3, 2));
        predefinedItems.add(new Item("Dehumidifier", "S12", 650.0, "5kg/45x30x30cm", 6, 2));
    }
    
    //Saves predefined items
    public static void savePredefinedItemsToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Item item : predefinedItems) {
                writer.write(item.getItemId() + ", " +
                             item.getItemName() + ", " +
                             item.getSupplierId() + ", " +
                             item.getPrice() + ", " +
                             item.getDimensions() + ", " +
                             item.getReorderLevel() + ", " +
                             item.getQuantityInStock());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving items to file: " + e.getMessage());
        }
    }
   

    //Static list for all items (both predefined and added/updated items)
    public static List<Item> allItems = new ArrayList<>(predefinedItems);
    
    
    //Save all item (for updated one also)
    public static void saveItem(Item item){
        boolean itemExists = false;
        for (Item existingItem : allItems) {
            if (existingItem.getItemId().equals(item.getItemId())) {
                existingItem.setItemName(item.getItemName());
                existingItem.setSupplierId(item.getSupplierId());
                existingItem.setPrice(item.getPrice());
                existingItem.setDimensions(item.getDimensions());
                existingItem.setReorderLevel(item.getReorderLevel());
                existingItem.setQuantityInStock(item.getQuantityInStock());
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            allItems.add(item);
        }
        
        saveItemsToFile("src/User_data/items.txt");
    }
    
    
    //Save the list of items to file
    public static void saveItemsToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Item item : allItems) {
                writer.write(item.getItemId() + ", " + item.getItemName() + ", " +
                             item.getSupplierId() + ", " + item.getPrice() + ", " +
                             item.getDimensions() + ", " + item.getReorderLevel() + ", " +
                             item.getQuantityInStock());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving items to file: " + e.getMessage());
        }
    }
    
    
    //Load items
     public static void loadItemsFromFile(String filePath) {
        allItems.clear();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                //Fields that are strings
                String itemId = data[0].trim();               
                String itemName = data[1].trim();             
                String supplierId = data[2].trim();           
                String weightDimensions = data[4].trim();   

                //Fields that willl be parsing (price, reorder level, and quantity)
                double price = Double.parseDouble(data[3].trim());  
                int reorderLevel = Integer.parseInt(data[5].trim()); 
                int quantityInStock = Integer.parseInt(data[6].trim()); 

                Item item = new Item(itemId, itemName, supplierId, price, weightDimensions, reorderLevel, quantityInStock);
                allItems.add(item);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading items from file: " + e.getMessage());
        }
    }

    
    //Fetch all items
    public static List<Item> getAllItems() {
        return new ArrayList<>(allItems); // Return a copy of the allItems list
    }
    
    
    //Fetch items below reorder level
    public static List<Item> getItemsBelowReorderLevel() {
        List<Item> belowReorder = new ArrayList<>();
        for (Item item : allItems) {
            if (item.getQuantityInStock() < item.getReorderLevel()) {
                belowReorder.add(item);
            }
        }
        return belowReorder;
    }
    
    
    //Search item by id or name
    public static List<Item> searchItems(String searchText){
        return allItems.stream()
                .filter(item -> item.getItemId().toLowerCase().contains(searchText.toLowerCase())||
                                item.getItemName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    
    //Static method to add an item
    public static boolean addItem(String itemName, String supplierName, double price, String dimensions, int reorderLevel, int quantityInStock) {
        // Get the supplier ID using the supplier name
        String supplierId = getSupplierIdByName(supplierName);

        if (supplierId == null) {
            throw new IllegalArgumentException("Supplier not found: " + supplierName);
        }

        for (Item item : allItems) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return false; // Item already exists
            }
        }
        //Generate a new item ID
        String itemId = generateItemId();
        
        Item newItem = new Item(itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock);

        allItems.add(newItem);
        saveItemsToFile("src/User_data/items.txt");
        return true;
    }

    
    //Delete item
    public static boolean deleteItemById(String itemId) {
        for (Item item : allItems) {
            if (item.getItemId().equals(itemId)) {
                allItems.remove(item);

                // Save the updated item list back to the file
                saveItemsToFile("src/User_data/items.txt");
                return true; 
            }
        }
        return false; 
    }
}