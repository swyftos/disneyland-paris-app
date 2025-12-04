package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.SetUICustomizationRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class SetUICustomizationRequestMarshaller implements Marshaller<Request<SetUICustomizationRequest>, SetUICustomizationRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<SetUICustomizationRequest> marshall(SetUICustomizationRequest setUICustomizationRequest) {
        if (setUICustomizationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(SetUICustomizationRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(setUICustomizationRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.SetUICustomization");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (setUICustomizationRequest.getUserPoolId() != null) {
                String userPoolId = setUICustomizationRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (setUICustomizationRequest.getClientId() != null) {
                String clientId = setUICustomizationRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (setUICustomizationRequest.getCSS() != null) {
                String css = setUICustomizationRequest.getCSS();
                jsonWriter.name("CSS");
                jsonWriter.value(css);
            }
            if (setUICustomizationRequest.getImageFile() != null) {
                ByteBuffer imageFile = setUICustomizationRequest.getImageFile();
                jsonWriter.name("ImageFile");
                jsonWriter.value(imageFile);
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
