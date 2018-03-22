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
    public  int runQuery(String Query,String id) throws SQLException {
        // TODO code application logic here
        
        Connection con = null;
        Statement state = null;
        ResultSet res =null;
        ResultSet res2 =null;
       String query="SELECT COUNT(PackageId) FROM BillPackage WHERE PackageId="+id;
       String query2="SELECT COUNT(PackageId) FROM Package WHERE PackageId="+id;;
     
        con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System","Supernova@135");
        state=con.createStatement();
        
      
          state.executeQuery(Query); 
       
        
        
           
//        while(res.next()){
//            int id=res.getInt("CustomerId");
//            String name=res.getString("CustomerName");
//            System.out.println("id :"+id+" name: "+name);     }
    return 1;
    }
    
}
