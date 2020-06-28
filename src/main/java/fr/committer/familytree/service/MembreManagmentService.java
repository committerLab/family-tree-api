package fr.committer.familytree.service;

import fr.committer.familytree.domain.Membre;
import fr.committer.familytree.mapper.MemberMapper;
import fr.committer.familytree.repository.MembreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class MembreManagmentService {

  private final MembreRepository membreRepository;
  private final MemberMapper memberMapper;

  /**
   * Add membre
   * @param membre member
   * @return saved member
   */
  public Mono<Membre> addMembre(Membre membre) {
    return membreRepository.save(membre);
  }

  /**
   * Delete membre
   * @param pseudo
   * @return
   */
  public Mono<Membre> deleteMembre(String pseudo) {
    return membreRepository.findOneByPseudo(pseudo)
        .map(membre -> {
          membre.setActif(false);
          return membre;
        }).flatMap(membre -> membreRepository.save(membre));
  }

  public Mono<Membre> updateMembre(Membre membre) {
    return membreRepository.findOneByPseudo(membre.getPseudo())
        .map(member -> memberMapper.mapMembre(member))
        .flatMap(member -> membreRepository.save(member));
  }

  /**
   * Update member
   * @param pseudo pseudo of member
   * @param membre new membre info
   * @return updated member
   */
  public Mono<Membre> updateMembre(String pseudo, Membre membre) {
    return membreRepository.findOneByPseudo(pseudo)
        .map(member -> memberMapper.mapMembre(member))
        .flatMap(member -> membreRepository.save(member));
  }

  /**
   * Get membre by provided id
   * @param pseudo pseudo of membre
   * @return membre
   */
  public Mono<Membre> getMembre(String pseudo) {
    return membreRepository.findOneByPseudo(pseudo);
  }

  /**
   * Get all members
   * @return All members
   */
  public Flux<Membre> getAllMembers() {
    return membreRepository.findByActifTrue();
  }

}