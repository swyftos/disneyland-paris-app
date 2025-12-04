package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AccountRecoverySettingType;
import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.EmailConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.LambdaConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.SmsConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolAddOnsType;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolPolicyType;
import com.amazonaws.services.cognitoidentityprovider.model.VerificationMessageTemplateType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UpdateUserPoolRequestMarshaller implements Marshaller<Request<UpdateUserPoolRequest>, UpdateUserPoolRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateUserPoolRequest> marshall(UpdateUserPoolRequest updateUserPoolRequest) {
        if (updateUserPoolRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateUserPoolRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateUserPoolRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateUserPool");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateUserPoolRequest.getUserPoolId() != null) {
                String userPoolId = updateUserPoolRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateUserPoolRequest.getPolicies() != null) {
                UserPoolPolicyType policies = updateUserPoolRequest.getPolicies();
                jsonWriter.name("Policies");
                UserPoolPolicyTypeJsonMarshaller.getInstance().marshall(policies, jsonWriter);
            }
            if (updateUserPoolRequest.getLambdaConfig() != null) {
                LambdaConfigType lambdaConfig = updateUserPoolRequest.getLambdaConfig();
                jsonWriter.name("LambdaConfig");
                LambdaConfigTypeJsonMarshaller.getInstance().marshall(lambdaConfig, jsonWriter);
            }
            if (updateUserPoolRequest.getAutoVerifiedAttributes() != null) {
                List<String> autoVerifiedAttributes = updateUserPoolRequest.getAutoVerifiedAttributes();
                jsonWriter.name("AutoVerifiedAttributes");
                jsonWriter.beginArray();
                for (String str : autoVerifiedAttributes) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
            }
            if (updateUserPoolRequest.getSmsVerificationMessage() != null) {
                String smsVerificationMessage = updateUserPoolRequest.getSmsVerificationMessage();
                jsonWriter.name("SmsVerificationMessage");
                jsonWriter.value(smsVerificationMessage);
            }
            if (updateUserPoolRequest.getEmailVerificationMessage() != null) {
                String emailVerificationMessage = updateUserPoolRequest.getEmailVerificationMessage();
                jsonWriter.name("EmailVerificationMessage");
                jsonWriter.value(emailVerificationMessage);
            }
            if (updateUserPoolRequest.getEmailVerificationSubject() != null) {
                String emailVerificationSubject = updateUserPoolRequest.getEmailVerificationSubject();
                jsonWriter.name("EmailVerificationSubject");
                jsonWriter.value(emailVerificationSubject);
            }
            if (updateUserPoolRequest.getVerificationMessageTemplate() != null) {
                VerificationMessageTemplateType verificationMessageTemplate = updateUserPoolRequest.getVerificationMessageTemplate();
                jsonWriter.name("VerificationMessageTemplate");
                VerificationMessageTemplateTypeJsonMarshaller.getInstance().marshall(verificationMessageTemplate, jsonWriter);
            }
            if (updateUserPoolRequest.getSmsAuthenticationMessage() != null) {
                String smsAuthenticationMessage = updateUserPoolRequest.getSmsAuthenticationMessage();
                jsonWriter.name("SmsAuthenticationMessage");
                jsonWriter.value(smsAuthenticationMessage);
            }
            if (updateUserPoolRequest.getMfaConfiguration() != null) {
                String mfaConfiguration = updateUserPoolRequest.getMfaConfiguration();
                jsonWriter.name("MfaConfiguration");
                jsonWriter.value(mfaConfiguration);
            }
            if (updateUserPoolRequest.getDeviceConfiguration() != null) {
                DeviceConfigurationType deviceConfiguration = updateUserPoolRequest.getDeviceConfiguration();
                jsonWriter.name("DeviceConfiguration");
                DeviceConfigurationTypeJsonMarshaller.getInstance().marshall(deviceConfiguration, jsonWriter);
            }
            if (updateUserPoolRequest.getEmailConfiguration() != null) {
                EmailConfigurationType emailConfiguration = updateUserPoolRequest.getEmailConfiguration();
                jsonWriter.name("EmailConfiguration");
                EmailConfigurationTypeJsonMarshaller.getInstance().marshall(emailConfiguration, jsonWriter);
            }
            if (updateUserPoolRequest.getSmsConfiguration() != null) {
                SmsConfigurationType smsConfiguration = updateUserPoolRequest.getSmsConfiguration();
                jsonWriter.name("SmsConfiguration");
                SmsConfigurationTypeJsonMarshaller.getInstance().marshall(smsConfiguration, jsonWriter);
            }
            if (updateUserPoolRequest.getUserPoolTags() != null) {
                Map<String, String> userPoolTags = updateUserPoolRequest.getUserPoolTags();
                jsonWriter.name("UserPoolTags");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : userPoolTags.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
            }
            if (updateUserPoolRequest.getAdminCreateUserConfig() != null) {
                AdminCreateUserConfigType adminCreateUserConfig = updateUserPoolRequest.getAdminCreateUserConfig();
                jsonWriter.name("AdminCreateUserConfig");
                AdminCreateUserConfigTypeJsonMarshaller.getInstance().marshall(adminCreateUserConfig, jsonWriter);
            }
            if (updateUserPoolRequest.getUserPoolAddOns() != null) {
                UserPoolAddOnsType userPoolAddOns = updateUserPoolRequest.getUserPoolAddOns();
                jsonWriter.name("UserPoolAddOns");
                UserPoolAddOnsTypeJsonMarshaller.getInstance().marshall(userPoolAddOns, jsonWriter);
            }
            if (updateUserPoolRequest.getAccountRecoverySetting() != null) {
                AccountRecoverySettingType accountRecoverySetting = updateUserPoolRequest.getAccountRecoverySetting();
                jsonWriter.name("AccountRecoverySetting");
                AccountRecoverySettingTypeJsonMarshaller.getInstance().marshall(accountRecoverySetting, jsonWriter);
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
