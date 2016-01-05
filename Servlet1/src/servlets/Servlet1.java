package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import beans.Voiture;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Voiture> hmap = new HashMap<Integer, Voiture>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        hmap.put(0, new Voiture("RENAULT", "95-522-95"));
        hmap.put(1, new Voiture("PEUGEOT", "95-544-95"));
        hmap.put(2, new Voiture("CITROEN", "95-533-95"));
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Cookie[] listeCookies = request.getCookies();
		String value = listeCookies[1].getValue();
		System.out.println(value);
		request.setAttribute("Placeholder", value);
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {					
		
		String voitures = "";
		for(Integer i=0;i<hmap.size();i++){
			if(hmap.get(i).getMarque().equals(request.getParameter("1"))){
				voitures += " " + hmap.get(i).getPlaque();
			}
		}
		if(voitures.equals("")) voitures = "Non disponible";
		
		//Enegistrement du résultat
		request.setAttribute("Voitures", voitures);
		
		//Création du cookie
		Cookie c = new Cookie("choix_cookie", request.getParameter("1"));
		response.addCookie(c);
		
		//Redirection, deux méthodes
		RequestDispatcher rd = request.getRequestDispatcher("/reponseDisponibilites.jsp");
		rd.forward(request, response);
		//getServletContext().getRequestDispatcher("/responseDisponibilites.jsp").forward(request, forward);
	}
}
