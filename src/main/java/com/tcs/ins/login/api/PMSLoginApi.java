package com.tcs.ins.login.api;

import static com.tcs.ins.login.support.Constant.REQUEST_PARAM_MAPPING_LOGIN;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ins.login.service.PMSService;
import com.tcs.ins.login.service.model.LoginModel;

@RestController
@RequestMapping(REQUEST_PARAM_MAPPING_LOGIN)
class PMSLoginApi {

	private final PMSService pMSService;

	public PMSLoginApi(PMSService pMSService) {
		this.pMSService = pMSService;
	}

	@PostMapping(path = "/signup/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<LoginModel> createLogin(@RequestBody LoginModel loginModel) {
		LoginModel create = pMSService.createLogin(loginModel);
		return ResponseEntity.ok(create);
	}

	@PostMapping(path = "/login/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<LoginModel> resourceLogin(@RequestBody LoginModel loginModel) {
		LoginModel create = pMSService.resourceLogin(loginModel);
		return new ResponseEntity<LoginModel>(create, HttpStatus.BAD_REQUEST);
	}
}