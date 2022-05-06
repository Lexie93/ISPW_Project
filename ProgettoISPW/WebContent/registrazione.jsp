<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"
    %>
    
<jsp:useBean id="beanRegistrazione" scope="request"   class="bean.BeanUtente" />

<jsp:setProperty name="beanRegistrazione" property="*" />
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Registrazione utente</title>
</head>
<body>

<%
	boolean myError=false;

	if (request.getParameter("registrazione") != null) 
	{
		try{
			beanRegistrazione.registrazione();
		
%>
			Registrazione Effettuata con successo
			
<%    		response.setHeader("Refresh", "3;url=index.jsp");
			}
		catch(Exception e)
		{
			myError=true;
			%>				
							<%  
							out.println(e.getMessage());
							%>
							<br>
							<%	
		}
		
	}
	if(request.getParameter("registrazione") == null || myError==true)
	{
%>
		

			
			<form action="registrazione.jsp" name="myform" method="POST">
			
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
				<td>Nome:</td>
				<td>
					<input name="nome" type="text" id="nome">
				</td>
			</tr>
			<tr>
				<td>Cognome:</td>
				<td>
					<input name="cognome" type="text" id="cognome">
				</td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td>
					<input name="email" type="text" id="email">
				</td>
			</tr>
			<tr>
				<td>Numero di telefono:</td>
				<td>
					<input name="numeroTelefono" type="text" id="numeroTelefono">
				</td>
			</tr>
			<tr>
				<td>Indirizzo:</td>
				<td>
					<input name="indirizzo" type="text" id="indirizzo">
				</td>
			</tr>									
			<tr>
				<td colspan=2 align="center">
					<input name="registrazione" type="submit" value="registrazione">
				</td>
			</tr>
			
				
			</table>
			</form>

	<% } %>


</body>
</html>