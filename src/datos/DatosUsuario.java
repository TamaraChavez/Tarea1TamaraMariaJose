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
public class DatosUsuario {
    
    public void AgregarUsuariosXml(String nomUsuario, String tipoUsuario, String contrasena)
    {
      
        try
        {
            
            String archivoXml = "Usuarios.xml";
                XML datosXml = new XML();
                if (datosXml.ValidarXml(archivoXml))
                //si el archivo ya existe agregar nodos hijos
                {
                    Document documento = datosXml.LeerXML(archivoXml);
                        
                    Element usuario= documento.createElement("Usuario");
                        
                    Element nodoNomUsuario = documento.createElement("NombreUsuario");
                    nodoNomUsuario.appendChild(documento.createTextNode(nomUsuario));
                    usuario.appendChild(nodoNomUsuario);
                      
                    Element nodoTipoUsuario= documento.createElement("TipoUsuario");
                    nodoTipoUsuario.appendChild(documento.createTextNode(tipoUsuario));
                    usuario.appendChild(nodoTipoUsuario);
                        
                    Element nodoContrasena = documento.createElement("Contraseña");
                    nodoContrasena.appendChild(documento.createTextNode(contrasena));
                   usuario.appendChild(nodoContrasena);
                        
                    NodeList usuarios= documento.getElementsByTagName("Usuarios");
                    usuarios.item(0).appendChild(usuario);   
                    
                    datosXml.GuardarXml(archivoXml, documento);

                }
                else
                {
                    //si el archivoo xml no existe, crear nodos padres y nodos hijos
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document documento = builder.newDocument();
                    
                    Element usuarios =documento.createElement("Usuarios");
                    documento.appendChild(usuarios);
                    
                    Element usuario= documento.createElement("Usuario");
                    
                    Element nodoNomUsuario = documento.createElement("NombreUsuario");
                    nodoNomUsuario.appendChild(documento.createTextNode(nomUsuario));
                    usuario.appendChild(nodoNomUsuario);
                    
                    Element nodoTipoUsuario = documento.createElement("TipoUsuario");
                    nodoTipoUsuario.appendChild(documento.createTextNode(tipoUsuario));
                    usuario.appendChild(nodoTipoUsuario);
                      
                    
                    Element nodoContrasena= documento.createElement("Contraseña");
                    nodoContrasena.appendChild(documento.createTextNode(contrasena));
                    usuario.appendChild(nodoContrasena);
            
                    usuarios.appendChild(usuario);
                    datosXml.GuardarXml(archivoXml, documento);
 
                }
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
  public DefaultTableModel leerUsuariosXml()
    {
        try
        {
            XML iDatos = new XML();
            DefaultTableModel dTable= TablaUsuarios();
            String fileXml = "Usuarios.xml";
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
                        String nomUsuario = elemento.getElementsByTagName("NombreUsuario").item(0).getTextContent();
                        String tipoUsuario= elemento.getElementsByTagName("TipoUsuario").item(0).getTextContent();
                        String contrasena= elemento.getElementsByTagName("Contraseña").item(0).getTextContent();
                        Object[] fila = {nomUsuario, tipoUsuario, contrasena};
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
    
    public boolean validarDuplicadosUsuariosXml(String nomUsuario, String tipoUsuario, String contrasena) 
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
                        String noUsuario = elemento.getElementsByTagName("NombreUsuario").item(0).getTextContent();
                        String tipUsuario = elemento.getElementsByTagName("TipoUsuario").item(0).getTextContent();
                        String contra= elemento.getElementsByTagName("Contraseña").item(0).getTextContent();

                        if (noUsuario.equals(nomUsuario) ||
                            tipUsuario.equals(tipoUsuario) ||    
                            contra.equals(contrasena)) {
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
    public DefaultTableModel TablaUsuarios()
    {
        try {
            DefaultTableModel dTable = new DefaultTableModel();
            
            // Agregar columnas a la tabla
            dTable.addColumn("NombreUsuario");
            dTable.addColumn("TipoUsuario");
            dTable.addColumn("Contraseña");
            
            return dTable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
          
        
    }  
    
    
         public boolean buscarUsuariosPorNombreXml(String nombre) {
        try {
            String archivoXml = "Usuarios.xml";
            XML datosXml = new XML();
            
            if (datosXml.ValidarXml(archivoXml)) {
                Document documento = datosXml.LeerXML(archivoXml);
                NodeList usuarios = documento.getElementsByTagName("Usuario");
                
                for (int i = 0; i < usuarios.getLength(); i++) {
                    Node nodo = usuarios.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element elemento = (Element) nodo;
                        String nombr = elemento.getElementsByTagName("NombreUsuario").item(0).getTextContent();
                        
                        if (nombr.equalsIgnoreCase(nombre)) {
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
    String archivoXml = "Usuarios.xml"; // Reemplaza con la ruta correcta de tu archivo XML
    XML xml= new XML();
    try {
        Document documento = xml.LeerXML(archivoXml);
        if (documento != null) {
            NodeList usuarios= documento.getElementsByTagName("Usuario");
            
            for (int i = 0; i < usuarios.getLength(); i++) {
                Node nodo = usuarios.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nom = elemento.getElementsByTagName("NombreUsuario").item(0).getTextContent();
                    String tipo = elemento.getElementsByTagName("TipoUsuario").item(0).getTextContent();
                    String contrasena = elemento.getElementsByTagName("Contraseña").item(0).getTextContent();

                    System.out.println("Usuario" + (i + 1) + ":");
                    System.out.println("NombreUsuario: " + nom);
                    System.out.println("TipoUsuario: " + tipo);
                    System.out.println("Contraseña: " + contrasena);
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
        
    
    public boolean eliminarUsuarioPorNombreXml(String nombre) {
    try {
        String archivoXml = "Usuarios.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList usuarios = documento.getElementsByTagName("Usuario");

            for (int i = 0; i < usuarios.getLength(); i++) {
                Node nodo = usuarios.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nom = elemento.getElementsByTagName("NombreUsuario").item(0).getTextContent();

                    if (nom.equalsIgnoreCase(nombre)) {
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
    
  public boolean modificarUsuarioXml(String nomUsuario, String tipoUsuario, String contrasena) {
    try {
        String archivoXml = "Usuarios.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList usuarios = documento.getElementsByTagName("Usuario");

            for (int i = 0; i < usuarios.getLength(); i++) {
                Node nodo = usuarios.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nom = elemento.getElementsByTagName("NombreUsuario").item(0).getTextContent();

                    if (nom.equalsIgnoreCase(nomUsuario)) {
                        // Modificar los datos del usuario
                        Element tipoElement = (Element) elemento.getElementsByTagName("TipoUsuario").item(0);
                       tipoElement.setTextContent(tipoUsuario);

                        Element contElement = (Element) elemento.getElementsByTagName("Contraseña").item(0);
                        contElement.setTextContent(contrasena);

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
    public boolean iniciarSesion(String nomUsuario, String contrasena) {
    try {
        String archivoXml = "Usuarios.xml";
        XML datosXml = new XML();

        if (datosXml.ValidarXml(archivoXml)) {
            Document documento = datosXml.LeerXML(archivoXml);
            NodeList usuarios = documento.getElementsByTagName("Usuario");

            for (int i = 0; i < usuarios.getLength(); i++) {
                Node nodo = usuarios.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nombreUsuario = elemento.getElementsByTagName("NombreUsuario").item(0).getTextContent();
                    String contra = elemento.getElementsByTagName("Contraseña").item(0).getTextContent();

                    if (nombreUsuario.equalsIgnoreCase(nomUsuario) && contra.equals(contrasena)) {
                        // Las credenciales son válidas
                        return true;
                    }
                }
            }
        }
        return false; // Las credenciales no son válidas
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }
}
