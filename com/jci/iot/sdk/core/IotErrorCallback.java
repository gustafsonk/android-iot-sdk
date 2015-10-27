package com.jci.iot.sdk.core;

public abstract class IotErrorCallback {
    public void execute(Exception exception, IotContext context) {
        if (context instanceof IotSendContext) {
            handleSendException(exception, (IotSendContext) context);
        }
        else if (context instanceof IotReceiveContext) {
            handleReceiveException(exception, (IotReceiveContext) context);
        }
    }

    public abstract void handleSendException(Exception exception, IotSendContext context);

    public abstract void handleReceiveException(Exception exception, IotReceiveContext context);
}