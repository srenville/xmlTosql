/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltosql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author Toozigba
 */
public class SqlConnect {
    public  int runQuery(String Query) throws SQLException {
        // TODO code application logic here
        
        Connection con = null;
        Statement state = null;
        ResultSet res =null;
//        String query="INSERT INTO BillPackage(BillId,PackageId,BillDate) VALUES ('705','1',TO_DATE('31/01/2018', 'DD/MM/YYYY'))";
//        String query2="INSERT INTO Package(PackageId,PackageType,PackageCost,AdditionalCharge) VALUES ('1','5GB one plan','199.00','55.00')";
     
        con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System","Supernova@135");
        state=con.createStatement();
        
        state.executeQuery(Query);
       
        
       // res=state.executeQuery("Select*From CUSTOMER");
           
//        while(res.next()){
//            int id=res.getInt("CustomerId");
//            String name=res.getString("CustomerName");
//            System.out.println("id :"+id+" name: "+name);     }
    return 1;
    }
    
}
