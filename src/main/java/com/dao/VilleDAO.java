
package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findVillesCodePostal(String codePostal);
	
	public ArrayList<Ville> findVilles();
	
	public void saveVille(Ville ville);
	
	public void updateVille(String codePostal, Ville ville);
}