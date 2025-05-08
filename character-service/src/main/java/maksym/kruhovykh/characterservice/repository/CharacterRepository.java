package maksym.kruhovykh.characterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findCharacterByName(String name);

}
