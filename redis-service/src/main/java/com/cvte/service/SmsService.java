package com.cvte.service;

import com.cvte.entity.PushEntity;

public interface SmsService {
    public abstract void sendSms(PushEntity pushEntity) throws Exception;
}
