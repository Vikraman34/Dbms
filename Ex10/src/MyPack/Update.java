package MyPack;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Update extends javax.swing.JFrame {

    /**
     * Creates new form Update2
     */
    public Update() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Ename = new javax.swing.JTextField();
        Dob = new javax.swing.JTextField();
        Designation = new javax.swing.JTextField();
        Basic = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Sex = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        Eid = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Enter only the details to modify for Eid :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 40, 440, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ename                        :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(133, 114, 203, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Dob (dd-mmm-yyyy)      :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(133, 183, 209, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sex                             :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(133, 261, 208, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Designation                  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(133, 336, 206, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Basic Pay                     :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(133, 402, 206, 22);

        Ename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnameActionPerformed(evt);
            }
        });
        getContentPane().add(Ename);
        Ename.setBounds(389, 114, 175, 22);

        Dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DobActionPerformed(evt);
            }
        });
        getContentPane().add(Dob);
        Dob.setBounds(389, 185, 175, 22);
        getContentPane().add(Designation);
        Designation.setBounds(389, 338, 175, 22);
        getContentPane().add(Basic);
        Basic.setBounds(389, 404, 175, 22);

        jButton1.setText("Modify");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 200, 103, 40);

        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(698, 283, 103, 46);
        getContentPane().add(Sex);
        Sex.setBounds(390, 260, 170, 22);

        jButton3.setText("Check");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(700, 120, 100, 50);
        getContentPane().add(Eid);
        Eid.setBounds(590, 42, 150, 30);

        setSize(new java.awt.Dimension(847, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DobActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Menu obj = new Menu();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ename,dob,sex,designation;
        Double basic;
        ename=Ename.getText();
        dob=Dob.getText();
        designation=Designation.getText();        
        sex=Sex.getText();
       
        try{
            basic=Double.parseDouble(Basic.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Basic pay field is empty!"); 
            basic = 0.0; 
        }
        Integer eid;
        eid=Integer.parseInt(Eid.getText());
        try{
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "1");
         String query = "Select * from Emp_Payroll where eid = '"+eid+"'";
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next())
            { 
                if(dob.length()==10)
                          query = "Update Emp_Payroll set ename = '"+ename+"',sex = '"+sex+"', designation = '"+designation+"', basic = '"+basic+"' where eid = '"+eid+"'";
                else
                     query = "Update Emp_Payroll set ename = '"+ename+"',dob ='"+dob+"',sex = '"+sex+"', designation = '"+designation+"', basic = '"+basic+"' where eid = '"+eid+"'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            query = "call calc('"+eid+"','"+basic+"')";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(this, "Successfully updated");
            }
        }
        catch (SQLException e) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Integer eid;
        eid=Integer.parseInt(Eid.getText());
        try{
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "HR", "1");
         String query = "Select * from Emp_Payroll where eid = '"+eid+"'";
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next())
            {
                JOptionPane.showMessageDialog(this,"Employee found");
                Ename.setText(rs.getString("ename"));
                Dob.setText(rs.getString("dob").substring(8,10)+"-"+rs.getString("dob").substring(5,7)+"-"+rs.getString("dob").substring(0,4));
                Sex.setText(rs.getString("sex"));
                Designation.setText(rs.getString("designation"));
                Basic.setText(rs.getString("basic"));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Employee not found!");
                Ename.setText(rs.getString(""));
                Dob.setText(rs.getString(""));
                Sex.setText(rs.getString(""));
                Designation.setText(rs.getString(""));
                Basic.setText(rs.getString(""));
            }
    }                                        
catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Basic;
    private javax.swing.JTextField Designation;
    private javax.swing.JTextField Dob;
    private javax.swing.JTextField Eid;
    private javax.swing.JTextField Ename;
    private javax.swing.JTextField Sex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
