
package java_assginment.SaleManager;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PurchaseOrderGUI extends javax.swing.JFrame {
     private DefaultTableModel m;
        
        private ArrayList<PurchaseOrder> PurchaseOrderList= new ArrayList<PurchaseOrder>();

   
    public PurchaseOrderGUI() {
        initComponents();
        m=(DefaultTableModel)tblPurchaseOrder.getModel();
        fillPurchaseOrder();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPurchaseOrder = new javax.swing.JPanel();
        lblPurchaseOrder = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchaseOrder = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlPurchaseOrder.setBackground(new java.awt.Color(255, 204, 204));

        lblPurchaseOrder.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblPurchaseOrder.setText("List of Purhase Orders");

        tblPurchaseOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item ID", "Name", "Supplier ID", "Qty", "Unit Price", "Total Price", "Date", "Payment Status", "Delivery Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPurchaseOrder);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPurchaseOrderLayout = new javax.swing.GroupLayout(pnlPurchaseOrder);
        pnlPurchaseOrder.setLayout(pnlPurchaseOrderLayout);
        pnlPurchaseOrderLayout.setHorizontalGroup(
            pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPurchaseOrderLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(lblPurchaseOrder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlPurchaseOrderLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlPurchaseOrderLayout.setVerticalGroup(
            pnlPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPurchaseOrderLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblPurchaseOrder)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnBack)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPurchaseOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPurchaseOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        //open MenuGUI back
        MenuGUI jf1= new MenuGUI();
        jf1.show(); //display MenuGUI
        
        dispose(); //close current frame after open MenuGUI
    }//GEN-LAST:event_btnBackActionPerformed

    public void fillPurchaseOrder() {
    // Clear the table rows
    m.setRowCount(0);

    // Load items from the file
    PurchaseOrder Temp = new PurchaseOrder();
    PurchaseOrderList = Temp.loadPurchaseOrder();

    // Populate the table
    for (PurchaseOrder p : PurchaseOrderList) {
        Object[] myRow = {
            p.getOrderID(),
            p.getItemID(),
            p.getItemName(),
            p.getSupplierID(),
            p.getQuantity(),
            p.getUnitPrice(),
            p.getTotalPrice(),
            p.getDate(),
            p.getPaymentStatus(),
            p.getDeliveryStatus()
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
            java.util.logging.Logger.getLogger(PurchaseOrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrderGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPurchaseOrder;
    private javax.swing.JPanel pnlPurchaseOrder;
    private javax.swing.JTable tblPurchaseOrder;
    // End of variables declaration//GEN-END:variables
}
