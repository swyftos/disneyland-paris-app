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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TouchGestureKt {

    @NotNull
    public static final TouchGestureKt INSTANCE = new TouchGestureKt();

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0018\b\u0007\u0018\u0000 02\u00020\u0001:\u00040123B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J%\u0010\u0014\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0007¢\u0006\u0002\b\u0017J%\u0010\u0014\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0007¢\u0006\u0002\b\u0018J%\u0010\u0014\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0016\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0019J+\u0010\u001a\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0007¢\u0006\u0002\b\u001dJ+\u0010\u001a\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0007¢\u0006\u0002\b\u001eJ+\u0010\u001a\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0007¢\u0006\u0002\b\u001fJ\u001d\u0010 \u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006H\u0007¢\u0006\u0002\b!J\u001d\u0010 \u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u0006H\u0007¢\u0006\u0002\b\"J\u001d\u0010 \u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b#J&\u0010$\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0087\n¢\u0006\u0002\b%J,\u0010$\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0087\n¢\u0006\u0002\b&J&\u0010$\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0087\n¢\u0006\u0002\b'J,\u0010$\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0087\n¢\u0006\u0002\b(J&\u0010$\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0016\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b)J,\u0010$\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0087\n¢\u0006\u0002\b*J.\u0010+\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b-J.\u0010+\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b.J.\u0010+\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n¨\u00064"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture$Builder;)V", "unixTimestampsMs", "Lcom/google/protobuf/kotlin/DslList;", "", "Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl$UnixTimestampsMsProxy;", "getUnixTimestampsMs", "()Lcom/google/protobuf/kotlin/DslList;", "xPositions", "", "Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl$XPositionsProxy;", "getXPositions", "yPositions", "Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl$YPositionsProxy;", "getYPositions", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture;", "add", "", "value", "addXPositions", "addYPositions", "addUnixTimestampsMs", "addAll", "values", "", "addAllXPositions", "addAllYPositions", "addAllUnixTimestampsMs", "clear", "clearXPositions", "clearYPositions", "clearUnixTimestampsMs", "plusAssign", "plusAssignXPositions", "plusAssignAllXPositions", "plusAssignYPositions", "plusAssignAllYPositions", "plusAssignUnixTimestampsMs", "plusAssignAllUnixTimestampsMs", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setXPositions", "setYPositions", "setUnixTimestampsMs", "Companion", "UnixTimestampsMsProxy", "XPositionsProxy", "YPositionsProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.TouchGesture.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.TouchGesture.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl$UnixTimestampsMsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class UnixTimestampsMsProxy extends DslProxy {
            private UnixTimestampsMsProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl$XPositionsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class XPositionsProxy extends DslProxy {
            private XPositionsProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/TouchGestureKt$Dsl$YPositionsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class YPositionsProxy extends DslProxy {
            private YPositionsProxy() {
            }
        }

        private Dsl(SessionRecordingV1.TouchGesture.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.TouchGesture _build() {
            SessionRecordingV1.TouchGesture touchGestureBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(touchGestureBuild, "_builder.build()");
            return touchGestureBuild;
        }

        @JvmName(name = "addAllUnixTimestampsMs")
        public final /* synthetic */ void addAllUnixTimestampsMs(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllUnixTimestampsMs(values);
        }

        @JvmName(name = "addAllXPositions")
        public final /* synthetic */ void addAllXPositions(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllXPositions(values);
        }

        @JvmName(name = "addAllYPositions")
        public final /* synthetic */ void addAllYPositions(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllYPositions(values);
        }

        @JvmName(name = "addUnixTimestampsMs")
        public final /* synthetic */ void addUnixTimestampsMs(DslList dslList, long j) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.addUnixTimestampsMs(j);
        }

        @JvmName(name = "addXPositions")
        public final /* synthetic */ void addXPositions(DslList dslList, int i) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.addXPositions(i);
        }

        @JvmName(name = "addYPositions")
        public final /* synthetic */ void addYPositions(DslList dslList, int i) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.addYPositions(i);
        }

        @JvmName(name = "clearUnixTimestampsMs")
        public final /* synthetic */ void clearUnixTimestampsMs(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearUnixTimestampsMs();
        }

        @JvmName(name = "clearXPositions")
        public final /* synthetic */ void clearXPositions(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearXPositions();
        }

        @JvmName(name = "clearYPositions")
        public final /* synthetic */ void clearYPositions(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearYPositions();
        }

        public final /* synthetic */ DslList getUnixTimestampsMs() {
            List<Long> unixTimestampsMsList = this._builder.getUnixTimestampsMsList();
            Intrinsics.checkNotNullExpressionValue(unixTimestampsMsList, "_builder.getUnixTimestampsMsList()");
            return new DslList(unixTimestampsMsList);
        }

        public final /* synthetic */ DslList getXPositions() {
            List<Integer> xPositionsList = this._builder.getXPositionsList();
            Intrinsics.checkNotNullExpressionValue(xPositionsList, "_builder.getXPositionsList()");
            return new DslList(xPositionsList);
        }

        public final /* synthetic */ DslList getYPositions() {
            List<Integer> yPositionsList = this._builder.getYPositionsList();
            Intrinsics.checkNotNullExpressionValue(yPositionsList, "_builder.getYPositionsList()");
            return new DslList(yPositionsList);
        }

        @JvmName(name = "plusAssignAllUnixTimestampsMs")
        public final /* synthetic */ void plusAssignAllUnixTimestampsMs(DslList<Long, UnixTimestampsMsProxy> dslList, Iterable<Long> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllUnixTimestampsMs(dslList, values);
        }

        @JvmName(name = "plusAssignAllXPositions")
        public final /* synthetic */ void plusAssignAllXPositions(DslList<Integer, XPositionsProxy> dslList, Iterable<Integer> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllXPositions(dslList, values);
        }

        @JvmName(name = "plusAssignAllYPositions")
        public final /* synthetic */ void plusAssignAllYPositions(DslList<Integer, YPositionsProxy> dslList, Iterable<Integer> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllYPositions(dslList, values);
        }

        @JvmName(name = "plusAssignUnixTimestampsMs")
        public final /* synthetic */ void plusAssignUnixTimestampsMs(DslList<Long, UnixTimestampsMsProxy> dslList, long j) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            addUnixTimestampsMs(dslList, j);
        }

        @JvmName(name = "plusAssignXPositions")
        public final /* synthetic */ void plusAssignXPositions(DslList<Integer, XPositionsProxy> dslList, int i) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            addXPositions(dslList, i);
        }

        @JvmName(name = "plusAssignYPositions")
        public final /* synthetic */ void plusAssignYPositions(DslList<Integer, YPositionsProxy> dslList, int i) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            addYPositions(dslList, i);
        }

        @JvmName(name = "setUnixTimestampsMs")
        public final /* synthetic */ void setUnixTimestampsMs(DslList dslList, int i, long j) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.setUnixTimestampsMs(i, j);
        }

        @JvmName(name = "setXPositions")
        public final /* synthetic */ void setXPositions(DslList dslList, int i, int i2) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.setXPositions(i, i2);
        }

        @JvmName(name = "setYPositions")
        public final /* synthetic */ void setYPositions(DslList dslList, int i, int i2) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.setYPositions(i, i2);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.TouchGesture.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private TouchGestureKt() {
    }
}
