package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCustomErrorEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomErrorEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/CustomErrorEvent\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,54:1\n215#2,2:55\n*S KotlinDebug\n*F\n+ 1 CustomErrorEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/CustomErrorEvent\n*L\n24#1:55,2\n*E\n"})
public final class C2626T0 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f2136m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final String f2137n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final Long f2138o;

    /* JADX INFO: renamed from: p */
    @NotNull
    public final Map<String, String> f2139p;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T0$a */
    public static final class a extends AbstractC2730e.a<C2626T0> {

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f2140k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public String f2141l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public Long f2142m;

        /* JADX INFO: renamed from: n */
        @NotNull
        public Map<String, String> f2143n;

        public a() {
            super(25);
            this.f2143n = MapsKt.emptyMap();
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2626T0(this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T0$b */
    public static final class b extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {

        /* JADX INFO: renamed from: a */
        public static final b f2144a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
            Map.Entry<? extends String, ? extends String> entry2 = entry;
            Intrinsics.checkNotNullParameter(entry2, "<name for destructuring parameter 0>");
            return entry2.getKey() + ':' + entry2.getValue();
        }
    }

    public C2626T0(a aVar) {
        super(aVar);
        this.f2136m = aVar.f2140k;
        this.f2137n = aVar.f2141l;
        this.f2138o = aVar.f2142m;
        this.f2139p = aVar.f2143n;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.take(this.f2139p.entrySet(), 10), ", ", null, null, 0, null, b.f2144a, 30, null);
        Logger logger = AbstractC2730e.f2545l;
        StringBuilder sb = new StringBuilder("Custom Error (from ");
        sb.append(this.f2137n);
        sb.append(") : ");
        String str = this.f2136m;
        sb.append(str != null ? StringsKt.take(str, 100) : null);
        sb.append(" - Attributes: [");
        sb.append(strJoinToString$default);
        sb.append(AbstractJsonLexerKt.END_LIST);
        logger.m831i(sb.toString());
    }
}
