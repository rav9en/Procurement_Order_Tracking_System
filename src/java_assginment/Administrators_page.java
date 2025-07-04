/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_assginment;

/**
 *
 * @author thong
 * .
 */
import java_assginment.Purchase_Manager.MainMenu;
import java_assginment.InventoryManager.Inventory_Interface;
import java_assginment.Finance_Manager.MainMenuFinance;
import java_assginment.SaleManager.MenuGUI;



public class Administrators_page extends javax.swing.JFrame {

    /**
     * Creates new form Administrators_page
     */
    public Administrators_page() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Log_Out = new javax.swing.JButton();
        Finance_Manager = new javax.swing.JButton();
        Inventory_Manager = new javax.swing.JButton();
        Purchase_Manager = new javax.swing.JButton();
        Sales_Manager = new javax.swing.JButton();
        Add_new_member = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Log_Out.setBackground(new java.awt.Color(255, 51, 51));
        Log_Out.setText("Log out");
        Log_Out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log_OutActionPerformed(evt);
            }
        });
        getContentPane().add(Log_Out, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        Finance_Manager.setText("Finance Manager");
        Finance_Manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Finance_ManagerActionPerformed(evt);
            }
        });
        getContentPane().add(Finance_Manager, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 160, 60));

        Inventory_Manager.setText("Inventory Manager");
        Inventory_Manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory_ManagerActionPerformed(evt);
            }
        });
        getContentPane().add(Inventory_Manager, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 160, 60));

        Purchase_Manager.setText("Purchase Manager");
        Purchase_Manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Purchase_ManagerActionPerformed(evt);
            }
        });
        getContentPane().add(Purchase_Manager, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 160, 60));

        Sales_Manager.setText("Sales Manager");
        Sales_Manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sales_ManagerActionPerformed(evt);
            }
        });
        getContentPane().add(Sales_Manager, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 160, 60));

        Add_new_member.setText("Add New Member");
        Add_new_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_new_memberActionPerformed(evt);
            }
        });
        getContentPane().add(Add_new_member, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 160, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\thong\\OneDrive - Asia Pacific University\\Documents\\NetBeansProjects\\Java_Assginment\\src\\image_file\\minecraft image.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 740, 430));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Administrator");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 220, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Add_new_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_new_memberActionPerformed
        // TODO add your handling code here:
        new_Register_page reg = new new_Register_page();
        reg.setVisible(true); 
        this.setVisible(false);        
    }//GEN-LAST:event_Add_new_memberActionPerformed

    private void Finance_ManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Finance_ManagerActionPerformed
        // TODO add your handling code here:
        MainMenuFinance reg = new MainMenuFinance();
        reg.setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_Finance_ManagerActionPerformed

    private void Inventory_ManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory_ManagerActionPerformed
        // TODO add your handling code here:
        Inventory_Interface reg = new Inventory_Interface();
        reg.setVisible(true); 
        this.setVisible(false);    
    }//GEN-LAST:event_Inventory_ManagerActionPerformed

    private void Purchase_ManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Purchase_ManagerActionPerformed
        // TODO add your handling code here:
        MainMenu reg = new MainMenu();
        reg.setVisible(true); 
        this.setVisible(false);     
    }//GEN-LAST:event_Purchase_ManagerActionPerformed

    private void Sales_ManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sales_ManagerActionPerformed
        // TODO add your handling code here:
        MenuGUI reg = new MenuGUI();
        reg.setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_Sales_ManagerActionPerformed

    private void Log_OutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_OutActionPerformed
    // TODO add your handling code here:

    login_page reg = new login_page();
    reg.setVisible(true);  // Make login page visible
    
    // Hide the current Admin page
    this.setVisible(false);  // Close the Admin page       
    }//GEN-LAST:event_Log_OutActionPerformed

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
            java.util.logging.Logger.getLogger(Administrators_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrators_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrators_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrators_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrators_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_new_member;
    private javax.swing.JButton Finance_Manager;
    private javax.swing.JButton Inventory_Manager;
    private javax.swing.JButton Log_Out;
    private javax.swing.JButton Purchase_Manager;
    private javax.swing.JButton Sales_Manager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
