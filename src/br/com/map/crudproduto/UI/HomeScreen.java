/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudproduto.UI;

import br.com.map.crudproduto.dao.ProdutoDao;
import br.com.map.crudproduto.model.Produto;
import br.com.map.crudproduto.reports.ReportsManager;
import br.com.map.crudproduto.util.MensagensUtil;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author natan
 */
public class HomeScreen extends javax.swing.JFrame {
            
    
    private ProdutoDao produtoDao;
    private int opcaoRelatorio;
    
    Produto produtoSelecionado;
    /**
     * Creates new form HomeScreen
     */
    public HomeScreen() {
        produtoDao = new ProdutoDao();
        produtoSelecionado = null;
        opcaoRelatorio = 0;
        this.setTitle("Cadastrar produtos");
        initComponents(); 
        setLanguage();        
        preencheTable(null);
    }
    
    void setLanguage(){
        this.PesquisarButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_PESQUISA));
        this.InserirButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_INSERIR));
        this.ExibirButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_EXIBIR));
        this.EditarButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_EDITAR));
        this.RemoverButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_REMOVER));
        this.SairButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_SAIR));
        this.NomeBuscaText.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_PESQUISA));
        this.GerarRelatorioButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_GERAR_RELATORIO));
        ComboRelatorios.setModel(new DefaultComboBoxModel<>(new String[] { MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_COMBO_TODOS), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_COMBO_MAIORES), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_COMBO_WINDOWS) }));
    }
    public void preencheTable(List<Produto> lista){
        try {

            List<Produto> produtos = null;

            if (lista == null) {
                produtos = produtoDao.listProdutos();
            } else {
                produtos = lista;
            }

            DefaultTableModel model;
            model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col){
                    return false;
                }
            };
            
            

            model.setColumnCount(7);
            model.setColumnIdentifiers(new String[]{MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_CODIGO), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_NOME), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_PRECO), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_FABRICANTE), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_COR), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_SISTEMA), MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_DETALHES)});
            model.setRowCount(produtos.size());
            
            for (int i = 0; i < produtos.size(); i++) {

                Produto p = produtos.get(i);

                model.setValueAt(p.getCodigo(), i, 0);
                model.setValueAt(p.getNome(), i, 1);
                model.setValueAt(p.getPreco(), i, 2);
                model.setValueAt(p.getEspecificacao().getFabricante(), i, 3);
                model.setValueAt(p.getEspecificacao().getCor(), i, 4);
                model.setValueAt(p.getEspecificacao().getSistema(), i, 5);
                model.setValueAt(p.getEspecificacao().getDetalhes(), i, 6);
                
            }

            ProdutosTable.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_ERRO_TABELA) + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelButtons = new javax.swing.JPanel();
        InserirButton = new javax.swing.JButton();
        EditarButton = new javax.swing.JButton();
        RemoverButton = new javax.swing.JButton();
        SairButton = new javax.swing.JButton();
        LabelNome = new javax.swing.JLabel();
        ExibirButton = new javax.swing.JButton();
        lingua = new javax.swing.JComboBox<>();
        RelatoriosLabel = new javax.swing.JLabel();
        ComboRelatorios = new javax.swing.JComboBox<>();
        GerarRelatorioButton = new javax.swing.JButton();
        PainelTable = new javax.swing.JPanel();
        ScrollTable = new javax.swing.JScrollPane();
        ProdutosTable = new javax.swing.JTable();
        BuscarPanel = new javax.swing.JPanel();
        BuscarText = new javax.swing.JTextField();
        PesquisarButton = new javax.swing.JButton();
        NomeBuscaText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        InserirButton.setText("Inserir");
        InserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirButtonActionPerformed(evt);
            }
        });

        EditarButton.setText("Editar");
        EditarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarButtonActionPerformed(evt);
            }
        });

        RemoverButton.setText("Remover");
        RemoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverButtonActionPerformed(evt);
            }
        });

        SairButton.setText("Sair");
        SairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairButtonActionPerformed(evt);
            }
        });

        LabelNome.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelNome.setText("CRUD- PRODUTOS");

        ExibirButton.setText("Exibir");
        ExibirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExibirButtonActionPerformed(evt);
            }
        });

        lingua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pt_BR", "en_US", "de_DE", "fr_FR" }));
        lingua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linguaActionPerformed(evt);
            }
        });

        RelatoriosLabel.setText("Relatórios:");

        ComboRelatorios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos os Produtos", "Produtos maiores que 1000", "Produtos com sistema windows" }));
        ComboRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboRelatoriosActionPerformed(evt);
            }
        });

        GerarRelatorioButton.setText("Gerar Relatorio");
        GerarRelatorioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarRelatorioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelButtonsLayout = new javax.swing.GroupLayout(painelButtons);
        painelButtons.setLayout(painelButtonsLayout);
        painelButtonsLayout.setHorizontalGroup(
            painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelButtonsLayout.createSequentialGroup()
                .addComponent(lingua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painelButtonsLayout.createSequentialGroup()
                .addGroup(painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelButtonsLayout.createSequentialGroup()
                        .addGroup(painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelButtonsLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(LabelNome))
                            .addGroup(painelButtonsLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(RelatoriosLabel)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelButtonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExibirButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SairButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RemoverButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InserirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboRelatorios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GerarRelatorioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painelButtonsLayout.setVerticalGroup(
            painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelButtonsLayout.createSequentialGroup()
                .addComponent(lingua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InserirButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoverButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExibirButton)
                .addGap(27, 27, 27)
                .addComponent(RelatoriosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GerarRelatorioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SairButton)
                .addGap(14, 14, 14))
        );

        ProdutosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdutosTableMouseClicked(evt);
            }
        });
        ScrollTable.setViewportView(ProdutosTable);

        PesquisarButton.setText("Pesquisar");
        PesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarButtonActionPerformed(evt);
            }
        });

        NomeBuscaText.setText("Buscar por nome:");

        javax.swing.GroupLayout BuscarPanelLayout = new javax.swing.GroupLayout(BuscarPanel);
        BuscarPanel.setLayout(BuscarPanelLayout);
        BuscarPanelLayout.setHorizontalGroup(
            BuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarPanelLayout.createSequentialGroup()
                .addGroup(BuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuscarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NomeBuscaText)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(BuscarPanelLayout.createSequentialGroup()
                        .addComponent(BuscarText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PesquisarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        BuscarPanelLayout.setVerticalGroup(
            BuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NomeBuscaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisarButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout PainelTableLayout = new javax.swing.GroupLayout(PainelTable);
        PainelTable.setLayout(PainelTableLayout);
        PainelTableLayout.setHorizontalGroup(
            PainelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuscarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)))
        );
        PainelTableLayout.setVerticalGroup(
            PainelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTableLayout.createSequentialGroup()
                .addComponent(BuscarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PainelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirButtonActionPerformed
        ProdutoCadastro editar = new ProdutoCadastro(this, null);
        editar.setVisible(true);
    }//GEN-LAST:event_InserirButtonActionPerformed

    private void RemoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverButtonActionPerformed
        try{
            if(produtoSelecionado != null){
                
                int alt = JOptionPane.showConfirmDialog(this, MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_MENSAGEM_EXCLUIR) + produtoSelecionado.getCodigo()+": "+ produtoSelecionado.getNome() + "?", "sim", JOptionPane.OK_CANCEL_OPTION);
                
                if(alt == JOptionPane.OK_OPTION){
                    produtoDao.deletar(produtoSelecionado.getCodigo());
                    produtoSelecionado = null;
                    preencheTable(null);
                }
            }
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_ERRO_ALTERAR)+ e);
        }
    }//GEN-LAST:event_RemoverButtonActionPerformed

    private void EditarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarButtonActionPerformed
        if (produtoSelecionado != null) {
            ProdutoCadastro editar = new ProdutoCadastro(this, produtoSelecionado);
            editar.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_ERRO_ALTERAR));
        }
    }//GEN-LAST:event_EditarButtonActionPerformed

    private void SairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairButtonActionPerformed

    private void PesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarButtonActionPerformed
        String text = BuscarText.getText();
        try{
            List<Produto> produtos = produtoDao.getProdutosbyText(text);
            preencheTable(produtos);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_ERRO_PESQUISAR)+ e);
        }
    }//GEN-LAST:event_PesquisarButtonActionPerformed

    private void ExibirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExibirButtonActionPerformed
        preencheTable(null);
    }//GEN-LAST:event_ExibirButtonActionPerformed
