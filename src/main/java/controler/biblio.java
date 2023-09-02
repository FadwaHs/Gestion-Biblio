package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mdel.dao.DAOAdherent;
import mdel.dao.DAOEmprunt;
import mdel.dao.DAOExemplaire;
import mdel.dao.DAOLivre;
import model.bo.Adherent;
import model.bo.Emprunter;
import model.bo.EmprunterId;
import model.bo.Exemplaire;
import model.bo.Livre;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class biblio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public biblio() {
        super();
    }
    
    
  
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = request.getServletPath();
		
		
		
		if( path.equals("/test.do"))
		{
			 String buttonClicked = request.getParameter("admin");
			 
			 if (buttonClicked != null) {
				 
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			     dispatcher.forward(request, response);
		      }
			 
			 buttonClicked = request.getParameter("client");
			 
		     if (buttonClicked != null) {
		        	
			     request.getRequestDispatcher("cleint.jsp").forward(request, response);
			     
		        }
		}
		
		else if( path.equals("/login.do")) //&& (request.getMethod().equals("POST"))
		 {
			
	        
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");

			 if(email != null && pass != null && email.equals("Admin@gmail.com") && pass.equals("admin") )
			 {
					
					 HttpSession session = request.getSession(true);
					 session.setAttribute("emailAd", email);
					 
					 response.sendRedirect("Menu.jsp");
			}
			else
			{
					
					 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				     dispatcher.forward(request, response);
			}
			
						
		}
		else if(path.equals("/index.do") )
		{			   
			HttpSession session = request.getSession(false); 
			if (session == null || session.getAttribute("emailAd") == null) {
				
		        response.sendRedirect("login.jsp");
		    }
			else
			{
				System.out.println(session.getAttribute("emailAd"));
				request.getRequestDispatcher("livre.jsp").forward(request, response);
			}
			   
			
		}
		else if(path.equals("/AJouter.do") )
		{
			
			HttpSession session = request.getSession(false); 
			if (session == null || session.getAttribute("emailAd") == null) {
				
		        response.sendRedirect("login.jsp");
		    }
			else
			{
				String isbn = request.getParameter("isbn");
				String titre = request.getParameter("titre");
				String cat = request.getParameter("cat");
			
			    Livre l = new Livre(isbn,titre,cat);
			  
			    DAOLivre dao = new DAOLivre();
			    dao.create(l);
			    
			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/livre.jsp");
			    rd.forward(request, response);	
			}
		
			
			
		}
		else if(path.equals("/Recherche.do"))
		{
			DAOLivre dao = new DAOLivre();
			
			String cat = request.getParameter("catR");
			if(cat == null || cat.isEmpty())
            {
            	
				 Vector<Livre> listlivre =(Vector<Livre>)dao.retreive();
				    
				 request.setAttribute("listlivre", listlivre);
            }
			else
			{
				Vector<Livre> listlivre =(Vector<Livre>)dao.retreive(cat);
			    
				request.setAttribute("listlivre", listlivre);
				
			}
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/livre.jsp");
		      rd.forward(request, response);
			
		}
		else if (path.equals("/delete.do"))
		{
			
			String ISBN = request.getParameter("id");
			System.out.println(ISBN);
			
			DAOLivre dao = new DAOLivre();
			dao.delete(ISBN);
			
			 /*RequestDispatcher rd = getServletContext().getRequestDispatcher("/livre.jsp");
		     rd.forward(request, response);*/
			
			response.sendRedirect("Recherche.do?catR=");
		}
		else if(path.equals("/Edit.do"))
		{
			
			String ISBN = request.getParameter("id");
			
			DAOLivre dao = new DAOLivre();
			Livre lv = dao.getlivre(ISBN);
			
			request.setAttribute("livre", lv);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Edit.jsp");
		    rd.forward(request, response);
			
		}
		else if( path.equals("/update.do") && (request.getMethod().equals("POST")) )
		{
		
			String isbn = request.getParameter("isbn");
			String titre = request.getParameter("titre");
			String cat = request.getParameter("cat");
			
		
			DAOLivre dao = new DAOLivre();
			Livre lv = new Livre(isbn,titre,cat);
			dao.update(lv);
			
			response.sendRedirect("Recherche.do?catR=");
		}
	    else if(path.equals("/AjouterExmpl.do") )
		{
			
			HttpSession session = request.getSession(false); 
			if (session == null || session.getAttribute("emailAd") == null) {
				
		        response.sendRedirect("login.jsp");
		    }
			else
			{
				
				String isbn = request.getParameter("isbn");
				String ref = request.getParameter("ref");
				
				DAOExemplaire exp = new DAOExemplaire();
				
				Livre l = new Livre();
				l.setIsbn(isbn);
				
				Exemplaire E = new Exemplaire(Integer.parseInt(ref),l,false);  
				exp.create(E);

			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/exemplaire.jsp");
			    rd.forward(request, response);	
			}
		
			 
			
		}
	    else if(path.equals("/RechercheExmpl.do"))
		{
	    	DAOExemplaire exp = new DAOExemplaire();
			
			String isbn  = request.getParameter("isbnr");
			if(isbn == null || isbn.isEmpty())
            {
            	
				 Vector<Exemplaire> listexmp =(Vector<Exemplaire>)exp.retreive();
				    
				 request.setAttribute("listexmp", listexmp);
            }
			else
			{
				 Vector<Exemplaire> listexmp =(Vector<Exemplaire>)exp.retreive(isbn);
			    
				 request.setAttribute("listexmp", listexmp);
				
			}
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/exemplaire.jsp");
		      rd.forward(request, response);
			
		}
	    else if (path.equals("/deleteExmp.do"))
		{
			
			String no = request.getParameter("id");
			DAOExemplaire exp = new DAOExemplaire();
			exp.delete(Integer.parseInt(no));
			
			response.sendRedirect("RechercheExmpl.do?isbnr=");
		}
	    else if(path.equals("/AJouterAD.do") )
		{
			
			HttpSession session = request.getSession(false); 
			if (session == null || session.getAttribute("emailAd") == null) {
				
		        response.sendRedirect("login.jsp");
		    }
			else
			{
				String cin = request.getParameter("cin");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("pr");
				String tele = request.getParameter("tele");
				String mdp = request.getParameter("ps");
				
			
				
				DAOAdherent daoa = new DAOAdherent();
				Adherent A = new Adherent(cin,nom, prenom, mdp, tele);
				daoa.create(A);
				
			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Adherent.jsp");
			    rd.forward(request, response);	
			}
		
		}
	    else if(path.equals("/RechercheAdr.do"))
		{
	    	DAOAdherent daoa = new DAOAdherent();
			
			String cin = request.getParameter("cinR");
			if(cin == null || cin.isEmpty())
            {
            	
				 Vector<Adherent> listAd =(Vector<Adherent>)daoa.retreive();
				    
				 request.setAttribute("listAd", listAd);
            }
			else
			{
				Vector<Adherent> listAd =(Vector<Adherent>)daoa.retreive(cin);
			    
				request.setAttribute("listAd", listAd);
				
			}
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/Adherent.jsp");
		      rd.forward(request, response);
			
		}
		else if(path.equals("/emprunter.do"))
		{
			
			HttpSession session = request.getSession(false); 
			if (session == null || session.getAttribute("emailAd") == null) {
				
		    response.sendRedirect("login.jsp");
		    }
			else
			{

				String exmpl = request.getParameter("exmpl");
				String cin = request.getParameter("cin");
				String date = request.getParameter("date");
				
				Date currentDate = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = dateFormat.format(currentDate);
				
				if(exmpl != null)
				{
					
					/// les conversion:
					Integer exno = Integer.parseInt(exmpl);
					
					/// Creation
					EmprunterId id = new EmprunterId(exno,cin,dateString);
					
					Exemplaire Expl = new Exemplaire();
			        Expl.setNoexp(exno);
			        
			        Adherent A = new Adherent();
			        A.setCin(cin);

			        Emprunter E = new Emprunter(id,Expl,A,date);
			        DAOEmprunt dao = new DAOEmprunt();
			        dao.create(E);
					
				}
				
				 //
				 DAOEmprunt dao = new DAOEmprunt();
				 Vector<Emprunter> listempr =(Vector<Emprunter>)dao.retreive();   
				 request.setAttribute("listempr", listempr);
				
			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/emprunt.jsp");
			    rd.forward(request, response);	
			}
			
			
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      doGet(request, response);
	}

}
