/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltosql;

import java.io.IOException;
import java.sql.SQLException;
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
    
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException {
        // TODO code application logic here
        SqlConnect sqlCon = new SqlConnect();
        int custId=705;
        String PackageType=null;
        String PackageCost=null;
        String addCost=null;
        
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
                String query="INSERT INTO BillPackage(BillId,PackageId,BillDate) VALUES ('"+custId+"','"+id+"',TO_DATE('31/01/2018', 'DD/MM/YYYY'))";
               try{ 
                sqlCon.runQuery(query,id);
               }
               catch (Exception e){
                   System.out.println("Duplicated Entry");
               }
                NodeList PackageChildren=Package.getChildNodes();
                int j;
                
                int k=0;
                
                for(j=0;j<PackageChildren.getLength();j++)
                {
                   
                   Node pc= PackageChildren.item(j);
                   if(PackageChildren.item(j).getNodeType()==Node.ELEMENT_NODE)
                   { 
                       Element PackageChil=(Element) pc;
                       if(k==0)PackageType=PackageChil.getTextContent();
                       if(k==1)PackageCost=PackageChil.getTextContent();
                       if(k==2)addCost=PackageChil.getTextContent();
                       k++;
                        System.out.println("j="+j+" Id ="+id+": "+PackageChil.getTagName()+"->"+PackageChil.getTextContent());
                   }
                }
                
               String query2="INSERT INTO Package(PackageId,PackageType,PackageCost,AdditionalCharge) VALUES ('"+id+"','"+PackageType+"','"+PackageCost+"','"+addCost+"')"; 
               try{
               sqlCon.runQuery(query2,id); 
               }
               catch(Exception e){
                 System.out.println("Duplicated Entry");  
               }
            }
            
        PackageType=null;
        PackageCost=null;
        addCost=null;
        
            
        }
    }
    
}
//String query="INSERT INTO BillPackage(BillId,PackageId,BillDate) VALUES ('705','1',TO_DATE('31/01/2018', 'DD/MM/YYYY'))";
//        String query2="INSERT INTO Package(PackageId,PackageType,PackageCost,AdditionalCharge) VALUES ('1','5GB one plan','199.00','55.00')";
