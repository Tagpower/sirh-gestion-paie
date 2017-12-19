package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.spring.JpaConfig;

@Service
@Transactional
	public class CotisationServiceJpa implements CotisationService {
	@PersistenceContext private EntityManager em;

	@Autowired private JpaConfig jpa;
	
	
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	public void mettreAJour(Cotisation cotisation) {
		Cotisation c = em.find(Cotisation.class, cotisation.getId());
		if( c != null) {
			c.setCode(cotisation.getCode());
			c.setLibelle(cotisation.getLibelle());
			c.setTauxPatronal(cotisation.getTauxPatronal());
			c.setTauxSalarial(cotisation.getTauxSalarial());
		}
		
	}

	@Override
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> q = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		return q.getResultList();
	}

}