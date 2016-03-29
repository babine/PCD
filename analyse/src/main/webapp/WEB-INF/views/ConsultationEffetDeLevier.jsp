<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Consultation De l'Effet De Levier</title>
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
                <p>Consultation De l'Effet De Levier</p> 
</div>	
	<div id="conteneur">
		<div id="menu">
		
		
		<table>
		<tr><td>
		<table>
    <tr>
        <th style="color:#696969">Annee</th>  
        <th style="color:#696969">Benefice Avant Interet Et Impot</th>
        <th style="color:#696969">Benefice Avant Impot</th>
        <th style="color:#696969">Benefice Net</th> 
        <th style="color:#696969">Capital Investi</th>
        <th style="color:#696969">Chiffre Affaire</th>        
        <th style="color:#696969">Chiffre Affaire Critique</th>
        <th style="color:#696969">Coefficient Effet De Levier</th>
        <th style="color:#696969">Cout Fixe</th>
        <th style="color:#696969">Cout Variable</th>  
        <th style="color:#696969">Effet De Levier</th> 
        <th style="color:#696969">Production Point Mort</th>
        <th style="color:#696969">Production Pour Benefice</th>   
        <th style="color:#696969">Taux Rentabilite Economique</th>
        <th style="color:#696969">Taux Rentabilite Financiere</th>
               
    </tr>
    
    <c:forEach var="cashFlow" items="${listDonneesEffetDeLevier}">
    <tr>
        <td style="text-align:center;">
            <c:out value="${cashFlow.annee}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${cashFlow.beneficeAvantInteretEtImpot}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${cashFlow.beneficeAvantImpot}" />
        </td>  
        <td style="text-align:center;">
            <c:out value="${cashFlow.beneficeNet}" />
        </td>    
            
        <td style="text-align:center;">
            <c:out value="${cashFlow.capitalInvesti}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${cashFlow.chiffreAffaire}" />
        </td>
          <td style="text-align:center;">
            <c:out value="${cashFlow.chiffreAffaireCritique}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${cashFlow.coefficientEffetDeLevier}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${cashFlow.coutFixe}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${cashFlow.coutVariable}" />
        </td> 
         
        <td style="text-align:center;">
            <c:out value="${cashFlow.effetDeLevier}" />
        </td> 
        <td style="text-align:center;">
            <c:out value="${cashFlow.productionPointMort}" />
        </td>
         <td style="text-align:center;">
            <c:out value="${cashFlow.productionPourBenefice}" />
        </td>
        <td style="text-align:center;">
            <c:out value="${cashFlow.tauxRentabiliteEconomique}" />
        </td>
        
        <td style="text-align:center;">
            <c:out value="${cashFlow.tauxRentabiliteFinanciere}" />
        </td>
       
       
    </tr>
    </c:forEach>
    </table>
    </td></tr>
    <tr>
    <td>
    <ul>
    <li style="width:80%;"> 
    <a href="http://localhost:8080/Finance/CashFlow" title="cliquer">Retour</a>
    </li>
		<li style="width:20%;">
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