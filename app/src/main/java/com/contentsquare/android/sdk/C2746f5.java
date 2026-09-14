package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.f5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2746f5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C2746f5 f2632a = new C2746f5();

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final ConcurrentLinkedQueue f2633b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c */
    @Nullable
    public static a f2634c;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.f5$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo1129a(@NotNull ConcurrentLinkedQueue concurrentLinkedQueue);
    }

    /* JADX INFO: renamed from: a */
    public static void m1128a(@NotNull C2706b5 screenView) {
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion == null || !companion.getPreferencesStore().getBoolean(PreferencesKey.TRACKING_ENABLE, false) || companion.getPreferencesStore().getBoolean(PreferencesKey.PAUSE_TRACKING, false)) {
            return;
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = f2633b;
        concurrentLinkedQueue.add(screenView);
        a aVar = f2634c;
        if (aVar != null) {
            aVar.mo1129a(concurrentLinkedQueue);
        }
    }
}
