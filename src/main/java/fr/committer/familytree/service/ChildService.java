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
public class ChildService {
  private final MemberRepository memberRepository;
  /**
   *
   * @param child child member
   * @param father father member
   * @return Saved child
   */
  public Mono<Member> addChild(Member child, Member father) {
    child.setFather(father);
    return memberRepository.save(child);
  }

  /**
   *
   * @param childPseudo pseudo of the child
   * @param fatherPseudo pseudo of the father
   * @return saved child
   */
  public Mono<Member> addChild(String childPseudo, String fatherPseudo) {
    return Mono.zip(memberRepository.findOneByPseudo(childPseudo), memberRepository.findOneByPseudo(fatherPseudo))
        .map(objects -> {
          Member child = objects.getT1();
          child.setFather(objects.getT2());
          return child;
        })
        .flatMap(memberRepository::save);
  }
}