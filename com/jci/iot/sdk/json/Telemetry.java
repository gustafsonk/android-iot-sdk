package com.jci.iot.sdk.json;

import org.json.JSONException;
import org.json.JSONObject;

public class Telemetry {
    public String id;
    public String timestamp;
    public Object value;

    public Telemetry(String id, String timestamp, Object value) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jsonTelemetry = new JSONObject();
        jsonTelemetry.put(MessageConstants.TELEMETRY_ID, id);
        jsonTelemetry.put(MessageConstants.TELEMETRY_TIMESTAMP, timestamp);
        jsonTelemetry.put(MessageConstants.TELEMETRY_VALUE, value);
        return jsonTelemetry;
    }
}