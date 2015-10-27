package com.jci.iot.sdk.json;

public class MessageConstants {
    // All message types
    public static final String MESSAGE_TYPE = "ObjectType";
    public static final String VERSION = "Version";
    public static final String VERSION_DEFAULT = "1.0";

    // DeviceInfo message structure
    public static final String INFO = "DeviceInfo";
    public static final String INFO_COMMAND_NAME = "Name";
    public static final String INFO_COMMAND_PARAMETERS = "Parameters";
    public static final String INFO_COMMAND_PARAMETER_NAME = "Name";
    public static final String INFO_COMMAND_PARAMETER_TYPE = "Type";
    public static final String INFO_COMMANDS = "Commands";
    public static final String INFO_DEVICE_ID = "DeviceID";
    public static final String INFO_PROPERTIES = "DeviceProperties";

    // popular DeviceInfo message properties
    public static final String INFO_APP_VERSION = "AppVersion";
    public static final String INFO_FIRMWARE_VERSION = "FirmwareVersion";
    public static final String INFO_MANUFACTURER = "Manufacturer";
    public static final String INFO_MODEL_NUMBER = "ModelNumber";
    public static final String INFO_PLATFORM = "Platform";
    public static final String INFO_PLATFORM_VERSION = "PlatformVersion";
    public static final String INFO_SERIAL_NUMBER = "SerialNumber";

    // Telemetry message structure
    public static final String TELEMETRY = "Telemetry";
    public static final String TELEMETRY_TELEMETRIES = "Telemetry";
    public static final String TELEMETRY_ID = "Id";
    public static final String TELEMETRY_TIMESTAMP = "Timestamp";
    public static final String TELEMETRY_VALUE = "Value";

    // Command message structure
    public static final String COMMAND_MESSAGE_ID = "MessageId";
    public static final String COMMAND_NAME = "Name";
    public static final String COMMAND_PARAMETERS = "Parameters";
    public static final String COMMAND_CREATED_TIME = "CreatedTime";
}