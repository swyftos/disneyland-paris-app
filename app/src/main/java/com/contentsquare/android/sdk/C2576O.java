package com.contentsquare.android.sdk;

import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.O */
/* JADX INFO: loaded from: classes2.dex */
public final class C2576O implements Function1<ViewGroup, String> {

    /* JADX INFO: renamed from: a */
    public final boolean f1907a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f1908b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Function1<ViewGroup, String> f1909c;

    public C2576O(boolean z, @Nullable String str, @NotNull C2740f wrappedProducer) {
        Intrinsics.checkNotNullParameter(wrappedProducer, "wrappedProducer");
        this.f1907a = z;
        this.f1908b = str;
        this.f1909c = wrappedProducer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(ViewGroup viewGroup) {
        String strInvoke = this.f1909c.invoke(viewGroup);
        boolean z = this.f1907a;
        String str = this.f1908b;
        if (z) {
            return str == null ? strInvoke : str;
        }
        if (Intrinsics.areEqual(strInvoke, str)) {
            return null;
        }
        return strInvoke;
    }
}
