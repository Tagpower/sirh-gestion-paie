package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	@Autowired
	private PaieUtils pu;
	
	public CalculerRemunerationServiceSimple() {

	}

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		RemunerationEmploye rem = bulletin.getRemunerationEmploye();
		Grade gr = rem.getGrade();
		List<Cotisation> cotis_imp = rem.getProfilRemuneration().getCotisationsImposables();
		List<Cotisation> cotis_non_imp = rem.getProfilRemuneration().getCotisationsNonImposables();
		
		BigDecimal sal_base = gr.getNbHeuresBase().multiply(gr.getTauxBase());
		BigDecimal sal_brut = sal_base.add(bulletin.getPrimeExceptionnelle());
		BigDecimal total_ret_sal = cotis_non_imp.stream().filter(c -> c.getTauxSalarial() != null).map(c -> c.getTauxSalarial().multiply(sal_brut)).reduce(BigDecimal::add).get();
		BigDecimal total_cot_pat = cotis_non_imp.stream().filter(c -> c.getTauxPatronal() != null).map(c -> c.getTauxPatronal().multiply(sal_brut)).reduce(BigDecimal::add).get();
		BigDecimal net_impos = sal_brut.subtract(total_ret_sal);
		BigDecimal net_a_payer = net_impos.subtract( cotis_imp.stream().map(c -> c.getTauxSalarial().multiply(sal_brut)).reduce(BigDecimal::add).get() );
		
		res.setSalaireDeBase(pu.formaterBigDecimal(sal_base));
		res.setSalaireBrut(pu.formaterBigDecimal(sal_brut));
		res.setTotalRetenueSalarial(pu.formaterBigDecimal(total_ret_sal));
		res.setTotalCotisationsPatronales(pu.formaterBigDecimal(total_cot_pat));
		res.setNetImposable(pu.formaterBigDecimal(net_impos));
		res.setNetAPayer(pu.formaterBigDecimal(net_a_payer));
		return res;
	}
	
	

}
