package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.MereRelationManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MereRelationManagmentController {

	private MereRelationManagmentService mereRelationManagmentService;
	public MereRelationManagmentController(MereRelationManagmentService mereRelationManagmentService){
		this.mereRelationManagmentService = mereRelationManagmentService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/mere")
	public Mono<Membre> addMother(@RequestBody Membre child, @RequestBody Membre Mother) {
		return mereRelationManagmentService.addMother(child, Mother);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/mere/{fils}")
	public Mono<Membre> addMotherByPsuedo(@RequestParam("fils") String childPseudo, @RequestParam("mere") String MotherPseudo) {
		return mereRelationManagmentService.addMother(childPseudo, MotherPseudo);
	}
}
