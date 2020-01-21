
package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findVilles();

    public ArrayList<Ville> findVilleCodePostal(String codePostal);

	public void saveVille(Ville ville);
	
	public void updateVille(String codePostal, Ville ville);

}