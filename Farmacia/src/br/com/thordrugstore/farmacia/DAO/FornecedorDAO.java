/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia.DAO;

import br.com.thordrugstore.farmacia.model.Fornecedor;
import br.com.thordrugstore.farmacia.utils.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author JHK
 */
public class FornecedorDAO {
    
    public static boolean salvar(Fornecedor f){
        boolean retorno = false;
        Connection conexao = null;
        String sql = null;
        PreparedStatement pst = null;
        
        sql = "insert into fornecedores(cod_forn,razao_social,cnpj,telefone1,telefone2,celular,endereco,complemento,cidade,uf) "
                + "values(?,?,?,?,?,?,?,?,?,?)";
         try {
             conexao = ModuloConexao.conector();
             
             if(f.getRazaoSocial().isEmpty() || f.getCnpj().isEmpty() || f.getTelComercial1().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
             } else {
                 pst = conexao.prepareStatement(sql);
                 pst.setInt(1, f.getFonecedorcod());
                 pst.setString(2,f.getRazaoSocial());
                 pst.setString(3,f.getCnpj());
                 pst.setString(4,f.getTelComercial1());
                 pst.setString(5,f.getTelComercial2());
                 pst.setString(6,f.getCelular());
                 pst.setString(7,f.getEndereco());
                 pst.setString(8,f.getComplemento());
                 pst.setString(9,f.getCidade());
                 pst.setString(10,f.getUf());
                 
                 int adicionado = pst.executeUpdate();
                 if (adicionado > 0) {
                    retorno = true;
                    JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso");                
                }                                  
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
        return retorno;
    }
    
   // public static boolean excluir(Fornecedor f){
   //     boolean retorno = false;
   //     Connection conexao = null;
   //     String sql = null;
   //     PreparedStatement pst = null;
  //      
   //     sql = "delete from fornecedores where cod_forn =?";
        
   // }
        
}
