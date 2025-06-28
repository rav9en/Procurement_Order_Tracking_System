
package java_assginment.SaleManager;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;



public class SalesReportGUI extends javax.swing.JFrame {
    
    private DefaultTableModel m;
    
        private ArrayList<SalesEntry> SEList= new ArrayList<SalesEntry>();

    
    public SalesReportGUI() {
        initComponents();
        m=(DefaultTableModel)tblSalesReport.getModel();
        fillSalesEntry();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSalesReport = new javax.swing.JPanel();
        lblSalesReport = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalesReport = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblTotalSales = new javax.swing.JLabel();
        txtTotalSales = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSalesReport.setBackground(new java.awt.Color(255, 204, 204));

        lblSalesReport.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        lblSalesReport.setText("SalesReport");

        tblSalesReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name", "Qty", "Sold Price (RM)", " Total (RM)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSalesReport);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTotalSales.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblTotalSales.setText("Total Sales: ");

        txtTotalSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSalesReportLayout = new javax.swing.GroupLayout(pnlSalesReport);
        pnlSalesReport.setLayout(pnlSalesReportLayout);
        pnlSalesReportLayout.setHorizontalGroup(
            pnlSalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalesReportLayout.createSequentialGroup()
                .addGroup(pnlSalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addGroup(pnlSalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSalesReportLayout.createSequentialGroup()
                            .addGap(233, 233, 233)
                            .addComponent(lblSalesReport))
                        .addGroup(pnlSalesReportLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(pnlSalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlSalesReportLayout.createSequentialGroup()
                                    .addComponent(lblTotalSales)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlSalesReportLayout.setVerticalGroup(
            pnlSalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalesReportLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblSalesReport)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlSalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalSales)
                    .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(btnBack)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void txtTotalSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalSalesActionPerformed

    private void fillSalesEntry() {
    m.setRowCount(0);
    SalesEntry temp = new SalesEntry();
    SEList = temp.loadSalesEntries();

    double totalSales = 0;

    for (SalesEntry s : SEList) {
        double totalForRow = s.getQuantitySold() * s.getPrice();
        totalSales += totalForRow;

        Object[] myRow = {
            s.getSalesEntryId(),
            s.getItemName(),
            s.getQuantitySold(),
            s.getPrice(),
            totalForRow
        };
        m.addRow(myRow);
    }

    // Update the total sales text field
    txtTotalSales.setText(String.format("%.2f", totalSales));
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
            java.util.logging.Logger.getLogger(SalesReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesReportGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSalesReport;
    private javax.swing.JLabel lblTotalSales;
    private javax.swing.JPanel pnlSalesReport;
    private javax.swing.JTable tblSalesReport;
    private javax.swing.JTextField txtTotalSales;
    // End of variables declaration//GEN-END:variables
}
