package androidx.test.espresso.base;

/* loaded from: classes2.dex */
interface IdleNotifier<CB> {
    void cancelCallback();

    boolean isIdleNow();

    void registerNotificationCallback(Object obj);
}
