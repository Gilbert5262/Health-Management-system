<%-- 
    Document   : patient_registration
    Created on : Apr 30, 2019, 11:21:30 AM
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
                                     
    <center><h4><i><center><u>New Patient Registration (Fill All Spaces)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="patientregister" method="POST">
                 <table border="2">
             
                     <tr height: 30px">
                               <td colspan="5">
                                   <h5><i>Personal Information</i></h5>
                                    </td>
                                </tr>
                                <tr>
                                 <td style="text-align: right">OPD No.:</td>
                                   <td><input type="text" name="opdno" placeholder="OPD No."></td>
                                    <td style="text-align: right">Date:</td>
                                   <td> <input type="text" name="date" placeholder="YYYY-MM-DD" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" title="Enter a date in this format YYYY-MM-DD"/></td>
                                   
                                  
                                   <td colspan="3"> <input style="width: 100px; height: 35px;" type="Submit" value="AddPatient" class="btn btn-success" name="save"/> </td>
                                   
                                   </tr>
                             <tr>
                                 <td style="text-align: right">Name:</td>
                                 <td><input type="text" name="patientFName" placeholder="First Name" size="12"></td>
                                 <td><input type="text" name="patientMName" placeholder="Middle Name" size="12"></td> 
                                 <td><input type="text" name="patientLName" placeholder="Last Name" size="12"> </td>
                                               <td> <a href="VitalsRecord.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Next_Page</button></a></td>
                                 
                             </tr>
                                
                             <tr>
                                   <td style="text-align: right">Age:</td>
                                   <td><input type="text" name="age" placeholder="age"></td>
                            
                                   <td style="text-align: right">Sex:</td>
                                   <td><input type="radio" name="sex" value="male" checked="checked" /> Male   <input type="radio" name="sex" value="female"/> Female</td>
                               <td> <a href="PatientCheck.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Home_Page</button></a></td>
                                </tr>
                                <tr>
                                    <td style="text-align: right">Physical Address:</td>
                                    <td><input type="text" name="physicaladdress" placeholder="Physical Address"/></td>
                     
                                    <td style="text-align: right">Location:</td>
                                    <td><input type="text" name="location" placeholder="Location"/></td>
                                    <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Logout</button></a></td>
                                </tr>
                                <tr>
                                    <td style="text-align: right">Sub_Location:</td>
                                    <td><input type="text" name="sublocation" placeholder="Sub_Location"/></td>
                                <td style="text-align: right">Mobile_No:</td>
                                    <td><input type="text" name="mobileno" placeholder="Mobile_No."/></td>
                                </tr>
                                <tr>
                 </table>
                 </form>
         </div>
      </center>
    </body>
</html>

                                                                                                                                