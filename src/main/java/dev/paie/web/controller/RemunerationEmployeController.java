package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerForm() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("employes/creerEmploye");
		
		String matricule = null;
		
		mv.addObject("matricule", matricule);

		List<Entreprise> entreprises = entrepriseRepository.findAll();
		mv.addObject("entreprises", entreprises);
		
		List<ProfilRemuneration> profils = profilRemunerationRepository.findAll();
		mv.addObject("profils", profils);
		
		List<Grade> grades = gradeRepository.findAll();
		mv.addObject("grades", grades);
		
		RemunerationEmploye remEmploye = new RemunerationEmploye();
		mv.addObject("employe", remEmploye);
		
		
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView submitForm( @ModelAttribute("employe") RemunerationEmploye employe, @RequestParam("matricule") String matricule) {
		employe.setMatricule(matricule);
		remunerationEmployeRepository.save(employe);
		
		
		
		return listerEmployes();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	public ModelAndView listerEmployes() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("employes/listerEmployes");
		
		List<RemunerationEmploye> employes = remunerationEmployeRepository.findAll();
		mv.addObject("employes", employes);
		
		
		
		return mv;
	}
	
	
}