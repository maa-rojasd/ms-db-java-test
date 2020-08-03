package com.db.util;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.db.dto.PhoneDto;
import com.db.dto.UserDto;
import com.db.dto.UserRegistrationDto;
import com.db.dto.UserResponseDto;
import com.db.model.PhoneModel;
import com.db.model.UserModel;

@Mapper
public interface ObjectMapper {
	ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);
    UserModel userDtoToModel(UserRegistrationDto userDto);
    UserRegistrationDto userModelToDto(UserModel userModel);
    PhoneModel phoneDtoToModel(PhoneDto phoneDto);
    PhoneDto phoneModelToDto(PhoneModel phoneModel);
    
}
