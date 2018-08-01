package com.qk.ginkgoservice.modules.sys.web;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.qk.ginkgoservice.common.exception.ErrorCode;
import com.qk.ginkgoservice.common.exception.MessageCode;
import com.qk.ginkgoservice.modules.sys.dto.RespDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;
import static org.bouncycastle.jcajce.spec.TLSKeyMaterialSpec.MASTER_SECRET;

/**
 * @author fuxuelong
 */
@RequestMapping("/sys")
@RestController
public class SysController {
    /**
     * 快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
     * 其他推送对象参考http://docs.jiguang.cn/jpush/server/sdk/java_sdk/中的服务端SDK
     * */
    /**
     * 调用检查token的有效性，如果失效在网关处会被拦截
     * */
    @PostMapping("/checkToken")
    @ApiOperation(value = "检查token有效性", notes = "访问时在header中携带Authorizition=token")
    public RespDTO checkToken(){
        System.out.println("=============");
        return new RespDTO(MessageCode.VALID_TOKEN);
    }
    /**
     * 使用极光推送推送消息
     * */
    @PostMapping("/jiGuangPush")
    @ApiOperation(value = "极光推送测试接口", notes = "")
    public RespDTO jiGuangPush(String content){
        JPushClient jpushClient = new JPushClient("a3c3831571950bb00313733c", "0b9f2766be54d7e79b3cf305", null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = payload;
        PushPayload payload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
//                .setAudience(Audience.alias("admin"))
                .setAudience(Audience.all())
                .setNotification(Notification.alert(content))
                .build();

        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            System.out.println("Connection error, should retry later");
            return new RespDTO(MessageCode.JIGUANG_PUSH_FAILD);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            System.out.println("Should review the error, and fix the request");
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
            return new RespDTO(MessageCode.JIGUANG_PUSH_FAILD);
        }
        return new RespDTO(MessageCode.JIGUANG_PUSH_SUCCESS);
    }

}
