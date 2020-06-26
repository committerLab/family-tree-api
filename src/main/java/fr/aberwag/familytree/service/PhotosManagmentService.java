package fr.aberwag.familytree.service;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.repository.MembreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class PhotosManagmentService {

    @Autowired
    private MembreRepository membreRepository;

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