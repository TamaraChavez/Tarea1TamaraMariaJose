/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DatosCuenta{
    

    public void agregarCuentaXml(String numCuenta, String tipoCuenta, String Propietario) 
    {
        try {
                String archivoXml = "Cuentas.xml";
                XML datosXml = new XML();
                if (datosXml.ValidarXml(archivoXml))
                //si el archivo ya existe agregar nodos hijos
                {
                    Document documento = datosXml.LeerXML(archivoXml);
                        
                    Element cuenta= documento.createElement("Cuenta");
                        
                    Element nodoNumCuenta = documento.createElement("NumeroCuenta");
                    nodoNumCuenta.appendChild(documento.createTextNode(numCuenta));
                    cuenta.appendChild(nodoNumCuenta);
                      
                    Element nodoTipoCuenta= documento.createElement("TipoCuenta");
                    nodoTipoCuenta.appendChild(documento.createTextNode(tipoCuenta));
                    cuenta.appendChild(nodoTipoCuenta);
                        
                    Element nodoPropietario = documento.createElement("Propietario");
                    nodoPropietario.appendChild(documento.createTextNode(Propietario));
                    cuenta.appendChild(nodoPropietario);
                        
                    NodeList cuentas= documento.getElementsByTagName("Cuentas");
                    cuentas.item(0).appendChild(cuenta);   
                    
                    datosXml.GuardarXml(archivoXml, documento);

                }
                else
                {
                    //si el archivoo xml no existe, crear nodos padres y nodos hijos
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document documento = builder.newDocument();
                    
                    Element cuentas =documento.createElement("Cuentas");
                    documento.appendChild(cuentas);
                    
                    Element cuenta = documento.createElement("Cuenta");
                    
                    Element nodoNumCuenta = documento.createElement("NumeroCuenta");
                    nodoNumCuenta.appendChild(documento.createTextNode(numCuenta));
                    cuenta.appendChild(nodoNumCuenta);
                      
                    Element nodoTipoCuenta= documento.createElement("TipoCuenta");
                    nodoTipoCuenta.appendChild(documento.createTextNode(tipoCuenta));
                    cuenta.appendChild(nodoTipoCuenta);
                        
                    Element nodoPropietario = documento.createElement("Propietario");
                    nodoPropietario.appendChild(documento.createTextNode(Propietario));
                    cuenta.appendChild(nodoPropietario);
                    
                    cuentas.appendChild(cuenta);
                    datosXml.GuardarXml(archivoXml, documento);
 
                }
            
            } catch(Exception e) 
            {
                e.printStackTrace();
            }
    }
    public DefaultTableModel leerCuentasXml()
    {
        try
        {
            XML iDatos = new XML();
            DefaultTableModel dTable= TablaCuentas();
            String fileXml = "Cuentas.xml";
            if (iDatos.ValidarXml(fileXml))
            {
                Document archivoXml = iDatos.LeerXML(fileXml);
                NodeList listaXml = archivoXml.getElementsByTagName(fileXml);
                for (int i = 0; i < listaXml.getLength(); i++) 
                {
                    Node nodo = listaXml.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) 
                    {
                        Element elemento = (Element) nodo;
                        String numCuenta = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();
                        String tipoCuenta = elemento.getElementsByTagName("TipoCuenta").item(0).getTextContent();
                        String propietario= elemento.getElementsByTagName("Propietario").item(0).getTextContent();
                        Object[] fila = {numCuenta, tipoCuenta, propietario};
                        dTable.addRow(fila);
                    }
                }
            }
            return dTable;
        }catch(Exception e)
        { 
            e.printStackTrace();
            return null;
        }   
    }
    
    public boolean validarDuplicadosCuentaXml(String numC, String tipoC, String Propietario) 
    {
        try 
        {
            XML iDatos = new XML();
            String fileXml = "Clientes.xml";
            // Revisar si el archivo XML existe
            if (iDatos.ValidarXml(fileXml)) {
                Document archivoXml = iDatos.LeerXML(fileXml);
                NodeList listaXml = archivoXml.getElementsByTagName(fileXml);
                for (int i = 0; i < listaXml.getLength(); i++) {
                    Node nodo = listaXml.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) nodo;
                        String numCuenta = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();
                        String tipoCuenta = elemento.getElementsByTagName("TipoCuenta").item(0).getTextContent();
                        String propietario = elemento.getElementsByTagName("Propietario").item(0).getTextContent();

                        if (numCuenta.equals(numC) ||
                            tipoCuenta.equals(tipoC) ||    
                            propietario.equals(Propietario)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
}   
    public DefaultTableModel TablaCuentas()
    {
        try {
            DefaultTableModel dTable = new DefaultTableModel();
            
            // Agregar columnas a la tabla
            dTable.addColumn("NumeroCuenta");
            dTable.addColumn("TipoCuenta");
            dTable.addColumn("Propietario");
            
            return dTable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public boolean buscarCuentaPorIdXml(String numC) {
        try {
            String archivoXml = "Cuenta.xml";
            XML datosXml = new XML();
            
            if (datosXml.ValidarXml(archivoXml)) {
                Document documento = datosXml.LeerXML(archivoXml);
                NodeList cuentas = documento.getElementsByTagName("Cuenta");
                
                for (int i = 0; i < cuentas.getLength(); i++) {
                    Node nodo = cuentas.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) nodo;
                        String nCuenta = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();
                        
                        if (nCuenta.equalsIgnoreCase(numC)) {
                            // El nombre de usuario existe en el XML
                            return true;
                        }
                    }
                }
            }
            
            // El nombre de usuario no se encontró en el XML
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        public void mostrarContenidoXml() {
    String archivoXml = "Cuentas.xml"; // Reemplaza con la ruta correcta de tu archivo XML
    XML xml= new XML();
    try {
        Document documento = xml.LeerXML(archivoXml);
        if (documento != null) {
            NodeList cuentas= documento.getElementsByTagName("Cuenta");
            
            for (int i = 0; i < cuentas.getLength(); i++) {
                Node nodo = cuentas.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String num = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();
                    String tipo = elemento.getElementsByTagName("TipoCuenta").item(0).getTextContent();
                    String propie = elemento.getElementsByTagName("Propietario").item(0).getTextContent();

                    System.out.println("Cuenta" + (i + 1) + ":");
                    System.out.println("NumeroCuenta: " + num);
                    System.out.println("TipoCuenta: " + tipo);
                    System.out.println("Propietario: " + propie);
                    System.out.println("-----------------------");
                }
            }
        } else {
            System.out.println("El archivo XML no pudo ser leído o no existe.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
        
    
    public boolean eliminarCuentaPorIdXml(String numC) {
    try {
        String archivoXml = "Cuentas.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList cuentas = documento.getElementsByTagName("Cuenta");

            for (int i = 0; i < cuentas.getLength(); i++) {
                Node nodo = cuentas.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String num = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();

                    if (num.equalsIgnoreCase(numC)) {
                        // Eliminar el nodo del usuario
                        nodo.getParentNode().removeChild(nodo);
                        datosXml.GuardarXml(archivoXml, documento);
                        return true;
                    }
                }
            }
        }
        return false; // No se encontró el usuario para eliminar
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    
}
    
  public boolean modificarCuentaXml(String numC, String tipoCuenta, String propietario) {
    try {
        String archivoXml = "Cuentas.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList cuentas = documento.getElementsByTagName("Cuenta");

            for (int i = 0; i < cuentas.getLength(); i++) {
                Node nodo = cuentas.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String num = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();

                    if (num.equalsIgnoreCase(numC)) {
                        // Modificar los datos del usuario
                        Element tipoElement = (Element) elemento.getElementsByTagName("TipoCuenta").item(0);
                       tipoElement.setTextContent(tipoCuenta);

                        Element propieElement = (Element) elemento.getElementsByTagName("Propietario").item(0);
                        propieElement.setTextContent(propietario);

                        datosXml.GuardarXml(archivoXml, documento);
                        return true;
                    }
                }
            }
        }
        return false; // No se encontró el usuario para modificar
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
  }
    
    
}
