<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ page import="model.bo.Livre"   %>
<%@ page import= "java.util.Vector"   %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Update Livre here</title>
</head>
<body>
<div class="container col-md-7 " style="margin: 30px;">      
<div class="panel panel-primary">  
<div class="panel-heading">Modifier Un Livre </div>
<div class="panel-body"> 



 <form  class="form-inline"  action="update.do" method="POST"> 
 
    
    <% Livre lv =(Livre)request.getAttribute("livre"); %>
    

    <div class="form-group">
    
    <label> ISBN:</label><br>
      <input type="text" class="form-control" id="isbn"  name="isbn"  value= <%=lv.getIsbn() %> readonly>
    </div><br/><br>
    
    <div class="form-group">
      <label > Titre:</label><br>
      <input type="text" class="form-control" id="titre" name="titre" value= <%=lv.getTitre() %> >
    </div><br/><br>
    
     <div class="form-group">
      <label > Category:</label><br>
      <input type="text" class="form-control" id="cat" name="cat"  value= <%=lv.getCategory() %>>
    </div><br><br><br>
    
    <input type="submit" class="btn btn-primary"" value="Modifier" /> <br><br>
   
    </form> <br>
    
 </div> 
 </div>
 </div>
 
    
 

</body>
</html>