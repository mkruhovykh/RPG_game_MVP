package maksym.kruhovykh.characterservice.mapper;

import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.CharacterParamsDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.CharacterParams;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterParamsMapper {
    CharacterParamsMapper INSTANCE = Mappers.getMapper(CharacterParamsMapper.class);

    CharacterParamsDto mapEntityToDto(CharacterParams params);

    CharacterParams mapDtoToEntity(CharacterParamsDto paramsDto);
}