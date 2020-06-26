package fr.aberwag.familytree.service;

import fr.aberwag.familytree.domain.Membre;
import fr.aberwag.familytree.mapper.MemberMapper;
import fr.aberwag.familytree.repository.MembreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class MembreManagmentService {

  private MembreRepository membreRepository;
  private MemberMapper memberMapper;

  public MembreManagmentService(MemberMapper memberMapper, MembreRepository membreRepository) {
    this.membreRepository = membreRepository;
    this.memberMapper = memberMapper;
  }

  public Mono<Membre> addMembre(Membre membre) {
    log.info("membre.getPseudo() ======> {}", membre.getPseudo());
    log.info("membreRepository =====> {}", membreRepository);
		/* membreRepository.findOneByPseudo(membre.getPseudo()).ifPresent(m -> {
			throw new FamilyBusinessException("Le client existe dans la base");
		});*/
    log.info("membreRepository.findOneByPseudo(membre.getPseudo()) ======> {}", membreRepository.findOneByPseudo(membre.getPseudo()));
    return membreRepository.save(membre);
  }

  public Mono<Membre> deleteMembre(String pseudo) {
    return membreRepository.findOneByPseudo(pseudo)
        .map(membre -> {
          membre.setActif(false);
          return membre;
        }).flatMap(membre -> membreRepository.save(membre));
  }

  public Mono<Membre> updateMembre(Membre membre) {
    return membreRepository.findOneByPseudo(membre.getPseudo())
        .map(m -> memberMapper.mapMembre(m, membre))
        .flatMap(m -> membreRepository.save(m));
  }

  public Mono<Membre> updateMembre(String pseudo, Membre membre) {
    return membreRepository.findOneByPseudo(pseudo)
        .map(m -> memberMapper.mapMembre(m, membre))
        .flatMap(m -> membreRepository.save(m));
  }

  public Mono<Membre> getMembre(String pseudo) {
    return membreRepository.findOneByPseudo(pseudo);
  }

  public Flux<Membre> getAllActifMembre() {
    return membreRepository.findByActifTrue();
  }

}