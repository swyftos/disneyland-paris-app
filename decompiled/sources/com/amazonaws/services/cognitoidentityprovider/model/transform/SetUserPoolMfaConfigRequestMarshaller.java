package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserPoolMfaConfigRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SmsMfaConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaConfigType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class SetUserPoolMfaConfigRequestMarshaller implements Marshaller<Request<SetUserPoolMfaConfigRequest>, SetUserPoolMfaConfigRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<SetUserPoolMfaConfigRequest> marshall(SetUserPoolMfaConfigRequest setUserPoolMfaConfigRequest) {
        if (setUserPoolMfaConfigRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(SetUserPoolMfaConfigRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(setUserPoolMfaConfigRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.SetUserPoolMfaConfig");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (setUserPoolMfaConfigRequest.getUserPoolId() != null) {
                String userPoolId = setUserPoolMfaConfigRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (setUserPoolMfaConfigRequest.getSmsMfaConfiguration() != null) {
                SmsMfaConfigType smsMfaConfiguration = setUserPoolMfaConfigRequest.getSmsMfaConfiguration();
                jsonWriter.name("SmsMfaConfiguration");
                SmsMfaConfigTypeJsonMarshaller.getInstance().marshall(smsMfaConfiguration, jsonWriter);
            }
            if (setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration() != null) {
                SoftwareTokenMfaConfigType softwareTokenMfaConfiguration = setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration();
                jsonWriter.name("SoftwareTokenMfaConfiguration");
                SoftwareTokenMfaConfigTypeJsonMarshaller.getInstance().marshall(softwareTokenMfaConfiguration, jsonWriter);
            }
            if (setUserPoolMfaConfigRequest.getMfaConfiguration() != null) {
                String mfaConfiguration = setUserPoolMfaConfigRequest.getMfaConfiguration();
                jsonWriter.name("MfaConfiguration");
                jsonWriter.value(mfaConfiguration);
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
