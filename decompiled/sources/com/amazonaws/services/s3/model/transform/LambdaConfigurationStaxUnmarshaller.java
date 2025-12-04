package com.amazonaws.services.s3.model.transform;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.model.CloudFunctionConfiguration;
import com.amazonaws.services.s3.model.Filter;
import com.amazonaws.services.s3.model.LambdaConfiguration;
import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class LambdaConfigurationStaxUnmarshaller implements Unmarshaller<Map.Entry<String, NotificationConfiguration>, StaxUnmarshallerContext> {
    private static LambdaConfigurationStaxUnmarshaller instance = new LambdaConfigurationStaxUnmarshaller();

    public static LambdaConfigurationStaxUnmarshaller getInstance() {
        return instance;
    }

    private LambdaConfigurationStaxUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public Map.Entry unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i = currentDepth + 2;
        }
        ArrayList arrayList = new ArrayList();
        String strUnmarshall = null;
        String strUnmarshall2 = null;
        String strUnmarshall3 = null;
        Filter filterUnmarshall = null;
        while (true) {
            int iNextEvent = staxUnmarshallerContext.nextEvent();
            if (iNextEvent == 1) {
                return null;
            }
            if (iNextEvent == 2) {
                if (staxUnmarshallerContext.testExpression(JsonDocumentFields.POLICY_ID, i)) {
                    strUnmarshall = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                } else if (staxUnmarshallerContext.testExpression("Event", i)) {
                    arrayList.add(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Filter", i)) {
                    filterUnmarshall = FilterStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                } else if (staxUnmarshallerContext.testExpression("CloudFunction", i)) {
                    strUnmarshall2 = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                } else if (staxUnmarshallerContext.testExpression("InvocationRole", i)) {
                    strUnmarshall3 = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                }
            } else if (iNextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createLambdaConfig(strUnmarshall, arrayList, strUnmarshall2, strUnmarshall3, filterUnmarshall);
            }
        }
    }

    private Map.Entry createLambdaConfig(String str, List list, String str2, String str3, Filter filter) {
        NotificationConfiguration cloudFunctionConfiguration;
        if (str3 == null) {
            cloudFunctionConfiguration = new LambdaConfiguration(str2, (String[]) list.toArray(new String[0]));
        } else {
            cloudFunctionConfiguration = new CloudFunctionConfiguration(str3, str2, (String[]) list.toArray(new String[0]));
        }
        return new AbstractMap.SimpleEntry(str, cloudFunctionConfiguration.withFilter(filter));
    }
}
