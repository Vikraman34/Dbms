package MyPack;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viki
 */
public class Start extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    public Start() {
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

        jLabel1 = new javax.swing.JLabel();
        bar = new javax.swing.JProgressBar();
        loading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Payroll");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 70, 410, 50);

        bar.setForeground(new java.awt.Color(0, 204, 51));
        getContentPane().add(bar);
        bar.setBounds(12, 260, 541, 6);

        loading.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        loading.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(loading);
        loading.setBounds(270, 230, 40, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyPack/background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(565, 305));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 580, 320);

        setSize(new java.awt.Dimension(562, 298));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Start splash=new Start();
       splash.setVisible(true);
       try {
           for (int i=0;i<=100;i++){
               Thread.sleep(40);
               splash.loading.setText(Integer.toString(i)+" %");
               splash.bar.setValue(i);
           }
           splash.dispose();
           Menu obj=new Menu();
           obj.setVisible(true);
       } catch (Exception e){
           
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loading;
    // End of variables declaration//GEN-END:variables
}
