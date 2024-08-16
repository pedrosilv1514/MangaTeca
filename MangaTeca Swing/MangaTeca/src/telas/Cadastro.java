package telas;
import Classes.Cliente;
import telas.TelaPrincipal;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author eduar
 */
public class Cadastro extends javax.swing.JFrame {

    boolean mostra = false;
    public Cadastro() {
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
        lblUsuarioCadastro = new javax.swing.JLabel();
        lblSenhaCadastro = new javax.swing.JLabel();
        txtConfirmaCadastro = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        txtUsuarioCadastro = new javax.swing.JTextField();
        txtEmailCadastro = new javax.swing.JTextField();
        txtSenhaCadastro = new javax.swing.JPasswordField();
        lblEmailCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 512));
        setSize(new java.awt.Dimension(720, 512));

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 512));
        jPanel1.setLayout(null);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo MangaTeca Pequena.png"))); // NOI18N
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(130, 50, 454, 67);

        lblUsuarioCadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarioCadastro.setForeground(new java.awt.Color(237, 237, 237));
        lblUsuarioCadastro.setText("Nome de Usuário");
        jPanel1.add(lblUsuarioCadastro);
        lblUsuarioCadastro.setBounds(130, 210, 200, 32);

        lblSenhaCadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSenhaCadastro.setForeground(new java.awt.Color(237, 237, 237));
        lblSenhaCadastro.setText("Senha");
        jPanel1.add(lblSenhaCadastro);
        lblSenhaCadastro.setBounds(130, 280, 96, 32);

        txtConfirmaCadastro.setBackground(new java.awt.Color(218, 0, 55));
        txtConfirmaCadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtConfirmaCadastro.setForeground(new java.awt.Color(237, 237, 237));
        txtConfirmaCadastro.setText("Finalizar Cadastro");
        txtConfirmaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmaCadastroActionPerformed(evt);
            }
        });
        jPanel1.add(txtConfirmaCadastro);
        txtConfirmaCadastro.setBounds(250, 400, 240, 47);

        jButton1.setBackground(new java.awt.Color(68, 68, 68));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Visibilidade.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(550, 330, 30, 20);

        txtUsuarioCadastro.setBackground(new java.awt.Color(68, 68, 68));
        txtUsuarioCadastro.setForeground(new java.awt.Color(237, 237, 237));
        txtUsuarioCadastro.setToolTipText("");
        jPanel1.add(txtUsuarioCadastro);
        txtUsuarioCadastro.setBounds(130, 250, 454, 22);

        txtEmailCadastro.setBackground(new java.awt.Color(68, 68, 68));
        txtEmailCadastro.setForeground(new java.awt.Color(237, 237, 237));
        txtEmailCadastro.setToolTipText("");
        jPanel1.add(txtEmailCadastro);
        txtEmailCadastro.setBounds(130, 180, 454, 22);

        txtSenhaCadastro.setBackground(new java.awt.Color(68, 68, 68));
        txtSenhaCadastro.setForeground(new java.awt.Color(237, 237, 237));
        txtSenhaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaCadastroActionPerformed(evt);
            }
        });
        jPanel1.add(txtSenhaCadastro);
        txtSenhaCadastro.setBounds(130, 320, 454, 40);

        lblEmailCadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEmailCadastro.setForeground(new java.awt.Color(237, 237, 237));
        lblEmailCadastro.setText("E-mail");
        jPanel1.add(lblEmailCadastro);
        lblEmailCadastro.setBounds(130, 140, 96, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmaCadastroActionPerformed
        String texto3 = txtEmailCadastro.getText();
        if (texto3.contains("@")){
            Cliente novoCliente = new Cliente();
            String texto = txtSenhaCadastro.getText();
            System.out.println(texto);
            String texto2 = txtUsuarioCadastro.getText();
            System.out.println(texto2);
            novoCliente.setEmail(texto3);
            novoCliente.setNomeUsuario(texto2);
            novoCliente.setSenha(texto);
            JOptionPane.showMessageDialog(null, "Novo usuário cadastrado:" + texto2,"Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Insira um e-mail válido!" ,"Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
        }
        //funciona uhu
        
    }//GEN-LAST:event_txtConfirmaCadastroActionPerformed

    private void txtSenhaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaCadastroActionPerformed

    }//GEN-LAST:event_txtSenhaCadastroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //tentei fazer um botão pra deixar a senha visível e escondida
        //mas não funciona, ainda continua mostrando *** no campo de senha
        if (mostra == false){
            mostra = true;
            String senha = txtSenhaCadastro.getText();
            txtSenhaCadastro.setText(senha);
        } else {
            mostra = false;
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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmailCadastro;
    private javax.swing.JLabel lblSenhaCadastro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuarioCadastro;
    private javax.swing.JToggleButton txtConfirmaCadastro;
    private javax.swing.JTextField txtEmailCadastro;
    private javax.swing.JPasswordField txtSenhaCadastro;
    private javax.swing.JTextField txtUsuarioCadastro;
    // End of variables declaration//GEN-END:variables
}