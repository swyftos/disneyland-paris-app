package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class ChangePasswordRequestMarshaller implements Marshaller<Request<ChangePasswordRequest>, ChangePasswordRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ChangePasswordRequest> marshall(ChangePasswordRequest changePasswordRequest) {
        if (changePasswordRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ChangePasswordRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(changePasswordRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.ChangePassword");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (changePasswordRequest.getPreviousPassword() != null) {
                String previousPassword = changePasswordRequest.getPreviousPassword();
                jsonWriter.name("PreviousPassword");
                jsonWriter.value(previousPassword);
            }
            if (changePasswordRequest.getProposedPassword() != null) {
                String proposedPassword = changePasswordRequest.getProposedPassword();
                jsonWriter.name("ProposedPassword");
                jsonWriter.value(proposedPassword);
            }
            if (changePasswordRequest.getAccessToken() != null) {
                String accessToken = changePasswordRequest.getAccessToken();
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
