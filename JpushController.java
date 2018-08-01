package com.jereh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jereh.entity.Message;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

@Controller
@RequestMapping("jpushController/")
public class JpushController {
	@RequestMapping("lianxi")
	public void findAllFunny21() throws APIConnectionException, APIRequestException{
		
		
		 JPushClient jpushClient = new JPushClient("8f8381cc51a65038208a843b", "9b016842ee3d141e3c50d9a4", null, ClientConfig.getInstance());

		    // For push, all you need do is to build PushPayload object.
		    PushPayload payload =  PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.alias("admin"))
	                .setNotification(Notification.alert("哈撒给 "))
	                .build();

		    try {
		        PushResult result = jpushClient.sendPush(payload);
//		        LOG.info("Got result - " + result);

		    } catch (cn.jiguang.common.resp.APIConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (cn.jiguang.common.resp.APIRequestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	
	//android查找所有管理员
	@RequestMapping("lianxixi")
	public void findAllFunny221() throws APIConnectionException, APIRequestException, cn.jiguang.common.resp.APIConnectionException, cn.jiguang.common.resp.APIRequestException{
		 JPushClient jpushClient = new JPushClient("8f8381cc51a65038208a843b", "9b016842ee3d141e3c50d9a4", null, ClientConfig.getInstance());
		
		 PushResult result=	 jpushClient.sendNotificationAll("1111");
		 
		   if(result != null && result.isResultOK()){
	           System.out.println("成功");
	        }else{
	        	
	            System.out.println("失败");
	        }
//		System.out.println("111111111111111111111");
}
	
	
	
	
	
    public static PushPayload buildPushObject_all_alias_alert() {
//        return PushPayload.newBuilder()
//                .setPlatform(Platform.all())
//                .setAudience(Audience.alias("alias1"))
//                .setNotification(Notification.alert("111111111"))
//                .build();
    	return PushPayload.alertAll("22222222222222");
    }
		


    


}
