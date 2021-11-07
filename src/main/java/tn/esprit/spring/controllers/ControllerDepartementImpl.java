package tn.esprit.spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.mail.internet.ParseException;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.DepartementDTO;
import tn.esprit.spring.services.IDepartementService;

@Controller
public class ControllerDepartementImpl {
	@Autowired
	IDepartementService idepartementservice;
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		idepartementservice.affecterDepartementAEntreprise(depId, entrepriseId);
	}
	public int ajouterDepartement(Departement dep) {
		return idepartementservice.ajouterDepartement(dep);
	}
	public void deleteDepartementById(int depId) {
		idepartementservice.deleteDepartementById(depId);

	}
	
	

}
