package fr.committer.familytree.service;

import fr.committer.familytree.domain.Membre;
import fr.committer.familytree.repository.MembreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class FatherManagmenetService {

    private final MembreRepository membreRepository;

    /**
     *
     * @param child chiherld
     * @param father father
     * @return
     */
    public Mono<Membre> addFather(Membre child, Membre father) {
        child.setFather(father);
        return membreRepository.save(child);
    }


    public Mono<Membre> addFather(String childPseudo, String fatherPseudo) {
        return null;
    }
}