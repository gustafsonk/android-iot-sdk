package com.jci.iot.sdk.core;

import com.microsoft.azure.iothub.IotHubStatusCode;

public enum IotStatusCode {
    OK,
    OK_EMPTY,
    BAD_FORMAT,
    UNAUTHORIZED,
    TOO_MANY_DEVICES,
    HUB_OR_DEVICE_ID_NOT_FOUND,
    PRECONDITION_FAILED,
    REQUEST_ENTITY_TOO_LARGE,
    THROTTLED,
    INTERNAL_SERVER_ERROR,
    SERVER_BUSY,
    ERROR;

    public static IotStatusCode fromIotHubStatusCode(IotHubStatusCode code) {
        switch (code) {
            case OK:
                return OK;
            case OK_EMPTY:
                return OK_EMPTY;
            case BAD_FORMAT:
                return BAD_FORMAT;
            case UNAUTHORIZED:
                return UNAUTHORIZED;
            case TOO_MANY_DEVICES:
                return TOO_MANY_DEVICES;
            case HUB_OR_DEVICE_ID_NOT_FOUND:
                return HUB_OR_DEVICE_ID_NOT_FOUND;
            case PRECONDITION_FAILED:
                return PRECONDITION_FAILED;
            case REQUEST_ENTITY_TOO_LARGE:
                return REQUEST_ENTITY_TOO_LARGE;
            case THROTTLED:
                return THROTTLED;
            case INTERNAL_SERVER_ERROR:
                return INTERNAL_SERVER_ERROR;
            case SERVER_BUSY:
                return SERVER_BUSY;
            case ERROR:
                return ERROR;
            default:
                return ERROR;
        }
    }
}