<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
    <!--jsp:useBean id="beanLogin" scope="request"   class="bean.BeanLogin" /-->
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>L' ennessimo sito di vendite</title>
</head>
<body>

<%  
	//if(beanLogin.isValid())
		if(session.getAttribute("user")!=null)
	{
%>
Benvenuto ${sessionScope.user}

<br>

puoi eseguire le seguenti operazioni <br>

<a  href="logout.jsp">Effettua il Logout  </a>   <br>
<a  href="visualizzaProfilo.jsp">Visualizza il profilo  </a> <br>
<a  href="cercaAnnunci.jsp">Ricerca annunci</a> <br>
<a  href="creaAnnuncio.jsp">Crea Annuncio</a> <br>
<a  href="propriAnnunci.jsp">Visualizza i tuoi annunci</a> <br>
<a  href="visualizzaArticoliPreferiti.jsp">Visualizza articoli nella lista desideri</a> 

<% }
	else
	{
%>
Benvenuto utente anonimo <br>
<a  href="login.jsp">Effettua il Login  </a>  <br>
<a  href="registrazione.jsp">Registrati  </a> <br>
<a  href="cercaAnnunci.jsp">Ricerca annunci</a> <br>


<%   }%>
</body>
</html>