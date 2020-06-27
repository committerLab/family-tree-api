package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.MembreManagmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class MembreManagmentController {

	private final MembreManagmentService membreManagmentService;

	/**
	 *
	 * @param membre
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/membres")
	public Mono<Membre> addMembre(@RequestBody Membre membre) {
		return membreManagmentService.addMembre(membre);
	}

	/**
	 *
	 * @param pseudo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/membres/{pseudo}")
	public Mono<Membre> deleteMembre(@PathVariable("pseudo") String pseudo) {
		return membreManagmentService.deleteMembre(pseudo);
	}

	/**
	 *
	 * @param pseudo
	 * @param membre
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/membres/{pseudo}")
	public Mono<Membre> updateMembre(@PathVariable("pseudo") String pseudo, @RequestBody Membre membre) {
		return membreManagmentService.updateMembre(membre);
	}

	/**
	 *
	 * @param pseudo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/membres/{pseudo}")
	public Mono<Membre> getMembre(@PathVariable("pseudo") String pseudo) {
		return membreManagmentService.getMembre(pseudo);
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/membres")
	public Flux<Membre> getAllActiveMembre() {
		return membreManagmentService.getAllMembers();
	}

}