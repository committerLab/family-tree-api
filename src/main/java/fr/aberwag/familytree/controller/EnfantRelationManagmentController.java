package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.EnfantRelationManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class EnfantRelationManagmentController {

	private EnfantRelationManagmentService enfantRelationManagmentService;
	public EnfantRelationManagmentController(EnfantRelationManagmentService enfantRelationManagmentService){
		this.enfantRelationManagmentService = enfantRelationManagmentService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/enfant")
	public Mono<Membre> addEnfant(@RequestBody Membre child, @RequestBody Membre Enfant) {
		return enfantRelationManagmentService.addChild(child, Enfant);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/enfant")
	public Mono<Membre> deleteEnfant(@RequestBody Membre child, @RequestBody Membre Enfant) {
		return enfantRelationManagmentService.deleteChild(child, Enfant);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/enfant/{fils}")
	public Mono<Membre> addChildByPseudo(@RequestParam("fils") String childPseudo, @RequestParam("enfant") String EnfantPseudo) {
		return enfantRelationManagmentService.addChild(childPseudo, EnfantPseudo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/enfant/{fils}")
	public Mono<Membre> deleteChildByPseudo(@RequestParam("fils") String childPseudo, @RequestParam("enfant") String EnfantPseudo) {
		return enfantRelationManagmentService.deleteChild(childPseudo, EnfantPseudo);
	}
}
