package fr.committer.familytree.mapper;

import fr.committer.familytree.domain.Member;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MemberMapper {

  /**
   *
   * @param member
   * @return
   */
  Member mapMembre(Member member);
}