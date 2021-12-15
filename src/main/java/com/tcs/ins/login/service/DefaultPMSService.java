package com.tcs.ins.login.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tcs.ins.login.repository.LoginRepository;
import com.tcs.ins.login.repository.entity.Login;
import com.tcs.ins.login.service.mapper.PMSMapper;
import com.tcs.ins.login.service.model.LoginModel;

@Service
public class DefaultPMSService implements PMSService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPMSService.class);
	private final LoginRepository loginRepository;
	private final PMSMapper pMSMapper;

	public DefaultPMSService(LoginRepository loginRepository, PMSMapper pMSMapper) {
		this.loginRepository = loginRepository;
		this.pMSMapper = pMSMapper;
	}

	// Sign Up Details
	@Override
	public LoginModel createLogin(LoginModel loginModel) {
		Login login = pMSMapper.toEntity(loginModel);
		Login saveLogin = loginRepository.save(login);
		return pMSMapper.toModel(saveLogin);
	}

	// Login Details
	@Override
	public LoginModel resourceLogin(LoginModel loginModel) {
		Optional<Login> optionalLogin = loginRepository.findById(null);
		Login login = optionalLogin.get();
		LOGGER.info("value of Id from repositorry: {} " + login);
		LOGGER.info("value of Id from model: {} " + loginModel.getId());

		if (!login.getPassword().equals(loginModel.getPassword())) {
			throw new IllegalArgumentException("Invalid Password");
		}
		return loginModel;
	}
}
