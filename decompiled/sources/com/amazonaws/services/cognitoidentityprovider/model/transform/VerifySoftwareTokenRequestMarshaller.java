package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class VerifySoftwareTokenRequestMarshaller implements Marshaller<Request<VerifySoftwareTokenRequest>, VerifySoftwareTokenRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<VerifySoftwareTokenRequest> marshall(VerifySoftwareTokenRequest verifySoftwareTokenRequest) {
        if (verifySoftwareTokenRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(VerifySoftwareTokenRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(verifySoftwareTokenRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.VerifySoftwareToken");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (verifySoftwareTokenRequest.getAccessToken() != null) {
                String accessToken = verifySoftwareTokenRequest.getAccessToken();
                jsonWriter.name("AccessToken");
                jsonWriter.value(accessToken);
            }
            if (verifySoftwareTokenRequest.getSession() != null) {
                String session = verifySoftwareTokenRequest.getSession();
                jsonWriter.name("Session");
                jsonWriter.value(session);
            }
            if (verifySoftwareTokenRequest.getUserCode() != null) {
                String userCode = verifySoftwareTokenRequest.getUserCode();
                jsonWriter.name("UserCode");
                jsonWriter.value(userCode);
            }
            if (verifySoftwareTokenRequest.getFriendlyDeviceName() != null) {
                String friendlyDeviceName = verifySoftwareTokenRequest.getFriendlyDeviceName();
                jsonWriter.name("FriendlyDeviceName");
                jsonWriter.value(friendlyDeviceName);
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
