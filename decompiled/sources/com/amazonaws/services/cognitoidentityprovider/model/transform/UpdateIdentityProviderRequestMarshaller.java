package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UpdateIdentityProviderRequestMarshaller implements Marshaller<Request<UpdateIdentityProviderRequest>, UpdateIdentityProviderRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateIdentityProviderRequest> marshall(UpdateIdentityProviderRequest updateIdentityProviderRequest) {
        if (updateIdentityProviderRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateIdentityProviderRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateIdentityProviderRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateIdentityProvider");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateIdentityProviderRequest.getUserPoolId() != null) {
                String userPoolId = updateIdentityProviderRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateIdentityProviderRequest.getProviderName() != null) {
                String providerName = updateIdentityProviderRequest.getProviderName();
                jsonWriter.name("ProviderName");
                jsonWriter.value(providerName);
            }
            if (updateIdentityProviderRequest.getProviderDetails() != null) {
                Map<String, String> providerDetails = updateIdentityProviderRequest.getProviderDetails();
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
            if (updateIdentityProviderRequest.getAttributeMapping() != null) {
                Map<String, String> attributeMapping = updateIdentityProviderRequest.getAttributeMapping();
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
            if (updateIdentityProviderRequest.getIdpIdentifiers() != null) {
                List<String> idpIdentifiers = updateIdentityProviderRequest.getIdpIdentifiers();
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
