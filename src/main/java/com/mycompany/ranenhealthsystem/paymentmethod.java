/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;

import com.mycompany.ranenhealthsystem.service.DatabaseConnection;
import com.mycompany.ranenhealthsystem.service.opdcheckservice;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "paymentmethod", urlPatterns = {"/paymentmethod"})
public class paymentmethod extends HttpServlet {

    
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
            
      if (request.getParameter("SavePay") !=null)
    
       {
         try
            {
             String OPDNo7 = request.getParameter("opdno");       
                if ("".equals(OPDNo7))
                {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Kindly Enter OPD No. To Acertain who the patient is first!');");
                        out.println("location='PaymentMethod.jsp';");
                        out.println("</script>");    
                }
                else
                {     
        
        dbconn=new DatabaseConnection();
   
        String OPDNo8 = request.getParameter("opdno"); 
         String ConsultationFee = "Consultation Fee";
         String amnt = request.getParameter("consultationfee");
         
         
         
         
System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+OPDNo8+ConsultationFee+amnt);
conn=dbconn.setConnection();

 System.out.println("OOOOO"+conn);
stmt=conn.createStatement();
query= "insert into rhc.consultationfee (Description,Amount,OPDNo)"+" values('"+ConsultationFee+"','"+amnt+"','"+OPDNo8+"')";
int x=stmt.executeUpdate(query);
 if (x!=0){
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Consultation Fee succesfully recorded in the database');");
 out.println("location='PatientCheck.jsp';");
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
