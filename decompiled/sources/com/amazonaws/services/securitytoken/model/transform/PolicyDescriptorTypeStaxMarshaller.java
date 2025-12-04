package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.util.StringUtils;

/* loaded from: classes2.dex */
class PolicyDescriptorTypeStaxMarshaller {
    private static PolicyDescriptorTypeStaxMarshaller instance;

    PolicyDescriptorTypeStaxMarshaller() {
    }

    public void marshall(PolicyDescriptorType policyDescriptorType, Request request, String str) {
        if (policyDescriptorType.getArn() != null) {
            request.addParameter(str + "arn", StringUtils.fromString(policyDescriptorType.getArn()));
        }
    }

    public static PolicyDescriptorTypeStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyDescriptorTypeStaxMarshaller();
        }
        return instance;
    }
}
