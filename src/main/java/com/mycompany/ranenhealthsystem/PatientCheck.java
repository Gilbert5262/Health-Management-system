/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;


import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import java.sql.*;


import com.mycompany.ranenhealthsystem.service.PatientCheckService;
import com.mycompany.ranenhealthsystem.service.RegistrationService;
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
public class PatientCheck extends HttpServlet {
    PatientCheckService PatientCheckService = new PatientCheckService();

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
           
            
            
            out.println("<table border=1 width=50% height=20%>");
             out.println("<tr><th>OPDNo</th><th>First Name</th><th>Middle Name</th><th>Last Name</th><th>Age</th><th>Sex</th><th>Mobile No.</th><th>Select Option</th><tr>");
             if (rs.next()) {
                 int OPD = rs.getInt("OPDNo");
                 String FName = rs.getString("FirstName");
                 String MName = rs.getString("MiddleName");
                 String LName = rs.getString("LastName");
                 int Age = rs.getInt("Age");
                 String Sex = rs.getString("Sex");
                 int mobile = rs.getInt("MobileNo"); 
                 out.println("<tr><td>" + OPD + "</td><td>" + FName + "</td><td>" + MName + "</td><td>" + LName + "</td><td>" + Age + "</td><td>" + Sex + "</td><td>" + mobile + "</td><td><p><a href='VitalsRecord.jsp'>Select</a></P></td></tr>");
                 //out.println("<tr><td><button style= "width: 100px; height: 35px;" name="Exit" type="button" onclick= "loadDoc();"> Exit </button></td></tr>");
                                               }
             out.println("</table>");
             out.println("</html></body>");
             con.close();
             
                      
                                      
         /*   if (rs.next())
                
            {
                String validUsrname = rs.getString("FirstName");
                String validPasswrd = rs.getString("LastName");
                
                                    
                    if (validUsrname.equals(firstName) && validPasswrd.equals(lastName)){
                        //out.println("login successful");
                        System.out.println("login successful"); 
                        authenticated = true;
                    }   
                        
                        con.close();
             */
                                      
       /*}
                                      
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('You are already in the database!!!');");
                        out.println("location='VitalsRecord.jsp';");
                        out.println("</script>");
                    }
                    else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Please add new member');");
                        out.println("location='patient_registration.jsp';");
                        out.println("</script>");
                    }
                */
                
        
        }
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
                                                