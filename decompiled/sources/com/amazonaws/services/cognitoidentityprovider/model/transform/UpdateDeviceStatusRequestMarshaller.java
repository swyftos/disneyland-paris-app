package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class UpdateDeviceStatusRequestMarshaller implements Marshaller<Request<UpdateDeviceStatusRequest>, UpdateDeviceStatusRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateDeviceStatusRequest> marshall(UpdateDeviceStatusRequest updateDeviceStatusRequest) {
        if (updateDeviceStatusRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateDeviceStatusRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateDeviceStatusRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateDeviceStatus");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateDeviceStatusRequest.getAccessToken() != null) {
                String accessToken = updateDeviceStatusRequest.getAccessToken();
                jsonWriter.name("AccessToken");
                jsonWriter.value(accessToken);
            }
            if (updateDeviceStatusRequest.getDeviceKey() != null) {
                String deviceKey = updateDeviceStatusRequest.getDeviceKey();
                jsonWriter.name("DeviceKey");
                jsonWriter.value(deviceKey);
            }
            if (updateDeviceStatusRequest.getDeviceRememberedStatus() != null) {
                String deviceRememberedStatus = updateDeviceStatusRequest.getDeviceRememberedStatus();
                jsonWriter.name("DeviceRememberedStatus");
                jsonWriter.value(deviceRememberedStatus);
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
