package dev.paie.utils;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.paie.util.PaieUtils;

public class PaieUtilsTest {
	private PaieUtils paieUtils;
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void onSetup() {
		context = new ClassPathXmlApplicationContext("app-config.xml");
		paieUtils = context.getBean(PaieUtils.class);
	}
	
	@Test
	public void test_formaterBigDecimal_entier_positif() {
		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2"));
		assertThat(resultat).isEqualTo("2.00");
	}
	
	@Test
	public void test_formaterBigDecimal_trois_chiffres_apres_la_virgule() {
		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2.199"));
		assertThat(resultat).isEqualTo("2.20");
	}
	
	@Test
	public void test_arrondi() {
		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2.00001"));		
		assertThat(resultat).isEqualTo("2.01");
	}
	
	@After
	public void onExit() {
		context.close();
	}
}