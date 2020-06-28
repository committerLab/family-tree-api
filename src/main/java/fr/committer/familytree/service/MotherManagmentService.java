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
public class MotherManagmentService {

  private final MembreRepository membreRepository;

  /**
   * Add mother
   * @param child child member
   * @param mother mother member
   * @return saved child
   */
  public Mono<Membre> addMother(Membre child, Membre mother) {
    child.setMother(mother);
    return membreRepository.save(child);
  }

  /**
   *
   * @param childPseudo child psuedo
   * @param motherPseudo morher pseudo
   * @return saved child
   */
  public Mono<Membre> addMother(String childPseudo, String motherPseudo) {
    return Mono.zip(membreRepository.findOneByPseudo(childPseudo), membreRepository.findOneByPseudo(motherPseudo))
        .map(objects -> {
          Membre child = objects.getT1();
          child.setMother(objects.getT2());
          return  child;
        }).flatMap(o -> membreRepository.save(o));
  }

}
