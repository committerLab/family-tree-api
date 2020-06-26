package fr.aberwag.familytree.mapper;

import fr.aberwag.familytree.domain.Membre;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MemberMapper {

  Membre mapMembre(Membre membre, Membre newMembre);
}