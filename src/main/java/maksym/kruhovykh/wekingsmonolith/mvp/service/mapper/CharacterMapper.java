package maksym.kruhovykh.wekingsmonolith.mvp.service.mapper;

import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.CharacterDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.Character;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, CharacterParamsMapper.class, CharacterInventoryMapper.class, CharacterStatisticsMapper.class})
public interface CharacterMapper {
    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);


    Character mapDtoToEntity(CharacterDto characterDto);

    CharacterDto mapEntityToDto(Character character);

}
