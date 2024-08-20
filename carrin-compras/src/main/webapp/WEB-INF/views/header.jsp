<%@page import="org.com.br.vo.Login"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
    <head>
	<title>Login</title>
	<meta charset="utf-8" lang="pt-br">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/shopping/pastaCSSJS/css/bootstrap.min.css" crossorigin="anonymous" /> 
	<link href="/shopping/pastaCSSJS/css/app.css" rel="stylesheet">
	<link rel="stylesheet" href="/shopping/pastaCSSJS/css/css_login.css" />
	<script src="/shopping/js/app.js"></script>
	<script src="/shopping/pastaCSSJS/js/bootstrap.min.js"  crossorigin="anonymous"></script> 
	<script src="/shopping/pastaCSSJS/js/jquery.min.js" crossorigin="anonymous"></script>
</head>

<body>
	<section>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <ul class="navbar-nav">
		    <li class="nav-item">
		      <a class="nav-link" href="home">Home</a>
		    </li>
        <%
        //allow access only if session exists
            Login user = (Login) session.getAttribute("user");
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>

			<c:if test="${user.getUser_type().equalsIgnoreCase('admin')}">
			    <li class="nav-item">
			      <a class="nav-link" href="products">Products</a>
			    </li>
			</c:if>
					    	
		    <li class="nav-item">
		      <a class="nav-link" href=kart>Kart</a>
		    </li>		    
		    <li class="nav-item">
		      <a class="nav-link" href=order>Order</a>
		    </li>		    
		    <li class="nav-item active">
		      <a class="nav-link" href="login">Login</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="logout">Logout</a>
		    </li>
		    
		  </ul>
		</nav>
	</section>
	<p style="color:red"> Usuário Logado : ${user.getEmail()} , type : ${user.getUser_type()} </p>	
