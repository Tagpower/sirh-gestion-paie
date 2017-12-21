package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");

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
	
	@RequestMapping(method = RequestMethod.POST)
	public void submitForm(@ModelAttribute("employe") RemunerationEmploye employe) {
		remunerationEmployeRepository.save(employe);
	}
	
	
}