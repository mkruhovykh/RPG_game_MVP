package maksym.kruhovykh.wekingsmonolith.auth.service.mapper;

import maksym.kruhovykh.wekingsmonolith.auth.model.dto.CharacterInventoryDto;
import maksym.kruhovykh.wekingsmonolith.auth.repository.entity.CharacterInventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterInventoryMapper {
    CharacterInventoryMapper INSTANCE = Mappers.getMapper(CharacterInventoryMapper.class);
    CharacterInventoryDto mapEntityToDto(CharacterInventory inventory);

    CharacterInventory mapDtoToEntity(CharacterInventoryDto inventoryDto);
}