
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
             transformer.transform(source, result);
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
             if (archivo.exists())
             {
              System.out.println("éxito");
             return true;
             }else{
                 System.out.println("Se acaba de crear el archivo");
                 return false;
                 }
         }catch (Exception ex)
         {
             ex.printStackTrace();
             return false;
         }
    }
    

    
}
