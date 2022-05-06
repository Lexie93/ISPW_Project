<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"
    %>
    
    <jsp:useBean id="beanLogin" scope="request"   class="bean.BeanLogin" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto loginBean -->
<jsp:setProperty name="beanLogin" property="*" />
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Pagina login</title>
</head>
<body>

<% 
if(session.getAttribute("user")!=null)
{
%>	
	<jsp:forward page="index.jsp" />

<%
}
	boolean myError=false;
	if (request.getParameter("login") != null) 
	{
			try
			{
			beanLogin.validate(); 
			session.setAttribute("user", beanLogin.getUsername());
%>

Login effettuato

<% 			
			response.setHeader("Refresh", "2;url=index.jsp");
			}
			catch(Exception e)
			{
				out.println(e.getMessage());
				myError=true;
				%>
				<br>
				<% 
			}
	}
	if (request.getParameter("login") == null || myError)
	{
%>
		

			
			<form action="login.jsp" name="myform" method="POST">
			
			<table>
			<tr>
				<td>Username:</td>
				<td>
					<input name="username" type="text" id="username">
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>
					<input name="password" type="password" id="password">
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<input name="login" type="submit" value="login">
				</td>
			</tr>	
			</table>
			</form>
<%
	}
%>
</body>
</html>