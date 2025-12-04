package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.utils.Debouncer;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0650d<V extends View> implements InterfaceC0795r5 {

    @NotNull
    public final Debouncer a;
    public int b;
    public int c;
    public long d;

    @NotNull
    public final WeakReference<V> e;

    @Nullable
    public Function3<? super Integer, ? super Integer, ? super Long, Unit> f;

    public AbstractC0650d(@NotNull V view, @NotNull Debouncer debouncer) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(debouncer, "debouncer");
        this.a = debouncer;
        this.e = new WeakReference<>(view);
    }

    public abstract int a();

    @Nullable
    public final <T> T a(@NotNull Function1<? super V, ? extends T> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        V v = this.e.get();
        if (v != null) {
            return body.invoke(v);
        }
        return null;
    }

    public abstract int b();
}
