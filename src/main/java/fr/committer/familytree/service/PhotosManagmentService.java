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
public class PhotosManagmentService {

    private final MembreRepository membreRepository;

    public Mono<Membre> addProfilePhoto(String pseudo, String path) {
        return null;
    }

    public Mono<Membre> deleteProfilePhoto(String pseudo, String path) {
        return null;
    }

    public Mono<Membre> updateProfilePhoto(String pseudo, String newPath) {
        return null;
    }

}