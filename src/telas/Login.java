package telas;

import java.io.*;
import Classes.Usuario;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Como o próprio nome diz, é a tela utilizada para login no sistema.

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblEmailLogin = new javax.swing.JLabel();
        lblSenhaLogin = new javax.swing.JLabel();
        txtSenhaLogin = new javax.swing.JPasswordField();
        txtEmailLogin = new javax.swing.JTextField();
        txtConfirmaLogin = new javax.swing.JToggleButton();
        btnVoltar = new javax.swing.JLabel();
        lblVoltar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MangaTeca - Login");

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 512));
        jPanel1.setLayout(null);

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo MangaTeca Pequena.png"))); // NOI18N
        jPanel1.add(lblLogo);
        lblLogo.setBounds(127, 82, 454, 67);

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

        txtSenhaLogin.setBackground(new java.awt.Color(68, 68, 68));
        txtSenhaLogin.setForeground(new java.awt.Color(237, 237, 237));
        jPanel1.add(txtSenhaLogin);
        txtSenhaLogin.setBounds(127, 305, 454, 30);

        txtEmailLogin.setBackground(new java.awt.Color(68, 68, 68));
        txtEmailLogin.setForeground(new java.awt.Color(237, 237, 237));
        txtEmailLogin.setToolTipText("");
        jPanel1.add(txtEmailLogin);
        txtEmailLogin.setBounds(127, 218, 454, 30);

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

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/return.png"))); // NOI18N
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarMouseEntered(evt);
            }
        });
        jPanel1.add(btnVoltar);
        btnVoltar.setBounds(20, 20, 100, 40);
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Fecha a tela atual e abre a tela principal
                new TelaPrincipal().setVisible(true);
            }
        });

        lblVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVoltar.setForeground(new java.awt.Color(255, 255, 255));
        lblVoltar.setText("Voltar");
        jPanel1.add(lblVoltar);
        lblVoltar.setBounds(60, 30, 60, 20);

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

    private void txtConfirmaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmaLoginActionPerformed
        String txtEmail = txtEmailLogin.getText();
        String txtSenha = txtSenhaLogin.getText();
        Usuario usuarioLogado = Usuario.Logar(txtEmail, txtSenha); //Inicia a instância do usuário na classe UsuarioLogado, para que seus dados possam ser acessados por outras telas.
        
        if(usuarioLogado != null){
            this.dispose();
            try {
                new Homepage().setVisible(true);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtConfirmaLoginActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_btnVoltarMouseEntered

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmailLogin;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSenhaLogin;
    private javax.swing.JLabel lblVoltar;
    private javax.swing.JToggleButton txtConfirmaLogin;
    private javax.swing.JTextField txtEmailLogin;
    private javax.swing.JPasswordField txtSenhaLogin;
    // End of variables declaration//GEN-END:variables
}
