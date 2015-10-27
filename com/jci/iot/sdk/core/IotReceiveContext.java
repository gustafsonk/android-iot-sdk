package com.jci.iot.sdk.core;

import com.microsoft.azure.iothub.MessageCallback;

public class IotReceiveContext extends IotContext {
    public MessageCallback messageCallback;

    public IotReceiveContext(String hubId, String deviceId, String deviceKey,
                             MessageCallback messageCallback, IotErrorCallback errorCallback) {
        super(hubId, deviceId, deviceKey, errorCallback);
        this.messageCallback = messageCallback;
    }
}