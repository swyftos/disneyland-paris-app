package com.rnfs;

import com.facebook.react.bridge.ReadableMap;
import java.io.File;
import java.net.URL;
import java.util.Map;

/* loaded from: classes4.dex */
public class DownloadParams {
    public int connectionTimeout;
    public File dest;
    public ReadableMap headers;
    public OnDownloadBegin onDownloadBegin;
    public OnDownloadProgress onDownloadProgress;
    public OnTaskCompleted onTaskCompleted;
    public float progressDivider;
    public int progressInterval;
    public int readTimeout;
    public URL src;

    public interface OnDownloadBegin {
        void onDownloadBegin(int i, long j, Map<String, String> map);
    }

    public interface OnDownloadProgress {
        void onDownloadProgress(long j, long j2);
    }

    public interface OnTaskCompleted {
        void onTaskCompleted(DownloadResult downloadResult);
    }
}
