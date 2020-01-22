/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;

import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import com.mycompany.ranenhealthsystem.service.DatabaseConnection;
import com.mycompany.ranenhealthsystem.service.labtestcheckservice;
import com.mycompany.ranenhealthsystem.service.opdcheckservice;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class patientexamination extends HttpServlet {
    String query;
    Connection conn;
    Statement stmt;
    ResultSet res;
    DatabaseConnection dbconn;
     opdcheckservice opdcheckservice = new opdcheckservice();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
      
            
    
             
            
    //1. Check OPD Number and return patient details        
            
if (request.getParameter("validate") !=null)
    {
               
        String OPDNO = request.getParameter("opdno");
                boolean authenticated = opdcheckservice.authenticateUser(OPDNO);
            
            
                if((authenticated)) 
                    
                                  {
                       
                                      
 try {
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql1 = "select * from rhc.patientinformation, rhc.patientsymptoms, rhc.vitalrecords where rhc.patientinformation.OPDNo = rhc.vitalrecords.OPDNo AND rhc.patientsymptoms.OPDNo AND rhc.patientinformation.OPDNo = '"+OPDNO+"'";
        
             ResultSet rs = st.executeQuery(sql1);
     if (rs.next()) {
                 int OPD = rs.getInt("OPDNo");
                 
                 
                 String FName = rs.getString("FirstName");
                  //if (FName == null || (FName = htmlFilter(FName.trim())).length() == 0)
                 //{
                 //out.println("<p>Name: MISSING</p>");
                 //}
                 String MName = rs.getString("MiddleName");
                 String LName = rs.getString("LastName");
                 int Age = rs.getInt("Age");
                 String Sex = rs.getString("Sex");
                 int mobile = rs.getInt("MobileNo"); 
                int weight = rs.getInt("Weight");
                int bloodpressure = rs.getInt("Bloodpressure");
                String symptoms = rs.getString("symptoms");
                 
                if ("".equals(OPD))
                {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Some Items are still black. Kindly Go Back to registration desk');");
                        out.println("location='patient_examination.jsp';");
                        out.println("</script>");    
                }
                else
                {     
                  request.getSession().setAttribute("firstname", FName);
                 request.getSession().setAttribute("opdno", OPD);
                 request.getSession().setAttribute("middlename", MName);
                 request.getSession().setAttribute("lastname", LName);
                 request.getSession().setAttribute("age", Age);
                request.getSession().setAttribute("sex", Sex);
                request.getSession().setAttribute("mobile", mobile);
                request.getSession().setAttribute("weight", weight);
                request.getSession().setAttribute("bloodpressure", bloodpressure);
                request.getSession().setAttribute("symptoms", symptoms);
                
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                
                }
                // out.println("<tr><td>" + OPD + "</td><td>" + FName + "</td><td>" + MName + "</td><td>" + LName + "</td><td>" + Age + "</td><td>" + Sex + "</td><td>" + mobile + "</td><td><p><a href='VitalsRecord.jsp'>Record Vitals</a></P></td></tr>");
               // out.println("<tr><td><button style= "width: 100px; height: 35px;" name="Exit" type="button" onclick= "loadDoc();"> Exit </button></td></tr>");
                                               }
             //out.println("</table>");
             //out.println("</html></body>");
             
             con.close();
        }
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
            
                
                else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('OPD Number Not Found');");
                        out.println("location='patient_examination.jsp';");
                        out.println("</script>");
                    }         
               
               //  out.println("You clicked the validate button");
                     
    }
                   
     
         
            
  //2. Saving Symptoms to the database from clinician side

if (request.getParameter("savesymptoms") !=null) 
{
    try
    {
             String OPDNooo = request.getParameter("opdno");       
          if ("".equals(OPDNooo))
                {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Kindly Enter OPD No. To Acertain who the patient is first!');");
                        out.println("location='patient_examination.jsp';");
                        out.println("</script>");    
                }
                else
                {     
        
        dbconn=new DatabaseConnection();
   
        String OPDNoo = request.getParameter("opdno"); 
         String Symptoms = request.getParameter("symptoms");
         
         
         
System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+OPDNoo+Symptoms);
conn=dbconn.setConnection();

 System.out.println("OOOOO"+conn);
stmt=conn.createStatement();
query= "insert into rhc.patientsymptoms(OPDNo,symptoms)"+" values('"+OPDNoo+"','"+Symptoms+"')";
int i=stmt.executeUpdate(query);
 if (i!=0){
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Disease Symptoms Succesfully Saved');");
 out.println("location='patient_examination.jsp';");
 out.println("</script>"); 
 }
 
 else
 {
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Please Correct Errors and try again');");
 out.println("location='patient_examination.jsp';");
 out.println("</script>");
 }   
conn.close();
}  
    }      
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                
}finally {

out.close();
        }
} 


            
 //new button for adding labtest      
            
 
if (request.getParameter("addlabtest") !=null){
    
try {
    /* ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql = "select * from rhc.labtesttypes";
        
             ResultSet rs = st.executeQuery(sql);
     if (rs.next()) {
                 int Tid = rs.getInt("testid");
                 String TName = rs.getString("testname");
                 float TCost = rs.getFloat("testcost");
                
                 
                  request.getSession().setAttribute("Tid", Tid);
                 request.getSession().setAttribute("TName", TName);
                 request.getSession().setAttribute("TCost", TCost);
                
                
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                



    
    
    
    
    
    
    
                
     try
                {
                
                dbconn=new DatabaseConnection();
                
                String LabTest = request.getParameter("labtests");
                String OPDNo = request.getParameter("opdno");
               
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+OPDNo+LabTest);

                conn=dbconn.setConnection();
                System.out.println("OOOOO"+conn);
                stmt=conn.createStatement();
                
 query= "insert into rhc.patientlabtests(OPDNo,testname)"+" values('"+OPDNo+"','"+LabTest+"')";
int i=stmt.executeUpdate(query);
 if (i!=0){
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Lab Test Added Succesfully');");
 out.println("location='patient_examination.jsp';");
 out.println("</script>");
 //out.println("<html><body><b>Successfully Inserted" + "</b></body></html>"); 
 }
 
 else
 {
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Please Correct Errors and try again');");
 out.println("location='patient_registration.jsp';");
 out.println("</script>");
 }   
conn.close();
        */
 

}
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                
                
           // out.println("You want to add labtest!");
                }
            }

if (request.getParameter("medhistory") !=null)
    {
       out.println("<script type=\"text/javascript\">");
       out.println("alert ('There is no Medical History Database For This Patient');");
       out.println("location='patient_examination.jsp';");
       out.println("</script>"); 
    }        

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String htmlFilter(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
