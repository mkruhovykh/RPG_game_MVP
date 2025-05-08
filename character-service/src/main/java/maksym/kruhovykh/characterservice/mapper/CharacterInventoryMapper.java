package maksym.kruhovykh.characterservice.mapper;

import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.CharacterInventoryDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.CharacterInventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterInventoryMapper {
    CharacterInventoryMapper INSTANCE = Mappers.getMapper(CharacterInventoryMapper.class);
    CharacterInventoryDto mapEntityToDto(CharacterInventory inventory);

    CharacterInventory mapDtoToEntity(CharacterInventoryDto inventoryDto);
}