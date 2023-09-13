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
 
    public void agregarTransaccionXml(String numTransaccion, String tipoTransaccion, String numCuenta, Double monto) 
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
                    
                    transacciones.appendChild(transaccion);
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
    
}
