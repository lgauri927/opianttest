<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ArithmeticExpression</title>
<link rel="stylesheet" href="/css/custom.css">
 
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
 <script src="jquery-3.2.1.js"></script> 
 <script>
 function madeAjaxCall(){
	 
	 $.ajax({
	        type: "get",
	      //  url: "http://localhost:8080/SpringExamples/employee/add.htm",
	        cache: false,    
	        data:'userInput=' + $("#userInput").val(),
	        success: function(response){
	         $('#result').html("");
	         var obj = JSON.parse(response);
	         $('#result').html(obj.output);
	        },
	        error: function(){      
	         alert('Error while request..');
	        }
	       });
	      }
 /* $(document).ready(function() { 
     $("#submitbtn").click(function() { 
         var input = $("#userInput").val(); 
         $.get(, { 
        	 userInput: input 
         }, function(data) { 
             $("#msg").html(data); 
         }); 

     }); 
 });  */
 
 
	function validateExpr(exp) {
		var arr = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')',
				'+', '-', '/', '*' ];
		var chars = exp.split("");
		//alert(chars);
		for (i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				var flag = false;
				for (j = 0; j < arr.length; j++) {
					if (arr[j] == chars[i]) {
						flag = true;
						break;
					}
				}
				if (flag == false)
					return false;
			}
		}
		return true;

	}
	function validate() {
		var userInput = document.getElementById("userInput").value;
				
		if(!validateExpr(userInput)){
			alert("Please enter valid Expression...");
			return false;
		}
		else{
			return true;
		}		
		
		
	}
</script>
</head>
<body>


	<div class="center">
		<h2>Arithmetic Expression Evaluation</h2>
		<form:form method="post" name="expre" modelAttribute="expression" action="main" >
			Input Expression : <form:input type="text" name="input" path="input" id="userInput" />
			<%-- <form:hidden  name="output" path="output" id="userOutput" /> --%>
			<br> <input type="submit" class="button" value="Submit"
				onclick="return validate()" id="submitbtn"/><br> <br> 
				<%-- <b> Result :${output}..!</b>  --%>
				<div id="result" > <b> Result :${output}..!</b> </div>  

		</form:form>
		

	</div>
</body>
</html>


