package telas;

import Classes.Cliente;
import Classes.Compras;
import Classes.Sistema;
import Classes.UsuarioLogado;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//Tela utilizada para visualizar o Histórico de compras do cliente, além da opção de alterar seus dados.

public class Perfil extends javax.swing.JFrame {
    boolean editar = false;
    UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
    private void atualizarTela(String nomeUsuario, String emailUsuario, String senhaUsuario){ //Função para atualizar os elementos da tela, quando necessário.
        lblNomeUsuario.setText(nomeUsuario);
        lblNome.setText(nomeUsuario);
        lblEmail.setText(emailUsuario);
        lblSenha.setText(senhaUsuario);
        Cliente cliente = new Cliente(); //Criando uma instância de cliente apenas para poder pegar o histórico de compras do usuário, já que o casting de UsuarioLogado para Cliente não é possível.
        cliente.setNomeUsuario(usuarioLogado.getUsuario().getNomeUsuario());
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Mangá");
        model.addColumn("Quantidade");
        model.addColumn("Data");
        model.addColumn("Total");
        for(Compras compra : cliente.getHistoricoCompras()){
            model.addRow(new Object[]{
                compra.getId(),
                compra.getNomeManga(),
                compra.getQuantidade(),
                compra.getData(),
                String.format("R$ %.2f", compra.getPreco()*compra.getQuantidade())
            });
        }
        tblHistorico.setModel(model);
    }
    public Perfil() {
        initComponents();

        txtNomeUsuario.setVisible(false);
        txtEmailUsuario.setVisible(false);
        txtSenhaUsuario.setVisible(false);
        btnConfirmar.setVisible(false);
        atualizarTela(usuarioLogado.getUsuario().getNomeUsuario(), usuarioLogado.getUsuario().getEmail(), usuarioLogado.getUsuario().getSenha());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        iconUsuario = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JPanel();
        lblLogOut = new javax.swing.JLabel();
        btnVoltarHomepage = new javax.swing.JToggleButton();
        scrollHistorico = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        pnlInformacoes = new javax.swing.JPanel();
        lblMinhasInformacoes = new javax.swing.JLabel();
        lblNomeDeUsuario = new javax.swing.JLabel();
        lblEmail1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        txtEmailUsuario = new javax.swing.JTextField();
        txtSenhaUsuario = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        lblHistoricoCompras = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MangaTeca - Perfil");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 512));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));
        jPanel2.setMinimumSize(new java.awt.Dimension(211, 313));
        jPanel2.setLayout(null);

        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(237, 237, 237));
        lblNomeUsuario.setText("LabelNomeUsuario");
        jPanel2.add(lblNomeUsuario);
        lblNomeUsuario.setBounds(80, 20, 188, 25);

        iconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cliente.png"))); // NOI18N
        jPanel2.add(iconUsuario);
        iconUsuario.setBounds(20, 0, 50, 60);

        btnLogOut.setBackground(new java.awt.Color(60, 60, 60));

