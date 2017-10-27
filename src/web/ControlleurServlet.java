package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entites.Produit;

@WebServlet(name = "cs", urlPatterns = { "*.php" })
public class ControlleurServlet extends HttpServlet {
	// le controlleur a besoin de la couche metier
	// notre couche metier est la couche dao dans cet exemple
	// donc on a besoin de declarer un attribut de type ProduitDao
	// on utilise l'interface pour un couplage faile, ou bien la classe pour un
	// couplage fort
	// a ce point : on peut utiliser Spring pour l'DI

	private IProduitDao metier;

	@Override
	public void init() throws ServletException {
		// instancier la couche metier (couplage fort)
		metier = new ProduitDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		if (path.equals("/index.php")) {
			
			String motCle = "";
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits = metier.produitsParMC("%" + motCle + "%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			// pour afficher la vue, on fait un forward
			request.getRequestDispatcher("produits.jsp").forward(request, response);
			
			
			
			//response.sendRedirect("chercher.php?motCle=");
			
			
		} else if (path.equals("/chercher.php")) {
			String motCle = request.getParameter("motCle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits = metier.produitsParMC("%" + motCle + "%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			// pour afficher la vue, on fait un forward
			request.getRequestDispatcher("produits.jsp").forward(request, response);

			//response.sendRedirect("chercher.php?motCle=");
			
		} else if (path.equals("/add.php")) {
			// je cree un attribut produit vide dans la request pour mettre des valeur par
			// defaut
			// et puis je peux ajouter "required"(HTML5) pour que les champs ne seront
			// jamais vide
			// mais c pas vraiment de du control de saisie
			// on peut utiliser js cote client ou bien ds la servlet cote serveur
			// ouuuuu biennnn par les framework
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("addProduit.jsp").forward(request, response);

		} else if (path.equals("/save.php") && (request.getMethod().equals("POST"))) {

			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit produit = metier.addProduit(new Produit(designation, prix, quantite));
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("confimAdd.jsp").forward(request, response);

		} else if (path.equals("/delete.php")) {
			//System.out.println("1");
			Long id = Long.parseLong(request.getParameter("id"));
			//System.out.println("2");
			metier.deleteProduit(id);
			//System.out.println("3");
			//request.getRequestDispatcher("produits.jsp").forward(request, response);
			response.sendRedirect("chercher.php?motCle=");
			//System.out.println("4");
			
		} else if (path.equals("/edit.php")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit produit = metier.getProduit(id);
			request.setAttribute("produit", produit);
			
			//metier.updateProduit(produit);
			
			request.getRequestDispatcher("editProduit.jsp").forward(request, response);
			
		} else if (path.equals("/update.php") && (request.getMethod().equals("POST"))) {

			Long id = Long.parseLong(request.getParameter("id"));
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit produit = new Produit(designation, prix, quantite);
			produit.setId(id);
			produit = metier.updateProduit(produit); 
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("confirmUpdate.jsp").forward(request, response);

			

		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
