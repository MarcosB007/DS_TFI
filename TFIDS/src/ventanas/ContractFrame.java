/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

/**
 *
 * @author MI PC
 */

import com.itextpdf.text.BadElementException;
import javax.swing.JOptionPane;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;


public class ContractFrame extends JFrame {

    private JTextField txtNombre, txtApellido, txtDNI, txtDomicilio, txtPuesto, txtContacto, txtSalario, txtFechaInicio, txtDuracion;
    private JButton btnGenerarPDF;

    public ContractFrame() {
        setTitle("Generar Contrato - Ingenio La Trinidad");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panel.add(txtApellido);

        panel.add(new JLabel("DNI:"));
        txtDNI = new JTextField();
        panel.add(txtDNI);

        panel.add(new JLabel("Domicilio:"));
        txtDomicilio = new JTextField();
        panel.add(txtDomicilio);

        panel.add(new JLabel("Puesto:"));
        txtPuesto = new JTextField();
        panel.add(txtPuesto);

        panel.add(new JLabel("Contacto:"));
        txtContacto = new JTextField();
        panel.add(txtContacto);

        panel.add(new JLabel("Salario:"));
        txtSalario = new JTextField();
        panel.add(txtSalario);

        panel.add(new JLabel("Fecha de Inicio:"));
        txtFechaInicio = new JTextField();
        panel.add(txtFechaInicio);

        panel.add(new JLabel("Duración:"));
        txtDuracion = new JTextField();
        panel.add(txtDuracion);
        
       
        btnGenerarPDF = new JButton("Generar Contrato");
        btnGenerarPDF.setBackground(new Color(0, 123, 62)); // Color de fondo del botón
        btnGenerarPDF.setForeground(Color.WHITE);
        
        btnGenerarPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarPDF();
                } catch (BadElementException ex) {
                    Logger.getLogger(ContractFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panel.add(btnGenerarPDF);
        
        add(panel);
        setVisible(true);
    }

    private void guardarPDF() throws BadElementException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar contrato como");   
        fileChooser.setSelectedFile(new File("Contrato_" + txtNombre.getText() + "_" + txtApellido.getText() + ".pdf"));
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            generarPDF(fileToSave.getAbsolutePath(), 
                txtNombre.getText(), 
                txtApellido.getText(), 
                txtDNI.getText(), 
                txtDomicilio.getText(), 
                txtPuesto.getText(), 
                txtContacto.getText(), 
                txtSalario.getText(), 
                txtFechaInicio.getText(), 
                txtDuracion.getText()
            );
        }
    }
      public void generarPDF(String ruta, String nombre, String apellido, String dni, String domicilio, String puesto,
                       String contacto, String salario, String fechaInicio, String duracion) throws BadElementException {
    Document document = new Document(PageSize.A4, 20, 20, 20, 20);
    try {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));
        document.open();
        
        // Ajuste de márgenes
        document.setMargins(30, 30, 30, 30); // Izquierda, Derecha, Arriba, Abajo

        // Agregar logo
        Image logo = Image.getInstance("C:\\Users\\MI PC\\Desktop\\DIseño\\DS_TFI\\TFIDS\\logo1.jpeg");
        logo.scaleToFit(100, 80);
        logo.setAlignment(Element.ALIGN_CENTER);
        document.add(logo);

        // Encabezado
        Paragraph encabezado = new Paragraph("Ingenio La Trinidad\nCalle Juan Manuel Mendez s/n - Chiclista - Tucuman\n03865-491030\n\n",
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
        encabezado.setAlignment(Element.ALIGN_CENTER);
        document.add(encabezado);

        // Título
        Paragraph titulo = new Paragraph("Contrato de Trabajo\n\n",
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);
        // Detalles del contrato
        Paragraph detalles = new Paragraph("Entre: Ingenio La Trinidad, con domicilio en La Trinidad, " +
                "representado por su apoderado Ing. Petrowich Gerardo, en adelante \"El Empleador\",\n\n" +
                nombre + " " + apellido + ", DNI " + dni + ", con domicilio en " + domicilio + ", " +
                "en adelante \"El Trabajador\", celebran el presente contrato conforme a las siguientes cláusulas:\n",
                new Font(Font.FontFamily.HELVETICA, 12));
        detalles.setSpacingBefore(10);
        detalles.setSpacingAfter(10);
        document.add(detalles);

        // Fecha
        document.add(new Paragraph("Fecha: " + fechaInicio + "\n", new Font(Font.FontFamily.HELVETICA, 12)));


        // Cuerpo del contrato con bordes
        Paragraph cuerpo = new Paragraph("Cláusulas del Contrato:\n", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        cuerpo.setSpacingBefore(10);
        cuerpo.setSpacingAfter(10);
        document.add(cuerpo);

        // Cláusulas
        String clausulas = "1. Objeto: El Trabajador se compromete a prestar servicios personales bajo la dependencia del Empleador, desempeñando la función de Supervisor de Obras.\n" +
                "2. Duración: El presente contrato tendrá una duración de 4 años, comenzando el 22/07/2024.\n" +
                "3. Jornada laboral: El Trabajador cumplirá una jornada laboral de 8 horas diarias de lunes a viernes.\n" +
                "4. Remuneración: El Empleador abonará al Trabajador una remuneración mensual de 800,000 pesos ($).\n" +
                "5. Vacaciones: El Trabajador tendrá derecho a vacaciones conforme a la ley.\n" +
                "6. Terminación: El contrato podrá ser rescindido por las causales previstas en la ley.\n" +
                "7. Confidencialidad: El Trabajador se compromete a mantener la confidencialidad de la información.\n";
        document.add(new Paragraph(clausulas, new Font(Font.FontFamily.HELVETICA, 10)));

        // Información del empleado
        document.add(new Paragraph("Información del Empleado:", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        document.add(new Paragraph("Nombre: " + nombre));
        document.add(new Paragraph("Apellido: " + apellido));
        document.add(new Paragraph("DNI: " + dni));
        document.add(new Paragraph("Domicilio: " + domicilio));
        document.add(new Paragraph("Puesto: " + puesto));
        document.add(new Paragraph("Contacto: " + contacto));
        document.add(new Paragraph("Salario: " + salario));
        document.add(new Paragraph("Fecha de Inicio: " + fechaInicio));
        document.add(new Paragraph("Duración: " + duracion));
        document.add(new Paragraph("\n\n"));

        // Firmas
        document.add(new Paragraph("Firmas:", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
        document.add(new Paragraph("\n")); // Añade un espacio antes de las firmas
        PdfPTable table = new PdfPTable(2); // Crear una tabla con 2 columnas
        table.setWidthPercentage(100); // Establecer el ancho de la tabla al 100%

        // Celda para la firma del empleado
        PdfPCell cellEmpleado = new PdfPCell(new Paragraph("_____________________________\nTrabajador: " + nombre, new Font(Font.FontFamily.HELVETICA, 10)));
cellEmpleado.setBorder(Rectangle.NO_BORDER); // Sin borde
cellEmpleado.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar texto
table.addCell(cellEmpleado); // Agregar celda de empleado

// Celda para la firma del empleador
PdfPCell cellEmpleador = new PdfPCell(new Paragraph("_____________________________\nEmpleador: Ingenio La Trinidad", new Font(Font.FontFamily.HELVETICA, 10)));
cellEmpleador.setBorder(Rectangle.NO_BORDER); // Sin borde
cellEmpleador.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar texto
table.addCell(cellEmpleador); // Agregar celda de empleador

// Agregar la tabla de firmas al documento
document.add(table);

        // Mensaje de éxito
        JOptionPane.showMessageDialog(null, "Contrato generado exitosamente en: " + ruta);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error: No se pudo crear el archivo. Verifica los permisos y la ruta.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (DocumentException e) {
        JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (IOException ex) {
        Logger.getLogger(ContractFrame.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        document.close();
    }
}

  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ContractFrame());
    }
}
