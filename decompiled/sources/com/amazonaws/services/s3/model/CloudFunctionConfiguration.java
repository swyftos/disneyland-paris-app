package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

@Deprecated
/* loaded from: classes2.dex */
public class CloudFunctionConfiguration extends NotificationConfiguration implements Serializable {
    private final String cloudFunctionARN;
    private final String invocationRoleARN;

    public CloudFunctionConfiguration(String str, String str2, EnumSet<S3Event> enumSet) {
        super(enumSet);
        this.invocationRoleARN = str;
        this.cloudFunctionARN = str2;
    }

    public CloudFunctionConfiguration(String str, String str2, String... strArr) {
        super(strArr);
        this.invocationRoleARN = str;
        this.cloudFunctionARN = str2;
    }

    public String getInvocationRoleARN() {
        return this.invocationRoleARN;
    }

    public String getCloudFunctionARN() {
        return this.cloudFunctionARN;
    }
}