        lblLogOut.setBackground(new java.awt.Color(255, 255, 255));
        lblLogOut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLogOut.setForeground(new java.awt.Color(219, 1, 55));
        lblLogOut.setText("    Log out");
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogOutMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout btnLogOutLayout = new javax.swing.GroupLayout(btnLogOut);
        btnLogOut.setLayout(btnLogOutLayout);
        btnLogOutLayout.setHorizontalGroup(
            btnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        btnLogOutLayout.setVerticalGroup(
            btnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        jPanel2.add(btnLogOut);
        btnLogOut.setBounds(617, 0, 104, 61);

        btnVoltarHomepage.setBackground(new java.awt.Color(218, 0, 55));
        btnVoltarHomepage.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVoltarHomepage.setForeground(new java.awt.Color(237, 237, 237));
        btnVoltarHomepage.setText("Voltar para Homepage");
        btnVoltarHomepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarHomepageActionPerformed(evt);
            }
        });
        jPanel2.add(btnVoltarHomepage);
        btnVoltarHomepage.setBounds(369, 10, 240, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 720, 60);

        tblHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mangá", "Quantidade", "Data", "Total"
            }
        ));
        scrollHistorico.setViewportView(tblHistorico);

        jPanel1.add(scrollHistorico);
        scrollHistorico.setBounds(20, 270, 680, 210);

        pnlInformacoes.setBackground(new java.awt.Color(219, 1, 55));
        pnlInformacoes.setLayout(null);

        lblMinhasInformacoes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMinhasInformacoes.setForeground(new java.awt.Color(237, 237, 237));
        lblMinhasInformacoes.setText("Minhas Informações");
        pnlInformacoes.add(lblMinhasInformacoes);
        lblMinhasInformacoes.setBounds(19, 6, 270, 29);

        lblNomeDeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomeDeUsuario.setForeground(new java.awt.Color(237, 237, 237));
        lblNomeDeUsuario.setText("Nome de Usuário:");
        pnlInformacoes.add(lblNomeDeUsuario);
        lblNomeDeUsuario.setBounds(19, 43, 149, 25);

        lblEmail1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail1.setForeground(new java.awt.Color(237, 237, 237));
        lblEmail1.setText("E-mail:");
        pnlInformacoes.add(lblEmail1);
        lblEmail1.setBounds(19, 81, 60, 16);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(237, 237, 237));
        lblNome.setText("LabelNomeUsuario");
        pnlInformacoes.add(lblNome);
        lblNome.setBounds(170, 40, 190, 30);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(237, 237, 237));
        lblEmail.setText("LabelEmailUsuario");
        pnlInformacoes.add(lblEmail);
        lblEmail.setBounds(90, 70, 210, 40);
        pnlInformacoes.add(jLabel17);
        jLabel17.setBounds(500, 144, 0, 0);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlInformacoes.add(btnEditar);
        btnEditar.setBounds(295, 14, 72, 23);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(237, 237, 237));
        jLabel20.setText("Senha:");
        pnlInformacoes.add(jLabel20);
        jLabel20.setBounds(19, 115, 60, 16);

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(237, 237, 237));
        lblSenha.setText("LabelSenhaUsuario");
        pnlInformacoes.add(lblSenha);
        lblSenha.setBounds(85, 110, 210, 30);

        txtNomeUsuario.setToolTipText("");
        txtNomeUsuario.addKeyListener(new KeyAdapter() {
            private final String whitelist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@-_!";
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (whitelist.indexOf(c) < 0) {
                    e.consume(); // Ignora o caractere se não estiver na lista permitida
                }
            }
        });
        pnlInformacoes.add(txtNomeUsuario);
        txtNomeUsuario.setBounds(410, 50, 157, 22);

        txtEmailUsuario.addKeyListener(new KeyAdapter() {
            private final String whitelist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@-._+*=";
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (whitelist.indexOf(c) < 0) {
                    e.consume(); // Ignora o caractere se não estiver na lista permitida
                }
            }
        });
        pnlInformacoes.add(txtEmailUsuario);
        txtEmailUsuario.setBounds(410, 80, 157, 22);

        txtSenhaUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (String.valueOf(c).equals(";")) { //proibindo ";" pois quebra o sistema de csv
                    e.consume();
                }
            }
        });
        pnlInformacoes.add(txtSenhaUsuario);
        txtSenhaUsuario.setBounds(410, 110, 157, 22);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        pnlInformacoes.add(btnConfirmar);
        btnConfirmar.setBounds(450, 140, 84, 23);

        jPanel1.add(pnlInformacoes);
        pnlInformacoes.setBounds(10, 70, 700, 170);

        lblHistoricoCompras.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHistoricoCompras.setForeground(new java.awt.Color(237, 237, 237));
        lblHistoricoCompras.setText("Histórico de Compras");
        jPanel1.add(lblHistoricoCompras);
        lblHistoricoCompras.setBounds(30, 240, 270, 29);

        lblCopyright.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCopyright.setForeground(new java.awt.Color(237, 237, 237));
        lblCopyright.setText("© MangaTeca 2024.");
        jPanel1.add(lblCopyright);
        lblCopyright.setBounds(250, 480, 240, 32);

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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       //Altera entre o modo de edição dos dados do cliente
        if(editar == true){
            txtNomeUsuario.setVisible(false);
            txtEmailUsuario.setVisible(false);
            txtSenhaUsuario.setVisible(false);
            btnConfirmar.setVisible(false);
            editar = false;
        } else {
            editar = true;
            txtNomeUsuario.setVisible(true);
            txtEmailUsuario.setVisible(true);
            txtSenhaUsuario.setVisible(true);
            btnConfirmar.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        boolean jaExiste = false;
        String nomeAntigo = usuarioLogado.getUsuario().getNomeUsuario();
        String emailAntigo = usuarioLogado.getUsuario().getEmail();
        String senhaAntiga = usuarioLogado.getUsuario().getSenha();
        String nomeNovo = txtNomeUsuario.getText();
        String emailNovo = txtEmailUsuario.getText();
        String senhaNova = txtSenhaUsuario.getText();
        if(nomeNovo.equals("")||emailNovo.equals("")||senhaNova.equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para atualizar seus dados!", "Falha ao atualizar dados", JOptionPane.INFORMATION_MESSAGE);
        } else if(nomeNovo.equals("Administrador")||emailNovo.equals("administrador@mangateca.com")){ //Caso o usuário tente mudar seu nome ou e-mail para os cadastrados como administrador do sistema, não será possível.
            JOptionPane.showMessageDialog(null, "Nome de usuário ou Email proibido.", "Falha ao atualizar dados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for(Hashtable<String, String> hashtable : Sistema.ListarUsuarios()){
                if((hashtable.get("nome").equals(nomeAntigo)||hashtable.get("email").equals(emailAntigo))){
                    continue;
                } else if(hashtable.get("nome").equals(nomeNovo)||hashtable.get("email").equals(emailNovo)){
                    JOptionPane.showMessageDialog(null, "O nome de usuário ou email escolhido já está em uso.", "Falha ao atualizar dados", JOptionPane.ERROR_MESSAGE);
                    jaExiste = true;
                    break;
                }
            }      
            if(!jaExiste){
               Sistema.alterarCadastro(nomeAntigo, emailAntigo, nomeNovo, emailNovo, senhaNova);
               usuarioLogado.getUsuario().setNomeUsuario(nomeNovo);
               usuarioLogado.getUsuario().setEmail(emailNovo);
               usuarioLogado.getUsuario().setSenha(senhaNova);
               atualizarTela(usuarioLogado.getUsuario().getNomeUsuario(), usuarioLogado.getUsuario().getEmail(), usuarioLogado.getUsuario().getSenha());
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        // Confirmação de Logout
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente fazer logout?", "Logout", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Realiza o logout limpando o usuário logado
            UsuarioLogado.getInstance().logout();
            // Fecha a tela atual e retorna para a página principal
            this.dispose();
            new TelaPrincipal().setVisible(true);
        }
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void lblLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseEntered
        lblLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_lblLogOutMouseEntered

    private void btnVoltarHomepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarHomepageActionPerformed
        try {
            new Homepage().setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVoltarHomepageActionPerformed

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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    new Perfil().setVisible(true);
                } catch (Exception e) {
                    Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JPanel btnLogOut;
    private javax.swing.JToggleButton btnVoltarHomepage;
    private javax.swing.JLabel iconUsuario;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblHistoricoCompras;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblMinhasInformacoes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeDeUsuario;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlInformacoes;
    private javax.swing.JScrollPane scrollHistorico;
    private javax.swing.JTable tblHistorico;
    private javax.swing.JTextField txtEmailUsuario;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtSenhaUsuario;
    // End of variables declaration//GEN-END:variables
}
