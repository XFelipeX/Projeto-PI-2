/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.view;

import br.com.thordrugstore.farmacia.controller.ItemVendaController;
import br.com.thordrugstore.farmacia.model.Cliente;
import br.com.thordrugstore.farmacia.model.ItemVenda;
import br.com.thordrugstore.farmacia.model.Produto;
import br.com.thordrugstore.farmacia.model.Venda;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lipes
 */
public class TelaVenda extends javax.swing.JInternalFrame {

    private Venda venda = null;
    private int qtdProdutos = 0;

    /**
     * Creates new form TelaCompra
     */
    public TelaVenda() {
        initComponents();
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }

    private void habilitarFormulario(Boolean condicao) {
        btnnovaVenda.setEnabled(condicao);
        btnadicionarProduto.setEnabled(condicao);
        btnpesquisarProduto.setEnabled(condicao);
        btnpesquisarCliente.setEnabled(condicao);
        btnfinalizarCompra.setEnabled(condicao);
        btnremoverProduto.setEnabled(condicao);
        spinquantidadeProduto.setEnabled(condicao);
        txtDesconto.setEnabled(condicao);
        cboPagamento.setEnabled(condicao);
        btnaplicarDesconto.setEnabled(condicao);
    }

    private void limparCampos() {
        txtnomeProduto.setText(null);
        txtcodigoProduto.setText(null);
        txtvalorUnitario.setText(null);
        spinquantidadeProduto.setValue(0);
    }

    public void setCliente(Cliente cliente) {
        txtnomeCliente.setValue(cliente.getNome());
        txtcodigoCliente.setText(String.valueOf(cliente.getCodcli()));
        txtcpfCliente.setText(cliente.getCpf());
    }

