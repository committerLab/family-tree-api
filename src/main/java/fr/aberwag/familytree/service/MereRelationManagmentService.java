package fr.aberwag.familytree.service;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.repository.MembreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class MereRelationManagmentService {

  @Autowired
  private MembreRepository membreRepository;

  public Mono<Membre> addMother(Membre child, Membre mother) {
    child.setMere(mother);
    return membreRepository.save(child);
  }

  public Mono<Membre> addMother(String childPseudo, String motherPseudo) {
    return null;
  }

}
