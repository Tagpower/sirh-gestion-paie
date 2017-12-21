package dev.paie.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.service.InitialiserDonneesService;

@ContextConfiguration(classes = {ServicesConfig.class})
//@ContextConfiguration(classes = {ServicesConfig.class, InitialiserDonneesServiceImpl.class, DataSourceMySQLConfig.class, JpaConfig.class})
@RunWith(SpringRunner.class)

public class MappingJpaTest {
	@Autowired private InitialiserDonneesService init;

	

	public MappingJpaTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void mapping_test() {
		init.initialiser();
	}

}
