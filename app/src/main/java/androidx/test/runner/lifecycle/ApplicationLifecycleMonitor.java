package androidx.test.runner.lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public interface ApplicationLifecycleMonitor {
    void addLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback);

    void removeLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback);
}
