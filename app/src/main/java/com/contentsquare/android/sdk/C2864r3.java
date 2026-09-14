package com.contentsquare.android.sdk;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.r3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nNetworkRequestMetricEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkRequestMetricEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/NetworkRequestMetricEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,65:1\n1855#2,2:66\n215#3,2:68\n*S KotlinDebug\n*F\n+ 1 NetworkRequestMetricEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/NetworkRequestMetricEvent\n*L\n26#1:66,2\n36#1:68,2\n*E\n"})
public final class C2864r3 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final String f3059m;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final String f3060n;

    /* JADX INFO: renamed from: o */
    public final long f3061o;

    /* JADX INFO: renamed from: p */
    public final long f3062p;

    /* JADX INFO: renamed from: q */
    public final int f3063q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public final String f3064r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public final List<String> f3065s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public final Map<String, String> f3066t;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.r3$a */
    public static final class a extends AbstractC2730e.a<C2864r3> {

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f3067k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public String f3068l;

        /* JADX INFO: renamed from: m */
        public long f3069m;

        /* JADX INFO: renamed from: n */
        public long f3070n;

        /* JADX INFO: renamed from: o */
        public int f3071o;

        /* JADX INFO: renamed from: p */
        @Nullable
        public String f3072p;

        /* JADX INFO: renamed from: q */
        @Nullable
        public List<String> f3073q;

        /* JADX INFO: renamed from: r */
        @Nullable
        public Map<String, String> f3074r;

        public a() {
            super(21);
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2864r3(this);
        }
    }

    public C2864r3(a aVar) {
        super(aVar);
        String str = aVar.f3067k;
        this.f3059m = str == null ? "" : str;
        String str2 = aVar.f3068l;
        this.f3060n = str2 != null ? str2 : "";
        this.f3061o = aVar.f3069m;
        this.f3062p = aVar.f3070n;
        this.f3063q = aVar.f3071o;
        this.f3064r = aVar.f3072p;
        this.f3065s = aVar.f3073q;
        this.f3066t = aVar.f3074r;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        AbstractC2730e.f2545l.m831i("API Error (from " + this.f3064r + ") - " + this.f3060n + ' ' + this.f3063q + ' ' + this.f3059m);
    }
}
