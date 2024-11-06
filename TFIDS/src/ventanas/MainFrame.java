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
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con color de fondo claro y borde
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Encabezado
        JPanel encabezadoPanel = new JPanel(new BorderLayout());
        encabezadoPanel.setBounds(0, 0, 1500, 60);
        encabezadoPanel.setBackground(new Color(0, 123, 62));

        JLabel titleLabel = new JLabel("Lista de Candidatos Seleccionados para Contratación");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        encabezadoPanel.add(titleLabel, BorderLayout.CENTER);

        // Información del candidato
        JLabel candidateLabel = new JLabel("Berdu Jasmin - Perfil: Ingeniería Mecánica");
        candidateLabel.setBounds(20, 80, 500, 25);
        candidateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        candidateLabel.setForeground(new Color(80, 80, 80));

        // Botón para generar contrato
        JButton generateButton = new JButton("Generar Contrato");
        generateButton.setBounds(20, 130, 200, 40);
        generateButton.setFont(new Font("Arial", Font.BOLD, 14));
        generateButton.setForeground(Color.WHITE);
        generateButton.setBackground(new Color(0, 123, 62));
        generateButton.setFocusPainted(false);
        generateButton.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 40), 2));

        // Acción al hacer clic en el botón "Generar Contrato"
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContractFrame(); // Abre la ventana para generar contrato
            }
        });

        // Añadir componentes al panel principal
        panel.add(encabezadoPanel);
        panel.add(candidateLabel);
        panel.add(generateButton);

        // Añadir panel principal a la ventana
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

