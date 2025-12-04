package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ResourceServerScopeType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class ResourceServerScopeTypeJsonMarshaller {
    private static ResourceServerScopeTypeJsonMarshaller instance;

    ResourceServerScopeTypeJsonMarshaller() {
    }

    public void marshall(ResourceServerScopeType resourceServerScopeType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (resourceServerScopeType.getScopeName() != null) {
            String scopeName = resourceServerScopeType.getScopeName();
            awsJsonWriter.name("ScopeName");
            awsJsonWriter.value(scopeName);
        }
        if (resourceServerScopeType.getScopeDescription() != null) {
            String scopeDescription = resourceServerScopeType.getScopeDescription();
            awsJsonWriter.name("ScopeDescription");
            awsJsonWriter.value(scopeDescription);
        }
        awsJsonWriter.endObject();
    }

    public static ResourceServerScopeTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ResourceServerScopeTypeJsonMarshaller();
        }
        return instance;
    }
}
