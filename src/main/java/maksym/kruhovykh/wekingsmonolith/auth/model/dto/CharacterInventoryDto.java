package maksym.kruhovykh.wekingsmonolith.auth.model.dto;

import lombok.Data;

@Data
public class CharacterInventoryDto {
    private Long id;

    private Integer gold;

    private Integer crystals;

    private Integer battlesCount;

    private Integer maxBattlesCount;

    private Integer silver;
}
