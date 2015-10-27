package com.jci.iot.sdk.json;

import org.json.JSONArray;
import org.json.JSONException;

public class TelemetryMessage extends MessageBuilder {

    public TelemetryMessage(Iterable<Telemetry> telemetries) throws JSONException {
        this(MessageConstants.VERSION_DEFAULT, telemetries);
    }

    public TelemetryMessage(String version, Iterable<Telemetry> telemetries) throws JSONException {
        super(MessageConstants.TELEMETRY, version);

        JSONArray jsonTelemetry = new JSONArray();
        for (Telemetry telemetry : telemetries) {
            jsonTelemetry.put(telemetry.toJSONObject());
        }

        put(MessageConstants.TELEMETRY_TELEMETRIES, jsonTelemetry);
    }
}