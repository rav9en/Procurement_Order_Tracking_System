package java_assginment.SaleManager;

import javax.swing.table.DefaultTableModel;

public class DeleteSalesEntryGUI extends javax.swing.JFrame {
    
    public DeleteSalesEntryGUI() {
        initComponents();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAddSalesEntry = new javax.swing.JPanel();
        lblDeleteSE = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSE = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlAddSalesEntry.setBackground(new java.awt.Color(255, 204, 204));

        lblDeleteSE.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblDeleteSE.setText("Delete Sales Entry");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblSE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"SE001", "I08", "Vacuum Cleaner", "S03",  new Double(300.0), "5kg/25x25x45",  new Integer(7),  new Integer(10),  new Integer(3)},
                {"SE002", "I09", "Coffee Maker", "S01",  new Double(150.0), "30x20x25",  new Integer(5),  new Integer(8),  new Integer(2)},
                {"SE003", "I06", "Washing Machine", "S02",  new Double(900.0), "60x55x90",  new Integer(2),  new Integer(5),  new Integer(1)},
                {"SE004", "I02", "Electric Kettle", "S01",  new Double(80.0), "15x10x10",  new Integer(10),  new Integer(20),  new Integer(8)},
                {"SE005", "I03", "Microwave Oven", "S02",  new Double(450.0), "50x40x35",  new Integer(4),  new Integer(8),  new Integer(3)},
                {"SE006", "I10", "Hair Dryer", "S03",  new Double(60.0), "20x10x5",  new Integer(12),  new Integer(20),  new Integer(5)},
                {"SE007", "I01", "Rice Steamer", "S01",  new Double(160.0), "25x20x15",  new Integer(5),  new Integer(15),  new Integer(7)},
                {"SE008", "I04", "Air Conditioner", "S02",  new Double(1150.0), "80x60x40",  new Integer(2),  new Integer(6),  new Integer(1)},
                {"SE009", "I01", "Rice Steamer", "S03",  new Double(120.0), "20x15x25",  new Integer(6),  new Integer(12),  new Integer(4)},
                {"SE010", "I02", "Electric Kettle", "S01",  new Double(700.0), "60x55x85",  new Integer(2),  new Integer(4),  new Integer(1)},
                {"SE011", "I07", "Blender", "S03",  new Double(170.0), "15x15x30",  new Integer(7),  new Integer(10),  new Integer(6)},
                {"SE012", "I05", "Toaster", "S02",  new Double(95.0), "22x15x12",  new Integer(8),  new Integer(15),  new Integer(5)},
                {"SE013", "I08", "Vacuum Cleaner", "S03",  new Double(280.0), "5kg/25x25x45",  new Integer(5),  new Integer(8),  new Integer(2)},
                {"SE014", "I09", "Coffee Maker", "S01",  new Double(140.0), "30x20x25",  new Integer(6),  new Integer(10),  new Integer(3)},
                {"SE015", "I06", "Washing Machine", "S02",  new Double(880.0), "60x55x90",  new Integer(3),  new Integer(5),  new Integer(1)},
                {"SE016", "I03", "Iron Box", "S03",  new Double(50.0), "25x12x10",  new Integer(10),  new Integer(20),  new Integer(8)},
                {"SE017", "I04", "Refrigator", "S01",  new Double(1400.0), "70x60x180",  new Integer(1),  new Integer(3),  new Integer(1)},
                {"SE018", "I05", "Water Heater", "S02",  new Double(350.0), "30x30x40",  new Integer(4),  new Integer(8),  new Integer(2)},
                {"SE019", "I06", "Electric Fan", "S03",  new Double(100.0), "40x40x60",  new Integer(7),  new Integer(15),  new Integer(5)},
                {"SE020", "I05", "Toaster", "S02",  new Double(100.0), "22x15x12",  new Integer(6),  new Integer(12),  new Integer(4)},
                {"SE021", "I02", "Smart doorbell", "S02",  new Double(500.0), "10x10x5",  new Integer(6),  new Integer(12),  new Integer(7)}
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

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddSalesEntryLayout = new javax.swing.GroupLayout(pnlAddSalesEntry);
        pnlAddSalesEntry.setLayout(pnlAddSalesEntryLayout);
        pnlAddSalesEntryLayout.setHorizontalGroup(
            pnlAddSalesEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddSalesEntryLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(28, 28, 28))
            .addGroup(pnlAddSalesEntryLayout.createSequentialGroup()
                .addGroup(pnlAddSalesEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddSalesEntryLayout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddSalesEntryLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(lblDeleteSE))
                    .addGroup(pnlAddSalesEntryLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlAddSalesEntryLayout.setVerticalGroup(
            pnlAddSalesEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddSalesEntryLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblDeleteSE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAddSalesEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 426, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAddSalesEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        //open SalesEntryGUI 
        SalesEntryGUI  jf1= new SalesEntryGUI ();
        jf1.show(); //display SalesEntryGUI 
        
        dispose(); //close current frame after open SalesEntryGUI 
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel= (DefaultTableModel) tblSE.getModel();
        
        //delete row
        if(tblSE.getSelectedRowCount()==1){
            //if single row is selected then delete
            tblModel.removeRow(tblSE.getSelectedRow());
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteSalesEntryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteSalesEntryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDeleteSE;
    private javax.swing.JPanel pnlAddSalesEntry;
    private javax.swing.JTable tblSE;
    // End of variables declaration//GEN-END:variables
}
