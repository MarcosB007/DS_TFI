/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;
import tfids.*;

/**
 *
 * @author MI PC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login extends JFrame {

   public login() {
        // Configuración básica de la ventana
        setTitle("Inicio de Sesión - Ingenio La Trinidad");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana

        // Cargar la imagen de fondo
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\MI PC\\Documents\\NetBeansProjects\\JavaApplication5\\imagen/vvvvv.png"); // Cambia la ruta a la ubicación de tu imagen
        JLabel background = new JLabel(backgroundIcon);
        background.setLayout(new GridBagLayout());  // Usar GridBagLayout para centrar el panel

        // Panel verde con color especificado y transparencia
            JPanel loginPanel = new JPanel();
           loginPanel.setBackground(new Color(0, 123, 62, 230));  // Verde con opacidad al 90%
           loginPanel.setPreferredSize(new Dimension(300, 400));
           loginPanel.setLayout(new GridBagLayout());
           loginPanel.setOpaque(true);

        // Configuración de GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Logo
        JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\MI PC\\Documents\\NetBeansProjects\\JavaApplication5\\imagen/ver.png")); // Cambia la ruta de tu logo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(logoLabel, gbc);

        // Título "Inicio de Sesión"
        JLabel titleLabel = new JLabel("Inicio de Sesión");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);

        // Campo de Usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setForeground(Color.WHITE);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        loginPanel.add(userLabel, gbc);

        JTextField userField = new JTextField(15);
        gbc.gridx = 1;
        loginPanel.add(userField, gbc);

        // Campo de Contraseña
        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        loginPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 1;
        loginPanel.add(passField, gbc);

        // Botón de Iniciar Sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBackground(new Color(34, 139, 34));  // Verde oscuro
        loginButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        // Mensaje de error (invisible al inicio)
        JLabel errorLabel = new JLabel("Usuario o contraseña incorrectos");
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);
        gbc.gridy = 5;
        loginPanel.add(errorLabel, gbc);

        // Agregar panel verde al fondo
        background.add(loginPanel);

        // Añadir el JLabel del fondo a la ventana
        setContentPane(background);

        // Acción al presionar el botón de inicio de sesión
        loginButton.addActionListener(e -> {
            String username= userField.getText();
            String password = new String(passField.getPassword());
            
            DAO dao = new DAO();
            
            try {      
                var resultado = dao.validarUsuario(username, password);
                System.out.println(resultado);
                // Verificar credenciales (ajusta según tu lógica de autenticación)
                if (resultado) {
                    //Usuario usuario = new Usuario(username, password, );
                  //dao.getVentana(new panelPrincipal(), this);
                    dispose(); // Cierra la ventana de inicio de sesión
                    panelPrincipal v = new panelPrincipal(); // Abre la ventana principal
                    v.setVisible(true);
                } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                }
            } catch (Exception ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new login().setVisible(true);
        });
    }
}

