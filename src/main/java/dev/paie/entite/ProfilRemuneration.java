package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


public class ProfilRemuneration {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(name="code")
	private String code;
	@ManyToMany
	@JoinTable(name="cotis_non_impo",
		joinColumns= @JoinColumn(name="id_cot", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="id_profil", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsNonImposables;
	@ManyToMany
	@JoinTable(name="cotis_impo",
		joinColumns= @JoinColumn(name="id_cot", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="id_profil", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsImposables;
	@ManyToMany
	@JoinTable(name="avantages",
		joinColumns= @JoinColumn(name="id_avan", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="id_profil", referencedColumnName="id")
	)
	private List<Avantage> avantages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
