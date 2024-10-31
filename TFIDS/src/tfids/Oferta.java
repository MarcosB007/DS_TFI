/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfids;

/**
 *
 * @author MI PC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oferta extends JFrame {
    private JTextField puestoField;
    private JTextArea descripcionField;
    private JTextArea requisitosField;
    private JTextArea ofrecimientosField;

    public Oferta() {
        setTitle("Publicar Nueva Oferta de Trabajo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 123, 62));
        JLabel headerLabel = new JLabel("Publicar Nueva Oferta de Trabajo");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 26));
        headerPanel.add(headerLabel);

        // Panel del formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.LIGHT_GRAY); // Fondo claro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10); // Espaciado aumentado
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo "Puesto"
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Puesto:"), gbc);
        puestoField = new JTextField(30);
        gbc.gridx = 1;
        formPanel.add(puestoField, gbc);

        // Campo "Descripción del Puesto"
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Descripción del Puesto:"), gbc);
        descripcionField = new JTextArea(5, 30);
        descripcionField.setLineWrap(true);
        descripcionField.setWrapStyleWord(true);
        gbc.gridx = 1;
        formPanel.add(new JScrollPane(descripcionField), gbc);

        // Campo "Requisitos y/o Responsabilidades"
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Requisitos y/o Responsabilidades:"), gbc);
        requisitosField = new JTextArea(5, 30);
        requisitosField.setLineWrap(true);
        requisitosField.setWrapStyleWord(true);
        gbc.gridx = 1;
        formPanel.add(new JScrollPane(requisitosField), gbc);

        // Campo "Ofrecimientos"
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Ofrecimientos:"), gbc);
        ofrecimientosField = new JTextArea(5, 30);
        ofrecimientosField.setLineWrap(true);
        ofrecimientosField.setWrapStyleWord(true);
        gbc.gridx = 1;
        formPanel.add(new JScrollPane(ofrecimientosField), gbc);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton publicarButton = new JButton("Publicar Oferta");
        publicarButton.setBackground(new Color(0, 128, 0));
        publicarButton.setForeground(Color.WHITE);
        publicarButton.setFont(new Font("Arial", Font.PLAIN, 14));
        publicarButton.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Bordes

        JButton volverButton = new JButton("Volver al menú");
        volverButton.setBackground(new Color(0, 128, 0));
        volverButton.setForeground(Color.WHITE);
        volverButton.setFont(new Font("Arial", Font.PLAIN, 14));
        volverButton.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Bordes

        // Acción al hacer clic en "Publicar Oferta"
        publicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    JOptionPane.showMessageDialog(Oferta.this, "Oferta de trabajo publicada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Aquí podrías agregar la lógica para guardar la oferta en la base de datos o similar.
                } else {
                    JOptionPane.showMessageDialog(Oferta.this, "Completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción al hacer clic en "Volver al menú"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });

        buttonPanel.add(publicarButton);
        buttonPanel.add(volverButton);

        // Agregar componentes al JFrame
        add(headerPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private boolean validarCampos() {
        return !puestoField.getText().trim().isEmpty()
                && !descripcionField.getText().trim().isEmpty()
                && !requisitosField.getText().trim().isEmpty()
                && !ofrecimientosField.getText().trim().isEmpty();
    }

}

