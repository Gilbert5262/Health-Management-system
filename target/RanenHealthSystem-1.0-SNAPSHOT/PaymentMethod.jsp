<%-- 
    Document   : PaymentMethod
    Created on : Jul 23, 2019, 11:20:52 AM
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
                                     
    <center><h4><i><center><u>(Payment Method Confirmation)</u></center></i></h4></center> 
 <center>  
    <div>
              <form action="paymentmethod" method="POST">
                 <table border="2">
             
                     <tr height: 30px">
                               <td colspan="5">
                             <h5><i><center>Patient Name:</center><marquee> <b> ${firstname} ${middlename} ${lastname}</marquee></b></i></h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: right">OPD No:</td>
                                   <td><input type="text" name="opdno" value="${opdno}" size="10" readonly = "readonly"></td>
                                     <td style="text-align: right">Consultation Fee:</td>
                                   <td><input type="text" name="consultationfee" value="250.0" size="10"></td>
                                  
                                   <td colspan="3">Date:</td>
                                   
                                   </tr>
                             <tr style>
                  <td colspan="5">
                     <h5><i>Payment Method</i></h5>
                        </td>
                            </tr>
                               <tr>
                                   <td style="text-align: right">Payment Mode:</td>
                                   <td><select name="paymethod">
                                           <option>Cash</option>
                                           <option>NHIF</option>
                                           <option>Credit</option>
                                       </select></td>
                                    <td style="text-align: right">Employee_No.:</td>
                                   <td><input type="text" name="employeeno" placeholder="Employee_No." size="10"></td>
                                       
                                      <td><input style="width: 100px; height: 35px;" type="submit" value="Save" class="btn btn-success" name="SavePay"/></td>
                               </tr>
                               
                                                         
                               <tr>
                                   <td style="text-align: right">Employee_Name:</td>
                                   <td><input type="text" class="form-control" name="employeename" placeholder="Employee_Name" disabled="disabled" size="10"></td>
                              
                                   <td style="text-align: right">Employee_ID_No.:</td>
                                   <td><input type="text" name="employeeidno" placeholder="Employee_ID_No." size="10"></td>
                                   <td><a href="VitalsRecord.jsp" <button class="btn btn-success" style="width: 100px; height: 35px;">Back</button></a></td>
                               </tr>
                               
                             <tr>
                                   <td style="text-align: right">Age:</td>
                                   <td><input type="number" name="age" placeholder="age"></td>
                            
                                   <td style="text-align: right">Sex:</td>
                                   <td><input type="radio" name="Sex" value="male" checked="checked"/> Male   <input type="radio" name="Sex" value="female" disabled="disabled"/> Female</td>
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
                             
                <tr>
                 </table>
            
        
        </br> 
              </form>          
               </div>
      </center>
    </body>
</html>