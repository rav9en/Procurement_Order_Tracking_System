/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_assginment.InventoryManager;

import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivenn
 */
public class Edit_Supplier extends javax.swing.JFrame {
    private Supplier_Management_Interface mainInterface;

        public void setMainInterface(Supplier_Management_Interface mainInterface) {
            this.mainInterface = mainInterface;
        }

        private final Supplier selectedSupplier;

        public Edit_Supplier(Supplier selectedSupplier) {
            this.selectedSupplier = selectedSupplier;
            initComponents();
            populateSuppliers();
        }
        
    private void populateSuppliers(){
        lblSupplierID_Old.setText(selectedSupplier.getSupplierId());
        lblSupplierName_Old.setText(selectedSupplier.getSupplierName());
        lblSupplierContactNumber_Old.setText(selectedSupplier.getContactNumber());
        lblSupplierEmail_Old.setText(selectedSupplier.getEmail());
        lblSupplier_ItemIds_Old.setText(selectedSupplier.getItemIds());
        lblSupplierPaymentMethod_Old.setText(String.valueOf(selectedSupplier.getPaymentMethod()));
        lblSupplierShippingMethod_Old.setText(selectedSupplier.getShippingMethod());
        lblSupplierSupplyCapacity_Old.setText(String.valueOf(selectedSupplier.getSupplyCapacity()));
        lblSupplierLeadTime_Old.setText(String.valueOf(selectedSupplier.getLeadTime()));
    }
    
