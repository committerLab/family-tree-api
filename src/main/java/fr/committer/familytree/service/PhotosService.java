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
public class PhotosService {

    private final MemberRepository memberRepository;

    public Mono<Member> addProfilePhoto(String pseudo, String path) {
        return null;
    }

    public Mono<Member> deleteProfilePhoto(String pseudo, String path) {
        return null;
    }

    public Mono<Member> updateProfilePhoto(String pseudo, String newPath) {
        return null;
    }

}