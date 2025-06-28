package java_assginment.Finance_Manager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MakePayment extends javax.swing.JFrame {

    public MakePayment() {
        initComponents();
        loadPurchaseOrders(); // Load data into the table
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void loadPurchaseOrders() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear the existing rows
        try (BufferedReader reader = new BufferedReader(new FileReader("src/User_data/PurchaseOrders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", "); // Adjusted to handle cases without spaces after commas
                String paymentStatus = parts[8]; // part[8] is Payment Status
                if ("Approved".equals(paymentStatus) || "Paid".equals(paymentStatus)) {
                    model.addRow(parts); // Add the row to the table if it matches the filter
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading Purchase Orders: " + e.getMessage());
        }
    }

    private void updatePurchaseOrderStatus(String poID, String newStatus) {
        try {
            List<String> lines = new ArrayList<>();
            boolean updated = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("src/User_data/PurchaseOrders.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(poID + ",")) {
                        String[] parts = line.split(",\\s*");
                        parts[8] = newStatus; // Update status
                        line = String.join(", ", parts); // Recreate the line with updated status
                        updated = true;
                    }
                    lines.add(line);
                }
            }

            if (!updated) {
                JOptionPane.showMessageDialog(this, "PO ID not found: " + poID);
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/User_data/PurchaseOrders.txt"))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine(); // Ensure each line ends with a new line
                }
            }
            // Reload purchase orders to update the table view
            loadPurchaseOrders();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating Purchase Orders: " + e.getMessage());
        }
    }
    
    public String generatePaymentID() {
    int maxID = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader("src/User_data/payment.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replace("\"", "").trim(); // Remove quotes and trim spaces
            String[] parts = line.split(",");
            if (parts.length > 0) {
                String idPart = parts[0].trim(); // Extract the payment ID
                if (idPart.startsWith("PM")) {
                    try {
                        int idNumber = Integer.parseInt(idPart.substring(2)); // Extract numeric part of ID
                        if (idNumber > maxID) {
                            maxID = idNumber; // Update maxID if a larger number is found
                        }
                    } catch (NumberFormatException e) {
                        // Ignore lines with invalid ID formats
                    }
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading payment.txt: " + e.getMessage());
    }

    // Generate the next payment ID
    int nextID = maxID + 1;
    return "PM" + String.format("%03d", nextID);
}
    
    private String getSupplierName(String supplierID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/User_data/suppliers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*", -1);
                String currentSupplierID = parts[0].trim();
                System.out.println("Checking supplier ID: " + currentSupplierID); // Debugging line
                if (supplierID.equals(currentSupplierID)) {
                    return parts[1].trim();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error retrieving supplier information: " + e.getMessage());
        }
        return null;
    }

    
    // Method to get the payment date for a specific PO ID
    private String getPaymentDateFromFile(String poID) {
        String paymentDate = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("payment.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove quotes and trim spaces
                line = line.replace("\"", "").trim();

                // Split the line by commas
                String[] parts = line.split(",");

                // Extract PO ID from the second field (index 1)
                String poIDFromFile = parts[1].trim();

                if (poIDFromFile.equals(poID)) {
                    // Extract payment date from the fourth field (index 3)
                    paymentDate = parts[3].trim();
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paymentDate;  // Return null if not found
    }
    
    
    public void recordPayment(String poID, String supplierID, double amountPaid) {
        // Validate inputs
        if (poID == null || poID.isEmpty() || supplierID == null || supplierID.isEmpty() || amountPaid <= 0) {
            System.out.println("Error: Invalid input values.");
            return;
        }

        // Generate a new payment ID
        String paymentID = generatePaymentID();

        // Get current date
        String paymentDate = LocalDate.now().toString();

        // Get supplier name from supplierID
        String supplierName = getSupplierName(supplierID);
        if (supplierName == null) {
            System.out.println("Error: Supplier not found for ID: " + supplierID);
            return;
        }

        // Check for duplicate payment (optional if required)
        if (isDuplicatePayment(poID)) {
            System.out.println("Error: Duplicate payment detected for PO ID: " + poID);
            return;
        }

        // Prepare the data to be saved in the file
        String paymentRecord = String.format("\"%s\", \"%s\", \"%s\", \"%s\", %.2f", 
                                              paymentID, poID, supplierName, paymentDate, amountPaid);

        // Write to payment.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("payment.txt", true))) {
            writer.write(paymentRecord);
            writer.newLine();
            System.out.println("Payment record saved successfully: " + paymentRecord);  // Optional debug log
        } catch (IOException e) {
            System.out.println("Error writing to payment.txt: " + e.getMessage());
        }
    }

    // Example method to check for duplicate payments
    private boolean isDuplicatePayment(String poID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("payment.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(poID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading payment.txt: " + e.getMessage());
        }
        return false;
    }

    private String getPaymentID() {
        // Get selected row in the table
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row.");
            return null;
        }

        // Extract PO ID from the table (index 0)
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String poID = (String) model.getValueAt(selectedRow, 0);

        String paymentID = null;

        // Read payment.txt and find the corresponding Payment ID for the selected PO ID
        try (BufferedReader reader = new BufferedReader(new FileReader("payment.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("\"", "").trim(); // Clean up the line
                String[] parts = line.split(","); // Split the line by commas

                if (parts.length > 1) {
                    String poIDFromFile = parts[1].trim(); // Extract PO ID from file (index 1)
                    if (poIDFromFile.equals(poID)) {
                        paymentID = parts[0].trim(); // Extract Payment ID from the file (index 0)
                        return paymentID;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading payment.txt: " + e.getMessage());
        }

        return paymentID; // Return the Payment ID (or null if not found)
    }
    
    // The updated generateReceipt method
    private void generateReceipt(String supplierName, String paymentID, String paymentDate, double amountPaid) {
        String receiptText = generateReceiptText(supplierName, paymentID, paymentDate, amountPaid);
        // Display the generated receipt in a dialog
        JOptionPane.showMessageDialog(this, receiptText, "Payment Receipt", JOptionPane.INFORMATION_MESSAGE);
    }


    // Helper method to generate receipt text
    private String generateReceiptText(String supplierName, String paymentID, String paymentDate, double amountPaid) {
        return "Receipt\n" +
               "-------------\n" +
               "Supplier Name: " + supplierName + "\n" +
               "Payment ID: " + paymentID + "\n" +
               "Payment Date: " + paymentDate + "\n" +
               "Amount Paid: RM " + String.format("%.2f", amountPaid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonPayment = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jButtonReceipt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(199, 213, 205));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchase Orders Eligible for Payment");

        jButtonPayment.setText("Make Payment");
        jButtonPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaymentActionPerformed(evt);
            }
        });

        jButtonMenu.setText("Back to Main Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonReceipt.setText("Generate Receipt");
        jButtonReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReceiptActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "orderID", "itemID", "itemName", "supplierID", "quantity", "unitPrice", "totalPrice", "date", "paymentStatus", "deliveryStatus"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonPayment)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonReceipt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMenu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPayment)
                    .addComponent(jButtonMenu)
                    .addComponent(jButtonReceipt))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaymentActionPerformed
        // Get selected row in the table
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to make payment.");
            return;
        }

        // Extract PO details from the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String poID = (String) model.getValueAt(selectedRow, 0); // Assuming PO ID is in the first column
        String supplierID = (String) model.getValueAt(selectedRow, 3); // Assuming supplierID is in the 4th column
        String paymentStatus = (String) model.getValueAt(selectedRow, 8); // Assuming paymentStatus is in the 9th column
        double totalPrice = Double.parseDouble((String) model.getValueAt(selectedRow, 6)); // Assuming totalPrice is in the 7th column

        // Check if the payment has already been made
        if ("Paid".equalsIgnoreCase(paymentStatus)) {
            JOptionPane.showMessageDialog(this, "Payment has already been made for this Purchase Order.");
            return;
        }

        // Record payment in the payment.txt file
        recordPayment(poID, supplierID, totalPrice);

        // Update the purchase order status to "Paid"
        updatePurchaseOrderStatus(poID, "Paid");

        JOptionPane.showMessageDialog(this, "Payment successfully recorded.");

    }//GEN-LAST:event_jButtonPaymentActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        MainMenuFinance mainMenu = new MainMenuFinance(); // Replace with your main menu JFrame class
        mainMenu.setVisible(true);
        dispose(); // Close the current panel
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceiptActionPerformed
        // Get the selected row index
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a purchase order to generate the receipt.");
            return;
        }

        // Get the PO ID and payment status from the selected row
        String poID = (String) jTable1.getValueAt(selectedRow, 0);  // Assuming PO ID is in the first column
        String paymentStatus = (String) jTable1.getValueAt(selectedRow, 8);  // Assuming Payment Status is in the 9th column (index 8)

        // Check if the payment status is "Paid"
        if ("Paid".equals(paymentStatus)) {
            // Get other necessary details (e.g., supplier name, payment ID, amount paid, and payment date)
            String supplierID = (String) jTable1.getValueAt(selectedRow, 3);  // Assuming supplier ID is in the 4th column
            double amountPaid = Double.parseDouble((String) jTable1.getValueAt(selectedRow, 6));  // Assuming Amount Paid is in the 7th column (index 6)
            String paymentDate = getPaymentDateFromFile(poID);  // Fetch the payment date from the payment.txt file
            if (paymentDate == null) {
                JOptionPane.showMessageDialog(this, "Payment date is missing for the selected PO.");
                return;
            }
            String supplierName = getSupplierName(supplierID);  // Fetch the supplier name from the supplier.txt file

            // Generate the receipt
            generateReceipt(supplierName, getPaymentID(), paymentDate, amountPaid);
        } else {
            JOptionPane.showMessageDialog(this, "Receipt can only be generated for orders with 'Paid' status.");
        }                                           
    }//GEN-LAST:event_jButtonReceiptActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakePayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPayment;
    private javax.swing.JButton jButtonReceipt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
