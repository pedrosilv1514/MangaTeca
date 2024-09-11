package telas;

import Classes.Administrador;
import Classes.CarrinhoDeCompras;
import Classes.Compras;
import Classes.Manga;
import Classes.Sistema;
import Classes.UsuarioLogado;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//Tela utilizada para acessar o carrinho de compras do cliente.

public class CarrinhoCompras extends javax.swing.JFrame {
    private CarrinhoDeCompras carrinho;

    public CarrinhoCompras(CarrinhoDeCompras carrinho) {
        this.carrinho = carrinho;
        initComponents();
        imprimirCarrinho();
        carregarCarrinho(); // Carregar e exibir o carrinho
    }
    
    private void carregarCarrinho() {
        DefaultTableModel model = new DefaultTableModel() {
            //Desabilita a edição de elementos da table, apenas deixando a seleção ativa.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Mangá");
        model.addColumn("Quantidade");
        model.addColumn("Preço");

        double subtotal = 0.0;
        for (Compras compra : carrinho.getProdutos()) {
            String nomeManga = compra.getNomeManga() != null ? compra.getNomeManga() : "Desconhecido";
            model.addRow(new Object[]{
                compra.getId(),
                nomeManga,
                compra.getQuantidade(),
                String.format("Total: R$ %.2f", compra.getPreco())
            });

            subtotal += compra.getPreco() * compra.getQuantidade();
        }

        tblCarrinho.setModel(model);
        lblPrecoManga.setText(String.format("R$ %.2f", subtotal));
        System.out.println("Subtotal do carrinho: R$ " + subtotal);
    }

    
    private void imprimirCarrinho() {
        System.out.println("Detalhes do Carrinho:");
        for (Compras compra : carrinho.getProdutos()) {
            System.out.println("ID: " + compra.getId());
            System.out.println("Mangá: " + (compra.getNomeManga() != null ? compra.getNomeManga() : "Desconhecido"));
            System.out.println("Quantidade: " + compra.getQuantidade());
            System.out.println("Preço: R$ " + String.format("%.2f", compra.getPreco()));
            System.out.println("---------------------------");
        }
        System.out.println("Subtotal do carrinho: R$ " + String.format("%.2f", carrinho.getTotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scrllCarrinho = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        lblPrecoManga = new javax.swing.JLabel();
        btnComprar = new javax.swing.JToggleButton();
        btnEsvaziar = new javax.swing.JToggleButton();
        iconUsuario = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        lblCarrinhoDeCompras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MangaTeca - Carrinho de Compras");

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 512));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));
        jPanel2.setLayout(null);

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mangá", "Quantidade", "Preço"
            }
        ));
        scrllCarrinho.setViewportView(tblCarrinho);

        jPanel2.add(scrllCarrinho);
        scrllCarrinho.setBounds(6, 23, 658, 248);

        lblPrecoManga.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPrecoManga.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecoManga.setText(" ");
        jPanel2.add(lblPrecoManga);
        lblPrecoManga.setBounds(260, 277, 165, 32);

        btnComprar.setBackground(new java.awt.Color(218, 0, 55));
        btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(237, 237, 237));
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        jPanel2.add(btnComprar);
        btnComprar.setBounds(90, 320, 190, 42);

        btnEsvaziar.setBackground(new java.awt.Color(218, 0, 55));
        btnEsvaziar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEsvaziar.setForeground(new java.awt.Color(237, 237, 237));
        btnEsvaziar.setText("Esvaziar Carrinho");
        btnEsvaziar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsvaziarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEsvaziar);
        btnEsvaziar.setBounds(390, 320, 187, 42);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 110, 670, 387);

        iconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cliente.png"))); // NOI18N
        jPanel1.add(iconUsuario);
        iconUsuario.setBounds(20, 0, 50, 60);

        jPanel4.setBackground(new java.awt.Color(68, 68, 68));
        jPanel4.setMinimumSize(new java.awt.Dimension(211, 313));

        nome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nome.setForeground(new java.awt.Color(237, 237, 237));
        nome.setText("LabelNomeUsuario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(444, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(nome)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 0, 720, 60);

        lblCarrinhoDeCompras.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCarrinhoDeCompras.setForeground(new java.awt.Color(237, 237, 237));
        lblCarrinhoDeCompras.setText("Carrinho de Compras");
        jPanel1.add(lblCarrinhoDeCompras);
        lblCarrinhoDeCompras.setBounds(220, 70, 270, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        if(carrinho.getProdutos().size() == 0){
            JOptionPane.showMessageDialog(this,"Seu carrinho está vazio! Adicione mangás ao seu carrinho na homepage.","Carrinho vazio", JOptionPane.INFORMATION_MESSAGE);
        } else {
            new Pagamento(carrinho).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnEsvaziarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsvaziarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente esvaziar o carrinho?", "Esvaziar o carrinho", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            for (Compras compra : carrinho.getProdutos()){
                Manga manga = Sistema.procuraManga(compra.getId());
                manga.setEstoque(manga.getEstoque() + compra.getQuantidade());
                Administrador admin = new Administrador();
                admin.atualizarManga(manga, manga);
            }
            carrinho.zerarCarrinho();
            carregarCarrinho();
        }
    }//GEN-LAST:event_btnEsvaziarActionPerformed

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
            java.util.logging.Logger.getLogger(CarrinhoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarrinhoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarrinhoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarrinhoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                        new CarrinhoCompras(carrinho).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Carrinho não encontrado.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    java.util.logging.Logger.getLogger(CarrinhoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o carrinho: " + e.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnComprar;
    private javax.swing.JToggleButton btnEsvaziar;
    private javax.swing.JLabel iconUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCarrinhoDeCompras;
    private javax.swing.JLabel lblPrecoManga;
    private javax.swing.JLabel nome;
    private javax.swing.JScrollPane scrllCarrinho;
    private javax.swing.JTable tblCarrinho;
    // End of variables declaration//GEN-END:variables
}
