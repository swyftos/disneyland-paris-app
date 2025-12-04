package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.CustomDomainConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class UpdateUserPoolDomainRequestMarshaller implements Marshaller<Request<UpdateUserPoolDomainRequest>, UpdateUserPoolDomainRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateUserPoolDomainRequest> marshall(UpdateUserPoolDomainRequest updateUserPoolDomainRequest) {
        if (updateUserPoolDomainRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateUserPoolDomainRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateUserPoolDomainRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateUserPoolDomain");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateUserPoolDomainRequest.getDomain() != null) {
                String domain = updateUserPoolDomainRequest.getDomain();
                jsonWriter.name("Domain");
                jsonWriter.value(domain);
            }
            if (updateUserPoolDomainRequest.getUserPoolId() != null) {
                String userPoolId = updateUserPoolDomainRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateUserPoolDomainRequest.getCustomDomainConfig() != null) {
                CustomDomainConfigType customDomainConfig = updateUserPoolDomainRequest.getCustomDomainConfig();
                jsonWriter.name("CustomDomainConfig");
                CustomDomainConfigTypeJsonMarshaller.getInstance().marshall(customDomainConfig, jsonWriter);
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
