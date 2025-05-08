package maksym.kruhovykh.userservice.mapper;


import maksym.kruhovykh.entity.Role;
import maksym.kruhovykh.entity.User;
import maksym.kruhovykh.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
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