    //Save the updated supplier after editing
    private void saveChanges() {
        if (selectedSupplier == null) {
            JOptionPane.showMessageDialog(this, "No supplier selected to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean changesMade = false; //Whether any changes were made

        //Validate and update supplier name
        String newSupplierName = txtSupplierName_Edit.getText().trim();
        if (!newSupplierName.isEmpty() && !newSupplierName.equals(selectedSupplier.getSupplierName())) {
            selectedSupplier.setSupplierName(newSupplierName);
            changesMade = true;
        }

        //Validate and update contact number
        String newContactNumber = txtSupplierContactNumber_Edit.getText().trim();
        if (!newContactNumber.isEmpty() && !newContactNumber.equals(selectedSupplier.getContactNumber())) {
            selectedSupplier.setContactNumber(newContactNumber);
            changesMade = true;
        }

        //Validate and update email
        String newEmail = txtSupplierEmail_Edit.getText().trim();
        if (!newEmail.isEmpty() && !newEmail.equals(selectedSupplier.getEmail())) {
            selectedSupplier.setEmail(newEmail);
            changesMade = true;
        }

        //Validate and update item IDs
        String itemIdsStr = txtSupplier_ItemIds_Edit.getText().trim(); 
        if (!itemIdsStr.isEmpty()) {
            List<String> newItemIds = Arrays.asList(itemIdsStr.split(","));
            if (!newItemIds.equals(selectedSupplier.getItemIds())) {
                selectedSupplier.setItemIds(newItemIds);
                changesMade = true;
            }
        }

    //Validate and update payment method
    String newPaymentMethod = txtSupplierPaymentMethod_Edit.getText().trim();
    if (!newPaymentMethod.isEmpty() && !newPaymentMethod.equals(selectedSupplier.getPaymentMethod())) {
        selectedSupplier.setPaymentMethod(newPaymentMethod);
        changesMade = true;
    }

    //Validate and update shipping method
    String newShippingMethod = txtSupplierShippingMethod_Edit.getText().trim();
    if (!newShippingMethod.isEmpty() && !newShippingMethod.equals(selectedSupplier.getShippingMethod())) {
        selectedSupplier.setShippingMethod(newShippingMethod);
        changesMade = true;
    }

    //Validate and update supply capacity
    String newSupplyCapacity = txtSupplierSupplyCapacity_Edit.getText().trim();
    if (!newSupplyCapacity.isEmpty() && !newSupplyCapacity.equals (selectedSupplier.getSupplyCapacity())) {
        selectedSupplier.setSupplyCapacity(newSupplyCapacity);
        changesMade = true;
    }

    //Validate and update lead time
    String newLeadTime = txtSupplierLeadTime_Edit.getText().trim();
    if (!newLeadTime.isEmpty() && !newLeadTime.equals (selectedSupplier.getLeadTime())) {
        selectedSupplier.setLeadTime(newLeadTime);
        changesMade = true;
    }

    //If no changes were made
    if (!changesMade) {
        JOptionPane.showMessageDialog(this, "No changes were made.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    Supplier.saveSupplier(selectedSupplier);

    JOptionPane.showMessageDialog(this, "Supplier updated successfully!");
    mainInterface.refreshSupplierTable();
    this.dispose(); 
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
        lblSupplierID_Edit = new javax.swing.JLabel();
        lblSupplierName_Edit = new javax.swing.JLabel();
        lblSupplierContactNumber_Edit = new javax.swing.JLabel();
        lblSupplierEmail_Edit = new javax.swing.JLabel();
        lblSupplier_ItemIds_Edit = new javax.swing.JLabel();
        lblSupplierPaymentMethod_Edit = new javax.swing.JLabel();
        lblSupplierShippingMethod_Edit = new javax.swing.JLabel();
        lblSupplierSupplyCapacity_Edit = new javax.swing.JLabel();
        lblSupplierLeadTime_Edit = new javax.swing.JLabel();
        txtSupplierName_Edit = new javax.swing.JTextField();
        txtSupplierContactNumber_Edit = new javax.swing.JTextField();
        txtSupplierEmail_Edit = new javax.swing.JTextField();
        txtSupplier_ItemIds_Edit = new javax.swing.JTextField();
        txtSupplierPaymentMethod_Edit = new javax.swing.JTextField();
        txtSupplierShippingMethod_Edit = new javax.swing.JTextField();
        txtSupplierSupplyCapacity_Edit = new javax.swing.JTextField();
        txtSupplierLeadTime_Edit = new javax.swing.JTextField();
        btnSaveChanges_EditSupplier = new javax.swing.JButton();
        btnCancel_EditSupplier = new javax.swing.JButton();
        lblEditSupplier = new javax.swing.JLabel();
        lblSupplierID_Old = new javax.swing.JLabel();
        lblSupplierName_Old = new javax.swing.JLabel();
        lblSupplierContactNumber_Old = new javax.swing.JLabel();
        lblSupplierEmail_Old = new javax.swing.JLabel();
        lblSupplier_ItemIds_Old = new javax.swing.JLabel();
        lblSupplierPaymentMethod_Old = new javax.swing.JLabel();
        lblSupplierShippingMethod_Old = new javax.swing.JLabel();
        lblSupplierSupplyCapacity_Old = new javax.swing.JLabel();
        lblSupplierLeadTime_Old = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        lblSupplierID_Edit.setText("Supplier ID");

        lblSupplierName_Edit.setText("Supplier Name");

        lblSupplierContactNumber_Edit.setText("Contact Number");

        lblSupplierEmail_Edit.setText("Email");

        lblSupplier_ItemIds_Edit.setText("Item IDs");

        lblSupplierPaymentMethod_Edit.setText("Payment Method");

        lblSupplierShippingMethod_Edit.setText("Shipping Method");

        lblSupplierSupplyCapacity_Edit.setText("Supply Capacity");

        lblSupplierLeadTime_Edit.setText("Lead Time");

        btnSaveChanges_EditSupplier.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnSaveChanges_EditSupplier.setText("Save Changes");
        btnSaveChanges_EditSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChanges_EditSupplierActionPerformed(evt);
            }
        });

        btnCancel_EditSupplier.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnCancel_EditSupplier.setText("Cancel");
        btnCancel_EditSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel_EditSupplierActionPerformed(evt);
            }
        });

        lblEditSupplier.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        lblEditSupplier.setText("Edit Supplier");

        lblSupplierID_Old.setText("jLabel11");

        lblSupplierName_Old.setText("jLabel12");

        lblSupplierContactNumber_Old.setText("jLabel13");

        lblSupplierEmail_Old.setText("jLabel14");

        lblSupplier_ItemIds_Old.setText("jLabel15");

        lblSupplierPaymentMethod_Old.setText("jLabel16");

        lblSupplierShippingMethod_Old.setText("jLabel17");

        lblSupplierSupplyCapacity_Old.setText("jLabel18");

        lblSupplierLeadTime_Old.setText("jLabel19");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(lblEditSupplier)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSupplierName_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblSupplierContactNumber_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSupplierID_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSupplierEmail_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSupplier_ItemIds_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSupplierPaymentMethod_Edit)
                            .addComponent(lblSupplierShippingMethod_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblSupplierSupplyCapacity_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSupplier_ItemIds_Old, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSupplierEmail_Old, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSupplierContactNumber_Old, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSupplierPaymentMethod_Old, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSupplierShippingMethod_Old, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSupplierName_Old, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSupplierSupplyCapacity_Old, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(41, 41, 41))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSupplierID_Old, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSupplierLeadTime_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(lblSupplierLeadTime_Old, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSupplierLeadTime_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnCancel_EditSupplier))
                    .addComponent(txtSupplierName_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSupplierContactNumber_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(txtSupplierEmail_Edit)
                            .addComponent(txtSupplier_ItemIds_Edit)
                            .addComponent(txtSupplierPaymentMethod_Edit)
                            .addComponent(txtSupplierShippingMethod_Edit)
                            .addComponent(txtSupplierSupplyCapacity_Edit))
                        .addGap(34, 34, 34)
                        .addComponent(btnSaveChanges_EditSupplier)))
                .addGap(202, 202, 202))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblEditSupplier)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierID_Edit)
                    .addComponent(lblSupplierID_Old))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierName_Old)
                    .addComponent(lblSupplierName_Edit)
                    .addComponent(txtSupplierName_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierContactNumber_Edit)
                    .addComponent(lblSupplierContactNumber_Old)
                    .addComponent(txtSupplierContactNumber_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierEmail_Edit)
                    .addComponent(lblSupplierEmail_Old)
                    .addComponent(txtSupplierEmail_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplier_ItemIds_Edit)
                    .addComponent(lblSupplier_ItemIds_Old)
                    .addComponent(txtSupplier_ItemIds_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierPaymentMethod_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierPaymentMethod_Old)
                    .addComponent(lblSupplierPaymentMethod_Edit))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierShippingMethod_Edit)
                    .addComponent(lblSupplierShippingMethod_Old)
                    .addComponent(txtSupplierShippingMethod_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierSupplyCapacity_Edit)
                    .addComponent(lblSupplierSupplyCapacity_Old)
                    .addComponent(txtSupplierSupplyCapacity_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveChanges_EditSupplier))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel_EditSupplier)
                    .addComponent(txtSupplierLeadTime_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierLeadTime_Old)
                    .addComponent(lblSupplierLeadTime_Edit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSaveChanges_EditSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChanges_EditSupplierActionPerformed
        saveChanges();
        mainInterface.refreshSupplierTable();
    }//GEN-LAST:event_btnSaveChanges_EditSupplierActionPerformed

    private void btnCancel_EditSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel_EditSupplierActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancel_EditSupplierActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Supplier selectedSupplier = getSelectedSupplier(); 
                new Edit_Supplier (selectedSupplier).setVisible(true);
            }

            private Supplier getSelectedSupplier() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel_EditSupplier;
    private javax.swing.JButton btnSaveChanges_EditSupplier;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEditSupplier;
    private javax.swing.JLabel lblSupplierContactNumber_Edit;
    private javax.swing.JLabel lblSupplierContactNumber_Old;
    private javax.swing.JLabel lblSupplierEmail_Edit;
    private javax.swing.JLabel lblSupplierEmail_Old;
    private javax.swing.JLabel lblSupplierID_Edit;
    private javax.swing.JLabel lblSupplierID_Old;
    private javax.swing.JLabel lblSupplierLeadTime_Edit;
    private javax.swing.JLabel lblSupplierLeadTime_Old;
    private javax.swing.JLabel lblSupplierName_Edit;
    private javax.swing.JLabel lblSupplierName_Old;
    private javax.swing.JLabel lblSupplierPaymentMethod_Edit;
    private javax.swing.JLabel lblSupplierPaymentMethod_Old;
    private javax.swing.JLabel lblSupplierShippingMethod_Edit;
    private javax.swing.JLabel lblSupplierShippingMethod_Old;
    private javax.swing.JLabel lblSupplierSupplyCapacity_Edit;
    private javax.swing.JLabel lblSupplierSupplyCapacity_Old;
    private javax.swing.JLabel lblSupplier_ItemIds_Edit;
    private javax.swing.JLabel lblSupplier_ItemIds_Old;
    private javax.swing.JTextField txtSupplierContactNumber_Edit;
    private javax.swing.JTextField txtSupplierEmail_Edit;
    private javax.swing.JTextField txtSupplierLeadTime_Edit;
    private javax.swing.JTextField txtSupplierName_Edit;
    private javax.swing.JTextField txtSupplierPaymentMethod_Edit;
    private javax.swing.JTextField txtSupplierShippingMethod_Edit;
    private javax.swing.JTextField txtSupplierSupplyCapacity_Edit;
    private javax.swing.JTextField txtSupplier_ItemIds_Edit;
    // End of variables declaration//GEN-END:variables
}
