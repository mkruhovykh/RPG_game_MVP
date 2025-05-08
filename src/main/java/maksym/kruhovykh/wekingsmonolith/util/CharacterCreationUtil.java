package maksym.kruhovykh.wekingsmonolith.util;

import lombok.experimental.UtilityClass;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.CharacterInventory;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.CharacterParams;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.CharacterStatistics;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.User;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.Character;

@UtilityClass
public class CharacterCreationUtil {
    public static Character createNewCharacter(User user) {
        CharacterParams params = CharacterParams.builder()
                .strength(5)
                .defense(5)
                .agility(5)
                .mastery(5)
                .vitality(5)
                .health(100)
                .maxHealth(100)
                .healthRegen(10)
                .build();

        // Create CharacterStatistics with default values
        CharacterStatistics statistics = CharacterStatistics.builder()
                .friends(0)
                .level(1)
                .experience(0)
                .maxExperience(5)
                .glory(0)
                .clan("Не состоит в клане")
                .brotherhood("Не состоит в братстве")
                .victories(0)
                .defeats(0)
                .lootGained(0)
                .lootLost(0)
                .itemsGained(0)
                .minutesOnExpedition(0)
                .hoursOnSite(0)
                .build();

        // Create CharacterInventory with default values
        CharacterInventory inventory = CharacterInventory.builder()
                .silver(10000)
                .crystals(0)
                .gold(10)
                .battlesCount(3)
                .maxBattlesCount(3)
                .build();

        // Create and return the Character object
        return Character.builder()
                .name(user.getUsername())
                .statistics(statistics)
                .params(params)
                .user(user)
                .inventory(inventory)
                .build();
    }
}
