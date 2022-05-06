<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
    
    <jsp:useBean id="beanVisualizzaProfilo" scope="session"   class="bean.BeanUtente" />

    
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<link rel="stylesheet" type="text/css" href="style/elements.css">
<title>Profilo</title>
</head>
<body>

<% 
if(session.getAttribute("user")==null)
{
%>	
	<jsp:forward page="sessioneScaduta.jsp" />
<% 
}
beanVisualizzaProfilo.visualizzaProfilo((String)session.getAttribute("user"));
%>

<table>
			<tr>
				<td>Username:</td>
				<td>
					<jsp:getProperty property="username" name="beanVisualizzaProfilo"/>
				</td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td>
					<jsp:getProperty property="nome" name="beanVisualizzaProfilo" />
				</td>
			</tr>
			<tr>
				<td>Cognome:</td>
				<td>
					<jsp:getProperty property="cognome" name="beanVisualizzaProfilo" />
				</td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td>
					<jsp:getProperty property="email" name="beanVisualizzaProfilo" />
				</td>
			</tr>
			<tr>
				<td>Numero di telefono:</td>
				<td>
					<jsp:getProperty property="numeroTelefono" name="beanVisualizzaProfilo" />
				</td>
			</tr>
			<tr>
				<td>Indirizzo:</td>
				<td>
					<jsp:getProperty property="indirizzo" name="beanVisualizzaProfilo" />
				</td>
			</tr>									
				
			<tr>
				<td>
				<a  href="modificaProfilo.jsp">Modifica il profilo  </a>
				</td>
				<td>
					<a  href="modificaPassword.jsp">Modifica la password  </a>
				</td>
				<td>
					<a  href="eliminaProfilo.jsp">Elimina il profilo  </a>
				</td>
			</tr>	
				
			</table>

</body>
</html>