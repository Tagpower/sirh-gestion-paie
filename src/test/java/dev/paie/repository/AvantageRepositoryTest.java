package dev.paie.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

//TODO compléter la configuration
@ContextConfiguration(classes = {ServicesConfig.class, DataSourceMySQLConfig.class, JpaConfig.class})

@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired private AvantageRepository avantageRepository;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//TODO sauvegarder un nouvel avantage
		Avantage av = new Avantage("AV001", "Avantage 1", new BigDecimal(150));
		avantageRepository.save(av);
		int testId = av.getId();
			
		//TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		assertThat(avantageRepository.findOne(testId).getNom()).isEqualTo("Avantage 1");
		
		//TODO modifier un avantage
		av.setCode("AV101");
		avantageRepository.save(av);
			
		//TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
		assertThat(avantageRepository.findOne(testId).getCode()).isEqualTo("AV101");
		
		avantageRepository.delete(testId);
		
		
	}
	
	@Test
	public void test_recherche_par_code() {
		Avantage av = new Avantage("CODE", "Code à trouver", new BigDecimal(144));
		avantageRepository.save(av);
		
		Avantage avTrouve = avantageRepository.findByCode("CODE").get(0);
		
		assertThat(avTrouve.getNom()).isEqualTo("Code à trouver");
		
		avantageRepository.delete(av);
	}
}