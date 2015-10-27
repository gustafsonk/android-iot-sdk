package com.jci.iot.sdk.simpleclient;

import com.jci.iot.sdk.core.IotReceiveContext;

public class SimpleClientReceiveMessageTask
        extends SimpleClientMessageTask<IotReceiveContext> {

    @Override
    protected Void doInBackground(IotReceiveContext... contexts) {
        for (IotReceiveContext context : contexts) {
            client.receiveMessage(context);
            activeContexts.add(context);
        }

        return null;
    }
}