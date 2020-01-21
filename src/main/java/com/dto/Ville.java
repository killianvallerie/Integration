package com.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville implements Serializable {	
	
	/**
	 * Serial IUD for serialization.
	 */
	private static final long serialVersionUID = -8050478362033217382L;
	
	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;	
	private String ligne;	
	private LieuVille lieu;
	
	public String getCodeCommune() {
		return codeCommune;
	}
	
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public LieuVille getLieu() {
		return lieu;
	}

	public void setLieu(LieuVille lieu) {
		this.lieu = lieu;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}	
	
}