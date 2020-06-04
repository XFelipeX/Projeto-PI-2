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
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtCliPesquisarNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(680, 700));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(37, 116, 169));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("UF:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cidade:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Complemento:");

        txtCliTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliTelefoneMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Endereço:");

        txtCliUf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliUf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliUfMouseExited(evt);
            }
        });

        txtCliCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliCidadeMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cod_Cliente:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data de nascimento:");

        txtCliEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliEmailMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*CPF:");

        txtCliEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliEnderecoMouseExited(evt);
            }
        });

        txtCliComplemento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliComplemento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliComplementoMouseExited(evt);
            }
        });

        txtCliNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliNomeMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*E-mail:");

        txtCodCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodCli.setEnabled(false);
        txtCodCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodCliMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*Telefone:");

        txtCliCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCliCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCliCpfMouseExited(evt);
            }
        });

        try {
            txtCliData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        btnAdicionar.setText("Registrar");
        btnAdicionar.setPreferredSize(new java.awt.Dimension(100, 35));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Clientes");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("*Campos obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCliEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCliComplemento))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCliData, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtCliComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionar, btnAtualizar, btnExcluir});

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

        txtCliPesquisarNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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
                .addGap(278, 278, 278)
                .addComponent(txtCliPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(723, 670));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtCliCpfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCliCpfMouseExited
        validaNumerico(txtCliCpf.getText());
    }//GEN-LAST:event_txtCliCpfMouseExited

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
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date dataFormatada = formato.parse(txtCliData.getText());
                cliente.setDataNascimento(dataFormatada);
                Date data = cliente.getDataNascimento();
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
