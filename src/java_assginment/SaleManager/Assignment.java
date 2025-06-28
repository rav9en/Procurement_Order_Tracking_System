package java_assginment.SaleManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Assignment {
    private static String salesFile = "src/User_data/sales_entries.txt";
    private static String itemsFile = "src/User_data/items.txt";
    private static String requisitionsFile = "src/User_data/requisitions.txt";
    private static String purchaseOrderFile = "src/User_data/PurchaseOrders.txt";
    
    private static List<SalesEntry> salesEntries = new ArrayList<>(); // List to hold sales entries
    private static List<Requisition> requisitions = new ArrayList<>(); // List to hold requisitions
    private static List<Item> items = loadItemsFromFile();  // Assign directly to the global list
    private static List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public static void main(String[] args) {
        
        loadSalesEntriesFromFile(); 
        loadRequisitionsFromFile(); 
        items = loadItemsFromFile();
        loadPurchaseOrderFromFile();

        //Scanner scanner = new Scanner(System.in);
        //String sales_entriesFilePath = salesFile;  // Use the updated file path
        mainMenu();
        //handleSalesEntry(scanner, sales_entriesFilePath); 
}
    
    // Load sales entries from the file
    private static void loadSalesEntriesFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(salesFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(","); // Assuming comma-separated values in the file
            if (fields.length == 9) { // Ensure there are 9 fields, matching your constructor

                // Parse each field based on its type
                String salesEntryId = fields[0];
                String itemId = fields[1];
                String itemName = fields[2];
                String supplierId = fields[3];
                double price = Double.parseDouble(fields[4]);
                String dimensions = fields[5];
                int reorderLevel = Integer.parseInt(fields[6]);
                int quantityInStock = Integer.parseInt(fields[7]);
                int quantitySold = Integer.parseInt(fields[8]);

                // Create a new SalesEntry object with the parsed data
                SalesEntry entry = new SalesEntry(salesEntryId, itemId, itemName, supplierId, 
                                                  price, dimensions, reorderLevel, quantityInStock, quantitySold);

                // Add the entry to the salesEntries list
                salesEntries.add(entry);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading sales entries file: " + e.getMessage());
    }
}


    
    // Add this method to load items
    public static List<Item> loadItemsFromFile() {
    List<Item> items = new ArrayList<>();
    System.out.println("Loading items from file: " + itemsFile); // Debug output
    try (Scanner scanner = new Scanner(new File(itemsFile))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(","); // Split by comma
            if (parts.length == 7) {
                try {
                    String itemId = parts[0].trim();
                    String itemName = parts[1].trim();
                    String supplierId = parts[2].trim();
                    double price = Double.parseDouble(parts[3].replace("RM", "").trim());
                    String dimensions = parts[4].trim();
                    int reorderLevel = Integer.parseInt(parts[5].trim());
                    int quantityInStock = Integer.parseInt(parts[6].trim());
                    
                    Item item = new Item(itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock);
                    items.add(item);
                } catch (Exception e) {
                    System.out.println("Skipping malformed line: " + line);
                }
            } else {
                System.out.println("Invalid line format: " + line);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Items file not found: " + itemsFile);
    }
    System.out.println("Loaded items: " + items.size()); // Debugging
    return items;
}

    // Method to load requisitions from the file
    private static void loadRequisitionsFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(requisitionsFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(","); // Assuming CSV format

            if (fields.length == 5) {  // Ensure correct number of fields
                String requisitionId = fields[0];
                String itemId = fields[1];
                String itemName = fields[2];
                String supplierId = fields[3];
                int quantityToOrder = Integer.parseInt(fields[4]);

                // Create a new Requisition object and add it to the list
                Requisition requisition = new Requisition(requisitionId, itemId, itemName, supplierId, quantityToOrder);
                requisitions.add(requisition);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading requisitions file: " + e.getMessage());
    }
}




    
    private static void loadPurchaseOrderFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(purchaseOrderFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line and add it to purchaseOrders
              //  System.out.println("Read purchase order: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading purchase orders file: " + e.getMessage());
        }
    }

    

    // Main menu 
    private static void mainMenu() {
    Scanner scanner = new Scanner(System.in);
    String sales_entriesFilePath = salesFile;  // Use the relative path

    while (true) {
        System.out.println("\n=== Sales Manager Menu ===");
        System.out.println("1. List of Items (View)");
        System.out.println("2. Daily Item-wise Sales Entry (Add/Edit/Delete)");
        System.out.println("3. Sales Report");
        System.out.println("4. Stock Level");
        System.out.println("5. Create Requisition");
        System.out.println("6. List of Purchaser Orders");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        switch (choice) {
            case 1:
                displayListOfItems();
                break;
            case 2:
                handleSalesEntry(scanner, sales_entriesFilePath); // Use the updated path
                break;
            case 3:
                generateSalesReport(); // Detailed sales report functionality
                break;
            case 4:
                StockLevel stockLevel = new StockLevel(itemsFile); // Use the updated path
                stockLevel.displayStockLevels(); // Display current stock levels
                stockLevel.checkStockLevels(); // Check for any items below reorder level
                break;
            case 5:
                displayRequisitions(); // Call to display requisitions
                createRequisition(); // Call to create requisition
                break;
            case 6:
                displayPurchaseOrder();
                break;
            case 0:
                System.out.println("Exiting...");
                return; 
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}



    // Method to display the list of items
    private static void displayListOfItems() {
        System.out.println("\n=== List of Items ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(itemsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Display each line from items.txt
            }
        } catch (IOException e) {
            System.out.println("Error loading items: " + e.getMessage());
        }
    }


    // Sales entry management functions
    private static void handleSalesEntry(Scanner scanner, String sales_entriesFilePath) {
    while (true) {
        System.out.println("\n=== Sales Entry Management ===");
        System.out.println("1. Add Sales Entry");
        System.out.println("2. Add Sales Entry with Details");
        System.out.println("3. Edit Sales Entry");
        System.out.println("4. Delete Sales Entry");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (choice) {
            case 1 -> addSalesEntry(sales_entriesFilePath); // Original method
            case 2 -> { // Overloaded method
                System.out.print("Enter Item ID: ");
                String itemId = scanner.nextLine().trim();
                System.out.print("Enter Quantity Sold: ");
                int quantitySold = Integer.parseInt(scanner.nextLine().trim());
                addSalesEntry(itemId, quantitySold);          }
            case 3 -> editSalesEntry(scanner); // Edit existing sales entry
            case 4 -> deleteSalesEntry(scanner); // Delete a sales entry
            case 0 -> {
                return; // Go back to main menu
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
}


    public static void addSalesEntry(String sales_entriesFilePath) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Add Sales Entry ===");
        System.out.print("Enter Item ID: ");
        String itemId = scanner.nextLine().trim();
        // Validate and find the item by ID
        Item selectedItem = null;
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                selectedItem = item;
                break;
            } 
        }
        if (selectedItem == null) {
            System.out.println("Item ID not found in the system.");
            return;}
        System.out.print("Enter quantity sold: ");
        int quantitySold = Integer.parseInt(scanner.nextLine().trim());
        if (quantitySold <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;}
        // Check if there is enough stock to sell
        if (selectedItem.getQuantityInStock() < quantitySold) {
            System.out.println("Insufficient stock. Available stock: " + selectedItem.getQuantityInStock());
            return;}
        // Generate a new sales entry ID
        String salesEntryId = generateSalesEntryId(sales_entriesFilePath);
        // Create sales entry
        SalesEntry salesEntry = new SalesEntry(
            salesEntryId,
            selectedItem.getItemId(),
            selectedItem.getItemName(),
            selectedItem.getSupplierId(),
            selectedItem.getPrice(),
            selectedItem.getDimensions(),
            selectedItem.getReorderLevel(),
            selectedItem.getQuantityInStock(),
            quantitySold
        );

        // Update item stock
        selectedItem.setQuantityInStock(selectedItem.getQuantityInStock() - quantitySold);

        // Add the new sales entry to the list
        salesEntries.add(salesEntry);

        // Save sales entries and items back to file
        saveSalesEntriesToFile(sales_entriesFilePath);
        saveItemsToFile(itemsFile);

        System.out.println("Sales Entry added: " + salesEntry.toString());
    }

    // Overloaded method with item ID and quantity as parameters
    public static void addSalesEntry(String itemId, int quantitySold) {
        // Validate and find the item by ID
        Item selectedItem = null;
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                selectedItem = item;
                break;}}
        if (selectedItem == null) {
            System.out.println("Item ID not found in the system.");
            return;}
        if (quantitySold <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;}
        // Check if there is enough stock to sell
        if (selectedItem.getQuantityInStock() < quantitySold) {
            System.out.println("Insufficient stock. Available stock: " + selectedItem.getQuantityInStock());
            return;}
        // Generate a new sales entry ID
        String salesEntryId = generateSalesEntryId("sales_entries.txt");
        // Create sales entry
        SalesEntry salesEntry = new SalesEntry(
            salesEntryId,
            selectedItem.getItemId(),
            selectedItem.getItemName(),
            selectedItem.getSupplierId(),
            selectedItem.getPrice(),
            selectedItem.getDimensions(),
            selectedItem.getReorderLevel(),
            selectedItem.getQuantityInStock(),
            quantitySold
        );

        // Update item stock
        selectedItem.setQuantityInStock(selectedItem.getQuantityInStock() - quantitySold);

        // Add the new sales entry to the list
        salesEntries.add(salesEntry);

        // Save sales entries and items back to file
        saveSalesEntriesToFile("sales_entries.txt");
        saveItemsToFile(itemsFile);

        System.out.println("Sales Entry added: " + salesEntry.toString());
    }



    
    // Generate unique sales entry ID
    private static String generateSalesEntryId(String sales_entriesFilePath) {
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


    // Edit existing sales entry method
    private static void editSalesEntry(Scanner scanner) {
        System.out.print("Enter Sales Entry ID of the Sales Entry to edit: ");
        String salesEntryId = scanner.nextLine();
        
        for (SalesEntry entry : salesEntries) {
            if (entry.getSalesEntryId().equals(salesEntryId)) {
                System.out.println("Current Entry: " + entry);
                System.out.print("Enter new Quantity Sold: ");
                int quantitySold = scanner.nextInt();
                entry.setQuantitySold(quantitySold);
                saveSalesEntriesToFile(salesFile); // Save updated entry to file
                System.out.println("Sales Entry updated: " + entry);
                return;
            }
        }
        System.out.println("Sales Entry not found!");
    }

    // Delete sales entry method
    private static void deleteSalesEntry(Scanner scanner) {
    System.out.print("Enter Sales Entry ID of the Sales Entry to delete: ");
    String salesEntryId = scanner.nextLine();
    
    SalesEntry entryToDelete = null; // To store the entry to be deleted
    
    // Find the sales entry to delete
    for (SalesEntry entry : salesEntries) {
        if (entry.getSalesEntryId().equals(salesEntryId)) {
            entryToDelete = entry;
            break;
        }
    }

    if (entryToDelete != null) {
        salesEntries.remove(entryToDelete); // Remove the entry from the list
        saveSalesEntriesToFile(salesFile);  // Save the updated list to file
        System.out.println("Sales Entry deleted: " + entryToDelete);
    } else {
        System.out.println("Sales Entry not found!");
    }
}



public static void saveSalesEntriesToFile(String salesEntriesFilePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(salesEntriesFilePath, false))) {  // Overwrite mode (false)
        for (SalesEntry entry : salesEntries) {
            writer.write(entry.toString() + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    // Save updated items to file
    private static void saveItemsToFile(String itemsFilePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(itemsFilePath))) {
        for (Item item : items) {
            // Assuming the Item class has getters for all its attributes
            String itemData = String.join(",",
                    item.getItemId(),
                    item.getItemName(),
                    item.getSupplierId(),
                    "RM" + item.getPrice(), // Adding "RM" for price
                    item.getDimensions(),
                    String.valueOf(item.getReorderLevel()),
                    String.valueOf(item.getQuantityInStock())
            );
            writer.write(itemData);
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error saving items to file: " + e.getMessage());
    }
}
    private static String generateRequisitionId(String requisitionsFilePath) {
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


private static void createRequisition() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n=== Creating Requisitions ===");
    System.out.print("Enter Item ID: ");
    String itemId = scanner.nextLine().trim();

    // Iterate over sales entries to find matching itemId
    for (SalesEntry entry : salesEntries) {
        if (entry.getItemId().equals(itemId)) {
            System.out.print("Enter Quantity to Order: ");
            int quantityToOrder = scanner.nextInt();

            // Validate quantity
            if (quantityToOrder <= 0) {
                System.out.println("Quantity must be greater than zero.");
                return;
            }

            // Generate the unique requisition ID using the method that reads the file
            String requisitionId = generateRequisitionId("src/User_data/requisitions.txt");

            // Create a new Requisition instance (Requisition ID is auto-generated)
            Requisition requisition = new Requisition(
                requisitionId,  // Using the generated requisition ID
                entry.getItemId(),
                entry.getItemName(),
                entry.getSupplierId(),
                quantityToOrder
            );

            // Add requisition to the list
            requisitions.add(requisition);

            // Save the updated list of requisitions to the file
            saveRequisitionsToFile();

            System.out.println("Requisition created: " + requisition);
            return;
        }
    }
    System.out.println("Item ID not found.");
}


// Method to save requisitions to the file
public static void saveRequisitionsToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/User_data/requisitions.txt"))) {
        for (Requisition requisition : requisitions) {
            writer.write(requisition.getRequisitionId() + "," + requisition.getItemId() + "," + requisition.getItemName() + ","
                    + requisition.getSupplierId() + "," + requisition.getQuantityToOrder());
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error saving requisitions to file: " + e.getMessage());
    }
}


// Method to display the requisitions
private static void displayRequisitions() {
    System.out.println("=== List of Requisitions ===");
    for (Requisition requisition : requisitions) {
        System.out.println(requisition);
    }
}


    // Detailed sales report generation method
    private static void generateSalesReport() {
        System.out.println("\n=== Sales Report ===");
        if (salesEntries.isEmpty()) {
            System.out.println("No sales entries available.");
            return;
        }
        
        double totalSales = 0; // Variable to hold total sales amount

        // Print the header for the sales report
        System.out.printf("%-15s %-20s %-10s %-10s %-10s%n", "Sales Entry ID", "Item Name", "Quantity Sold", "Price", "Total");
        System.out.println("-------------------------------------------------------------");

        // Loop through sales entries to display details
        for (SalesEntry entry : salesEntries) {
            double totalForEntry = entry.getQuantitySold() * entry.getPrice(); // Calculate total for the entry
            totalSales += totalForEntry; // Update the total sales amount
            // Display entry details
            System.out.printf("%-15s %-20s %-10d $%-9.2f $%-10.2f%n", 
                entry.getSalesEntryId(), 
                entry.getItemName(), 
                entry.getQuantitySold(), 
                entry.getPrice(), 
                totalForEntry
            );
        }

        // Print total sales at the bottom
        System.out.println("-------------------------------------------------------------");
        System.out.printf("Total Sales: $%.2f%n", totalSales);
    }
    
    // Method to display the list of items
    private static void displayPurchaseOrder() {
    System.out.println("\n=== List of Purchase Orders ===");
    try (BufferedReader reader = new BufferedReader(new FileReader(purchaseOrderFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Display each line from the purchase orders file
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Error loading purchase orders: " + e.getMessage());
    }
}

}
