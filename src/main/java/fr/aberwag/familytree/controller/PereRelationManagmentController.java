package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.PereRelationmanagmenetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class PereRelationManagmentController {

	private PereRelationmanagmenetService pereRelationmanagmenetService;
	public PereRelationManagmentController(PereRelationmanagmenetService pereRelationmanagmenetService){
		this.pereRelationmanagmenetService = pereRelationmanagmenetService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pere")
	public Mono<Membre> addFather(@RequestBody Membre child, @RequestBody Membre Father) {
		return pereRelationmanagmenetService.addFather(child, Father);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pere/{fils}")
	public Mono<Membre> addFatherByPsuedo(@RequestParam("fils") String childPseudo, @RequestParam("pere") String FatherPseudo) {
		return pereRelationmanagmenetService.addFather(childPseudo, FatherPseudo);
	}

}
