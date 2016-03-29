<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Consultation de l'etat de l'entreprise</title>
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
                <p>Etat De l'Entreprise</p> 
</div>	
	<div id="conteneur">
		<div id="menu">
		
		
		<table>
		<tr><td>
		<table>
    <tr>
        <th style="color:#696969">Annee</th>       
        <th style="color:#696969">Degre de Liquidite</th>
        <th style="color:#696969">Liquidite Generale</th>
        <th style="color:#696969">Liquidite Reduite</th>
        <th style="color:#696969">Liquidite Immediate</th>
        <th style="color:#696969">Solvabilite Generale</th>
        <th style="color:#696969">Autonomie Decisionnelle</th>
        
    </tr>
    <c:forEach var="analyseRatios" items="${listAnalyseRatios}">
    <tr>
        <td style="text-align:center;">
            <c:out value="${analyseRatios.annee}" />
        </td>
        
      
        <td style="text-align:center;">
            <c:out value="${analyseRatios.degreLiquidite}" />
        </td>
        
        <td style="text-align:center;">
            <c:out value="${analyseRatios.liquiditeGenerale}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${analyseRatios.liquiditeReduite}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${analyseRatios.liquiditeImmediate}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${analyseRatios.solvabiliteGenerale}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${analyseRatios.autonomieDecisionnelle}" />
        </td>
      
    </tr>
    </c:forEach>
    </table>
    </td></tr>
    <tr>
    <td>
    <ul>
    <li> 
    <a href="http://localhost:8080/Finance/Etat" title="cliquer">Retour</a>
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
    </body>
</html>