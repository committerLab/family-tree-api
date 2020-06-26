package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.ConjointRelationManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class ConjointRelationManagmentController {

	@Autowired
	private ConjointRelationManagmentService conjointRelationManagmentService;

	@RequestMapping(method = RequestMethod.POST, value = "/conjoint")
	public Mono<Membre> addConjoint(@RequestBody Membre child, @RequestBody Membre Conjoint) {
		return conjointRelationManagmentService.addConjoint(child, Conjoint);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/conjoint")
	public Mono<Membre> deleteConjoint(@RequestBody Membre child, @RequestBody Membre Conjoint) {
		return conjointRelationManagmentService.deleteConjoint(child, Conjoint);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/conjoints/{fils}")
	public Mono<Membre> addConjointByPseudo(@RequestParam("fils") String childPseudo,
			@RequestParam("conjoint") String ConjointPseudo) {
		return conjointRelationManagmentService.addConjoint(childPseudo, ConjointPseudo);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/conjoint/{fils}")
	public Mono<Membre> deleteConjointByPseudo(@RequestParam("fils") String childPseudo,
			@RequestParam("conjoint") String ConjointPseudo) {
		return conjointRelationManagmentService.addConjoint(childPseudo, ConjointPseudo);
	}
}
