package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nNetworkRequestMetricEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkRequestMetricEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/NetworkRequestMetricEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,65:1\n1855#2,2:66\n215#3,2:68\n*S KotlinDebug\n*F\n+ 1 NetworkRequestMetricEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/NetworkRequestMetricEvent\n*L\n26#1:66,2\n36#1:68,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.r3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0793r3 extends AbstractC0660e {

    @NotNull
    public final String m;

    @NotNull
    public final String n;
    public final long o;
    public final long p;
    public final int q;

    @Nullable
    public final String r;

    @Nullable
    public final List<String> s;

    @Nullable
    public final Map<String, String> t;

    /* renamed from: com.contentsquare.android.sdk.r3$a */
    public static final class a extends AbstractC0660e.a<C0793r3> {

        @Nullable
        public String k;

        @Nullable
        public String l;
        public long m;
        public long n;
        public int o;

        @Nullable
        public String p;

        @Nullable
        public List<String> q;

        @Nullable
        public Map<String, String> r;

        public a() {
            super(21);
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0793r3(this);
        }
    }

    public C0793r3(a aVar) {
        super(aVar);
        String str = aVar.k;
        this.m = str == null ? "" : str;
        String str2 = aVar.l;
        this.n = str2 != null ? str2 : "";
        this.o = aVar.m;
        this.p = aVar.n;
        this.q = aVar.o;
        this.r = aVar.p;
        this.s = aVar.q;
        this.t = aVar.r;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("API Error (from " + this.r + ") - " + this.n + ' ' + this.q + ' ' + this.m);
    }
}
