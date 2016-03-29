<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Affichage Des Actifs Non Courants</title>
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
#down{
text-align:bottom;
font-size:20px;
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
                <p>Affichage Des Actifs Non Courants</p> 
</div>	
	<div id="conteneur">
		<div id="menu">
		
		
		<div style="text-align:center;">
		<table>
		<tr><td>
		<table>
    <tr>
        <th style="color:#696969;height:80px;">Annee</th>
        <th style="color:#696969;height:80px;">Immobilisations Incorporelles</th>
        <th style="color:#696969;height:80px;">Immobilisations Corporelles</th>
        <th style="color:#696969;height:80px;">Immobilisations Financieres</th>
        <th style="color:#696969;height:80px;color:		#F5DEB3;">Somme Des Actifs Non Courants</th>
        
    </tr>
    <c:forEach var="anc" items="${listActifNonCourant}">
    <tr>
        <td style="text-align:center;">
            <c:out value="${anc.annee}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${anc.immIncorporelles}" />
        </td>
        
        <td style="text-align:center;">
            <c:out value="${anc.immCorporelles}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${anc.immFinancieres}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${anc.sommeActifNonCourant()}" />
        </td>
    </tr>
    </c:forEach>
    </table>
    </td>
    
    <td style="color:	#FFA07A">
    <ul>
    <li> 
    <a href="http://localhost:8080/Finance/Bilan" title="cliquer">Retour</a>
    </li>
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