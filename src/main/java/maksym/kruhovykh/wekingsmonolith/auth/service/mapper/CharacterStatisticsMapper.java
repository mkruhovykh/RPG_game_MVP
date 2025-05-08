package maksym.kruhovykh.wekingsmonolith.auth.service.mapper;

import maksym.kruhovykh.wekingsmonolith.auth.model.dto.CharacterStatisticsDto;
import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.CharacterStatistics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterStatisticsMapper {
    CharacterStatisticsMapper INSTANCE = Mappers.getMapper(CharacterStatisticsMapper.class);

    CharacterStatisticsDto mapEntityToDto(CharacterStatistics statistics);

    CharacterStatistics mapDtoToEntity(CharacterStatisticsDto statisticsDto);
}