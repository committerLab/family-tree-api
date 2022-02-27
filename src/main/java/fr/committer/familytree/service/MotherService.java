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
public class MotherService {

  private final MemberRepository memberRepository;

  /**
   * Add mother
   * @param child child member
   * @param mother mother member
   * @return saved child
   */
  public Mono<Member> addMother(Member child, Member mother) {
    child.setMother(mother);
    return memberRepository.save(child);
  }

  /**
   *
   * @param childPseudo child pseudo
   * @param motherPseudo mother pseudo
   * @return saved child
   */
  public Mono<Member> addMother(String childPseudo, String motherPseudo) {
    return Mono.zip(memberRepository.findOneByPseudo(childPseudo), memberRepository.findOneByPseudo(motherPseudo))
        .map(objects -> {
          Member child = objects.getT1();
          child.setMother(objects.getT2());
          return  child;
        }).flatMap(memberRepository::save);
  }

}
