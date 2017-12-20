package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Cotisation;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@ContextConfiguration(classes = { CotisationServiceJpa.class, DataSourceMySQLConfig.class, JpaConfig.class})
@RunWith(SpringRunner.class)

	public class CotisationServiceJpaTest {
	@Autowired private CotisationService cotisationService;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//sauvegarder une nouvelle cotisation
		Cotisation cot = new Cotisation("ABCDE", "La cotisation ABCDE", new BigDecimal(123), new BigDecimal(150));
		cotisationService.sauvegarder(cot);
		
		//vérifier qu'il est possible de récupérer la nouvelle cotisation via laméthode lister
		assertThat(cotisationService.lister().get(cotisationService.lister().size()-1).getLibelle()).isEqualTo("La cotisation ABCDE");
		
		//modifier une cotisation
		Cotisation cot2 = new Cotisation("ABCDE", "La cotisation ABCDE changée", new BigDecimal(150), new BigDecimal(130));
		cot2.setId(cotisationService.lister().size());
		cotisationService.mettreAJour(cot2);
		
		//vérifier que les modifications sont bien prises en compte via la méthode lister
		assertThat(cotisationService.lister().get(cotisationService.lister().size()-1).getLibelle()).isEqualTo("La cotisation ABCDE changée");

		cotisationService.supprimer(cotisationService.lister().get(cotisationService.lister().size()-1));
	
	}
}