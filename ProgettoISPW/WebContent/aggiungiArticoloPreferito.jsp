<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
    <jsp:useBean id="beanArticoliPreferiti" scope="request"   class="bean.BeanModificaArticoliPreferiti" />
    
    <jsp:setProperty name="beanArticoliPreferiti" property="*" />
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Registrazione articolo preferito</title>
</head>
<body>


<!--  http://localhost:8080/ProgettoISPW/aggiungiArticoloPreferito.jsp?id=   -->

<% 
if(session.getAttribute("user")==null)
{
%>	
	<jsp:forward page="index.jsp" />

<%
}
	//boolean myError=false;
	if (request.getParameter("id") != null) 
	{
			try
			{
			beanArticoliPreferiti.aggiungiArticoloPreferito((String)session.getAttribute("user")); 
%>

Articolo aggiunto alla lista desideri

<% 			
			response.setHeader("Refresh", "2;url=index.jsp");
			}
			catch(Exception e)
			{
				out.println(e.getMessage());
				//myError=true;
				%>
				<br>
				<% 
			}
	}
	else
	{
%>		
		<jsp:forward page="index.jsp" />
<% 
	}
%>

</body>
</html>