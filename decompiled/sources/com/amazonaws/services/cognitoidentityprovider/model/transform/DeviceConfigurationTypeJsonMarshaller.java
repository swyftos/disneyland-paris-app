package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeviceConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class DeviceConfigurationTypeJsonMarshaller {
    private static DeviceConfigurationTypeJsonMarshaller instance;

    DeviceConfigurationTypeJsonMarshaller() {
    }

    public void marshall(DeviceConfigurationType deviceConfigurationType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (deviceConfigurationType.getChallengeRequiredOnNewDevice() != null) {
            Boolean challengeRequiredOnNewDevice = deviceConfigurationType.getChallengeRequiredOnNewDevice();
            awsJsonWriter.name("ChallengeRequiredOnNewDevice");
            awsJsonWriter.value(challengeRequiredOnNewDevice.booleanValue());
        }
        if (deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt() != null) {
            Boolean deviceOnlyRememberedOnUserPrompt = deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt();
            awsJsonWriter.name("DeviceOnlyRememberedOnUserPrompt");
            awsJsonWriter.value(deviceOnlyRememberedOnUserPrompt.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static DeviceConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new DeviceConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
