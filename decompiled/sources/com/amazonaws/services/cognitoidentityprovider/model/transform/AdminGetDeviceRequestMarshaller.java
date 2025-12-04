package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminGetDeviceRequestMarshaller implements Marshaller<Request<AdminGetDeviceRequest>, AdminGetDeviceRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminGetDeviceRequest> marshall(AdminGetDeviceRequest adminGetDeviceRequest) {
        if (adminGetDeviceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminGetDeviceRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminGetDeviceRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminGetDevice");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminGetDeviceRequest.getDeviceKey() != null) {
                String deviceKey = adminGetDeviceRequest.getDeviceKey();
                jsonWriter.name("DeviceKey");
                jsonWriter.value(deviceKey);
            }
            if (adminGetDeviceRequest.getUserPoolId() != null) {
                String userPoolId = adminGetDeviceRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminGetDeviceRequest.getUsername() != null) {
                String username = adminGetDeviceRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
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
