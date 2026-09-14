package com.contentsquare.android.sdk;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.F5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2492F5 extends AbstractC2586P<b> {

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Lazy<C2492F5> f1615c = LazyKt.lazy(a.f1616a);

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.F5$a */
    public static final class a extends Lambda implements Function0<C2492F5> {

        /* JADX INFO: renamed from: a */
        public static final a f1616a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2492F5 invoke() {
            return new C2492F5();
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.F5$b */
    public enum b {
        /* JADX INFO: Fake field, exist only in values array */
        ANDROID_VIEW_TO_VIEW_LIGHT_PROCESS
    }
}
