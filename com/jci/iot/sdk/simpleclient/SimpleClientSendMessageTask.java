package com.jci.iot.sdk.simpleclient;

import com.jci.iot.sdk.core.IotSendContext;

public class SimpleClientSendMessageTask extends SimpleClientMessageTask<IotSendContext> {

    @Override
    protected Void doInBackground(IotSendContext... contexts) {
        for (IotSendContext context : contexts) {
            client.sendMessage(context);
            activeContexts.add(context);
        }

        return null;
    }
}