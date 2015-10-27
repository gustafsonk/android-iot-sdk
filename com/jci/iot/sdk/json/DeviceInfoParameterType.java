package com.jci.iot.sdk.json;

public enum DeviceInfoParameterType {
    BOOLEAN,
    DOUBLE,
    INTEGER,
    LONG,
    SINGLE,
    STRING;

    public String toString() {
        switch(this) {
            case BOOLEAN:
                return "boolean";
            case DOUBLE:
                return "double";
            case INTEGER:
                return "int32";
            case LONG:
                return "int64";
            case SINGLE:
                return "single";
            case STRING:
                return "string";
            default:
                return null;
        }
    }
}