package com.jci.iot.sdk.core;

import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.IotHubClientProtocol;

public abstract class IotContext {
    public final long CLIENT_TIMEOUT_MILLISECONDS = 30000L;

    // Provide always
    public String hubId;
    public String deviceId;
    public String deviceKey;

    // Optional
    public IotErrorCallback errorCallback;

    // Don't provide, populated internally
    public DeviceClient client;
    public IotHubClientProtocol protocol;

    public IotContext(String hubId, String deviceId, String deviceKey,
                      IotErrorCallback errorCallback) {
        this.hubId = hubId;
        this.deviceId = deviceId;
        this.deviceKey = deviceKey;
        this.errorCallback = errorCallback;
    }
}