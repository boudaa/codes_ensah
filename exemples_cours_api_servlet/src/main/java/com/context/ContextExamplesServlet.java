package com.context;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.common.Etudiant;

/**
 * Cette classe servlet présente des exemples avec le contexte de servlet
 * 
 * @author BOUDAA
 *
 */

@WebServlet("/contextExamples")
public class ContextExamplesServlet extends HttpServlet {

	public ContextExamplesServlet() {

	}

	/**
	 * Cette méthode stocke un objet dans le contexte
	 * 
	 * @param rq
	 *            : l'objet représentant la requête
	 * @param key
	 *            : une chaîne de caractères qui represente la clé à utiliser
	 *            pour référencer l'objet dans le contexte
	 * @param object
	 *            : l'objet à stocker dans le contexte
	 */
	public void storeObjectInContext(HttpServletRequest rq, String key, Object object) {

		// On récupère le contexte
		ServletContext context = rq.getServletContext();

		// On stocke l'objet dans le contexte de l'application

		context.setAttribute(key, object);

	}

	/**
	 * Méthode qui permet de récupérer un objet du contexte
	 * 
	 * @param rq
	 *            : l'objet représentant la requête
	 * @param key
	 *            : une chaîne de caractères qui represente la clé  à utiliser
	 *            pour récupérer l'objet du contexte
	 * @param object
	 *            : l'objet à récupérer du contexte
	 */
	public Object getObjectFromContext(HttpServletRequest rq, String key) {

		// On récupère le contexte
		ServletContext context = rq.getServletContext();

		// On récupère l'objet du contexte
		return context.getAttribute(key);

	}

	/**
	 * Permet d'écrire un paragraphe dans la réponse
	 * 
	 * @param response
	 *            : objet de réponse à envoyer à l'utilisateur
	 * @throws IOException
	 */
	public void writeParagraph(HttpServletResponse response, String p) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		out.print("<p>" + p + "</p>");
	}

	/**
	 * Méthode qui s'execute lorsque la sevlet reçoit une requête de type GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// On récupère un paramètre de la  requête qui indique la tâche demandée,
		// ce paramètre attendu est : task
		String param = request.getParameter("task");

		// En fonction de la valeur de ce paramère on execute l'une des tâches ci-dessous :

		// Tâche 1 : On stocke un objet étudiant dans le context
		if ("store".equals(param)) {
			Etudiant et = new Etudiant("Karimi", "Ali", 22);
			storeObjectInContext(request, "etudiant", et);

			// On insère du texte dans la réponse
			writeParagraph(response, "L'étudiant est bien ajoutée dans le contexte");

		}
		// Tâche 2 : On récupère un objet étudiant de la session

		else if ("get".equals(param)) {

			// On récupère un étudiant du contexte
			// L'objet récupéré du contexte est généralement de type Object,
			// on s'assure qu'il s'agit exactement d'un objet de type Etudiant
			// par instanceof avant de forcer la conversion
			Etudiant etudiant = null;
			Object obj = getObjectFromContext(request, "etudiant");
			if (obj instanceof Etudiant) {
				etudiant = (Etudiant) obj;
			}

			// si un étudiant est trouvé
			if (etudiant != null) {
				// On insère du texte dans la réponse
				// on laisse la méthode toString de Etudiant prendera soin de
				// convertir l'objet en une belle chaîne de caractères
				writeParagraph(response, "L'étudiant est trouvé : " + etudiant);
			}

			else {
				// On écrit un message indiquant que l'objet recherché n'existe
				// pas dans le contexte
				writeParagraph(response, "Aucun étudiant trouvé");

			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
