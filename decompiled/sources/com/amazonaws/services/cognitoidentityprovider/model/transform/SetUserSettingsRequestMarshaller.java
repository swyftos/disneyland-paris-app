package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.MFAOptionType;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class SetUserSettingsRequestMarshaller implements Marshaller<Request<SetUserSettingsRequest>, SetUserSettingsRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<SetUserSettingsRequest> marshall(SetUserSettingsRequest setUserSettingsRequest) {
        if (setUserSettingsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(SetUserSettingsRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(setUserSettingsRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.SetUserSettings");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (setUserSettingsRequest.getAccessToken() != null) {
                String accessToken = setUserSettingsRequest.getAccessToken();
                jsonWriter.name("AccessToken");
                jsonWriter.value(accessToken);
            }
            if (setUserSettingsRequest.getMFAOptions() != null) {
                List<MFAOptionType> mFAOptions = setUserSettingsRequest.getMFAOptions();
                jsonWriter.name("MFAOptions");
                jsonWriter.beginArray();
                for (MFAOptionType mFAOptionType : mFAOptions) {
                    if (mFAOptionType != null) {
                        MFAOptionTypeJsonMarshaller.getInstance().marshall(mFAOptionType, jsonWriter);
                    }
                }
                jsonWriter.endArray();
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
