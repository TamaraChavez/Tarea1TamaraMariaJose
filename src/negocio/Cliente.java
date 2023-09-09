/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.*;
import datos.XML;

public class Cliente {
    String _identificacion;
    String _nombre;
    String _telefono;

    
//constructor
    
    public Cliente(String _identificacion, String _nombre, String _telefono) {
        this._identificacion = _identificacion;
        this._nombre = _nombre;
        this._telefono = _telefono;

    }
    
//propiedades getters
    public String getIdentificaicion() {
        return _identificacion;
    }

    public String getNombre() {
        return _nombre;
    }

    public String getTelefono() {
        return _telefono;
    }


   //propiedades setters

    public void setIdentificaicion(String _identificaicion) {
        this._identificacion = _identificaicion;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }


    public void agregarClientes() 
    {
        try {
                String archivoXml = "Clientes.xml";
                XML datosXml = new XML();
                if (datosXml.ValidarXml(archivoXml))
                //si el archivo ya existe agregar nodos hijos
                {
                    Document documento = datosXml.LeerXML(archivoXml);
                        
                    Element cliente= documento.createElement("Cliente");
                        
                    Element nodoIdentificacion = documento.createElement("Identificacion");
                    nodoIdentificacion.appendChild(documento.createTextNode(_identificacion));
                    cliente.appendChild(nodoIdentificacion);
                      
                    Element nodoNombre = documento.createElement("Nombre");
                    nodoNombre.appendChild(documento.createTextNode(_nombre));
                    cliente.appendChild(nodoNombre);
                        
                    Element nodoTelefono = documento.createElement("Telefono");
                    nodoTelefono.appendChild(documento.createTextNode(_telefono));
                    cliente.appendChild(nodoTelefono);
                        
                    NodeList clientes = documento.getElementsByTagName("Clientes");
                    clientes.item(0).appendChild(cliente);   
                    
                    datosXml.GuardarXml(archivoXml, documento);

                }
                else
                {
                    //si el archivoo xml no existe, crear nodos padres y nodos hijos
                    DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document documento = builder.newDocument();
                    
                    Element clientes =documento.createElement("Clientes");
                    documento.appendChild(clientes);
                    
                    Element cliente = documento.createElement("Cliente");
                    
                    Element nodoIdentificacion = documento.createElement("Identificacion");
                    nodoIdentificacion.appendChild(documento.createTextNode(_identificacion));
                    cliente.appendChild(nodoIdentificacion);
                      
                    Element nodoNombre = documento.createElement("Nombre");
                    nodoNombre.appendChild(documento.createTextNode(_nombre));
                    cliente.appendChild(nodoNombre);
                        
                    Element nodoTelefono = documento.createElement("Telefono");
                    nodoTelefono.appendChild(documento.createTextNode(_telefono));
                    cliente.appendChild(nodoTelefono);
                    
                    clientes.appendChild(cliente);
                    datosXml.GuardarXml(archivoXml, documento);
 
                }
            
            } catch(Exception e) 
            {
                e.printStackTrace();
            }
    }
    
    public DefaultTableModel leerClientesXml()
    {
        try
        {
            XML iDatos = new XML();
            DefaultTableModel dTable= iDatos.TablaClientes();
            String fileXml = "Clientes.xml";
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
                        String identificacion = elemento.getElementsByTagName("Identificacion").item(0).getTextContent();
                        String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
                        String telefono= elemento.getElementsByTagName("Telefono").item(0).getTextContent();
                        Object[] fila = {identificacion, nombre, telefono};
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
    
    public boolean validarDuplicadosClientes() 
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
                        String identificacion = elemento.getElementsByTagName("Identificacion").item(0).getTextContent();
                        String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
                        String telefono = elemento.getElementsByTagName("Telefono").item(0).getTextContent();

                        if (identificacion.equals(getIdentificaicion()) ||
                            nombre.equals(getNombre()) ||    
                            telefono.equals(getTelefono())) {
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
    
    
    
}
    
    
    

