/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

/**
 *
 * @author MI PC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearUsuario extends JFrame {
    public CrearUsuario() {
        // Configuración básica de la ventana
        setTitle("Crear Usuario");
        setSize(400, 350); // Incrementado tamaño para encajar los nuevos campos
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana

        // Panel para contener los campos
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Encabezado
        JLabel headerLabel = new JLabel("Crear Usuario");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(headerLabel, gbc);

        // Campo DNI
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(new JLabel("DNI:"), gbc);
        JTextField dniField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(dniField, gbc);

        // Campo Nombre y Apellido
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(new JLabel("Nombre y Apellido:"), gbc);
        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Campo Fecha de Nacimiento
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(new JLabel("Fecha de Nacimiento:"), gbc);
        JTextField dobField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(dobField, gbc);

        // Campo Celular
        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(new JLabel("Celular:"), gbc);
        JTextField phoneField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);

        // Campo Email
        gbc.gridy = 5;
        gbc.gridx = 0;
        panel.add(new JLabel("Email:"), gbc);
        JTextField emailField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        // Campo Usuario
        gbc.gridy = 6;
        gbc.gridx = 0;
        panel.add(new JLabel("Usuario:"), gbc);
        JTextField userField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(userField, gbc);

        // Campo Contraseña
        gbc.gridy = 7;
        gbc.gridx = 0;
        panel.add(new JLabel("Contraseña:"), gbc);
        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Botón Guardar
        JButton saveButton = new JButton("Guardar");
        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        // Acción del botón Guardar
        saveButton.addActionListener(e -> {
            // Puedes agregar aquí la lógica para guardar el usuario
            JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
            dispose(); // Cierra la ventana al guardar
        });

        // Añadir panel a la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new CrearUsuario();
    }
}
