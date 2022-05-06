<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"
    %>
    
<jsp:useBean id="beanModificaProfilo" scope="request"   class="bean.BeanUtente" />

<jsp:useBean id="beanVisualizzaProfilo" scope="session"   class="bean.BeanUtente" />

<jsp:setProperty name="beanModificaProfilo" property="*" />    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Modifica Profilo</title>
</head>
<body>

<% 
if(session.getAttribute("user")==null)
{
%>	
	<jsp:forward page="sessioneScaduta.jsp" />
<% 
}

boolean myError=false;

	if (request.getParameter("modificaProfilo") != null) 
	{
		beanModificaProfilo.setPassword(beanVisualizzaProfilo.getPassword());
		beanModificaProfilo.setUsername((String)session.getAttribute("user"));
		try
		{
			
		
			beanModificaProfilo.modificaProfilo((String)session.getAttribute("user"));
			/*if(!beanModificaProfilo.getUsername().equals(session.getAttribute("user")))
			{
				session.setAttribute("user", beanModificaProfilo.getUsername());
			}*/
			response.setHeader("Refresh", "2;url=index.jsp");
%>			
			Modifica Profilo effettuata con successo
<% 			
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
%>
			
			
<%    		
	}
	if(request.getParameter("modificaProfilo") == null || myError==true)
	{
%>
		

			
			<form action="modificaProfilo.jsp" name="myform" method="POST">
			
			<table>
			<!--
			<tr>
			  	<td>Username:</td>
				<td>
					<input name="username" type="text" id="username"
					value="<jsp:getProperty property="username" name="beanVisualizzaProfilo"/>">
				</td>
			</tr>  
			-->
			<tr>
				<td>Nome:</td>
				<td>
					<input name="nome" type="text" id="nome"
					value="<jsp:getProperty property="nome" name="beanVisualizzaProfilo"/>">
				</td>
			</tr>
			<tr>
				<td>Cognome:</td>
				<td>
					<input name="cognome" type="text" id="cognome" 
					value="<jsp:getProperty property="cognome" name="beanVisualizzaProfilo"/>"  >
				</td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td>
					<input name="email" type="text" id="email"
					value="<jsp:getProperty property="email" name="beanVisualizzaProfilo"/>"	>
				</td>
			</tr>
			<tr>
				<td>Numero di telefono:</td>
				<td>
					<input name="numeroTelefono" type="text" id="numeroTelefono"
					value="<jsp:getProperty property="numeroTelefono" name="beanVisualizzaProfilo"/>"	>
				</td>
			</tr>
			<tr>
				<td>Indirizzo:</td>
				<td>
					<input name="indirizzo" type="text" id="indirizzo"
					value="<jsp:getProperty property="indirizzo" name="beanVisualizzaProfilo"/>"	>
				</td>
			</tr>									
			<tr>
				<td colspan=2 align="center">
					<input name="modificaProfilo" type="submit" value="modificaProfilo">
				</td>
			</tr>
				
			</table>
			</form>			
<%
	}
%>
</body>
</html>