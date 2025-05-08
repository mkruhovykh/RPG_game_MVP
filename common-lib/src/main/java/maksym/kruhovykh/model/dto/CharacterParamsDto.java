package maksym.kruhovykh.model.dto;

import lombok.Data;

@Data
public class CharacterParamsDto {

    private Long id;
    private Integer strength;
    private Integer defense;
    private Integer agility;
    private Integer mastery;
    private Integer vitality;
    private Integer health;
    private Integer maxHealth;
    private Integer healthRegen;
}
