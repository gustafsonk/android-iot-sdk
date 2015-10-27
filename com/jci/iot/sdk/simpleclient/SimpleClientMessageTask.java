package com.jci.iot.sdk.simpleclient;

import android.os.AsyncTask;
import android.os.CountDownTimer;

import com.jci.iot.sdk.core.IotContext;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleClientMessageTask<Param> extends AsyncTask<Param, Void, Void> {
    protected SimpleClient client = new SimpleClient();
    protected List<IotContext> activeContexts = new ArrayList<>();

    @Override
    protected void onPostExecute(Void result) {
        for (final IotContext context : activeContexts) {
            new CountDownTimer(context.CLIENT_TIMEOUT_MILLISECONDS,
                    context.CLIENT_TIMEOUT_MILLISECONDS) {

                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    client.closeClient(context);
                }
            }.start();
        }
    }
}