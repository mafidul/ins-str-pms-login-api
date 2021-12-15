package com.tcs.ins.login.service;

import com.tcs.ins.login.service.model.LoginModel;

public interface PMSService {

	LoginModel createLogin(LoginModel loginModel);

	LoginModel resourceLogin(LoginModel loginModel);
}
