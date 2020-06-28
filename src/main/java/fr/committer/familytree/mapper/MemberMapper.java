package fr.committer.familytree.mapper;

import fr.committer.familytree.domain.Membre;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MemberMapper {

  /**
   *
   * @param membre
   * @return
   */
  Membre mapMembre(Membre membre);
}