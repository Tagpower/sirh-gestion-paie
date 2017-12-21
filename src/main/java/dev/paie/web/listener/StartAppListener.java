package dev.paie.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDonneesService;

@Component
public class StartAppListener {

	@Autowired
	private InitialiserDonneesService init;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		init.initialiser();
	}
}