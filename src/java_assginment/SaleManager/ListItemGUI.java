package java_assginment.SaleManager;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListItemGUI extends javax.swing.JFrame {
        private DefaultTableModel m;
        
        private ArrayList<Item> IList= new ArrayList<Item>();


    public ListItemGUI() {
        initComponents();
        m=(DefaultTableModel)tblListOfItem.getModel();
        fillItem();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlListItem = new javax.swing.JPanel();
        lblListOfItem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListOfItem = new javax.swing.JTable();
        btnBack1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlListItem.setBackground(new java.awt.Color(255, 204, 204));

        lblListOfItem.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        lblListOfItem.setText("View List of Item");

        tblListOfItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Supplier ID", "Price (RM)", "Dimension", "Reorder Level", "Qty In Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListOfItem);

        btnBack1.setText("Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListItemLayout = new javax.swing.GroupLayout(pnlListItem);
        pnlListItem.setLayout(pnlListItemLayout);
        pnlListItemLayout.setHorizontalGroup(
            pnlListItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListItemLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(pnlListItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack1))
                .addGap(20, 20, 20))
            .addGroup(pnlListItemLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(lblListOfItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlListItemLayout.setVerticalGroup(
            pnlListItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListItemLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblListOfItem)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlListItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlListItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        //open MenuGUI back
        MenuGUI jf1= new MenuGUI();
        jf1.show(); //display MenuGUI
        
        dispose(); //close current frame after open MenuGUI
    }//GEN-LAST:event_btnBack1ActionPerformed

    
    
    public void fillItem() {
    // Clear the table rows
    m.setRowCount(0);

    // Load items from the file
    Item Temp = new Item();
    IList = Temp.loadItem();

    // Debugging output
    System.out.println("Loaded Item List Size: " + IList.size());
    
    if (IList.isEmpty()) {
        System.out.println("No items found.");
    } else {
        // Populate the table
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
        }
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
            java.util.logging.Logger.getLogger(ListItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListItemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListItemGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListOfItem;
    private javax.swing.JPanel pnlListItem;
    private javax.swing.JTable tblListOfItem;
    // End of variables declaration//GEN-END:variables
}
