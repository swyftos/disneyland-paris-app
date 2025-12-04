package androidx.test.internal.runner.lifecycle;

import android.app.Application;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitor;
import androidx.test.runner.lifecycle.ApplicationStage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ApplicationLifecycleMonitorImpl implements ApplicationLifecycleMonitor {
    private final List callbacks = new ArrayList();

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void addLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback) {
        Checks.checkNotNull(applicationLifecycleCallback);
        synchronized (this.callbacks) {
            try {
                Iterator it = this.callbacks.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    ApplicationLifecycleCallback applicationLifecycleCallback2 = (ApplicationLifecycleCallback) ((WeakReference) it.next()).get();
                    if (applicationLifecycleCallback2 == null) {
                        it.remove();
                    } else if (applicationLifecycleCallback2 == applicationLifecycleCallback) {
                        z = false;
                    }
                }
                if (z) {
                    this.callbacks.add(new WeakReference(applicationLifecycleCallback));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void removeLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback) {
        Checks.checkNotNull(applicationLifecycleCallback);
        synchronized (this.callbacks) {
            try {
                Iterator it = this.callbacks.iterator();
                while (it.hasNext()) {
                    ApplicationLifecycleCallback applicationLifecycleCallback2 = (ApplicationLifecycleCallback) ((WeakReference) it.next()).get();
                    if (applicationLifecycleCallback2 == null) {
                        it.remove();
                    } else if (applicationLifecycleCallback2 == applicationLifecycleCallback) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void signalLifecycleChange(Application application, ApplicationStage applicationStage) {
        synchronized (this.callbacks) {
            Iterator it = this.callbacks.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = (ApplicationLifecycleCallback) ((WeakReference) it.next()).get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else {
                    try {
                        String strValueOf = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                        sb.append("running callback: ");
                        sb.append(strValueOf);
                        Log.d("ApplicationLifecycleMonitorImpl", sb.toString());
                        applicationLifecycleCallback.onApplicationLifecycleChanged(application, applicationStage);
                        String strValueOf2 = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 20);
                        sb2.append("callback completes: ");
                        sb2.append(strValueOf2);
                        Log.d("ApplicationLifecycleMonitorImpl", sb2.toString());
                    } catch (RuntimeException e) {
                        Log.e("ApplicationLifecycleMonitorImpl", String.format("Callback threw exception! (callback: %s stage: %s)", applicationLifecycleCallback, applicationStage), e);
                    }
                }
            }
        }
    }
}
