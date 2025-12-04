package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class UpdateGroupRequestMarshaller implements Marshaller<Request<UpdateGroupRequest>, UpdateGroupRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateGroupRequest> marshall(UpdateGroupRequest updateGroupRequest) {
        if (updateGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateGroupRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateGroupRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateGroup");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateGroupRequest.getGroupName() != null) {
                String groupName = updateGroupRequest.getGroupName();
                jsonWriter.name("GroupName");
                jsonWriter.value(groupName);
            }
            if (updateGroupRequest.getUserPoolId() != null) {
                String userPoolId = updateGroupRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateGroupRequest.getDescription() != null) {
                String description = updateGroupRequest.getDescription();
                jsonWriter.name("Description");
                jsonWriter.value(description);
            }
            if (updateGroupRequest.getRoleArn() != null) {
                String roleArn = updateGroupRequest.getRoleArn();
                jsonWriter.name("RoleArn");
                jsonWriter.value(roleArn);
            }
            if (updateGroupRequest.getPrecedence() != null) {
                Integer precedence = updateGroupRequest.getPrecedence();
                jsonWriter.name("Precedence");
                jsonWriter.value(precedence);
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
