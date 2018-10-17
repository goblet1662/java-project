/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author user
 */
public class SessionManager {
  


   
    public static String User_ID = "userid";
  

   
      public void setUser(String b)
    {
        User_ID=b;
    }
public void createLoginSession(String userid){
        // Storing login value as TRUE
        setUser(userid);       
}
public String getUser()
{
return User_ID;
}
}
