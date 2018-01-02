package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class Utilisateur {

	public enum Role {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(name="nom_utilisateur", nullable=false)
	private String nomUtilisateur;
	@Column(name="mot_de_passe", nullable=false)
	private String motDePasse;
	@Column(name="actif")
	private Boolean estActif;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String nom, String mdp, boolean actif, Role role) {
		nomUtilisateur = nom;
		motDePasse = mdp;
		estActif = actif;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Boolean getEstActif() {
		return estActif;
	}
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	

}
