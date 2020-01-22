/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;
import com.mycompany.ranenhealthsystem.service.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class patientregister extends HttpServlet {
String query;
Connection conn;
Statement stmt;
ResultSet res;
DatabaseConnection dbconn;
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
      
            dbconn=new DatabaseConnection();
   
         String tarehe = request.getParameter("date");
         String OPDNo = request.getParameter("opdno");
         String FirstName = request.getParameter("patientFName");
         String MiddleName = request.getParameter("patientMName");
         String LastName = request.getParameter("patientLName");
         String Age = request.getParameter("age");
         String Sex = request.getParameter("sex");
         String PhysicalAdress = request.getParameter("physicaladdress");
         String SubLocation = request.getParameter("sublocation");    
         String Location = request.getParameter("location");
         String MobileNo = request.getParameter("mobileno");
         
           System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+OPDNo+tarehe+FirstName+MiddleName+LastName+Age+Sex+PhysicalAdress+SubLocation+Location+MobileNo);
conn=dbconn.setConnection();

 System.out.println("OOOOO"+conn);
stmt=conn.createStatement();
query= "insert into rhc.patientinformation(OPDNo,Date,FirstName,MiddleName,LastName,Age,Sex,PhysicalAdress,SubLocation,Location,MobileNo)"+" values('"+OPDNo+"','"+tarehe+"','"+FirstName+"','"+MiddleName+"','"+LastName+"','"+Age+"','"+Sex+"','"+PhysicalAdress+"','"+SubLocation+"','"+Location+"','"+MobileNo+"')";
int i=stmt.executeUpdate(query);
 if (i!=0){
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('New Patient Added Succesfully');");
 out.println("location='PatientCheck.jsp';");
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
}  
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                
//RequestDispatcher rd= request.getRequestDispatcher("/error.jsp");
//rd.forward(request, response);
}finally {
//RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
// rd.forward(request, response);
out.close();
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
