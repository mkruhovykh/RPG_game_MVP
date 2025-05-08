package maksym.kruhovykh.wekingsmonolith.mvp.model.dto;

import lombok.Data;

@Data
public class CharacterDto {

    private Long id;
    private String name;
    private UserDto user;
    private CharacterParamsDto params;
    private CharacterStatisticsDto statistics;
    private CharacterInventoryDto inventory;

}
