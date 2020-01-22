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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
public class payforconsultation extends HttpServlet {
    
    String returnPage="default.jsp";
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
            
if (request.getParameter("searchconsultation") !=null)
    {
               
        try
                {
                String OPDNO3 = request.getParameter("opdno");
               ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql = "select Amount from rhc.consultationfee where rhc.consultationfee.OPDNo = '"+OPDNO3+"'";
        
             ResultSet rs = st.executeQuery(sql);
             

 while (rs.next()) {
  
     float consultamnt = rs.getFloat("Amount");
     request.setAttribute("ConsultAmnt", consultamnt);
     RequestDispatcher rd;
     rd = getServletContext().getRequestDispatcher("/paymentconsultationfee.jsp");
     rd.forward(request, response);
     
     
       //request.getSession().setAttribute("totaldrugs", total);
       //returnPage = "paymentdrugsfee.jsp";
    }
con.close();

     }
                
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
       
    }
            
        /*        
                else
                    {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('OPD Number Not Found');");
                        out.println("location='patient_examination.jsp';");
                        out.println("</script>");
                    }         
               
               //  out.println("You clicked the validate button");
                     
    */
        
               
             
               
//2. Get payment table details for consultation

if (request.getParameter("getconsultdetails") !=null) 
{
    try
                {
                String OPDNO4 = request.getParameter("opdno");
               ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
            
             String sqll = "select * from rhc.consultationfee where rhc.consultationfee.OPDNo = '"+OPDNO4+"'";
        
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
 
     }
                
         
 
/*else
 {
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Please Correct Errors and try again');");
 out.println("location='patient_examination.jsp';");
 out.println("</script>");
 }   
conn.close();*/
 
    
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                
}finally {

out.close();
        }
}   
    

//3. Add payments for consultation
  if (request.getParameter("Pay2") !=null)
    
       {
         try
            {
             String OPDNo7 = request.getParameter("opdno");       
                if ("".equals(OPDNo7))
                {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert ('Kindly Enter OPD No. To Acertain who the patient is first!');");
                        out.println("location='paymentdrugsfee.jsp';");
                        out.println("</script>");    
                }
                else
                {     
        
        dbconn=new DatabaseConnection();
   
        String OPDNo8 = request.getParameter("opdno"); 
         String ConsultationFee = request.getParameter("consultationfee");
         String amnt = request.getParameter("consultamount");
         String PayMode = request.getParameter("paymethod");
         String Status = "Paid";
         
         
         
System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+OPDNo8+ConsultationFee+amnt+PayMode+Status);
conn=dbconn.setConnection();

 System.out.println("OOOOO"+conn);
stmt=conn.createStatement();
query= "insert into rhc.amountspaid (OPDNo,PayDetails,AmntPaid,PayMode,PayStatus)"+" values('"+OPDNo8+"','"+ConsultationFee+"','"+amnt+"','"+PayMode+"','"+Status+"')";
int x=stmt.executeUpdate(query);
 if (x!=0){
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Amount Paid and succesfully recorded in the database');");
 out.println("location='paymentconsultationfee.jsp';");
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
