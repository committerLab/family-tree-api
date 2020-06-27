package fr.aberwag.familytree.domain;

import static org.neo4j.springframework.data.core.schema.Relationship.Direction.INCOMING;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Property;
import org.neo4j.springframework.data.core.schema.Relationship;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Node("Membre")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Membre {

  @Id
  @GeneratedValue
  private Long id;

  @Property(name = "pseudo")
  private String pseudo;

  @Property(name = "name")
  private String name;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Relationship(type = "PERE", direction = INCOMING)
  private Membre father;

  @Relationship(type = "MERE", direction = INCOMING)
  private Membre mother;

  @Relationship(type = "CONJOINT", direction = INCOMING)
  private Membre spoose;
}
