package com.contentsquare.android.sdk;

import android.app.Activity;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.C0646c5;
import com.contentsquare.android.sdk.C0676f5;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.h5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0696h5 implements C0676f5.a {

    @NotNull
    public final C0710j a;

    @NotNull
    public final M2 b;

    @NotNull
    public final PreferencesStore c;

    @NotNull
    public final C0686g5 d;

    @Nullable
    public C0646c5.a e;

    public C0696h5(@NotNull L3 pathGenerator, @NotNull C0710j analyticsPipeline, @NotNull E1 eventsBuildersFactory, @NotNull InterfaceC0832v2 glassPane, @NotNull M2 liveActivityProvider, @NotNull PreferencesStore preferencesStore) {
        C0676f5 screenViewEventsHandler = C0676f5.a;
        Intrinsics.checkNotNullParameter(pathGenerator, "pathGenerator");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(screenViewEventsHandler, "screenViewEventsHandler");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = analyticsPipeline;
        this.b = liveActivityProvider;
        this.c = preferencesStore;
        Logger logger = new Logger("ScreenView");
        C0676f5.c = this;
        this.d = new C0686g5(pathGenerator, glassPane, eventsBuildersFactory, this, logger);
    }

    @Override // com.contentsquare.android.sdk.C0676f5.a
    public final void a(@NotNull ConcurrentLinkedQueue queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        if (this.b.a.get() != null) {
            b(queue);
        }
    }

    public final void b(@NotNull ConcurrentLinkedQueue queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        Activity activity = this.b.a.get();
        if (activity == null) {
            return;
        }
        while (true) {
            C0636b5 c0636b5 = (C0636b5) queue.poll();
            if (c0636b5 == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(c0636b5, "queue.poll() ?: break");
            C0686g5 c0686g5 = this.d;
            String screenTitle = c0636b5.a;
            CustomVar[] customVars = c0636b5.b;
            boolean z = c0636b5.c;
            Long l = c0636b5.d;
            c0686g5.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(screenTitle, "screenTitle");
            Intrinsics.checkNotNullParameter(customVars, "customVars");
            c0686g5.a(activity, new C0670f(activity, screenTitle, c0686g5.a), new R2(activity, screenTitle, 2), screenTitle, customVars, z, l);
        }
    }
}
