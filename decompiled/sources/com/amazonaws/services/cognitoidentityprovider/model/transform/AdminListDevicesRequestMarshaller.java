package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminListDevicesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminListDevicesRequestMarshaller implements Marshaller<Request<AdminListDevicesRequest>, AdminListDevicesRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminListDevicesRequest> marshall(AdminListDevicesRequest adminListDevicesRequest) {
        if (adminListDevicesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminListDevicesRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminListDevicesRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminListDevices");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminListDevicesRequest.getUserPoolId() != null) {
                String userPoolId = adminListDevicesRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminListDevicesRequest.getUsername() != null) {
                String username = adminListDevicesRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminListDevicesRequest.getLimit() != null) {
                Integer limit = adminListDevicesRequest.getLimit();
                jsonWriter.name("Limit");
                jsonWriter.value(limit);
            }
            if (adminListDevicesRequest.getPaginationToken() != null) {
                String paginationToken = adminListDevicesRequest.getPaginationToken();
                jsonWriter.name("PaginationToken");
                jsonWriter.value(paginationToken);
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
