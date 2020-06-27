package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.FatherManagmenetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class FatherManagmentController {

	private final FatherManagmenetService fatherManagmenetService;

	/**
	 *
	 * @param child
	 * @param Father
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/father")
	public Mono<Membre> addFather(@RequestBody Membre child, @RequestBody Membre Father) {
		return fatherManagmenetService.addFather(child, Father);
	}

	/**
	 *
	 * @param childPseudo
	 * @param FatherPseudo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/father/{fils}")
	public Mono<Membre> addFatherByPsuedo(@RequestParam("member") String childPseudo, @RequestParam("father") String FatherPseudo) {
		return fatherManagmenetService.addFather(childPseudo, FatherPseudo);
	}

}
