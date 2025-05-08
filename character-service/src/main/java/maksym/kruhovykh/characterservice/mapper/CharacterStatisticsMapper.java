package maksym.kruhovykh.characterservice.mapper;

import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.CharacterStatisticsDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.CharacterStatistics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterStatisticsMapper {
    CharacterStatisticsMapper INSTANCE = Mappers.getMapper(CharacterStatisticsMapper.class);

    CharacterStatisticsDto mapEntityToDto(CharacterStatistics statistics);

    CharacterStatistics mapDtoToEntity(CharacterStatisticsDto statisticsDto);
}