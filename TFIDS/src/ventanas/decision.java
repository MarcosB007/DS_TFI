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

public class decision extends JFrame {

    public decision() {
        setTitle("Decisiones de Contratación - Ingenio La Trinidad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 123, 62)); // Color corporativo
        JLabel headerLabel = new JLabel("Decisiones de Contratación - Ingenio La Trinidad");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Contenedor principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel, BorderLayout.CENTER);

        // Paneles para los candidatos
        mainPanel.add(createCandidatePanel("Jasmin Berdu", "Ingeniería Mecánica", "jasmin@example.com"));
        mainPanel.add(Box.createVerticalStrut(20));  // Espacio entre candidatos
        mainPanel.add(createCandidatePanel("Marcos Brandan", "Ingeniería en Sistemas", "marcos@example.com"));
         mainPanel.add(Box.createVerticalStrut(20));  // Espacio entre candidatos
        mainPanel.add(createCandidatePanel("Gonzalo Albarracin", "Ingeniería Civil", "gonzalo@example.com"));


        // Panel para el botón de volver
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnVolver = new JButton("Volver al Menu");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(34, 139, 34));
        btnVolver.setPreferredSize(new Dimension(150, 30));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  // Cierra la ventana actual
                new panelPrincipal().setVisible(true);
                // Aquí puedes añadir lógica para volver a la pantalla anterior
            }
        });
        bottomPanel.add(btnVolver);
        add(bottomPanel, BorderLayout.SOUTH);
        
         add(mainPanel);
    }

    private JPanel createCandidatePanel(String name, String profile, String email) {
        JPanel candidatePanel = new JPanel(new BorderLayout(10, 10));
        candidatePanel.setPreferredSize(new Dimension(300, 80));
        candidatePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        // Información del candidato
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel profileLabel = new JLabel("Perfil: " + profile);
        profileLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

        infoPanel.add(nameLabel);
        infoPanel.add(profileLabel);
        candidatePanel.add(infoPanel, BorderLayout.NORTH);

        // Dropdown de decisiones y botón Guardar
        JPanel decisionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel decisionLabel = new JLabel("Decisión:");
        decisionLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JComboBox<String> decisionCombo = new JComboBox<>(new String[]{"Aceptado", "Rechazado", "En Espera"});
        decisionCombo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        decisionCombo.setPreferredSize(new Dimension(120, 25));

        JButton btnGuardar = new JButton("Guardar Decisión");
        btnGuardar.setBackground(new Color(34, 139, 34));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnGuardar.setPreferredSize(new Dimension(150, 25));
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String decision = (String) decisionCombo.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Decisión guardada y notificada al candidato: " + name,
                        "Notificación", JOptionPane.INFORMATION_MESSAGE);

                // Simulación de envío de correo
                enviarCorreo(email, decision);
            }
        });

        decisionPanel.add(decisionLabel);
        decisionPanel.add(decisionCombo);
        decisionPanel.add(btnGuardar);

        candidatePanel.add(decisionPanel, BorderLayout.SOUTH);

        return candidatePanel;
    }

    // Simulación del envío de correo
    private void enviarCorreo(String email, String decision) {
        String mensaje = "Estimado candidato,\n\n"
                + "Le informamos que su solicitud ha sido " + decision.toLowerCase() + ".\n"
                + "Gracias por su interés en formar parte de Ingenio La Trinidad.\n\n"
                + "Atentamente,\nDepartamento de RRHH";

        JOptionPane.showMessageDialog(this, 
                "Correo enviado a: " + email + "\n\n" + mensaje, 
                "Simulación de Envío de Correo", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new decision().setVisible(true);
            }
        });
    }
}
