<%-- 
    Document   : paymentconsultationfee
    Created on : Sep 17, 2019, 8:56:12 AM
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
                                     
    <center><h4><i><center><u>(Accounts Department)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="payforconsultation" method="POST">
                <%--TABLE1: name = "Personal information" --%>
                 <table border="1">
                 <tr height: 30px">
                               <td colspan="8">
                                   <h5><i>Personal Information</i></h5>
                                    </td>
                                </tr>
                             <tr>
                                 <td style="text-align: right">OPD No.:</td>
                                   <td><input type="text" size="10" name="opdno" placeholder="OPD No." value = "${opd}">
                                      <%--<td style="text-align: right"><input type="date"/></td>
                                       <td> <input style="width: 100px; height: 35px;" type="submit" name = "validate" value="Validate" class="btn btn-success" name="searchopd"/></td>--%>
                                       <td></td>
                                       <td></td>
                                       <td></td>
                                       <td style="text-align: right"></td>
                            </tr>
                            <tr>
                                 <td style="text-align: right">Names:</td>
                                 <td><input type="text" size="10" name="First Name" placeholder="First Name" readonly ="readonly" value = "${fname}"/></td>
                                 <td><input type="text" size="10" name="Middle Name" placeholder="Middle Name" readonly ="readonly" value = "${mname}"/></td>
                                 <td><input type="text" size="10" name="Last Name" placeholder="Last Name" readonly ="readonly"  value = "${lname}"/></td>
                                 <td colspan="0" style="text-align: right; width: 25px">Sex: </td>
                                 <td> <input size = "5" type= "text" name="Sex" readonly ="read only" value = "${Sex}"/></td>
                                 <td style="text-align: right">Age:</td>
                                 <td><input type="text" size="10" name="age" placeholder="age" readonly ="readonly" value = "${Age}"/></td>
                            </tr>
                             <tr>
                                 
                                 <td></td>  
                                </tr>
                                <tr>
                                   <td style="text-align: right">Weight:</td>
                                   <td><input type="text" size="10" name="weight" placeholder="Weight" readonly ="readonly" value = "${Weight}"/></td>
                                   <td style="text-align: right">Pressure:</td>
                                   <td><input type="text" size="10" name="bloodpressure" placeholder="Blood_pressure" readonly ="readonly" value = "${BP}"/></td>
                                   <td style="text-align: right">Phone:</td>
                                   <td><input type="text" size="10" name="mobileno" placeholder="Mobile_No." readonly ="readonly" value = "${Mobile}" /></td>
                                   
                                   <td></td>
                                   <td> <a href="Accounts.jsp" <button class="btn btn-success" style="width: 150px; height: 35px;">Next Patient</button></a> </td>
                                   
                               </tr>
                                
                 </table>
                               
        </br>
            <table border="2">              
                               
                 <tr style>
                  
                            </tr>
                               <tr>
                                   <td style="text-align: right">Pay:</td>
                                   
                                      <td> <a href="paymentconsultationfee.jsp"<button style="width: 100px; height: 30px; font-size: 13px" class="btn btn-success">Consultation</button></a></td>
                                      <td> <a href="paymentdrugsfee.jsp"<button style="width: 100px; height: 30px; font-size: 13px" class="btn btn-success">Drugs </button></a></td>
                                      <td> <a href="paymentlabtestfee.jsp"<button style="width: 100px; height: 30px; font-size: 13px" class="btn btn-success">Lab Test </button></a></td>
                                      <td> <a href="paymentsurgicalfee.jsp"<button style="width: 100px; height: 30px; font-size: 13px" class="btn btn-success">Surgical </button></a></td>
                                      <td> <a href="paymentinjectionfee.jsp"<button style="width: 100px; height: 30px; font-size: 13px" class="btn btn-success">Injection </button></a></td>
                                      <td> <a href="paymentmaternintyfee.jsp"<button style="width: 100px; height: 30px; font-size: 13px" class="btn btn-success">Maternity </button></a></td>
                                      <td> <a href="paymentotherfee.jsp"<button style="width: 100px; height: 30px; font-size: 13px" class="btn btn-success">Other </button></a></td>
                               </tr>
                               
                                                         
                             <tr style ="background-color: skyblue">
                                   
                               </tr>
                       </table>
        <br>
           <table border="2">
             
                     <tr height: 30px">
                                    <td colspan="8">
                                        
                             <h5><i>Account Name: <b>${fname} ${mname} ${lname}</b></i></h5>
                                    </td>
                                </tr>
                               <tr>
                                   <td style="text-align: right">Process:</td>
                                   <td><input type="text" size="12" name="consultationfee" value = "Consultation Fee" style = "font-size: 20px; color: red"></td>
                                   <td> <input type="submit" style="width: 50px; height: 35px; font-size: 15px" value="Go" class="btn btn-success" name="searchconsultation"/></td>
                                   <td> <input type="text" name="consultamount" placeholder="Amount" value="${ConsultAmnt}" size="6"/></td>
                                   <td> <input type="submit" style="width: 100px; height: 35px; font-size: 15px" value="Details" class="btn btn-success" name="getconsultdetails"/>
                                </td>
                                   <td style="text-align: right">Payment Mode:</td>
                                   <td><select name="paymethod">
                                           <option>Cash</option>
                                           <option>NHIF</option>
                                           <option>Credit</option>
                                       </select></td>
                                    <td><input style="width: 100px; height: 35px;" type="submit" value="Pay" class="btn btn-success" name="Pay2" /></td>
                               </tr>
                               
                               <tr>
                                   <td></td>
                                   <td></td>
                                   <td></td>
                                   <td></td>
                                   <td></td>
                                   <td></td>
                                   <td></td>
                                   <td><input style="width: 100px; height: 35px;" type="submit" value="Get Receipt" class="btn btn-success" name="printreceipt" /></td>
                               </tr>
                               
                                </table>
                                 
                                 <br>
                                
       </form>
        
        </br> 
         </div>
      </center>
    </body>
</html>
