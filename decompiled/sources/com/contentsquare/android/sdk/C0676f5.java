package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.f5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0676f5 {

    @NotNull
    public static final C0676f5 a = new C0676f5();

    @NotNull
    public static final ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();

    @Nullable
    public static a c;

    /* renamed from: com.contentsquare.android.sdk.f5$a */
    public interface a {
        void a(@NotNull ConcurrentLinkedQueue concurrentLinkedQueue);
    }

    public static void a(@NotNull C0636b5 screenView) {
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion == null || !companion.getPreferencesStore().getBoolean(PreferencesKey.TRACKING_ENABLE, false) || companion.getPreferencesStore().getBoolean(PreferencesKey.PAUSE_TRACKING, false)) {
            return;
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = b;
        concurrentLinkedQueue.add(screenView);
        a aVar = c;
        if (aVar != null) {
            aVar.a(concurrentLinkedQueue);
        }
    }
}
