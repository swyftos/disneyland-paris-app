package com.contentsquare.android.sdk;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class F5 extends P<b> {

    @NotNull
    public static final Lazy<F5> c = LazyKt.lazy(a.a);

    public static final class a extends Lambda implements Function0<F5> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final F5 invoke() {
            return new F5();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final /* synthetic */ b[] a = {new b()};

        /* JADX INFO: Fake field, exist only in values array */
        b EF2;

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) a.clone();
        }
    }
}
