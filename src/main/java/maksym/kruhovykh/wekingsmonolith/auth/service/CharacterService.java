package maksym.kruhovykh.wekingsmonolith.auth.service;

import maksym.kruhovykh.wekingsmonolith.auth.model.dto.CharacterDto;
import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.Character;
import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.User;

public interface CharacterService {
    void createCharacterForUser(User user);

    CharacterDto getCharacterByName(String userName);
    void updateCharacter(Character character);
}
