/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.*;
import datos.XML;

public class Cliente {
    String identificacion;
    String nombre;
    String telefono;

    
//constructor
    
    public Cliente(String identificacion, String nombre, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;

    }
    
//propiedades getters
    public String getIdentificaicion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }


   //propiedades setters

    public void setIdentificaicion(String _identificaicion) {
        this.identificacion = _identificaicion;
    }

    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    public void setTelefono(String _telefono) {
        this.telefono = _telefono;
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
                    nodoIdentificacion.appendChild(documento.createTextNode(identificacion));
                    cliente.appendChild(nodoIdentificacion);
                      
                    Element nodoNombre = documento.createElement("Nombre");
                    nodoNombre.appendChild(documento.createTextNode(nombre));
                    cliente.appendChild(nodoNombre);
                        
                    Element nodoTelefono = documento.createElement("Telefono");
                    nodoTelefono.appendChild(documento.createTextNode(telefono));
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
                    nodoIdentificacion.appendChild(documento.createTextNode(identificacion));
                    cliente.appendChild(nodoIdentificacion);
                      
                    Element nodoNombre = documento.createElement("Nombre");
                    nodoNombre.appendChild(documento.createTextNode(nombre));
                    cliente.appendChild(nodoNombre);
                        
                    Element nodoTelefono = documento.createElement("Telefono");
                    nodoTelefono.appendChild(documento.createTextNode(telefono));
                    cliente.appendChild(nodoTelefono);
                    
                    clientes.appendChild(cliente);
                    datosXml.GuardarXml(archivoXml, documento);
 
                }
            
            } catch(Exception e) 
            {
                e.printStackTrace();
            }
    }
    
    
    
}
    
    
    

