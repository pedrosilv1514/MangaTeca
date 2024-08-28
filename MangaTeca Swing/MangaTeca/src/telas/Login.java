package telas;

import java.io.*;
import Classes.Sistema;
import Classes.Cliente;
import Classes.Usuario;
import javax.swing.*;

/**
 *
 * @author eduar
 */
public class Login extends javax.swing.JFrame {

    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblEmailLogin = new javax.swing.JLabel();
        lblSenhaLogin = new javax.swing.JLabel();
        txtConfirmaLogin = new javax.swing.JToggleButton();
        txtSenhaLogin = new javax.swing.JPasswordField();
        txtEmailLogin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MangaTeca");

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 512));
        jPanel1.setLayout(null);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo MangaTeca Pequena.png"))); // NOI18N
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(127, 82, 454, 67);

        lblEmailLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEmailLogin.setForeground(new java.awt.Color(237, 237, 237));
        lblEmailLogin.setText("E-Mail");
        jPanel1.add(lblEmailLogin);
        lblEmailLogin.setBounds(127, 180, 96, 32);

        lblSenhaLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSenhaLogin.setForeground(new java.awt.Color(237, 237, 237));
        lblSenhaLogin.setText("Senha");
        jPanel1.add(lblSenhaLogin);
        lblSenhaLogin.setBounds(127, 267, 96, 32);

        txtConfirmaLogin.setBackground(new java.awt.Color(218, 0, 55));
        txtConfirmaLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtConfirmaLogin.setForeground(new java.awt.Color(237, 237, 237));
        txtConfirmaLogin.setText("Entrar");
        txtConfirmaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmaLoginActionPerformed(evt);
            }
        });
        jPanel1.add(txtConfirmaLogin);
        txtConfirmaLogin.setBounds(244, 391, 209, 47);

        txtSenhaLogin.setBackground(new java.awt.Color(68, 68, 68));
        txtSenhaLogin.setForeground(new java.awt.Color(237, 237, 237));
        txtSenhaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaLoginActionPerformed(evt);
            }
        });
        jPanel1.add(txtSenhaLogin);
        txtSenhaLogin.setBounds(127, 305, 454, 30);

        txtEmailLogin.setBackground(new java.awt.Color(68, 68, 68));
        txtEmailLogin.setForeground(new java.awt.Color(237, 237, 237));
        txtEmailLogin.setToolTipText("");
        jPanel1.add(txtEmailLogin);
        txtEmailLogin.setBounds(127, 218, 454, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaLoginActionPerformed
        
    }//GEN-LAST:event_txtSenhaLoginActionPerformed

    private void txtConfirmaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmaLoginActionPerformed
        String txtEmail = txtEmailLogin.getText();
        String txtSenha = txtSenhaLogin.getText();
        Usuario.Logar(txtEmail, txtSenha);
    }//GEN-LAST:event_txtConfirmaLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblEmailLogin;
    private javax.swing.JLabel lblSenhaLogin;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JToggleButton txtConfirmaLogin;
    private javax.swing.JTextField txtEmailLogin;
    private javax.swing.JPasswordField txtSenhaLogin;
    // End of variables declaration//GEN-END:variables
}
