/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;
import negocio.Cliente;
import negocio.Cuenta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tarea1TamaraMariaJose {

    private JTextField nombreField;
    private JTextField identificacionField;
    private JTextField telefonoField;
    private JTextField numCuentaField;
    private JTextField tipoCuentaField;
    private JTextField propietarioField;
    private JTextArea outputArea;

    private Cliente cliente;
    private Cuenta cuenta;

    public Tarea1TamaraMariaJose() {
        JFrame frame = new JFrame("Sistema de Depósitos Bancarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        JLabel identificacionLabel = new JLabel("Identificación:");
        identificacionField = new JTextField(20);
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoField = new JTextField(20);

        JLabel numCuentaLabel = new JLabel("Número de Cuenta:");
        numCuentaField = new JTextField(20);
        JLabel tipoCuentaLabel = new JLabel("Tipo de Cuenta:");
        tipoCuentaField = new JTextField(20);
        JLabel propietarioLabel = new JLabel("Propietario:");
        propietarioField = new JTextField(20);

        JButton agregarClienteButton = new JButton("Agregar Cliente");
        agregarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });

        JButton agregarCuentaButton = new JButton("Agregar Cuenta");
        agregarCuentaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarCuenta();
            }
        });

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(identificacionLabel);
        panel.add(identificacionField);
        panel.add(telefonoLabel);
        panel.add(telefonoField);
        panel.add(numCuentaLabel);
        panel.add(numCuentaField);
        panel.add(tipoCuentaLabel);
        panel.add(tipoCuentaField);
        panel.add(propietarioLabel);
        panel.add(propietarioField);
        panel.add(agregarClienteButton);
        panel.add(agregarCuentaButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        cliente = new Cliente();
        cuenta = new Cuenta();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Tarea1TamaraMariaJose();
            }
        });
    }

    void agregarCliente() {
        String nombre = nombreField.getText();
        String identificacion = identificacionField.getText();
        String telefono = telefonoField.getText();

        if (!nombre.isEmpty() && !identificacion.isEmpty() && !telefono.isEmpty()) {
            cliente.agregarClientesC(nombre, identificacion, telefono);
            outputArea.append("Cliente agregado: " + nombre + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos del cliente.");
        }
    }

    void agregarCuenta() {
        String numCuenta = numCuentaField.getText();
        String tipoCuenta = tipoCuentaField.getText();
        String propietario = propietarioField.getText();

        if (!numCuenta.isEmpty() && !tipoCuenta.isEmpty() && !propietario.isEmpty()) {
            cuenta.agregarCuentaC(numCuenta, tipoCuenta, propietario);
            outputArea.append("Cuenta agregada: " + numCuenta + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos de la cuenta.");
        }
    }
}

