package com.cvte.dao;

import com.cvte.entity.Reply;

import java.util.List;

public interface IReplyDao {


    public abstract int addReply(Reply reply);

    public abstract List<Reply> getReplys(String appid,Integer requestCode, String pushAddress);

}
