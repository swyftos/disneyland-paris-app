package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
import com.contentsquare.proto.sessionreplay.v1.AssetHashKt;
import com.contentsquare.proto.sessionreplay.v1.AssetHashesKt;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.DslList;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nAssetHashesSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssetHashesSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/AssetHashesSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AssetHashesKt.kt\ncom/contentsquare/proto/sessionreplay/v1/AssetHashesKtKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 AssetHashKt.kt\ncom/contentsquare/proto/sessionreplay/v1/AssetHashKtKt\n*L\n1#1,36:1\n11#2:37\n1#3:38\n1#3:40\n1#3:45\n11#4:39\n1549#5:41\n1620#5,2:42\n1622#5:46\n11#6:44\n*S KotlinDebug\n*F\n+ 1 AssetHashesSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/AssetHashesSrEvent\n*L\n23#1:37\n23#1:38\n24#1:40\n27#1:45\n24#1:39\n26#1:41\n26#1:42,2\n26#1:46\n27#1:44\n*E\n"})
/* loaded from: classes2.dex */
public final class L extends AbstractC0707i6 {

    @NotNull
    public final List<WebViewAsset> a;

    public L(@NotNull ArrayList assets) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.a = assets;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        AssetHashesKt.Dsl.Companion companion = AssetHashesKt.Dsl.INSTANCE;
        SessionRecordingV1.AssetHashes.Builder builderNewBuilder = SessionRecordingV1.AssetHashes.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        AssetHashesKt.Dsl dsl_create = companion._create(builderNewBuilder);
        DslList assetHashes = dsl_create.getAssetHashes();
        List<WebViewAsset> list = this.a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (WebViewAsset webViewAsset : list) {
            AssetHashKt.Dsl.Companion companion2 = AssetHashKt.Dsl.INSTANCE;
            SessionRecordingV1.AssetHash.Builder builderNewBuilder2 = SessionRecordingV1.AssetHash.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
            AssetHashKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
            dsl_create2.setAssetId(webViewAsset.a);
            String str = webViewAsset.e;
            Intrinsics.checkNotNull(str);
            dsl_create2.setHash(str);
            arrayList.add(dsl_create2._build());
        }
        dsl_create.addAllAssetHashes(assetHashes, arrayList);
        dslA.setAssetHashes(dsl_create._build());
        return dslA._build();
    }
}
