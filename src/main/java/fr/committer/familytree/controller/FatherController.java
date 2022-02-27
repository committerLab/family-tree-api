package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Member;
import fr.committer.familytree.service.FatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class FatherController {

	private final FatherService fatherService;

	/**
	 *
	 * @param child child
	 * @param Father father
	 * @return added father
	 */
	@PostMapping("/father")
	public Mono<Member> addFather(@RequestBody Member child, @RequestBody Member Father) {
		return fatherService.addFather(child, Father);
	}

	/**
	 *
	 * @param childPseudo child pseudo
	 * @param fatherPseudo father pseudo
	 * @return added father with child
	 */
	@PostMapping("/father/{father}/{child}")
	public Mono<Member> addFatherByPsuedo(@PathVariable("child") String childPseudo, @PathVariable("father") String fatherPseudo) {
		return fatherService.addFather(childPseudo, fatherPseudo);
	}

}
