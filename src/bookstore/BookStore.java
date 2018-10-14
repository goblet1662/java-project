/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
import java.sql.*;  
import javafx.scene.control.ProgressBar;
/**
 *
 * @author user
 */
public class BookStore {

 

public static void main(String args[]){  



 
Log login=new Log();
login.setVisible(true);
System.out.println("hii");
}  
public  Connection Database_connection(){
Connection con=null;    
try{  
   
Class.forName("com.mysql.jdbc.Driver");  
 con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/","root","root123");  
//here  root is username and root123 is password  



}catch(Exception e){ System.out.println(e);}
return con;
}  
}  
 
    

