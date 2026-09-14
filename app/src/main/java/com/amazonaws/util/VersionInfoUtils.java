package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public class VersionInfoUtils {
    private static final Log log = LogFactory.getLog(VersionInfoUtils.class);
    private static volatile String platform = "android";
    private static volatile String userAgent = null;
    private static volatile String version = "2.18.0";

    public static String getVersion() {
        return version;
    }

    public static String getPlatform() {
        return platform;
    }

    public static String getUserAgent() {
        if (userAgent == null) {
            synchronized (VersionInfoUtils.class) {
                try {
                    if (userAgent == null) {
                        initializeUserAgent();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return userAgent;
    }

    private static void initializeUserAgent() {
        userAgent = userAgent();
    }

    static String userAgent() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("aws-sdk-");
        sb.append(StringUtils.lowerCase(getPlatform()));
        sb.append("/");
        sb.append(getVersion());
        sb.append(" ");
        sb.append(replaceSpaces(System.getProperty(SystemProperties.OS_NAME)));
        sb.append("/");
        sb.append(replaceSpaces(System.getProperty(SystemProperties.OS_VERSION)));
        sb.append(" ");
        sb.append(replaceSpaces(System.getProperty(SystemProperties.JAVA_VM_NAME)));
        sb.append("/");
        sb.append(replaceSpaces(System.getProperty(SystemProperties.JAVA_VM_VERSION)));
        sb.append("/");
        sb.append(replaceSpaces(System.getProperty(SystemProperties.JAVA_VERSION)));
        String property = System.getProperty(SystemProperties.USER_LANGUAGE);
        String property2 = System.getProperty(SystemProperties.USER_REGION);
        if (property != null && property2 != null) {
            sb.append(" ");
            sb.append(replaceSpaces(property));
            sb.append("_");
            sb.append(replaceSpaces(property2));
        }
        return sb.toString();
    }

    private static String replaceSpaces(String str) {
        return str.replace(' ', '_');
    }
}
