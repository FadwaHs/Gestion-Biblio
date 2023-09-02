<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
    background-color: #f9f9f9;
    font-family: Arial, sans-serif;
  }
  
  .panel {
    margin-top: 50px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.3);
  }
  
  .panel-heading {
    background-color: #2196f3;
    color: #fff;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    font-size: 24px;
    font-weight: bold;
    padding: 20px;
  }
  
  .panel-body {
    padding: 20px;
  }
  
  .form-group {
    margin-bottom: 20px;
  }
  
  label {
    font-weight: bold;
    color: #333;
  }
  
  input[type="email"],
  input[type="password"] {
    border-radius: 4px;
    border: 1px solid #ccc;
    box-sizing: border-box;
    font-size: 16px;
    padding: 10px;
    width: 100%;
  }
  
  input[type="submit"] {
    background-color: #2196f3;
    border-radius: 4px;
    border: none;
    color: #fff;
    font-size: 16px;
    font-weight: bold;
    padding: 10px 20px;
    text-transform: uppercase;
    transition: background-color 0.3s ease;
  }
  
  input[type="submit"]:hover {
    background-color: #0d8bf2;
  }
  
  
</style>
<title>Insert title here</title>
</head>
<body>


<div class="container col-md-7 ">      
<div class="panel panel-primary">  
<div class="panel-heading">Admin</div>
<div class="panel-body"> 

 <form  class="form-inline"  action="login.do" >  

    <div class="form-group">
      <label>Email</label><br><br>
      <input type="email" class="form-control" id="email"name="email">
    </div><br/><br>
    
    <div class="form-group">
      <label > Password</label><br><br>
      <input type="password" class="form-control" id="pass" name=pass>
    </div><br/><br>
    
    
    <input type="submit" class="btn btn-primary"" value="Login" /> <br><br>
   
    </form> <br>
    
 </div> 
 </div>
 </div>
    
 </div> 
 </div>
 </div>
 

</body>
</html>

