<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<%@ include file="Menu.jsp" %>
<div style="margin: 20px;">
<div class="container col-md-10 ">      
<div class="panel panel-primary">  
<div class="panel-heading">Emprunter Un Livre </div>
<div class="panel-body"> 

 <form class="form-horizontal"  action="emprunter.do">  

    <div class="form-group">
      <label  class="control-label col-sm-2" > Code Exemplaire:</label>
      <div class="col-sm-7">
      <input type="text" class="form-control" id="exmpl" name="exmpl">
       </div>
    </div><br/>
    
    <div class="form-group">
      <label  class="control-label col-sm-2" > CIN Adherent : </label>
      <div class="col-sm-7">
     
      <input type="text" class="form-control" id="cin"  name="cin">
      </div> 
    </div><br/><br>
    
    <div class="form-group">
      <label  class="control-label col-sm-2" > Date : </label>
      <div class="col-sm-7">
     
      <input type="text" class="form-control" id="date"  name="date">
      </div> 
    </div><br/><br>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-7">
        <input type="submit" class="btn btn-primary"" value="Emprunter" />
      </div>
    </div>
       
 </form> <br>
 
 
    
 </div> 
 </div>
 </div>
 </div>

</body>
</html>