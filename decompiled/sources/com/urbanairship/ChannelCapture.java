package com.urbanairship;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.app.SimpleApplicationListener;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.util.UAStringUtil;
import java.util.Calendar;

/* loaded from: classes4.dex */
public class ChannelCapture extends AirshipComponent {
    private final ActivityMonitor activityMonitor;
    private final AirshipChannel airshipChannel;
    private ClipboardManager clipboardManager;
    private final AirshipConfigOptions configOptions;
    private final Context context;
    private boolean enabled;
    private int indexOfKnocks;
    private long[] knockTimes;
    private final ApplicationListener listener;

    ChannelCapture(Context context, AirshipConfigOptions airshipConfigOptions, AirshipChannel airshipChannel, PreferenceDataStore preferenceDataStore, ActivityMonitor activityMonitor) {
        super(context, preferenceDataStore);
        this.context = context.getApplicationContext();
        this.configOptions = airshipConfigOptions;
        this.airshipChannel = airshipChannel;
        this.activityMonitor = activityMonitor;
        this.knockTimes = new long[6];
        this.listener = new SimpleApplicationListener() { // from class: com.urbanairship.ChannelCapture.1
            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onForeground(long j) {
                ChannelCapture.this.countForeground(j);
            }
        };
    }

    @Override // com.urbanairship.AirshipComponent
    protected void init() {
        super.init();
        this.enabled = this.configOptions.channelCaptureEnabled;
        this.activityMonitor.addApplicationListener(this.listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countForeground(long j) {
        if (isEnabled()) {
            if (this.indexOfKnocks >= 6) {
                this.indexOfKnocks = 0;
            }
            long[] jArr = this.knockTimes;
            int i = this.indexOfKnocks;
            jArr[i] = j;
            this.indexOfKnocks = i + 1;
            if (checkKnock()) {
                writeClipboard();
            }
        }
    }

    private boolean checkKnock() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        for (long j : this.knockTimes) {
            if (j + 30000 < timeInMillis) {
                return false;
            }
        }
        return true;
    }

    private void writeClipboard() {
        if (this.clipboardManager == null) {
            try {
                this.clipboardManager = (ClipboardManager) this.context.getSystemService("clipboard");
            } catch (Exception e) {
                UALog.e(e, "Unable to initialize clipboard manager: ", new Object[0]);
            }
        }
        if (this.clipboardManager == null) {
            UALog.d("Unable to attempt channel capture, clipboard manager uninitialized", new Object[0]);
            return;
        }
        this.knockTimes = new long[6];
        this.indexOfKnocks = 0;
        String id = this.airshipChannel.getId();
        final String str = "ua:";
        if (!UAStringUtil.isEmpty(id)) {
            str = "ua:" + id;
        }
        try {
            new Handler(AirshipLoopers.getBackgroundLooper()).post(new Runnable() { // from class: com.urbanairship.ChannelCapture.2
                @Override // java.lang.Runnable
                public void run() {
                    ChannelCapture.this.clipboardManager.setPrimaryClip(ClipData.newPlainText("UA Channel ID", str));
                    UALog.d("Channel ID copied to clipboard", new Object[0]);
                }
            });
        } catch (Exception e2) {
            UALog.w(e2, "Channel capture failed! Unable to copy Channel ID to clipboard.", new Object[0]);
        }
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    @Override // com.urbanairship.AirshipComponent
    protected void tearDown() {
        this.activityMonitor.removeApplicationListener(this.listener);
    }
}
