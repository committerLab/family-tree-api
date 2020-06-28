package fr.committer.familytree.repository;

import fr.committer.familytree.domain.Membre;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface MembreRepository extends ReactiveNeo4jRepository<Membre, Long> {

  /**
   * Get member bi provided ID
   * @param pseudo pseudo of memer
   * @return one member
   */
  Mono<Membre> findOneByPseudo(String pseudo);

  /**
   * Get all members
   * @return all members
   */
  Flux<Membre> findByActifTrue();
}
