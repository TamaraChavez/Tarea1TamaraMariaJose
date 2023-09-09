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
                        String numCuenta = elemento.getElementsByTagName("Numero de cuenta").item(0).getTextContent();
                        String tipoCuenta = elemento.getElementsByTagName("Tipo de Cuenta").item(0).getTextContent();
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
                        String numCuenta = elemento.getElementsByTagName("Numero de Cuenta").item(0).getTextContent();
                        String tipoCuenta = elemento.getElementsByTagName("Tipo de Cuenta").item(0).getTextContent();
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
            dTable.addColumn("Numero de Cuenta");
            dTable.addColumn("Tipo de Cuenta");
            dTable.addColumn("Propietario");
            
            return dTable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
