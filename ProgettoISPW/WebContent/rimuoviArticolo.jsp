<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
    <jsp:useBean id="beanArticolo" scope="request"   class="bean.BeanArticolo" />
    
    <jsp:setProperty name="beanArticolo" property="*" />
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Rimozione Annuncio</title>
</head>
<body>
<%if (request.getParameter("ID") != null) 
	{
		
			try
			{
			beanArticolo.rimuoviArticolo(); 
%>

<p>Annuncio eliminato</p>

<% 			
			response.setHeader("Refresh", "2;url=index.jsp");
			}
			catch(Exception e)
			{
				out.println(e.getMessage());
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