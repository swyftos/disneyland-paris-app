package androidx.test.runner.intent;

/* JADX INFO: loaded from: classes2.dex */
public interface IntentMonitor {
    void addIntentCallback(IntentCallback intentCallback);

    void removeIntentCallback(IntentCallback intentCallback);
}
