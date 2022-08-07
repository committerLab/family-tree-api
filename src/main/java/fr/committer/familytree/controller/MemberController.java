package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Member;
import fr.committer.familytree.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {

	private final MemberService memberService;

	/**
	 *
	 * @param member member
	 * @return Add new member
	 */
	@PostMapping
	public Mono<Member> addMember(@RequestBody Member member) {
		return memberService.addMember(member);
	}

	/**
	 *
	 * @param pseudo pseud of member to delete
	 * @return deleted member
	 */
	@DeleteMapping( "/{pseudo}")
	public Mono<Member> deleteMember(@PathVariable("pseudo") String pseudo) {
		return memberService.deleteMember(pseudo);
	}

	/**
	 *
	 * @param pseudo pseudo of member
	 * @param member member information
	 * @return updated member
	 */
	@PutMapping( "/{pseudo}")
	public Mono<Member> updateMember(@PathVariable("pseudo") String pseudo, @RequestBody Member member) {
		return memberService.updateMember(member);
	}

	/**
	 *
	 * @param pseudo pseudo
	 * @return Member
	 */
	@GetMapping( "/{pseudo}")
	public Mono<Member> getMember(@PathVariable("pseudo") String pseudo) {
		return memberService.getMember(pseudo);
	}

	/**
	 *
	 * @return Flux of members
	 */
	@GetMapping
	public Flux<Member> getAllActiveMember() {
		return memberService.getAllMembers();
	}

}