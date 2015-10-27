package com.jci.iot.sdk.core;

import com.microsoft.azure.iothub.IotHubMessageResult;
import com.microsoft.azure.iothub.Message;
import com.microsoft.azure.iothub.MessageCallback;

import java.nio.charset.Charset;

public abstract class IotMessageCallback implements MessageCallback {

    @Override
    public IotHubMessageResult execute(Message message, Object context) {
        String response = new String(message.getBytes(), Charset.forName("UTF-8"));
        IotReceiveContext receiveContext = (IotReceiveContext) context;
        IotMessageResult result = execute(response, receiveContext);
        return result.getIotHubStatus();
    }

    public abstract IotMessageResult execute(String message, IotReceiveContext context);
}