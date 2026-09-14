package com.contentsquare.android.sdk;

import androidx.annotation.AnyThread;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.H1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2508H1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ArrayList f1661a = new ArrayList();

    @AnyThread
    /* JADX INFO: renamed from: a */
    public final synchronized void m930a(@NotNull AbstractC2777i6 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1661a.add(event);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final synchronized List<AbstractC2777i6> m929a() {
        List<AbstractC2777i6> list;
        list = CollectionsKt.toList(this.f1661a);
        this.f1661a.clear();
        return list;
    }
}
