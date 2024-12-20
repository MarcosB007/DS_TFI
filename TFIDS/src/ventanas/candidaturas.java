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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import tfids.Candidato;
import tfids.DAO;
import tfids.OfertaTrabajo;
import tfids.Postulaciones;

public class candidaturas extends JFrame {
    DAO dao = new DAO();
    private JComboBox<String> filtroOfertaComboBox;
    private JPanel listaCandidatosPanel;
    private HashMap<String, String> cvs;
    private int dniCandidatoForButton;

    public candidaturas() {
        setTitle("Ingenio La Trinidad - Gestión de Candidaturas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cvs = new HashMap<>();
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Encabezado formal
        JPanel encabezadoPanel = new JPanel(new BorderLayout());
        encabezadoPanel.setBackground(new Color(0, 123, 62)); // Color sobrio para el encabezado

        JLabel tituloLabel = new JLabel("Contratación RRHH - Ingenio La Trinidad", JLabel.CENTER);
        tituloLabel.setFont(new Font("Serif", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE);
        encabezadoPanel.add(tituloLabel, BorderLayout.CENTER);

        add(encabezadoPanel, BorderLayout.NORTH);

        // Panel de filtro en la izquierda
        JPanel filtroPanel = new JPanel();
        filtroPanel.setLayout(new BoxLayout(filtroPanel, BoxLayout.Y_AXIS));
        filtroPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        filtroPanel.setBackground(new Color(230, 230, 250)); // Fondo claro y sobrio

        // Filtro de oferta de trabajo
        JLabel filtroOfertaLabel = new JLabel("Filtrar por oferta de trabajo:");
        filtroOfertaLabel.setFont(new Font("Serif", Font.BOLD, 14));
        filtroOfertaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        filtroPanel.add(filtroOfertaLabel);

        filtroOfertaComboBox = new JComboBox<>(new String[]{"Todas las ofertas", "Supervisor de Obra", "Administrador", "Operario", "Analista de Calidad"});
        filtroOfertaComboBox.setFont(new Font("Serif", Font.PLAIN, 14));
        filtroOfertaComboBox.setMaximumSize(new Dimension(200, 30));
        filtroOfertaComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        filtroOfertaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarCandidatos();
            }
        });
        filtroPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado entre el título y el combo box
        filtroPanel.add(filtroOfertaComboBox);

        add(filtroPanel, BorderLayout.WEST);

