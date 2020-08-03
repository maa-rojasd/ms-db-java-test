package com.db.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.db.dto.PhoneDto;
import com.db.dto.PhoneDto.PhoneDtoBuilder;
import com.db.dto.UserRegistrationDto;
import com.db.dto.UserRegistrationDto.UserRegistrationDtoBuilder;
import com.db.model.PhoneModel;
import com.db.model.UserModel;
import com.db.model.PhoneModel.PhoneModelBuilder;
import com.db.model.UserModel.UserModelBuilder;


@Service
public class ObjectMapperImpl implements ObjectMapper {

	@Override
	public UserModel userDtoToModel(UserRegistrationDto userDto, String token) {
		LocalDateTime dateTime = LocalDateTime.now();
		Date date = java.sql.Timestamp.valueOf( dateTime );
		List<PhoneModel> phoneList = new ArrayList<>();
		UserModelBuilder userModel = UserModel.builder();
		for (PhoneDto phoneDtoAux : userDto.getPhones()) {
			phoneList.add(this.phoneDtoToModel(phoneDtoAux));
		}
		userModel.name(userDto.getName());
		userModel.email(userDto.getEmail());
		userModel.password(userDto.getPassword());
		userModel.phones(phoneList);
		userModel.created(date);
		userModel.isActive(Constants.DEFAULT_ACTIVE_USER);
		userModel.modified(date);
		userModel.lastLogin(date);
		userModel.token(token);

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
		long val = 0L;
		phoneModel.number(phoneDto.getNumber());
		phoneModel.cityCode(phoneDto.getCityCode());
		phoneModel.contryCode(phoneDto.getContryCode());
		phoneModel.idUser(val);

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
	
	@Override
	public UserModel userDtoToModelUpdate(UserRegistrationDto userDto, String token, UserModel userMod) {
		LocalDateTime dateTime = LocalDateTime.now();
		Date date = java.sql.Timestamp.valueOf( dateTime );
		List<PhoneModel> phoneList = new ArrayList<>();
		UserModelBuilder userModel = UserModel.builder();
		for (PhoneDto phoneDtoAux : userDto.getPhones()) {
			phoneList.add(this.phoneDtoToModel(phoneDtoAux));
		}
		userModel.id(userMod.getId());
		userModel.name(userDto.getName());
		userModel.email(userDto.getEmail());
		userModel.password(userDto.getPassword());
		userModel.phones(phoneList);
		userModel.created(userMod.getCreated());
		userModel.isActive(Constants.DEFAULT_ACTIVE_USER);
		userModel.modified(date);
		userModel.lastLogin(date);
		userModel.token(token);

        return userModel.build();
	}

}
