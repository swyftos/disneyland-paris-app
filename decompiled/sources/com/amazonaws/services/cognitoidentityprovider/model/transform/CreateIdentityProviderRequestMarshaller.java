package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CreateIdentityProviderRequestMarshaller implements Marshaller<Request<CreateIdentityProviderRequest>, CreateIdentityProviderRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<CreateIdentityProviderRequest> marshall(CreateIdentityProviderRequest createIdentityProviderRequest) {
        if (createIdentityProviderRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(CreateIdentityProviderRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(createIdentityProviderRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.CreateIdentityProvider");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (createIdentityProviderRequest.getUserPoolId() != null) {
                String userPoolId = createIdentityProviderRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (createIdentityProviderRequest.getProviderName() != null) {
                String providerName = createIdentityProviderRequest.getProviderName();
                jsonWriter.name("ProviderName");
                jsonWriter.value(providerName);
            }
            if (createIdentityProviderRequest.getProviderType() != null) {
                String providerType = createIdentityProviderRequest.getProviderType();
                jsonWriter.name("ProviderType");
                jsonWriter.value(providerType);
            }
            if (createIdentityProviderRequest.getProviderDetails() != null) {
                Map<String, String> providerDetails = createIdentityProviderRequest.getProviderDetails();
                jsonWriter.name("ProviderDetails");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : providerDetails.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
            }
            if (createIdentityProviderRequest.getAttributeMapping() != null) {
                Map<String, String> attributeMapping = createIdentityProviderRequest.getAttributeMapping();
                jsonWriter.name("AttributeMapping");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry2 : attributeMapping.entrySet()) {
                    String value2 = entry2.getValue();
                    if (value2 != null) {
                        jsonWriter.name(entry2.getKey());
                        jsonWriter.value(value2);
                    }
                }
                jsonWriter.endObject();
            }
            if (createIdentityProviderRequest.getIdpIdentifiers() != null) {
                List<String> idpIdentifiers = createIdentityProviderRequest.getIdpIdentifiers();
                jsonWriter.name("IdpIdentifiers");
                jsonWriter.beginArray();
                for (String str : idpIdentifiers) {
                    if (str != null) {
                        jsonWriter.value(str);
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
