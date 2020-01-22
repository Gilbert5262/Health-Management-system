<%-- 
    Document   : VitalsRecord
    Created on : Jun 18, 2019, 3:13:28 PM
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
                                     
    <center><h4><i><center><u>(Vital Records)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="patientvitals" method="POST">
                 
                 <table border="1">
             
                     <tr height: 30px">
                               <td colspan="8">
                                   <h5><i>Personal Information</i></h5>
                                    </td>
                                </tr>
                             <tr>
                                 <td style="text-align: right">OPD No.:</td>
                                   <td><input type="text" size="10" name="opdno" placeholder="OPD No." value = "${opdno}">
                                       <td> <input style="width: 100px; height: 35px;" type="submit" name = "validate2" value="Validate" class="btn btn-success" name="searchopd"/></td>
                                       <td></td>
                                       <td></td>
                                       <td></td>
                                       <td style="text-align: right">Date:</td><td><input type="date"/> </td>
                                   
                                   
                             </tr>
                            <tr>
                                 <td style="text-align: right">Names:</td>
                                 <td><input type="text" size="10" name="First Name" placeholder="First Name" disabled="disabled" readonly="readonly" value = "${firstname}"/></td>
                                 <td><input type="text" size="10" name="Middle Name" placeholder="Middle Name" disabled="disabled" readonly="readonly" value = "${middlename}"/></td>
                                 <td><input type="text" size="10" name="Last Name" placeholder="Last Name" disabled="disabled" readonly="readonly" value = "${lastname}"/></td>
                                 <td colspan="0" style="text-align: right; width: 25px">Sex: </td>
                                 <td> <input size = "5" type= "text" name="Sex" disabled="disabled" value = "${sex}"/></td>
                                 <td style="text-align: right">Age:</td>
                                 <td><input type="text" size="10" name="age" placeholder="age" disabled="disabled" value = "${age}"/></td>
                            </tr>
                             <tr>
                                 
                                 <td></td>  
                                </tr>
                                
                                
                 </table>  
                  
                            </br>
                  <table border="2">
             
                   <td colspan="5">
                                   <h5><i>Vital Records</i></h5>
                                    </td>
                                </tr>
                                <tr>
                                   <td style="text-align: right">Weight:</td>
                                   <td><input type="text" name="weight" placeholder="Weight (Kgs)" size="16"/></td>
                                   <td style="text-align: right">Blood_Pressure:</td>
                                    <td><input type="text" name="bloodpressure" placeholder="Blood_pressure" size="16"/></td>
                                    <td><input style="width: 100px; height: 35px;" type="submit" value="Save" class="btn btn-success" name="save1"/> </td>
                               </tr>
                                
                             <tr>
                                 <td> </td>
                                   <td> <a href="patient_registration.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Back</button></a>
                                   <a href="PaymentMethod.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Next</button></a>
                                   </td>
                            
                                   <td></td>
                                   <td></td>
                                    <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Logout</button></a></td>
              </form>    
         </div>
      </center>
    </body>
</html>

