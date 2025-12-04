package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.ResourceServerScopeType;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class UpdateResourceServerRequestMarshaller implements Marshaller<Request<UpdateResourceServerRequest>, UpdateResourceServerRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateResourceServerRequest> marshall(UpdateResourceServerRequest updateResourceServerRequest) {
        if (updateResourceServerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateResourceServerRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateResourceServerRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateResourceServer");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateResourceServerRequest.getUserPoolId() != null) {
                String userPoolId = updateResourceServerRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateResourceServerRequest.getIdentifier() != null) {
                String identifier = updateResourceServerRequest.getIdentifier();
                jsonWriter.name("Identifier");
                jsonWriter.value(identifier);
            }
            if (updateResourceServerRequest.getName() != null) {
                String name = updateResourceServerRequest.getName();
                jsonWriter.name("Name");
                jsonWriter.value(name);
            }
            if (updateResourceServerRequest.getScopes() != null) {
                List<ResourceServerScopeType> scopes = updateResourceServerRequest.getScopes();
                jsonWriter.name("Scopes");
                jsonWriter.beginArray();
                for (ResourceServerScopeType resourceServerScopeType : scopes) {
                    if (resourceServerScopeType != null) {
                        ResourceServerScopeTypeJsonMarshaller.getInstance().marshall(resourceServerScopeType, jsonWriter);
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
