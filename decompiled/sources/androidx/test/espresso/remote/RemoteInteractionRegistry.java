package androidx.test.espresso.remote;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class RemoteInteractionRegistry {
    private static final AtomicReference sInstance = new AtomicReference(new NoopRemoteInteraction());

    public static RemoteInteraction getInstance() {
        return (RemoteInteraction) sInstance.get();
    }

    public static void registerInstance(RemoteInteraction remoteInteraction) {
        if (remoteInteraction == null) {
            sInstance.set(new NoopRemoteInteraction());
        } else {
            sInstance.set(remoteInteraction);
        }
    }
}
