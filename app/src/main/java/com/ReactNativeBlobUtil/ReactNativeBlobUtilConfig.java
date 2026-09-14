package com.ReactNativeBlobUtil;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.Locale;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* JADX INFO: loaded from: classes2.dex */
class ReactNativeBlobUtilConfig {
    public ReadableMap addAndroidDownloads;
    public String appendExt;
    public Boolean auto;
    public ReadableArray binaryContentTypes;
    public Boolean fileCache;
    public Boolean followRedirect;
    public Boolean increment;
    public String key;
    public String mime;
    public Boolean overwrite;
    public String path;
    public String targetHostIp;
    public long timeout;
    public Boolean transformFile;
    public Boolean trusty;
    public Boolean wifiOnly;

    ReactNativeBlobUtilConfig(ReadableMap readableMap) {
        Boolean bool = Boolean.FALSE;
        this.wifiOnly = bool;
        Boolean bool2 = Boolean.TRUE;
        this.overwrite = bool2;
        this.timeout = 60000L;
        this.increment = bool;
        this.followRedirect = bool2;
        this.binaryContentTypes = null;
        if (readableMap == null) {
            return;
        }
        this.fileCache = Boolean.valueOf(readableMap.hasKey("fileCache") && readableMap.getBoolean("fileCache"));
        this.transformFile = Boolean.valueOf(readableMap.hasKey("transformFile") ? readableMap.getBoolean("transformFile") : false);
        this.path = readableMap.hasKey("path") ? readableMap.getString("path") : null;
        this.appendExt = readableMap.hasKey("appendExt") ? readableMap.getString("appendExt") : "";
        this.trusty = Boolean.valueOf(readableMap.hasKey("trusty") && readableMap.getBoolean("trusty"));
        this.wifiOnly = Boolean.valueOf(readableMap.hasKey("wifiOnly") && readableMap.getBoolean("wifiOnly"));
        this.targetHostIp = readableMap.hasKey("targetHostIp") ? readableMap.getString("targetHostIp") : "";
        if (readableMap.hasKey("addAndroidDownloads")) {
            this.addAndroidDownloads = readableMap.getMap("addAndroidDownloads");
        }
        if (readableMap.hasKey("binaryContentTypes")) {
            this.binaryContentTypes = readableMap.getArray("binaryContentTypes");
        }
        String str = this.path;
        if (str != null && str.toLowerCase(Locale.ROOT).contains("?append=true")) {
            this.overwrite = bool;
        }
        if (readableMap.hasKey("overwrite")) {
            this.overwrite = Boolean.valueOf(readableMap.getBoolean("overwrite"));
        }
        if (readableMap.hasKey("followRedirect")) {
            this.followRedirect = Boolean.valueOf(readableMap.getBoolean("followRedirect"));
        }
        this.key = readableMap.hasKey("key") ? readableMap.getString("key") : null;
        this.mime = readableMap.hasKey(CMSAttributeTableGenerator.CONTENT_TYPE) ? readableMap.getString(CMSAttributeTableGenerator.CONTENT_TYPE) : null;
        this.increment = Boolean.valueOf(readableMap.hasKey("increment") && readableMap.getBoolean("increment"));
        this.auto = Boolean.valueOf(readableMap.hasKey("auto") && readableMap.getBoolean("auto"));
        if (readableMap.hasKey("timeout")) {
            this.timeout = readableMap.getInt("timeout");
        }
    }
}
