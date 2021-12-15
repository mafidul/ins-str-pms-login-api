package com.tcs.ins.login.service.mapper;

import org.mapstruct.Mapper;

import com.tcs.ins.login.repository.entity.Login;
import com.tcs.ins.login.service.model.LoginModel;

@Mapper(componentModel = "spring")
public interface PMSMapper {

	Login toEntity(LoginModel source);

	LoginModel toModel(Login source);
}
