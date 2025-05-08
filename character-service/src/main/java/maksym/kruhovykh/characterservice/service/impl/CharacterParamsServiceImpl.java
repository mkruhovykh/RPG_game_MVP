package maksym.kruhovykh.characterservice.service.impl;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.CharacterRepository;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.Character;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.CharacterParams;
import maksym.kruhovykh.wekingsmonolith.mvp.service.CharacterParamsService;
import maksym.kruhovykh.wekingsmonolith.mvp.service.CharacterService;
import maksym.kruhovykh.wekingsmonolith.mvp.service.exceptions.InsufficientFundsException;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import static maksym.kruhovykh.wekingsmonolith.util.Constants.Params.*;

@Service
@RequiredArgsConstructor
public class CharacterParamsServiceImpl implements CharacterParamsService {
    private final CharacterService characterService;
    private final CharacterRepository characterRepository;

    @Override
    public void increaseStrength(String characterName) {
        increaseParam(characterName, STRENGTH, this::getPriceForStrengthByLvl);
    }

    @Override
    public void increaseMastery(String characterName) {
        increaseParam(characterName, MASTERY, this::getPriceForMasteryByLvl);
    }

    @Override
    public void increaseDefence(String characterName) {
        increaseParam(characterName, DEFENSE, this::getPriceForDefenceByLvl);
    }

    @Override
    public void increaseAgility(String characterName) {
        increaseParam(characterName, AGILITY, this::getPriceForAgilityByLvl);
    }

    @Override
    public void increaseHealth(String characterName) {
        increaseParam(characterName, HEALTH, this::getPriceForHealthByLvl);
    }

    private void increaseParam(String characterName, String param, Function<Integer, Integer> priceFunction) {
        Character character = characterRepository.findCharacterByName(characterName);
        CharacterParams params = character.getParams();
        int currentValue = switch (param) {
            case STRENGTH -> params.getStrength();
            case MASTERY -> params.getMastery();
            case DEFENSE -> params.getDefense();
            case AGILITY -> params.getAgility();
            case HEALTH -> params.getHealth();
            default -> throw new IllegalArgumentException("Unknown parameter: " + param);
        };

        int nextLevel = currentValue + 1;
        int upgradeCost = priceFunction.apply(nextLevel);
        int silver = character.getInventory().getSilver();

        if (!hasEnoughMoney(silver, upgradeCost)) {
            throw new InsufficientFundsException("Not enough money to increase " + param + ".");
        }

        character.getInventory().reduceSilver(upgradeCost);

        switch (param) {
            case STRENGTH:
                params.setStrength(nextLevel);
                break;
            case MASTERY:
                params.setMastery(nextLevel);
                break;
            case DEFENSE:
                params.setDefense(nextLevel);
                break;
            case AGILITY:
                params.setAgility(nextLevel);
                break;
            case HEALTH:
                params.setHealth(nextLevel);
                break;
        }

        characterService.updateCharacter(character);
    }

    @Override
    public Integer getPriceForStrengthByLvl(int level) {
        return (int) ((2.5 * (level * level)) - (22.5 * level) + 51);
    }

    @Override
    public Integer getPriceForMasteryByLvl(int level) {
        return (int) (0.9 * getPriceForStrengthByLvl(level));
    }

    @Override
    public Integer getPriceForDefenceByLvl(int level) {
        return (int) (0.7 * getPriceForStrengthByLvl(level));
    }

    @Override
    public Integer getPriceForAgilityByLvl(int level) {
        return (int) (0.65 * getPriceForStrengthByLvl(level));
    }

    @Override
    public Integer getPriceForHealthByLvl(int level) {
        return (int) (0.65 * getPriceForStrengthByLvl(level));
    }

    private boolean hasEnoughMoney(int silver, int upgradeCost) {
        return silver >= upgradeCost;
    }
}
