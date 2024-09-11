package telas;

import Classes.Acao;
import Classes.Administrador;
import Classes.Avaliacao;
import Classes.Comedia;
import Classes.Manga;
import Classes.Romance;
import Classes.Sistema;
import Classes.Status;
import Classes.UsuarioLogado;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//Tela utilizada pelo administrador para adicionar, editar ou remover mangás.

public class ConfigAdm extends javax.swing.JFrame {

    String modo = "adicionar"; //String que define o modo de operar da tela, alternando entre adicionar mangá, editar mangá e remover mangá.
    boolean mostra = false; //boolean que define se a imagem contida no linkImagem do mangá estará visível ou não
    DefaultTableModel model = new DefaultTableModel(){
        //Método que define que os elementos da table não poderão ser editados ao dar double click na table
        @Override
        public boolean isCellEditable(int row, int column) {
           return false;
        }
    };
    Administrador admin = new Administrador(); //Instanciando um novo Administrador pois o casting de usuarioLogado para Administrador não é possível.
    public ConfigAdm() {
        initComponents();
        lblTesteImagem.setVisible(false);
        ArrayList<Manga> array = Sistema.ListarMangas();
        //O id do próximo mangá a ser adicionado será sempre a quantidade de mangás no sistema + 1,
        //mesmo que algum mangá da lista esteja com status de removido.
        txtId.setText(String.valueOf(array.size() + 1)); 
        btnRemover.setEnabled(false);
        btnEditar.setEnabled(false);
        ArrayList<Manga> listaMangas = Sistema.ListarMangas();
        model.addColumn("ID");
        model.addColumn("Título");
        model.addColumn("Autor");
        model.addColumn("Gênero");
        model.addColumn("Preço");
        model.addColumn("Estoque");
        for (Manga manga : listaMangas) {
            if ((manga.getStatus()).equals(Status.valueOf("DISPONIVEL"))){ 
                //Adiciona os mangás com status de DISPONÍVEL na tabela, 
                //pois os REMOVIDOS não são mais possíveis de serem acessados.
                model.addRow(new Object[]{
                    manga.getId(),
                    manga.getTitulo(),
                    manga.getAutor(),
                    manga.getGenero().getTipo(),
                    manga.getPreco(),
                    manga.getEstoque()
                });
            }
        }
        tableMangas.setModel(model);
        if (tableMangas.getColumnModel().getColumnCount() > 0) {
            tableMangas.getColumnModel().getColumn(0).setMinWidth(40);
            tableMangas.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableMangas.getColumnModel().getColumn(0).setMaxWidth(40);
            tableMangas.getColumnModel().getColumn(2).setMinWidth(120);
            tableMangas.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableMangas.getColumnModel().getColumn(2).setMaxWidth(120);
            tableMangas.getColumnModel().getColumn(3).setMaxWidth(70);
            tableMangas.getColumnModel().getColumn(3).setPreferredWidth(70);
            tableMangas.getColumnModel().getColumn(3).setMinWidth(70);
            tableMangas.getColumnModel().getColumn(3).setMaxWidth(60);
            tableMangas.getColumnModel().getColumn(4).setMinWidth(65);
            tableMangas.getColumnModel().getColumn(4).setPreferredWidth(65);
            tableMangas.getColumnModel().getColumn(4).setMaxWidth(65);
            tableMangas.getColumnModel().getColumn(5).setMinWidth(70);
            tableMangas.getColumnModel().getColumn(5).setPreferredWidth(70);
            tableMangas.getColumnModel().getColumn(5).setMaxWidth(70);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblAdministrador = new javax.swing.JLabel();
        iconAdministrador = new javax.swing.JLabel();
        pnlLogOut = new javax.swing.JPanel();
        lblLogOut = new javax.swing.JLabel();
        btnVoltarHomepage = new javax.swing.JToggleButton();
        lblTesteImagem = new javax.swing.JLabel();
        lblSinopse = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pnlSinopse = new javax.swing.JScrollPane();
        txtSinopse = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnRemover = new javax.swing.JToggleButton();
        btnAdicionar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMangas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        comboGenero = new javax.swing.JComboBox<>();
        txtLinkImagem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblModo = new javax.swing.JLabel();
        btnModo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        txtPreco = new javax.swing.JFormattedTextField();
        btnTestarImagem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MangaTeca - Gerenciar mangás");
        setMinimumSize(new java.awt.Dimension(820, 612));

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setMinimumSize(new java.awt.Dimension(820, 612));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));
        jPanel2.setMinimumSize(new java.awt.Dimension(211, 313));
        jPanel2.setLayout(null);

