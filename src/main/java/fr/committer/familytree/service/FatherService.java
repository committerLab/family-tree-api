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
public class FatherService {

    private final MemberRepository memberRepository;

    /**
     *
     * @param child child ld
     * @param father father
     * @return Father with his child
     */
    public Mono<Member> addFather(Member child, Member father) {
        child.setFather(father);
        return memberRepository.save(child);
    }


    public Mono<Member> addFather(String childPseudo, String fatherPseudo) {
        return null;
    }
}