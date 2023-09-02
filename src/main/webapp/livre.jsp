<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    %>

<%@ page import="model.bo.Livre"   %>
<%@ page import= "java.util.Vector"   %>
<%@ page import= "mdel.dao.DAOExemplaire"   %>
    
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
<div class="panel-heading">Saisire Un Livre </div>
<div class="panel-body"> 

 <form  class="form-inline"  action="AJouter.do">  

    <div class="form-group">
      <label> ISBN:</label><br>
      <input type="text" class="form-control" id="isbn" placeholder="Enter ISBN" name="isbn">
    </div><br/><br>
    
    <div class="form-group">
      <label > Titre:</label><br>
      <input type="text" class="form-control" id="titre" placeholder="Enter titre" name="titre">
    </div><br/><br>
    
     <div class="form-group">
      <label > Category:</label><br>
      <input type="text" class="form-control" id="cat" placeholder="Enter Category" name="cat">
    </div><br><br><br>
    
    <input type="submit" class="btn btn-primary"" value="AJouter" /> <br><br>
   
  </form> <br>
    
 </div> 
 </div>
 </div>
 </div>
<div class="container col-md-7">    
    
 <form  class="form-inline"  action="Recherche.do">  

    <div class="form-group">

     <div class="form-group" style="margin: 20px;">
      <label >Enter Category:</label>
      <input type="text" class="form-control" id="catR" name="catR">
    </div>
    
    <input type="submit" class="btn btn-primary"" value="Recherche" /> <br><br>
   
 </form> <br>
    
 </div> 
 
  <div class="container">          
  <table class="table table-striped" id="messages" border="1">
    <thead>
      <tr >
        <th>ISBN</th>
        <th>Title</th>
        <th>Category</th>
         <th>Exemplaire</th>
         <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <% DAOExemplaire exp = new DAOExemplaire(); %>
    <% Vector<Livre> listlivre = (Vector<Livre>) request.getAttribute("listlivre");%>
          <% if(listlivre != null ) { for( Livre l : listlivre ) { %>
                <tr>
                    <td> <%= l.getIsbn()%> </td>
                    <td>  <%= l.getTitre() %></td>
                    <td>  <%= l.getCategory() %></td>
                     <td>  <%= exp.getnumberExemplaire(l)+" Disponible"%></td>
                     <td ><a Onclick="return confirm('Etes Vous Sure ?')" href="delete.do?id=<%= l.getIsbn()%>">Supprimer</a></td>
                     <td><a href="Edit.do?id=<%= l.getIsbn()%>">Modifier</a></td>
                </tr>
          <% }  
          
               }%>
    </tbody>
  </table>
</div>
      
    
    </body>
</html>



