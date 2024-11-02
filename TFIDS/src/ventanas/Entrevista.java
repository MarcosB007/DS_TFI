/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Entrevista extends JFrame {
       
    public Entrevista() {
        // Configuración de la ventana principal
        setTitle("Programar Entrevistas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior para el título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        // Crear el título centrado
        JLabel titleLabel = new JLabel("Programación de Entrevistas - Ingenio La Trinidad", SwingConstants.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 128, 0)); // Color verde
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        // Agregar el título al panel superior
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Panel principal para los contenidos
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Candidato 1
        mainPanel.add(crearPanelCandidato("Jasmin Berdu", "Ingeniería Mecánica"));

        // Candidato 2
        mainPanel.add(crearPanelCandidato("Marcos Brandan", "Ingeniería Industrial"));
        
        // Candidato 3
        mainPanel.add(crearPanelCandidato("Gonzalo Albarracin", "Ingeniería en Alimentos"));

        // Botón Volver al Menú
        JButton volverButton = new JButton("Volver al Menú");
        volverButton.setBackground(new Color(0, 128, 0)); // Color verde
        volverButton.setForeground(Color.WHITE);
        volverButton.setFont(new Font("Arial", Font.PLAIN, 14));
        volverButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        volverButton.setPreferredSize(new Dimension(120, 30));
        
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        
       
        // Agregar los paneles al JFrame
        add(topPanel, BorderLayout.NORTH); // Agregar el panel del título en la parte superior
        add(mainPanel, BorderLayout.CENTER); // Agregar el panel principal en el centro
        add(volverButton, BorderLayout.SOUTH); // Agregar el botono Volver al final de todo
        setVisible(true);  // Hace visible la ventana
    }

    private JPanel crearPanelCandidato(String nombre, String perfil) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nombreLabel = new JLabel(nombre);
        JLabel perfilLabel = new JLabel("Perfil: " + perfil);
        JTextField fechaField = new JTextField("dd/mm/aaaa");
        JComboBox<String> horaComboBox = new JComboBox<>(new String[] {"08:00", "09:00", "10:00", "11:00"});
        JButton programarButton = new JButton("Programar Entrevista");

        programarButton.setBackground(new Color(0, 128, 0)); // Color verde
        programarButton.setForeground(Color.WHITE);
        
        // ActionListener para el botón "Programar Entrevista"
        programarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = fechaField.getText().trim();
                String hora = (String) horaComboBox.getSelectedItem();

                // Validar si la fecha o la hora no están seleccionadas o ingresadas correctamente
                if (fecha.isEmpty() || fecha.equals("dd/mm/aaaa") || hora.isEmpty()) {
                    // Mostrar mensaje de error
                    JOptionPane.showMessageDialog(Entrevista.this,
                            "Por favor ingrese una fecha y seleccione una hora para la entrevista.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // Crear y mostrar el mensaje de confirmación centrado
                    JOptionPane pane = new JOptionPane("Entrevista programada para " + nombre + " el " + fecha + " a las " + hora,
                            JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = pane.createDialog(Entrevista.this, "Confirmación de Entrevista");
                    dialog.setLocation(getX() + getWidth() / 2 - dialog.getWidth() / 2, getY() + 100); // Centrado y en la parte superior
                    dialog.setVisible(true);
                }
            }
        });
        
        panel.add(nombreLabel);
        panel.add(perfilLabel);
        panel.add(new JLabel("Seleccionar Fecha:"));
        panel.add(fechaField);
        panel.add(new JLabel("Seleccionar Hora:"));
        panel.add(horaComboBox);
        panel.add(programarButton);

        return panel;
    }    
    
    public static void main(String[] args) {
        new Entrevista();
    }
}   
