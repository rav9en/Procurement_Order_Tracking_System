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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Supplier {
    private static int supplierCounter = 1; 
    
    private String supplierId;
    private String supplierName;
    private String contactNumber;
    private String email;
    private String itemIds;
    private String paymentMethod;
    private String shippingMethod;
    private String supplyCapacity;
    private String leadTime;
    
    //Constructor for initialization
    public Supplier(String supplierName, String contactNumber, String email, String itemIds, String paymentMethod, String shippingMethod, String supplyCapacity, String leadTime) {
        this.supplierId = generateSupplierId();
        this.supplierName = supplierName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.itemIds = itemIds;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.supplyCapacity = supplyCapacity;
        this.leadTime = leadTime;
    }

    
    
    private static String generateSupplierId(){
        String id = "S" + String.format("%02d", supplierCounter);
        supplierCounter++;
        return id;
    }
    
    //Constructor for Supplier Management Interface -- edit part
    public Supplier(String supplierId, String supplierName, String contactNumber, String email, List<String> itemIds, String paymentMethod, String shippingMethod, String supplyCapacity, String leadTime) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.itemIds = String.join(";", itemIds);
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.supplyCapacity = supplyCapacity;
        this.leadTime = leadTime;
    }


    private Supplier(String supplierId, String name, String contactNumber, String email, String itemIds, String paymentMethod, String shippingMethod, String supplyCapacity, String leadTime) {
    }

    private Supplier(String supplierId, String name, String contactNumber, String email, List<String> itemIds, String paymentMethod, String shippingMethod, int supplyCapacity, int leadTime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Getters
    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getItemIds() {
        return itemIds; 
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public String getSupplyCapacity() {
        return supplyCapacity;
    }

    public String getLeadTime() {
        return leadTime;
    }
    
    
    //Setters
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = String.join(";", itemIds);
    }


    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public void setSupplyCapacity(String supplyCapacity) {
        this.supplyCapacity = supplyCapacity;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    @Override
    public String toString() {
        return supplierId + ", " + supplierName + ", " + contactNumber + ", " + email + ", " + itemIds + ", " + paymentMethod + ", " + shippingMethod + ", " + supplyCapacity + ", " + leadTime;
    }
    
    //Static List for Predefined Supplier
    public static List<Supplier> predefinedSuppliers = new ArrayList<>();

    //Initialization
    static {
        predefinedSuppliers.add(new Supplier("Senheng Electric", "+60392814040", "sales@senheng.com.my", "I01;I03;I25", "Net 30", "Air", "200", "5"));
        predefinedSuppliers.add(new Supplier("Panasonic Malaysia", "+60379537600", "contact@panasonic.com.my", "I02;I04;I29", "Net 60", "Sea", "150", "10"));
        predefinedSuppliers.add(new Supplier("Pensonic Holdings", "+6042623300", "support@pensonic.com.my", "I07;I12", "Net 30", "Land", "300", "3"));
        predefinedSuppliers.add(new Supplier("Samsung Malaysia", "+60351911515", "contact@samsung.com.my", "I05;I06;I28", "Net 45", "Air", "100", "7"));
        predefinedSuppliers.add(new Supplier("Huawei Malaysia", "+60322620086", "sales@huawei.com.my", "I22", "Prepaid", "Air", "80", "5"));
        predefinedSuppliers.add(new Supplier("Khind Holdings", "+60378392000", "info@khind.com.my", "I11;I15;I19;I26", "Net 30", "Land", "100", "7"));
        predefinedSuppliers.add(new Supplier("Dahua Technology", "+60386055168", "malaysia@dahuatech.com", "I09;I14", "Prepaid", "Air", "50", "5"));
        predefinedSuppliers.add(new Supplier("Philips Malaysia", "+60379698888", "customerservice.my@philips.com", "I08;I10;I13;I27", "Net 30", "Air", "400", "4"));
        predefinedSuppliers.add(new Supplier("Xiaomi Malaysia", "+6020273033", "support@xiaomi.com.my", "I18;I20;I23;I24", "Prepaid", "Land", "500", "3"));
        predefinedSuppliers.add(new Supplier("HP Malaysia", "+60323325333", "contact@hp.com.my", "I21", "Prepaid", "Air", "50", "5"));
        predefinedSuppliers.add(new Supplier("Belkin Malaysia", "+60322955115", "info@belkin.com.my", "I16", "Net 60", "Land", "250", "5"));
        predefinedSuppliers.add(new Supplier("IKEA Malaysia", "+60379527575", "customerservice.my@ikea.com", "I17;I30", "Prepaid", "Land", "150", "4"));
    }
    
    //Saves the predefined items
    public static void savePredefinedSuppliersToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Supplier supplier : predefinedSuppliers) {
                writer.write(supplier.getSupplierId() + ", " +
                             supplier.getSupplierName() + ", " +
                             supplier.getContactNumber() + ", " +
                             supplier.getEmail() + ", " +
                             supplier.getItemIds() + ", " +
                             supplier.getPaymentMethod()  + ", " +
                             supplier.getShippingMethod() + ", " +
                             supplier.getSupplyCapacity() + ", " +
                             supplier.getLeadTime());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving suppliers to file: " + e.getMessage());
        }
    }

 
    
    //Static list for all suppliers (both predefined and added/updated suppliers)
    public static List<Supplier> allSuppliers = new ArrayList<>(predefinedSuppliers);

    //Save all suppliers (for updated ones also)
    public static void saveSupplier(Supplier supplier) {
        // Check if supplier already exists by supplierId and update it
        boolean supplierExists = false;
        for (Supplier existingSupplier : allSuppliers) {
            if (existingSupplier.getSupplierId().equals(supplier.getSupplierId())) {
                // Update the existing supplier details
                existingSupplier.setSupplierName(supplier.getSupplierName());
                existingSupplier.setContactNumber(supplier.getContactNumber());
                existingSupplier.setEmail(supplier.getEmail());
                existingSupplier.setItemIds(List.of(supplier.getItemIds()));
                existingSupplier.setPaymentMethod(supplier.getPaymentMethod());
                existingSupplier.setShippingMethod(supplier.getShippingMethod());
                existingSupplier.setSupplyCapacity(supplier.getSupplyCapacity());
                existingSupplier.setLeadTime(supplier.getLeadTime());
                supplierExists = true;
                break;
            }
        }
        //If supplier doesn't exist, add a new supplier
        if (!supplierExists) {
            allSuppliers.add(supplier);
        }

        //After updating/adding the supplier, save the list to a file
        saveSuppliersToFile("src/User_data/suppliers.txt");
    }

    //Save the list of suppliers to file
    public static void saveSuppliersToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Supplier supplier : allSuppliers) {
                writer.write(supplier.getSupplierId() + ", " + supplier.getSupplierName() + ", " +
                             supplier.getContactNumber() + ", " + supplier.getEmail() + ", " +
                             supplier.getItemIds() + ", " + supplier.getPaymentMethod() + ", " +
                             supplier.getShippingMethod() + ", " + supplier.getSupplyCapacity() + ", " +
                             supplier.getLeadTime());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving suppliers to file: " + e.getMessage());
        }
    }

    //Load suppliers from file
    public static void loadSuppliersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",\\s*"); //Split by comma and trim spaces
                    if (parts.length != 9) {
                        System.out.println("Skipping malformed line: " + line);
                        continue;
                    }

                    //Parse fields
                    String supplierId = parts[0];
                    String supplierName = parts[1];
                    String contactNumber = parts[2];
                    String email = parts[3].trim();
                    List<String> itemIds = Arrays.asList(parts[4].replace("[", "").replace("]", "").split("[,;]")); //Will handle both ',' and ';'
                    String paymentMethod = parts[5];
                    String shippingMethod = parts[6];
                    int supplyCapacity = Integer.parseInt(parts[7].trim());
                    int leadTime = Integer.parseInt(parts[8].trim());

                    //Add supplier
                    Supplier supplier = new Supplier(supplierId, supplierName, contactNumber, email, itemIds, paymentMethod, shippingMethod, supplyCapacity, leadTime);
                    allSuppliers.add(supplier);
                    System.out.println("Loaded Supplier: " + line);
                } catch (Exception e) {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        }
    }


    //Get all suppliers
    public static List<Supplier> getAllSuppliers() {
        return new ArrayList<>(allSuppliers); // Return a copy of the allSuppliers list
    }

    //Fetch suppliers by name
    public static List<Supplier> searchSuppliers(String searchText) {
        return allSuppliers.stream()
                .filter(supplier -> supplier.getSupplierId().toLowerCase().contains(searchText.toLowerCase()) ||
                                    supplier.getSupplierName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    //Static method to add a supplier
    public static boolean addSupplier(String name, String contactNumber, String email, List<String> itemIds,
                                       String paymentMethod, String shippingMethod, String supplyCapacity, String leadTime) {
        for (Supplier supplier : allSuppliers) {
            if (supplier.getSupplierName().equalsIgnoreCase(name)) {
                return false;
            }
        }

        //Generate a new supplier ID
        String supplierId = generateSupplierId();

        Supplier newSupplier = new Supplier(supplierId, name, contactNumber, email, itemIds, paymentMethod, shippingMethod, supplyCapacity, leadTime);

        allSuppliers.add(newSupplier);
        saveSuppliersToFile("src/User_data/suppliers.txt");
        return true; 
    }

    //Delete supplier 
    public static boolean deleteSupplierById(String supplierId) {
        for (Supplier supplier : allSuppliers) {
            if (supplier.getSupplierId().equals(supplierId)) {
                allSuppliers.remove(supplier);

                saveSuppliersToFile("src/User_data/suppliers.txt");
                return true; 
            }
        }
        return false; 
    }

}
