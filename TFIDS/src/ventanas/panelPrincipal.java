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


public class panelPrincipal extends JFrame {
    private JLabel background;

    public panelPrincipal() {
        setTitle("Contratación RRHH - Ingenio La Trinidad");
        setSize(800, 600); // Tamaño inicial
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Cargar y escalar la imagen de fondo
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\MI PC\\Documents\\NetBeansProjects\\JavaApplication5\\imagen\\vvvvv.png");
        Image scaledImage = backgroundIcon.getImage().getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(scaledImage);
        
        background = new JLabel(backgroundIcon);
        background.setLayout(new BorderLayout());  // Permite agregar otros componentes sobre el fondo
        setContentPane(background);  // Configura background como el panel principal

        // Título superior con logo
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 123, 62, 230));
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        titlePanel.setOpaque(true);

        // Logo del ingenio
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\MI PC\\Documents\\NetBeansProjects\\JavaApplication5\\imagen\\ver.png");
        JLabel logoLabel = new JLabel(logoIcon);

        // Texto del título
        JLabel titleLabel = new JLabel("Contratación RRHH - Ingenio La Trinidad", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Agregar logo y título al panel de título
        titlePanel.add(logoLabel);
        titlePanel.add(titleLabel);

        // Añadir el panel del título al norte
        background.add(titlePanel, BorderLayout.NORTH);

        // Panel de botones principal
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 2, 12, 12)); // Espaciado de 10 píxeles entre botones
        buttonPanel.setOpaque(false);

        String[] buttonTexts = {"Publicar Oferta de Trabajo", "Candidaturas", "Entrevistas", "Evaluación de Entrevistas", "Contratación"};
        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setBackground(new Color(0, 128, 0));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(button);
            
            // Agregar ActionListener solo para el botón "Publicar Oferta de Trabajo"
            if (text.equals("Publicar Oferta de Trabajo")) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Oferta(); // Abre la ventana PublicarOferta
                    }
                });
            }

            buttonPanel.add(button);
        }
        
         

        // Añadir el panel de botones al centro con espaciado alrededor
        JPanel centeredButtonPanel = new JPanel();
        centeredButtonPanel.setOpaque(false);
        centeredButtonPanel.setLayout(new GridBagLayout());
        centeredButtonPanel.add(buttonPanel);
        background.add(centeredButtonPanel, BorderLayout.CENTER);

        // Pie de página
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(0, 123, 62));
        JLabel footerLabel = new JLabel("Ingenio La Trinidad © 2024. Todos los derechos reservados.", SwingConstants.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        footerPanel.add(footerLabel);

        // Añadir el pie de página al sur
        background.add(footerPanel, BorderLayout.SOUTH);

        // Hacer visible la ventana
        setVisible(true);
    }


    
 }

