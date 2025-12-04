package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/InsertionMutationKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InsertionMutationKt {

    @NotNull
    public static final InsertionMutationKt INSTANCE = new InsertionMutationKt();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u0015*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/InsertionMutationKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation$Builder;)V", "value", "", "indexInParent", "getIndexInParent", "()I", "setIndexInParent", "(I)V", "", "parentViewId", "getParentViewId", "()J", "setParentViewId", "(J)V", "unixTimestampMs", "getUnixTimestampMs", "setUnixTimestampMs", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;", "view", "getView", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;", "setView", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;)V", "viewOrNull", "getViewOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/InsertionMutationKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation;", "clearIndexInParent", "", "clearParentViewId", "clearUnixTimestampMs", "clearView", "hasIndexInParent", "", "hasParentViewId", "hasView", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.InsertionMutation.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/InsertionMutationKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/InsertionMutationKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.InsertionMutation.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.InsertionMutation.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.InsertionMutation _build() {
            SessionRecordingV1.InsertionMutation insertionMutationBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(insertionMutationBuild, "_builder.build()");
            return insertionMutationBuild;
        }

        public final void clearIndexInParent() {
            this._builder.clearIndexInParent();
        }

        public final void clearParentViewId() {
            this._builder.clearParentViewId();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        public final void clearView() {
            this._builder.clearView();
        }

        @JvmName(name = "getIndexInParent")
        public final int getIndexInParent() {
            return this._builder.getIndexInParent();
        }

        @JvmName(name = "getParentViewId")
        public final long getParentViewId() {
            return this._builder.getParentViewId();
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        @JvmName(name = "getView")
        @NotNull
        public final SessionRecordingV1.View getView() {
            SessionRecordingV1.View view = this._builder.getView();
            Intrinsics.checkNotNullExpressionValue(view, "_builder.getView()");
            return view;
        }

        @Nullable
        public final SessionRecordingV1.View getViewOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return InsertionMutationKtKt.getViewOrNull(dsl._builder);
        }

        public final boolean hasIndexInParent() {
            return this._builder.hasIndexInParent();
        }

        public final boolean hasParentViewId() {
            return this._builder.hasParentViewId();
        }

        public final boolean hasView() {
            return this._builder.hasView();
        }

        @JvmName(name = "setIndexInParent")
        public final void setIndexInParent(int i) {
            this._builder.setIndexInParent(i);
        }

        @JvmName(name = "setParentViewId")
        public final void setParentViewId(long j) {
            this._builder.setParentViewId(j);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        @JvmName(name = "setView")
        public final void setView(SessionRecordingV1.View value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setView(value);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.InsertionMutation.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private InsertionMutationKt() {
    }
}
