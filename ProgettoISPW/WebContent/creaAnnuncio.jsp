<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    

<jsp:useBean id="BeanArticolo" scope="request"  class="bean.BeanArticolo" />
<jsp:setProperty name="BeanArticolo" property="*" />

<%
	boolean errore=false;
	if(request.getParameter("CreaAnnuncio")!=null){
		try{
	BeanArticolo.setVenditore((String)session.getAttribute("user"));
	//if (request.getParameter("nome")!= null && request.getParameter("descrizione")!=null && request.getParameter("prezzo")!=null) {
		BeanArticolo.creaArticolo();
	//}
	} catch (Exception e){
		errore=true;
		out.println("Dati inseriti non validi");
		//out.println(e);
	}
	}%>
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Creazione Annuncio</title>
</head>
<body>


<% if (request.getParameter("CreaAnnuncio")==null || errore) {%>

<form action="creaAnnuncio.jsp" name="myform" method="POST">
			
			<table>
			<tr>
				<td>Nome Articolo:</td>
				<td>
					<input name="nome" type="text" id="nome">
				</td>
			</tr>
			<tr>
				<td>Descrizione:</td>
				<td>
					<input name="descrizione" type="text" id="descrizione">
				</td>
			</tr>
			<tr>
				<td>Prezzo:</td>
				<td>
					<input name="prezzo" type="number" id="prezzo" step="0.01"> €
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<input name="CreaAnnuncio" type="submit" value="Crea Annuncio">
				</td>
			</tr>
				
			</table>
			</form>
			
<p><a  href="index.jsp">Indietro</a> <br></p>
<%} else {%>
<p>Annuncio creato</p>
			
<%		response.setHeader("Refresh", "3;url=index.jsp");}%>

</body>
</html>