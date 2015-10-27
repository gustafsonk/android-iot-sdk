package com.jci.iot.sdk.json;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class MessageBuilder {
    public JSONObject fields = new JSONObject();

    public MessageBuilder(String messageType, String version) throws JSONException {
        fields.put(MessageConstants.MESSAGE_TYPE, messageType);
        fields.put(MessageConstants.VERSION, version);
    }

    public MessageBuilder put(String field, Object value) throws JSONException {
        fields.put(field, value);
        return this;
    }

    @Override
    public String toString() {
        return fields.toString();
    }
}