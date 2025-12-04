package androidx.test.espresso;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class UiController$$CC {
    public static boolean injectMotionEventSequence$$dflt$$(UiController uiController, Iterable iterable) throws InjectEventSecurityException {
        Log.w("UIC", "Using default injectMotionEventSeq() - this may not inject a sequence properly. If wrapping UIController please override this method and delegate.");
        Iterator it = iterable.iterator();
        boolean zInjectMotionEvent = true;
        while (it.hasNext()) {
            MotionEvent motionEvent = (MotionEvent) it.next();
            if (motionEvent.getEventTime() - SystemClock.uptimeMillis() > 10) {
                uiController.loopMainThreadForAtLeast(10L);
            }
            zInjectMotionEvent &= uiController.injectMotionEvent(motionEvent);
        }
        return zInjectMotionEvent;
    }
}
