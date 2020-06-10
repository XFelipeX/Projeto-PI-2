package br.com.thordrugstore.farmacia;

import br.com.thordrugstore.farmacia.view.TelaLogin;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main {
    public static void main(String[] args) {
         
         try {
for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    if ("Nimbus".equals(info.getName())) {
        UIManager.setLookAndFeel(info.getClassName());
             TelaLogin telaInicial = new TelaLogin();
            telaInicial.setVisible(true);
        break;
    }
}
} catch (Exception e) {
   // If Nimbus is not available, you can set the GUI to another look and feel.
}
        
    }        
}
