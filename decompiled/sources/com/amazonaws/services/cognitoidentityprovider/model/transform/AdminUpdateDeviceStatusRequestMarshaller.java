package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminUpdateDeviceStatusRequestMarshaller implements Marshaller<Request<AdminUpdateDeviceStatusRequest>, AdminUpdateDeviceStatusRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminUpdateDeviceStatusRequest> marshall(AdminUpdateDeviceStatusRequest adminUpdateDeviceStatusRequest) {
        if (adminUpdateDeviceStatusRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminUpdateDeviceStatusRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminUpdateDeviceStatusRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminUpdateDeviceStatus");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminUpdateDeviceStatusRequest.getUserPoolId() != null) {
                String userPoolId = adminUpdateDeviceStatusRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminUpdateDeviceStatusRequest.getUsername() != null) {
                String username = adminUpdateDeviceStatusRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminUpdateDeviceStatusRequest.getDeviceKey() != null) {
                String deviceKey = adminUpdateDeviceStatusRequest.getDeviceKey();
                jsonWriter.name("DeviceKey");
                jsonWriter.value(deviceKey);
            }
            if (adminUpdateDeviceStatusRequest.getDeviceRememberedStatus() != null) {
                String deviceRememberedStatus = adminUpdateDeviceStatusRequest.getDeviceRememberedStatus();
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
