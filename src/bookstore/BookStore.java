/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
import java.sql.*;  
/**
 *
 * @author user
 */
public class BookStore {

 

public static void main(String args[]){  
/*try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/","root","root123");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("show databases");  
while(rs.next())  
System.out.println(rs.getString(1));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
*/
Log login=new Log();
login.setVisible(true);
System.out.println("hii");
}  
}  
 
    

