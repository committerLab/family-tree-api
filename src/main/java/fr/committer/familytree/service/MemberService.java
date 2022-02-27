package fr.committer.familytree.service;

import fr.committer.familytree.domain.Member;
import fr.committer.familytree.mapper.MemberMapper;
import fr.committer.familytree.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final MemberMapper memberMapper;

  /**
   * Add member
   * @param member member
   * @return saved member
   */
  public Mono<Member> addMember(Member member) {
    return memberRepository.save(member);
  }

  /**
   * Delete member
   * @param pseudo pseudo
   * @return Deleted member
   */
  public Mono<Member> deleteMember(String pseudo) {
    return memberRepository.findOneByPseudo(pseudo)
        .map(member -> {
          member.setActif(false);
          return member;
        }).flatMap(memberRepository::save);
  }

  public Mono<Member> updateMember(Member member) {
    return memberRepository.findOneByPseudo(member.getPseudo())
        .map(memberMapper::mapMembre)
        .flatMap(memberRepository::save);
  }

  /**
   * Update member
   * @param pseudo pseudo of member
   * @param member new member info
   * @return updated member
   */
  public Mono<Member> updateMember(String pseudo, Member member) {
    return memberRepository.findOneByPseudo(pseudo)
        .map(memberMapper::mapMembre)
        .flatMap(memberRepository::save);
  }

  /**
   * Get member by provided id
   * @param pseudo pseudo of member
   * @return member
   */
  public Mono<Member> getMember(String pseudo) {
    return memberRepository.findOneByPseudo(pseudo);
  }

  /**
   * Get all members
   * @return All members
   */
  public Flux<Member> getAllMembers() {
    return memberRepository.findByActifTrue();
  }

}