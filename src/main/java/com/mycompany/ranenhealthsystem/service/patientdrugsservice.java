/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem.service;

import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class patientdrugsservice {
    
    
     
     public boolean authenticateUser(String drugcode){        
        
    boolean authenticated = false;
            
    try{
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
            StringBuilder sb = new StringBuilder();
             sb.append("select drugcode from rhc.drugrecordstable where UPPER(drugcode)=").append("'")
                     .append(drugcode).append("'"); 
             
             //System.out.println(sb.toString());
            
            ResultSet rs = st.executeQuery(sb.toString());
           
            if (rs.next())
                
            {
                String validdrugcode = rs.getString("drugcode");
                             
                                    
                    if (validdrugcode.equals(drugcode)){
                        //out.println("login successful");
                        System.out.println("Drug Found"); 
                        authenticated = true;
                    }   
                        
                        con.close();
            }}catch(Exception ex){   
            Logger.getLogger(RegistrationService.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    return authenticated;
            }
    
}
