<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    %>

<%@ page import="model.bo.Livre"   %>
<%@ page import= "mdel.dao.DAOExemplaire"   %>
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

<div class="container col-md-7">    
    
 <form  class="form-inline"  action="RechercheCl.do">  

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
       
      </tr>
    </thead>
    <tbody>
   
     <% DAOExemplaire exp = new DAOExemplaire(); %>
      <% Vector<Livre> listlivre = (Vector<Livre>) request.getAttribute("listlivre");
        Vector<Livre> listlivrecat = (Vector<Livre>) request.getAttribute("listlivrecat");%>
        
          <% if(listlivre != null ) { for( Livre l : listlivre ) { %>
                <tr>
                    <td> <%= l.getIsbn()%> </td>
                    <td>  <%= l.getTitre() %></td>
                    <td>  <%= l.getCategory() %></td>
                     <td>  <%= exp.getnumberExemplaire(l)+" Disponible"%></td>
 
                </tr>
          <% }  
          
               }%>
    </tbody>
  </table>
</div>
      
    
    </body>
</html>



