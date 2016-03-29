<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Affichage Des Utilisateurs</title>
</head>
<style>
body{
background:url(resources/images/fond_new.jpg) no-repeat center;
background-size:1900px,700px;
font-family:Arial,sans-serif;
font-size:25px;
color:	#FF7F50;
margin: 100px;
}
#top{
text-align:center;
font-size:30px;
text-shadow: 5px 5px 5px #FF0000;

}


#conteneur{
width:1200px;
margin:160px 150px 0 150px;

}

#menu ul li{
list-style:none;
float:left;
padding:0;

}
#menu ul li a{
height:70px;
width:150px;
display:block;
font-size:18px;
line-height:43px;
text-decoration:none;
color: 	#696969;
text-align:center;
}
#menu ul li a:hover {
line-height:30px;
}
</style>
  
  <body>
<div id="top">
				<p>Application d'Analyse Financière</p>
                <p>Affichage De La Liste Des Utilisateurs</p> 
</div>	
	<div id="conteneur">
		<div id="menu">
		
		
		<div>
		<table>
		<tr><td>
		<table>
    <tr>
        <th style="color:#696969;height:80px;">Username</th>
        <th style="color:#696969;height:80px;">Lastname</th>
        <th style="color:#696969;height:80px;">Password</th>
        <th style="color:#696969;height:80px;">Email</th>
    </tr>
    <c:forEach var="user" items="${listUtilisateurs}">
    <tr>
        <td style="text-align:center;">
            <c:out value="${user.username}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${user.lastname}" />
        </td>
        
        <td style="text-align:center;">
            <c:out value="${user.password}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${user.email}" />
        </td>
    </tr>
    </c:forEach>
    </table>
    </td>
    <td>
    <ul>
    	<li><a href="http://localhost:8080/Finance/GestionUtilisateurs" title="cliquer">Retour</a></li>
    
		<li>
				<c:url value="/j_spring_security_logout" var="logoutUrl" />
		        <a href="${logoutUrl}">Log Out</a>
		</li>
		</ul>
	</td></tr>

</table>
		</div>		
		</div>	   
		</div>
    </body>
</html>