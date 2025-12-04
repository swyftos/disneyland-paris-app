package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GraphMetadataKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GraphMetadataKt {

    @NotNull
    public static final GraphMetadataKt INSTANCE = new GraphMetadataKt();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GraphMetadataKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata$Builder;)V", "value", "", "className", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "incrementalPath", "getIncrementalPath", "setIncrementalPath", "reliablePath", "getReliablePath", "setReliablePath", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata;", "clearClassName", "", "clearIncrementalPath", "clearReliablePath", "hasReliablePath", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.GraphMetadata.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GraphMetadataKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/GraphMetadataKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.GraphMetadata.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.GraphMetadata.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.GraphMetadata _build() {
            SessionRecordingV1.GraphMetadata graphMetadataBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(graphMetadataBuild, "_builder.build()");
            return graphMetadataBuild;
        }

        public final void clearClassName() {
            this._builder.clearClassName();
        }

        public final void clearIncrementalPath() {
            this._builder.clearIncrementalPath();
        }

        public final void clearReliablePath() {
            this._builder.clearReliablePath();
        }

        @JvmName(name = "getClassName")
        @NotNull
        public final String getClassName() {
            String className = this._builder.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "_builder.getClassName()");
            return className;
        }

        @JvmName(name = "getIncrementalPath")
        @NotNull
        public final String getIncrementalPath() {
            String incrementalPath = this._builder.getIncrementalPath();
            Intrinsics.checkNotNullExpressionValue(incrementalPath, "_builder.getIncrementalPath()");
            return incrementalPath;
        }

        @JvmName(name = "getReliablePath")
        @NotNull
        public final String getReliablePath() {
            String reliablePath = this._builder.getReliablePath();
            Intrinsics.checkNotNullExpressionValue(reliablePath, "_builder.getReliablePath()");
            return reliablePath;
        }

        public final boolean hasReliablePath() {
            return this._builder.hasReliablePath();
        }

        @JvmName(name = "setClassName")
        public final void setClassName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setClassName(value);
        }

        @JvmName(name = "setIncrementalPath")
        public final void setIncrementalPath(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setIncrementalPath(value);
        }

        @JvmName(name = "setReliablePath")
        public final void setReliablePath(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReliablePath(value);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.GraphMetadata.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private GraphMetadataKt() {
    }
}
