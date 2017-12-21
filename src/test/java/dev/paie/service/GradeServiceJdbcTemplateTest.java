package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = { GradeServiceJdbcTemplate.class, DataSourceMySQLConfig.class})

@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired private GradeService gradeService;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//sauvegarder un nouveau grade
		Grade g1 = new Grade("AAAAA", new BigDecimal(500), new BigDecimal(1300));
		gradeService.sauvegarder(g1);
		
		//vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		assertThat(gradeService.lister().get(0).getCode()).isEqualTo("AAAAA");
		
		//modifier un grade
		g1.setCode("CCCCC");
		gradeService.mettreAJour(g1);	
		
		//vérifier que les modifications sont bien prises en compte via la méthode lister
		assertThat(gradeService.lister().get(0).getCode()).isEqualTo("CCCCC");
		
		gradeService.supprimer(g1);
	}
}