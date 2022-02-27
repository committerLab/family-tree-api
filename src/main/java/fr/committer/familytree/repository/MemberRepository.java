package fr.committer.familytree.repository;

import fr.committer.familytree.domain.Member;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface MemberRepository extends ReactiveNeo4jRepository<Member, Long> {

  /**
   * Get member bi provided ID
   * @param pseudo pseudo of member
   * @return one member
   */
  Mono<Member> findOneByPseudo(String pseudo);

  /**
   * Get all members
   * @return all members
   */
  Flux<Member> findByActifTrue();
}
