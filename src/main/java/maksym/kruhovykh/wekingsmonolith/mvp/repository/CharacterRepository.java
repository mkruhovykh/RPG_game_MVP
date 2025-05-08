package maksym.kruhovykh.wekingsmonolith.mvp.repository;

import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findCharacterByName(String name);

}
