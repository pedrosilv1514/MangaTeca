package telas;

import Classes.Administrador;
import Classes.Avaliacao;
import Classes.CarrinhoDeCompras;
import Classes.Cliente;
import Classes.Compras;
import Classes.Sistema;
import Classes.UsuarioLogado;
import Classes.Manga;
import Classes.Status;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Homepage extends javax.swing.JFrame {
    private CarrinhoDeCompras carrinho; 
    //Como o carrinho de compras reseta toda vez que o cliente sai do programa, 
    //ele será armazenado em uma variável nas telas e passado adiante.
    
    UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
    String nomeUsuario = usuarioLogado.getUsuario() != null ? usuarioLogado.getUsuario().getNomeUsuario() : "Usuário não logado";
    private void atualizarTabela(String filtro) {
        //Função para atualizar a tabela cada vez que uma tecla for digitada no campo de pesquisa
        DefaultTableModel modelo = (DefaultTableModel) tblMangas.getModel();
        modelo.setRowCount(0);

        // Filtrar os mangás com base no que o usuário digita
        for (Manga manga : Sistema.ListarMangas()) {
            if ((manga.getStatus()).equals(Status.valueOf("DISPONIVEL"))&&manga.getTitulo().toLowerCase().contains(filtro.toLowerCase())) {
                modelo.addRow(new Object[]{manga.getId(),
                    manga.getTitulo(),
                    manga.getGenero().getTipo(),
                    manga.getAutor(),
                    manga.getPreco(),
                    manga.getEstoque()});
            }
        }
    }
    Manga manga1; //Mangá top 1, está sendo definido aqui para que o usuário possa clicar na imagem dele e ser direcionado para o mesmo;
    Manga manga2; //Mangá top 2, está sendo definido aqui para que o usuário possa clicar na imagem dele e ser direcionado para o mesmo;
    Manga manga3; //Mangá top 3, está sendo definido aqui para que o usuário possa clicar na imagem dele e ser direcionado para o mesmo.
        public Homepage() throws IOException {
        //Iniciando o carrinho de compras aqui para poder usar como argumento na abertura da tela do carrinho
        carrinho = new CarrinhoDeCompras(); 
             
        initComponents();
        btnAvaliar.setVisible(false);
        scrollAvaliacoes.setVisible(false);
        tblAvaliacoes.setVisible(false);
        btnVoltar.setVisible(false);
        btnPerfil.setVisible(true);
        btnGerenciador.setVisible(false);
        
        try{
            //Sistema para pegar os 3 mangás com maior avaliação no sistema e mostrá-los na tela.
            List<Manga> top3 = Sistema.getTop3();
            for(Manga m : top3){
                System.out.println(m);
            }
            manga1 = top3.get(0);
            manga2 = top3.get(1);
            manga3 = top3.get(2);
            ImageIcon icon1 = new ImageIcon(new URL(manga1.getLinkImagem()));
            ImageIcon icon2 = new ImageIcon(new URL(manga2.getLinkImagem()));
            ImageIcon icon3 = new ImageIcon(new URL(manga3.getLinkImagem()));
            Image imagem1 = icon1.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
            Image imagem2 = icon2.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
            Image imagem3 = icon3.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
            ImageIcon imagemRedimensionada1 = new ImageIcon(imagem1);
            ImageIcon imagemRedimensionada2 = new ImageIcon(imagem2);
            ImageIcon imagemRedimensionada3 = new ImageIcon(imagem3);
            lblManga1.setIcon(imagemRedimensionada1);
            lblManga2.setIcon(imagemRedimensionada2);
            lblManga3.setIcon(imagemRedimensionada3);
            nomeManga1.setText(manga1.getTitulo());
            nomeManga2.setText(manga2.getTitulo());
            nomeManga3.setText(manga3.getTitulo());
            lblNotaManga1.setText(String.valueOf(manga1.calcularMedia(manga1.getAvaliacoes())));
            lblNotaManga2.setText(String.valueOf(manga2.calcularMedia(manga2.getAvaliacoes())));
            lblNotaManga3.setText(String.valueOf(manga3.calcularMedia(manga3.getAvaliacoes())));
            
        } catch (Exception e){
            //Caso falhe por algum motivo, as imagens ficarão com símbolo de "not found"
            e.printStackTrace();
            ImageIcon image = new ImageIcon(getClass().getResource("/Imagens/filenotfound.jpg"));
            Image imagem = image.getImage().getScaledInstance(190, 200, Image.SCALE_SMOOTH);
            ImageIcon imagemRedimensionada = new ImageIcon(imagem);
            lblManga1.setIcon(imagemRedimensionada);
            lblManga2.setIcon(imagemRedimensionada);
            lblManga3.setIcon(imagemRedimensionada);
            
        }

        lblNomeUsuario.setText(nomeUsuario);
        
        //Verifica se o usuário logado é um administrador
        if("Administrador".equals(nomeUsuario)){
            btnAdicionarCarrinho.setVisible(false);
            btnCarrinho.setVisible(false);
            btnGerenciador.setVisible(true);
            btnPerfil.setVisible(false);
            iconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/admin.png")));
        } else {
            iconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cliente.png")));
        }

        ArrayList<Manga> listaMangas = Sistema.ListarMangas();
        DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
           return false;
        }
    };  
        model.addColumn("ID");
        model.addColumn("Título");
        model.addColumn("Gênero");
        model.addColumn("Autor");
        model.addColumn("Preço");
        model.addColumn("Estoque");

        for (Manga manga : listaMangas) {
            if ((manga.getStatus()).equals(Status.valueOf("DISPONIVEL"))){ 
                //Todo mangá com status de disponivel será adicionado à lista
                model.addRow(new Object[]{
                    manga.getId(),
                    manga.getTitulo(),
                    manga.getGenero().getTipo(),
                    manga.getAutor(),
                    manga.getPreco(),
                    manga.getEstoque()
                });
            }
        }
        tblMangas.setModel(model);
        txtProcurar.addKeyListener(new KeyAdapter() {
            //Key listener para reconhecer toda tecla que o usuário digitar na barra de pesquisa,
            //e atualizará a table de mangás conforme o filtro.
                @Override
                public void keyReleased(KeyEvent e) {
                    atualizarTabela(txtProcurar.getText());
                }
            });
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaInicial = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        pnlLogOut = new javax.swing.JPanel();
        lblLogOut = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JToggleButton();
        iconUsuario = new javax.swing.JLabel();
        btnCarrinho = new javax.swing.JToggleButton();
        btnGerenciador = new javax.swing.JToggleButton();
        txtProcurar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pnlManga2 = new javax.swing.JPanel();
        lblManga2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlManga1 = new javax.swing.JPanel();
        lblManga1 = new javax.swing.JLabel();
        pnlManga3 = new javax.swing.JPanel();
        lblManga3 = new javax.swing.JLabel();
        scrollMangas = new javax.swing.JScrollPane();
        tblMangas = new javax.swing.JTable();
        lblMangaSelecionado = new javax.swing.JLabel();
        nomeManga2 = new javax.swing.JLabel();
        nomeManga1 = new javax.swing.JLabel();
        nomeManga3 = new javax.swing.JLabel();
        lblNotaManga2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNotaManga1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNotaManga3 = new javax.swing.JLabel();
        lblImagemManga = new javax.swing.JLabel();
        lblModo = new javax.swing.JLabel();
        btnAvaliacoes = new javax.swing.JToggleButton();
        btnAdicionarCarrinho = new javax.swing.JToggleButton();
        lblAutor = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JToggleButton();
        scrollAvaliacoes = new javax.swing.JScrollPane();
        tblAvaliacoes = new javax.swing.JTable();
        btnAvaliar = new javax.swing.JToggleButton();
        scrllSinopse = new javax.swing.JScrollPane();
        sinopseSelecionado = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Homepage");
        setMinimumSize(new java.awt.Dimension(1224, 774));
        setSize(new java.awt.Dimension(1224, 774));

        telaInicial.setBackground(new java.awt.Color(23, 23, 23));
        telaInicial.setPreferredSize(new java.awt.Dimension(720, 512));
        telaInicial.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));
        jPanel2.setMinimumSize(new java.awt.Dimension(211, 313));
        jPanel2.setLayout(null);

        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(237, 237, 237));
        lblNomeUsuario.setText("LabelNomeUsuario");
        jPanel2.add(lblNomeUsuario);
        lblNomeUsuario.setBounds(90, 20, 188, 25);

        pnlLogOut.setBackground(new java.awt.Color(60, 60, 60));

        lblLogOut.setBackground(new java.awt.Color(255, 255, 255));
        lblLogOut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLogOut.setForeground(new java.awt.Color(219, 1, 55));
        lblLogOut.setText("     Log out");
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
            .addGroup(pnlLogOutLayout.createSequentialGroup()
                .addComponent(lblLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlLogOutLayout.setVerticalGroup(
            pnlLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jPanel2.add(pnlLogOut);
        pnlLogOut.setBounds(1113, 0, 117, 58);

        btnPerfil.setBackground(new java.awt.Color(218, 0, 55));
        btnPerfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(237, 237, 237));
        btnPerfil.setSelected(true);
        btnPerfil.setText("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        jPanel2.add(btnPerfil);
        btnPerfil.setBounds(1000, 10, 90, 40);
        jPanel2.add(iconUsuario);
        iconUsuario.setBounds(30, 0, 50, 60);

        btnCarrinho.setBackground(new java.awt.Color(218, 0, 55));
        btnCarrinho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCarrinho.setForeground(new java.awt.Color(237, 237, 237));
        btnCarrinho.setSelected(true);
        btnCarrinho.setText("Carrinho de Compras");
        btnCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrinhoActionPerformed(evt);
            }
        });
        jPanel2.add(btnCarrinho);
        btnCarrinho.setBounds(810, 10, 170, 40);

        btnGerenciador.setBackground(new java.awt.Color(218, 0, 55));
        btnGerenciador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGerenciador.setForeground(new java.awt.Color(237, 237, 237));
        btnGerenciador.setSelected(true);
        btnGerenciador.setText("Gerenciador");
        btnGerenciador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciadorActionPerformed(evt);
            }
        });
        jPanel2.add(btnGerenciador);
        btnGerenciador.setBounds(970, 10, 124, 40);

        telaInicial.add(jPanel2);
        jPanel2.setBounds(0, 0, 1230, 60);
        telaInicial.add(txtProcurar);
        txtProcurar.setBounds(610, 420, 580, 22);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/silver crown.png"))); // NOI18N
        telaInicial.add(jLabel6);
        jLabel6.setBounds(120, 50, 90, 70);

        pnlManga2.setToolTipText("");
        pnlManga2.setLayout(null);

        lblManga2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManga2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManga2MouseEntered(evt);
            }
        });
        pnlManga2.add(lblManga2);
        lblManga2.setBounds(0, 0, 190, 200);

        telaInicial.add(pnlManga2);
        pnlManga2.setBounds(70, 100, 190, 200);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/copper crown.png"))); // NOI18N
        telaInicial.add(jLabel2);
        jLabel2.setBounds(990, 50, 90, 70);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gold crown.png"))); // NOI18N
        telaInicial.add(jLabel4);
        jLabel4.setBounds(550, 50, 90, 70);

        lblManga1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManga1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManga1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlManga1Layout = new javax.swing.GroupLayout(pnlManga1);
        pnlManga1.setLayout(pnlManga1Layout);
        pnlManga1Layout.setHorizontalGroup(
            pnlManga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
            .addGroup(pnlManga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblManga1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );
        pnlManga1Layout.setVerticalGroup(
            pnlManga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(pnlManga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblManga1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );

        telaInicial.add(pnlManga1);
        pnlManga1.setBounds(500, 100, 190, 200);

        lblManga3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManga3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManga3MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlManga3Layout = new javax.swing.GroupLayout(pnlManga3);
        pnlManga3.setLayout(pnlManga3Layout);
        pnlManga3Layout.setHorizontalGroup(
            pnlManga3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblManga3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        pnlManga3Layout.setVerticalGroup(
            pnlManga3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblManga3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        telaInicial.add(pnlManga3);
        pnlManga3.setBounds(940, 100, 190, 200);

        tblMangas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Genero", "Autor", "Preço", "Estoque"
            }
        ));
        tblMangas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMangasMouseClicked(evt);
            }
        });
        scrollMangas.setViewportView(tblMangas);

        telaInicial.add(scrollMangas);
        scrollMangas.setBounds(610, 450, 580, 190);

        lblMangaSelecionado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMangaSelecionado.setForeground(new java.awt.Color(255, 255, 255));
        lblMangaSelecionado.setText("Mangá");
        telaInicial.add(lblMangaSelecionado);
        lblMangaSelecionado.setBounds(360, 370, 230, 25);

        nomeManga2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeManga2.setForeground(new java.awt.Color(255, 255, 255));
        telaInicial.add(nomeManga2);
        nomeManga2.setBounds(70, 310, 140, 20);

        nomeManga1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeManga1.setForeground(new java.awt.Color(255, 255, 255));
        telaInicial.add(nomeManga1);
        nomeManga1.setBounds(500, 310, 150, 20);

        nomeManga3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeManga3.setForeground(new java.awt.Color(255, 255, 255));
        telaInicial.add(nomeManga3);
        nomeManga3.setBounds(940, 310, 140, 20);

        lblNotaManga2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNotaManga2.setForeground(new java.awt.Color(255, 255, 255));
        lblNotaManga2.setText("0.0");
        telaInicial.add(lblNotaManga2);
        lblNotaManga2.setBounds(210, 310, 40, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Star.png"))); // NOI18N
        telaInicial.add(jLabel3);
        jLabel3.setBounds(240, 310, 24, 22);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Star.png"))); // NOI18N
        telaInicial.add(jLabel5);
        jLabel5.setBounds(680, 310, 24, 22);

        lblNotaManga1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNotaManga1.setForeground(new java.awt.Color(255, 255, 255));
        lblNotaManga1.setText("0.0");
        telaInicial.add(lblNotaManga1);
        lblNotaManga1.setBounds(650, 310, 40, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Star.png"))); // NOI18N
        telaInicial.add(jLabel7);
        jLabel7.setBounds(1110, 310, 24, 22);

        lblNotaManga3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNotaManga3.setForeground(new java.awt.Color(255, 255, 255));
        lblNotaManga3.setText("0.0");
        telaInicial.add(lblNotaManga3);
        lblNotaManga3.setBounds(1080, 310, 40, 20);

        lblImagemManga.setForeground(new java.awt.Color(255, 255, 255));
        telaInicial.add(lblImagemManga);
        lblImagemManga.setBounds(30, 380, 300, 340);

        lblModo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblModo.setForeground(new java.awt.Color(255, 255, 255));
        lblModo.setText("Procurar Mangás no Acervo");
        telaInicial.add(lblModo);
        lblModo.setBounds(610, 380, 260, 25);

        btnAvaliacoes.setBackground(new java.awt.Color(218, 0, 55));
        btnAvaliacoes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAvaliacoes.setForeground(new java.awt.Color(237, 237, 237));
        btnAvaliacoes.setSelected(true);
        btnAvaliacoes.setText("Avaliações");
        btnAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliacoesActionPerformed(evt);
            }
        });
        telaInicial.add(btnAvaliacoes);
        btnAvaliacoes.setBounds(380, 710, 190, 40);

        btnAdicionarCarrinho.setBackground(new java.awt.Color(218, 0, 55));
        btnAdicionarCarrinho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdicionarCarrinho.setForeground(new java.awt.Color(237, 237, 237));
        btnAdicionarCarrinho.setSelected(true);
        btnAdicionarCarrinho.setText("Adicionar ao carrinho");
        btnAdicionarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCarrinhoActionPerformed(evt);
            }
        });
        telaInicial.add(btnAdicionarCarrinho);
        btnAdicionarCarrinho.setBounds(380, 660, 190, 40);

        lblAutor.setForeground(new java.awt.Color(255, 255, 255));
        lblAutor.setText("Autor");
        telaInicial.add(lblAutor);
        lblAutor.setBounds(360, 400, 150, 16);

        lblPreco.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPreco.setForeground(new java.awt.Color(51, 204, 0));
        lblPreco.setText("0.0");
        telaInicial.add(lblPreco);
        lblPreco.setBounds(430, 620, 80, 30);

        btnVoltar.setBackground(new java.awt.Color(218, 0, 55));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(237, 237, 237));
        btnVoltar.setSelected(true);
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        telaInicial.add(btnVoltar);
        btnVoltar.setBounds(990, 650, 190, 40);

        tblAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Usuario", "Comentario", "Nota", "Data"
            }
        ));
        tblAvaliacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAvaliacoesMouseClicked(evt);
            }
        });
        scrollAvaliacoes.setViewportView(tblAvaliacoes);

        telaInicial.add(scrollAvaliacoes);
        scrollAvaliacoes.setBounds(610, 450, 580, 190);

        btnAvaliar.setBackground(new java.awt.Color(218, 0, 55));
        btnAvaliar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAvaliar.setForeground(new java.awt.Color(237, 237, 237));
        btnAvaliar.setSelected(true);
        btnAvaliar.setText("Avaliar");
        btnAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliarActionPerformed(evt);
            }
        });
        telaInicial.add(btnAvaliar);
        btnAvaliar.setBounds(780, 650, 190, 40);

        scrllSinopse.setBackground(new java.awt.Color(23, 23, 23));
        scrllSinopse.setBorder(null);

        sinopseSelecionado.setEditable(false);
        sinopseSelecionado.setBackground(new java.awt.Color(23, 23, 23));
        sinopseSelecionado.setBorder(null);
        sinopseSelecionado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sinopseSelecionado.setForeground(new java.awt.Color(255, 255, 255));
        sinopseSelecionado.setRequestFocusEnabled(false);
        sinopseSelecionado.setVerifyInputWhenFocusTarget(false);
        scrllSinopse.setViewportView(sinopseSelecionado);

        telaInicial.add(scrllSinopse);
        scrllSinopse.setBounds(360, 430, 220, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 1224, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliacoesActionPerformed
        //Se o usuário for um administrador, não poderá fazer avaliações.
        if("Administrador".equals(nomeUsuario)){
            btnAvaliar.setVisible(false);
        } else{
            btnAvaliar.setVisible(true);
        }
        tblMangas.setVisible(false);
        lblModo.setText("Avaliações");
        txtProcurar.setVisible(false);
        scrollMangas.setVisible(false);
        scrollAvaliacoes.setVisible(true);
        tblAvaliacoes.setVisible(true);
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
    
        model.addColumn("Usuário");
        model.addColumn("Comentário");
        model.addColumn("Nota");
        model.addColumn("Data");
        
        ArrayList<Avaliacao> avaliacoes = (Sistema.procuraManga(usuarioLogado.getIdSelecionado())).getAvaliacoes();
        for (Avaliacao avaliacao : avaliacoes) {
                model.addRow(new Object[]{
                    avaliacao.getCliente(),
                    avaliacao.getComentario().replace("|", ","),//Substituindo os "|" no csv por vírgula
                    avaliacao.getNota(),
                    avaliacao.getData(),
            });
        }
        tblAvaliacoes.setModel(model);
        btnVoltar.setVisible(true);
    }//GEN-LAST:event_btnAvaliacoesActionPerformed

    private void btnAdicionarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCarrinhoActionPerformed
        //Adicionará um mangá ao carrinho, sendo pela linha 
        //que estiver selecionada na tabela de mangás disponíveis.
        int selectedRow = tblMangas.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (Integer) tblMangas.getValueAt(selectedRow, 0);
            String titulo = (String) tblMangas.getValueAt(selectedRow, 1);
            double preco = (Double) tblMangas.getValueAt(selectedRow, 4);
            int estoque = (Integer) tblMangas.getValueAt(selectedRow, 5);

            Manga manga = Sistema.procuraManga(id);
            if(manga.getEstoque() != 0){
                carrinho.adicionarManga(manga);
                Administrador admin = new Administrador(); //Instanciando um novo administrador para poder atualizar o mangá no csv, pois o casting de UsuarioLogado para Administrador não é possível
                Manga mangaNovo = manga;
                mangaNovo.setEstoque(manga.getEstoque()-1);
                admin.atualizarManga(manga, manga);
                tblMangas.setValueAt(estoque-1,selectedRow, 5);
                JOptionPane.showMessageDialog(this, "Manga adicionado ao carrinho!");
            } else {
                JOptionPane.showMessageDialog(this, "Este mangá está fora de estoque!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um mangá para adicionar ao carrinho.");
        }
    }//GEN-LAST:event_btnAdicionarCarrinhoActionPerformed

    private void tblMangasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMangasMouseClicked
        // Tabela clicável que servirá para mostrar os dados dos mangás na tela, além de possilibitar serem adicionados ao carrinho.              
        int selectedRow = tblMangas.getSelectedRow();

        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblMangas.getModel();
            String titulo = model.getValueAt(selectedRow, 1).toString();
            String genero = model.getValueAt(selectedRow, 2).toString();
            String autor = model.getValueAt(selectedRow, 3).toString();
            String preco = model.getValueAt(selectedRow, 4).toString();
            String estoque = model.getValueAt(selectedRow, 5).toString();
            lblMangaSelecionado.setText(titulo);
            lblAutor.setText(autor);
            lblPreco.setText("R$" + preco);
            String linkImagem; // Aqui você deve pegar o link da imagem do CSV para o mangá selecionado
            
            ArrayList<Manga> mangas = Sistema.ListarMangas();
            String ID = String.valueOf(model.getValueAt(selectedRow, 0));
            usuarioLogado.setIdSelecionado(Integer.parseInt(ID));
            
            Manga m = Sistema.procuraManga(Integer.parseInt(ID));
            linkImagem = m.getLinkImagem();
            String sinopse = m.getSinopse();
            try {
                URL url = new URL(linkImagem);
                ImageIcon iconOriginal = new ImageIcon(url);
                int larguraNova = 300;
                int alturaNova = 340;
                Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(larguraNova, alturaNova, Image.SCALE_SMOOTH);
                ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
                lblImagemManga.setIcon(iconRedimensionado);
                sinopseSelecionado.setText(sinopse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
    }//GEN-LAST:event_tblMangasMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        //Ao clicar o botão de voltar a tabela de avaliações será escondida e a de mangá voltará ao lugar.
        btnAvaliar.setVisible(false);
        tblMangas.setVisible(true);
        lblModo.setText("Procurar Mangás no Acervo");
        txtProcurar.setVisible(true);
        scrollMangas.setVisible(true);
        scrollAvaliacoes.setVisible(false);
        tblAvaliacoes.setVisible(false);
        btnVoltar.setVisible(false);
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tblAvaliacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAvaliacoesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAvaliacoesMouseClicked

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        //Abre a tela de perfil
        try{
            Perfil perfil = new Perfil();
            perfil.setVisible(true);
            this.dispose();
            } catch(Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
            //Abre a tela de avaliação se o cliente não tiver avaliado o mangá antes e se ele estiver em seu histórico de compras
            try {
                UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
                Cliente cliente = new Cliente(); //Instanciando novo Cliente pois o casting de UsuarioLogado para Cliente não é possível.
                cliente.setNomeUsuario(usuarioLogado.getUsuario().getNomeUsuario());
                var historicoCompras = cliente.getHistoricoCompras();
                boolean comprou = false;
                boolean avaliou = false;
                for(Compras c : historicoCompras){
                    if (String.valueOf(c.getId()).equals(String.valueOf(usuarioLogado.getIdSelecionado()))){
                        comprou= true;
                        break;
                    }
                }
                if(comprou){
                    for(Avaliacao avaliacao : cliente.getAvaliacoes()){
                        if(avaliacao.getIdManga() == usuarioLogado.getIdSelecionado()){
                            avaliou = true;
                            break;
                        }
                    }
                    if (avaliou){
                        JOptionPane.showMessageDialog(this, "Você já avaliou este mangá!", "Falha ao abrir tela de avaliação", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        new AvaliarManga().setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this,"Você precisa ter comprado o mangá para poder avaliá-lo!","Falha ao avaliar", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }//GEN-LAST:event_btnAvaliarActionPerformed

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
        pnlLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_lblLogOutMouseEntered

    private void btnCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrinhoActionPerformed
        // Acessando o Carrinho
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras(carrinho);
        carrinhoCompras.setVisible(true);
    }//GEN-LAST:event_btnCarrinhoActionPerformed

    private void btnGerenciadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciadorActionPerformed
        //Abre a tela de configuração de mangás.
        new ConfigAdm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGerenciadorActionPerformed

    private void lblManga2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManga2MouseClicked
        //Possibilita o acesso aos dados do mangá top 2 clicando na imagem dele.
        usuarioLogado.setIdSelecionado(manga2.getId());
        lblMangaSelecionado.setText(manga2.getTitulo());
        lblAutor.setText(manga2.getAutor());
        lblPreco.setText("R$" + manga2.getPreco());
        sinopseSelecionado.setText(manga2.getSinopse());
        try {
            URL url = new URL(manga2.getLinkImagem());
            ImageIcon iconOriginal = new ImageIcon(url);
            int larguraNova = 300;
            int alturaNova = 340;
            Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(larguraNova, alturaNova, Image.SCALE_SMOOTH);
            ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
            lblImagemManga.setIcon(iconRedimensionado); // Altere o JLabel para a imagem do mangá
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }//GEN-LAST:event_lblManga2MouseClicked

    private void lblManga1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManga1MouseClicked
        //Possibilita o acesso aos dados do mangá top 1 clicando na imagem dele.
        usuarioLogado.setIdSelecionado(manga1.getId());
        lblMangaSelecionado.setText(manga1.getTitulo());
        lblAutor.setText(manga1.getAutor());
        lblPreco.setText("R$" + manga1.getPreco());
        sinopseSelecionado.setText(manga1.getSinopse());
        try {
            URL url = new URL(manga1.getLinkImagem());
            ImageIcon iconOriginal = new ImageIcon(url);
            int larguraNova = 300;
            int alturaNova = 340;
            Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(larguraNova, alturaNova, Image.SCALE_SMOOTH);
            ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
            lblImagemManga.setIcon(iconRedimensionado); // Altere o JLabel para a imagem do mangá
            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_lblManga1MouseClicked

    private void lblManga3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManga3MouseClicked
        //Possibilita o acesso aos dados do mangá top 3 clicando na imagem dele.
        usuarioLogado.setIdSelecionado(manga3.getId());
        lblMangaSelecionado.setText(manga3.getTitulo());
        lblAutor.setText(manga3.getAutor());
        lblPreco.setText("R$" + manga3.getPreco());
        sinopseSelecionado.setText(manga3.getSinopse());
        try {
            URL url = new URL(manga3.getLinkImagem());
            ImageIcon iconOriginal = new ImageIcon(url);
            int larguraNova = 300;
            int alturaNova = 340;
            Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(larguraNova, alturaNova, Image.SCALE_SMOOTH);
            ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
            lblImagemManga.setIcon(iconRedimensionado); // Altere o JLabel para a imagem do mangá
            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_lblManga3MouseClicked

    private void lblManga2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManga2MouseEntered
        lblManga2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_lblManga2MouseEntered

    private void lblManga1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManga1MouseEntered
        lblManga1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_lblManga1MouseEntered

    private void lblManga3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManga3MouseEntered
        lblManga3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Muda o mouse para a aparência de "botão clicável"
    }//GEN-LAST:event_lblManga3MouseEntered

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Homepage().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdicionarCarrinho;
    private javax.swing.JToggleButton btnAvaliacoes;
    private javax.swing.JToggleButton btnAvaliar;
    private javax.swing.JToggleButton btnCarrinho;
    private javax.swing.JToggleButton btnGerenciador;
    private javax.swing.JToggleButton btnPerfil;
    private javax.swing.JToggleButton btnVoltar;
    private javax.swing.JLabel iconUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblImagemManga;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblManga1;
    private javax.swing.JLabel lblManga2;
    private javax.swing.JLabel lblManga3;
    private javax.swing.JLabel lblMangaSelecionado;
    private javax.swing.JLabel lblModo;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblNotaManga1;
    private javax.swing.JLabel lblNotaManga2;
    private javax.swing.JLabel lblNotaManga3;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel nomeManga1;
    private javax.swing.JLabel nomeManga2;
    private javax.swing.JLabel nomeManga3;
    private javax.swing.JPanel pnlLogOut;
    private javax.swing.JPanel pnlManga1;
    private javax.swing.JPanel pnlManga2;
    private javax.swing.JPanel pnlManga3;
    private javax.swing.JScrollPane scrllSinopse;
    private javax.swing.JScrollPane scrollAvaliacoes;
    private javax.swing.JScrollPane scrollMangas;
    private javax.swing.JTextPane sinopseSelecionado;
    private javax.swing.JTable tblAvaliacoes;
    private javax.swing.JTable tblMangas;
    private javax.swing.JPanel telaInicial;
    private javax.swing.JTextField txtProcurar;
    // End of variables declaration//GEN-END:variables
}
