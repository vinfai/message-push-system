package com.cvte.service;

import com.cvte.entity.PushEntity;

public interface MailService {
    public abstract void sendMail(PushEntity pushEntity) throws Exception;
}
