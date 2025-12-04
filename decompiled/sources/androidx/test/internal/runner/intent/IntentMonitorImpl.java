package androidx.test.internal.runner.intent;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.runner.intent.IntentCallback;
import androidx.test.runner.intent.IntentMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class IntentMonitorImpl implements IntentMonitor {
    List callbacks = Collections.synchronizedList(new ArrayList());

    @Override // androidx.test.runner.intent.IntentMonitor
    public void addIntentCallback(@NonNull IntentCallback intentCallback) {
        if (intentCallback == null) {
            throw new NullPointerException("callback cannot be null!");
        }
        Iterator it = this.callbacks.iterator();
        boolean z = true;
        while (it.hasNext()) {
            IntentCallback intentCallback2 = (IntentCallback) ((WeakReference) it.next()).get();
            if (intentCallback2 == null) {
                it.remove();
            } else if (intentCallback2 == intentCallback) {
                z = false;
            }
        }
        if (z) {
            this.callbacks.add(new WeakReference(intentCallback));
        }
    }

    @Override // androidx.test.runner.intent.IntentMonitor
    public void removeIntentCallback(@NonNull IntentCallback intentCallback) {
        if (intentCallback == null) {
            throw new NullPointerException("callback cannot be null!");
        }
        Iterator it = this.callbacks.iterator();
        while (it.hasNext()) {
            IntentCallback intentCallback2 = (IntentCallback) ((WeakReference) it.next()).get();
            if (intentCallback2 == null) {
                it.remove();
            } else if (intentCallback2 == intentCallback) {
                it.remove();
            }
        }
    }

    public void signalIntent(Intent intent) {
        Iterator it = this.callbacks.iterator();
        while (it.hasNext()) {
            IntentCallback intentCallback = (IntentCallback) ((WeakReference) it.next()).get();
            if (intentCallback == null) {
                it.remove();
            } else {
                try {
                    intentCallback.onIntentSent(new Intent(intent));
                } catch (RuntimeException e) {
                    Log.e("IntentMonitorImpl", String.format("Callback threw exception! (callback: %s intent: %s)", intentCallback, intent), e);
                }
            }
        }
    }
}
