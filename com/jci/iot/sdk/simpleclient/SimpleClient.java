package com.jci.iot.sdk.simpleclient;

import com.jci.iot.sdk.core.IotClient;
import com.jci.iot.sdk.core.IotContext;
import com.jci.iot.sdk.core.IotReceiveContext;
import com.jci.iot.sdk.core.IotSendContext;
import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.IotHubClientProtocol;
import com.microsoft.azure.iothub.Message;

public class SimpleClient implements
        IotClient<IotContext, IotSendContext, IotReceiveContext> {

    private void handleException(Exception exception, IotContext context) {
        if (context.errorCallback != null) {
            context.errorCallback.execute(exception, context);
        }
        else {
            System.out.println("Error callback undefined. Exception: " + exception.getMessage());
        }
    }

    @Override
    public void sendMessage(IotSendContext context) {
        try {
            openClient(context);

            Message message = new Message(context.messageData);
            context.client.sendEventAsync(message, context.eventCallback, context);
        }
        catch (Exception exception) {
            handleException(exception, context);
        }
    }

    @Override
    public void receiveMessage(IotReceiveContext context) {
        try {
            openClient(context);

            context.client.setMessageCallback(context.messageCallback, context);
        }
        catch (Exception exception) {
            handleException(exception, context);
        }
    }

    @Override
    public void openClient(IotContext context) {
        try {
            if (context.protocol == null) {
                context.protocol = IotHubClientProtocol.HTTPS;
            }

            if (context.client == null) {
                context.client = new DeviceClient(context.hubId,
                        context.deviceId,
                        context.deviceKey,
                        context.protocol);
            }

            context.client.open();
        }
        catch (Exception exception) {
            handleException(exception, context);
        }
    }

    @Override
    public void closeClient(IotContext context) {
        try {
            if (context.client != null) {
                context.client.close();
            }
        }
        catch (Exception exception) {
            handleException(exception, context);
        }
    }
}