
package java_assginment.SaleManager;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class StockLevelGUI extends javax.swing.JFrame {

    private DefaultTableModel m;
        
        private ArrayList<Item> IList= new ArrayList<Item>();
        
    public StockLevelGUI() {
        initComponents();
        m=(DefaultTableModel)tblStockLevel.getModel();
        fillItem();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlStockLevel = new javax.swing.JPanel();
        lblStockLevel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStockLevel = new javax.swing.JTable();
        lblItemBelowStockLevel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtABelowStockLevel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlStockLevel.setBackground(new java.awt.Color(255, 204, 204));

        lblStockLevel.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        lblStockLevel.setText("View Stock Level");

        tblStockLevel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Supplier ID", "Price (RM)", "Dimension", "Reorder Level", "Qty In Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStockLevel);

        lblItemBelowStockLevel.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        lblItemBelowStockLevel.setText("Item Below Stock Level");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtABelowStockLevel.setColumns(20);
        txtABelowStockLevel.setRows(5);
        jScrollPane3.setViewportView(txtABelowStockLevel);

        javax.swing.GroupLayout pnlStockLevelLayout = new javax.swing.GroupLayout(pnlStockLevel);
        pnlStockLevel.setLayout(pnlStockLevelLayout);
        pnlStockLevelLayout.setHorizontalGroup(
            pnlStockLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockLevelLayout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(lblStockLevel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStockLevelLayout.createSequentialGroup()
                .addGroup(pnlStockLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlStockLevelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(pnlStockLevelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1)))
                .addGap(28, 28, 28))
            .addGroup(pnlStockLevelLayout.createSequentialGroup()
                .addGroup(pnlStockLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStockLevelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStockLevelLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(lblItemBelowStockLevel)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        pnlStockLevelLayout.setVerticalGroup(
            pnlStockLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockLevelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblStockLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(lblItemBelowStockLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnBack)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStockLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStockLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    public void fillItem() {
    // Clear the table rows
    m.setRowCount(0);

    // Load items from the file
    Item Temp = new Item();
    IList = Temp.loadItem();

    // Prepare a string to store items below reorder level
    StringBuilder belowReorderItems = new StringBuilder();

    // Populate the table and check for below reorder level items
    for (Item i : IList) {
        Object[] myRow = {
            i.getItemId(),
            i.getItemName(),
            i.getSupplierId(),
            i.getPrice(),
            i.getDimensions(),
            i.getReorderLevel(),
            i.getQuantityInStock()
        };
        m.addRow(myRow);

        // Check if the item is below the reorder level
        if (i.getQuantityInStock() < i.getReorderLevel()) {
            belowReorderItems.append(String.format("ID: %s, Name: %s, Qty: %d\n",
                    i.getItemId(), i.getItemName(), i.getQuantityInStock()));
        }
    }

    // Update the text area with items below reorder level
    txtABelowStockLevel.setText(belowReorderItems.toString());
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
            java.util.logging.Logger.getLogger(StockLevelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockLevelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockLevelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockLevelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockLevelGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblItemBelowStockLevel;
    private javax.swing.JLabel lblStockLevel;
    private javax.swing.JPanel pnlStockLevel;
    private javax.swing.JTable tblStockLevel;
    private javax.swing.JTextArea txtABelowStockLevel;
    // End of variables declaration//GEN-END:variables
}
