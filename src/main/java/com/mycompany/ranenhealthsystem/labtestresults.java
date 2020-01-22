/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;

import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import com.mycompany.ranenhealthsystem.service.DatabaseConnection;
import com.mycompany.ranenhealthsystem.service.labtestresultscheckservice;
import java.io.IOException;
import java.io.PrintWriter;
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
public class labtestresults extends HttpServlet {
    String query;
    Connection conn;
    Statement stmt;
    ResultSet res;
    DatabaseConnection dbconn;
     //opdcheckservice opdcheckservice = new opdcheckservice();
     labtestresultscheckservice labtestresultscheckservice = new labtestresultscheckservice();

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
            
if (request.getParameter("validatetest") !=null)
    {
               
        String OPDNO11 = request.getParameter("opdno");
                boolean authenticated = labtestresultscheckservice.authenticateUser(OPDNO11);
            
            
                if((authenticated)) 
                    
                                  {
                       
                                      
 try {
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql1 = "select * from rhc.patientinformation, rhc.vitalrecords where rhc.patientinformation.OPDNo = rhc.vitalrecords.OPDNo AND rhc.patientinformation.OPDNo = '"+OPDNO11+"'";
        
             ResultSet rs = st.executeQuery(sql1);
     if (rs.next()) {
                 int OPD11 = rs.getInt("OPDNo");
                 
                 
                 String FName1 = rs.getString("FirstName");
                  //if (FName == null || (FName = htmlFilter(FName.trim())).length() == 0)
                 //{
                 //out.println("<p>Name: MISSING</p>");
                 //}
                 String MName1 = rs.getString("MiddleName");
                 String LName1 = rs.getString("LastName");
                 int Age1 = rs.getInt("Age");
                 String Sex1 = rs.getString("Sex");
                 int mobile1 = rs.getInt("MobileNo"); 
                int weight1 = rs.getInt("Weight");
                int bloodpressure1 = rs.getInt("Bloodpressure");
                 
                if ("".equals(OPD11))
                {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Some Items are still blank. Kindly Go Back to registration desk');");
                        out.println("location='Patient_LabTest.jsp';");
                        out.println("</script>");    
                }
                else
                {     
                  request.getSession().setAttribute("firstname1", FName1);
                 request.getSession().setAttribute("opdno1", OPD11);
                 request.getSession().setAttribute("middlename1", MName1);
                 request.getSession().setAttribute("lastname1", LName1);
                 request.getSession().setAttribute("age1", Age1);
                request.getSession().setAttribute("sex1", Sex1);
                request.getSession().setAttribute("mobile1", mobile1);
                request.getSession().setAttribute("weight1", weight1);
                request.getSession().setAttribute("bloodpressure1", bloodpressure1);
                
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                
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
  return;
    }
            
    }
               /* else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('OPD Number Not Found');");
                        out.println("location='Patient_LabTest.jsp';");
                        out.println("</script>");
                    }  */ 
               /* else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('OPD Number Not Found');");
                        out.println("location='Patient_LabTest.jsp';");
                        out.println("</script>");
                    }  */ 
               /* else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('OPD Number Not Found');");
                        out.println("location='Patient_LabTest.jsp';");
                        out.println("</script>");
                    }  */ 
               /* else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('OPD Number Not Found');");
                        out.println("location='Patient_LabTest.jsp';");
                        out.println("</script>");
                    }  */ 
               
               
               
if (request.getParameter("viewsymptoms") !=null)
    {
               
        String OPDNO12 = request.getParameter("opdno");
        
        
        
        try {
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql1 = "select * from rhc.patientsymptoms, rhc.patientlaboratorytests where rhc.patientsymptoms.OPDNo = rhc.patientlaboratorytests.OPDNo AND rhc.patientlaboratorytests.OPDNo = '"+OPDNO12+"'";
        
             ResultSet rs = st.executeQuery(sql1);
     if (rs.next()) {
               
              String Symptomsview = rs.getString("symptoms");
              String testdetails = rs.getString("testname");
              float tamount = rs.getFloat("testamount");
              
              request.getSession().setAttribute("sview", Symptomsview);
              request.getSession().setAttribute("Tdetails", testdetails);
             request.getSession().setAttribute("Tamount", tamount);
                                 
              request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
               request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
                request.getRequestDispatcher("Patient_LabTest.jsp").forward(request, response);
               
               
               }
             
             con.close();
            
        }
         
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //end of second button
               
               
               
    
 
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

}
