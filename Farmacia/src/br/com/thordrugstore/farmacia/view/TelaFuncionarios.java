/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.view;

import br.com.thordrugstore.farmacia.DAO.FuncionarioDAO;
import br.com.thordrugstore.farmacia.controller.FuncionarioController;
import br.com.thordrugstore.farmacia.model.Funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trodrsil
 */
public class TelaFuncionarios extends javax.swing.JFrame {

    Funcionario funcionario;

    public TelaFuncionarios() {
        initComponents();
        setLocationRelativeTo(null);
        funcionario = new Funcionario();
        carregarTabela();
    }

    public void validaNumerico(String confirma) {
        try {
            confirma = confirma.replace(".", "");
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

    public void setarCampos() {

        try {
            int setar = tblFuncionarios.getSelectedRow();
            txtCodigo.setText(tblFuncionarios.getModel().getValueAt(setar, 0).toString());
            txtId.setText(tblFuncionarios.getModel().getValueAt(setar, 1).toString());
            txtSenha.setText(tblFuncionarios.getModel().getValueAt(setar, 2).toString());
            txtNome.setText(tblFuncionarios.getModel().getValueAt(setar, 3).toString());
            txtCpf.setText(tblFuncionarios.getModel().getValueAt(setar, 4).toString());
            txtLogradouro.setText(tblFuncionarios.getModel().getValueAt(setar, 5).toString());
            txtNum.setText(tblFuncionarios.getModel().getValueAt(setar, 6).toString());
            txtComplemento.setText(tblFuncionarios.getModel().getValueAt(setar, 7).toString());
            txtUf.setText(tblFuncionarios.getModel().getValueAt(setar, 8).toString());
            txtTelefone.setText(tblFuncionarios.getModel().getValueAt(setar, 9).toString());
            txtEmail.setText(tblFuncionarios.getModel().getValueAt(setar, 10).toString());
            txtFuncao.setText(tblFuncionarios.getModel().getValueAt(setar, 11).toString());
            txtSalario.setText(tblFuncionarios.getModel().getValueAt(setar, 12).toString());
            cboFuncionarioPerfil.setSelectedItem(tblFuncionarios.getModel().getValueAt(setar, 13).toString());
        } catch (Exception e) {
        }

        //a linha abaixo desabilita o botao adicionar
        btnAdicionar.setEnabled(false);
    }

    public void limparCampos() {
        txtCodigo.setText(null);
        txtNome.setText(null);
        txtCpf.setText(null);
        txtComplemento.setText(null);
        txtFuncao.setText(null);
        txtTelefone.setText(null);
        txtNum.setText(null);
        txtTelefone.setText(null);
        txtSalario.setText("0");
        txtUf.setText(null);
        txtLogradouro.setText(null);
        txtSenha.setText(null);
        txtEmail.setText(null);
        txtId.setText(null);

        btnAdicionar.setEnabled(true);
    }

    public void carregarTabela() {
        ArrayList<Funcionario> listaFuncionarios;
        listaFuncionarios = FuncionarioDAO.pesquisar(txtFuncionarioPesquisa.getText());
        DefaultTableModel tabela = new DefaultTableModel();
        tabela.addColumn("COD");
        tabela.addColumn("ID");
        tabela.addColumn("Senha");
        tabela.addColumn("Nome");
        tabela.addColumn("CPF");
        tabela.addColumn("Logradouro");
        tabela.addColumn("N°");
        tabela.addColumn("Complemento");
        tabela.addColumn("Uf");
        tabela.addColumn("Telefone");
        tabela.addColumn("Email");
        tabela.addColumn("Função");
        tabela.addColumn("Salário");
        tabela.addColumn("Perfil");
        tblFuncionarios.setModel(tabela);
        tabela.setRowCount(0);
        for (Funcionario f : listaFuncionarios) {
            tabela.addRow(new Object[]{f.getCodfunc(), f.getIdUsuario(), f.getSenha(), f.getNome(), f.getCpf(), f.getLogradouro(), f.getNum(), f.getComplemento(), f.getUf(), f.getTelefone(), f.getEmail(), f.getFuncao(), f.getSalario(), f.getPerfil()});
        }
        tblFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(40); //
        tblFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(70);
        tblFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(40);
        tblFuncionarios.getColumnModel().getColumn(7).setPreferredWidth(100);
        tblFuncionarios.getColumnModel().getColumn(8).setPreferredWidth(40);
        tblFuncionarios.getColumnModel().getColumn(9).setPreferredWidth(70);
        tblFuncionarios.getColumnModel().getColumn(10).setPreferredWidth(100);
        tblFuncionarios.getColumnModel().getColumn(11).setPreferredWidth(80);
        tblFuncionarios.getColumnModel().getColumn(12).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(13).setPreferredWidth(50);
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
        txtCodigo = new javax.swing.JTextField();
        jLabelSalarioFunc = new javax.swing.JLabel();
        jLabelNomeFunc = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabelCPFFunc = new javax.swing.JLabel();
        jLabelLogradouroFunc = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabelNumFunc = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabelComplemFunc = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabelUF = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabelCod = new javax.swing.JLabel();
        jLabelFuncao = new javax.swing.JLabel();
        txtFuncao = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        cboFuncionarioPerfil = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabelTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        txtFuncionarioPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(698, 700));

        jPanel1.setBackground(new java.awt.Color(37, 116, 169));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigo.setEnabled(false);
        txtCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCodigoMouseExited(evt);
            }
        });

        jLabelSalarioFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSalarioFunc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSalarioFunc.setText("Salário: ");

        jLabelNomeFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNomeFunc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNomeFunc.setText("*Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNomeMouseExited(evt);
            }
        });
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabelCPFFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCPFFunc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCPFFunc.setText("*CPF:");

        jLabelLogradouroFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLogradouroFunc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogradouroFunc.setText("Logradouro:");

        txtLogradouro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLogradouro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtLogradouroMouseExited(evt);
            }
        });

        jLabelNumFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNumFunc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumFunc.setText("Núm.:");

        txtNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNumMouseExited(evt);
            }
        });

        jLabelComplemFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelComplemFunc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelComplemFunc.setText("Complemento:");

        txtComplemento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtComplemento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtComplementoMouseExited(evt);
            }
        });
        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        jLabelUF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelUF.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUF.setText("UF:");

        txtUf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUfMouseExited(evt);
            }
        });

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTelefone.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefone.setText("Telefone:");

        txtTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTelefoneMouseExited(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("*E-mail:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEmailMouseExited(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabelCod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCod.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCod.setText("Código:");

        jLabelFuncao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelFuncao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFuncao.setText("*Função:");

        txtFuncao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFuncao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFuncaoMouseExited(evt);
            }
        });

        txtSalario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSalarioMouseExited(evt);
            }
        });
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        txtCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCpfMouseExited(evt);
            }
        });
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Registrar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        cboFuncionarioPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Senha:");

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*Perfil:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*ID:");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Cadastro de funcionários");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("*Campos obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelSalarioFunc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSalario))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFuncao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(359, 359, 359))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cboFuncionarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNomeFunc)
                    .addComponent(jLabelLogradouroFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNumFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelComplemFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelUF))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCPFFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabelCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnAtualizar, btnExcluir});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCod)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeFunc)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCPFFunc)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogradouroFunc)
                    .addComponent(jLabelNumFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComplemFunc)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUF)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jLabelEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFuncao)
                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalarioFunc)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboFuncionarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionar, btnAtualizar, btnExcluir});

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtFuncionarioPesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFuncionarioPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncionarioPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (!txtCodigo.getText().equals("")) {
            if (FuncionarioController.excluir(Integer.valueOf(txtCodigo.getText()))) {
                limparCampos();
            };
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        try {
            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtEmail.getText().isEmpty() || txtFuncao.getText().isEmpty() || txtSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (txtUf.getText().length() > 2) {
                JOptionPane.showMessageDialog(null, "O campo UF não pode conter mais que dois caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                funcionario.setCodfunc(Integer.parseInt(txtCodigo.getText()));
                funcionario.setNome(txtNome.getText());
                funcionario.setIdUsuario(txtId.getText());
                funcionario.setCpf(txtCpf.getText());
                funcionario.setFuncao(txtFuncao.getText());
                funcionario.setEmail(txtEmail.getText());
                funcionario.setTelefone(txtTelefone.getText());
                funcionario.setLogradouro(txtLogradouro.getText());
                funcionario.setComplemento(txtComplemento.getText());
                funcionario.setNum(txtNum.getText());
                funcionario.setUf(txtUf.getText());
                funcionario.setSenha(txtSenha.getText());
                funcionario.setSalario(Double.parseDouble(txtSalario.getText()));
                funcionario.setPerfil(cboFuncionarioPerfil.getSelectedItem().toString());
                if (FuncionarioController.atualizar(tblFuncionarios, funcionario)) {
                    JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error dados não atualizados!");
                }
            }
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O campo salário não pode ser nulo, insira um valor maior ou igual a zero!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtCodigoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoMouseExited
        // TODO add your handling code here:
        validaNumerico(txtCodigo.getText());
    }//GEN-LAST:event_txtCodigoMouseExited

    private void txtNomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeMouseExited
        // TODO add your handling code here:
        validaString(txtNome.getText());
        //Evento Nome
    }//GEN-LAST:event_txtNomeMouseExited

    private void txtLogradouroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLogradouroMouseExited
        // TODO add your handling code here:
        validaString(txtLogradouro.getText());
    }//GEN-LAST:event_txtLogradouroMouseExited

    private void txtNumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumMouseExited
        // TODO add your handling code here:
        validaNumerico(txtNum.getText());
    }//GEN-LAST:event_txtNumMouseExited

    private void txtComplementoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtComplementoMouseExited
        // TODO add your handling code here:
        validaNumerico(txtComplemento.getText());
    }//GEN-LAST:event_txtComplementoMouseExited

    private void txtUfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUfMouseExited
        // TODO add your handling code here:
        validaString(txtUf.getText());
    }//GEN-LAST:event_txtUfMouseExited

    private void txtTelefoneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefoneMouseExited
        // TODO add your handling code here:
        validaNumerico(txtTelefone.getText());
    }//GEN-LAST:event_txtTelefoneMouseExited

    private void txtEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseExited
        // TODO add your handling code here:
        //validaString(txtEmail.getText());
    }//GEN-LAST:event_txtEmailMouseExited

    private void txtFuncaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFuncaoMouseExited
        // TODO add your handling code here:
        validaString(txtFuncao.getText());
    }//GEN-LAST:event_txtFuncaoMouseExited

    private void txtSalarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalarioMouseExited
        // TODO add your handling code here:
        validaNumerico(txtSalario.getText());
    }//GEN-LAST:event_txtSalarioMouseExited

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtEmail.getText().isEmpty() || txtFuncao.getText().isEmpty() || txtSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (txtUf.getText().length() > 2) {
                JOptionPane.showMessageDialog(null, "O campo UF não pode conter mais que dois caracteres!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {

                String nome = txtNome.getText();
                String user = txtId.getText();
                String cpf = txtCpf.getText();
                String senha = txtSenha.getText();
                String email = txtEmail.getText();
                String telefone = txtTelefone.getText();
                String logradouro = txtLogradouro.getText();
                String complemento = txtComplemento.getText();
                String funcao = txtFuncao.getText();
                String uf = txtUf.getText();
                String num = txtNum.getText();
                double salario = Double.parseDouble(txtSalario.getText());
                String perfil = cboFuncionarioPerfil.getSelectedItem().toString();

                if (FuncionarioController.salvar(user, perfil, senha, nome, cpf, logradouro, num, complemento, uf, telefone, email, funcao, salario)) {
                    JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
                    limparCampos();
                } else {

                    JOptionPane.showMessageDialog(this, "Falha no cadastro!");
                }
            }
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O campo salário não pode ser nulo, insira um valor maior ou igual a zero!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblFuncionariosMouseClicked

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void txtCpfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpfMouseExited
        validaNumerico(txtCpf.getText());
    }//GEN-LAST:event_txtCpfMouseExited

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        ArrayList<Funcionario> listaFuncionarios;
        listaFuncionarios = FuncionarioDAO.pesquisar(txtFuncionarioPesquisa.getText());
        DefaultTableModel tabela = new DefaultTableModel();
        tabela.addColumn("COD");
        tabela.addColumn("ID");
        tabela.addColumn("Senha");
        tabela.addColumn("Nome");
        tabela.addColumn("CPF");
        tabela.addColumn("Logradouro");
        tabela.addColumn("N°");
        tabela.addColumn("Complemento");
        tabela.addColumn("Uf");
        tabela.addColumn("Telefone");
        tabela.addColumn("Email");
        tabela.addColumn("Função");
        tabela.addColumn("Salário");
        tabela.addColumn("Perfil");
        tblFuncionarios.setModel(tabela);
        tabela.setRowCount(0);
        for (Funcionario f : listaFuncionarios) {
            tabela.addRow(new Object[]{f.getCodfunc(), f.getIdUsuario(), f.getSenha(), f.getNome(), f.getCpf(), f.getLogradouro(), f.getNum(), f.getComplemento(), f.getUf(), f.getTelefone(), f.getEmail(), f.getFuncao(), f.getSalario(), f.getPerfil()});
        }
        tblFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(50); //
        tblFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(7).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(8).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(9).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(10).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(11).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(12).setPreferredWidth(50);
        tblFuncionarios.getColumnModel().getColumn(13).setPreferredWidth(50);
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cboFuncionarioPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCPFFunc;
    private javax.swing.JLabel jLabelCod;
    private javax.swing.JLabel jLabelComplemFunc;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFuncao;
    private javax.swing.JLabel jLabelLogradouroFunc;
    private javax.swing.JLabel jLabelNomeFunc;
    private javax.swing.JLabel jLabelNumFunc;
    private javax.swing.JLabel jLabelSalarioFunc;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFuncao;
    private javax.swing.JTextField txtFuncionarioPesquisa;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
