package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.cognito.clientcontext.datacollection.DataRecordKey;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceSecretVerifierConfigType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class ConfirmDeviceRequestMarshaller implements Marshaller<Request<ConfirmDeviceRequest>, ConfirmDeviceRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ConfirmDeviceRequest> marshall(ConfirmDeviceRequest confirmDeviceRequest) {
        if (confirmDeviceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ConfirmDeviceRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(confirmDeviceRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.ConfirmDevice");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (confirmDeviceRequest.getAccessToken() != null) {
                String accessToken = confirmDeviceRequest.getAccessToken();
                jsonWriter.name("AccessToken");
                jsonWriter.value(accessToken);
            }
            if (confirmDeviceRequest.getDeviceKey() != null) {
                String deviceKey = confirmDeviceRequest.getDeviceKey();
                jsonWriter.name("DeviceKey");
                jsonWriter.value(deviceKey);
            }
            if (confirmDeviceRequest.getDeviceSecretVerifierConfig() != null) {
                DeviceSecretVerifierConfigType deviceSecretVerifierConfig = confirmDeviceRequest.getDeviceSecretVerifierConfig();
                jsonWriter.name("DeviceSecretVerifierConfig");
                DeviceSecretVerifierConfigTypeJsonMarshaller.getInstance().marshall(deviceSecretVerifierConfig, jsonWriter);
            }
            if (confirmDeviceRequest.getDeviceName() != null) {
                String deviceName = confirmDeviceRequest.getDeviceName();
                jsonWriter.name(DataRecordKey.MODEL);
                jsonWriter.value(deviceName);
            }
            jsonWriter.endObject();
            jsonWriter.close();
            String string = stringWriter.toString();
            byte[] bytes = string.getBytes(StringUtils.UTF8);
            defaultRequest.setContent(new StringInputStream(string));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
            }
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
