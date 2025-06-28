package java_assginment.SaleManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Requisition {
    private String requisitionId;
    private String itemId;
    private String itemName;
    private String supplierId;
    private int quantityToOrder;
    private ArrayList<Requisition> Rlist= new ArrayList<Requisition>();
    

    public Requisition() {
    }

    public Requisition(String itemId, String itemName, String supplierId, int quantityToOrder) {
        this.requisitionId = generateRequisitionId("src/assignment/requisitions.txt");
        this.itemId = itemId;
        this.itemName = itemName;
        this.supplierId = supplierId;
        this.quantityToOrder = quantityToOrder;
    }
    
    public Requisition(String requisitionId, String itemId, String itemName, String supplierId, int quantityToOrder) {
        this.requisitionId = requisitionId;  // Use the requisitionId from file
        this.itemId = itemId;
        this.itemName = itemName;
        this.supplierId = supplierId;
        this.quantityToOrder = quantityToOrder;
    }
    
    // Method to generate requisition ID (using last ID from file)
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

    @Override
    public String toString() {
        return requisitionId + "," + itemId + "," + itemName + "," + supplierId + "," + quantityToOrder;
    }

    public String getRequisitionId() {
        return requisitionId;
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

    public int getQuantityToOrder() {
        return quantityToOrder;
    }

    public ArrayList<Requisition> getSlist() {
        return Rlist;
    }

    public static void saveToFile(Requisition requisition, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(requisition.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing requisition to file: " + e.getMessage());
        }
    }
    
    public ArrayList<Requisition> loadRequisition() {
    ArrayList<Requisition> Slist = new ArrayList<>();  // Initialize the list
    File Flist = new File("src/assignment/requisitions.txt");
    try {
        Scanner Sc = new Scanner(Flist);
        while (Sc.hasNextLine()) {
            String Line = Sc.nextLine();
            String[] parts = Line.split(",");
            
            // Ensure the array has the expected number of elements
            if (parts.length == 5) {
                String ReqID = parts[0];
                String ItID = parts[1];
                String ItName = parts[2];
                String SupID = parts[3];
                int Qty = Integer.parseInt(parts[4]);  // Parse as int
                
                Requisition Temp = new Requisition(ReqID, ItID, ItName, SupID, Qty);
                Slist.add(Temp);
            }
        }
        Sc.close();
    } catch (Exception Ex) {
        System.err.println("Error reading file: " + Ex.getMessage());
    }
    return Slist;
}

    void addRow(Object[] myRow) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
