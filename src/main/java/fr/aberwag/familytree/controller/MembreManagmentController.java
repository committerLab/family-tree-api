package fr.aberwag.familytree.controller;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.service.MembreManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MembreManagmentController {

	MembreManagmentService membreManagmentService;
	public MembreManagmentController(MembreManagmentService membreManagmentService){
		this.membreManagmentService = membreManagmentService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/membres")
	public Mono<Membre> addMembre(@RequestBody Membre membre) {
		return membreManagmentService.addMembre(membre);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/membres/{pseudo}")
	public Mono<Membre> deleteMembre(@PathVariable("pseudo") String pseudo) {
		return membreManagmentService.deleteMembre(pseudo);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/membres/{pseudo}")
	public Mono<Membre> updateMembre(@PathVariable("pseudo") String pseudo, @RequestBody Membre membre) {
		return membreManagmentService.updateMembre(membre);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/membres/{pseudo}")
	public Mono<Membre> getMembre(@PathVariable("pseudo") String pseudo) {
		return membreManagmentService.getMembre(pseudo);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/membres")
	public Flux<Membre> getAllActiveMembre() {
		return membreManagmentService.getAllActifMembre();
	}

}