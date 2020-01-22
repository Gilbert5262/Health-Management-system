<%-- 
    Document   : Administrator
    Created on : Jun 26, 2019, 10:37:09 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>patient_registration</title>
        
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            td {
                padding: 6px;
            }
            
            div{
                width: 65%;
                border: 1px solid black;
                background-color: antiquewhite;
            }
            h5 {
                color: white;
                background-color: brown;
                height: 60%
            }
        </style>
    </head>
    <body>
        <h2><center>Ranen Health Management System<i></i></center></h2>
                                     
    <center><h4><i><center><u>(Admin Panel)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="Register" method="POST">
                 <table border="2">
             
                     <tr height: 30px">
                               <td colspan="5">
                                   <h5><i>General Control Pannel</i></h5>
                                    </td>
                                </tr>
                                <tr>
                                    
                                         <td><input style="width: 150px; height: 35px;" type="submit" value="User Logins" class="btn btn-success" name="LoginCred"/></td>                               
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="RHC Employees" class="btn btn-success" name="RHCEmployees"/></td>
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="RC Employees" class="btn btn-success" name="RCEmployees"/></td>
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="Employee Accts" class="btn btn-success" name="EmployeeAccts"/></td>                             <tr>
                                    <td><input style="width: 150px; height: 35px;" type="submit" value="Accounting" class="btn btn-success" name="Login Accounts"/></td>
                                    <td><input style="width: 150px; height: 35px;" type="submit" value="Drugs" class="btn btn-success" name="Login Accounts"/></td>
                                    <td><input style="width: 150px; height: 35px;" type="submit" value="AddLabTests" class="btn btn-success" name="Addlabtests"/></td>
                                    <td></td>
                                                <td> <a href="PatientCheck.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Home_Page</button></a></td>
                                   
                                   
                             </tr>
                                
                             <tr>
                                   <td></td>
                                   <td></td>
                            
                                   <td></td>
                                   <td></td>
                                    <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Logout</button></a></td>
                                       <%-- <td colspan="1"><button style="width: 100px; height: 35px;" class="btn btn-success" name="logout" type="button" onclick="loadDoc();"> logout </button></td> --%>
                             
                             
  <script>
function loadDoc() {
  var txt;
  var person = prompt("Please enter your name:", "Harry Potter");
  if (person == null || person == "") {
    txt = "User cancelled the prompt.";
  } else {
    txt = "Hello " + person + "! How are you today?";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>
                             
                </tr>
                 </table>
                 </form>
        </br>
        <form action="Payment" method="post">
            
            <table border="2">
             
                      <tr height: 30px">
                               <td colspan="5">
                                   <h5><i>Patient Data Management</i></h5>
                                    </td>
                                </tr>
                                <tr>
                                    
                                         <td><input style="width: 150px; height: 35px;" type="submit" value="Registration" class="btn btn-success" name="Registration"/></td>                               
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="In-Patient" class="btn btn-success" name="In-Patient"/></td>
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="Out-Patient" class="btn btn-success" name="Out-Patient"/></td>
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="Maternity" class="btn btn-success" name="EmployeeAccts"/></td>                             <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                                <td> <a href="PatientCheck.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Home_Page</button></a></td>
                                   
                                   
                             </tr>
                                
                             <tr>
                                   <td></td>
                                   <td></td>
                            
                                   <td></td>
                                   <td></td>
                                    <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Logout</button></a></td>
                                       <%-- <td colspan="1"><button style="width: 100px; height: 35px;" class="btn btn-success" name="logout" type="button" onclick="loadDoc();"> logout </button></td> --%>
                             
                             
  <script>
function loadDoc() {
  var txt;
  var person = prompt("Please enter your name:", "Harry Potter");
  if (person == null || person == "") {
    txt = "User cancelled the prompt.";
  } else {
    txt = "Hello " + person + "! How are you today?";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>
                             
   </tr>
                               
    </table>
       </form>
        
        </br> 
                <form action="medical" method="post">
            
            <table border="2">              
                   <tr height: 30px">
                               <td colspan="5">
                                   <h5><i>Reports & System Configuration</i></h5>
                                    </td>
                                </tr>
                                <tr>
                                    
                                         <td><input style="width: 150px; height: 35px;" type="submit" value="Financial Reports" class="btn btn-success" name="Login Accounts"/></td>                               
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="Employee Reports" class="btn btn-success" name="RHCEmployees"/></td>
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="Patient Reports" class="btn btn-success" name="RCEmployees"/></td>
                                      <td><input style="width: 150px; height: 35px;" type="submit" value="Drugs Reports" class="btn btn-success" name="EmployeeAccts"/></td>                             <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                                <td> <a href="PatientCheck.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Home_Page</button></a></td>
                                   
                                   
                             </tr>
                                
                             <tr>
                                   <td></td>
                                   <td></td>
                            
                                   <td></td>
                                   <td></td>
                                    <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Logout</button></a></td>
                                       <%-- <td colspan="1"><button style="width: 100px; height: 35px;" class="btn btn-success" name="logout" type="button" onclick="loadDoc();"> logout </button></td> --%>
                             
                             
  <script>
function loadDoc() {
  var txt;
  var person = prompt("Please enter your name:", "Harry Potter");
  if (person == null || person == "") {
    txt = "User cancelled the prompt.";
  } else {
    txt = "Hello " + person + "! How are you today?";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>
                             
                </