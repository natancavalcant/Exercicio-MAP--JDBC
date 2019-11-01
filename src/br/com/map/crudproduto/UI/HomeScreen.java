/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudproduto.UI;

import br.com.map.crudproduto.dao.ProdutoDao;
import br.com.map.crudproduto.model.Produto;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author natan
 */
public class HomeScreen extends javax.swing.JFrame {
    
    private ProdutoDao produtoDao;
    Produto produtoSelecionado;
    /**
     * Creates new form HomeScreen
     */
    public HomeScreen() {
        produtoDao = new ProdutoDao();
        produtoSelecionado = null;
        this.setTitle("Cadastrar produtos");
        initComponents();        
        preencheTable(null);
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
            
            

            model.setColumnCount(8);
            model.setColumnIdentifiers(new String[]{"Código", "Nome", "Preco", "Especificacao","Fabricante", "Cor", "SO", "Detalhes"});
            model.setRowCount(produtos.size());
            
            for (int i = 0; i < produtos.size(); i++) {

                Produto p = produtos.get(i);

                model.setValueAt(p.getCodigo(), i, 0);
                model.setValueAt(p.getNome(), i, 1);
                model.setValueAt(p.getPreco(), i, 2);
                model.setValueAt(p.getEspecificacao().getCodigo(), i, 3);
                model.setValueAt(p.getEspecificacao().getFabricante(), i, 4);
                model.setValueAt(p.getEspecificacao().getCor(), i, 5);
                model.setValueAt(p.getEspecificacao().getSistema(), i, 6);
                model.setValueAt(p.getEspecificacao().getDetalhes(), i, 7);
                
            }

            ProdutosTable.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
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

        javax.swing.GroupLayout painelButtonsLayout = new javax.swing.GroupLayout(painelButtons);
        painelButtons.setLayout(painelButtonsLayout);
        painelButtonsLayout.setHorizontalGroup(
            painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelButtonsLayout.createSequentialGroup()
                .addGroup(painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelButtonsLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(LabelNome)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(painelButtonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExibirButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SairButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RemoverButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InserirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painelButtonsLayout.setVerticalGroup(
            painelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(InserirButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoverButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExibirButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SairButton))
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
                    .addComponent(ScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)))
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
    }// </editor-fold>//GEN-END:initComponents

    private void InserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirButtonActionPerformed
        ProdutoCadastro editar = new ProdutoCadastro(this, null);
        editar.setVisible(true);
    }//GEN-LAST:event_InserirButtonActionPerformed

    private void RemoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverButtonActionPerformed
        try{
            if(produtoSelecionado != null){
                
                int alt = JOptionPane.showConfirmDialog(this, "Excluir o produto " + produtoSelecionado.getCodigo()+": "+ produtoSelecionado.getNome() + "?", "Excluir", JOptionPane.OK_CANCEL_OPTION);
                
                if(alt == JOptionPane.OK_OPTION){
                    produtoDao.deletar(produtoSelecionado.getCodigo());
                    produtoSelecionado = null;
                    preencheTable(null);
                }
            }
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, "Error: "+ e);
        }
    }//GEN-LAST:event_RemoverButtonActionPerformed

    private void EditarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarButtonActionPerformed
        if (produtoSelecionado != null) {
            ProdutoCadastro editar = new ProdutoCadastro(this, produtoSelecionado);
            editar.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Selecione um cliente!");
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
            JOptionPane.showMessageDialog(this, "Erro: "+ e);
        }
    }//GEN-LAST:event_PesquisarButtonActionPerformed

    private void ExibirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExibirButtonActionPerformed
        preencheTable(null);
    }//GEN-LAST:event_ExibirButtonActionPerformed
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
            // decobre a linha do clique
            int linha = ProdutosTable.rowAtPoint(evt.getPoint());
            // pegar o codigo do produto da linha selecionada
            int codigo = (int) ProdutosTable.getModel().getValueAt(linha, 0);

            produtoSelecionado = produtoDao.getProduto(codigo);

            //System.out.println(produtoSelecionado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Erros: "+ e);
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
    private javax.swing.JButton EditarButton;
    private javax.swing.JButton ExibirButton;
    private javax.swing.JButton InserirButton;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel NomeBuscaText;
    private javax.swing.JPanel PainelTable;
    private javax.swing.JButton PesquisarButton;
    private javax.swing.JTable ProdutosTable;
    private javax.swing.JButton RemoverButton;
    private javax.swing.JButton SairButton;
    private javax.swing.JScrollPane ScrollTable;
    private javax.swing.JPanel painelButtons;
    // End of variables declaration//GEN-END:variables
}
