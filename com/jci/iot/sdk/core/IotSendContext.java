package com.jci.iot.sdk.core;

import com.microsoft.azure.iothub.IotHubEventCallback;

public class IotSendContext extends IotContext {
    public String messageData;
    public IotHubEventCallback eventCallback;

    public IotSendContext(String hubId, String deviceId, String deviceKey,
                          String messageData, IotHubEventCallback eventCallback,
                          IotErrorCallback errorCallback) {
        super(hubId, deviceId, deviceKey, errorCallback);
        this.messageData = messageData;
        this.eventCallback = eventCallback;
    }
}