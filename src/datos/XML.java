
package datos;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import javax.swing.table.DefaultTableModel;


//leer documento xml
public class XML {
    public Document LeerXML(String strRuta)
    {
        try
        {
            DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File(strRuta));
          return documento; 
        }catch (Exception ex)
        {
            return null; 
        }      
    }
    
    //guardar documento xml
    public void GuardarXml(String strRuta, Document documento)
    {
         try
         {
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
             Transformer transformer = transformerFactory.newTransformer();
             DOMSource source = new DOMSource(documento);
             StreamResult result= new StreamResult(new File(strRuta));
             
         }catch(Exception ex)
         {
           ex.printStackTrace(); 
         }
    }
    
    //validar si existe el xml
    public boolean ValidarXml(String strRuta)        
    {
         try
         {
             File archivo = new File(strRuta);
             return archivo.exists();
         }catch (Exception ex)
         {
             ex.printStackTrace();
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
    
}
