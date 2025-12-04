package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SchemaAttributeType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class AddCustomAttributesRequestMarshaller implements Marshaller<Request<AddCustomAttributesRequest>, AddCustomAttributesRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AddCustomAttributesRequest> marshall(AddCustomAttributesRequest addCustomAttributesRequest) {
        if (addCustomAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AddCustomAttributesRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(addCustomAttributesRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AddCustomAttributes");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (addCustomAttributesRequest.getUserPoolId() != null) {
                String userPoolId = addCustomAttributesRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (addCustomAttributesRequest.getCustomAttributes() != null) {
                List<SchemaAttributeType> customAttributes = addCustomAttributesRequest.getCustomAttributes();
                jsonWriter.name("CustomAttributes");
                jsonWriter.beginArray();
                for (SchemaAttributeType schemaAttributeType : customAttributes) {
                    if (schemaAttributeType != null) {
                        SchemaAttributeTypeJsonMarshaller.getInstance().marshall(schemaAttributeType, jsonWriter);
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
