package androidx.test.platform.p013ui;

import android.view.KeyEvent;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface UiController {
    boolean injectKeyEvent(KeyEvent keyEvent) throws InjectEventSecurityException;

    boolean injectMotionEvent(MotionEvent motionEvent) throws InjectEventSecurityException;

    boolean injectString(String str) throws InjectEventSecurityException;

    void loopMainThreadForAtLeast(long j);

    void loopMainThreadUntilIdle();
}
