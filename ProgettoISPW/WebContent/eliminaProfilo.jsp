<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
    <jsp:useBean id="beanEliminaProfilo" scope="request"   class="bean.BeanUtente" />
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Eliminazione profilo</title>
</head>
<body>

<%
if (request.getParameter("submit") != null) 
{
	if(request.getParameter("submit").equals("conferma"))
		{
			beanEliminaProfilo.eliminaProfilo((String)session.getAttribute("user"));
			session.invalidate();
			response.setHeader("Refresh", "2;url=index.jsp");
%>

account eliminato

<% 			
		}
	else		
	{
		response.setHeader("Refresh", "2;url=visualizzaProfilo.jsp");
%>

Operazione annullata , redirezione alla pagina del profilo

<%	
	}
}
else
{

%>
<form action="eliminaProfilo.jsp" name="myform" method="POST">

Vuoi davvero eliminare il tuo profilo?

<input name="submit" value='conferma' type="submit">
<input name="submit" value='annulla' type="submit">
</form>

<%
}
%>
</body>
</html>