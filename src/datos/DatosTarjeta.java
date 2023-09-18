/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DatosTarjeta {

    // Ruta al archivo de tarjetas (ajusta la ruta según tu configuración)
    private static final String ARCHIVO_TARJETAS = "tarjetas.txt";

    public void guardarTarjetaEnArchivo(String numTarjeta, String tipoTarjeta, String propietarioTarjeta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_TARJETAS, true))) {
            // Escribe la información de la tarjeta en el archivo
            writer.write(numTarjeta + "," + tipoTarjeta + "," + propietarioTarjeta);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Agrega métodos para recuperar tarjetas del archivo o base de datos si es necesario

    public void guardarTarjetaEnBaseDeDatos(String numTarjeta, String tipoTarjeta, String propietarioTarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
