package com.jci.iot.sdk.core;

import com.microsoft.azure.iothub.IotHubMessageResult;

public enum IotMessageResult {
    SUCCESS,
    FAILURE,
    ERROR;

    public IotHubMessageResult getIotHubStatus() {
        switch (this) {
            case SUCCESS:
                return IotHubMessageResult.COMPLETE;
            case FAILURE:
                return IotHubMessageResult.REJECT;
            case ERROR:
                return IotHubMessageResult.ABANDON;
            default:
                return IotHubMessageResult.ABANDON;
        }
    }
}