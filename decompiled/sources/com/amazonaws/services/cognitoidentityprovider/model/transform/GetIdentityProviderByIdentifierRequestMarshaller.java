package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.GetIdentityProviderByIdentifierRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class GetIdentityProviderByIdentifierRequestMarshaller implements Marshaller<Request<GetIdentityProviderByIdentifierRequest>, GetIdentityProviderByIdentifierRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GetIdentityProviderByIdentifierRequest> marshall(GetIdentityProviderByIdentifierRequest getIdentityProviderByIdentifierRequest) {
        if (getIdentityProviderByIdentifierRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(GetIdentityProviderByIdentifierRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(getIdentityProviderByIdentifierRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.GetIdentityProviderByIdentifier");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (getIdentityProviderByIdentifierRequest.getUserPoolId() != null) {
                String userPoolId = getIdentityProviderByIdentifierRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (getIdentityProviderByIdentifierRequest.getIdpIdentifier() != null) {
                String idpIdentifier = getIdentityProviderByIdentifierRequest.getIdpIdentifier();
                jsonWriter.name("IdpIdentifier");
                jsonWriter.value(idpIdentifier);
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
