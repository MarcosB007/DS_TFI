/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

/**
 *
 * @author MI PC
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        // Configuración de la ventana principal
        setTitle("Generación de Contratos - Ingenio La Trinidad");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));


        // Encabezado
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 80, 50));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 80));


        JLabel titleLabel = new JLabel("Lista de Candidatos Seleccionados para Contratación", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        
        // Panel de contenido principal con BoxLayout y JScrollPane
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(245,245,245));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
         // Añadir candidatos como "tarjetas" visuales
        contentPanel.add(createCandidateBlock("Berdu Jasmin", "Ingeniería Mecánica"));
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        // Panel para el botón "Volver al Menú" en la parte inferior derecha
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setBackground(new Color(245, 245, 245));
        
        JButton backButton = new JButton("Volver al Menú");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(0, 123, 62));
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Acción para volver al panel principal
                new panelPrincipal();
            }
        });
        footerPanel.add(backButton);
        
         // Añadir paneles al panel principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Añadir el panel principal a la ventana
        add(mainPanel);
        setVisible(true);
    }
    
    private JPanel createCandidateBlock(String name, String profile) {
        JPanel candidateBlock = new JPanel(new BorderLayout());
        candidateBlock.setBackground(Color.WHITE);
        candidateBlock.setPreferredSize(new Dimension(500, 120)); // Tamaño de cada "tarjeta"
        candidateBlock.setMaximumSize(new Dimension(700, 120));
        candidateBlock.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
    ));
    
    candidateBlock.setAlignmentX(Component.CENTER_ALIGNMENT);
   
    // Información del candidato
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel candidateLabel = new JLabel(name);
        candidateLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        candidateLabel.setForeground(new Color(50, 50, 50));
        infoPanel.add(candidateLabel);

        JLabel profileLabel = new JLabel("Perfil: " + profile);
        profileLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        profileLabel.setForeground(new Color(100, 100, 100));
        infoPanel.add(profileLabel);
        
     candidateBlock.add(infoPanel, BorderLayout.CENTER);
     
     // Botón de acción
        JButton generateButton = new JButton("Generar Contrato");
        generateButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        generateButton.setForeground(Color.WHITE);
        generateButton.setBackground(new Color(0, 123, 62));
        generateButton.setFocusPainted(false);
        generateButton.setPreferredSize(new Dimension(140, 30)); // Botón más compacto// Acción del botón "Generar Contrato"
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se abre la ventana de Contrato
                new ContractFrame().setVisible(true);
            }
        });
        
        // Panel del botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(generateButton);

        candidateBlock.add(buttonPanel, BorderLayout.EAST);

        return candidateBlock;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

