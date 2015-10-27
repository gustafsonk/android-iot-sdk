package com.jci.iot.sdk.sample;

import com.jci.iot.sdk.core.IotErrorCallback;
import com.jci.iot.sdk.core.IotReceiveContext;
import com.jci.iot.sdk.core.IotSendContext;

public class SampleErrorCallback extends IotErrorCallback {

    @Override
    public void handleSendException(Exception exception, IotSendContext context) {
        System.out.println("Failed to send message: " + context.messageData);
        System.out.println(exception.getMessage());
    }

    @Override
    public void handleReceiveException(Exception exception, IotReceiveContext context) {
        System.out.println("Failed to receive a message.");
        System.out.println(exception.getMessage());
    }
}