package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class VerifyUserAttributeRequestMarshaller implements Marshaller<Request<VerifyUserAttributeRequest>, VerifyUserAttributeRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<VerifyUserAttributeRequest> marshall(VerifyUserAttributeRequest verifyUserAttributeRequest) {
        if (verifyUserAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(VerifyUserAttributeRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(verifyUserAttributeRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.VerifyUserAttribute");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (verifyUserAttributeRequest.getAccessToken() != null) {
                String accessToken = verifyUserAttributeRequest.getAccessToken();
                jsonWriter.name("AccessToken");
                jsonWriter.value(accessToken);
            }
            if (verifyUserAttributeRequest.getAttributeName() != null) {
                String attributeName = verifyUserAttributeRequest.getAttributeName();
                jsonWriter.name("AttributeName");
                jsonWriter.value(attributeName);
            }
            if (verifyUserAttributeRequest.getCode() != null) {
                String code = verifyUserAttributeRequest.getCode();
                jsonWriter.name("Code");
                jsonWriter.value(code);
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
