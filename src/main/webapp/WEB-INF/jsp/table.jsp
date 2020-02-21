<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*"  import = "java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	  <!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    
	    <!--<spring:url value="/resources/rehberStyle.css" var="rehberStyle" />
		<link href="${rehberStyle}" rel="stylesheet" />
		-->
		 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	    <link href="rehberStyle.css" rel="stylesheet">
	    <title>Rehber</title>
	</head>
	<body >
	    <header >
	        <h1 >Rehber</h1>
	    </header>
	  
	    
	    <div class="search-box">
    		<form action="display" method="post" class="form" onsubmit="">
		        <input class="search-txt" id="barName" name="searchBarName" placeholder="Name" formaction = "">
		        <a href="#" class="search-btn" style="text-decoration: none;">
		            <i class="fas fa-search"></i>
		        </a>
	        </form>
	    </div>
	    	<form action="addTransfer">
	    		<button type="submit" class="btn2" style="text-decoration: none;">Add New Data</button>
	    	</form>
		    
		    <form action="logout" method="post">
		   		<button  class="btn3" type="submit" >Logout</button>
	    	</form>
    	<div class="divv">
			<form action="update" method="post">
					<label class ="labels">Name</label>
					<input  type="text" class="textBox" name="textName" id="textName" value="${boxName}" >
					<label class ="labels">Email</label>
					<input  type="text" class="textBox" name="textEmail" id = "textEmail" value="${boxEmail}" >
					<button type="submit"  class="btn4" >Update</button>
			</form>	
        </div>
        
	        <table id="rehber" align="center"  >
		        <thead>
		            <tr bgcolor="#333">
		                <th  style="width: 0%;"><font color="#fff">ID</font></th>
		                <th  style="width: 0%;"><font color="#fff">NAME</font></th>
		                <th  style="width: 0%;"><font color="#fff">EMAIL</font></th>
		                <th  style="width: 100%;"><font color="#fff">ACTION</font></th>    
		            </tr>
		        </thead>
		        <TBody>
					<c:forEach items="${listUser}" var="list">
					<tr>
						<td><input readonly name="id" id="id" value="<c:out value="${list.id}"/>"></td>
						<td><input readonly name="name" id="name" value="<c:out value="${list.name}"/>"></td>
						<td><input readonly name="email" id="email" value="<c:out value="${list.email}"/>"></td>
						<td>
							<form action="fill/${list.id}" method="post">
								<input type="submit" style="text-decoration: none; background:#333;" class="edit" value ="Edit">
							</form>
							<form action="delete/${list.id}" method="post">
    							<input type="submit" style="text-decoration: none; background: rgb(163, 2, 2);" class="edit"value="Delete">
							</form>
						</td>
					</tr>
					</c:forEach>
		        </TBody>
	    	</table>
   	 	<!-- </form>  -->	
   	 	<script>
 		$( document ).ready(function() {

 			var nameArray = new Array();
 			
 			<c:forEach var="row" items="${listName}">
 				nameArray.push('${row}');
 			</c:forEach>
			$( function() {
			   
			    $( "#barName" ).autocomplete({
			      source: nameArray,
			      messages: {
			          noResults: '',
			          results: function(amount) {
			              return  ''
			          }
			      } 
			    });
			  } );
			
 		});		
 		</script>
	</body>
	</html>
		
		
