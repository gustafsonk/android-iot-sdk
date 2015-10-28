# Sample Usage

// Device connection string information
String hubId = "YOUR_HUB_ID";
String deviceId = "YOUR_DEVICE_ID";
String deviceKey = "YOUR_DEVICE_KEY";

// Some sample callbacks that pretty much just print lines to the console
SampleEventCallback eventCallback = new SampleEventCallback();
SampleErrorCallback errorCallback = new SampleErrorCallback();
SampleMessageCallback messageCallback = new SampleMessageCallback();

// Sending a message using an AsyncTask, a new context should be made for every request
String message = "Hello Cloud";
IotSendContext sendContext = new IotSendContext(hubId, deviceId, deviceKey, message, eventCallback, errorCallback);
new SimpleClientSendMessageTask().execute(sendContext);

// Receiving a message using an AsyncTask, a new context should be made for every request
IotReceiveContext receiveContext = new IotReceiveContext(hubId, deviceId, deviceKey, messageCallback, errorCallback);
new SimpleClientReceiveMessageTask().execute(receiveContext);

try {
	// Define the device's known properties
	Pair<String, Object> property1 = new Pair<String, Object>(MessageConstants.INFO_MANUFACTURER, "Johnson Controls");
	Pair<String, Object> property2 = new Pair<String, Object>(MessageConstants.INFO_MODEL_NUMBER, "123");
	List<Pair<String, Object>> properties = new ArrayList<>();
	properties.add(property1);
	properties.add(property2);

	// Define the device's supported commands
	List<DeviceInfoParameter> command1params = new ArrayList<>();
	command1params.add(new DeviceInfoParameter("Temperature", DeviceInfoParameterType.DOUBLE));
	DeviceInfoCommand command1 = new DeviceInfoCommand("SetTemperature", command1params);
	List<DeviceInfoCommand> commands = new ArrayList<>();
	commands.add(command1);

	// Make some telemetry
	Telemetry telemetry1 = new Telemetry("humidity", "ISO8601 timestamp", 52);
	List<Telemetry> telemetries = new ArrayList<>();
	telemetries.add(telemetry1);

	// Print out the JSON that would normally be sent
	String jsonDeviceInfo = new DeviceInfoMessage(deviceId, properties, commands).toString();
	System.out.println(jsonDeviceInfo);
	String jsonTelemetry = new TelemetryMessage(telemetries).toString();
	System.out.println(jsonTelemetry);

	// Example JSON you could receive if someone performed the command above
	String jsonReceived = "{\"Name\":\"SetTemperature\",\"MessageId\":\"some id\",\"CreatedTime\":\"2015-10-19T01:13:55.5527874Z\",\"Parameters\":{\"temperature\":42.0}}";
	ReceivedCommand command = new ReceivedCommand(jsonReceived);
	System.out.println("Received command named: " + command.name);
} catch (JSONException e) {
	System.out.println(e.getMessage());
}