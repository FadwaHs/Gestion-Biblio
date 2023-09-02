<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome to our Library</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6 text-center">
        <h1>Welcome to our Library</h1>
        <p class="lead">Please select your space:</p>
        <form   action="test.do">
          <div class="row">
            <div class="col-sm-6 mb-3">
              <input class="btn btn-primary btn-lg btn-block" type="submit"  name="admin"  value="admin" /> 
            </div>
            <div class="col-sm-6 mb-3">
               <input  class="btn btn-success btn-lg btn-block" type="submit" name="client" value="client" /> 
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    