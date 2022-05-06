<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<!--  jsp:useBean id="beanLogin" scope="session"   class="bean.BeanLogin" /-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Logout effettuato</title>
</head>
<body>
Logout effettuato
<%   
session.invalidate();
response.setHeader("Refresh", "3;url=index.jsp");
%>



</body>
</html>