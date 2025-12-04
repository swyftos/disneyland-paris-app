package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolClientRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class UpdateUserPoolClientRequestMarshaller implements Marshaller<Request<UpdateUserPoolClientRequest>, UpdateUserPoolClientRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateUserPoolClientRequest> marshall(UpdateUserPoolClientRequest updateUserPoolClientRequest) {
        if (updateUserPoolClientRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateUserPoolClientRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateUserPoolClientRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateUserPoolClient");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateUserPoolClientRequest.getUserPoolId() != null) {
                String userPoolId = updateUserPoolClientRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateUserPoolClientRequest.getClientId() != null) {
                String clientId = updateUserPoolClientRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (updateUserPoolClientRequest.getClientName() != null) {
                String clientName = updateUserPoolClientRequest.getClientName();
                jsonWriter.name("ClientName");
                jsonWriter.value(clientName);
            }
            if (updateUserPoolClientRequest.getRefreshTokenValidity() != null) {
                Integer refreshTokenValidity = updateUserPoolClientRequest.getRefreshTokenValidity();
                jsonWriter.name("RefreshTokenValidity");
                jsonWriter.value(refreshTokenValidity);
            }
            if (updateUserPoolClientRequest.getReadAttributes() != null) {
                List<String> readAttributes = updateUserPoolClientRequest.getReadAttributes();
                jsonWriter.name("ReadAttributes");
                jsonWriter.beginArray();
                for (String str : readAttributes) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getWriteAttributes() != null) {
                List<String> writeAttributes = updateUserPoolClientRequest.getWriteAttributes();
                jsonWriter.name("WriteAttributes");
                jsonWriter.beginArray();
                for (String str2 : writeAttributes) {
                    if (str2 != null) {
                        jsonWriter.value(str2);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getExplicitAuthFlows() != null) {
                List<String> explicitAuthFlows = updateUserPoolClientRequest.getExplicitAuthFlows();
                jsonWriter.name("ExplicitAuthFlows");
                jsonWriter.beginArray();
                for (String str3 : explicitAuthFlows) {
                    if (str3 != null) {
                        jsonWriter.value(str3);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getSupportedIdentityProviders() != null) {
                List<String> supportedIdentityProviders = updateUserPoolClientRequest.getSupportedIdentityProviders();
                jsonWriter.name("SupportedIdentityProviders");
                jsonWriter.beginArray();
                for (String str4 : supportedIdentityProviders) {
                    if (str4 != null) {
                        jsonWriter.value(str4);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getCallbackURLs() != null) {
                List<String> callbackURLs = updateUserPoolClientRequest.getCallbackURLs();
                jsonWriter.name("CallbackURLs");
                jsonWriter.beginArray();
                for (String str5 : callbackURLs) {
                    if (str5 != null) {
                        jsonWriter.value(str5);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getLogoutURLs() != null) {
                List<String> logoutURLs = updateUserPoolClientRequest.getLogoutURLs();
                jsonWriter.name("LogoutURLs");
                jsonWriter.beginArray();
                for (String str6 : logoutURLs) {
                    if (str6 != null) {
                        jsonWriter.value(str6);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getDefaultRedirectURI() != null) {
                String defaultRedirectURI = updateUserPoolClientRequest.getDefaultRedirectURI();
                jsonWriter.name("DefaultRedirectURI");
                jsonWriter.value(defaultRedirectURI);
            }
            if (updateUserPoolClientRequest.getAllowedOAuthFlows() != null) {
                List<String> allowedOAuthFlows = updateUserPoolClientRequest.getAllowedOAuthFlows();
                jsonWriter.name("AllowedOAuthFlows");
                jsonWriter.beginArray();
                for (String str7 : allowedOAuthFlows) {
                    if (str7 != null) {
                        jsonWriter.value(str7);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getAllowedOAuthScopes() != null) {
                List<String> allowedOAuthScopes = updateUserPoolClientRequest.getAllowedOAuthScopes();
                jsonWriter.name("AllowedOAuthScopes");
                jsonWriter.beginArray();
                for (String str8 : allowedOAuthScopes) {
                    if (str8 != null) {
                        jsonWriter.value(str8);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() != null) {
                Boolean allowedOAuthFlowsUserPoolClient = updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient();
                jsonWriter.name("AllowedOAuthFlowsUserPoolClient");
                jsonWriter.value(allowedOAuthFlowsUserPoolClient.booleanValue());
            }
            if (updateUserPoolClientRequest.getAnalyticsConfiguration() != null) {
                AnalyticsConfigurationType analyticsConfiguration = updateUserPoolClientRequest.getAnalyticsConfiguration();
                jsonWriter.name("AnalyticsConfiguration");
                AnalyticsConfigurationTypeJsonMarshaller.getInstance().marshall(analyticsConfiguration, jsonWriter);
            }
            if (updateUserPoolClientRequest.getPreventUserExistenceErrors() != null) {
                String preventUserExistenceErrors = updateUserPoolClientRequest.getPreventUserExistenceErrors();
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
