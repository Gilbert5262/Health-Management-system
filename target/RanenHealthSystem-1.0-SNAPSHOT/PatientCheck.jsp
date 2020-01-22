<%-- 
    Document   : PatientCheck
    Created on : Jun 13, 2019, 3:09:14 PM
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
            h6 {
                color: white;
                background-color: brown;
                height: 60%
            }
            
            
            .my_content_container a {
    border-bottom: 1px solid #777777;
    border-left: 1px solid #000000;
    border-right: 1px solid #333333;
    border-top: 1px solid #000000;
    color: #000000;
    display: block;
    height: 2.5em;
    padding: 0 1em;
    width: 5em;       
    text-decoration: none;       
}
        </style>
    </head>
    <body>
        <h2><center>Ranen Health Management System<i></i></center></h2>
                                     
    <center><h5><i><center><u>(Is the Patient Already Registered With Us?)</u></center></i></h5></center> 
 <center>  
    <div>
              <form action="PatientCheck" method="POST">
                 <table border="2">
             
                     <tr height: 30px">
                               <td colspan="5">
                     <center><h6><i>Search For Patient</i></h6></center> 
                                    </td>
                                </tr>
                             <tr>
                                       <td style="text-align: right">First Name.:</td>
                                   <td><input type="text" name="patientFName" placeholder="First Name"></td>
                                   <td colspan=""> <input style="width: 100px; height: 35px;" type="submit" value="Search" class="btn btn-success" name="search"/> </td>
                             </tr>
                                 
                             <tr>
                                 <td style="text-align: right">Last Name:</td>
                                 <td><input type="text" name="patientLName" placeholder="Last Name" ></td>
                                 <td> <a href="patient_registration.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">NewPatient</button></a></td>
                                 <%--<td><input type ="button" class="my_content_container"> <a href="patient_registration.jsp">New_Patient</a></input> </td>       --%>              
                               
                               </tr>
                             <tr>
                                 <td></td>
                                 <td></td>
                                  <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Exit</button></a></td>
                               </tr>
  <script>
function loadDoc() {
  var txt;
  if (confirm("Are You Sure?")) {
    txt = "You pressed OK!";
  } else {
    txt = "You pressed Cancel!";
  }
  document.getElementById("demo").innerHTML = txt;
}
}
</script>
                             
                                </tr>
                               
                       </table>
                   </form>
               </div>
     
           </center>
    </body>
</html>
