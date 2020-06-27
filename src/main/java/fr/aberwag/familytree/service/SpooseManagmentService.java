package fr.aberwag.familytree.service;


import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.repository.MembreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpooseManagmentService {

  private final MembreRepository membreRepository;

  /**
   *
   * @param membre nember
   * @param spoose spoose
   * @return
   */
  public Mono<Membre> addConjoint(Membre membre, Membre spoose) {
    membre.setSpoose(spoose);
    return membreRepository.save(membre);
  }

  public Mono<Membre> deleteConjoint(Membre membre, Membre spoose) {
    return membreRepository.findOneByPseudo(membre.getPseudo())
        .filter(membre1 -> membre1.getSpoose().getPseudo().equals(spoose.getPseudo()))
        .map(membre1 -> {
          membre.setSpoose(null);
          return membre;
        }).flatMap(membre1 -> membreRepository.save(spoose));
  }

  public Mono<Membre> addConjoint(String membrePseudo, String spoosePseudo) {
    return Mono.zip(membreRepository.findOneByPseudo(membrePseudo), membreRepository.findOneByPseudo(spoosePseudo))
        .map(objects -> {
          Membre membre = objects.getT1();
          membre.setSpoose(objects.getT2());
          return membre;
        }).flatMap(membre -> membreRepository.save(membre));
  }

  public Mono<Membre> deleteConjoint(String membrePseudo, String spoosePseudo) {
    return membreRepository
        .findOneByPseudo(membrePseudo)
        .filter(membre -> membre.getSpoose().getPseudo().equals(spoosePseudo))
        .map(membre -> {
          membre.setSpoose(null);
          return membre;
        }).flatMap(membre -> membreRepository.save(membre));
  }
}
