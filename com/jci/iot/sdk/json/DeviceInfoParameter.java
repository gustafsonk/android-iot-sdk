package com.jci.iot.sdk.json;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfoParameter {
    public String name;
    public DeviceInfoParameterType type;

    public DeviceInfoParameter(String name, DeviceInfoParameterType type) {
        this.name = name;
        this.type = type;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jsonParameter = new JSONObject();
        jsonParameter.put(MessageConstants.INFO_COMMAND_PARAMETER_NAME, name);
        jsonParameter.put(MessageConstants.INFO_COMMAND_PARAMETER_TYPE, type.toString());
        return jsonParameter;
    }
}