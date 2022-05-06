<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
<jsp:useBean id="beanModificaPassword" scope="request"   class="bean.BeanUtente" />    
<jsp:useBean id="beanVisualizzaProfilo" scope="session"   class="bean.BeanUtente" />
<jsp:setProperty name="beanModificaPassword" property="password" />
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Modifica password</title>
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
	
	if (request.getParameter("modificaPassword") != null) 
	{
		
		if(!beanModificaPassword.getPassword().equals(request.getParameter("password2")))
		{
			myError=true;
		
%>			Errore le password devono combaciare <br>
	
			
<%    		
		}
		else
		{
			try
			{
			beanModificaPassword.modificaPassword((String)session.getAttribute("user"));
%>

Modifica Password effettuata con successo

<%	
			response.setHeader("Refresh", "2;url=index.jsp");
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
	}
	if(request.getParameter("modificaPassword") == null || myError==true)
	{
%>

La password deve contenere almeno 8 caratteri e massimo 20

<form action="modificaPassword.jsp" name="myform" method="POST">
			
			<table>
			<tr>
				<td>Password:</td>
				<td>
					<input name="password" type="password" id="password">
				</td>
			</tr>
			
			<tr>
				<td>Conferma Password:</td>
				<td>
					<input name="password2" type="password" id="password2">
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<input name="modificaPassword" type="submit" value="Modifica">
				</td>
			</tr>
				
			</table>
			</form>		

<%
	}
%>

</body>
</html>