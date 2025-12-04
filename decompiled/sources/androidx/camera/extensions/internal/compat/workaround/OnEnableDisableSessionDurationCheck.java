package androidx.camera.extensions.internal.compat.workaround;

import android.os.SystemClock;
import androidx.camera.core.Logger;
import androidx.camera.extensions.internal.compat.quirk.CrashWhenOnDisableTooSoon;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;

/* loaded from: classes.dex */
public class OnEnableDisableSessionDurationCheck {
    private final boolean mEnabledMinimumDuration;
    private long mOnEnableSessionTimeStamp;

    public OnEnableDisableSessionDurationCheck() {
        this(DeviceQuirks.get(CrashWhenOnDisableTooSoon.class) != null);
    }

    OnEnableDisableSessionDurationCheck(boolean z) {
        this.mOnEnableSessionTimeStamp = 0L;
        this.mEnabledMinimumDuration = z;
    }

    public void onEnableSessionInvoked() {
        if (this.mEnabledMinimumDuration) {
            this.mOnEnableSessionTimeStamp = SystemClock.elapsedRealtime();
        }
    }

    public void onDisableSessionInvoked() throws InterruptedException {
        if (this.mEnabledMinimumDuration) {
            ensureMinDurationAfterOnEnableSession();
        }
    }

    private void ensureMinDurationAfterOnEnableSession() throws InterruptedException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mOnEnableSessionTimeStamp;
        while (true) {
            long j2 = jElapsedRealtime - j;
            if (j2 >= 100) {
                return;
            }
            long j3 = 100 - j2;
            try {
                Logger.d("OnEnableDisableSessionDurationCheck", "onDisableSession too soon, wait " + j3 + " ms");
                Thread.sleep(j3);
                jElapsedRealtime = SystemClock.elapsedRealtime();
                j = this.mOnEnableSessionTimeStamp;
            } catch (InterruptedException unused) {
                Logger.e("OnEnableDisableSessionDurationCheck", "sleep interrupted");
                return;
            }
        }
    }
}
