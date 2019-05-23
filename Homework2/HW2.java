import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import java.util.*;
import java.io.*;

public class DOM4JTest {
    public static void main(String[] args) throws DocumentException
    {
       
        SAXReader reader = new SAXReader();
        try
        {
            Document document = reader.read(new File("books.xml")); 
            Element books = document.getRootElement(); 
            Iterator it = books.elementIterator(); 
            while (it.hasNext()) 
            { 
                Element book = (Element) it.next(); 
                for (Element e:book.elements()) 
                {
                    System.out.println("属性名： " + e.getName() + "--属性值： " + e.getText());
            
                }
                
            Iterator itt = book.elementIterator();
            while (itt.hasNext()) 
            {
                Element bookChild = (Element) itt.next();
                System.out.println("节点名： " + bookChild.getName() + "--节点值： " + bookChild.getStringValue());
            }
            }
        } 
        catch(DocumentException e) 
        {
            e.printStackTrace();
        }
    }
}
