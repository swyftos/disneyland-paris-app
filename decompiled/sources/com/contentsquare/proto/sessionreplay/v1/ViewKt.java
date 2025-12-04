package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.urbanairship.channel.AttributeMutation;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewKt {

    @NotNull
    public static final ViewKt INSTANCE = new ViewKt();

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 H2\u00020\u0001:\u0002GHB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00100\u001a\u00020\u0007H\u0001J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J%\u00109\u001a\u000202*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b:J+\u0010;\u001a\u000202*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070=H\u0007¢\u0006\u0002\b>J\u001d\u0010?\u001a\u000202*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b@J&\u0010A\u001a\u000202*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\bBJ,\u0010A\u001a\u000202*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070=H\u0087\n¢\u0006\u0002\bCJ.\u0010D\u001a\u000202*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010E\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\bFR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u001e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010*\u001a\u0004\u0018\u00010\u0018*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\u0004\u0018\u00010$*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006I"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View$Builder;)V", "children", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;", "Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl$ChildrenProxy;", "getChildren", "()Lcom/google/protobuf/kotlin/DslList;", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View$Format;", "format", "getFormat", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View$Format;", "setFormat", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View$Format;)V", "", "formatValue", "getFormatValue", "()I", "setFormatValue", "(I)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata;", "metadata", "getMetadata", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata;", "setMetadata", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata;)V", "", "recordingId", "getRecordingId", "()J", "setRecordingId", "(J)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "style", "getStyle", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "setStyle", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;)V", "metadataOrNull", "getMetadataOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata;", "styleOrNull", "getStyleOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "_build", "clearFormat", "", "clearMetadata", "clearRecordingId", "clearStyle", "hasMetadata", "", "hasStyle", "add", "addChildren", "addAll", "values", "", "addAllChildren", "clear", "clearChildren", "plusAssign", "plusAssignChildren", "plusAssignAllChildren", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setChildren", "ChildrenProxy", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.View.Builder _builder;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl$ChildrenProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ChildrenProxy extends DslProxy {
            private ChildrenProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.View.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.View.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.View _build() {
            SessionRecordingV1.View viewBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(viewBuild, "_builder.build()");
            return viewBuild;
        }

        @JvmName(name = "addAllChildren")
        public final /* synthetic */ void addAllChildren(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllChildren(values);
        }

        @JvmName(name = "addChildren")
        public final /* synthetic */ void addChildren(DslList dslList, SessionRecordingV1.View value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addChildren(value);
        }

        @JvmName(name = "clearChildren")
        public final /* synthetic */ void clearChildren(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearChildren();
        }

        public final void clearFormat() {
            this._builder.clearFormat();
        }

        public final void clearMetadata() {
            this._builder.clearMetadata();
        }

        public final void clearRecordingId() {
            this._builder.clearRecordingId();
        }

        public final void clearStyle() {
            this._builder.clearStyle();
        }

        public final /* synthetic */ DslList getChildren() {
            List<SessionRecordingV1.View> childrenList = this._builder.getChildrenList();
            Intrinsics.checkNotNullExpressionValue(childrenList, "_builder.getChildrenList()");
            return new DslList(childrenList);
        }

        @JvmName(name = "getFormat")
        @NotNull
        public final SessionRecordingV1.View.Format getFormat() {
            SessionRecordingV1.View.Format format = this._builder.getFormat();
            Intrinsics.checkNotNullExpressionValue(format, "_builder.getFormat()");
            return format;
        }

        @JvmName(name = "getFormatValue")
        public final int getFormatValue() {
            return this._builder.getFormatValue();
        }

        @JvmName(name = "getMetadata")
        @NotNull
        public final SessionRecordingV1.GraphMetadata getMetadata() {
            SessionRecordingV1.GraphMetadata metadata = this._builder.getMetadata();
            Intrinsics.checkNotNullExpressionValue(metadata, "_builder.getMetadata()");
            return metadata;
        }

        @Nullable
        public final SessionRecordingV1.GraphMetadata getMetadataOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ViewKtKt.getMetadataOrNull(dsl._builder);
        }

        @JvmName(name = "getRecordingId")
        public final long getRecordingId() {
            return this._builder.getRecordingId();
        }

        @JvmName(name = "getStyle")
        @NotNull
        public final SessionRecordingV1.ViewStyle getStyle() {
            SessionRecordingV1.ViewStyle style = this._builder.getStyle();
            Intrinsics.checkNotNullExpressionValue(style, "_builder.getStyle()");
            return style;
        }

        @Nullable
        public final SessionRecordingV1.ViewStyle getStyleOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ViewKtKt.getStyleOrNull(dsl._builder);
        }

        public final boolean hasMetadata() {
            return this._builder.hasMetadata();
        }

        public final boolean hasStyle() {
            return this._builder.hasStyle();
        }

        @JvmName(name = "plusAssignAllChildren")
        public final /* synthetic */ void plusAssignAllChildren(DslList<SessionRecordingV1.View, ChildrenProxy> dslList, Iterable<SessionRecordingV1.View> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllChildren(dslList, values);
        }

        @JvmName(name = "plusAssignChildren")
        public final /* synthetic */ void plusAssignChildren(DslList<SessionRecordingV1.View, ChildrenProxy> dslList, SessionRecordingV1.View value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addChildren(dslList, value);
        }

        @JvmName(name = "setChildren")
        public final /* synthetic */ void setChildren(DslList dslList, int i, SessionRecordingV1.View value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setChildren(i, value);
        }

        @JvmName(name = "setFormat")
        public final void setFormat(SessionRecordingV1.View.Format value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFormat(value);
        }

        @JvmName(name = "setFormatValue")
        public final void setFormatValue(int i) {
            this._builder.setFormatValue(i);
        }

        @JvmName(name = "setMetadata")
        public final void setMetadata(SessionRecordingV1.GraphMetadata value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMetadata(value);
        }

        @JvmName(name = "setRecordingId")
        public final void setRecordingId(long j) {
            this._builder.setRecordingId(j);
        }

        @JvmName(name = "setStyle")
        public final void setStyle(SessionRecordingV1.ViewStyle value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setStyle(value);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.View.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private ViewKt() {
    }
}
