package telas;

import Classes.CarrinhoDeCompras;
import Classes.UsuarioLogado;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.JOptionPane;

//Tela utilizada para simular o pagamento dos mangás adicionados ao carrinho.

public class Pagamento extends javax.swing.JFrame {
    private CarrinhoDeCompras carrinho; // Iniciando a instância de carrinho de compras para poder usar o método de finalizar compra depois
    boolean mostra = false; 
    UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
    public Pagamento(CarrinhoDeCompras carrinho) {
        this.carrinho = carrinho;
        initComponents();
        lblNomeUsuarioCartao.setText(usuarioLogado.getUsuario().getNomeUsuario());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconCalendario = new javax.swing.JLabel();
        iconMiniCartao = new javax.swing.JLabel();
        lblNomeUsuarioCartao = new javax.swing.JLabel();
        lblSenhaUsuario = new javax.swing.JLabel();
        lblNumeroCartao = new javax.swing.JLabel();
        iconCartao = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        txtSenhaUsuario = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnConfirma = new javax.swing.JButton();
        txtValidade = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JFormattedTextField();
        txtCVC = new javax.swing.JFormattedTextField();
        lblCVC = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JLabel();
        lblVoltar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MangaTeca - Concluir compra");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(720, 480));
        setSize(new java.awt.Dimension(720, 480));

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 480));
        jPanel1.setLayout(null);

        iconCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imagem_calendario.png"))); // NOI18N
        iconCalendario.setText("jLabel7");
        jPanel1.add(iconCalendario);
        iconCalendario.setBounds(610, 220, 20, 20);

        iconMiniCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imagem_cartaozinho_1.png"))); // NOI18N
        jPanel1.add(iconMiniCartao);
        iconMiniCartao.setBounds(600, 140, 30, 30);

        lblNomeUsuarioCartao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNomeUsuarioCartao.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeUsuarioCartao.setText("labelNomeUsuarioGrande");
        jPanel1.add(lblNomeUsuarioCartao);
        lblNomeUsuarioCartao.setBounds(70, 260, 150, 25);

        lblSenhaUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSenhaUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblSenhaUsuario.setText("Senha do usuário");
        jPanel1.add(lblSenhaUsuario);
        lblSenhaUsuario.setBounds(320, 260, 160, 25);

        lblNumeroCartao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNumeroCartao.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroCartao.setText("Número do Cartão");
        jPanel1.add(lblNumeroCartao);
        lblNumeroCartao.setBounds(320, 110, 160, 25);

        iconCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cartão.png"))); // NOI18N
        iconCartao.setText("jLabel1");
        jPanel1.add(iconCartao);
        iconCartao.setBounds(60, 100, 168, 264);

        labelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Olho aberto.png"))); // NOI18N
        labelSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSenhaMouseClicked(evt);
            }
        });
        jPanel1.add(labelSenha);
        labelSenha.setBounds(600, 290, 30, 30);
        jPanel1.add(txtSenhaUsuario);
        txtSenhaUsuario.setBounds(320, 290, 315, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Validade");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(550, 190, 80, 25);

        btnConfirma.setBackground(new java.awt.Color(218, 0, 55));
        btnConfirma.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirma.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirma.setText("Confirmar Compra");
        btnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirma);
        btnConfirma.setBounds(390, 360, 190, 40);

        try {
            txtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtValidade);
        txtValidade.setBounds(530, 220, 100, 22);

        try {
            txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroFocusLost(evt);
            }
        });
        jPanel1.add(txtNumero);
        txtNumero.setBounds(320, 140, 310, 30);

        try {
            txtCVC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCVC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCVCFocusLost(evt);
            }
        });
        jPanel1.add(txtCVC);
        txtCVC.setBounds(320, 220, 64, 22);

        lblCVC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCVC.setForeground(new java.awt.Color(255, 255, 255));
        lblCVC.setText("CVC");
        jPanel1.add(lblCVC);
        lblCVC.setBounds(320, 190, 40, 25);

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
                // Fecha a tela atual e abre o carrinho de compras
                new CarrinhoCompras(carrinho).setVisible(true);
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

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        if("".equals(txtNumero.getText())||"".equals(txtCVC.getText())||"  /  /    ".equals(txtValidade.getText())||"".equals(txtSenhaUsuario.getText())){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de continuar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String numeroCartao = txtNumero.getText().replaceAll("\\s+", ""); //Número do cartão com espaços removidos
            String cvc = txtCVC.getText();
            Calendar cal = Calendar.getInstance();
            String dataValidade = txtValidade.getText();
            String[] dataSplit = dataValidade.split("/");
            int anoAtual = cal.get(Calendar.YEAR);
            //Se o dia informado for maior que 31 ou o mês for maior que 12 ou o ano for menor que o ano atual (cartão vencido) a validade será dada como inválida.
            if(Integer.parseInt(dataSplit[0])>31||Integer.parseInt(dataSplit[1])>12||Integer.parseInt(dataSplit[2])<anoAtual){
                JOptionPane.showMessageDialog(this, "Data de vencimento inválida.", "Falha ao finalizar compra", JOptionPane.ERROR_MESSAGE);
            } else {
                if(!String.valueOf(numeroCartao.length()).equals("16")){
                    JOptionPane.showMessageDialog(this, "Insira todos os 16 dígitos do seu cartão.", "Falha ao finalizar compra", JOptionPane.ERROR_MESSAGE);
                } else {
                    long numero = Long.parseLong(numeroCartao);
                    String senha = txtSenhaUsuario.getText();
                    String senhaUsuario = usuarioLogado.getUsuario().getSenha();
                    if(!senha.equals(senhaUsuario)){
                        JOptionPane.showMessageDialog(this, "Senha incorreta.", "Falha ao finalizar compra", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String nomeUsuario = usuarioLogado.getUsuario().getNomeUsuario();
                        carrinho.finalizarCompra(nomeUsuario, carrinho.getProdutos());
                        JOptionPane.showMessageDialog(this, "Compra realizada com sucesso, aproveite seus mangás!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                        this.dispose();
                    }
                }
            }
        } 
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void labelSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSenhaMouseClicked
        //Botão que alterna entre mostrar a senha digitada e ocultá-la.
        if(mostra==false){
            labelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Olho fechado.png")));
            txtSenhaUsuario.setEchoChar((char)0);
            mostra = true;
        }else{
            labelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Olho aberto.png")));
            txtSenhaUsuario.setEchoChar('\u25cf');
            mostra = false;
        }
    }//GEN-LAST:event_labelSenhaMouseClicked

    private void txtNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroFocusLost
        txtNumero.setFocusLostBehavior(txtNumero.PERSIST); //Faz com que o conteúdo no JFormattedTextField não fique voltando para o que estava escrito antes
    }//GEN-LAST:event_txtNumeroFocusLost

    private void txtCVCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCVCFocusLost
        txtCVC.setFocusLostBehavior(txtCVC.PERSIST); //Faz com que o conteúdo no JFormattedTextField não fique voltando para o que estava escrito antes
    }//GEN-LAST:event_txtCVCFocusLost

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose(); //Fecha a tela quando o botão voltar é pressionado, o resto do código está implementado diretamente no botão na aba "Design".
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_btnVoltarMouseEntered

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Obtém a instância do usuário logado e seu carrinho
                    UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
                    CarrinhoDeCompras carrinho = usuarioLogado.getCarrinho();

                    // Verifica se o carrinho está disponível
                    if (carrinho != null) {
                        new Pagamento(carrinho).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Carrinho não encontrado.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o carrinho: " + e.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirma;
    private javax.swing.JLabel btnVoltar;
    private javax.swing.JLabel iconCalendario;
    private javax.swing.JLabel iconCartao;
    private javax.swing.JLabel iconMiniCartao;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel lblCVC;
    private javax.swing.JLabel lblNomeUsuarioCartao;
    private javax.swing.JLabel lblNumeroCartao;
    private javax.swing.JLabel lblSenhaUsuario;
    private javax.swing.JLabel lblVoltar;
    private javax.swing.JFormattedTextField txtCVC;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JPasswordField txtSenhaUsuario;
    private javax.swing.JFormattedTextField txtValidade;
    // End of variables declaration//GEN-END:variables
}
