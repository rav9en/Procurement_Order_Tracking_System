/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_assginment.InventoryManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

        
public class Update_Stock extends javax.swing.JFrame {
    private DefaultTableModel receivedItemsTableModel;
    private List<String[]> receivedItems;

    
    public Update_Stock(){
        initComponents();
        loadReceivedItems();
    }


    private void loadReceivedItems(){
        receivedItems = new ArrayList<>();
        File purchaseOrderFile = new File("src/User_data/PurchaseOrders.txt");

        
        try (BufferedReader reader = new BufferedReader(new FileReader(purchaseOrderFile))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] orderDetails = line .split(", ");
                
                if (orderDetails.length >= 4 && orderDetails[9].trim().equalsIgnoreCase("Received")) {
                    String orderID = orderDetails[0].trim();  
                    String itemID = orderDetails[1].trim(); 
                    String itemName = orderDetails[2].trim(); 
                    String supplierID = orderDetails[3].trim(); 
                    String quantity = orderDetails[4].trim(); 
                    String deliveryStatus = orderDetails[9].trim(); 
                    receivedItems.add(new String[]{orderID, itemID, itemName, supplierID, quantity, deliveryStatus});
                }
            }
            
            receivedItemsTableModel = new DefaultTableModel(new Object[]{"orderID", "itemID", "itemName", "supplierID", "quantity", "deliveryStatus"}, 0);
            for (String[] item : receivedItems){
                receivedItemsTableModel.addRow(item);
            }

            
            tblReceivedOrders.setModel(receivedItemsTableModel);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading purchase orders: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Method to update stock in items.txt
    private void updateItemStock() {
        String itemId = txtItemID_UpdateStock.getText().trim(); 
        String quantityStr = txtItemQuantity_UpdateStock.getText().trim();

        if (itemId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quantity cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Read and update the items directly in the same file
        File itemFile = new File("src/User_data/items.txt");
        List<String> updatedLines = new ArrayList<>();
        boolean itemFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(itemFile))) {
            String line;

            //Read each line and update the stock if the item ID matches
            while ((line = reader.readLine()) != null) {
                String[] itemDetails = line.split(","); 

                if (itemDetails.length >= 7) {
                    String currentItemId = itemDetails[0].trim(); 

                    if (currentItemId.equals(itemId)) {
                        try {
                            int currentStock = Integer.parseInt(itemDetails[6].trim()); 
                            int newStock = currentStock + quantity; 
                            itemDetails[6] = String.valueOf(newStock); 
                            itemFound = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Invalid stock format in file for Item ID: " + itemId, "Error", JOptionPane.ERROR_MESSAGE);
                            updatedLines.add(line); 
                            continue;
                        }
                    }
                }

                updatedLines.add(String.join(",", itemDetails));
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading items file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!itemFound) {
            JOptionPane.showMessageDialog(this, "Item ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Write the updated lines back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(itemFile))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Stock updated successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing items file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    //Method to delete selected rows from the table (not the file)
    private void deleteSelectedRows() {
        int[] selectedRows = tblReceivedOrders.getSelectedRows();
            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this, "Please select rows to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (int i = selectedRows.length - 1; i >= 0; i--) {
                receivedItems.remove(selectedRows[i]); //Remove from the rows or list
                receivedItemsTableModel.removeRow(selectedRows[i]); //Remove from the table model
            }
        JOptionPane.showMessageDialog(this,"Selected rows have been deleted from table.");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReceivedOrders = new javax.swing.JTable();
        btnUpdateItem_UpdateStock = new javax.swing.JButton();
        lblUpdateStock = new javax.swing.JLabel();
        lblItemQuantity_UpdateStock = new javax.swing.JLabel();
        txtItemQuantity_UpdateStock = new javax.swing.JTextField();
        btnDelete_ReceivedStock = new javax.swing.JButton();
        txtItemID_UpdateStock = new javax.swing.JTextField();
        lblItemID_UpdateStock = new javax.swing.JLabel();
        btnBackToMenuFromUpdateStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        tblReceivedOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Item ID", "Item Name", "Supplier ID", "Quantity", "Delivery Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReceivedOrders);

        btnUpdateItem_UpdateStock.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnUpdateItem_UpdateStock.setText("Update");
        btnUpdateItem_UpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateItem_UpdateStockActionPerformed(evt);
            }
        });

        lblUpdateStock.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblUpdateStock.setText("Update Stock");

        lblItemQuantity_UpdateStock.setText("Quantity");

        txtItemQuantity_UpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemQuantity_UpdateStockActionPerformed(evt);
            }
        });

        btnDelete_ReceivedStock.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnDelete_ReceivedStock.setText("Delete");
        btnDelete_ReceivedStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_ReceivedStockActionPerformed(evt);
            }
        });

        lblItemID_UpdateStock.setText("Item ID");

        btnBackToMenuFromUpdateStock.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnBackToMenuFromUpdateStock.setText("Back To Menu");
        btnBackToMenuFromUpdateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuFromUpdateStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(lblUpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnUpdateItem_UpdateStock)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblItemQuantity_UpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblItemID_UpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtItemID_UpdateStock, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                        .addComponent(txtItemQuantity_UpdateStock))))
                            .addGap(68, 68, 68)
                            .addComponent(btnDelete_ReceivedStock)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBackToMenuFromUpdateStock))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblUpdateStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemID_UpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItemID_UpdateStock))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemQuantity_UpdateStock)
                    .addComponent(txtItemQuantity_UpdateStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateItem_UpdateStock)
                    .addComponent(btnDelete_ReceivedStock)
                    .addComponent(btnBackToMenuFromUpdateStock))
                .addGap(29, 29, 29))
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

    private void txtItemQuantity_UpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemQuantity_UpdateStockActionPerformed
        
    }//GEN-LAST:event_txtItemQuantity_UpdateStockActionPerformed

    private void btnDelete_ReceivedStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_ReceivedStockActionPerformed
        deleteSelectedRows();

    }//GEN-LAST:event_btnDelete_ReceivedStockActionPerformed

    private void btnUpdateItem_UpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateItem_UpdateStockActionPerformed
        updateItemStock(); 
    }//GEN-LAST:event_btnUpdateItem_UpdateStockActionPerformed

    private void btnBackToMenuFromUpdateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuFromUpdateStockActionPerformed
        new Inventory_Interface().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackToMenuFromUpdateStockActionPerformed
    
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
            java.util.logging.Logger.getLogger(Update_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToMenuFromUpdateStock;
    private javax.swing.JButton btnDelete_ReceivedStock;
    private javax.swing.JButton btnUpdateItem_UpdateStock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItemID_UpdateStock;
    private javax.swing.JLabel lblItemQuantity_UpdateStock;
    private javax.swing.JLabel lblUpdateStock;
    private javax.swing.JTable tblReceivedOrders;
    private javax.swing.JTextField txtItemID_UpdateStock;
    private javax.swing.JTextField txtItemQuantity_UpdateStock;
    // End of variables declaration//GEN-END:variables
}
