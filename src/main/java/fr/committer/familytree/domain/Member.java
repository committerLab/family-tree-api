package fr.committer.familytree.domain;

import static org.neo4j.springframework.data.core.schema.Relationship.Direction.INCOMING;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

import lombok.*;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Property;
import org.neo4j.springframework.data.core.schema.Relationship;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Node("Member")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  @Property(name = "pseudo")
  private String pseudo;

  @Property(name = "nom")
  private String nom;

  @Property(name = "prenom")
  private String prenom;

  @Property(name = "civilite")
  private String civilite;

  @Property(name = "dateNaissance")
  private Date dateNaissance;

  @Property(name = "lieuNaissance")
  private String lieuDeNaissance;

  @Property(name = "latitudeNaissance")
  private Double latitudeNaissance;

  @Property(name = "longitudeNaissance")
  private Double longitudeNaissance;

    @Property(name = "description")
  private String description;

  @Property(name = "photo")
  private String photo;

  @Property(name = "actif")
  private boolean actif = true;

  @Property(name = "vivant")
  private boolean vivant = true;

  @Property(name = "numeroPortable")
  private String numeroPortable;

  @Property(name = "numeroFixe")
  private String numeroFixe;

  @Property(name = "paysDeResidence")
  private String paysDeResidence;

  @Property(name = "villeDeResidence")
  private String villeDeResidence;

  @Property(name = "adresse")
  private String adresse;

  @Property(name = "dateDeces")
  private Date dateDeces;

  @Property(name = "email")
  private String email;

  @Relationship(type = "Mother", direction = INCOMING)
  private Member father;

  @Relationship(type = "Father", direction = INCOMING)
  private Member mother;

  @Relationship(type = "Spouse", direction = INCOMING)
  private Member spouse;
}
