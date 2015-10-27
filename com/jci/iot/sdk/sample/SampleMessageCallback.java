package com.jci.iot.sdk.sample;

import com.jci.iot.sdk.core.IotMessageCallback;
import com.jci.iot.sdk.core.IotMessageResult;
import com.jci.iot.sdk.core.IotReceiveContext;
import com.jci.iot.sdk.json.ReceivedCommand;

import org.json.JSONException;

import java.util.Map;

public class SampleMessageCallback extends IotMessageCallback {
    @Override
    public IotMessageResult execute(String message, IotReceiveContext context) {
        System.out.println("A message was received from IoT Hub: " + message);

        // Success (something expected happened on the device leading to a positive result)
        // IotMessageResult.SUCCESS

        // Failure (something expected happened on the device leading to a negative result)
        // IotMessageResult.FAILURE

        // Error (something unexpected happened on the device leading to an unknown result)
        // IotMessageResult.ERROR

        ReceivedCommand command;
        try {
            command = new ReceivedCommand(message);
        } catch (JSONException e) {
            System.out.println("Failed to parse the message as a command.");
            System.out.println(e.getMessage());
            return IotMessageResult.FAILURE;
        }

        try {
            System.out.println("Received command named: " + command.name);
            if (command.parameters != null) {
                for (Map.Entry<String, Object> parameter : command.parameters.entrySet()) {
                    System.out.println("Received command parameter named: " + parameter.getKey() + " with value: " + parameter.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to complete a command.");
            System.out.println(e.getMessage());
            return IotMessageResult.ERROR;
        }

        System.out.println("Completed a command.");
        return IotMessageResult.SUCCESS;
    }
}