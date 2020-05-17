/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thordrugstore.farmacia;

import br.com.thordrugstore.farmacia.view.TelaLogin;
import br.com.thordrugstore.farmacia.view.TelaPrincipal;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lipes
 */
public class Main {
    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
             TelaLogin telaInicial = new TelaLogin();
            telaInicial.setVisible(true);
            
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
}
