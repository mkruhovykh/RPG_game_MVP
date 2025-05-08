package maksym.kruhovykh.model.dto;

import lombok.Data;

@Data
public class CharacterStatisticsDto {

    private Long id;
    private Integer friends;
    private Integer level;
    private Integer experience;
    private Integer maxExperience;
    private Integer glory;
    private String clan;
    private String brotherhood;
    private Integer victories;
    private Integer defeats;
    private Integer lootGained;
    private Integer lootLost;
    private Integer itemsGained;
    private Integer minutesOnExpedition;
    private Integer hoursOnSite;
}
