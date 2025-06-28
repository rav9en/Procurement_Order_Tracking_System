package java_assginment.SaleManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class RequisitionGUI extends javax.swing.JFrame {
    private DefaultTableModel model;
    private ArrayList<Requisition> RList = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();


    public RequisitionGUI() {       
        initComponents();
        model = (DefaultTableModel) tblRequisition.getModel();
        loadItems();  // Load items from file
        fillRequisition();  // Fill requisitions into the table
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRequisition = new javax.swing.JPanel();
        lblCreateRequisition = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequisition = new javax.swing.JTable();
        lblItemID = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlRequisition.setBackground(new java.awt.Color(255, 204, 204));

        lblCreateRequisition.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblCreateRequisition.setText("Create Requisitions");

        tblRequisition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Requisition ID", "Item ID", "Item Name", "Supplier ID", "Qty To Order"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequisition);

        lblItemID.setText("Enter Item ID: ");

        txtItemID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemIDActionPerformed(evt);
            }
        });

        lblQuantity.setText("Enter Quantity to Order: ");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRequisitionLayout = new javax.swing.GroupLayout(pnlRequisition);
        pnlRequisition.setLayout(pnlRequisitionLayout);
        pnlRequisitionLayout.setHorizontalGroup(
            pnlRequisitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRequisitionLayout.createSequentialGroup()
                .addGroup(pnlRequisitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRequisitionLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRequisitionLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addGroup(pnlRequisitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRequisitionLayout.createSequentialGroup()
                                .addComponent(lblQuantity)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRequisitionLayout.createSequentialGroup()
                                .addComponent(lblItemID)
                                .addGap(18, 18, 18)
                                .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRequisitionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRequisitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRequisitionLayout.createSequentialGroup()
                        .addComponent(lblCreateRequisition)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRequisitionLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(19, 19, 19))))
            .addGroup(pnlRequisitionLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(btnSave)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlRequisitionLayout.setVerticalGroup(
            pnlRequisitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRequisitionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblCreateRequisition)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlRequisitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemID)
                    .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRequisitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRequisition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRequisition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemIDActionPerformed
    }//GEN-LAST:event_txtItemIDActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuGUI jf1= new MenuGUI();
        jf1.show(); //display MenuGUI
        
        dispose(); //close current frame after open MenuGUI
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    // Get input from text fields
    String itemId = txtItemID.getText().trim();
    String quantityStr = txtQuantity.getText().trim();

    if (itemId.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Item ID cannot be empty.");
        return;
    }

    if (quantityStr.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Quantity cannot be empty.");
        return;
    }

    try {
        int quantity = Integer.parseInt(quantityStr);
        if (quantity <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Quantity must be greater than zero.");
            return;
        }

        // Retrieve the item details from items list or file
        Item item = getItemById(itemId);
        if (item == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Item ID not found.");
            return;
        }

        // Create a new requisition with the actual item details
        Requisition newRequisition = new Requisition(
            itemId,
            item.getItemName(),  // Get item name from the Item object
            item.getSupplierId(),  // Get supplier ID from the Item object
            quantity
        );

        // Add to the requisition list
        RList.add(newRequisition);

        // Save the single requisition to the file
        Requisition.saveToFile(newRequisition, "src/User_data/requisitions.txt"); // Provide the actual file path

        // Update the table
        Object[] row = {
            newRequisition.getRequisitionId(),
            newRequisition.getItemId(),
            newRequisition.getItemName(),
            newRequisition.getSupplierId(),
            newRequisition.getQuantityToOrder()
        };
        model.addRow(row);

        javax.swing.JOptionPane.showMessageDialog(this, "Requisition created successfully!");
        txtItemID.setText(""); // Clear input fields
        txtQuantity.setText("");
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Invalid quantity entered. Please enter a valid number.");
    }



    }//GEN-LAST:event_btnSaveActionPerformed


// Method to load items from the file
private void loadItems() {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/User_data/items.txt"))) { // Use relative path here
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");  // Assuming your file is comma-separated
            if (parts.length == 7) {  // itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock
                String itemId = parts[0].trim();
                String itemName = parts[1].trim();
                String supplierId = parts[2].trim();
                // Remove the "RM" prefix and parse the price
                double price = Double.parseDouble(parts[3].trim().replaceAll("[^\\d.]", ""));
                String dimensions = parts[4].trim();
                int reorderLevel = Integer.parseInt(parts[5].trim());
                int quantityInStock = Integer.parseInt(parts[6].trim());
                itemList.add(new Item(itemId, itemName, supplierId, price, dimensions, reorderLevel, quantityInStock));
            }
        }
    } catch (IOException e) {
        System.err.println("Error loading items from file: " + e.getMessage());
    }
}



private Item getItemById(String itemId) {
    for (Item item : itemList) {
        if (item.getItemId().equals(itemId)) {
            return item;
        }
    }
    return null;  // Return null if item is not found
}

    public void fillRequisition() {
        // Clear the existing rows in the table
        model.setRowCount(0);

        // Load requisitions from the file
        Requisition temp = new Requisition();
        RList = temp.loadRequisition();

        // Populate the table with requisition data
        for (Requisition r : RList) {
            Object[] row = {
                r.getRequisitionId(),
                r.getItemId(),
                r.getItemName(),
                r.getSupplierId(),
                r.getQuantityToOrder()
            };
            model.addRow(row);
        }
    }
    
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
            java.util.logging.Logger.getLogger(RequisitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequisitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequisitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequisitionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequisitionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCreateRequisition;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JPanel pnlRequisition;
    private javax.swing.JTable tblRequisition;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
