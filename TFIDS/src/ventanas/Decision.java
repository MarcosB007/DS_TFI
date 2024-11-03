import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Decision {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Ventana con dos paneles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 100, 0)); 
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Decisiones de Contratación - Ingenio La Trinidad");
        titleLabel.setForeground(Color.WHITE); 
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); 

        JLabel subtitleLabel = new JLabel("Listas de Candidatos Entrevistados");
        subtitleLabel.setFont(new Font("Serif", Font.BOLD, 18)); 

        topPanel.add(titleLabel);
        topPanel.add(subtitleLabel);

        // Panel central que contiene los dos paneles
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));

        // Crear dos paneles
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        // Añadir elementos al primer panel
        JLabel title1 = new JLabel("<html><b>Jasmin Berdu 1</b></html>");
        JLabel occupation1 = new JLabel("Perfil: Ingeniera Mecánica");
        JLabel decisionLabel1 = new JLabel("Decisión:");
        JComboBox<String> comboBox1 = new JComboBox<>(new String[] {"Aceptado", "Rechazado", "En Espera"});
        JButton saveButton1 = new JButton("Guardar");
        saveButton1.setBackground(new Color(0, 100, 0)); 
        saveButton1.setForeground(Color.WHITE); 

        panel1.add(title1);
        panel1.add(occupation1);
        panel1.add(decisionLabel1);
        panel1.add(comboBox1);
        panel1.add(saveButton1);

        // Añadir elementos al segundo panel
        JLabel title2 = new JLabel("<html><b>Marcos Brandan 2</b></html>");
        JLabel occupation2 = new JLabel("Perfil: Ingeniero Industrial");
        JLabel decisionLabel2 = new JLabel("Decisión:");
        JComboBox<String> comboBox2 = new JComboBox<>(new String[] {"Aceptado", "Rechazado", "En Espera"});
        JButton saveButton2 = new JButton("Guardar");
        saveButton2.setBackground(new Color(0, 100, 0)); 
        saveButton2.setForeground(Color.WHITE); 

        panel2.add(title2);
        panel2.add(occupation2);
        panel2.add(decisionLabel2);
        panel2.add(comboBox2);
        panel2.add(saveButton2);

        // Añadir los paneles al panel central
        centerPanel.add(panel1);
        centerPanel.add(panel2);

        // Crear un botón para volver al menú
        JButton backButton = new JButton("Volver al Menú");
        backButton.setBackground(new Color(0, 100, 0)); 
        backButton.setForeground(Color.WHITE); 

        // Añadir los paneles al marco
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.SOUTH);

        // Hacer la ventana visible
        frame.setVisible(true);

        // Acciones para los botones guardar
        saveButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        saveButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           
            }
        });

        // Acción para el botón volver al menú
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                
            }
        });
    }

   
}



