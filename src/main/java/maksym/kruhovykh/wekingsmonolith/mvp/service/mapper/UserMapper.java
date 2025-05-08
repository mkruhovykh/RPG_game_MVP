package maksym.kruhovykh.wekingsmonolith.mvp.service.mapper;

import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.UserDto;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.Role;
import maksym.kruhovykh.wekingsmonolith.mvp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import org.mapstruct.Named;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(source = "roles", target = "roles", qualifiedByName = "namesToRoles")
    User mapDtoToEntity(UserDto userDto);
    @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToNames")
    UserDto mapEntityToDto(User User);

    List<UserDto> usersToUserDtos(List<User> users);
    List<User> userDtosToUsers(List<UserDto> userDtos);
    @Named(value = "namesToRoles")
    default Set<Role> namesToRoles(List<String> roles) {
        return roles.stream()
                .map(this::mapRole)
                .collect(Collectors.toSet());
    }
    default Role mapRole(String roleString) {

        return new Role(roleString);
    }
    @Named("rolesToNames")
    default List<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }


}
