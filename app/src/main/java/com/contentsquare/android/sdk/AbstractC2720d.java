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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.d */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2720d<V extends View> implements InterfaceC2866r5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Debouncer f2480a;

    /* JADX INFO: renamed from: b */
    public int f2481b;

    /* JADX INFO: renamed from: c */
    public int f2482c;

    /* JADX INFO: renamed from: d */
    public long f2483d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final WeakReference<V> f2484e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public Function3<? super Integer, ? super Integer, ? super Long, Unit> f2485f;

    public AbstractC2720d(@NotNull V view, @NotNull Debouncer debouncer) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(debouncer, "debouncer");
        this.f2480a = debouncer;
        this.f2484e = new WeakReference<>(view);
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo879a();

    @Nullable
    /* JADX INFO: renamed from: a */
    public final <T> T m1113a(@NotNull Function1<? super V, ? extends T> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        V v = this.f2484e.get();
        if (v != null) {
            return body.invoke(v);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public abstract int mo880b();
}
