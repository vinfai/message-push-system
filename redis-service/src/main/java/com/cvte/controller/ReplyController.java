
package com.cvte.controller;

import java.util.List;


import com.cvte.dao.IReplyDao;
import com.cvte.entity.Reply;
import com.cvte.util.TimeUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pubsub")
public class ReplyController {



    @Autowired
    IReplyDao replyDao;

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public ModelAndView joinRoom(
            @RequestParam(value = "appid") String appid,
            @RequestParam(value = "requestCode") String requestCode,
            @RequestParam(value = "pushAddress") String pushAddress) {

        //Todo 验证

        //获取db
        List<Reply> list = replyDao.getReplys(appid,Integer.parseInt(requestCode),pushAddress);
        JSONArray array = JSONArray.fromObject(list);

        ModelAndView modelAndView = new ModelAndView("/WEB-INF/jsp/room.jsp", "message", array.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public ModelAndView reply(@RequestParam(value = "appid") String appid,
                              @RequestParam(value = "requestCode") String requestCode,
                              @RequestParam(value = "pushAddress") String pushAddress,
                              @RequestParam(value = "replyText") String replyText) {

        //type=2,user给管理员
        Reply reply = new Reply(appid,  requestCode,  pushAddress,  replyText,  2, TimeUtil.getDate());
        replyDao.addReply(reply);

        ModelAndView modelAndView = new ModelAndView("/WEB-INF/jsp/result.jsp", "message", "回复成功");
        return modelAndView;
    }


    @RequestMapping(value = "/reply2User", method = RequestMethod.POST)
    @ResponseBody
    public String reply2User(@RequestParam(value = "appid") String appid,
                              @RequestParam(value = "requestCode") String requestCode,
                              @RequestParam(value = "pushAddress") String pushAddress,
                              @RequestParam(value = "replyText") String replyText) {

        //type=1,管理员给user
        Reply reply = new Reply(appid,  requestCode,  pushAddress,  replyText,  1, TimeUtil.getDate());
        int num = replyDao.addReply(reply);
        String result = "";

        if(num>0){
            result = "reply success.";
        }

        return result;
    }




}