        // Panel central para la lista de candidatos
        listaCandidatosPanel = new JPanel();
        listaCandidatosPanel.setLayout(new BoxLayout(listaCandidatosPanel, BoxLayout.Y_AXIS));
        listaCandidatosPanel.setBackground(Color.WHITE);
        listaCandidatosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(listaCandidatosPanel), BorderLayout.CENTER);

        // Panel inferior para el botón "Volver al menú"
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton volverButton = new JButton("Volver al menú");
        volverButton.setBackground(new Color(34, 139, 34)); // Verde oscuro para el botón
        volverButton.setForeground(Color.WHITE);
        volverButton.setFocusPainted(false);
        volverButton.setFont(new Font("Serif", Font.BOLD, 14));
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //volverAlMenu();
                dispose();
                new panelPrincipal().setVisible(true);
            }
        });
        bottomPanel.add(volverButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Agrega candidatos a la lista
        agregarCandidatos();
    }

    private void agregarCandidatos() {
        listaCandidatosPanel.removeAll();
        
        ArrayList<Postulaciones> postulantes = dao.getPostulaciones();
        ArrayList<Candidato> candidatos = dao.getCandidatos();
        ArrayList<OfertaTrabajo> ofertas = dao.getOfertas();

        for(int i=0; i<postulantes.size();i++){
            String nombreApellido = "";
            Candidato candidato = null;
            String puesto = "";
            for(int j=0; j<candidatos.size();j++){
                if(postulantes.get(i).getDni() == candidatos.get(j).getDni()){ 
                    nombreApellido = candidatos.get(j).getNombreApellido();
                    candidato = candidatos.get(j);
                    break;
                }  
            }
            if (candidato != null && !candidato.isSeleccionado()) {
            // Busca la oferta correspondiente al ID de la postulación
            for (int k = 0; k < ofertas.size(); k++) {
                if (postulantes.get(i).getIdOferta() == ofertas.get(k).getIdOferta()) {
                    puesto = ofertas.get(k).getPuesto();
                    break; // Sale del bucle una vez que encuentra la oferta
                }
            }
            
            listaCandidatosPanel.add(crearCandidatoPanel(candidato, puesto));
        }
            
            /*for(int k=0; k < ofertas.size(); k++){
                if(postulantes.get(i).getIdOferta() == ofertas.get(k).getIdOferta()){
                    puesto = ofertas.get(k).getPuesto();
                    break;
                }
            }
            
            if(candidato.isSeleccionado() == false){
                listaCandidatosPanel.add(crearCandidatoPanel(candidato,puesto));
            }*/
            //listaCandidatosPanel.add(crearCandidatoPanel(candidato,puesto));
        }

        listaCandidatosPanel.revalidate();
        listaCandidatosPanel.repaint();
    }

    /*private JPanel crearCandidatoPanel(String nombre, String oferta) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(245, 245, 245));

        // Información del candidato en la izquierda
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(245, 245, 245));

        JLabel nombreLabel = new JLabel("<html><b>" + nombre + "</b><br>Oferta: " + oferta);
        nombreLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        infoPanel.add(nombreLabel);

        JLabel verCvLabel = new JLabel("<html><u>Ver CV</u></html>");
        verCvLabel.setForeground(Color.BLUE);
        verCvLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verCvLabel.setFont(new Font("Serif", Font.ITALIC, 12));
        verCvLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verCV(nombre);
            }
        });
        infoPanel.add(verCvLabel);

        panel.add(infoPanel, BorderLayout.CENTER);

        // Botón Confirmar en la derecha
        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.setBackground(new Color(0, 123, 62));
        confirmarButton.setForeground(Color.WHITE);
        confirmarButton.setFont(new Font("Serif", Font.BOLD, 12));
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dao.actualizarEstadoSeleccionado();
                confirmarCandidato(nombre);
            }
        });
        panel.add(confirmarButton, BorderLayout.EAST);

        panel.putClientProperty("oferta", oferta);
        //panel.putClientProperty("nombre", nombre);
        return panel;
    }*/
    
    private JPanel crearCandidatoPanel(Candidato candidato, String oferta) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Coloca el contenido en horizontal
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(245, 245, 245));
    panel.setMaximumSize(new Dimension(600, 60)); // Limita el ancho del panel

    // Información del candidato en la izquierda
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.setBackground(new Color(245, 245, 245));
    infoPanel.setMaximumSize(new Dimension(400, 60)); // Limita el ancho del infoPanel

    JLabel nombreLabel = new JLabel("<html><b>" + candidato.getNombreApellido() + "</b><br>Oferta: " + oferta + "</html>");
    nombreLabel.setFont(new Font("Serif", Font.PLAIN, 14));
    infoPanel.add(nombreLabel);

    JLabel verCvLabel = new JLabel("<html><u>Ver CV</u></html>");
    verCvLabel.setForeground(Color.BLUE);
    verCvLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    verCvLabel.setFont(new Font("Serif", Font.ITALIC, 12));
    verCvLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            verCV(candidato.getNombreApellido()); // Llama a verCV con el nombre del candidato
        }
    });
    infoPanel.add(verCvLabel);

    panel.add(infoPanel);

    // Botón Confirmar en la derecha, ajustado a un tamaño más pequeño
    JButton confirmarButton = new JButton("Confirmar");
    confirmarButton.setPreferredSize(new Dimension(80, 30)); // Define un tamaño fijo para el botón
    confirmarButton.setBackground(new Color(0, 123, 62));
    confirmarButton.setForeground(Color.WHITE);
    confirmarButton.setFont(new Font("Serif", Font.BOLD, 12));
    confirmarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            confirmarCandidato(candidato); // Llama a la función con el objeto Candidato
        }
    });
    panel.add(confirmarButton);

    panel.putClientProperty("oferta", oferta);
    return panel;
}


    private void filtrarCandidatos() {
        String filtroOferta = (String) filtroOfertaComboBox.getSelectedItem();

        for (Component comp : listaCandidatosPanel.getComponents()) {
            JPanel candidatoPanel = (JPanel) comp;
            String oferta = (String) candidatoPanel.getClientProperty("oferta");

            boolean ofertaCoincide = filtroOferta.equals("Todas las ofertas") || oferta.equals(filtroOferta);
            candidatoPanel.setVisible(ofertaCoincide);
        }

        listaCandidatosPanel.revalidate();
        listaCandidatosPanel.repaint();
    }

    private void verCV(String nombre) {
        try {
            Desktop.getDesktop().open(new File(cvs.get(nombre)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*private void confirmarCandidato(String nombre) {
        JOptionPane.showMessageDialog(this, "Candidato " + nombre + " confirmado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }*/
    
    private void confirmarCandidato(Candidato candidato) {
        JOptionPane.showMessageDialog(this, "Candidato " + candidato.getNombreApellido() + " confirmado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        // Aquí puedes agregar la funcionalidad que deseas, por ejemplo:
        dao.actualizarEstadoSeleccionado(candidato.getDni());
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new candidaturas().setVisible(true));
    }
}
