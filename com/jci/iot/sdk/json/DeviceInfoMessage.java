package com.jci.iot.sdk.json;

import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfoMessage extends MessageBuilder {

    public DeviceInfoMessage(String deviceId, Iterable<Pair<String, Object>> properties,
                             Iterable<DeviceInfoCommand> commands) throws JSONException {
        this(deviceId, MessageConstants.VERSION_DEFAULT, properties, commands);
    }

    public DeviceInfoMessage(String deviceId, String version, Iterable<Pair<String, Object>> properties,
                             Iterable<DeviceInfoCommand> commands) throws JSONException {
        super(MessageConstants.INFO, version);

        JSONObject jsonProperties = new JSONObject();
        if (properties != null) {
            for (Pair property : properties) {
                jsonProperties.put((String)property.first, property.second);
            }
        }
        jsonProperties.put(MessageConstants.INFO_DEVICE_ID, deviceId);
        put(MessageConstants.INFO_PROPERTIES, jsonProperties);

        if (commands != null) {
            JSONArray jsonCommands = new JSONArray();
            for (DeviceInfoCommand command : commands) {
                jsonCommands.put(command.toJSONObject());
            }
            put(MessageConstants.INFO_COMMANDS, jsonCommands);
        }
    }
}