<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
    <jsp:useBean id="BeanRicerca" scope="session"   class="bean.BeanRicerca" />
    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Articoli preferiti</title>
</head>
<body>

<%			BeanRicerca.setVenditore((String)session.getAttribute("user"));
			BeanRicerca.cercaPreferitiUtente();
			//System.out.println(BeanRicerca.getNum_articoli());
			if(BeanRicerca.getNum_articoli()>0){%>
			<p align=center><b>I tuoi articoli preferiti:</b></p>
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
				<td><b>Venditore:</b></td>
				<td><%out.print(BeanRicerca.getArticolo(i).getVenditore()); %></td>
				
				<td><a  href='http://localhost:8080/ProgettoISPW/eliminaArticoloPreferito.jsp?id=<%=BeanRicerca.getArticolo(i).getID()%>'>Rimuovi dalla lista desideri</a></td>
				</tr>
			<%}%>
		</table>
		<%} else { %>
		<p align=center>Non hai nessun articolo tra i preferiti</p>
		<%} %>
		
<p><a  href="index.jsp">Indietro</a> <br></p>


</body>
</html>