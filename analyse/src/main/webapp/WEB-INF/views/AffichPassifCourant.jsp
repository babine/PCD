<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Affichage Des Passifs Courants</title>
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
				<p>Application d'Analyse Financiere</p>
                <p>Affichage Des Passifs Courants</p> 
</div>	
	<div id="conteneur">
		<div id="menu">
		
		
		<div>
		<table>
		<tr><td>
		<table>
    <tr>
        <th style="color:#696969;height:80px;">Annee</th>
        <th style="color:#696969;height:80px;">Dette Fournisseurs</th>
        <th style="color:#696969;height:80px;">Dette Fiscales</th>
        <th style="color:#696969;height:80px;">Diverses Passifs Courants</th>
        <th style="color:#696969;height:80px;">Concour Bancaire</th>
        <th style="color:#696969;height:80px;">Dette Salaries</th>
        <th style="color:#696969;height:80px;color:		#F5DEB3;">Somme Des Passifs Courants</th>
        
    </tr>
    <c:forEach var="pc" items="${listPassifCourant}">
    <tr>
    
        <td style="text-align:center;">
            <c:out value="${pc.annee}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pc.detteFournisseurs}" />
        </td>
        
        <td style="text-align:center;">
            <c:out value="${pc.detteFiscales}" />
        </td>
        
         <td style="text-align:center;">
            <c:out value="${pc.diversePassifCourant}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${pc.concourBancaire}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pc.detteSalaries}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${pc.sommePassifCourant()}" />
        </td>
         
    </tr>
    </c:forEach>
    </table>
    
    <td>
    <ul style="color:#BA55D3;">
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