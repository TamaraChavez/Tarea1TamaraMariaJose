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

public class DatosTransaccion {
 
    public void agregarTransaccionXml(String numTransaccion, String tipoTransaccion, String numCuenta, String saldo) 
    {
        try {
                String archivoXml = "Transacciones.xml";
                XML datosXml = new XML();
                if (datosXml.ValidarXml(archivoXml))
                //si el archivo ya existe agregar nodos hijos
                {
                    Document documento = datosXml.LeerXML(archivoXml);
                        
                    Element transaccion= documento.createElement("Transaccion");
                        
                    Element nodoNumTransaccion = documento.createElement("NumeroTransaccion");
                    nodoNumTransaccion.appendChild(documento.createTextNode(numTransaccion));
                    transaccion.appendChild(nodoNumTransaccion);
                      
                    Element nodoTipoTransaccion= documento.createElement("TipoTransaccion");
                    nodoTipoTransaccion.appendChild(documento.createTextNode(tipoTransaccion));
                    transaccion.appendChild(nodoTipoTransaccion);
                        
                    Element nodoNumCuenta = documento.createElement("NumeroCuenta");
                    nodoNumCuenta.appendChild(documento.createTextNode(numCuenta));
                    transaccion.appendChild(nodoNumCuenta);
                        
                     Element nodoMonto = documento.createElement("Saldo");
                    nodoMonto.appendChild(documento.createTextNode(saldo));
                    transaccion.appendChild(nodoMonto);
                    
                    NodeList cuentas= documento.getElementsByTagName("Cuentas");
                    cuentas.item(0).appendChild(transaccion);   
                    
                    datosXml.GuardarXml(archivoXml, documento);

                }
                else
                {
                    //si el archivoo xml no existe, crear nodos padres y nodos hijos
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document documento = builder.newDocument();
                    
                    Element transacciones =documento.createElement("Transacciones");
                    documento.appendChild(transacciones);
                    
                    Element transaccion = documento.createElement("Transaccion");
                    
                    Element nodoNumTransaccion = documento.createElement("NumeroTransaccion");
                    nodoNumTransaccion.appendChild(documento.createTextNode(numTransaccion));
                    transaccion.appendChild(nodoNumTransaccion);
                      
                    Element nodoTipoTransaccion= documento.createElement("TipoTransaccion");
                    nodoTipoTransaccion.appendChild(documento.createTextNode(tipoTransaccion));
                    transaccion.appendChild(nodoTipoTransaccion);
                        
                    Element nodoNumCuenta = documento.createElement("NumeroCuenta");
                    nodoNumCuenta.appendChild(documento.createTextNode(numCuenta));
                    transaccion.appendChild(nodoNumCuenta);
                    
                    Element nodoMonto = documento.createElement("Saldo");
                    nodoMonto.appendChild(documento.createTextNode(saldo));
                    transaccion.appendChild(nodoMonto);
                    
                    transacciones.appendChild(transaccion);
                    datosXml.GuardarXml(archivoXml, documento);
 
                }
            
            } catch(Exception e) 
            {
                e.printStackTrace();
            }
    }
    public DefaultTableModel leerTransaccionesXml()
    {
        try
        {
            XML iDatos = new XML();
            DefaultTableModel dTable= TablaCuentas();
            String fileXml = "Transacciones.xml";
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
                        String numTransaccion = elemento.getElementsByTagName("NumeroTransaccion").item(0).getTextContent();
                        String tipoTransaccion = elemento.getElementsByTagName("TipoTransaccion").item(0).getTextContent();
                        String numCuenta= elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();
                        String monto= elemento.getElementsByTagName("Saldo").item(0).getTextContent();
                        Object[] fila = {numTransaccion, tipoTransaccion, numCuenta, monto };
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
    
    public boolean validarDuplicadosTransaccionesXml(String numTransaccion, String tipoTransaccion, String numCuenta, String saldo) 
    {
        try 
        {
            XML iDatos = new XML();
            String fileXml = "Transacciones.xml";
            // Revisar si el archivo XML existe
            if (iDatos.ValidarXml(fileXml)) {
                Document archivoXml = iDatos.LeerXML(fileXml);
                NodeList listaXml = archivoXml.getElementsByTagName(fileXml);
                for (int i = 0; i < listaXml.getLength(); i++) {
                    Node nodo = listaXml.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) nodo;
                        String num = elemento.getElementsByTagName("NumeroTrnsaccion").item(0).getTextContent();
                        String tipo = elemento.getElementsByTagName("TipoTransaccion").item(0).getTextContent();
                        String numC = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();
                        String mont = elemento.getElementsByTagName("Saldo").item(0).getTextContent();
                        if (num.equals(numTransaccion) ||
                            tipo.equals(tipoTransaccion) ||   
                            numC.equals(numCuenta) || 
                           mont.equals(saldo)) {
                            
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
            dTable.addColumn("NumeroTransaccion");
            dTable.addColumn("TipoTransaccion");
            dTable.addColumn("NumeroCuenta");
            dTable.addColumn("Saldo");
            return dTable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    public boolean buscarTransaccionPorIdXml(String numT) {
        try {
            String archivoXml = "Transacciones.xml";
            XML datosXml = new XML();
            
            if (datosXml.ValidarXml(archivoXml)) {
                Document documento = datosXml.LeerXML(archivoXml);
                NodeList transacciones = documento.getElementsByTagName("Transaccion");
                
                for (int i = 0; i < transacciones.getLength(); i++) {
                    Node nodo = transacciones.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) nodo;
                        String nTransaccion = elemento.getElementsByTagName("NumeroTransaccion").item(0).getTextContent();
                        
                        if (nTransaccion.equalsIgnoreCase(numT)) {
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
    String archivoXml = "Transacciones.xml"; 
    XML xml= new XML();
    try {
        Document documento = xml.LeerXML(archivoXml);
        if (documento != null) {
            NodeList transacciones= documento.getElementsByTagName("Transaccion");
            
            for (int i = 0; i < transacciones.getLength(); i++) {
                Node nodo = transacciones.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String num = elemento.getElementsByTagName("NumeroTrnsaccion").item(0).getTextContent();
                    String tipo = elemento.getElementsByTagName("TipoTransaccion").item(0).getTextContent();
                    String numC = elemento.getElementsByTagName("NumeroCuenta").item(0).getTextContent();
                    String mont = elemento.getElementsByTagName("Saldo").item(0).getTextContent();
                    System.out.println("Transaccion" + (i + 1) + ":");
                    System.out.println("NumeroTransaccion: " + num);
                    System.out.println("TipoTransaccion: " + tipo);
                    System.out.println("NumCuenta: " + numC);
                    System.out.println("Saldo: " + mont);
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
    public boolean eliminarTransaccionPorIdXml(String numTr) {
    try {
        String archivoXml = "Transacciones.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList transacciones = documento.getElementsByTagName("Transaccion");

            for (int i = 0; i < transacciones.getLength(); i++) {
                Node nodo = transacciones.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String numT = elemento.getElementsByTagName("NumeroTransaccion").item(0).getTextContent();

                    if (numT.equalsIgnoreCase(numTr)) {
                        // Eliminar el nodo de la transacciones
                        nodo.getParentNode().removeChild(nodo);
                        datosXml.GuardarXml(archivoXml, documento);
                        return true;
                    }
                }
            }
        }
        return false; // No se encontró la transaccion para eliminar
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    
}
      public boolean modificarTransaccionXml(String numTransaccion, String tipoTransaccion, String numCuenta, String saldo) {
    try {
        String archivoXml = "Transacciones.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList transacciones = documento.getElementsByTagName("Transaccion");

            for (int i = 0; i < transacciones.getLength(); i++) {
                Node nodo = transacciones.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String num = elemento.getElementsByTagName("NumeroTransaccion").item(0).getTextContent();

                    if (num.equalsIgnoreCase(numTransaccion)) {
                        // Modificar los datos de la transaccion
                        Element tipoElement = (Element) elemento.getElementsByTagName("TipoTransaccion").item(0);
                       tipoElement.setTextContent(tipoTransaccion);

                        Element numCElement = (Element) elemento.getElementsByTagName("NumeroCuenta").item(0);
                        numCElement.setTextContent(numCuenta);
                        
                        Element montoElement = (Element) elemento.getElementsByTagName("Saldo").item(0);
                        montoElement.setTextContent(saldo);
                        datosXml.GuardarXml(archivoXml, documento);
                        return true;
                    }
                }
            }
        }
        return false; // No se encontró la transaccion para modificar
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
  }
    

    public boolean actualizarSaldo(String numeroTransaccion, String nuevoSaldo) {
        try {
            XML datosXml = new XML();
            String archivoXml = "Transacciones.xml";
            if (datosXml.ValidarXml(archivoXml)) {
                Document documento = datosXml.LeerXML(archivoXml);
                NodeList cuentas = documento.getElementsByTagName("Transaccion");

                for (int i = 0; i < cuentas.getLength(); i++) {
                    Node nodo = cuentas.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) nodo;
                        String numero = elemento.getElementsByTagName("NumeroTransaccion").item(0).getTextContent();

                        if (numero.equals(numeroTransaccion)) {
                            // Encontramos la transaccion de la cuenta
                            Element saldoElement = (Element) elemento.getElementsByTagName("Saldo").item(0);
                            saldoElement.setTextContent(nuevoSaldo);

                            datosXml.GuardarXml(archivoXml, documento);
                            return true; 
                        }
                    }
                }
            }
            return false; 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

      
}
