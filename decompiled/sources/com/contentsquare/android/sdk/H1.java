package com.contentsquare.android.sdk;

import androidx.annotation.AnyThread;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class H1 {

    @NotNull
    public final ArrayList a = new ArrayList();

    @AnyThread
    public final synchronized void a(@NotNull AbstractC0707i6 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.a.add(event);
    }

    @NotNull
    public final synchronized List<AbstractC0707i6> a() {
        List<AbstractC0707i6> list;
        list = CollectionsKt.toList(this.a);
        this.a.clear();
        return list;
    }
}
