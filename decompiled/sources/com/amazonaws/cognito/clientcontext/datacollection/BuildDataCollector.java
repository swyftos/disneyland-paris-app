package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class BuildDataCollector extends DataCollector {
    @Override // com.amazonaws.cognito.clientcontext.datacollection.DataCollector
    public Map<String, String> collect(Context context) {
        HashMap map = new HashMap();
        map.put(DataRecordKey.BRAND, Build.BRAND);
        map.put(DataRecordKey.FINGERPRINT, Build.FINGERPRINT);
        map.put(DataRecordKey.HARDWARE, Build.HARDWARE);
        map.put(DataRecordKey.MODEL, Build.MODEL);
        map.put(DataRecordKey.PRODUCT, Build.PRODUCT);
        map.put(DataRecordKey.BUILD_TYPE, Build.TYPE);
        map.put(DataRecordKey.VERSION_RELEASE, Build.VERSION.RELEASE);
        map.put(DataRecordKey.VERSION_SDK, Build.VERSION.SDK);
        return map;
    }
}
