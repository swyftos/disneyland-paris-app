package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.OnlineAssetsKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nWebViewEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/WebViewOnlineAssetsEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 OnlineAssetsKt.kt\ncom/contentsquare/proto/sessionreplay/v1/OnlineAssetsKtKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n11#2:72\n1#3:73\n1#3:75\n11#4:74\n1855#5,2:76\n*S KotlinDebug\n*F\n+ 1 WebViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/WebViewOnlineAssetsEvent\n*L\n24#1:72\n24#1:73\n25#1:75\n25#1:74\n26#1:76,2\n*E\n"})
/* loaded from: classes2.dex */
public final class M8 extends E8 {

    @NotNull
    public final List<String> a;

    public M8(@NotNull ArrayList urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        this.a = urls;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof M8) && Intrinsics.areEqual(this.a, ((M8) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode() + 31;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        OnlineAssetsKt.Dsl.Companion companion = OnlineAssetsKt.Dsl.INSTANCE;
        SessionRecordingV1.OnlineAssets.Builder builderNewBuilder = SessionRecordingV1.OnlineAssets.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        OnlineAssetsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            dsl_create.addUrls(dsl_create.getUrls(), (String) it.next());
        }
        dslA.setOnlineAssets(dsl_create._build());
        return dslA._build();
    }
}
