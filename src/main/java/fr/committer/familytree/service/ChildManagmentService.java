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
public class ChildManagmentService {
  private final MembreRepository membreRepository;
  /**
   *
   * @param child child membre
   * @param father father member
   * @return Saved child
   */
  public Mono<Membre> addChild(Membre child, Membre father) {
    child.setFather(father);
    return membreRepository.save(child);
  }

  /**
   *
   * @param childPseudo pseudo of the child
   * @param fatherPeudo pseudo of the father
   * @return saved child
   */
  public Mono<Membre> addChild(String childPseudo, String fatherPeudo) {
    return Mono.zip(membreRepository.findOneByPseudo(childPseudo), membreRepository.findOneByPseudo(fatherPeudo))
        .map(objects -> {
          Membre  child = objects.getT1();
          child.setFather(objects.getT2());
          return child;
        })
        .flatMap(membre -> membreRepository.save(membre));
  }
}