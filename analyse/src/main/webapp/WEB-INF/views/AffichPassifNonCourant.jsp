<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Affichage Des Passifs Non Courants</title>
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
margin:160px 0 0 0;

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
                <p>Affichage Des Passifs Non Courants</p> 
</div>	
	<div id="conteneur">
		<div id="menu">
		
		
		<div>
		<table>
		<tr><td>
		<table>
    <tr>
        <th style="color:#696969;height:80px;">Annee</th>
        <th style="color:#696969;height:80px;">CapitalSocial</th>
        <th style="color:#696969;height:80px;">Reserves</th>
        <th style="color:#696969;height:80px;">Autre Capitaux</th>
        <th style="color:#696969;height:80px;">Resultat Reporte</th>
        <th style="color:#696969;height:80px;">Resultat Exercice</th>
        <th style="color:#696969;height:80px;">Emprunts</th>
        <th style="color:#696969;height:80px;">Provisions</th>
        <th style="color:#696969;height:80px;">Autres Passifs Financiers</th>
        <th style="color:#696969;height:80px;color:		#F5DEB3;">Somme Des Passifs Non Courants</th>
        <th style="color:#696969;height:80px;color:		#F5DEB3;">Somme Des Capitaux Propres</th>
        
    </tr>
    <c:forEach var="pnc" items="${listPassifNonCourant}">
    <tr>
        <td style="text-align:center;">
            <c:out value="${pnc.annee}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pnc.capitalSocial}" />
        </td>
        
        <td style="text-align:center;">
            <c:out value="${pnc.reserves}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pnc.autreCapitaux}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${pnc.resultatReporte}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${pnc.resultatExercice}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${pnc.emprunts}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pnc.provisions}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pnc.autresPassifsFinanciers}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pnc.sommePassifNonCourant()}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pnc.sommeCapitalPropre()}" />
        </td>
    </tr>
    </c:forEach>
    </table>
    </td>
    
    <td>
    <ul>
    <li> <a href="http://localhost:8080/Finance/Bilan" title="cliquer">Retour</a>
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