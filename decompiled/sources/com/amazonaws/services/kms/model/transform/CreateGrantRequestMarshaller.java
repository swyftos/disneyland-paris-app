package com.amazonaws.services.kms.model.transform;

import androidx.constraintlayout.widget.Constraints;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.CreateGrantRequest;
import com.amazonaws.services.kms.model.GrantConstraints;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class CreateGrantRequestMarshaller implements Marshaller<Request<CreateGrantRequest>, CreateGrantRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<CreateGrantRequest> marshall(CreateGrantRequest createGrantRequest) {
        if (createGrantRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(CreateGrantRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(createGrantRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.CreateGrant");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (createGrantRequest.getKeyId() != null) {
                String keyId = createGrantRequest.getKeyId();
                jsonWriter.name("KeyId");
                jsonWriter.value(keyId);
            }
            if (createGrantRequest.getGranteePrincipal() != null) {
                String granteePrincipal = createGrantRequest.getGranteePrincipal();
                jsonWriter.name("GranteePrincipal");
                jsonWriter.value(granteePrincipal);
            }
            if (createGrantRequest.getRetiringPrincipal() != null) {
                String retiringPrincipal = createGrantRequest.getRetiringPrincipal();
                jsonWriter.name("RetiringPrincipal");
                jsonWriter.value(retiringPrincipal);
            }
            if (createGrantRequest.getOperations() != null) {
                List<String> operations = createGrantRequest.getOperations();
                jsonWriter.name("Operations");
                jsonWriter.beginArray();
                for (String str : operations) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
            }
            if (createGrantRequest.getConstraints() != null) {
                GrantConstraints constraints = createGrantRequest.getConstraints();
                jsonWriter.name(Constraints.TAG);
                GrantConstraintsJsonMarshaller.getInstance().marshall(constraints, jsonWriter);
            }
            if (createGrantRequest.getGrantTokens() != null) {
                List<String> grantTokens = createGrantRequest.getGrantTokens();
                jsonWriter.name("GrantTokens");
                jsonWriter.beginArray();
                for (String str2 : grantTokens) {
                    if (str2 != null) {
                        jsonWriter.value(str2);
                    }
                }
                jsonWriter.endArray();
            }
            if (createGrantRequest.getName() != null) {
                String name = createGrantRequest.getName();
                jsonWriter.name("Name");
                jsonWriter.value(name);
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
