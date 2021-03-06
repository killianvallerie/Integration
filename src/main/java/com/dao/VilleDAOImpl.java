package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfigurationSol1;
import com.dto.LieuVille;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	@Override
	public ArrayList<Ville> findVilles() {
			return this.findVillesCodePostal("*");
	}

	@Override
	public ArrayList<Ville> findVillesCodePostal(String codePostal) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		try {
			// solution 1
			Connection con = JDBCConfigurationSol1.getConnection();
		
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ville_france where Code_postal = ?");
			statement.setString(1, codePostal);
			
			// execution 
            ResultSet resultSet = statement.executeQuery();

            // close de la connexion
			resultSet.close();
			statement.close();
			
            // parcourt des éléments de réponse
			while(resultSet.next()){
				Ville ville = new Ville();
				
				ville.setCodeCommune(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne(resultSet.getString("Ligne_5"));
				LieuVille coordonnee = new LieuVille();
				coordonnee.setLatitude(resultSet.getString("Latitude"));
				coordonnee.setLongitude(resultSet.getString("Longitude"));
				ville.setLieu(coordonnee);
  
				listVille.add(ville);
			}
			    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return listVille;       
    }
	
	@Override
    public void insertVille(Ville ville) {

		try {
			// solution 1
			Connection con = JDBCConfigurationSol1.getConnection();
			
			String insertTableSQL = "INSERT INTO ville_france "
					+ "(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement,"
					+ " Ligne_5, Latitude, Longitude) VALUES (?,?,?,?,?,?,?) ";
			
			PreparedStatement statement = con.prepareStatement(insertTableSQL);
			statement.setString(1, ville.getCodeCommune());
			statement.setString(2, ville.getNomCommune());
			statement.setString(3, ville.getCodePostal());
			statement.setString(4, ville.getLibelleAcheminement());
			statement.setString(5, ville.getLigne());
			statement.setString(6, ville.getLieu().getLatitude());
			statement.setString(7, ville.getLieu().getLongitude());

			statement.executeUpdate();
            
            // close de la connexion
			statement.close();
			    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
            
    }
	
	@Override
    public void updateVille(String codePostal, Ville ville) {

		try {
			// solution 1
			Connection con = JDBCConfigurationSol1.getConnection();
			
			String updateTableSQL = "UPDATE ville_france SET "
					+ "Code_commune_INSEE = ?, Nom_commune = ?, Code_postal = ?,"
					+ " Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?,"
					+ " Longitude = ? WHERE Code_postal = ? ";
			

			PreparedStatement statement = con.prepareStatement(updateTableSQL);
			statement.setString(1, ville.getCodeCommune());
			statement.setString(2, ville.getNomCommune());
			statement.setString(3, codePostal);
			statement.setString(4, ville.getLibelleAcheminement());
			statement.setString(5, ville.getLigne());
			statement.setString(6, ville.getLieu().getLatitude());
			statement.setString(7, ville.getLieu().getLongitude());
			statement.setString(8, codePostal);

			statement.executeUpdate();
            
            // close de la connexion
			statement.close();
			    
		} catch (SQLException e) {
		    e.printStackTrace();
		}
            
    }
}