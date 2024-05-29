package Main;

import view.Login;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        // Set up the FlatMacLightLaf look and feel
        try {
            FlatMacLightLaf.setup();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Failed to initialize LaF", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Create and display the login window
        Login login = new Login();
        java.awt.EventQueue.invokeLater(() -> {
            login.setVisible(true);
        });

     
    }
}
