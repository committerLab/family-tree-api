package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.SpooseManagmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class SpooseManagmentController {

	private final SpooseManagmentService conjointRelationManagmentService;

	/**
	 *
	 * @param member
	 * @param spoose
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/spoose")
	public Mono<Membre> addConjoint(@RequestBody Membre member, @RequestBody Membre spoose) {
		return conjointRelationManagmentService.addConjoint(member, spoose);
	}

	/**
	 *
	 * @param member
	 * @param spoose
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/spoose")
	public Mono<Membre> deleteConjoint(@RequestBody Membre member, @RequestBody Membre spoose) {
		return conjointRelationManagmentService.deleteConjoint(member, spoose);
	}

	/**
	 *
	 * @param memberPseudo
	 * @param spoosePseudo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/spoose/{fils}")
	public Mono<Membre> addConjointByPseudo(@RequestParam("member") String memberPseudo,
			@RequestParam("conjoint") String spoosePseudo) {
		return conjointRelationManagmentService.addConjoint(memberPseudo, spoosePseudo);
	}

	/**
	 * 
	 * @param memberPseudo
	 * @param spoosePseudo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/conjoint/{fils}")
	public Mono<Membre> deleteConjointByPseudo(@RequestParam("fils") String memberPseudo,
			@RequestParam("conjoint") String spoosePseudo) {
		return conjointRelationManagmentService.addConjoint(memberPseudo, spoosePseudo);
	}
}
