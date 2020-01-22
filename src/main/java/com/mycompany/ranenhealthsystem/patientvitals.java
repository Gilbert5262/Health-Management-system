/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;

import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import com.mycompany.ranenhealthsystem.service.DatabaseConnection;
import com.mycompany.ranenhealthsystem.service.opdcheckservice;
import java.io.IOException;
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
public class patientvitals extends HttpServlet {

     opdcheckservice opdcheckservice = new opdcheckservice();
     
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
    
    
     if (request.getParameter("validate2") !=null){
               
        String OPDNO = request.getParameter("opdno");
                boolean authenticated = opdcheckservice.authenticateUser(OPDNO);
            
            
                if((authenticated)) 
                    
                                  {
                       
                                      
 try {
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
            String sql = "select * from rhc.patientinformation where OPDNo = '"+OPDNO+"'";
        
            ResultSet rs = st.executeQuery(sql);
          if (rs.next()) {
                 int OPD = rs.getInt("OPDNo");
                 String FName = rs.getString("FirstName");
                 String MName = rs.getString("MiddleName");
                 String LName = rs.getString("LastName");
                 int Age = rs.getInt("Age");
                 String Sex = rs.getString("Sex");
                 
                 
                 request.getSession().setAttribute("firstname", FName);
                 request.getSession().setAttribute("opdno", OPD);
                 request.getSession().setAttribute("middlename", MName);
                 request.getSession().setAttribute("lastname", LName);
                 request.getSession().setAttribute("age", Age);
                request.getSession().setAttribute("sex", Sex);
              
                request.getRequestDispatcher("VitalsRecord.jsp").forward(request, response);
                request.getRequestDispatcher("VitalsRecord.jsp").forward(request, response);
                request.getRequestDispatcher("VitalsRecord.jsp").forward(request, response);
                request.getRequestDispatcher("VitalsRecord.jsp").forward(request, response);
                request.getRequestDispatcher("VitalsRecord.jsp").forward(request, response);
                request.getRequestDispatcher("VitalsRecord.jsp").forward(request, response);
               
             }
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
                        out.println("alert ('A Patient with such an OPD Number does not exist in the system. Please go back and add such a patient first!');");
                        out.println("location='VitalsRecord.jsp';");
                        out.println("</script>");
                    }         
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
              //  out.println("You clicked the search button");
           
            
            
            
            
            
            
            
            
            } 
            
     
     if (request.getParameter("save1") !=null)
     
     {
          
            
       try {  
         
         
      dbconn=new DatabaseConnection();
   
         String OPDNo = request.getParameter("opdno");
         String Weight = request.getParameter("weight");
         String Bloodpressure = request.getParameter("bloodpressure");
         
           System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+OPDNo+Weight+Bloodpressure);
conn=dbconn.setConnection();

 System.out.println("OOOOO"+conn);
stmt=conn.createStatement();
query= "insert into rhc.vitalrecords(OPDNo,Weight,Bloodpressure)"+" values('"+OPDNo+"','"+Weight+"','"+Bloodpressure+"')";
int i=stmt.executeUpdate(query);
 if (i!=0){
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Patient Vitals Added Succesfully');");
 out.println("location='PaymentMethod.jsp';");
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
