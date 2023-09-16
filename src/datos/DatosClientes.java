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
import datos.XML;
public class DatosClientes {
    public void agregarClientesXml(String identificacion, String nombre, String Telefono) 
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
                    nodoTelefono.appendChild(documento.createTextNode(Telefono));
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
                    nodoTelefono.appendChild(documento.createTextNode(Telefono));
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
            DefaultTableModel dTable= TablaClientes();
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
    
    public boolean validarDuplicadosClientes(String id, String nom, String tel) 
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

                        if (identificacion.equals(id) ||
                            nombre.equals(nom) ||    
                            telefono.equals(tel)) {
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
    public DefaultTableModel TablaClientes()
    {
        try {
            DefaultTableModel dTable = new DefaultTableModel();
            
            // Agregar columnas a la tabla
            dTable.addColumn("Identificacion");
            dTable.addColumn("Nombre");
            dTable.addColumn("Telefono");
            
            return dTable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public boolean buscarClientePorIdXml(String id) 
    {
        try {
            String archivoXml = "Clientes.xml";
            XML datosXml = new XML();
            
            if (datosXml.ValidarXml(archivoXml)) {
                Document documento = datosXml.LeerXML(archivoXml);
                NodeList clientes = documento.getElementsByTagName("Cliente");
                
                for (int i = 0; i < clientes.getLength(); i++) {
                    Node nodo = clientes.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) nodo;
                        String identificacion = elemento.getElementsByTagName("Identificacion").item(0).getTextContent();
                        
                        if (identificacion.equalsIgnoreCase(id)) {
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
    public void mostrarContenidoXml() 
    {
        try 
        {   String archivoXml = "Clientes.xml"; 
            XML xml= new XML();
            Document documento = xml.LeerXML(archivoXml);
            if (documento != null) 
            {
                NodeList clientes = documento.getElementsByTagName("Cliente");
            
                for (int i = 0; i < clientes.getLength(); i++) 
                {
                     Node nodo = clientes.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) 
                    {
                        Element elemento = (Element) nodo;
                        String identificacion = elemento.getElementsByTagName("Identificacion").item(0).getTextContent();
                        String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
                        String telefono = elemento.getElementsByTagName("Telefono").item(0).getTextContent();

                        System.out.println("Cliente " + (i + 1) + ":");
                        System.out.println("Identificación: " + identificacion);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Teléfono: " + telefono);
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
        
    
    public boolean eliminarClientePorIdXml(String id) {
    try {
        String archivoXml = "Clientes.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList clientes = documento.getElementsByTagName("Cliente");

            for (int i = 0; i < clientes.getLength(); i++) {
                Node nodo = clientes.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String ide = elemento.getElementsByTagName("Identificacion").item(0).getTextContent();

                    if (ide.equalsIgnoreCase(id)) {
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
    
  public boolean modificarClienteXml(String id, String nom, String tel) {
    try {
        String archivoXml = "Clientes.xml";
        XML datosXml = new XML();

            if (datosXml.ValidarXml(archivoXml)) 
            {
                Document documento = datosXml.LeerXML(archivoXml);
                NodeList clientes = documento.getElementsByTagName("Cliente");

                for (int i = 0; i < clientes.getLength(); i++) 
                {
                    Node nodo = clientes.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) 
                    {
                        Element elemento = (Element) nodo;
                        String ide = elemento.getElementsByTagName("Identificacion").item(0).getTextContent();

                        if (ide.equalsIgnoreCase(id)) 
                        {
                            // Modificar los datos del usuario
                            Element nombreElement = (Element) elemento.getElementsByTagName("Nombre").item(0);
                           nombreElement.setTextContent(nom);

                            Element telefonoElement = (Element) elemento.getElementsByTagName("Telefono").item(0);
                            telefonoElement.setTextContent(tel);

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
