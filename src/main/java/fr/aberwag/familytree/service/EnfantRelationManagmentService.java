package fr.aberwag.familytree.service;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.repository.MembreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class EnfantRelationManagmentService {

  @Autowired
  private MembreRepository membreRepository;

  public Mono<Membre> addChild(Membre child, Membre Father) {
    return null;
  }

  public Mono<Membre> addChild(String childPseudo, String FatherPeudo) {
    return null;
  }

  public Mono<Membre> deleteChild(Membre child, Membre Father) {
    return null;
  }

  public Mono<Membre> deleteChild(String child, String Father) {
    return null;
  }
}