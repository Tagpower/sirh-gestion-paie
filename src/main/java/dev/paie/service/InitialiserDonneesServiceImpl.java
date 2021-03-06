package dev.paie.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.Role;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.repository.UtilisateurRepository;

@Service
@ImportResource({"classpath:jdd-config.xml", "classpath:entreprises.xml", "classpath:grades.xml", "classpath:profils-remuneration.xml"})
public class InitialiserDonneesServiceImpl implements InitialiserDonneesService{

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private AvantageRepository avantageRepository;
	@Autowired
	private CotisationRepository cotisationRepository;
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private PeriodeRepository periodeRepository;
	@Autowired
	private RemunerationEmployeRepository remRepository;
	@Autowired
	private BulletinRepository bulletinRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	

//	@Autowired
//	private List<Avantage> avantages;
	@Autowired
	private List<ProfilRemuneration> profilsRemuneration;
	@Autowired
	private List<Cotisation> cotisations;
	@Autowired
	private List<Entreprise> entreprises;
	@Autowired
	private List<Grade> grades;
	@Autowired
	private List<RemunerationEmploye> remunerations;
	@Autowired
	private List<BulletinSalaire> bulletins;
	
	@Transactional
	@Override
	public void initialiser() {
		profilRemunerationRepository.save(profilsRemuneration.iterator().next());
		cotisationRepository.save(cotisations);
		entrepriseRepository.save(entreprises);
		gradeRepository.save(grades);
		remRepository.save(remunerations);
		bulletinRepository.save(bulletins);
		//avantageRepository.save(avantages);

		for (int month = 1; month <= 12; month++) {
			Periode p = new Periode();
			LocalDate dateDebut = LocalDate.of(2017, month, 1);
			LocalDate dateFin = dateDebut.withDayOfMonth(dateDebut.lengthOfMonth());
			p.setDateDebut(dateDebut);
			p.setDateFin(dateFin);
			periodeRepository.save(p);
		}
		
		String motDePasse = "mdp";
		String motDePasseHash = this.passwordEncoder.encode(motDePasse);
		
		Utilisateur u_admin = new Utilisateur("bill", this.passwordEncoder.encode("billy"), true, Role.ROLE_ADMINISTRATEUR);
		utilisateurRepository.save(u_admin);
		Utilisateur u_user = new Utilisateur("bob", this.passwordEncoder.encode("bobby"), true, Role.ROLE_UTILISATEUR);
		utilisateurRepository.save(u_user);
		
		
	}

	
	
}
