package com.jci.iot.sdk.json;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReceivedCommand {
    public String name;
    public String messageId;
    public String createdTime;
    public Map<String, Object> parameters;

    public ReceivedCommand(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        if (!jsonObject.isNull(MessageConstants.COMMAND_NAME)) {
            name = (String) jsonObject.get(MessageConstants.COMMAND_NAME);
        }
        if (!jsonObject.isNull(MessageConstants.COMMAND_MESSAGE_ID)) {
            messageId = (String) jsonObject.get(MessageConstants.COMMAND_MESSAGE_ID);
        }
        if (!jsonObject.isNull(MessageConstants.COMMAND_CREATED_TIME)) {
            createdTime = (String) jsonObject.get(MessageConstants.COMMAND_CREATED_TIME);
        }
        if (!jsonObject.isNull(MessageConstants.COMMAND_PARAMETERS)) {
            JSONObject jsonParameters = (JSONObject) jsonObject.get(MessageConstants.COMMAND_PARAMETERS);
            parameters = new HashMap<>();
            Iterator<String> iterator = jsonParameters.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                parameters.put(key, jsonParameters.get(key));
            }
        }
    }
}