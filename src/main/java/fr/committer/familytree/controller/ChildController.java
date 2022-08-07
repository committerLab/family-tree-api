package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Member;
import fr.committer.familytree.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/children")
public class ChildController {

	private final ChildService childService;

	/**
	 *
	 * @param member member
	 * @param child child
	 * @return added member
	 */
	@PostMapping
	public Mono<Member> addChild(@RequestBody Member member, @RequestBody Member child) {
		return childService.addChild(member, child);
	}

	/**
	 *
	 * @param memberPseudo member pseudo
	 * @param childPseudo child pseudo
	 * @return member with child
	 */
	@GetMapping( "/{parentPseudo}/{childPseudo}")
	public Mono<Member> addChildByPseudo(@PathVariable("parentPseudo") String memberPseudo, @PathVariable("childPseudo") String childPseudo) {
		return childService.addChild(memberPseudo, childPseudo);
	}
}
