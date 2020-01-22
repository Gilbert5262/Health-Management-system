/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;

import com.mycompany.ranenhealthsystem.service.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Login extends HttpServlet {
    
    //TODO : Create SingleTon Service here, tip getInstance
    
     // LoginService service = LoginService.getInsatnce();
    
    LoginService loginService = new LoginService();

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
            String _username = request.getParameter("usern");
            String _password = request.getParameter("pass");
            String _userlevel = request.getParameter("userlevel");
            
            //String _userlevel = request.getParameter("userlevel");
            
           boolean authenticated = loginService.authenticateUser(_username,_password);
            
                if((authenticated) && _userlevel.equals("Customer_Care")) {          
                        
                        response.sendRedirect("PatientCheck.jsp");                        
                }  
                 if((authenticated) && _userlevel.equals("Clinician")) {          
                        
                        response.sendRedirect("patient_examination.jsp");                        
                }  
                 if((authenticated) && _userlevel.equals("Lab_Tech")) {          
                        
                        response.sendRedirect("Patient_LabTest.jsp");                        
                }  
                  if((authenticated) && _userlevel.equals("Pharmacist")) {          
                        
                        response.sendRedirect("Pharmacy.jsp");                        
                }  
                   if((authenticated) && _userlevel.equals("Accountant")) {          
                        
                        response.sendRedirect("Accounts.jsp");                        
                }  
                   if((authenticated) && _userlevel.equals("Nursing")) {          
                        
                        response.sendRedirect("In_Patient.jsp");                        
                }  
                   if((authenticated) && _userlevel.equals("Administrator")) {          
                        
                        response.sendRedirect("Administrator.jsp");                        
                }  
            else {
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert ('User or password incorrect');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
        } catch (Exception ex){ 
            System.out.println("<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
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
