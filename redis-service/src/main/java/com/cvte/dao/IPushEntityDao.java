package com.cvte.dao;

import com.cvte.entity.PushEntity;

import java.util.List;

public interface IPushEntityDao {

    public abstract int  addPushEntity(PushEntity entity);

    public  abstract List<PushEntity> findAllByAppidAndRequestCode(String appid, String requestCode);
//    public  abstract List<PushEntity> findByAppidAndRequestCode(String appid, String requestCode, List<String> pushAddresses);
}
