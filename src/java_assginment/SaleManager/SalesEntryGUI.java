
package java_assginment.SaleManager;


public class SalesEntryGUI extends javax.swing.JFrame {

    public SalesEntryGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSalesEntryManagement = new javax.swing.JPanel();
        lblSalesEntryManagement = new javax.swing.JLabel();
        btnAddSE = new javax.swing.JButton();
        btnEditSE = new javax.swing.JButton();
        btnDeleteSE = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSalesEntryManagement.setBackground(new java.awt.Color(255, 204, 204));

        lblSalesEntryManagement.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        lblSalesEntryManagement.setText("Sales Entry Management");

        btnAddSE.setText("Add Sales Entry");
        btnAddSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSEActionPerformed(evt);
            }
        });

        btnEditSE.setText("Edit Sales Entry");
        btnEditSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSEActionPerformed(evt);
            }
        });

        btnDeleteSE.setText("Delete Sales Entry");
        btnDeleteSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSEActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSalesEntryManagementLayout = new javax.swing.GroupLayout(pnlSalesEntryManagement);
        pnlSalesEntryManagement.setLayout(pnlSalesEntryManagementLayout);
        pnlSalesEntryManagementLayout.setHorizontalGroup(
            pnlSalesEntryManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalesEntryManagementLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(lblSalesEntryManagement)
                .addGap(47, 47, 47))
            .addGroup(pnlSalesEntryManagementLayout.createSequentialGroup()
                .addGroup(pnlSalesEntryManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSalesEntryManagementLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(pnlSalesEntryManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteSE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditSE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddSE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlSalesEntryManagementLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSalesEntryManagementLayout.setVerticalGroup(
            pnlSalesEntryManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalesEntryManagementLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblSalesEntryManagement)
                .addGap(41, 41, 41)
                .addComponent(btnAddSE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditSE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteSE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBack)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSalesEntryManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSalesEntryManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSEActionPerformed
        // TODO add your handling code here:
        //open AddSalesEntryGUI 
        AddSalesEntry  jf1= new AddSalesEntry ();
        jf1.show(); //display AddSalesEntryGUI 
        
        dispose(); //close current frame after open AddSalesEntryGUI 
    }//GEN-LAST:event_btnAddSEActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        //open MenuGUI back
        MenuGUI jf1= new MenuGUI();
        jf1.show(); //display MenuGUI
        
        dispose(); //close current frame after open MenuGUI
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEditSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSEActionPerformed
        // TODO add your handling code here:
        //open EditSalesEntryGUI
        EditSalesEntryGUI  jf1= new EditSalesEntryGUI ();
        jf1.show(); //display EditSalesEntryGUI 
        
        dispose(); //close current frame after open EditSalesEntryGUI 
    }//GEN-LAST:event_btnEditSEActionPerformed

    private void btnDeleteSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSEActionPerformed
        // TODO add your handling code here:
        //open DeleteSalesEntryGUI 
        DeleteSalesEntryGUI jf1= new DeleteSalesEntryGUI();
        jf1.show(); //display DeleteSalesEntryGUI
        
        dispose(); //close current frame after open DeleteSalesEntryGUI
    }//GEN-LAST:event_btnDeleteSEActionPerformed

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
            java.util.logging.Logger.getLogger(SalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesEntryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSE;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteSE;
    private javax.swing.JButton btnEditSE;
    private javax.swing.JLabel lblSalesEntryManagement;
    private javax.swing.JPanel pnlSalesEntryManagement;
    // End of variables declaration//GEN-END:variables
}
