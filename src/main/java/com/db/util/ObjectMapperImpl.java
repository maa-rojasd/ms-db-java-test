package com.db.util;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.dto.PhoneDto;
import com.db.dto.UserDto;
import com.db.dto.PhoneDto.PhoneDtoBuilder;
import com.db.dto.UserDto.UserDtoBuilder;
import com.db.dto.UserRegistrationDto;
import com.db.dto.UserRegistrationDto.UserRegistrationDtoBuilder;
import com.db.dto.UserResponseDto;
import com.db.dto.UserResponseDto.UserResponseDtoBuilder;
import com.db.model.PhoneModel;
import com.db.model.UserModel;
import com.db.model.PhoneModel.PhoneModelBuilder;
import com.db.model.UserModel.UserModelBuilder;

@Service
public class ObjectMapperImpl implements ObjectMapper {

	@Override
	public UserModel userDtoToModel(UserRegistrationDto userDto) {
		List<PhoneModel> phoneList = new ArrayList<>();
		UserModelBuilder userModel = UserModel.builder();
		
		for (PhoneDto phoneDtoAux : userDto.getPhones()) {
			phoneList.add(this.phoneDtoToModel(phoneDtoAux));
		}
		userModel.name(userDto.getName());
		userModel.email(userDto.getEmail());
		userModel.password(userDto.getPassword());
		userModel.phones(phoneList);

        return userModel.build();
	}

	@Override
	public UserRegistrationDto userModelToDto(UserModel userModel) {
		List<PhoneDto> phoneList = new ArrayList<>();
		UserRegistrationDtoBuilder userDto = UserRegistrationDto.builder();
		
		for (PhoneModel phoneDtoAux : userModel.getPhones()) {
			phoneList.add(this.phoneModelToDto(phoneDtoAux));
		}
		userDto.name(userModel.getName());
		userDto.email(userModel.getEmail());
		userDto.password(userModel.getPassword());
		userDto.phones(phoneList);

        return userDto.build();
	}

	@Override
	public PhoneModel phoneDtoToModel(PhoneDto phoneDto) {
		PhoneModelBuilder phoneModel = PhoneModel.builder();
		
		phoneModel.number(phoneDto.getNumber());
		phoneModel.cityCode(phoneDto.getCityCode());
		phoneModel.contryCode(phoneDto.getContryCode());

        return phoneModel.build();
	}

	@Override
	public PhoneDto phoneModelToDto(PhoneModel phoneModel) {
		PhoneDtoBuilder phoneDto = PhoneDto.builder();
		
		phoneDto.number(phoneModel.getNumber());
		phoneDto.cityCode(phoneModel.getCityCode());
		phoneDto.contryCode(phoneModel.getContryCode());

        return phoneDto.build();
	}

}
