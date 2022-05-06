<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
    
<jsp:useBean id="BeanRicerca" scope="session"  class="bean.BeanRicerca" />
<jsp:setProperty name="BeanRicerca" property="*" />    

<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>I Tuoi Annunci</title>
</head>
<body>

<%			BeanRicerca.setVenditore((String)session.getAttribute("user"));
			BeanRicerca.cercaPerUtente();
			//System.out.println(BeanRicerca.getNum_articoli());
			if(BeanRicerca.getNum_articoli()>0){%>
			<p align=center><b>I tuoi articoli:</b></p>
		<table style="background-color:PowderBlue">
			<%for (int i=0;i<BeanRicerca.getNum_articoli();i++){%>
				<tr>
				<td><b>ID:</b></td>
				<td><%out.print(BeanRicerca.getArticolo(i).getID()); %></td>
				<td><b>Nome:</b></td>
				<td><%out.print(BeanRicerca.getArticolo(i).getNome()); %></td>
				<td><b>Descrizione:</b></td>
				<td><%out.print(BeanRicerca.getArticolo(i).getDescrizione()); %></td>
				<td><b>Prezzo:</b></td>
				<td><%out.print(BeanRicerca.getArticolo(i).getPrezzo() +  " \u20ac"); %></td>
				<td><a  href='http://localhost:8080/ProgettoISPW/modificaAnnuncio.jsp?ID=<%=BeanRicerca.getArticolo(i).getID()%>'>Modifica annuncio</a></td>
				<td><a  href='http://localhost:8080/ProgettoISPW/rimuoviArticolo.jsp?ID=<%=BeanRicerca.getArticolo(i).getID()%>'>Rimuovi annuncio</a></td>
				</tr>
			<%}%>
		</table>
		<%} else { %>
		<p align=center>Nessun annuncio trovato</p>
		<%} %>
		
<p><a  href="index.jsp">Indietro</a> <br></p>

</body>
</html>