/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;
import datos.XML;
import java.util.Scanner;
public class Tarea1TamaraMariaJose {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        XML xml = new XML();

        while (true) {
            System.out.println("Bienvenido al sistema de dep�sitos bancarios");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Crear Cuenta");
            System.out.println("3. Modificar Cliente");
            System.out.println("4. Realizar una Transacci�n");
            System.out.println("5. Realizar un Traslado de Fondos");
            System.out.println("6. Generar Reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opci�n: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    //  Crer Usuario
                    break;
                case 2:
                   //crear cuentas 
                    break;
                case 3:
                    // modificar clientes
                    break;
                case 4:
                    // realizar una transacci�n
                    break;
                case 5:
                    //  realizar un traslado de fondos
                    break;
                case 6:
                    // generar reportes
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opci�n no v�lida. Intente de nuevo.");
            }
        
    }
    }
}

