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
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Connection con = null;
        Statement state = null;
        ResultSet res =null;
     
        con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System","Supernova@135");
        state=con.createStatement();
        res=state.executeQuery("Select*From CUSTOMER");
           
        while(res.next()){
            int id=res.getInt("CustomerId");
            String name=res.getString("CustomerName");
            System.out.println("id :"+id+" name: "+name);
        }
    }
}
