package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cotisation")
public class Cotisation {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(name="code", length=5, nullable=false)
	private String code;
	@Column(name="libelle", length=50, nullable=false)
	private String libelle;
	@Column(name="tauxSalarial")
	private BigDecimal tauxSalarial;
	@Column(name="tauxPatronal")
	private BigDecimal tauxPatronal;
//	@ManyToMany(mappedBy="cotis_impo")
//	private ProfilRemuneration profilRemImposable;
//	@ManyToMany(mappedBy="cotis_non_impo")
//	private ProfilRemuneration profilRemNonImposable;
	
	public Cotisation() {
		
	}

	public Cotisation(String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
		this.code = code;
		this.libelle = libelle;
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronal = tauxPatronal;
	}



	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

//	public ProfilRemuneration getProfilRemImposable() {
//		return profilRemImposable;
//	}
//
//	public void setProfilRemImposable(ProfilRemuneration profilRemImposable) {
//		this.profilRemImposable = profilRemImposable;
//	}
//
//	public ProfilRemuneration getProfilRemNonImposable() {
//		return profilRemNonImposable;
//	}
//
//	public void setProfilRemNonImposable(ProfilRemuneration profilRemNonImposable) {
//		this.profilRemNonImposable = profilRemNonImposable;
//	}


	
	
	
	
	
	

}
