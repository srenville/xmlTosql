/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltosql;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Toozigba
 */
public class DomParser {
    
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here
        DocumentBuilderFactory doucmentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder DocumentBuilder =doucmentBuilderFactory.newDocumentBuilder();
        Document doc =DocumentBuilder.parse("q3.xml");
        NodeList list =doc.getElementsByTagName("Package");
        int i;
        for(i=0; i<list.getLength();i++)
        {
            Node p= list.item(i);
            if(list.item(i).getNodeType()==Node.ELEMENT_NODE)
            {
                Element Package=(Element) p;
                String id =Package.getAttribute("PackageId");
              
                NodeList PackageChildren=Package.getChildNodes();
                int j;
                for(j=0;j<PackageChildren.getLength();j++)
                {
                   Node pc= PackageChildren.item(j);
                   if(PackageChildren.item(j).getNodeType()==Node.ELEMENT_NODE)
                   { 
                       Element PackageChil=(Element) pc;
                
                        System.out.println("Id ="+id+": "+PackageChil.getTagName()+"->"+PackageChil.getTextContent());
                   }
                }
            }
            
        }
    }
    
}
