package com.jci.iot.sdk.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfoCommand {
    public String name;
    public Iterable<DeviceInfoParameter> parameters;

    public DeviceInfoCommand(String name, Iterable<DeviceInfoParameter> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jsonCommand = new JSONObject();
        jsonCommand.put(MessageConstants.INFO_COMMAND_NAME, name);
        if (parameters != null) {
            JSONArray jsonParameters = new JSONArray();
            for (DeviceInfoParameter parameter : parameters) {
                jsonParameters.put(parameter.toJSONObject());
            }
            jsonCommand.put(MessageConstants.INFO_COMMAND_PARAMETERS, jsonParameters);
        }
        return jsonCommand;
    }
}