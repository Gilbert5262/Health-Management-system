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
public class labtestcheckservice {
    
     public boolean authenticateUser(String labtestid){        
        
    boolean authenticated = false;
            
    try{
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
            StringBuilder sb = new StringBuilder();
             sb.append("select testid from rhc.labtesttypes where UPPER(testid)=").append("'")
                     .append(labtestid).append("'"); 
             
             //System.out.println(sb.toString());
            
            ResultSet rs = st.executeQuery(sb.toString());
           
            if (rs.next())
                
            {
                String validlabtestid = rs.getString("testid");
                             
                                    
                    if (validlabtestid.equals(labtestid)){
                        //out.println("login successful");
                        System.out.println("Lab Test Type Found"); 
                        authenticated = true;
                    }   
                        
                        con.close();
            }}catch(Exception ex){   
            Logger.getLogger(RegistrationService.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    return authenticated;
            }
    
}
