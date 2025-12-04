package com.rnfs;

import com.facebook.react.bridge.ReadableMap;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class UploadParams {
    public boolean binaryStreamOnly;
    public ReadableMap fields;
    public ArrayList<ReadableMap> files;
    public ReadableMap headers;
    public String method;
    public String name;
    public onUploadBegin onUploadBegin;
    public onUploadComplete onUploadComplete;
    public onUploadProgress onUploadProgress;
    public URL src;

    public interface onUploadBegin {
        void onUploadBegin();
    }

    public interface onUploadComplete {
        void onUploadComplete(UploadResult uploadResult);
    }

    public interface onUploadProgress {
        void onUploadProgress(int i, int i2);
    }
}
