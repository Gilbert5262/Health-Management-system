<%-- 
    Document   : Patient_LabTest
    Created on : Jun 25, 2019, 1:50:39 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>patient_labtest</title>
        
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            td {
                padding: 6px;
            }
            
            div{
                width: 85%;
                border: 1px solid black;
                border: radius 5px;
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
                                     
    <center><h4><i><center><u>(Lab Test)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="labtestresults" method="POST">
                       <%--TABLE1: name = "Personal information" --%>
                 <table border="1" >
             
                     <tr height: 30px">
                               <td colspan="8">
                                   <h5><i>Personal Information</i></h5>
                                    </td>
                                </tr>
                             <tr>
                                 <td style="text-align: right">OPD No.:</td>
                                   <td><input type="text" size="10" name="opdno" placeholder="OPD No." value = "${opdno1}">
                                       <td style="text-align: right"><input type="date"/></td>
                                       <td> <input style="width: 100px; height: 35px;" type="submit" value="Validate" class="btn btn-success" name="validatetest"/></td>
                                       <td></td>
                                       <td></td>
                                       <td></td>
                                       <td style="text-align: right"></td>
                            </tr>
                            <tr>
                                 <td style="text-align: right">Names:</td>
                                 <td><input type="text" size="10" name="First Name" placeholder="First Name"  readonly="readonly" value = "${firstname1}"/></td>
                                 <td><input type="text" size="10" name="Middle Name" placeholder="Middle Name"  readonly="readonly" value = "${middlename1}"/></td>
                                 <td><input type="text" size="10" name="Last Name" placeholder="Last Name" readonly="readonly" value = "${lastname1}"/></td>
                                 <td colspan="0" style="text-align: right; width: 25px">Sex: </td>
                                 <td> <input size = "5" type= "text" name="Sex"  value = "${sex1}"/></td>
                                 <td style="text-align: right">Age:</td>
                                 <td><input type="text" size="10" name="age" placeholder="age"  value = "${age1}"/></td>
                            </tr>
                             <tr>
                                 
                                 <td></td>  
                                </tr>
                                <tr>
                                   <td style="text-align: right">Weight:</td>
                                   <td><input type="text" size="10" name="weight" placeholder="Weight"  value = "${weight1}"/></td>
                                   <td style="text-align: right">Pressure:</td>
                                   <td><input type="text" size="10" name="bloodpressure" placeholder="Blood_pressure"  value = "${bloodpressure1}"/></td>
                                   <td style="text-align: right">Phone:</td>
                                   <td><input type="text" size="10" name="mobileno" placeholder="Mobile_No."  value = "${mobile1}" /></td>
                                   
                                   <td></td>
                                   <td> <a href="index.jsp" <button class="btn btn-success" style="width: 150px; height: 35px;">Logout</button></a> </td>
                                   
                               </tr>
                                
                 </table>
                  <br>
                 <table border="2">
                               
                               <tr>
                                   <td colspan="6">
                                       <h5><i>Lab Test Report For: <b>${firstname1} ${lastname1}</b> </i></h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td> <input style="width: 60px; height: 35px;" type="submit" value="View" class="btn btn-success" name="viewsymptoms" /></td>
                                    <td>${sview}</td>
                                    <td>${Tdetails}</td>
                                    <td style="text-align: center">Symptoms <textarea name="symptoms" rows="4" cols="19" value ="${sview}" > </textarea>
                                     </td>
                                                          
                                   <td> <input style="width: 60px; height: 35px;" type="submit" value="View" class="btn btn-success" name="viewtests" /></td>
                                     <td style="text-align: center">  Recommended Lab Tests
                                           <textarea name="labtest" rows="3" cols="19" ></textarea>
                                        <br>
                                       Paid (Kshs.): <input type="text" name="tamnt" size= "8" value="${Tamount}"/>
                                       </td>
                                       
                                      
                                       <td style="text-align: center"> Lab Test Results 
                                                                 
                                         <textarea name="labtest" rows="4" cols="19"></textarea>
                                        <br>
                                       
                                       <%--  <td style="text-align: center"> Drugs 
       