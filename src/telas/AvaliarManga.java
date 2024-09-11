package telas;

import Classes.Avaliacao;
import Classes.Cliente;
import Classes.Manga;
import Classes.Sistema;
import Classes.UsuarioLogado;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class AvaliarManga extends javax.swing.JFrame {
    UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
    public AvaliarManga() throws IOException {
        initComponents();
        ArrayList<Manga> mangas = Sistema.ListarMangas();
        for(Manga m : mangas){
            if(String.valueOf(usuarioLogado.getIdSelecionado()).equals(String.valueOf(m.getId()))){
                setTitle("Mangateca - Avaliando " + m.getTitulo());
                try {
                    URL url = new URL(m.getLinkImagem());
                    ImageIcon iconOriginal = new ImageIcon(url);
                    int larguraNova = 270;
                    int alturaNova = 340;
                    Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(larguraNova, alturaNova, Image.SCALE_SMOOTH);
                    ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
                    labelManga.setIcon(iconRedimensionado);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    ImageIcon image = new ImageIcon(getClass().getResource("/Imagens/filenotfound.jpg"));
                    Image imagem = image.getImage().getScaledInstance(270, 340, Image.SCALE_SMOOTH);
                    ImageIcon imagemRedimensionada = new ImageIcon(imagem);
                    labelManga.setIcon(imagemRedimensionada);
                    break;
                }
            }
        }
        String nomeUsuario = usuarioLogado.getUsuario().getNomeUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrllComentario = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        lblEscreva = new javax.swing.JLabel();
        sliderNota = new javax.swing.JSlider();
        lblAvaliar = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        labelManga = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JLabel();
        lblVoltar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MangaTeca - Avaliar");

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 452));
        jPanel1.setLayout(null);

        txtComentario.setColumns(20);
        txtComentario.setLineWrap(true);
        txtComentario.setRows(5);
        txtComentario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (String.valueOf(c).equals(";")) {
                    e.consume(); // Ignora o caractere se não estiver na lista permitida
                }
            }
        });
        scrllComentario.setViewportView(txtComentario);

        jPanel1.add(scrllComentario);
        scrllComentario.setBounds(330, 180, 340, 160);

        lblEscreva.setBackground(new java.awt.Color(255, 255, 255));
        lblEscreva.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEscreva.setForeground(new java.awt.Color(255, 255, 255));
        lblEscreva.setText("Escreva sua avaliação");
        jPanel1.add(lblEscreva);
        lblEscreva.setBounds(330, 140, 300, 32);

        sliderNota.setBackground(new java.awt.Color(255, 255, 255));
        sliderNota.setForeground(new java.awt.Color(255, 255, 255));
        sliderNota.setMajorTickSpacing(1);
        sliderNota.setMaximum(10);
        sliderNota.setPaintLabels(true);
        jPanel1.add(sliderNota);
        sliderNota.setBounds(330, 80, 200, 36);

        lblAvaliar.setBackground(new java.awt.Color(255, 255, 255));
        lblAvaliar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAvaliar.setForeground(new java.awt.Color(255, 255, 255));
        lblAvaliar.setText("Avaliar");
        jPanel1.add(lblAvaliar);
        lblAvaliar.setBounds(330, 40, 80, 32);

        btnConfirmar.setBackground(new java.awt.Color(218, 0, 55));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar);
        btnConfirmar.setBounds(430, 380, 160, 40);
        jPanel1.add(labelManga);
        labelManga.setBounds(30, 80, 270, 340);

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
        btnVoltar.setBounds(40, 20, 100, 40);
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Fecha a tela atual e abre a homepage
                try{
                    new Homepage().setVisible(true);
                } catch (Exception d){
                    d.printStackTrace();
                }
            }
        });

        lblVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVoltar.setForeground(new java.awt.Color(255, 255, 255));
        lblVoltar.setText("Voltar");
        jPanel1.add(lblVoltar);
        lblVoltar.setBounds(80, 30, 60, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (txtComentario.equals("")){
            JOptionPane.showMessageDialog(this, "Faça um comentário para poder avaliar.", "Falha ao avaliar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int nota = sliderNota.getValue();
            String comentario = txtComentario.getText();
            comentario = comentario.replace(",","|"); //Remove as vírgulas do comentário e as substitui por "|" para não causar problemas no CSV.
            LocalDate data = LocalDate.now();
            UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
            Cliente cliente = new Cliente(); //Instanciando um novo cliente para poder avaliar, visto que não é possível fazer casting de UsuarioLogado para Cliente.
            cliente.setNomeUsuario(usuarioLogado.getUsuario().getNomeUsuario());
            Avaliacao avaliacao = new Avaliacao(nota, comentario, data, cliente, usuarioLogado.getIdSelecionado());
            Manga manga = new Manga(); 
            manga = Sistema.procuraManga(usuarioLogado.getIdSelecionado());
            cliente.adicionarAvaliacao(manga,avaliacao); //A avaliação vai tanto para o CSV dos mangás quanto pro CSV do cliente.
            JOptionPane.showMessageDialog(null, "Avaliação adicionada com sucesso.", "Sucesso.", JOptionPane.INFORMATION_MESSAGE);
            try{
                new Homepage().setVisible(true);
                this.dispose();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
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
            java.util.logging.Logger.getLogger(AvaliarManga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvaliarManga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvaliarManga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvaliarManga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AvaliarManga().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AvaliarManga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelManga;
    private javax.swing.JLabel lblAvaliar;
    private javax.swing.JLabel lblEscreva;
    private javax.swing.JLabel lblVoltar;
    private javax.swing.JScrollPane scrllComentario;
    private javax.swing.JSlider sliderNota;
    private javax.swing.JTextArea txtComentario;
    // End of variables declaration//GEN-END:variables
}