        lblAdministrador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAdministrador.setForeground(new java.awt.Color(237, 237, 237));
        lblAdministrador.setText("Administrador");
        jPanel2.add(lblAdministrador);
        lblAdministrador.setBounds(61, 18, 130, 25);

        iconAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/admin.png"))); // NOI18N
        jPanel2.add(iconAdministrador);
        iconAdministrador.setBounds(17, 18, 32, 32);

        pnlLogOut.setBackground(new java.awt.Color(60, 60, 60));

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

        javax.swing.GroupLayout pnlLogOutLayout = new javax.swing.GroupLayout(pnlLogOut);
        pnlLogOut.setLayout(pnlLogOutLayout);
        pnlLogOutLayout.setHorizontalGroup(
            pnlLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        pnlLogOutLayout.setVerticalGroup(
            pnlLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        jPanel2.add(pnlLogOut);
        pnlLogOut.setBounds(718, 0, 104, 61);

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
        btnVoltarHomepage.setBounds(460, 10, 240, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 820, 60);
        jPanel1.add(lblTesteImagem);
        lblTesteImagem.setBounds(530, 70, 250, 210);

        lblSinopse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSinopse.setForeground(new java.awt.Color(237, 237, 237));
        lblSinopse.setText("Sinopse");
        jPanel1.add(lblSinopse);
        lblSinopse.setBounds(460, 100, 50, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(237, 237, 237));
        jLabel5.setText("Administrar Mangás");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(260, 60, 250, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(237, 237, 237));
        jLabel3.setText("Título");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 100, 40, 20);

        txtTitulo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (String.valueOf(c).equals(";")) { //Proibindo o caractere ; pois quebra o sistema de csv.
                    e.consume();
                }
            }
        });
        jPanel1.add(txtTitulo);
        txtTitulo.setBounds(10, 120, 430, 22);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(237, 237, 237));
        jLabel7.setText("Id");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 150, 20, 20);

        txtSinopse.setColumns(1);
        txtSinopse.setLineWrap(true);
        txtSinopse.setRows(5);
        txtSinopse.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (String.valueOf(c).equals(";")) { //Proibindo o ";" pois quebra o sistema de CSV.
                    e.consume();
                }
            }
        });
        pnlSinopse.setViewportView(txtSinopse);

        jPanel1.add(pnlSinopse);
        pnlSinopse.setBounds(460, 120, 350, 130);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(237, 237, 237));
        jLabel9.setText("Autor");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 150, 50, 20);

        txtId.setEditable(false);
        txtId.setEnabled(false);
        jPanel1.add(txtId);
        txtId.setBounds(390, 170, 40, 22);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(237, 237, 237));
        jLabel10.setText("Preço");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 200, 50, 20);

        btnRemover.setBackground(new java.awt.Color(218, 0, 55));
        btnRemover.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(237, 237, 237));
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemover);
        btnRemover.setBounds(520, 280, 170, 40);

        btnAdicionar.setBackground(new java.awt.Color(218, 0, 55));
        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(237, 237, 237));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar);
        btnAdicionar.setBounds(80, 280, 170, 40);

        btnEditar.setBackground(new java.awt.Color(218, 0, 55));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(237, 237, 237));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);
        btnEditar.setBounds(300, 280, 170, 40);

        tableMangas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Autor", "Preço", "Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableMangas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMangasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMangas);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 330, 820, 280);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(237, 237, 237));
        jLabel11.setText("Link da Imagem");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(170, 200, 100, 20);

        txtEstoque.addKeyListener(new KeyAdapter() {
            private final String whitelist = "0123456789";
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (whitelist.indexOf(c) < 0) {
                    e.consume(); // Ignora o caractere se não estiver na lista permitida
                }
            }
        });
        jPanel1.add(txtEstoque);
        txtEstoque.setBounds(90, 220, 60, 22);

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Ação", "Comédia" }));
        jPanel1.add(comboGenero);
        comboGenero.setBounds(280, 170, 90, 22);

        txtLinkImagem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (String.valueOf(c).equals(";")) { //Proibindo o ";" pois quebra o sistema de CSV.
                    e.consume();
                }
            }
        });
        jPanel1.add(txtLinkImagem);
        txtLinkImagem.setBounds(170, 220, 260, 22);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(237, 237, 237));
        jLabel12.setText("Estoque");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(90, 200, 50, 20);

        lblModo.setForeground(new java.awt.Color(237, 237, 237));
        lblModo.setText("Modo Atual: Adicionar mangá");
        jPanel1.add(lblModo);
        lblModo.setBounds(560, 70, 170, 16);

        btnModo.setText("Mudar Modo");
        btnModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoActionPerformed(evt);
            }
        });
        jPanel1.add(btnModo);
        btnModo.setBounds(580, 90, 110, 20);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(237, 237, 237));
        jLabel13.setText("Gênero");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(280, 150, 50, 20);

        txtAutor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (String.valueOf(c).equals(";")) { //Proibindo o ";" pois quebra o sistema de CSV.
                    e.consume();
                }
            }
        });
        jPanel1.add(txtAutor);
        txtAutor.setBounds(10, 170, 260, 22);

        txtPreco.addKeyListener(new KeyAdapter() {
            private final String whitelist = "0123456789.";
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (whitelist.indexOf(c) < 0) {
                    e.consume(); // Ignora o caractere se não estiver na lista permitida
                }
            }
        });
        jPanel1.add(txtPreco);
        txtPreco.setBounds(10, 220, 60, 22);

        btnTestarImagem.setText("Testar Imagem");
        btnTestarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestarImagemActionPerformed(evt);
            }
        });
        jPanel1.add(btnTestarImagem);
        btnTestarImagem.setBounds(310, 250, 120, 23);

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

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente remover " + txtTitulo.getText() + " do sistema?", "Remover mangá", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Manga manga = Sistema.procuraManga((Integer.parseInt(txtId.getText())));
                    admin.removerManga(manga);
                    int linha = tableMangas.getSelectedRow();
                    model.removeRow(linha);
                }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        var gen = (String) comboGenero.getSelectedItem();
        String linkImagem = txtLinkImagem.getText();
        String sinopse = txtSinopse.getText();
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        if(titulo.equals("") || autor.equals("") || sinopse.equals("") || linkImagem.equals("") || txtEstoque.getText().equals("") || txtPreco.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.", "Falha ao adicionar mangá", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int estoque = Integer.parseInt(txtEstoque.getText());
            double preco = Double.parseDouble(txtPreco.getText());
            int novoId = Sistema.ListarMangas().size() + 1;
            if (gen.equals("Ação")){
                Acao genero = new Acao("Acao");
                Manga manga = new Manga(novoId, titulo, sinopse, genero, autor, estoque, preco, avaliacoes, linkImagem);
                model.addRow(new Object[]{
                    manga.getId(),
                    manga.getTitulo(),
                    manga.getAutor(),
                    manga.getGenero().getTipo(),
                    manga.getPreco(),
                    manga.getEstoque()
                });
                admin.adicionarManga(manga);
                JOptionPane.showMessageDialog(null, "Novo mangá adicionado:" + manga.getTitulo(), "Sucesso", JOptionPane.PLAIN_MESSAGE);
                txtId.setText(String.valueOf(novoId+1));
            } else if (gen.equals("Comédia")){
                Comedia genero = new Comedia("Comedia");
                Manga manga = new Manga(novoId, titulo, sinopse, genero, autor, estoque, preco, avaliacoes, linkImagem);
                System.out.println(manga);
                model.addRow(new Object[]{
                    manga.getId(),
                    manga.getTitulo(),
                    manga.getAutor(),
                    manga.getGenero().getTipo(),
                    manga.getPreco(),
                    manga.getEstoque()
                });
                admin.adicionarManga(manga);
                JOptionPane.showMessageDialog(null, "Novo mangá adicionado:" + manga.getTitulo(), "Sucesso", JOptionPane.PLAIN_MESSAGE);
                txtId.setText(String.valueOf(novoId+1));
            } else if (gen.equals("Romance")){
                Romance genero = new Romance("Romance");
                Manga manga = new Manga(novoId, titulo, sinopse, genero, autor, estoque, preco, avaliacoes, linkImagem);
                model.addRow(new Object[]{
                    manga.getId(),
                    manga.getTitulo(),
                    manga.getAutor(),
                    manga.getGenero().getTipo(),
                    manga.getPreco(),
                    manga.getEstoque()
                });
                admin.adicionarManga(manga);
                JOptionPane.showMessageDialog(null, "Novo mangá adicionado:" + manga.getTitulo(), "Sucesso", JOptionPane.PLAIN_MESSAGE);
                txtId.setText(String.valueOf(novoId+1));
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int id = Integer.parseInt(txtId.getText());
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        var gen = (String) comboGenero.getSelectedItem();
        String linkImagem = txtLinkImagem.getText();
        String sinopse = txtSinopse.getText();
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        if(titulo.equals("") || autor.equals("") || sinopse.equals("") || linkImagem.equals("") || txtEstoque.getText().equals("") || txtPreco.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.", "Falha ao adicionar mangá", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int estoque = Integer.parseInt(txtEstoque.getText());
            double preco = Double.parseDouble(txtPreco.getText());
            if (gen.equals("Ação")){
                Acao genero = new Acao("Acao");
                Manga mangaAtualizado = new Manga(id, titulo, sinopse, genero, autor, estoque, preco, avaliacoes, linkImagem);
                admin.atualizarManga(mangaAtualizado, mangaAtualizado);
                DefaultTableModel model = (DefaultTableModel) tableMangas.getModel();
                model.setRowCount(0);
                for (Manga manga : Sistema.ListarMangas()) {
                    if ((manga.getStatus()).equals(Status.valueOf("DISPONIVEL"))){
                        model.addRow(new Object[]{
                            manga.getId(),
                            manga.getTitulo(),
                            manga.getAutor(),
                            manga.getGenero().getTipo(),
                            manga.getPreco(),
                            manga.getEstoque()
                        });
                    }
                }
            } else if (gen.equals("Romance")){
                Romance genero = new Romance("Romance");
                Manga mangaAtualizado = new Manga(id, titulo, sinopse, genero, autor, estoque, preco, avaliacoes, linkImagem);
                admin.atualizarManga(mangaAtualizado, mangaAtualizado);
                DefaultTableModel model = (DefaultTableModel) tableMangas.getModel();
                model.setRowCount(0);
                for (Manga manga : Sistema.ListarMangas()) {
                    if ((manga.getStatus()).equals(Status.valueOf("DISPONIVEL"))){
                        model.addRow(new Object[]{
                            manga.getId(),
                            manga.getTitulo(),
                            manga.getAutor(),
                            manga.getGenero().getTipo(),
                            manga.getPreco(),
                            manga.getEstoque()
                        });
                    }
                }
            } else if (gen.equals("Comédia")){
                Comedia genero = new Comedia("Comedia");
                Manga mangaAtualizado = new Manga(id, titulo, sinopse, genero, autor, estoque, preco, avaliacoes, linkImagem);
                admin.atualizarManga(mangaAtualizado, mangaAtualizado);
                DefaultTableModel model = (DefaultTableModel) tableMangas.getModel();
                model.setRowCount(0);
                for (Manga manga : Sistema.ListarMangas()) {
                    if ((manga.getStatus()).equals(Status.valueOf("DISPONIVEL"))){
                        model.addRow(new Object[]{
                            manga.getId(),
                            manga.getTitulo(),
                            manga.getAutor(),
                            manga.getGenero().getTipo(),
                            manga.getPreco(),
                            manga.getEstoque()
                        });
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnModoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoActionPerformed
        if(modo.equals("adicionar")){
            txtTitulo.setText("");
            txtAutor.setText("");
            txtEstoque.setText("");
            txtPreco.setText("");
            txtSinopse.setText("");
            txtId.setText("");
            txtLinkImagem.setText("");
            modo = "editar";
            lblModo.setText("Modo Atual: Editar mangá");
            btnEditar.setEnabled(true);
            btnAdicionar.setEnabled(false);
        } else if (modo.equals("editar")){
            modo = "remover";
            txtTitulo.setText("");
            txtAutor.setText("");
            txtEstoque.setText("");
            txtPreco.setText("");
            txtSinopse.setText("");
            txtId.setText("");
            txtLinkImagem.setText("");
            txtTitulo.setEnabled(false);
            txtAutor.setEnabled(false);
            txtEstoque.setEnabled(false);
            txtSinopse.setEnabled(false);
            txtPreco.setEnabled(false);
            txtLinkImagem.setEnabled(false);
            comboGenero.setEnabled(false);
            lblModo.setText("Modo Atual: Remover mangá");
            btnEditar.setEnabled(false);
            btnRemover.setEnabled(true);
        } else if (modo.equals("remover")){
            modo = "adicionar";
            txtId.setText(String.valueOf(Sistema.ListarMangas().size() + 1));
            txtTitulo.setText("");
            txtAutor.setText("");
            txtEstoque.setText("");
            txtPreco.setText("");
            txtSinopse.setText("");
            txtLinkImagem.setText("");
            txtTitulo.setEnabled(true);
            txtAutor.setEnabled(true);
            txtEstoque.setEnabled(true);
            txtSinopse.setEnabled(true);
            txtPreco.setEnabled(true);
            txtLinkImagem.setEnabled(true);
            comboGenero.setEnabled(true);
            lblModo.setText("Modo Atual: Adicionar mangá");
            btnAdicionar.setEnabled(true);
            btnRemover.setEnabled(false);
        }
    }//GEN-LAST:event_btnModoActionPerformed

    private void tableMangasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMangasMouseClicked
        if (modo.equals("editar")){
            int linha = tableMangas.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) tableMangas.getModel();
            txtId.setText(model.getValueAt(linha, 0).toString());
            txtTitulo.setText(model.getValueAt(linha, 1).toString());
            txtAutor.setText(model.getValueAt(linha, 2).toString());
            System.out.println(model.getValueAt(linha, 3));
            if (model.getValueAt(linha, 3).equals("Romance")){
                comboGenero.setSelectedItem("Romance");
            } else if (model.getValueAt(linha, 3).equals("Comedia")){
                comboGenero.setSelectedItem("Comédia");
            } else {
                comboGenero.setSelectedItem("Ação");
            }
            txtPreco.setText(model.getValueAt(linha, 4).toString());
            txtEstoque.setText(model.getValueAt(linha, 5).toString());
            for(Manga m : Sistema.ListarMangas()){
                int id = Integer.parseInt(model.getValueAt(linha,0).toString());
                if (m.getId()==id){
                    txtLinkImagem.setText(m.getLinkImagem());
                    txtSinopse.setText(m.getSinopse());
                break;
                }
            }
        } else if (modo.equals("remover")){
            int linha = tableMangas.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) tableMangas.getModel();
            txtId.setText(model.getValueAt(linha, 0).toString());
            txtTitulo.setText(model.getValueAt(linha, 1).toString());
            txtAutor.setText(model.getValueAt(linha, 2).toString());
            comboGenero.setSelectedItem(model.getValueAt(linha, 3));
            txtPreco.setText(model.getValueAt(linha, 4).toString());
            txtEstoque.setText(model.getValueAt(linha, 5).toString());
            txtLinkImagem.setText(Sistema.procuraManga((Integer)(model.getValueAt(linha, 0))).getLinkImagem());
            txtSinopse.setText(String.valueOf(Sistema.procuraManga((Integer)(model.getValueAt(linha, 0))).getEstoque()));
        }
    }//GEN-LAST:event_tableMangasMouseClicked

    private void btnTestarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestarImagemActionPerformed
        if (!txtLinkImagem.getText().equals("")){
            if(mostra == false){
                mostra = true;
                btnModo.setEnabled(false);
                lblTesteImagem.setVisible(true);
                pnlSinopse.setVisible(false);
                txtSinopse.setVisible(false);
                lblSinopse.setVisible(false);
                try {
                    URL url = new URL(txtLinkImagem.getText());
                    ImageIcon iconOriginal = new ImageIcon(url);
                    int larguraNova = 250;
                    int alturaNova = 210;
                    Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(larguraNova, alturaNova, Image.SCALE_SMOOTH);
                    ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
                    lblTesteImagem.setIcon(iconRedimensionado);
                } catch (Exception e) {
                    e.printStackTrace();
                    ImageIcon image = new ImageIcon(getClass().getResource("/Imagens/filenotfound.jpg"));
                    Image imagem = image.getImage().getScaledInstance(220, 150, Image.SCALE_SMOOTH);
                    ImageIcon imagemRedimensionada = new ImageIcon(imagem);
                    lblTesteImagem.setIcon(imagemRedimensionada);
                }
            } else if (mostra==true){
                mostra = false;
                lblTesteImagem.setVisible(false);
                btnModo.setEnabled(true);
                pnlSinopse.setVisible(true);
                txtSinopse.setVisible(true);
                lblSinopse.setVisible(true);
            }   
        }
    }//GEN-LAST:event_btnTestarImagemActionPerformed

    private void btnVoltarHomepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarHomepageActionPerformed
        //Volta para a homepage.
        try {
            new Homepage().setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVoltarHomepageActionPerformed

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        // Confirmação de Logout
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente fazer logout?", "Logout", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Realiza o logout limpando o usuário logado
            UsuarioLogado.getInstance().logout();
            // Fecha a tela atual e retorna para a página principal
            this.dispose();
            new TelaPrincipal().setVisible(true);
        }
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void lblLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseEntered
        pnlLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_lblLogOutMouseEntered

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
            java.util.logging.Logger.getLogger(ConfigAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    new ConfigAdm().setVisible(true);
                } catch (Exception e){
                    java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdicionar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JButton btnModo;
    private javax.swing.JToggleButton btnRemover;
    private javax.swing.JButton btnTestarImagem;
    private javax.swing.JToggleButton btnVoltarHomepage;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JLabel iconAdministrador;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdministrador;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblModo;
    private javax.swing.JLabel lblSinopse;
    private javax.swing.JLabel lblTesteImagem;
    private javax.swing.JPanel pnlLogOut;
    private javax.swing.JScrollPane pnlSinopse;
    private javax.swing.JTable tableMangas;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLinkImagem;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JTextArea txtSinopse;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
