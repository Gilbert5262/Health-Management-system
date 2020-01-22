<%-- 
    Document   : Pharmacy
    Created on : Jun 25, 2019, 2:20:16 PM
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
                                     
    <center><h4><i><center><u>(Pharmacy)</u></center></i></h4></center> 
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
                                    <td style="text-align: center">Symptoms <br><textarea name="symptoms" rows="4" cols="19" placeholder="Type_here" disabled="disabled"> </textarea>
                                     </td>
                                                          
                                    <td style="text-align: center">  Lab Tests Results
                                           
                                        <br><textarea name="labtest" rows="3" cols="19" disabled="disabled"></textarea>
                                        <br>
                                       Paid (Kshs.): <input type="text" name="tamnt" size= "8" placeholder="Kshs" disabled="disabled"/>
                                       </td>
                                          <td style="text-align: center"> Recommended Drugs
                                                                 
                                           <br><textarea name="labtest" rows="4" cols="19"></textarea>
                                        <br>
                                       
                                       <%--  <td style="text-align: center"> Drugs 
                                            <br> Code: <input type="text" name="tamnt" size= "4" placeholder="Code"/>                     
                                        <br style="height: 15px">
                                        <br>
                                        <textarea name="labtest" rows="3" cols="19" disabled="disabled"></textarea>
                                        <br>
                                       Amnt (Kshs.): <input type="text" name="tamnt" size= "4" placeholder="Kshs" disabled="disabled"/> --%>
                                                                              
                                        <td><input style="width: 100px; height: 35px;" type="submit" value="Administer" class="btn btn-success" name="Administer" /></td> 
                               </tr>
                               
                                                         
                              
                               
                               <tr style ="background-color: skyblue">
                                   
                               </tr>
                       </table>
                   </form>
               </div>
      </center>
    </body>
</html>