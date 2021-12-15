package com.tcs.ins.login.messaging;

import com.tcs.ins.login.service.model.LoginModel;

public interface BatchProcessTriggeredEventProducer {

	void sendMessage(LoginModel event);
}