    public void setProduto(Produto produto) {
        DecimalFormat formatar = new DecimalFormat("#,###.00");
        txtnomeProduto.setValue(produto);
        txtvalorUnitario.setValue(formatar.format(produto.getValor()));
        txtcodigoProduto.setValue(produto.getCodProduto());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcpfCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnpesquisarCliente = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtcodigoCliente = new javax.swing.JTextField();
        txtnomeCliente = new javax.swing.JFormattedTextField();
        lblData = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtvalorBruto = new javax.swing.JTextField();
        txtDesconto = new javax.swing.JTextField();
        cboPagamento = new javax.swing.JComboBox<>();
        btnaplicarDesconto = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnadicionarProduto = new javax.swing.JButton();
        btnpesquisarProduto = new javax.swing.JButton();
        spinquantidadeProduto = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnomeProduto = new javax.swing.JFormattedTextField();
        txtvalorUnitario = new javax.swing.JFormattedTextField();
        txtcodigoProduto = new javax.swing.JFormattedTextField();
        btnremoverProduto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblItensSacola = new javax.swing.JLabel();
        btnfinalizarCompra = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnnovaVenda = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Compra");
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("CPF:");

        txtcpfCliente.setEnabled(false);

        jLabel11.setText("Cliente");

        btnpesquisarCliente.setText("Pesquisar");
        btnpesquisarCliente.setEnabled(false);
        btnpesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarClienteActionPerformed(evt);
            }
        });

        jLabel15.setText("Código:");

        txtcodigoCliente.setEnabled(false);

        txtnomeCliente.setEnabled(false);

        lblData.setBackground(new java.awt.Color(0, 0, 0));
        lblData.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblData.setText("Data");

        jLabel1.setText("DATA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtcodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnpesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(btnpesquisarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Valor bruto");

        jLabel4.setText("Desconto:");

        txtvalorBruto.setEnabled(false);

        txtDesconto.setText("0");
        txtDesconto.setEnabled(false);

        cboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Crédito", "Débito", " " }));
        cboPagamento.setEnabled(false);
        cboPagamento.setFocusable(false);

        btnaplicarDesconto.setText("Aplicar Desconto");
        btnaplicarDesconto.setEnabled(false);
        btnaplicarDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaplicarDescontoActionPerformed(evt);
            }
        });

        jLabel17.setText("Pagamento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaplicarDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPagamento, 0, 98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDesconto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(txtvalorBruto)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtvalorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnaplicarDesconto)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Produto");

        jLabel8.setText("QTD:");

        btnadicionarProduto.setText("Adicionar Produto");
        btnadicionarProduto.setEnabled(false);
        btnadicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionarProdutoActionPerformed(evt);
            }
        });

        btnpesquisarProduto.setText("Pesquisar");
        btnpesquisarProduto.setEnabled(false);
        btnpesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarProdutoActionPerformed(evt);
            }
        });

        spinquantidadeProduto.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spinquantidadeProduto.setEnabled(false);

        jLabel13.setText("Preço:");

        jLabel14.setText("Código:");

        txtnomeProduto.setEnabled(false);

        txtvalorUnitario.setEnabled(false);

        txtcodigoProduto.setEnabled(false);

        btnremoverProduto.setText("Remover Produto");
        btnremoverProduto.setEnabled(false);
        btnremoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoverProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnpesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtvalorUnitario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinquantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnadicionarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnremoverProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtcodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisarProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinquantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnremoverProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnadicionarProduto)
                    .addComponent(txtvalorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "Nome Produto", "QTD", "Valor Unitário", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVenda);
        if (tblVenda.getColumnModel().getColumnCount() > 0) {
            tblVenda.getColumnModel().getColumn(0).setResizable(false);
            tblVenda.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblVenda.getColumnModel().getColumn(1).setResizable(false);
            tblVenda.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblVenda.getColumnModel().getColumn(2).setResizable(false);
            tblVenda.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblVenda.getColumnModel().getColumn(3).setResizable(false);
            tblVenda.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblVenda.getColumnModel().getColumn(4).setResizable(false);
            tblVenda.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        jLabel9.setText("Itens na sacola:");

        lblItensSacola.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblItensSacola.setForeground(new java.awt.Color(204, 0, 0));
        lblItensSacola.setText("0");

        btnfinalizarCompra.setText("Finalizar Venda");
        btnfinalizarCompra.setEnabled(false);

        lblTotal.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lblTotal.setText("0");

        jLabel16.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel16.setText("Total:");

        btnnovaVenda.setText("Nova Venda");
        btnnovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovaVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(lblTotal)
                .addGap(59, 59, 59)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblItensSacola, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnovaVenda)
                .addGap(31, 31, 31)
                .addComponent(btnfinalizarCompra)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnfinalizarCompra)
                        .addComponent(btnnovaVenda)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblItensSacola, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        setBounds(0, 0, 685, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void btnpesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarProdutoActionPerformed
        TelaPesquisaProduto buscaProduto = new TelaPesquisaProduto(this);
        buscaProduto.setLocationRelativeTo(null);
        buscaProduto.setVisible(true);
    }//GEN-LAST:event_btnpesquisarProdutoActionPerformed

    private void btnadicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionarProdutoActionPerformed
        if (((int) spinquantidadeProduto.getValue() > 0) && (!txtcodigoProduto.getText().isEmpty() || !txtnomeProduto.getText().isEmpty() || !txtvalorUnitario.getText().isEmpty())) {
            //formatar para duas casas decimais
            DecimalFormat formatar = new DecimalFormat("#,###.00");
            //instanciar um produto
            Produto p = new Produto();
            p.setCodProduto(Integer.parseInt(txtcodigoProduto.getText()));
            p.setNomeProduto(txtnomeProduto.getText());
            p.setQtdProduto(Integer.parseInt(spinquantidadeProduto.getValue().toString()));
            double a = Double.parseDouble(txtvalorUnitario.getValue().toString().replace(",", "."));
            p.setValor(a);
            //instanciar um item de produto para armazenar no array
            ItemVenda item = new ItemVenda();
            item.setProduto(p);
            item.setVenda(venda);
            item.setQuantidade(p.getQtdProduto());
            item.setValorUnitario(p.getValor());
            //adicionando a linha na tabela
            DefaultTableModel tabela = (DefaultTableModel) tblVenda.getModel();
            String codigo = String.valueOf(item.getProduto().getCodProduto());
            String nome = String.valueOf(item.getProduto().getNomeProduto());
            String qtd = String.valueOf(item.getQuantidade());
            String valorUnitario = String.valueOf(item.getValorUnitario());
            String valorTotal = String.valueOf(item.getValorTotal());

            tabela.addRow(new String[]{codigo, nome, qtd, valorUnitario, valorTotal});

            //adicionando mais um item de venda
            venda.addItem(item);
            //somar o valor do item ao total da venda e atualizar label
            venda.somarTotal(item.getValorTotal());
            String total = formatar.format(venda.getTotal());
            lblTotal.setText(total);
            txtvalorBruto.setText(total);
            venda.setValorBruto(venda.getTotal());
            //somando quantidade de itens e atualizando lblitensSacola
            qtdProdutos += (int) spinquantidadeProduto.getValue();
            lblItensSacola.setText(String.valueOf(qtdProdutos));
            //limpando campos
            limparCampos();
        } else if (txtcodigoProduto.getText().isEmpty() || txtnomeProduto.getText().isEmpty() || txtvalorUnitario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Escolha um produto", "Atenção!", JOptionPane.ERROR_MESSAGE);
        } else if (spinquantidadeProduto.getValue().equals(0)) {
            JOptionPane.showMessageDialog(null, "Por favor, insira uma QTD maior que 0", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnadicionarProdutoActionPerformed

    private void btnnovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovaVendaActionPerformed
        venda = new Venda();
        habilitarFormulario(true);
    }//GEN-LAST:event_btnnovaVendaActionPerformed

    private void btnremoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverProdutoActionPerformed
        if (tblVenda.getSelectedRowCount() > 0) {
            DecimalFormat formatar = new DecimalFormat("#,###.00");
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
                int linha = tblVenda.getSelectedRow();
                int qtd = Integer.parseInt(tblVenda.getModel().getValueAt(linha, 2).toString());
                qtdProdutos -= qtd;
                Double precoProduto = Double.parseDouble(tblVenda.getValueAt(tblVenda.getSelectedRow(), 4).toString());
                ItemVenda iv = venda.getLinha(0);

                venda.removeItem(iv);
                venda.subtrairTotal(precoProduto);
                String total = formatar.format(venda.getTotal());
                lblTotal.setText(total);
                txtvalorBruto.setText(total);
                lblItensSacola.setText(String.valueOf(qtdProdutos));
                ((DefaultTableModel) tblVenda.getModel()).removeRow(tblVenda.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para remover.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnremoverProdutoActionPerformed

    private void btnaplicarDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaplicarDescontoActionPerformed
        if (!txtDesconto.getText().equals("")) {
            DecimalFormat formatar = new DecimalFormat("#,###.00");
            double desconto = Double.parseDouble(txtDesconto.getText());
            venda.setDesconto(desconto);
            venda.subtrairTotal(desconto);
            lblTotal.setText(formatar.format(venda.getTotal()));
        }
    }//GEN-LAST:event_btnaplicarDescontoActionPerformed

    private void btnpesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarClienteActionPerformed
        TelaPesquisaCliente buscaCliente = new TelaPesquisaCliente(this);
        buscaCliente.setVisible(true);
    }//GEN-LAST:event_btnpesquisarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadicionarProduto;
    private javax.swing.JButton btnaplicarDesconto;
    private javax.swing.JButton btnfinalizarCompra;
    private javax.swing.JButton btnnovaVenda;
    private javax.swing.JButton btnpesquisarCliente;
    private javax.swing.JButton btnpesquisarProduto;
    private javax.swing.JButton btnremoverProduto;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblItensSacola;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spinquantidadeProduto;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtcodigoCliente;
    private javax.swing.JFormattedTextField txtcodigoProduto;
    private javax.swing.JTextField txtcpfCliente;
    private javax.swing.JFormattedTextField txtnomeCliente;
    private javax.swing.JFormattedTextField txtnomeProduto;
    private javax.swing.JTextField txtvalorBruto;
    private javax.swing.JFormattedTextField txtvalorUnitario;
    // End of variables declaration//GEN-END:variables
}
