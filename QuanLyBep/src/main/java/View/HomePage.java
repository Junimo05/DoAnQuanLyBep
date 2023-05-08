/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import View.QLNLView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JFrame;
/**
 *
 * @author anhtu
 */
public class HomePage extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form HomePage
     */
   
    public HomePage() {
        initComponents();
        bttQLMA.addActionListener(this);
        bttQLNL.addActionListener(this);
        bttQLNV.addActionListener(this);
        bttQLSA.addActionListener(this);
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
        jPanel1 = new javax.swing.JPanel();
        bttQLSA = new javax.swing.JButton();
        bttQLMA = new javax.swing.JButton();
        bttQLNL = new javax.swing.JButton();
        bttQLNV = new javax.swing.JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Trang Chủ");

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Bếp");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setLayout(new java.awt.GridLayout(0, 4));

        bttQLSA.setBackground(new java.awt.Color(255, 102, 102));
        bttQLSA.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bttQLSA.setText("Quản Lý Suất Ăn");
        bttQLSA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(bttQLSA);

        bttQLMA.setBackground(new java.awt.Color(255, 153, 153));
        bttQLMA.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bttQLMA.setText("Quản Lý Món Ăn");
        jPanel1.add(bttQLMA);

        bttQLNL.setBackground(new java.awt.Color(255, 204, 204));
        bttQLNL.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bttQLNL.setText("Quản Lý Nguyên Liệu");
        jPanel1.add(bttQLNL);

        bttQLNV.setBackground(new java.awt.Color(255, 255, 204));
        bttQLNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bttQLNV.setText("Quản Lý Nhân Viên");
        jPanel1.add(bttQLNV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttQLMA;
    private javax.swing.JButton bttQLNL;
    private javax.swing.JButton bttQLNV;
    private javax.swing.JButton bttQLSA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Events
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bttQLSA)){
            bttQLSAClick();
        }else if(e.getSource().equals(bttQLMA)){
            bttQLMAClick();
        }else if(e.getSource().equals(bttQLNL)){
            bttQLNLClick();
        }else{
            bttQLNVClick();
        }
    }
    
    public void bttQLSAClick(){
        new QLSuatAnView().setVisible(true);
        this.dispose();
    }
    
    public void bttQLMAClick(){
        new QLMonAnView().setVisible(true);
        this.dispose();
    }
    
    public void bttQLNLClick(){
        new QLNLView().setVisible(true);
        this.dispose();
    }
    
    public void bttQLNVClick(){
        new QLNhanVienView().setVisible(true);
        this.dispose();
    }
}
