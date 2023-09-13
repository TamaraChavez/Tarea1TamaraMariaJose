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
    
    public void AgregarUsuariosXml(String nomUsuario, String tipoUsuario, String contraseña)
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
                    nodoContrasena.appendChild(documento.createTextNode(contraseña));
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
                    nodoContrasena.appendChild(documento.createTextNode(contraseña));
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
                        String contraseña= elemento.getElementsByTagName("Contraseña").item(0).getTextContent();
                        Object[] fila = {nomUsuario, tipoUsuario, contraseña};
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
    
    public boolean validarDuplicadosUsuariosXml(String nomUsuario, String tipoUsuario, String contraseña) 
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
                        String noUsuario = elemento.getElementsByTagName("NombreUsuarios").item(0).getTextContent();
                        String tipUsuario = elemento.getElementsByTagName("TipoUsuario").item(0).getTextContent();
                        String contrasena = elemento.getElementsByTagName("Cotraseña").item(0).getTextContent();

                        if (noUsuario.equals(nomUsuario) ||
                            tipUsuario.equals(tipoUsuario) ||    
                            contrasena.equals(contraseña)) {
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
}
