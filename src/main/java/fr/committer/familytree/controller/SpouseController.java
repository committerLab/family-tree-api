package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Member;
import fr.committer.familytree.service.SpouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("spouses")
public class SpouseController {

	private final SpouseService spouseService;

	/**
	 *
	 * @param member member
	 * @param spouse spouse
	 * @return Member with his spouse
	 */
	@PostMapping
	public Mono<Member> addConjoint(@RequestBody Member member, @RequestBody Member spouse) {
		return spouseService.addConjoint(member, spouse);
	}

	/**
	 *
	 * @param member member
	 * @param spouse spouse
	 * @return divorced member
	 */
	@DeleteMapping
	public Mono<Member> deleteConjoint(@RequestBody Member member, @RequestBody Member spouse) {
		return spouseService.deleteConjoint(member, spouse);
	}

	/**
	 *
	 * @param memberPseudo member pseudo
	 * @param spousePseudo spouse pseudo
	 * @return Married member
	 */
	@GetMapping( "/{member}/{conjoint}")
	public Mono<Member> addConjointByPseudo(@PathVariable("member") String memberPseudo,
											@PathVariable("conjoint") String spousePseudo) {
		return spouseService.addConjoint(memberPseudo, spousePseudo);
	}

	/**
	 * 
	 * @param memberPseudo member pseudo
	 * @param spousePseudo spouse pseudo
	 * @return Divorced member
	 */
	@DeleteMapping( "/{member}/{conjoint}")
	public Mono<Member> deleteConjointByPseudo(@PathVariable("member") String memberPseudo,
											   @PathVariable("conjoint") String spousePseudo) {
		return spouseService.addConjoint(memberPseudo, spousePseudo);
	}
}
