/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;
import datos.XML;
import java.util.Scanner;
import negocio.Cliente;
import negocio.Cuenta;
public class Tarea1TamaraMariaJose {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cliente cliente =new Cliente();
        Cuenta cuenta = new Cuenta();
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
                   System.out.print("Digite su nombre"); 
                   String nom=scanner.nextLine();
                   System.out.print("Digite su identificación");
                   String id=scanner.nextLine();
                   System.out.print("Digite su telefono");
                   String tel =scanner.nextLine();
                   cliente.agregarClientesC(nom,id,tel);
                    break;
                case 2:
                   System.out.print("Digite su numero de cuenta:"); 
                   String num=scanner.nextLine();
                   System.out.print("Digite su tipo:");
                   String tipo =scanner.nextLine();
                   System.out.print("Digite su nombre:");
                   String no =scanner.nextLine();
                   cuenta.agregarCuentaC(num,tipo,no);
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

