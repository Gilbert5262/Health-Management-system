/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;

import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import com.mycompany.ranenhealthsystem.service.DatabaseConnection;
import com.mycompany.ranenhealthsystem.service.accountsopdcheckservice;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
public class accounts extends HttpServlet {
 String query;
    Connection conn;
    Statement stmt;
    ResultSet res;
    DatabaseConnection dbconn;
     accountsopdcheckservice accountsopdcheckservice = new accountsopdcheckservice();
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
                boolean authenticated = accountsopdcheckservice.authenticateUser(OPDNO);
            
            
                if((authenticated)) 
                    
                                  {
                       
                                      
 try {
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql = "select * from rhc.patientinformation, rhc.vitalrecords where rhc.patientinformation.OPDNo = rhc.vitalrecords.OPDNo AND rhc.patientinformation.OPDNo = '"+OPDNO+"'";
        
             ResultSet rs = st.executeQuery(sql);
     if (rs.next()) {
                 int OPD = rs.getInt("OPDNo");
                                 
                 String FName = rs.getString("FirstName");
                 String MName = rs.getString("MiddleName");
                 String LName = rs.getString("LastName");
                 int Age = rs.getInt("Age");
                 String Sex = rs.getString("Sex");
                 int mobile = rs.getInt("MobileNo"); 
                int weight = rs.getInt("Weight");
                int bloodpressure = rs.getInt("Bloodpressure");
                 
                request.getSession().setAttribute("fname", FName);
                 request.getSession().setAttribute("opd", OPD);
                 request.getSession().setAttribute("mname", MName);
                 request.getSession().setAttribute("lname", LName);
                 request.getSession().setAttribute("Age", Age);
                request.getSession().setAttribute("Sex", Sex);
                request.getSession().setAttribute("Mobile", mobile);
                request.getSession().setAttribute("Weight", weight);
                request.getSession().setAttribute("BP", bloodpressure);
                
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                request.getRequestDispatcher("Accounts.jsp").forward(request, response);
                
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
                        out.println("alert ('OPD Number Not Found');");
                        out.println("location='Accounts.jsp';");
                        out.println("</script>");
                    }         
                                
    }       
            
     



if (request.getParameter("searchbill") !=null)
{

    String bill = request.getParameter("payment options");
    String OPDNO2 = request.getParameter("opdno");
    
    
    if (bill.equals("Consultation Fee"))
    {
        double x = 250;
        
        request.getSession().setAttribute("bill", x);
        request.getRequestDispatcher("Accounts.jsp").forward(request, response);
    }
     if (bill.equals("Medical/Drugs Fee"))
    {
        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Do you wish to pay medical, drugs fee?');");
                        out.println("location='Accounts.jsp';");
                        out.println("</script>");
    }
    
     
     
     
     
     //payment of labtest fee and sending lab test to lab if payments has been done
            if (bill.equals("Lab Test Fee"))
                {
                    
                    try
                {
                String OPDNO3 = request.getParameter("opdno");
               ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql = "select SUM(testamount) from rhc.patientlaboratorytests where rhc.patientlaboratorytests.OPDNo = '"+OPDNO3+"'";
        
             ResultSet rs = st.executeQuery(sql);
             

 while (rs.next()) {
  
     String total = rs.getString("SUM(testamount)");
     
        request.getSession().setAttribute("totalsum", total);
        request.getRequestDispatcher("Accounts.jsp").forward(request, response);
    }


     }
                
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
       
                }
     
     
     
     
      if (bill.equals("Family Planing Fee"))
    {
        double x = 250;
        
        request.getSession().setAttribute("bill", x);
        request.getRequestDispatcher("Accounts.jsp").forward(request, response);
    }
       if (bill.equals("Surgical Fee"))
    {
        double x = 250;
        
        request.getSession().setAttribute("bill", x);
        request.getRequestDispatcher("Accounts.jsp").forward(request, response);
    }
        if (bill.equals("Injection Fee"))
    {
        double x = 250;
        
        request.getSession().setAttribute("bill", x);
        request.getRequestDispatcher("Accounts.jsp").forward(request, response);
    }
         if (bill.equals("Maternity Fee"))
    {
        double x = 250;
        
        request.getSession().setAttribute("bill", x);
        request.getRequestDispatcher("Accounts.jsp").forward(request, response);
    }
          if (bill.equals("Other Payments"))
    {
        double x = 250;
        
        request.getSession().setAttribute("bill", x);
        request.getRequestDispatcher("Accounts.jsp").forward(request, response);
    }
          
          
          
          
          
          
          
          
          
          //Button for listing the details of payment being made
          
if (request.getParameter("getdetails") !=null)
    
       {
                    
           try
                {
                
               ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sqll = "select * from rhc.labtesttypes";
        
             ResultSet rs = st.executeQuery(sqll);
             
            //  out.println("<table border=1 width=50% height=20%>");
            // out.println("<tr><th>LabTest ID</th><th>LabTest Name</th><th>LabTest Cost</th></tr>");
    
 out.println("<P ALIGN='center'><TABLE BORDER=1>");
 ResultSetMetaData rsmd = rs.getMetaData();
 int columnCount = rsmd.getColumnCount();
 int rowCount =0;
 // table header
 out.println("<TR>");
 for (int i = 0; i < columnCount; i++) {
   out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
   }
 out.println("</TR>");
  // the data
 while (rs.next()) {
  
     rowCount++;
  out.println("<TR>");
  for (int i = 0; i < columnCount; i++) {
    out.println("<TD>" + rs.getString(i + 1) + "</TD>");
    }
  out.println("</TR>");
  }
 out.println("</TABLE></P>");
 //return rowCount;
     }
                
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
       
                }
    /*else
            {
          
               out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Consultation fee cannot be added at this time');");
                        out.println("location='Accounts.jsp';");
                        out.println("</script>"); 
                
            }*/
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
