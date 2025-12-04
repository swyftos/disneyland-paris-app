package com.ReactNativeBlobUtil;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes2.dex */
public class ReactNativeBlobUtilProgressConfig {
    private int count;
    private boolean enable;
    private int interval;
    private long lastTick = 0;
    private int tick = 0;
    private ReportType type;

    enum ReportType {
        Upload,
        Download
    }

    ReactNativeBlobUtilProgressConfig(boolean z, int i, int i2, ReportType reportType) {
        this.count = -1;
        this.interval = -1;
        this.enable = false;
        ReportType reportType2 = ReportType.Upload;
        this.enable = z;
        this.interval = i;
        this.type = reportType;
        this.count = i2;
    }

    public boolean shouldReport(float f) {
        int i = this.count;
        boolean z = false;
        boolean z2 = i <= 0 || f <= BitmapDescriptorFactory.HUE_RED || Math.floor((double) (f * ((float) i))) > ((double) this.tick);
        if (System.currentTimeMillis() - this.lastTick > this.interval && this.enable && z2) {
            z = true;
        }
        if (z) {
            this.tick++;
            this.lastTick = System.currentTimeMillis();
        }
        return z;
    }
}
