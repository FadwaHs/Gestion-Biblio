<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    %>

<%@ page import="model.bo.Adherent"   %>
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
<div class="panel-heading">Saisire Un nouveau Adherent </div>
<div class="panel-body"> 

 <form  class="form-inline"  action="AJouterAD.do">  

    <div class="form-group">
    <label> CIN:</label><br>
      <input type="text" class="form-control" id="cin" placeholder="Enter CIN" name="cin">
    </div><br/><br>
    
    <div class="form-group">
      <label > Name :</label><br>
      <input type="text" class="form-control" id="nom" placeholder="Enter Name" name="nom">
    </div><br/><br>
    
     <div class="form-group">
      <label > Prenom :</label><br>
      <input type="text" class="form-control" id="pr" placeholder="Enter Prenom" name="pr">
    </div><br/><br>
    
    <div class="form-group">
      <label > Telephone :</label><br>
      <input type="text" class="form-control" id="tele" placeholder="Enter NUmero Tele" name="tele">
    </div><br/><br>
    
     <div class="form-group">
      <label > Mot de Pass :</label><br>
      <input type="password" class="form-control" id="ps" name="ps">
    </div><br><br><br>
    
    <input type="submit" class="btn btn-primary"" value="AJouter Adherent" /> <br><br>
   
  </form> <br>
    
 </div> 
 </div>
 </div>
 </div>
<div class="container col-md-7">    
    
 <form  class="form-inline"  action="RechercheAdr.do">  

    <div class="form-group">

     <div class="form-group" style="margin: 20px;">
      <label >Enter CIN:</label>
      <input type="text" class="form-control" id="cinR" name="cinR">
    </div>
    
    <input type="submit" class="btn btn-primary"" value="Rechercher" /> <br><br>
   
 </form> <br>
    
 </div> 
 
  <div class="container">          
  <table class="table table-striped" id="messages" border="1">
    <thead>
      <tr >
      
        <th>CIN</th>
        <th>Non Complet </th>
        <th>Tele</th>
         <th>Number Emprunte</th>
         <th></th>
         <th></th>
      </tr>
    </thead>
    <tbody>
     <% DAOExemplaire exp = new DAOExemplaire(); %>
    <% Vector<Adherent> listAd = (Vector<Adherent>) request.getAttribute("listAd");%>
          <% if(listAd != null ) { for( Adherent A : listAd ) { %>
                <tr>
                    <td> <%=  A.getCin() %> </td>
                    <td>  <%= A.getNom()+" "+A.getPrenom() %></td>
                    <td>  <%= A.getTele() %></td>
                    <td>  <%= exp.getnumberExemplaireA(A)%> </td>
                     <td ><a Onclick="return confirm('Etes Vous Sure ?')" href="deleteA.do?id=<%= A.getCin() %>">Supprimer</a></td>
                     <td><a href="EditA.do?id=<%=  A.getCin() %>">Modifier</a></td>
                </tr>
          <% } }%>

    </tbody>
  </table>
</div>
      
    </body>
</html>



