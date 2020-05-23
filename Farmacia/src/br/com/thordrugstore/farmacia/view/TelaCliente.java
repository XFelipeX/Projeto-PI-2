/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.view;

import br.com.thordrugstore.farmacia.DAO.ClienteDAO;
import br.com.thordrugstore.farmacia.controller.ClienteController;
import br.com.thordrugstore.farmacia.model.Cliente;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JHK
 */
public class TelaCliente extends javax.swing.JFrame {

    Cliente cliente;

    public TelaCliente() {
        initComponents();
        
        setLocationRelativeTo(null);
        cliente = new Cliente();

        carregarTabela();
    }

    public void validaNumerico(String confirma) {//!confirma.matches("[0-9]*")
        try {
            //int x = Integer.parseInt(confirma);
            boolean temNumero = true;
            for (int i = 0; i < confirma.length(); i++) {
                if (Character.isDigit(confirma.charAt(i))) {
                    temNumero = true;
                } else {
                    temNumero = false;
                    break;
                }
            }
            if (temNumero == false) {
                JOptionPane.showMessageDialog(null, "Preencha o campo com valor numérico", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void validaString(String confirma) {
        try {
            if (confirma != null) {
                boolean temLetra = true;
                for (int i = 0; i < confirma.length(); i++) {
                    if (Character.isLetter(confirma.charAt(i))) {
                        temLetra = true;
                    } else {
                        temLetra = false;
                        break;
                    }
                }
                if (temLetra == false) {
                    JOptionPane.showMessageDialog(null, "O campo não pode ser preenchido com numeros", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void carregarTabela() {
        ArrayList<Cliente> listaClientes = ClienteDAO.pesquisar();

        DefaultTableModel tabela = new DefaultTableModel();
        tabela.addColumn("COD");
        tabela.addColumn("Nome");
        tabela.addColumn("CPF");
        tabela.addColumn("Data Nasc");
        tabela.addColumn("Email");
        tabela.addColumn("Telefone");
        tabela.addColumn("Endereço");
        tabela.addColumn("Complemento");
        tabela.addColumn("Cidade");
        tabela.addColumn("Uf");

        tblClientes.setModel(tabela);

        tabela.setRowCount(0);

        for (Cliente c : listaClientes) {
            tabela.addRow(new Object[]{c.getCodcli(), c.getNome(), c.getCpf(), c.getDataNascimento(), c.getEmail(), c.getTelefone(), c.getEndereco(), c.getComplemento(), c.getCidade(), c.getUf()});
        }
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50); //
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(7).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(8).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    public void setarCampos() throws ParseException {
        int setar = tblClientes.getSelectedRow();
        txtCodCli.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtCliNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        txtCliCpf.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
        txtCliData.setText(tblClientes.getModel().getValueAt(setar, 3).toString().replace("-", ""));
        txtCliEmail.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
        txtCliTelefone.setText(tblClientes.getModel().getValueAt(setar, 5).toString());
        txtCliEndereco.setText(tblClientes.getModel().getValueAt(setar, 6).toString());
        txtCliComplemento.setText(tblClientes.getModel().getValueAt(setar, 7).toString());
        txtCliCidade.setText(tblClientes.getModel().getValueAt(setar, 8).toString());
        txtCliUf.setText(tblClientes.getModel().getValueAt(setar, 9).toString());
        //a linha abaixo desabilita o botao adicionar

        btnAdicionar.setEnabled(false);
    }

    public void limparCampos() {
        txtCodCli.setText(null);
        txtCliNome.setText(null);
        txtCliCpf.setText(null);
        txtCliData.setText(null);
        txtCliEmail.setText(null);
        txtCliTelefone.setText(null);
        txtCliEndereco.setText(null);
        txtCliComplemento.setText(null);
        txtCliCidade.setText(null);
        txtCliUf.setText(null);

        btnAdicionar.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCliTelefone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCliUf = new javax.swing.JTextField();
        txtCliCidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCliEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCliEndereco = new javax.swing.JTextField();
        txtCliComplemento = new javax.swing.JTextField();
        txtCliNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodCli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCliCpf = new javax.swing.JTextField();
        txtCliData = new javax.swing.JFormattedTextField();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtCliPesquisarNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(841, 695));
        setSize(new java.awt.Dimension(0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("UF:");

        jLabel10.setText("Cidade:");

        jLabel9.setText("Complemento:");

        txtCliTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliTelefoneMouseExited(evt);
            }
        });

        jLabel8.setText("Endereço:");

        txtCliUf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliUfMouseExited(evt);
            }
        });

        txtCliCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliCidadeMouseExited(evt);
            }
        });

        jLabel3.setText("*Nome:");

        jLabel2.setText("Cod_Cliente:");

        jLabel5.setText("Data de nascimento:");

        txtCliEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliEmailMouseExited(evt);
            }
        });

        jLabel4.setText("*CPF:");

        txtCliEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliEnderecoMouseExited(evt);
            }
        });
        txtCliEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliEnderecoActionPerformed(evt);
            }
        });

        txtCliComplemento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliComplementoMouseExited(evt);
            }
        });

        txtCliNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliNomeMouseExited(evt);
            }
        });
        txtCliNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliNomeActionPerformed(evt);
            }
        });

        jLabel6.setText("*E-mail:");

        txtCodCli.setEnabled(false);
        txtCodCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodCliMouseExited(evt);
            }
        });
        txtCodCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodCliActionPerformed(evt);
            }
        });

        jLabel7.setText("*Telefone:");

        txtCliCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliCpfMouseExited(evt);
            }
        });
        txtCliCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliCpfActionPerformed(evt);
            }
        });

        try {
            txtCliData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCliData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliDataActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Incluir Registro");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(299, 299, 299))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(63, 63, 63))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel9))
                                    .addGap(53, 53, 53))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCliData, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtCodCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCliNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(194, 194, 194)
                                        .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCliComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCliEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                            .addComponent(txtCliCidade))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(363, 363, 363)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel10))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(26, 26, 26)
                        .addComponent(txtCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnAtualizar, btnExcluir});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionar, btnAtualizar});

        jLabel12.setText("*Campos obrigatórios");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        txtCliPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliPesquisarNomeActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCliPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(32, 32, 32))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodCliActionPerformed

    }//GEN-LAST:event_txtCodCliActionPerformed

    private void txtCodCliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodCliMouseExited
        validaNumerico(txtCodCli.getText());
    }//GEN-LAST:event_txtCodCliMouseExited

    private void txtCliNomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliNomeMouseExited
        validaString(txtCliNome.getText());
    }//GEN-LAST:event_txtCliNomeMouseExited

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            if (txtCliNome.getText().isEmpty() || txtCliCpf.getText().isEmpty() || txtCliEmail.getText().isEmpty() || txtCliTelefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);

            } else {
                //int codcli = Integer.parseInt(txtCodCli.getText());
                String nome = txtCliNome.getText();
                String cpf = txtCliCpf.getText();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date dataFormatada = formato.parse(txtCliData.getText());
                cliente.setDataNascimento(dataFormatada);
                Date data = cliente.getDataNascimento();
                String email = txtCliEmail.getText();
                String telefone = txtCliTelefone.getText();
                String endereco = txtCliEndereco.getText();
                String complemento = txtCliComplemento.getText();
                String cidade = txtCliCidade.getText();
                String uf = txtCliUf.getText();
                //  System.out.println(data);
                //String dataFormatada = formatarData(data);
                //System.out.println(dataFormatada);
                if (ClienteController.salvar(nome, cpf, data, email, telefone, endereco, complemento, cidade, uf)) {
                    JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                    limparCampos();
                } else {

                    JOptionPane.showMessageDialog(this, "Falha no cadastro!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtCliEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliEmailMouseExited
        //validaString(txtCliEmail.getText());
    }//GEN-LAST:event_txtCliEmailMouseExited

    private void txtCliTelefoneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliTelefoneMouseExited
        validaNumerico(txtCliTelefone.getText());
    }//GEN-LAST:event_txtCliTelefoneMouseExited

    private void txtCliEnderecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliEnderecoMouseExited
        validaString(txtCliEndereco.getText());
    }//GEN-LAST:event_txtCliEnderecoMouseExited

    private void txtCliComplementoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliComplementoMouseExited
        validaString(txtCliComplemento.getText());
    }//GEN-LAST:event_txtCliComplementoMouseExited

    private void txtCliCidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliCidadeMouseExited
        validaString(txtCliCidade.getText());
    }//GEN-LAST:event_txtCliCidadeMouseExited

    private void txtCliUfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliUfMouseExited
        validaString(txtCliUf.getText());
    }//GEN-LAST:event_txtCliUfMouseExited

    private void txtCliCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliCpfActionPerformed

    }//GEN-LAST:event_txtCliCpfActionPerformed

    private void txtCliCpfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliCpfMouseExited
        validaNumerico(txtCliCpf.getText());
    }//GEN-LAST:event_txtCliCpfMouseExited

    private void txtCliDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliDataActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        ArrayList<Cliente> listaClientes;
        try {
            listaClientes = ClienteDAO.pesquisar(txtCliPesquisarNome.getText());

            DefaultTableModel tabela = new DefaultTableModel();
            tabela.addColumn("ID");
            tabela.addColumn("Nome");
            tabela.addColumn("CPF");
            tabela.addColumn("Data Nasc");
            tabela.addColumn("Email");
            tabela.addColumn("Telefone");
            tabela.addColumn("Endereço");
            tabela.addColumn("Complemento");
            tabela.addColumn("Cidade");
            tabela.addColumn("Uf");

            tblClientes.setModel(tabela);

            //tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(0));
            tabela.setRowCount(0);
            for (Cliente c : listaClientes) {
                tabela.addRow(new Object[]{c.getCodcli(), c.getNome(), c.getCpf(), c.getDataNascimento(), c.getEmail(), c.getTelefone(), c.getEndereco(), c.getComplemento(), c.getCidade(), c.getUf()});
            }

            tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50); //
            tblClientes.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(7).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(8).setPreferredWidth(50);
            tblClientes.getColumnModel().getColumn(9).setPreferredWidth(50);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtCliPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliPesquisarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliPesquisarNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (!txtCodCli.getText().equals("")) {
            if (ClienteController.excluir(Integer.valueOf(txtCodCli.getText()))) {
                limparCampos();
            };
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        try {
            setarCampos();
        } catch (ParseException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        try {
            if (txtCliNome.getText().isEmpty() || txtCliCpf.getText().isEmpty() || txtCliEmail.getText().isEmpty() || txtCliTelefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                cliente.setCodcli(Integer.parseInt(txtCodCli.getText()));
                cliente.setNome(txtCliNome.getText());
                cliente.setCpf(txtCliCpf.getText());
                //cliente.setDataNascimento(new Date(Integer.parseInt(txtCliData.getText().replace("/", ""))));
                cliente.setDataNascimento((Date) txtCliData.getValue());
                cliente.setEmail(txtCliEmail.getText());
                cliente.setTelefone(txtCliTelefone.getText());
                cliente.setEndereco(txtCliEndereco.getText());
                cliente.setComplemento(txtCliComplemento.getText());
                cliente.setCidade(txtCliComplemento.getText());
                cliente.setUf(txtCliUf.getText());
                if (ClienteController.atualizar(tblClientes, cliente)) {
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error dados não atualizados!");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtCliEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliEnderecoActionPerformed

    private void txtCliNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliNomeActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliCidade;
    private javax.swing.JTextField txtCliComplemento;
    private javax.swing.JTextField txtCliCpf;
    private javax.swing.JFormattedTextField txtCliData;
    private javax.swing.JTextField txtCliEmail;
    private javax.swing.JTextField txtCliEndereco;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliPesquisarNome;
    private javax.swing.JTextField txtCliTelefone;
    private javax.swing.JTextField txtCliUf;
    private javax.swing.JTextField txtCodCli;
    // End of variables declaration//GEN-END:variables
}
