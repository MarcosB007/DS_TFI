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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.EmptyBorder;
import tfids.Candidato;
import tfids.DAO;
import tfids.Entrevista;
import tfids.Gerente;

public class Entrevistas extends JFrame {

    public Entrevistas() {
        setTitle("Programación de Entrevistas - Ingenio La Trinidad");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con márgenes
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // Panel de título
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0, 123, 62));

        JLabel titleLabel = new JLabel("Programación de Entrevistas - Ingenio La Trinidad", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1, 0, 10)); // Dos filas para los candidatos
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        //Candidato 1
        //JPanel candidate1Panel = crearPanelCandidato("Jasmin Berdu",123);
        //contentPanel.add(candidate1Panel);

        // Candidato 2
        //JPanel candidate2Panel = crearPanelCandidato("Marcos Brandan", "Ingeniería en Sistemas");
        //contentPanel.add(candidate2Panel);
        
        //JPanel candidate3Panel = crearPanelCandidato("Gonzalo Albarracin", "Ingenieria Civil");
        //contentPanel.add(candidate3Panel);
        
        
        DAO dao = new DAO();
        ArrayList<Candidato> candidatos = new ArrayList<>();
        ArrayList<Entrevista> entrevista = new ArrayList<>();
        candidatos = dao.getCandidatos();
        entrevista = dao.getEntrevistas();
        System.out.println("cantidad entrevistas :" + entrevista.size());
        for(int i=0; i<candidatos.size();i++){
            
            if (candidatos.get(i).isSeleccionado()) {
                // Usar una bandera para verificar si tiene entrevista programada
                boolean tieneEntrevista = false;

                // Verificar en el listado de entrevistas si ya tiene una programada
                for (int j=0; j<entrevista.size();j++) {
                    if (entrevista.get(j).getDniCandidato() == candidatos.get(i).getDni()) {
                        tieneEntrevista = true;
                        System.out.println("Candidato ya tiene entrevista programada");
                        break; // Salir del bucle si ya se encontró una entrevista para el candidato
                    }
                }

                // Si no tiene entrevista, crear el panel para el candidato
                if (!tieneEntrevista) {
                    JPanel panelCandidato = crearPanelCandidato(candidatos.get(i).getNombreApellido(), candidatos.get(i).getDni());
                    contentPanel.add(panelCandidato);
                }
            }
            
            
        }

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Panel de botón "Volver al Menú"
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton volverButton = new JButton("Volver al menú");
        volverButton.setBackground(new Color(34, 139, 34)); // Verde oscuro para el botón
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setFont(new Font("Serif", Font.BOLD, 14));
        
        // ActionListener para el botón Volver al menú
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes volver al panel principal o cerrar la ventana
                // Si solo deseas cerrar la ventana actual:
                dispose();
                new panelPrincipal().setVisible(true);
                // Si tienes un método para volver al panel principal, puedes llamarlo aquí.
                // por ejemplo: mostrarPanelPrincipal();
            }
        });

        bottomPanel.add(volverButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel principal a la ventana
        add(mainPanel);
    }    

    private JPanel crearPanelCandidato(String nombre, int dni) {
        JPanel candidatePanel = new JPanel();
        candidatePanel.setLayout(new BorderLayout());
        candidatePanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        candidatePanel.setBackground(Color.WHITE);
        
        // Información del candidato
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setBackground(Color.WHITE);
        
        JLabel nameLabel = new JLabel(nombre);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        nameLabel.setForeground(new Color(24, 78, 119));

        //JLabel profileLabel = new JLabel("Perfil: " + perfil);
        //profileLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        //profileLabel.setForeground(Color.DARK_GRAY);
        
        infoPanel.add(nameLabel);
        //infoPanel.add(profileLabel);

        // Panel para selección de fecha y hora
        JPanel datetimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datetimePanel.setBackground(Color.WHITE);

        // Selección de Fecha
        JLabel dateLabel = new JLabel("Fecha:");
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
        dateSpinner.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // Selección de Hora
        JLabel timeLabel = new JLabel("Hora:");
        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm"));
        timeSpinner.setFont(new Font("SansSerif", Font.PLAIN, 12));

        // Agregar los componentes al panel de fecha y hora
        datetimePanel.add(dateLabel);
        datetimePanel.add(dateSpinner);
        datetimePanel.add(Box.createHorizontalStrut(20)); // Separador
        datetimePanel.add(timeLabel);
        datetimePanel.add(timeSpinner);

        // Botón para programar entrevista (Diseño Formal y más pequeño)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.WHITE);

        JButton scheduleButton = new JButton("Programar");
        scheduleButton.setBackground(new Color(0, 123, 62));  // Verde oscuro para un aspecto formal
        scheduleButton.setForeground(Color.WHITE);
        scheduleButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        scheduleButton.setFocusPainted(false);
        scheduleButton.setPreferredSize(new Dimension(120, 30)); // Tamaño más pequeño y discreto
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DAO dao = new DAO();
                Gerente gerente = Gerente.getInstancia();

                Date dateValue  = (Date) dateSpinner.getValue();
                Date timeValue  = (Date) timeSpinner.getValue();
                
                LocalDate selectedDate = dateValue.toInstant()
                                      .atZone(ZoneId.systemDefault())
                                      .toLocalDate();
                LocalTime selectedTime = timeValue.toInstant()
                                      .atZone(ZoneId.systemDefault())
                                      .toLocalTime();

                dao.crearEntrevista(selectedDate, selectedTime, Entrevista.EstadoEntrevista.ENTREVISTA_PROGRAMADA, gerente.getDni(), dni);

                // Formatear la fecha y la hora para el mensaje de confirmación
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

                // Mensaje de confirmación
                JOptionPane.showMessageDialog(null, 
                    "Entrevista programada para " + nombre + 
                    " el " + selectedDate.format(dateFormatter) +
                    " a las " + selectedTime.format(timeFormatter),
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Añadir subpaneles al panel principal del candidato
        candidatePanel.add(infoPanel, BorderLayout.NORTH);
        candidatePanel.add(datetimePanel, BorderLayout.CENTER);
        buttonPanel.add(scheduleButton); // Agregar botón en un panel separado debajo de fecha y hora
        candidatePanel.add(buttonPanel, BorderLayout.SOUTH);

        return candidatePanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Entrevistas().setVisible(true);
        });
    }
}
