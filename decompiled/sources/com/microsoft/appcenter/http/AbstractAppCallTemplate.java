package com.microsoft.appcenter.http;

import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class AbstractAppCallTemplate implements HttpClient.CallTemplate {
    @Override // com.microsoft.appcenter.http.HttpClient.CallTemplate
    public void onBeforeCalling(URL url, Map<String, String> map) {
        if (AppCenterLog.getLogLevel() <= 2) {
            AppCenterLog.verbose("AppCenter", "Calling " + url + "...");
            HashMap map2 = new HashMap(map);
            String str = (String) map2.get(Constants.APP_SECRET);
            if (str != null) {
                map2.put(Constants.APP_SECRET, HttpUtils.hideSecret(str));
            }
            AppCenterLog.verbose("AppCenter", "Headers: " + map2);
        }
    }
}
