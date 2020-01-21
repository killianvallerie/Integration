package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	@Override
	public ArrayList<Ville> getInfoVilles(String codePostal) throws VilleException {
		ArrayList<Ville> listVille;
		
		// dans le cas ou numTrain est null ou vide = récupération de l'ensemble des informations
        if (codePostal == null || "".equalsIgnoreCase(codePostal)) {
			listVille = villeDAO.findVilles();
		} else {
			listVille = villeDAO.findVilleCodePostal(codePostal);
		}
        
        System.out.println("Nombre de ville récupérée(s) : " + listVille.size() );
		
		return listVille;
	}
	
	@Override
	public void insertVille(Ville ville) throws VilleException {

		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.saveVille(ville);
		} 
	}
	
	@Override
	public void updateVille(String codePostal, Ville ville) throws VilleException {

		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.updateVille(codePostal, ville);
		} 
	}

}
