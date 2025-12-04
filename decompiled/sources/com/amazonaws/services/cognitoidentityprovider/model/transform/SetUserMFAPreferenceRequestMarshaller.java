package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.SMSMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class SetUserMFAPreferenceRequestMarshaller implements Marshaller<Request<SetUserMFAPreferenceRequest>, SetUserMFAPreferenceRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<SetUserMFAPreferenceRequest> marshall(SetUserMFAPreferenceRequest setUserMFAPreferenceRequest) {
        if (setUserMFAPreferenceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(SetUserMFAPreferenceRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(setUserMFAPreferenceRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.SetUserMFAPreference");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (setUserMFAPreferenceRequest.getSMSMfaSettings() != null) {
                SMSMfaSettingsType sMSMfaSettings = setUserMFAPreferenceRequest.getSMSMfaSettings();
                jsonWriter.name("SMSMfaSettings");
                SMSMfaSettingsTypeJsonMarshaller.getInstance().marshall(sMSMfaSettings, jsonWriter);
            }
            if (setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() != null) {
                SoftwareTokenMfaSettingsType softwareTokenMfaSettings = setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings();
                jsonWriter.name("SoftwareTokenMfaSettings");
                SoftwareTokenMfaSettingsTypeJsonMarshaller.getInstance().marshall(softwareTokenMfaSettings, jsonWriter);
            }
            if (setUserMFAPreferenceRequest.getAccessToken() != null) {
                String accessToken = setUserMFAPreferenceRequest.getAccessToken();
                jsonWriter.name("AccessToken");
                jsonWriter.value(accessToken);
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
