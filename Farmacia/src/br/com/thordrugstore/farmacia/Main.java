package br.com.thordrugstore.farmacia;

import br.com.thordrugstore.farmacia.view.TelaLogin;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
