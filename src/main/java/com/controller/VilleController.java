package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
//@RequestMapping("/path")
class VilleController {
	
	@Autowired
	VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> recover(@RequestParam(required = false, value = "codePostal") String codePostal) {
		System.out.println("Appel GET");

		ArrayList<Ville> listVille = villeService.getInfoVilles(codePostal);
		return listVille;
	}

	// Methode POST
	@RequestMapping(value="/ville", method=RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Ville ville, Model model) {
		System.out.println("Appel POST");
		System.out.println("ville Post : " + ville.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(ville);
			System.out.println("ville Json : " + jsonInString);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	    villeService.insertVille(ville);
		return "index";
	}
	
	// Methode PUT
	public String update(@PathVariable String codePostal, @RequestBody Ville ville, Model model) {
		System.out.println("Appel PUT");

	    System.out.println(codePostal);
	    System.out.println(ville.getCodePostal());
	    villeService.updateVille(codePostal, ville);
		return "index";
	}

}