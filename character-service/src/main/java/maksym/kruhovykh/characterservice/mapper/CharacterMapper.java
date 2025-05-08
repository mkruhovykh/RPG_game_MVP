package maksym.kruhovykh.characterservice.mapper;

import maksym.kruhovykh.model.dto.CharacterDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, CharacterParamsMapper.class, CharacterInventoryMapper.class, CharacterStatisticsMapper.class})
public interface CharacterMapper {
    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);


    Character mapDtoToEntity(CharacterDto characterDto);

    CharacterDto mapEntityToDto(Character character);

}
