package androidx.test.espresso.base;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

/* loaded from: classes2.dex */
final class EventInjector {
    private final EventInjectionStrategy injectionStrategy;

    EventInjector(EventInjectionStrategy eventInjectionStrategy) {
        this.injectionStrategy = (EventInjectionStrategy) Preconditions.checkNotNull(eventInjectionStrategy);
    }

    boolean injectKeyEvent(KeyEvent keyEvent) {
        long downTime = keyEvent.getDownTime();
        long eventTime = keyEvent.getEventTime();
        int action = keyEvent.getAction();
        int keyCode = keyEvent.getKeyCode();
        int repeatCount = keyEvent.getRepeatCount();
        int metaState = keyEvent.getMetaState();
        int deviceId = keyEvent.getDeviceId();
        int scanCode = keyEvent.getScanCode();
        int flags = keyEvent.getFlags();
        if (eventTime == 0) {
            eventTime = SystemClock.uptimeMillis();
        }
        long j = eventTime;
        return this.injectionStrategy.injectKeyEvent(new KeyEvent(downTime == 0 ? j : downTime, j, action, keyCode, repeatCount, metaState, deviceId, scanCode, flags | 8, keyEvent.getSource()));
    }

    boolean injectMotionEvent(MotionEvent motionEvent) {
        return this.injectionStrategy.injectMotionEvent(motionEvent, true);
    }

    boolean injectMotionEventAsync(MotionEvent motionEvent) {
        return this.injectionStrategy.injectMotionEvent(motionEvent, false);
    }
}
