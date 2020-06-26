package fr.aberwag.familytree.repository;

import java.util.List;
import java.util.Optional;

import fr.aberwag.familytree.domain.Membre;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface MembreRepository extends ReactiveNeo4jRepository<Membre, String> {
    Mono<Membre> findOneByPseudo(String pseudo);
    Flux<Membre> findByActifTrue();
}
