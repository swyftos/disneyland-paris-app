package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.InstrumentationRegistryHelper;

/* loaded from: classes4.dex */
abstract class ServiceInstrumentationUtils {
    static boolean isServiceDisabledByInstrumentation(String str) {
        try {
            String string = InstrumentationRegistryHelper.getArguments().getString("APP_CENTER_DISABLE");
            if (string == null) {
                return false;
            }
            for (String str2 : string.split(",")) {
                String strTrim = str2.trim();
                if (strTrim.equals("All") || strTrim.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (IllegalStateException | LinkageError unused) {
            AppCenterLog.debug("AppCenter", "Cannot read instrumentation variables in a non-test environment.");
            return false;
        }
    }
}
