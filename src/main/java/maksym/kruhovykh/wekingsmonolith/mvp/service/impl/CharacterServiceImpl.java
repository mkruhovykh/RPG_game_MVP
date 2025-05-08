package maksym.kruhovykh.wekingsmonolith.mvp.service.impl;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.CharacterDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.CharacterRepository;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.*;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.Character;
import maksym.kruhovykh.wekingsmonolith.mvp.service.CharacterService;
import maksym.kruhovykh.wekingsmonolith.mvp.service.mapper.CharacterMapper;
import org.springframework.stereotype.Service;

import static maksym.kruhovykh.wekingsmonolith.util.CharacterCreationUtil.createNewCharacter;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    @Override
    public void createCharacterForUser(User user) {
        characterRepository.save(createNewCharacter(user));
    }

    @Override
    public CharacterDto getCharacterByName(String characterName) {
        Character characterByName = characterRepository.findCharacterByName(characterName);
        return CharacterMapper.INSTANCE.mapEntityToDto(characterByName);
    }

    @Override
    public void updateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character should be present");
        }
        characterRepository.save(character);
    }
}
