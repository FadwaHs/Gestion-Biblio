package ma.fstm.ilisi2.springproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ma.fstm.ilisi2.springproject.LivreService;
import ma.fstm.ilisi2.springproject.livres;

@Controller
public class AppController {
	
	
	@Autowired
	private LivreService service;
	@Autowired
	private AdherentService serviceA;
	@Autowired
	private EmprunteService serviceE;
	
	
	public AppController(LivreService service ,  AdherentService serviceA,EmprunteService serviceE) {
		
		super();
		this.service = service;
		this.serviceA = serviceA;
		this.serviceE = serviceE;
	}


	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
	   List<livres> listLivre = service.listAll();
	   model.addAttribute("listLivre", listLivre);
	   return "index";
	}
	
	@RequestMapping("/new")
	public String showNewlivrePage(Model model) {
		
    livres livre = new livres();
	model.addAttribute("livre", livre);
	return "new_livre";
	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveLivre(@ModelAttribute("livre") livres livre) {
		
	   service.save(livre);
	   return "redirect:/";
	}
	
	@RequestMapping("/edit/{isbn}")
	
	public ModelAndView showEditLivrePage(@PathVariable(name = "isbn") String isbn) {
		
	ModelAndView mav = new ModelAndView("edit_livre");
	livres livre = service.get(isbn);
	mav.addObject("livre", livre);
	return mav;
	
	}
	
	@RequestMapping("/delete/{isbn}")
	public String deleteLivre(@PathVariable(name = "isbn") String isbn) {
		
	service.delete(isbn);
	return "redirect:/";
	}
	
	
	////////////////////////// Crud Adhreent /////////////:
	
	@RequestMapping("/Adherent")
	public String viewAdherentPage(Model model) {
		
	   List<Adherent> listAdherent = serviceA.listAll();
	   model.addAttribute("listAdherent", listAdherent);
	   
	   return "index_adhrent";
	}
	
	@RequestMapping("/newA")
	public String showNewAdherentePage(Model model) {
		
    Adherent adherent = new Adherent();
	model.addAttribute("adherent", adherent);
	return "new_Adherent";
	
	}
	
	@RequestMapping(value = "/saveA", method = RequestMethod.POST)
	public String saveAdherent(@ModelAttribute("adherent") Adherent adherent) {
		
	   serviceA.save(adherent);
	   return "redirect:/Adherent";
	}
	
	
    @RequestMapping("/editA/{cin}")
	public ModelAndView showEditAdherentPage(@PathVariable(name = "cin") String cin) {
		
	ModelAndView mav = new ModelAndView("edit_adhrent");
	Adherent adherent = serviceA.get(cin);
	mav.addObject("adherent", adherent);
	return mav;
	
	}
	
	@RequestMapping("/deleteA/{cin}")
	public String deleteAdherent(@PathVariable(name = "cin") String cin) {
		
	serviceA.delete(cin);
	return "redirect:/Adherent";
	}
	
	
	///////////////////////////////////////// Emprurnter ///////////////////////////////
	
	@RequestMapping("/emprunt")
	public String viewemprunte(Model model) {
		
	   List<Emprunter> listEmprunter = serviceE.listAll();
	   model.addAttribute("listEmprunter", listEmprunter);
	   return "index_emprunt";
	}
	
	@RequestMapping("/newE")
	public String showNewEmprunterPage(Model model) {
		
	    Emprunter emprunter = new Emprunter();
	    emprunter.setId(new EmprunterId()); // create a new instance of EmprunterId and set it in the Emprunter object
	    
	    model.addAttribute("emprunter", emprunter);
	    return "new_emprunt";
	}

	@RequestMapping(value = "/saveE", method = RequestMethod.POST)
	public String saveEmprunter(@ModelAttribute("emprunter") Emprunter emprunter) {
		
	    serviceE.save(emprunter);
	    
	    return "redirect:/index_emprunt";
	}
	

	
	
	
	
	
	

}

