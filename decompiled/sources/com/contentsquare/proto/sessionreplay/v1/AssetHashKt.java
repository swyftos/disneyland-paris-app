package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/AssetHashKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AssetHashKt {

    @NotNull
    public static final AssetHashKt INSTANCE = new AssetHashKt();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/AssetHashKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHash$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHash$Builder;)V", "value", "", "assetId", "getAssetId", "()Ljava/lang/String;", "setAssetId", "(Ljava/lang/String;)V", "hash", "getHash", "setHash", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHash;", "clearAssetId", "", "clearHash", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.AssetHash.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/AssetHashKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/AssetHashKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHash$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.AssetHash.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.AssetHash.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.AssetHash _build() {
            SessionRecordingV1.AssetHash assetHashBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(assetHashBuild, "_builder.build()");
            return assetHashBuild;
        }

        public final void clearAssetId() {
            this._builder.clearAssetId();
        }

        public final void clearHash() {
            this._builder.clearHash();
        }

        @JvmName(name = "getAssetId")
        @NotNull
        public final String getAssetId() {
            String assetId = this._builder.getAssetId();
            Intrinsics.checkNotNullExpressionValue(assetId, "_builder.getAssetId()");
            return assetId;
        }

        @JvmName(name = "getHash")
        @NotNull
        public final String getHash() {
            String hash = this._builder.getHash();
            Intrinsics.checkNotNullExpressionValue(hash, "_builder.getHash()");
            return hash;
        }

        @JvmName(name = "setAssetId")
        public final void setAssetId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAssetId(value);
        }

        @JvmName(name = "setHash")
        public final void setHash(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setHash(value);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.AssetHash.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private AssetHashKt() {
    }
}
