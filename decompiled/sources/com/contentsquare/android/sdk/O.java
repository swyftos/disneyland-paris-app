package com.contentsquare.android.sdk;

import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class O implements Function1<ViewGroup, String> {
    public final boolean a;

    @Nullable
    public final String b;

    @NotNull
    public final Function1<ViewGroup, String> c;

    public O(boolean z, @Nullable String str, @NotNull C0670f wrappedProducer) {
        Intrinsics.checkNotNullParameter(wrappedProducer, "wrappedProducer");
        this.a = z;
        this.b = str;
        this.c = wrappedProducer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(ViewGroup viewGroup) {
        String strInvoke = this.c.invoke(viewGroup);
        boolean z = this.a;
        String str = this.b;
        if (z) {
            return str == null ? strInvoke : str;
        }
        if (Intrinsics.areEqual(strInvoke, str)) {
            return null;
        }
        return strInvoke;
    }
}
