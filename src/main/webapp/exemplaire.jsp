<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 %>
 
<%@ page import="model.bo.Exemplaire"   %>
<%@ page import= "java.util.Vector"   %>



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
<div class="container col-md-7 ">      
<div class="panel panel-primary">  
<div class="panel-heading">Saisire Un Exemplaire </div>
<div class="panel-body"> 

 <form  class="form-inline"  action="AjouterExmpl.do">  

    <div class="form-group">
      <label> Ref :</label><br>
      <input type="text" class="form-control" id="ref" placeholder="Enter Réference" name="ref">
    </div><br/><br>
    
    <div class="form-group">
      <label> ISBN: </label><br>
      <input type="text" class="form-control" id="isbn" placeholder="Enter ISBN" name="isbn">
    </div><br/><br>
    
    <input type="submit" class="btn btn-primary"" value="AJouter ExemplaireS" /> <br><br>
   
  </form> <br>
    
 </div> 
 </div>
 </div>
 </div>
 
 <div class="container col-md-7">    
    
 <form  class="form-inline"  action="RechercheExmpl.do">  

    <div class="form-group">

     <div class="form-group" style="margin: 20px;">
      <label >Enter ISBN:</label>
      <input type="text" class="form-control" id="isbnr" name="isbnr">
    </div>
    
    <input type="submit" class="btn btn-primary"" value="Rechercher" /> <br><br>
   
 </form> <br>
    
 </div> 
 
 
  <div class="container">          
  <table class="table table-striped" id="messages" border="1">
    <thead>
      <tr >
        <th>Reference</th>
        <th>ISBN</th>
        <th>Etat</th>
        <th> Delete</th>
      </tr>
    </thead>
    <tbody>  
    <% Vector<Exemplaire> listexmp = (Vector<Exemplaire>) request.getAttribute("listexmp");%>
          <% if(listexmp != null ) { for( Exemplaire E : listexmp ) { %>
                <tr>
                    <td> <%= E.getNoexp() %> </td>
                    <td>  <%= E.getLivres().getIsbn() %></td>
                     <% String Etat; if(E.getEtat())Etat = "Non Disponible"; else Etat="Disponible"; // Attention Prob Pour les Infoghrapique  %>
                     <td> <%= Etat %></td>
                   <td ><a Onclick="return confirm('Etes Vous Sure ?')" href="deleteExmp.do?id=<%= E.getNoexp() %>">Supprimer</a></td>
                     
                </tr>
          <% }}%>
             
    </tbody>
  </table>
</div>
   
</body>
</html>



