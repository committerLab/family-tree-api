package fr.committer.familytree.service;


import fr.committer.familytree.domain.Member;
import fr.committer.familytree.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpouseService {

  private final MemberRepository memberRepository;

  /**
   *
   * @param member member
   * @param spouse spouse
   * @return member
   */
  public Mono<Member> addConjoint(Member member, Member spouse) {
    member.setSpouse(spouse);
    return memberRepository.save(member);
  }

  public Mono<Member> deleteConjoint(Member member, Member spouse) {
    return memberRepository.findOneByPseudo(member.getPseudo())
        .filter(member1 -> member1.getSpouse().getPseudo().equals(spouse.getPseudo()))
        .map(member1 -> {
          member.setSpouse(null);
          return member;
        }).flatMap(member1 -> memberRepository.save(spouse));
  }

  public Mono<Member> addConjoint(String memberPseudo, String spousePseudo) {
    return Mono.zip(memberRepository.findOneByPseudo(memberPseudo), memberRepository.findOneByPseudo(spousePseudo))
        .map(objects -> {
          Member member = objects.getT1();
          member.setSpouse(objects.getT2());
          return member;
        }).flatMap(memberRepository::save);
  }

  public Mono<Member> deleteConjoint(String memberPseudo, String spousePseudo) {
    return memberRepository
        .findOneByPseudo(memberPseudo)
        .filter(member -> member.getSpouse().getPseudo().equals(spousePseudo))
        .map(member -> {
          member.setSpouse(null);
          return member;
        }).flatMap(memberRepository::save);
  }
}
