package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Member;
import fr.committer.familytree.service.MotherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MotherController {

	private final MotherService motherService;

	/**
	 *
	 * @param child child
	 * @param mother mother
	 * @return Mother with her child
	 */
	@PostMapping( "/mothers")
	public Mono<Member> addMother(@RequestBody Member child, @RequestBody Member mother) {
		return motherService.addMother(child, mother);
	}

	/**
	 *
	 * @param childPseudo child pseudo
	 * @param motherPseudo mother pseudo
	 * @return Mother with her child
	 */
	@PostMapping( "/mothers/{mother}/{child}")
	public Mono<Member> addMotherByPsuedo(@PathVariable("child") String childPseudo, @PathVariable("mother") String motherPseudo) {
		return motherService.addMother(childPseudo, motherPseudo);
	}
}
