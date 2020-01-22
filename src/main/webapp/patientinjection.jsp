<%-- 
    Document   : patientinjection
    Created on : Aug 14, 2019, 4:54:55 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>patient_examination</title>
        
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            td {
                padding: 6px;
            }
            
            div{
                width: 85%;
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
                                     
    <center><h4><i><center><u>(Out-Patient Examination: Administer Injection)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="patientinjection" method="POST">
                  
<%--TABLE1: name = "Personal information" --%>
                 <table border="1" >
             
                     <tr height: 30px">
                               <td colspan="8">
                                   <h5><i>Personal Information</i></h5>
                                    </td>
                                </tr>
                             <tr>
                                 <td style="text-align: right">OPD No.:</td>
                                   <td><input type="text" size="10" name="opdno" placeholder="OPD No." value = "${opdno}">
                                       <td> <input style="width: 100px; height: 35px;" type="submit" name = "validate" value="Validate" class="btn btn-success" name="searchopd"/></td>
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
                                <tr>
                                   <td style="text-align: right">Weight:</td>
                                   <td><input type="text" size="10" name="weight" placeholder="Weight" disabled="enabled" value = "${weight}"/></td>
                                   <td style="text-align: right">Pressure:</td>
                                   <td><input type="text" size="10" name="bloodpressure" placeholder="Blood_pressure" disabled="disabled" value = "${bloodpressure}"/></td>
                                   <td style="text-align: right">Phone:</td>
                                   <td><input type="text" size="10" name="mobileno" placeholder="Mobile_No." disabled="disabled" value = "${mobile}" /></td>
                                   
                                   <td></td>
                                   <td> <input style=" height: 35px;" type="submit" name = "medical" value="Medical History" class="btn btn-success" name="medhistory"/> </td>
                                   
                               </tr>
                                
                 </table>
                  <br>
                  
<%--TABLE3: name = "Injection table" --%>
                 <table border="2">
                               
                               <tr>
                                   <td colspan="8">
                                       <h5><i>Medical Examination Report: (C) Patient Injection </i></h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                      <td style="text-align: center" colspan="2"><input type="submit" style="width: 150px; height: 25px; font-size: 12px;" value="View Available Injections" class="btn btn-success" name="viewinjections"/></td>
                                      <td></td>
                                    <td style="text-align: center"></td>
                                       <td style="text-align: center"></td>
                                                                       
                                </tr>
                                
                                
                                <tr>
                                    <td></td>
                                    <td style="text-align: right"> 
                                    Code: 
                                    </td> 
                                    <td>
                                        <input type="text" name="injectioncode" size= "4" placeholder="Code" value = "${Injectionid}"/>
                                        <input type="submit" style="width: 50px; height: 35px; font-size: 15px" value="Add+" class="btn btn-success" name="adddinjection"/>
                                    </td>
                                   
                                    <td style="text-align: right">Injection:</td> 
                                    <td>
                                    <input type="text" name="InjectionName" size= "14" placeholder="Injection Name" value="${Injectionname}"/>   
                                    </td>
                                     <td>Cost:</td>
                                    <td>
                                       <input type="text" name="injectionprice" size= "3" placeholder="Kshs." value="${Injectioncost}"/>
                                   </td>
                                   <td>
                                       <input type="submit" style="width: 150px; height: 35px; font-size: 15px" value="Send_For_Injection" class="btn btn-success" name="sendinjection"/>
                                   </td>
                                </tr>
                                
                                <tr>
                                    <td></td>
                                    
                                     <td style="text-align: right"></td> 
                                     <td></td>
                                     <td></td>
                                     <td></td>
                                     <td></td>
                                     <td></td>
                                     <td>
                                       <input type="submit" style="width: 150px; height: 35px; font-size: 15px" value="Lab_TestResults" class="btn btn-success" name="labresults"/>
                                   </td>
                                     <td>
                                    </td>
                                      </tr>
                                      
                                       <tr>
                                    <td></td>
                                     <td> <a href="patient_examination.jsp" <button class="btn btn-success" style="width: 60px; height: 35px;">Back</button></a></td>
                                     <td></td>
                                     <td></td>
                                     <td></td>
                                     <td></a></td>
                                   
                                     <td></td>
                                     <td><a href="index.jsp" <button class="btn btn-success" style="width: 150px; height: 35px;">Logout</button></a></td>
                                      </tr>
                             
                 </table>
                   </form>
               </div>
      </center>
    </body>
</html>