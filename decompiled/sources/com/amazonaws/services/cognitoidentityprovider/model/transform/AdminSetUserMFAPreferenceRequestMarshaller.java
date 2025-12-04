package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SMSMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminSetUserMFAPreferenceRequestMarshaller implements Marshaller<Request<AdminSetUserMFAPreferenceRequest>, AdminSetUserMFAPreferenceRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminSetUserMFAPreferenceRequest> marshall(AdminSetUserMFAPreferenceRequest adminSetUserMFAPreferenceRequest) {
        if (adminSetUserMFAPreferenceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminSetUserMFAPreferenceRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminSetUserMFAPreferenceRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminSetUserMFAPreference");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminSetUserMFAPreferenceRequest.getSMSMfaSettings() != null) {
                SMSMfaSettingsType sMSMfaSettings = adminSetUserMFAPreferenceRequest.getSMSMfaSettings();
                jsonWriter.name("SMSMfaSettings");
                SMSMfaSettingsTypeJsonMarshaller.getInstance().marshall(sMSMfaSettings, jsonWriter);
            }
            if (adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() != null) {
                SoftwareTokenMfaSettingsType softwareTokenMfaSettings = adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings();
                jsonWriter.name("SoftwareTokenMfaSettings");
                SoftwareTokenMfaSettingsTypeJsonMarshaller.getInstance().marshall(softwareTokenMfaSettings, jsonWriter);
            }
            if (adminSetUserMFAPreferenceRequest.getUsername() != null) {
                String username = adminSetUserMFAPreferenceRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminSetUserMFAPreferenceRequest.getUserPoolId() != null) {
                String userPoolId = adminSetUserMFAPreferenceRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
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
