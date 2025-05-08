package maksym.kruhovykh.wekingsmonolith.mvp.service;

import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.CharacterDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.Character;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.User;

public interface CharacterService {
    void createCharacterForUser(User user);

    CharacterDto getCharacterByName(String userName);
    void updateCharacter(Character character);
}
