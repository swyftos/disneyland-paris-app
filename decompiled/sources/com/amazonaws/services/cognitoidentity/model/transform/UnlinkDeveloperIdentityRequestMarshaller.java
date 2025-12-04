package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.UnlinkDeveloperIdentityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class UnlinkDeveloperIdentityRequestMarshaller implements Marshaller<Request<UnlinkDeveloperIdentityRequest>, UnlinkDeveloperIdentityRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UnlinkDeveloperIdentityRequest> marshall(UnlinkDeveloperIdentityRequest unlinkDeveloperIdentityRequest) {
        if (unlinkDeveloperIdentityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UnlinkDeveloperIdentityRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(unlinkDeveloperIdentityRequest, "AmazonCognitoIdentity");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityService.UnlinkDeveloperIdentity");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (unlinkDeveloperIdentityRequest.getIdentityId() != null) {
                String identityId = unlinkDeveloperIdentityRequest.getIdentityId();
                jsonWriter.name("IdentityId");
                jsonWriter.value(identityId);
            }
            if (unlinkDeveloperIdentityRequest.getIdentityPoolId() != null) {
                String identityPoolId = unlinkDeveloperIdentityRequest.getIdentityPoolId();
                jsonWriter.name("IdentityPoolId");
                jsonWriter.value(identityPoolId);
            }
            if (unlinkDeveloperIdentityRequest.getDeveloperProviderName() != null) {
                String developerProviderName = unlinkDeveloperIdentityRequest.getDeveloperProviderName();
                jsonWriter.name("DeveloperProviderName");
                jsonWriter.value(developerProviderName);
            }
            if (unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier() != null) {
                String developerUserIdentifier = unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier();
                jsonWriter.name("DeveloperUserIdentifier");
                jsonWriter.value(developerUserIdentifier);
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
