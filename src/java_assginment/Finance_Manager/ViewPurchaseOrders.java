/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_assginment.Finance_Manager;

import javax.swing.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class ViewPurchaseOrders extends javax.swing.JFrame {

    /**
     * Creates new form ViewPurchaseOrders
     */
    public ViewPurchaseOrders() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadPurchaseOrders();  // Load purchase orders into the table
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    // Method to load purchase orders from file and display them in the table
    private void loadPurchaseOrders() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Clear any existing rows in the table
    model.setRowCount(0);
    
    try {
        // Open the text file (replace with your actual file path)
        File file = new File("src/User_data/PurchaseOrders.txt");
        Scanner scanner = new Scanner(file);

        // Read the file line by line and parse the data
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(","); // Assuming CSV format (comma-separated)

            // If there are exactly 10 columns in each row
            if (data.length == 10) {
                // Trim any extra spaces before parsing
                String orderID = data[0].trim();
                String itemID = data[1].trim();
                String itemName = data[2].trim();
                String supplierID = data[3].trim();
                int quantity = Integer.parseInt(data[4].trim()); // Trim and then parse
                double unitPrice = Double.parseDouble(data[5].trim()); // Trim and then parse
                double totalPrice = Double.parseDouble(data[6].trim()); // Trim and then parse
                String date = data[7].trim();
                String paymentStatus = data[8].trim();
                String deliveryStatus = data[9].trim();

                Object[] row = {
                    orderID,
                    itemID,
                    itemName,
                    supplierID,
                    quantity,
                    unitPrice,
                    totalPrice,
                    date,
                    paymentStatus,
                    deliveryStatus
                };
                model.addRow(row);  // Add row to the table model
            }
        }
        scanner.close();  // Close the scanner after reading the file
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error loading purchase orders: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error parsing numbers: " + e.getMessage());
    }
}
    
    private void updatePaymentStatusInFile(String orderId, String status) {
        File file = new File("src/User_data/PurchaseOrders.txt");
        File tempFile = new File("src/User_data/tempPurchaseOrders.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean isUpdated = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Split by comma
                // Debugging output
                System.out.println("Processing line: " + line);

                if (data[0].trim().equals(orderId)) { // Match the order ID
                    System.out.println("Updating status for Order ID: " + orderId + " to " + status);
                    data[8] = " " + status; // Update the payment status (column 9, index 8)
                    isUpdated = true;
                }

                writer.write(String.join(",", data)); // Write updated or original line
                writer.newLine();
            }

            if (isUpdated) {
                System.out.println("Order status updated successfully.");
            } else {
                System.out.println("Order ID not found. No update performed.");
            }

        } catch (IOException e) {
            System.err.println("Error updating the file: " + e.getMessage());
        }

        // Replace the original file with the updated file
        if (file.delete()) {
            tempFile.renameTo(file);
            System.out.println("File replaced successfully.");
        } else {
            System.err.println("Failed to delete the original file.");
        }
    }

    private void refreshTable() {
        // Reload the data from the file and refresh the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Clear the current table data

        // Read the file and add data to the table
        try (BufferedReader reader = new BufferedReader(new FileReader("src/User_data/PurchaseOrders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);  // Add row to table
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading data from file.");
        }
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
        jButtonBackToMenu = new javax.swing.JButton();
        jButtonReject = new javax.swing.JButton();
        jButtonApprove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(212, 231, 212));

        jButtonBackToMenu.setText("Back to Menu");
        jButtonBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackToMenuActionPerformed(evt);
            }
        });

        jButtonReject.setText("Reject");
        jButtonReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRejectActionPerformed(evt);
            }
        });

        jButtonApprove.setText("Approve");
        jButtonApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApproveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Purchase Orders");

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
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButtonApprove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonReject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBackToMenu)
                    .addComponent(jButtonReject)
                    .addComponent(jButtonApprove))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackToMenuActionPerformed
        MainMenuFinance mainMenu = new MainMenuFinance(); // Replace with your main menu JFrame class
        mainMenu.setVisible(true);
        dispose(); // Close the current panel
    }//GEN-LAST:event_jButtonBackToMenuActionPerformed

    private void jButtonRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRejectActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            // Get the order ID from the selected row
            String orderId = (String) jTable1.getValueAt(selectedRow, 0);  // Assuming orderID is at index 0
            updatePaymentStatusInFile(orderId, "Rejected");  // Update the payment status to "Rejected"
            JOptionPane.showMessageDialog(this, "Order " + orderId + " has been rejected.");
            refreshTable();  // Refresh the table to show the updated status
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Purchase Order to reject.");
        }
    }//GEN-LAST:event_jButtonRejectActionPerformed

    private void jButtonApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApproveActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            // Get the order ID from the selected row
            String orderId = (String) jTable1.getValueAt(selectedRow, 0);  // Assuming orderID is at index 0
            updatePaymentStatusInFile(orderId, "Approved");  // Update the payment status to "Approved"
            JOptionPane.showMessageDialog(this, "Order " + orderId + " has been approved.");
            refreshTable();  // Refresh the table to show the updated status
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Purchase Order to approve.");
        }
    }//GEN-LAST:event_jButtonApproveActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1PropertyChange

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
            java.util.logging.Logger.getLogger(ViewPurchaseOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPurchaseOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPurchaseOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPurchaseOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPurchaseOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApprove;
    private javax.swing.JButton jButtonBackToMenu;
    private javax.swing.JButton jButtonReject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
