package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0660e;
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

@SourceDebugExtension({"SMAP\nCustomErrorEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomErrorEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/CustomErrorEvent\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,54:1\n215#2,2:55\n*S KotlinDebug\n*F\n+ 1 CustomErrorEvent.kt\ncom/contentsquare/android/analytics/internal/model/data/CustomErrorEvent\n*L\n24#1:55,2\n*E\n"})
/* loaded from: classes2.dex */
public final class T0 extends AbstractC0660e {

    @Nullable
    public final String m;

    @Nullable
    public final String n;

    @Nullable
    public final Long o;

    @NotNull
    public final Map<String, String> p;

    public static final class a extends AbstractC0660e.a<T0> {

        @Nullable
        public String k;

        @Nullable
        public String l;

        @Nullable
        public Long m;

        @NotNull
        public Map<String, String> n;

        public a() {
            super(25);
            this.n = MapsKt.emptyMap();
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new T0(this);
        }
    }

    public static final class b extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
        public static final b a = new b();

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

    public T0(a aVar) {
        super(aVar);
        this.m = aVar.k;
        this.n = aVar.l;
        this.o = aVar.m;
        this.p = aVar.n;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.take(this.p.entrySet(), 10), ", ", null, null, 0, null, b.a, 30, null);
        Logger logger = AbstractC0660e.l;
        StringBuilder sb = new StringBuilder("Custom Error (from ");
        sb.append(this.n);
        sb.append(") : ");
        String str = this.m;
        sb.append(str != null ? StringsKt.take(str, 100) : null);
        sb.append(" - Attributes: [");
        sb.append(strJoinToString$default);
        sb.append(AbstractJsonLexerKt.END_LIST);
        logger.i(sb.toString());
    }
}
