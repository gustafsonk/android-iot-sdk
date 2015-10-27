package com.jci.iot.sdk.core;

import com.microsoft.azure.iothub.IotHubEventCallback;
import com.microsoft.azure.iothub.IotHubStatusCode;

public abstract class IotEventCallback implements IotHubEventCallback {

    @Override
    public void execute(IotHubStatusCode hubStatusCode, Object context) {
        IotStatusCode statusCode = IotStatusCode.fromIotHubStatusCode(hubStatusCode);
        IotSendContext sendContext = (IotSendContext) context;
        execute(statusCode, sendContext);
    }

    public abstract void execute(IotStatusCode statusCode, IotSendContext context);
}