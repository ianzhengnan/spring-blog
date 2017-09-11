package com.ian.sblog.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SendSMS {

    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";

    static final String accessKeyId = "LTAI8ggXjOrEHYXI";
    static final String accessKeySecret = "1pc9Dxi4N09It6j2hYYL93d8wU9P5c";

    public static SendSmsResponse sendSms(String phone, String smscode) throws ClientException{

        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phone);
        request.setSignName("郑楠");
        request.setTemplateCode("SMS_94770141");
        request.setTemplateParam("{\"number\":\"" + smscode + "\"}");

        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }
}
