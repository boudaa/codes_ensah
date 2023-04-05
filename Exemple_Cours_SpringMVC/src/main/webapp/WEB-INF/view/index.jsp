<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>

</head>
<body>
	<div class="container">

		<h1>Note : </h1>
		<p>Commencer par lire le code des controleurs puis executer les exemples et analyser les résultats affichés dans la
			console</p>
		<hr>
		<h1>Exemple de l'utilisation de l'annotation @ModelAttribute sur
			une méthode</h1>
		<ul>
			<li><a href="test1">Executer la méthode test1</a></li>
			<li><a href="test2">Executer la méthode test2</a></li>
		</ul>

		<h1>Exemple de l'utilisation de l'annotation @PathVariable</h1>
		<ul>
			<li><a
				href="http://localhost:8080/Exemple_Cours_SpringMVC/delete/1/2">Executer
					http://localhost:8080/Exemple_Cours_SpringMVC/delete/1/2</a></li>
			<li><a
				href="http://localhost:8080/Exemple_Cours_SpringMVC/deleteRequried">Executer
					http://localhost:8080/Exemple_Cours_SpringMVC/deleteRequried</a></li>
			<li><a
				href="http://localhost:8080/Exemple_Cours_SpringMVC/deleteRequried/1">Executer
					http://localhost:8080/Exemple_Cours_SpringMVC/deleteRequried/1</a></li>

		</ul>


		<h1>Exemple d'utilisation de l'annotation @RequestParam</h1>
		<ul>
			<li><a
				href="http://localhost:8080/Exemple_Cours_SpringMVC/deletePerson?idPerson=2&idRole=3">Executer
					http://localhost:8080/Exemple_Cours_SpringMVC/deletePerson?idPerson=2&idRole=3</a></li>
			<li>(idPerson prend la valeur par défaut)<a
				href="http://localhost:8080/Exemple_Cours_SpringMVC/deletePerson?idRole=5"> Executer
					http://localhost:8080/Exemple_Cours_SpringMVC/deletePerson?idRole=5</a></li>

		<li>(Erreur car idRole est obligatoire)<a
				href="http://localhost:8080/Exemple_Cours_SpringMVC/deletePerson"> Executer
					http://localhost:8080/Exemple_Cours_SpringMVC/deletePerson</a></li>
		</ul>
	</div>
</body>
</html>