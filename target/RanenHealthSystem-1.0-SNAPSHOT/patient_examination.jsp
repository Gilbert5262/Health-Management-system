<%-- 
    Document   : patient_examination
    Created on : Jun 24, 2019, 10:47:00 AM
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
                                     
    <center><h4><i><center><u>(Out-Patient Examination)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="patientexamination" method="POST">
                  
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
                                   <td> <input style=" height: 35px;" type="submit" value="Medical History" class="btn btn-success" name= "medhistory"/> </td>
                                   
                               </tr>
                                
                 </table>
                  <br>
                  
                  
                  
<%--TABLE2: name = "Symptoms table" --%>

 <table border="2">
                               
                               <tr>
                                   <td colspan="9">
                                       <h5><i>Medical Examination Report: (A) Disease Symptoms</i></h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                      <td style="text-align: right" colspan="2">Symptoms::</td>
                                      <td></td>
                                    <td style="text-align: center"></td>
                                       <td style="text-align: center"></td>
                                                                       
                                </tr>
                                
                                
                                <tr>
                                    <td></td>
                                    <td style="text-align: right"> 
                                    
                                    </td> 
                                    <td>
                                    <td style="text-align: center" colspan="4"> <textarea name="symptoms" rows="5" cols="50" value ="${symptoms}"> </textarea>
                                        
                                    </td>
                                   
                                    <td style="text-align: right"><input type="submit" style="width: 70px; height: 35px; font-size: 15px" value="Save" class="btn btn-success" name="savesymptoms"/></td> 
                                    
                                </tr>
                                
                                <tr>
                                    <td></td>
                                    
                                     <td style="text-align: right"></td> 
                                     <td></td>
                                     <td> <a href="patientlab.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Lab</button></a></td>
                                     <td> <a href="patientinjection.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Injections</button></a></td>
                                     <td> <a href="patientdrugs.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Drugs</button></a></td>
                                     <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Admission</button></a></td>
                                     <td> <a href="index.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Logout</button></a></td>
                                    <td>
                                    </td>
                                      </tr>
                             
                 </table>
                 </form>
               </div>
      </center>
    </body>
</html>

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     <br>
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
                                   
                                   <td> <input type="submit" style="width: 45px; height: 35px;" value="Add" class="btn btn-success" name="addlabtest"/>
                                       <input type="submit" style="width: 45px; height: 35px;" value="Del" class="btn btn-success" name="dellabtest"/>
                                        <input type="submit" style="width: 80px; height: 35px;" value="Send" class="btn btn-success" name="sendlabtest"/>
                                   </td>
                               </tr>
                               
                               
                               <tr style ="background-color: skyblue">
                                   
                               </tr>
                       </table>
                   </form>
               </div>
      </center>
    </body>
</html>

