package maksym.kruhovykh.wekingsmonolith.auth.service.mapper;

import maksym.kruhovykh.wekingsmonolith.auth.model.dto.CharacterParamsDto;
import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.CharacterParams;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterParamsMapper {
    CharacterParamsMapper INSTANCE = Mappers.getMapper(CharacterParamsMapper.class);

    CharacterParamsDto mapEntityToDto(CharacterParams params);

    CharacterParams mapDtoToEntity(CharacterParamsDto paramsDto);
}