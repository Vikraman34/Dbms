package MyPack;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viki
 */
public class Insert extends javax.swing.JFrame {

    /**
     * Creates new form Insert
     */
    public Insert() {
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

        Sex = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Eid = new javax.swing.JTextField();
        Ename = new javax.swing.JTextField();
        Dob = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        Designation = new javax.swing.JTextField();
        Basic = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Add New Employee Details");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 30, 211, 34);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Eid                                 :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(117, 111, 155, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ename                           : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(117, 159, 159, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Dob (dd-mmm-yyyy)    :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(117, 206, 155, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Sex                                :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(117, 268, 156, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Designation                    :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(117, 322, 156, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Basic Pay                       :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(117, 374, 154, 17);

        Eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EidActionPerformed(evt);
            }
        });
        getContentPane().add(Eid);
        Eid.setBounds(330, 109, 159, 22);

        Ename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnameActionPerformed(evt);
            }
        });
        getContentPane().add(Ename);
        Ename.setBounds(330, 157, 159, 22);

        Dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DobActionPerformed(evt);
            }
        });
        getContentPane().add(Dob);
        Dob.setBounds(330, 204, 159, 22);

        Sex.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(330, 265, 55, 25);

        Sex.add(jRadioButton2);
        jRadioButton2.setText("Female");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(418, 265, 71, 25);
        getContentPane().add(Designation);
        Designation.setBounds(330, 320, 159, 22);
        getContentPane().add(Basic);
        Basic.setBounds(330, 372, 159, 22);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(670, 146, 103, 48);

        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(670, 255, 103, 44);

        setSize(new java.awt.Dimension(847, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EidActionPerformed

    private void EnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnameActionPerformed

    private void DobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DobActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Menu obj = new Menu();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ename,dob,sex,designation;
        Integer eid;
        Double basic;
        eid=Integer.parseInt(Eid.getText());
        ename=Ename.getText();
        dob=Dob.getText();
        designation=Designation.getText();
        jRadioButton1.setActionCommand("Male");
        jRadioButton2.setActionCommand("Female");
        
        sex=Sex.getSelection().getActionCommand();
       
        try{
            basic=Double.parseDouble(Basic.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Basic pay field is empty!"); 
            basic = 0.0; 
        }
            
        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "1");
            String query = "Insert into Emp_Payroll (eid, ename, dob, sex, designation, basic) values('"+eid+"','"+ename+"','"+dob+"','"+sex+"','"+designation+"','"+basic+"')";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            query = "call calc('"+eid+"','"+basic+"')";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(this, "Employee added successfully and net pay is claculated");
        }
        catch (SQLException e) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error try again");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Basic;
    private javax.swing.JTextField Designation;
    private javax.swing.JTextField Dob;
    private javax.swing.JTextField Eid;
    private javax.swing.JTextField Ename;
    private javax.swing.ButtonGroup Sex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}