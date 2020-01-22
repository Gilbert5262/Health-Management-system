/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;
import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import com.mycompany.ranenhealthsystem.service.PatientCheckService;
import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DataServlet extends HttpServlet {
PatientCheckService PatientCheckService = new PatientCheckService();
    private ServletConfig config;

  //Setting JSP page

  String page="DataPage.jsp";
  
   public void init(ServletConfig config)

  throws ServletException{

 this.config=config;

 }
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
            String _PatientFName = request.getParameter("patientFName");
            //int _PatientOPDNo = (int) request.getAttribute("opdno");
            String _PatientLName = request.getParameter("patientLName");
            
            //int _patientopdno= Integer.parseInt(_PatientOPDNo);
            response.setContentType("text/html");

  List dataList = new ArrayList(); 
                       
            boolean authenticated = PatientCheckService.authenticateUser(_PatientFName,_PatientLName);
            
            
                if((authenticated)) 
                    
                                  {
                       
                                      
 try {
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             //String sql = "select OPDNo, FirstName, MiddleName, LastName, Age, Sex, PhysicalAdress, SubLocation, Location, MobileNo from rhc.patientinformation where FirstName = '' and LastName = ''";      
            
             String sql = "select * from rhc.patientinformation where lower (FirstName)  like '%"+_PatientFName+"%' AND lower (LastName) like '%"+_PatientLName+"%'";
          //  String y =  "select * from users where username='" + username + "' AND password='" + password + "'";
             
             ResultSet rs = st.executeQuery(sql);
           
            
           if (rs.next()) {
                
  dataList.add(rs.getInt("OPDNo"));

  dataList.add(rs.getString("FirstName"));
                 int OPD = rs.getInt("OPDNo");
                 String FName = rs.getString("FirstName");
                 String MName = rs.getString("MiddleName");
                 String LName = rs.getString("LastName");
                 int Age = rs.getInt("Age");
                 String Sex = rs.getString("Sex");
                 int mobile = rs.getInt("MobileNo"); 
                        }
           
             con.close();
            
        
        
        }
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 request.setAttribute("data", dataList);

  //Disptching request

  RequestDispatcher dispatcher = request.getRequestDispatcher(page);

  if (dispatcher != null){

  dispatcher.forward(request, response);

  } 
    }
                
                else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Patient Not In Database. Please Add Patient');");
                        out.println("location='PatientCheck.jsp';");
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

}
