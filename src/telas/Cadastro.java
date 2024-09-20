package telas;

import Classes.Usuario;
import java.awt.Cursor;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

//Como o próprio nome diz, é a tela utilizada para cadastrar novos clientes no sistema.

public class Cadastro extends javax.swing.JFrame {
    boolean mostra = false;
    public Cadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuarioCadastro = new javax.swing.JLabel();
        lblSenhaCadastro = new javax.swing.JLabel();
        txtConfirmaCadastro = new javax.swing.JToggleButton();
        txtUsuarioCadastro = new javax.swing.JTextField();
        txtEmailCadastro = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        txtSenhaCadastro = new javax.swing.JPasswordField();
        lblEmailCadastro = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JLabel();
        lblVoltar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MangaTeca - Cadastro");
        setMinimumSize(new java.awt.Dimension(720, 512));
        setPreferredSize(new java.awt.Dimension(720, 512));
        setSize(new java.awt.Dimension(720, 512));

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 512));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 512));
        jPanel1.setLayout(null);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo MangaTeca Pequena.png"))); // NOI18N
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(130, 60, 454, 67);

        lblUsuarioCadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarioCadastro.setForeground(new java.awt.Color(237, 237, 237));
        lblUsuarioCadastro.setText("Nome de Usuário");
        jPanel1.add(lblUsuarioCadastro);
        lblUsuarioCadastro.setBounds(130, 230, 200, 32);

        lblSenhaCadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSenhaCadastro.setForeground(new java.awt.Color(237, 237, 237));
        lblSenhaCadastro.setText("Senha");
        jPanel1.add(lblSenhaCadastro);
        lblSenhaCadastro.setBounds(130, 310, 96, 32);

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
        txtConfirmaCadastro.setBounds(230, 400, 240, 47);

        txtUsuarioCadastro.setBackground(new java.awt.Color(68, 68, 68));
        txtUsuarioCadastro.setForeground(new java.awt.Color(237, 237, 237));
        txtUsuarioCadastro.setToolTipText("");
        txtUsuarioCadastro.addKeyListener(new KeyAdapter() {
            private final String whitelist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@-_!";
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (whitelist.indexOf(c) < 0) {
                    e.consume(); // Ignora o caractere se não estiver na lista permitida
                }
            }
        });
        jPanel1.add(txtUsuarioCadastro);
        txtUsuarioCadastro.setBounds(130, 270, 454, 30);

        txtEmailCadastro.setBackground(new java.awt.Color(68, 68, 68));
        txtEmailCadastro.setForeground(new java.awt.Color(237, 237, 237));
        txtEmailCadastro.setToolTipText("");
        txtEmailCadastro.addKeyListener(new KeyAdapter() {
            private final String whitelist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@-._+*=";
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (whitelist.indexOf(c) < 0) {
                    e.consume(); // Ignora o caractere se não estiver na lista permitida
                }
            }
        });
        jPanel1.add(txtEmailCadastro);
        txtEmailCadastro.setBounds(130, 190, 454, 30);

        labelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Olho aberto.png"))); // NOI18N
        labelSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSenhaMouseClicked(evt);
            }
        });
        jPanel1.add(labelSenha);
        labelSenha.setBounds(550, 340, 30, 50);

        txtSenhaCadastro.setBackground(new java.awt.Color(68, 68, 68));
        txtSenhaCadastro.setForeground(new java.awt.Color(237, 237, 237));
        txtSenhaCadastro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (String.valueOf(c).equals(";")) { //proibindo ";" pois quebra o sistema de csv
                    e.consume();
                }
            }
        });
        jPanel1.add(txtSenhaCadastro);
        txtSenhaCadastro.setBounds(130, 350, 454, 30);

        lblEmailCadastro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEmailCadastro.setForeground(new java.awt.Color(237, 237, 237));
        lblEmailCadastro.setText("E-mail");
        jPanel1.add(lblEmailCadastro);
        lblEmailCadastro.setBounds(130, 150, 96, 32);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmaCadastroActionPerformed
        String txtEmail = txtEmailCadastro.getText();
        String txtUser = txtUsuarioCadastro.getText();
        String txtSenha = txtSenhaCadastro.getText();
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";         //Caracteres que são permitidos antes e depois do @ do email.
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE); 
        Matcher matcher = emailPat.matcher(txtEmail);
        if(txtEmail.equals("")||txtUser.equals("")||txtSenha.equals("")){ //Verifica se todos os campos foram preenchidos
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar." ,"Falha ao cadastrar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(matcher.find() == true){ 
                Usuario.Cadastrar(txtUser, txtEmail, txtSenha);  
            } else { //Caso o email digitado não siga o padrão, vai ser dado como inválido.
                JOptionPane.showMessageDialog(null, "Insira um email válido.", "Falha ao cadastrar", JOptionPane.ERROR_MESSAGE);
            }  
        }
    }//GEN-LAST:event_txtConfirmaCadastroActionPerformed

    private void labelSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSenhaMouseClicked
        //Botão que alterna entre mostrar a senha digitada e ocultá-la.
        if(mostra==false){
            labelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Olho fechado.png")));
            txtSenhaCadastro.setEchoChar((char)0);
            mostra = true;
        }else{
            labelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Olho aberto.png")));
            txtSenhaCadastro.setEchoChar('\u25cf');
            mostra = false;
        }
    }//GEN-LAST:event_labelSenhaMouseClicked

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();//Fecha a tela quando o botão voltar é pressionado, o resto do código está implementado diretamente no botão na aba "Design".
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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel lblEmailCadastro;
    private javax.swing.JLabel lblSenhaCadastro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuarioCadastro;
    private javax.swing.JLabel lblVoltar;
    private javax.swing.JToggleButton txtConfirmaCadastro;
    private javax.swing.JTextField txtEmailCadastro;
    private javax.swing.JPasswordField txtSenhaCadastro;
    private javax.swing.JTextField txtUsuarioCadastro;
    // End of variables declaration//GEN-END:variables
}
