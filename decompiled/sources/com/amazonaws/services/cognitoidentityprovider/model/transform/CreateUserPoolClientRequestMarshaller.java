package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolClientRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class CreateUserPoolClientRequestMarshaller implements Marshaller<Request<CreateUserPoolClientRequest>, CreateUserPoolClientRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<CreateUserPoolClientRequest> marshall(CreateUserPoolClientRequest createUserPoolClientRequest) {
        if (createUserPoolClientRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(CreateUserPoolClientRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(createUserPoolClientRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.CreateUserPoolClient");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (createUserPoolClientRequest.getUserPoolId() != null) {
                String userPoolId = createUserPoolClientRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (createUserPoolClientRequest.getClientName() != null) {
                String clientName = createUserPoolClientRequest.getClientName();
                jsonWriter.name("ClientName");
                jsonWriter.value(clientName);
            }
            if (createUserPoolClientRequest.getGenerateSecret() != null) {
                Boolean generateSecret = createUserPoolClientRequest.getGenerateSecret();
                jsonWriter.name("GenerateSecret");
                jsonWriter.value(generateSecret.booleanValue());
            }
            if (createUserPoolClientRequest.getRefreshTokenValidity() != null) {
                Integer refreshTokenValidity = createUserPoolClientRequest.getRefreshTokenValidity();
                jsonWriter.name("RefreshTokenValidity");
                jsonWriter.value(refreshTokenValidity);
            }
            if (createUserPoolClientRequest.getReadAttributes() != null) {
                List<String> readAttributes = createUserPoolClientRequest.getReadAttributes();
                jsonWriter.name("ReadAttributes");
                jsonWriter.beginArray();
                for (String str : readAttributes) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getWriteAttributes() != null) {
                List<String> writeAttributes = createUserPoolClientRequest.getWriteAttributes();
                jsonWriter.name("WriteAttributes");
                jsonWriter.beginArray();
                for (String str2 : writeAttributes) {
                    if (str2 != null) {
                        jsonWriter.value(str2);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getExplicitAuthFlows() != null) {
                List<String> explicitAuthFlows = createUserPoolClientRequest.getExplicitAuthFlows();
                jsonWriter.name("ExplicitAuthFlows");
                jsonWriter.beginArray();
                for (String str3 : explicitAuthFlows) {
                    if (str3 != null) {
                        jsonWriter.value(str3);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getSupportedIdentityProviders() != null) {
                List<String> supportedIdentityProviders = createUserPoolClientRequest.getSupportedIdentityProviders();
                jsonWriter.name("SupportedIdentityProviders");
                jsonWriter.beginArray();
                for (String str4 : supportedIdentityProviders) {
                    if (str4 != null) {
                        jsonWriter.value(str4);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getCallbackURLs() != null) {
                List<String> callbackURLs = createUserPoolClientRequest.getCallbackURLs();
                jsonWriter.name("CallbackURLs");
                jsonWriter.beginArray();
                for (String str5 : callbackURLs) {
                    if (str5 != null) {
                        jsonWriter.value(str5);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getLogoutURLs() != null) {
                List<String> logoutURLs = createUserPoolClientRequest.getLogoutURLs();
                jsonWriter.name("LogoutURLs");
                jsonWriter.beginArray();
                for (String str6 : logoutURLs) {
                    if (str6 != null) {
                        jsonWriter.value(str6);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getDefaultRedirectURI() != null) {
                String defaultRedirectURI = createUserPoolClientRequest.getDefaultRedirectURI();
                jsonWriter.name("DefaultRedirectURI");
                jsonWriter.value(defaultRedirectURI);
            }
            if (createUserPoolClientRequest.getAllowedOAuthFlows() != null) {
                List<String> allowedOAuthFlows = createUserPoolClientRequest.getAllowedOAuthFlows();
                jsonWriter.name("AllowedOAuthFlows");
                jsonWriter.beginArray();
                for (String str7 : allowedOAuthFlows) {
                    if (str7 != null) {
                        jsonWriter.value(str7);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getAllowedOAuthScopes() != null) {
                List<String> allowedOAuthScopes = createUserPoolClientRequest.getAllowedOAuthScopes();
                jsonWriter.name("AllowedOAuthScopes");
                jsonWriter.beginArray();
                for (String str8 : allowedOAuthScopes) {
                    if (str8 != null) {
                        jsonWriter.value(str8);
                    }
                }
                jsonWriter.endArray();
            }
            if (createUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() != null) {
                Boolean allowedOAuthFlowsUserPoolClient = createUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient();
                jsonWriter.name("AllowedOAuthFlowsUserPoolClient");
                jsonWriter.value(allowedOAuthFlowsUserPoolClient.booleanValue());
            }
            if (createUserPoolClientRequest.getAnalyticsConfiguration() != null) {
                AnalyticsConfigurationType analyticsConfiguration = createUserPoolClientRequest.getAnalyticsConfiguration();
                jsonWriter.name("AnalyticsConfiguration");
                AnalyticsConfigurationTypeJsonMarshaller.getInstance().marshall(analyticsConfiguration, jsonWriter);
            }
            if (createUserPoolClientRequest.getPreventUserExistenceErrors() != null) {
                String preventUserExistenceErrors = createUserPoolClientRequest.getPreventUserExistenceErrors();
                jsonWriter.name("PreventUserExistenceErrors");
                jsonWriter.value(preventUserExistenceErrors);
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
