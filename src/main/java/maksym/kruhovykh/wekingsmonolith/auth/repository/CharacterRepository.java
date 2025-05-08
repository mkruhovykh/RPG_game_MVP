package maksym.kruhovykh.wekingsmonolith.auth.repository;

import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findCharacterByName(String name);

}
