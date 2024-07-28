package com.sushi.tuyenbeoo.authentication.service.domain.mapper;

import com.sushi.tuyenbeoo.authentication.service.domain.dto.UserDTO;
import com.sushi.tuyenbeoo.authentication.service.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    User userDtoToUser(UserDTO userDTO);
}
