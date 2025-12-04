package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AdminCreateUserRequestMarshaller implements Marshaller<Request<AdminCreateUserRequest>, AdminCreateUserRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminCreateUserRequest> marshall(AdminCreateUserRequest adminCreateUserRequest) {
        if (adminCreateUserRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminCreateUserRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminCreateUserRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminCreateUser");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminCreateUserRequest.getUserPoolId() != null) {
                String userPoolId = adminCreateUserRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminCreateUserRequest.getUsername() != null) {
                String username = adminCreateUserRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminCreateUserRequest.getUserAttributes() != null) {
                List<AttributeType> userAttributes = adminCreateUserRequest.getUserAttributes();
                jsonWriter.name("UserAttributes");
                jsonWriter.beginArray();
                for (AttributeType attributeType : userAttributes) {
                    if (attributeType != null) {
                        AttributeTypeJsonMarshaller.getInstance().marshall(attributeType, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }
            if (adminCreateUserRequest.getValidationData() != null) {
                List<AttributeType> validationData = adminCreateUserRequest.getValidationData();
                jsonWriter.name("ValidationData");
                jsonWriter.beginArray();
                for (AttributeType attributeType2 : validationData) {
                    if (attributeType2 != null) {
                        AttributeTypeJsonMarshaller.getInstance().marshall(attributeType2, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }
            if (adminCreateUserRequest.getTemporaryPassword() != null) {
                String temporaryPassword = adminCreateUserRequest.getTemporaryPassword();
                jsonWriter.name("TemporaryPassword");
                jsonWriter.value(temporaryPassword);
            }
            if (adminCreateUserRequest.getForceAliasCreation() != null) {
                Boolean forceAliasCreation = adminCreateUserRequest.getForceAliasCreation();
                jsonWriter.name("ForceAliasCreation");
                jsonWriter.value(forceAliasCreation.booleanValue());
            }
            if (adminCreateUserRequest.getMessageAction() != null) {
                String messageAction = adminCreateUserRequest.getMessageAction();
                jsonWriter.name("MessageAction");
                jsonWriter.value(messageAction);
            }
            if (adminCreateUserRequest.getDesiredDeliveryMediums() != null) {
                List<String> desiredDeliveryMediums = adminCreateUserRequest.getDesiredDeliveryMediums();
                jsonWriter.name("DesiredDeliveryMediums");
                jsonWriter.beginArray();
                for (String str : desiredDeliveryMediums) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
            }
            if (adminCreateUserRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = adminCreateUserRequest.getClientMetadata();
                jsonWriter.name("ClientMetadata");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : clientMetadata.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
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
