package com.jci.iot.sdk.sample;

import com.jci.iot.sdk.core.IotEventCallback;
import com.jci.iot.sdk.core.IotSendContext;
import com.jci.iot.sdk.core.IotStatusCode;

public class SampleEventCallback extends IotEventCallback {

    @Override
    public void execute(IotStatusCode statusCode, IotSendContext context) {
        System.out.println("IoT Hub responded with status " + statusCode.name()
                + " to message: " + context.messageData);
    }
}