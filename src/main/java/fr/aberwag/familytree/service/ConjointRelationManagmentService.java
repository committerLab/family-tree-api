package fr.aberwag.familytree.service;


import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.repository.MembreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ConjointRelationManagmentService {

  @Autowired
  private MembreRepository membreRepository;

  public Mono<Membre> addConjoint(Membre membre, Membre conjoint) {
    membre.setConjoint(conjoint);
    return membreRepository.save(membre);
  }

  public Mono<Membre> deleteConjoint(Membre membre, Membre conjoint) {
    return membreRepository.findOneByPseudo(membre.getPseudo())
        .filter(membre1 -> membre1.getConjoint().getPseudo().equals(conjoint.getPseudo()))
        .map(membre1 -> {
          membre.setConjoint(null);
          return membre;
        }).flatMap(membre1 -> membreRepository.save(conjoint));
  }

  public Mono<Membre> addConjoint(String membrePseudo, String conjointPseudo) {
    return Mono.zip(membreRepository.findOneByPseudo(membrePseudo), membreRepository.findOneByPseudo(conjointPseudo))
        .map(objects -> {
          Membre membre = objects.getT1();
          membre.setConjoint(objects.getT2());
          return membre;
        }).flatMap(membre -> membreRepository.save(membre));
  }

  public Mono<Membre> deleteConjoint(String membrePseudo, String conjointPseudo) {
    return membreRepository
        .findOneByPseudo(membrePseudo)
        .filter(membre -> membre.getConjoint().getPseudo().equals(conjointPseudo))
        .map(membre -> {
          membre.setConjoint(null);
          return membre;
        }).flatMap(membre -> membreRepository.save(membre));
  }
}
