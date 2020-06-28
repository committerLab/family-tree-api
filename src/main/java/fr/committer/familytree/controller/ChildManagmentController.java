package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Membre;
import fr.committer.familytree.service.ChildManagmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ChildManagmentController {

	private final ChildManagmentService childManagmentService;

	/**
	 *
	 * @param member
	 * @param child
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/child")
	public Mono<Membre> addChild(@RequestBody Membre member, @RequestBody Membre child) {
		return childManagmentService.addChild(member, child);
	}

	/**
	 *
	 * @param memberPseudo
	 * @param childPseudo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/enfant/{fils}")
	public Mono<Membre> addChildByPseudo(@RequestParam("member") String memberPseudo, @RequestParam("child") String childPseudo) {
		return childManagmentService.addChild(memberPseudo, childPseudo);
	}
}