//seleciona a linguagem
    private void linguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linguaActionPerformed
        String s = (String) lingua.getSelectedItem();
        //System.out.println(s);
        switch(s){
            case "pt_BR":
                MensagensUtil.setLocale(MensagensUtil.PT_BR);
                break;
            case "en_US":
                MensagensUtil.setLocale(MensagensUtil.EN_US);
                break;
            case "fr_FR":
                MensagensUtil.setLocale(MensagensUtil.FR_FR);
                break;
            case "de_DE":
                MensagensUtil.setLocale(MensagensUtil.DE_DE);
                break;
            default:
                MensagensUtil.setLocale(MensagensUtil.PT_BR);
                break;
        }
        setLanguage();
        preencheTable(null);
    }//GEN-LAST:event_linguaActionPerformed

    private void ComboRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboRelatoriosActionPerformed
        this.opcaoRelatorio = ComboRelatorios.getSelectedIndex();
    }//GEN-LAST:event_ComboRelatoriosActionPerformed

    private void GerarRelatorioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarRelatorioButtonActionPerformed
        try{
            List<Produto> produtos;
            
            switch(opcaoRelatorio){
             
                case 0:
                    produtos = produtoDao.listProdutos(); 
                    break;
                case 1:
                    produtos = produtoDao.listProdutosPorPreco((float) 1000);
                    break;
                case 2:
                    produtos = produtoDao.listProdutosPorSistema("Windows"); 
                    break;
                default:
                    produtos = null;
        }
            
            JasperPrint relatorio;
            relatorio = ReportsManager.escreverRelatorio(produtos);
            
            JRViewer view = new JRViewer(relatorio);
            
            JFrame janela = new JFrame();
            janela.add(view);
            janela.setSize(800, 600);
            janela.setVisible(true);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "error "+ e);
        }
    }//GEN-LAST:event_GerarRelatorioButtonActionPerformed
    private void ProdutosTableMouseClicked(java.awt.event.MouseEvent evt) {                                           
      
        try {
            //duploclick
            if(evt.getClickCount() == 2){
                int linha = ProdutosTable.rowAtPoint(evt.getPoint());
                int codigo = (int) ProdutosTable.getModel().getValueAt(linha, 0);
                Produto p = produtoDao.getProduto(codigo);
                ProdutoView Visualizar = new ProdutoView(p);
                Visualizar.setVisible(true);
            }
            // descobre a linha do clique
            int linha = ProdutosTable.rowAtPoint(evt.getPoint());
            // pegar o codigo do produto da linha selecionada
            int codigo = (int) ProdutosTable.getModel().getValueAt(linha, 0);

            produtoSelecionado = produtoDao.getProduto(codigo);

            //System.out.println(produtoSelecionado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_ERRO_TABELA)+ e);
        }
    }
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
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BuscarPanel;
    private javax.swing.JTextField BuscarText;
    private javax.swing.JComboBox<String> ComboRelatorios;
    private javax.swing.JButton EditarButton;
    private javax.swing.JButton ExibirButton;
    private javax.swing.JButton GerarRelatorioButton;
    private javax.swing.JButton InserirButton;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel NomeBuscaText;
    private javax.swing.JPanel PainelTable;
    private javax.swing.JButton PesquisarButton;
    private javax.swing.JTable ProdutosTable;
    private javax.swing.JLabel RelatoriosLabel;
    private javax.swing.JButton RemoverButton;
    private javax.swing.JButton SairButton;
    private javax.swing.JScrollPane ScrollTable;
    private javax.swing.JComboBox<String> lingua;
    private javax.swing.JPanel painelButtons;
    // End of variables declaration//GEN-END:variables
}
