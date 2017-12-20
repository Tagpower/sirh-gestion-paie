package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(name="code", nullable=false)
	private String code;
	@Column(name="nbHeuresBase")
	private BigDecimal nbHeuresBase;
	@Column(name="tauxBase")
	private BigDecimal tauxBase;
	@ManyToOne
	//@JoinColumn(mappedBy="grade") TODO
	private RemunerationEmploye rem;
	
	public Grade() {
		
	}
	
	public Grade(String code, BigDecimal nbHeuresBase, BigDecimal tauxBase, RemunerationEmploye rem) {
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
		this.rem = rem;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public RemunerationEmploye getRem() {
		return rem;
	}

	public void setRem(RemunerationEmploye rem) {
		this.rem = rem;
	}
	
	
	
	
	

}
