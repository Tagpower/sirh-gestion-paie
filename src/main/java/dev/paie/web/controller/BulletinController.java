package dev.paie.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {
	
	@Autowired
	private PeriodeRepository periodeRepository;
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	private BulletinRepository bulletinRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerForm() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("bulletins/creerBulletin");
		
		String matricule = null;
		
		mv.addObject("matricule", matricule);

		List<Periode> periodes = periodeRepository.findAll();
		mv.addObject("periodes", periodes);
		
		List<RemunerationEmploye> employes = remunerationEmployeRepository.findAll();
		mv.addObject("employes", employes);
		
		
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView submitForm( @ModelAttribute("bulletin") BulletinSalaire bulletin, @RequestParam("prime") BigDecimal prime) {
		bulletin.setPrimeExceptionnelle(prime);
		bulletinRepository.save(bulletin);
		
		
		
		return listerBulletins();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	public ModelAndView listerBulletins() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("bulletins/listerBulletins");
		
		List<BulletinSalaire> bulletins = bulletinRepository.findAll();
		mv.addObject("bulletins", bulletins);
		
		
		
		return mv;
	}
	
	
}