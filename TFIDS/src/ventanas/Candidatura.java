/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class Candidatura extends JFrame{
    private JPanel candidatoPanel; // Panel donde se muestran los candidatos
    private String[][] candidatos = {
        {"Jasmin Berdu", "Ingeniería Mecánica"},
        {"Jasmin Berdu2", "Ingeniería Mecánica"},
        {"Marcos Brandan", "Ingeniería Industrial"},
        {"Marcos Brandan2", "Ingeniería Industrial"},
        {"Rocio Aguero", "Ingeniería Química"},
        {"Rocio Aguero2", "Ingeniería Química"},
        {"Gonzalo Albarracín", "Ingeniería en Alimentos"},
        {"Gonzalo Albarracín2", "Ingeniería en Alimentos"}
    };

    public Candidatura() {
        setTitle("Lista de Candidaturas Recibidas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear el panel principal
        JPanel canPanel = new JPanel();
        canPanel.setLayout(new BorderLayout());

        // Crear el título
        JLabel tituloLabel = new JLabel("Ingenio La Trinidad - Candidaturas", SwingConstants.CENTER);
        tituloLabel.setOpaque(true);
        tituloLabel.setBackground(new Color(0, 123, 62));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 26));
        //canPanel.add(tituloLabel, BorderLayout.NORTH);
        
        // Panel para contener el título y el filtro
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(tituloLabel, BorderLayout.NORTH);

        // Panel para filtrar
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel filterLabel = new JLabel("Filtrar por oferta de trabajo");
        
        // ComboBox para seleccionar el perfil de ingeniería
        JComboBox<String> jobFilterCombo = new JComboBox<>(new String[]{
            "Todas las ofertas", 
            "Ingeniería Mecánica", 
            "Ingeniería Industrial", 
            "Ingeniería Química", 
            "Ingeniería en Alimentos"
        });
        
        filterPanel.add(filterLabel);
        filterPanel.add(jobFilterCombo);
        
        // Agregar el filtro al panel superior (debajo del título)
        topPanel.add(filterPanel, BorderLayout.CENTER);

        // Agregar el panel superior al panel principal
        canPanel.add(topPanel, BorderLayout.NORTH);

        // Panel donde se mostrará la lista de candidatos
        candidatoPanel = new JPanel();
        candidatoPanel.setLayout(new BoxLayout(candidatoPanel, BoxLayout.Y_AXIS));

        // Agregar el panel de candidatos dentro de un JScrollPane
        JScrollPane scrollPane = new JScrollPane(candidatoPanel);
        canPanel.add(scrollPane, BorderLayout.CENTER);

        // Mostrar todos los candidatos
        mostrarCandidatos("Todas las ofertas");

        // Listener para el combo box de filtrado
        jobFilterCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) jobFilterCombo.getSelectedItem();
                mostrarCandidatos(seleccion); // Filtra los candidatos según la selección
            }
        });

        // Botón de volver al menú
        JButton volverButton = new JButton("Volver al menú");
        volverButton.setBackground(new Color(0, 128, 0));
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
        canPanel.add(volverButton, BorderLayout.SOUTH);

        // Añadir el panel principal al JFrame
        setContentPane(canPanel);
        setVisible(true);
    }

    private void mostrarCandidatos(String filtro) {
        candidatoPanel.removeAll(); // Eliminar el contenido actual del panel de candidatos

        for (String[] candidato : candidatos) {
            String nombre = candidato[0];
            String perfil = candidato[1];

            // Mostrar el candidato si su perfil coincide con el filtro seleccionado
            if (filtro.equals("Todas las ofertas") || perfil.equals(filtro)) {
                JPanel candiPanel = new JPanel();
                candiPanel.setLayout(new BorderLayout());
                candiPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

                JLabel nombreLabel = new JLabel(nombre);
                JLabel perfilLabel = new JLabel("Perfil: " + perfil);
                perfilLabel.setForeground(Color.DARK_GRAY);
                JButton verButton = new JButton("Ver CV");
                JButton confirmarButton = new JButton("Confirmar");
                confirmarButton.setBackground(new Color(34, 139, 34));
                confirmarButton.setForeground(Color.WHITE);

                confirmarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Candidatura.this, "Candidatura de " + nombre + " confirmada.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    }
                });

                // Panel para los botones
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                buttonPanel.add(verButton);
                buttonPanel.add(confirmarButton);

                // Agregar etiquetas y botones al panel de cada candidato
                candiPanel.add(nombreLabel, BorderLayout.NORTH);
                candiPanel.add(perfilLabel, BorderLayout.CENTER);
                candiPanel.add(buttonPanel, BorderLayout.SOUTH);

                // Añadir el panel del candidato al panel de candidatos
                candidatoPanel.add(candiPanel);
            }
        }

        // Actualizar el panel de candidatos y refrescar la vista
        candidatoPanel.revalidate();
        candidatoPanel.repaint();
    }

    public static void main(String[] args) {
        new Candidatura();
    }
}
