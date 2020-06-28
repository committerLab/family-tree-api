package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Membre;
import fr.committer.familytree.service.MotherManagmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MotherManagmentController {

	private final MotherManagmentService motherManagmentService;

	/**
	 *
	 * @param child
	 * @param mother
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/mother")
	public Mono<Membre> addMother(@RequestBody Membre child, @RequestBody Membre mother) {
		return motherManagmentService.addMother(child, mother);
	}

	/**
	 *
	 * @param childPseudo
	 * @param motherPseudo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/mother/{mother}")
	public Mono<Membre> addMotherByPsuedo(@RequestParam("member") String childPseudo, @RequestParam("mother") String motherPseudo) {
		return motherManagmentService.addMother(childPseudo, motherPseudo);
	}
}
