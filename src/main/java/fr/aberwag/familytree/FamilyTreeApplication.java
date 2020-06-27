package fr.aberwag.familytree;

import org.neo4j.springframework.data.repository.config.EnableReactiveNeo4jRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FamilyTreeApplication {
	public static void main(String[] args) {
		SpringApplication.run(FamilyTreeApplication.class, args);
	}
}
