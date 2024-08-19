/*
    Criação de Tela Principal do Projeto MangaTeca
    A Tela consiste na criação de uma tela com opções de cadastro e login
    MangaTeca: Acervo de coleções de mangá de forma virtual 
    Alunos: Pedro Henrique
            Eduardo Pereira

*/
package telas;

import Classes.Cliente;
import telas.Cadastro;
import java.util.*;
import javax.swing.*;


public class TelaPrincipal extends javax.swing.JFrame {
    ArrayList<Cliente> Clientes; //iniciei o arraylist só pra ver se dava pra colocar os clientes do cadastro nele, falhei
    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaInicial = new javax.swing.JPanel();
        logoMangaTeca = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JToggleButton();
        btnLogin = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MangaTeca");

        telaInicial.setBackground(new java.awt.Color(23, 23, 23));
        telaInicial.setPreferredSize(new java.awt.Dimension(720, 512));
        telaInicial.setLayout(null);

        logoMangaTeca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoMangaTeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo MangaTeca Pequena.png"))); // NOI18N
        telaInicial.add(logoMangaTeca);
        logoMangaTeca.setBounds(136, 78, 453, 67);

        btnCadastro.setBackground(new java.awt.Color(68, 68, 68));
        btnCadastro.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(237, 237, 237));
        btnCadastro.setText("Cadastrar");
        btnCadastro.setPreferredSize(new java.awt.Dimension(316, 59));
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });
        telaInicial.add(btnCadastro);
        btnCadastro.setBounds(213, 294, 316, 59);

        btnLogin.setBackground(new java.awt.Color(218, 0, 55));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(237, 237, 237));
        btnLogin.setText("Entrar");
        btnLogin.setPreferredSize(new java.awt.Dimension(316, 59));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        telaInicial.add(btnLogin);
        btnLogin.setBounds(213, 223, 316, 59);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(237, 237, 237));
        jLabel1.setText("© MangaTeca 2024.");
        telaInicial.add(jLabel1);
        jLabel1.setBounds(250, 470, 240, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        new Cadastro().setVisible(true);
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCadastro;
    private javax.swing.JToggleButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logoMangaTeca;
    private javax.swing.JPanel telaInicial;
    // End of variables declaration//GEN-END:variables
}
