/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ranenhealthsystem;

import com.mycompany.ranenhealthsystem.data.ConnectionManager;
import com.mycompany.ranenhealthsystem.service.DatabaseConnection;
import com.mycompany.ranenhealthsystem.service.injectioncheckservice;
import com.mycompany.ranenhealthsystem.service.patientdrugsservice;
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
public class patientdrugs extends HttpServlet {
    
    String query;
    Connection conn;
    Statement stmt;
    ResultSet res;
    DatabaseConnection dbconn;
     patientdrugsservice patientdrugsservice = new patientdrugsservice ();

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
            
//1. Adding a Injection by validating the code first on the add injection button           
            

            

            if (request.getParameter("adddrug") !=null)
{
   try 
   
  {
           String Drugcode = request.getParameter("drugcode");
                boolean authenticated = patientdrugsservice.authenticateUser(Drugcode);
            
            
    if((authenticated)) 
    {                      
                                    
 
     ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql1 = "select * from rhc.drugrecordstable where drugcode = '"+Drugcode+"'";
        
             ResultSet rs = st.executeQuery(sql1);
     if (rs.next()) {
                 int drugcode = rs.getInt("drugcode");
                 String drugname = rs.getString("drugname");
                 String drugcost = rs.getString("DrugRetailPrice");
    
                request.getSession().setAttribute("drugcode", drugcode);
                request.getSession().setAttribute("drugname", drugname);
                request.getSession().setAttribute("drugcost", drugcost);
                
                request.getRequestDispatcher("patientdrugs.jsp").forward(request, response);
                request.getRequestDispatcher("patientdrugs.jsp").forward(request, response);
                request.getRequestDispatcher("patientdrugs.jsp").forward(request, response);
                
                }
               
             con.close();
    }
            
                 
}
                 
      catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            
            
            
            
            
  
                 
                 
                 
                 
                 
            
            
            
 //2. for listing available Injections
            
if (request.getParameter("viewdrugs") !=null)

{
 try
                {
                
               ConnectionManager db= new ConnectionManager();
            Connection con = db.getcon();
            
            Statement st = con.createStatement();
            
             String sql = "select * from rhc.drugrecordstable";
        
             ResultSet rs = st.executeQuery(sql);
             
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
      
         
         
         
     
               /*   int LTestID = rs.getInt("testid");
                 String LTestName = rs.getString("testname");
                 String LTestCost = rs.getString("testcost");
                 
                 
                 int rowcount = 0;
                 ResultSetMetaData rsmd = rs.getMetaData();
                 int columncount = rsmd.getColumnCount();
                 
                for (int i=0, i<columncount; i++){
   out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
   }
                
                rowcount++;
                out.println("<tr>");
                for (int i=0; i<columncount; i++)
                 out.println("<tr><td>" + LTestID + "</td><td>" + LTestName + "</td><td>" + LTestCost + "</td>");
                 //out.println("<tr><td><button style= "width: 100px; height: 35px;" name="Exit" type="button" onclick= "loadDoc();"> Exit </button></td></tr>");
                                               }
             out.println("</table>");
             out.println("</html></body>");
                 

   //String page="DataPage.jsp";
   //List dataList = new ArrayList(); 
   //dataList.add(rs.getInt("id"));
   //dataList.add(rs.getString("message"));
                 
                */ 
                 
              /*   request.getSession().setAttribute("firstname", LTestID);
                 request.getSession().setAttribute("opdno", LTestName);
                 request.getSession().setAttribute("middlename", LTestCost);
                 
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                request.getRequestDispatcher("patient_examination.jsp").forward(request, response);
                */

     }
                
                catch (Exception ex){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+ex.getMessage());
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
}
                       
            




//3. Sending injection selected by doctor to the database for processing by injection room

if (request.getParameter("senddrug") !=null) 
{
    try
    {
                   dbconn=new DatabaseConnection();
   
         String DrugCode = request.getParameter("drugcode");
         String OPDNo = request.getParameter("opdno");
         String Drugname = request.getParameter("DrugName");
         String Drugamount = request.getParameter("drugprice");
         
         
           System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+OPDNo+DrugCode+Drugname+Drugamount);
conn=dbconn.setConnection();

 System.out.println("OOOOO"+conn);
stmt=conn.createStatement();
query= "insert into rhc.selectedpatientdrugs (OPDNo,drugcode,drugname,drugprice)"+" values('"+OPDNo+"','"+DrugCode+"','"+Drugname+"','"+Drugamount+"')";
int i=stmt.executeUpdate(query);
 if (i!=0){
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Drugs Sent Succesfully To Pharmacy');");
 out.println("location='patientdrugs.jsp';");
 out.println("</script>"); 
 }
 
 else
 {
 out.println("<script type=\"text/javascript\">");
 out.println("alert ('Please Correct Errors and try again');");
 out.println("location='patientdrugss.jsp';");
 out.println("</script>");
 }   
conn.close();
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
