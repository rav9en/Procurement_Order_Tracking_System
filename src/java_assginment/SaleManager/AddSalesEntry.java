
package java_assginment.SaleManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AddSalesEntry extends javax.swing.JFrame {
    
    private final String FILE_Items = "items.txt";
    
    private DefaultTableModel model;
    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<SalesEntry> SEList= new ArrayList<SalesEntry>();
    
    public AddSalesEntry() {
        initComponents();
        model = (DefaultTableModel) tblAddSE.getModel();
        loadItems();  // Load items from file
        fillSalesEntry();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAddSE = new javax.swing.JPanel();
        lblAddSE = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAddSE = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblItemID = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlAddSE.setBackground(new java.awt.Color(255, 204, 204));

        lblAddSE.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblAddSE.setText("Add Sales Entry");

        tblAddSE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item ID", "Name", "Supplier ID", "Price (RM)", "Dimension", "Reorder Level", "Qty In Stock", "Qty Sold"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAddSE);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblItemID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItemID.setText("Enter Item ID:");

        lblQty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQty.setText("Enter Quantity Sold: ");

        txtItemID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemIDActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddSELayout = new javax.swing.GroupLayout(pnlAddSE);
        pnlAddSE.setLayout(pnlAddSELayout);
        pnlAddSELayout.setHorizontalGroup(
            pnlAddSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddSELayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(21, 21, 21))
            .addGroup(pnlAddSELayout.createSequentialGroup()
                .addGroup(pnlAddSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddSELayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(lblAddSE))
                    .addGroup(pnlAddSELayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddSELayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addGroup(pnlAddSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlAddSELayout.createSequentialGroup()
                                .addComponent(lblItemID)
                                .addGap(18, 18, 18)
                                .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAddSELayout.createSequentialGroup()
                                .addComponent(lblQty)
                                .addGap(18, 18, 18)
                                .addComponent(txtQty))))
                    .addGroup(pnlAddSELayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlAddSELayout.setVerticalGroup(
            pnlAddSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddSELayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblAddSE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pnlAddSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItemID))
                .addGap(18, 18, 18)
                .addGroup(pnlAddSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQty)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAddSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAddSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemIDActionPerformed
    }//GEN-LAST:event_txtItemIDActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        SalesEntryGUI  jf1= new SalesEntryGUI ();
        jf1.show(); //display SalesEntryGUI 
        
        dispose(); //close current frame after open MenuGUI
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String itemId = txtItemID.getText().trim();
    String quantitySoldText = txtQty.getText().trim();

    // Validate inputs
    if (itemId.isEmpty() || quantitySoldText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Item ID and Quantity Sold cannot be empty.");
        return;
    }

    int quantitySold;
    try {
        quantitySold = Integer.parseInt(quantitySoldText);
        if (quantitySold <= 0) {
            throw new NumberFormatException();
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Quantity Sold must be a positive number.");
        return;
    }

    Item selectedItem = null; // Declare inside method

    // Find the item by ID
    for (Item item : itemList) {
        if (item.getItemId().equals(itemId)) {
            selectedItem = item;
            break;
        }
    }

    if (selectedItem == null) {
        JOptionPane.showMessageDialog(this, "Item ID not found.");
        return;
    }

    // Check if there is enough stock to sell
    if (selectedItem.getQuantityInStock() < quantitySold) {
        JOptionPane.showMessageDialog(this, "Insufficient stock. Available stock: " + selectedItem.getQuantityInStock());
        return;
    }

    // Generate a new sales entry ID
    String salesEntryId = generateSalesEntryId();

    // Create new sales entry
    SalesEntry newEntry = new SalesEntry(
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
    SEList.add(newEntry);

    // Save sales entries to file
    SalesEntry.saveSalesEntriesToFile(SEList);

    // Update the table
    fillSalesEntry();

    // Show success message
    JOptionPane.showMessageDialog(this, "Sales Entry added: " + newEntry.getSalesEntryId());
    }//GEN-LAST:event_btnSaveActionPerformed
    
    // Method to load items from the file
private void loadItems() {
    try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"))) {
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
    public void fillSalesEntry() {
        model.setRowCount(0);
        SalesEntry temp = new SalesEntry();
        SEList = temp.loadSalesEntries();
        
        for (SalesEntry s : SEList) {
            Object[] myRow = {
                s.getSalesEntryId(),
                s.getItemId(),
                s.getItemName(),
                s.getSupplierId(),
                s.getPrice(),
                s.getDimensions(),
                s.getReorderLevel(),
                s.getQuantityInStock(),
                s.getQuantitySold()
            };
            model.addRow(myRow);
        }
    }
    

     private String generateSalesEntryId() {
        int lastId = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("sales_entries.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].startsWith("SE")) {
                    String numericPart = parts[0].substring(2); // Extract numeric part of SE ID
                    lastId = Math.max(lastId, Integer.parseInt(numericPart));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return "SE" + String.format("%03d", lastId + 1);
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
            java.util.logging.Logger.getLogger(AddSalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSalesEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSalesEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddSE;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblQty;
    private javax.swing.JPanel pnlAddSE;
    private javax.swing.JTable tblAddSE;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
