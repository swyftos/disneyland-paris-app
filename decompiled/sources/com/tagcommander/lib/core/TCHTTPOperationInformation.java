package com.tagcommander.lib.core;

import androidx.camera.video.AudioStats;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class TCHTTPOperationInformation implements Serializable {
    public String url;
    public String postData = "";
    public double timestamp = AudioStats.AUDIO_AMPLITUDE_NONE;
    public EType hitType = EType.HTTP_REQUEST;
    public String partner = "";

    public enum EType {
        HTTP_REQUEST(1),
        SEGMENT_REQUEST(2),
        CONFIGURATION(3),
        VENDOR_DISCLOSURE(4),
        PARTNER(5);

        private final int value;

        EType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public boolean hasPostData() {
        String str = this.postData;
        return (str == null || str.isEmpty()) ? false : true;
    }
}
