<%-- 
    Document   : In_Patient
    Created on : Jun 26, 2019, 10:31:44 AM
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
                                     
    <center><h4><i><center><u>(In-Patient Examination)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="register" method="POST">
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
                                       <td style="text-align: right"><input type="date"/></td>
                                       <td> <input style="width: 100px; height: 35px;" type="submit" name = "validate" value="Validate" class="btn btn-success" name="searchopd"/></td>
                                       <td></td>
                                       <td></td>
                                       <td></td>
                                       <td style="text-align: right"></td>
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
                                   <td> <a href="index.jsp" <button class="btn btn-success" style="width: 150px; height: 35px;">Logout</button></a> </td>
                                   
                               </tr>
                                
                 </table>
                  <br>
                 <table border="2">
                               
                               <tr>
                                   <td colspan="5">
                                       <h5><i>Medical Examination Report</i></h5>
                                    </td>
                                </tr>
                                <tr>
                                     <td style="text-align: center">Symptoms <textarea name="symptoms" rows="5" cols="19" placeholder="Type_here"> </textarea>
                                     </td>
                                                          
                                    <td style="text-align: center">   Lab Tests
                                        <select name="labtests">
                                            <option>Select Lab Test</option>
                                            <option>None</option>
                                            <option>Full Haemogramme</option>
                                            <option>Liver Function Test</option>
                                            <option>Kidney Function Test</option>
                                            <option>Lipid Profile</option>
                                            <option>Salmonella Antigen Test</option>
                                            <option>H. Pylori Test</option>
                                            <option>Brucella Test</option>
                                            <option>Rheumatoid Factor</option>
                                            <option>Pregnancy Test</option>
                                            <option>BS for MPS</option>
                                            <option>Blood Glucose</option>
                                            <option>Haemoglobin Test</option>
                                            <option>VDRL</option>
                                            <option>Blood Grouping</option>
                                            <option>Urinalysis</option>
                                            <option>Stool for O/C</option>
                                            <option>Hepatitis B Surface AG Test</option>
                                            <option>MRDT</option>
                                            <option>ANC Profile</option>
                                        </select>                                        
                                        <br style="height: 10px">
                                        <textarea name="labtest" rows="3" cols="19" disabled="disabled"></textarea>
                                        <br>
                                       Amnt (Kshs.): <input type="text" name="tamnt" size= "8" placeholder="Kshs" disabled="disabled"/>
                                       </td>
                                       
                                       <td style="text-align: center"> Injections 
                                            <select name="injections">
                                                <option>Number of Injections</option>
                                            <option>None</option>
                                            <option>One</option>
                                            <option>Two</option>
                                            <option>Three</option>
                                            <option>Four</option>
                                            <option>Five</option>
                                        </select>                                        
                                        <br style="height: 10px">
                                        <textarea name="labtest" rows="3" cols="19"></textarea>
                                        <br>
                                       Amnt (Kshs.): <input type="text" name="tamnt" size= "4" placeholder="Kshs" disabled="disabled"/>
                                       </td> 
                                       
                                        <td style="text-align: center"> Drugs 
                                            <br> Code: <input type="text" name="tamnt" size= "4" placeholder="Code"/>                     
                                        <br style="height: 15px">
                                        <br>
                                        <textarea name="labtest" rows="3" cols="19" disabled="disabled"></textarea>
                                        <br>
                                       Amnt (Kshs.): <input type="text" name="tamnt" size= "4" placeholder="Kshs" disabled="disabled"/>
                                                                              
                                        <td><input type="submit" style="width: 100px; height: 40px;" value="List_Drugs" class="btn btn-success" name="addlabtest"/><br><br><input style="width: 100px; height: 35px;" type="submit" value="Save" class="btn btn-success" name="saveform" /></td> 
                               </tr>
                               
                                                         
                               <tr>
                                   
                                   <td>
                                       <input type="submit" style="width: 75px; height: 35px;" value="Delete" class="btn btn-success" name="delsy"/>
                                <input type="submit" style="width: 75px; height: 35px;" value="Save" class="btn btn-success" name="savesym"/>
                                   </td>
                                   <td> <input type="submit" style="width: 45px; height: 35px;" value="Add" class="btn btn-success" name="addlabtest"/>
                                       <input type="submit" style="width: 45px; height: 35px;" value="Del" class="btn btn-success" name="dellabtest"/>
                                        <input type="submit" style="width: 80px; height: 35px;" value="Send" class="btn btn-success" name="sendlabtest"/>
                                   </td>
                                   
                                   <td> <input type="submit" style="width: 45px; height: 35px;" value="Add" class="btn btn-success" name="addlabtest"/>
                                       <input type="submit" style="width: 45px; height: 35px;" value="Del" class="btn btn-success" name="dellabtest"/>
                                        <input type="submit" style="width: 80px; height: 35px;" value="Send" class="btn btn-success" name="sendlabtest"/>
                                   </td>
                                   
                    