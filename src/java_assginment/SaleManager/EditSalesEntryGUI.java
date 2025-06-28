
package java_assginment.SaleManager;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class EditSalesEntryGUI extends javax.swing.JFrame {

    private DefaultTableModel m;    
    private ArrayList<SalesEntry> SEList= new ArrayList<SalesEntry>();

    public EditSalesEntryGUI() {
        initComponents();
        m=(DefaultTableModel)tblSE.getModel();
        fillSalesEntry();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditSE = new javax.swing.JPanel();
        lblEditSE = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSE = new javax.swing.JTable();
        lblSEID = new javax.swing.JLabel();
        lblNewQtySold = new javax.swing.JLabel();
        txtSEID = new javax.swing.JTextField();
        txtNewQtySold = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlEditSE.setBackground(new java.awt.Color(255, 204, 204));

        lblEditSE.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblEditSE.setText("Edit Sales Entry");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblSE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item ID", "Name", "Supplier ID", "Price (RM)", "Dimension", "Reorder Level", "Qty in Stock", "Qty Sold"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSE);

        lblSEID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSEID.setText("Sales Entry ID:");

        lblNewQtySold.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNewQtySold.setText("New Qty Sold: ");

        txtSEID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSEIDActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditSELayout = new javax.swing.GroupLayout(pnlEditSE);
        pnlEditSE.setLayout(pnlEditSELayout);
        pnlEditSELayout.setHorizontalGroup(
            pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditSELayout.createSequentialGroup()
                .addGroup(pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditSELayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEditSELayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSEID)
                            .addComponent(lblNewQtySold)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSEID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewQtySold, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEditSELayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(lblEditSE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlEditSELayout.setVerticalGroup(
            pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditSELayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblEditSE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSEID)
                    .addComponent(txtSEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditSELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewQtySold)
                    .addComponent(txtNewQtySold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBack)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditSE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //open SalesEntryGUI
        SalesEntryGUI  jf1= new SalesEntryGUI ();
        jf1.show(); //display SalesEntryGUI 
        
        dispose(); //close current frame after open SalesEntryGUI 
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSEIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSEIDActionPerformed
    }//GEN-LAST:event_txtSEIDActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String salesEntryId = txtSEID.getText().trim();
        String newQtySoldText = txtNewQtySold.getText().trim();

    if (salesEntryId.isEmpty() || newQtySoldText.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter all fields!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int newQtySold = Integer.parseInt(newQtySoldText);
        boolean found = false;

        for (SalesEntry entry : SEList) {
            if (entry.getSalesEntryId().equals(salesEntryId)) {
                entry.setQuantitySold(newQtySold); // Update the quantity
                found = true;
                break;
            }
        }

        if (found) {
            // Convert SEList to a single String
            StringBuilder serializedEntries = new StringBuilder();
            for (SalesEntry entry : SEList) {
                serializedEntries.append(entry.toString()).append("\n"); // Assuming toString formats correctly
            }

            // Save the serialized String to file
            SalesEntry.saveSalesEntriesToFile(SEList);
            javax.swing.JOptionPane.showMessageDialog(this, "Sales Entry updated successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            // Refresh the table
            fillSalesEntry();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Sales Entry not found!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter a valid quantity!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    public void fillSalesEntry() {
    // Clear the table rows
    m.setRowCount(0);

    // Load items from the file
    SalesEntry Temp = new SalesEntry();
    SEList = Temp.loadSalesEntries();

    // Populate the table
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
        m.addRow(myRow);
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
            java.util.logging.Logger.getLogger(EditSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSalesEntryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEditSE;
    private javax.swing.JLabel lblNewQtySold;
    private javax.swing.JLabel lblSEID;
    private javax.swing.JPanel pnlEditSE;
    private javax.swing.JTable tblSE;
    private javax.swing.JTextField txtNewQtySold;
    private javax.swing.JTextField txtSEID;
    // End of variables declaration//GEN-END:variables
}
