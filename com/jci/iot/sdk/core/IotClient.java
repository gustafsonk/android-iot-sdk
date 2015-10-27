package com.jci.iot.sdk.core;

public interface IotClient<Base, Send, Receive> {
    void sendMessage(Send context);

    void receiveMessage(Receive context);

    void openClient(Base context);

    void closeClient(Base context);
}