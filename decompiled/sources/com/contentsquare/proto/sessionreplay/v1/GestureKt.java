package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012J*\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt;", "", "()V", "drag", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$DragKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializedrag", "flick", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$FlickKt$Dsl;", "-initializeflick", "longPress", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$LongPressKt$Dsl;", "-initializelongPress", "tap", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$TapKt$Dsl;", "-initializetap", "DragKt", "Dsl", "FlickKt", "LongPressKt", "TapKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGestureKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GestureKt.kt\ncom/contentsquare/proto/sessionreplay/v1/GestureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,370:1\n1#2:371\n*E\n"})
/* loaded from: classes3.dex */
public final class GestureKt {

    @NotNull
    public static final GestureKt INSTANCE = new GestureKt();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$DragKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DragKt {

        @NotNull
        public static final DragKt INSTANCE = new DragKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$DragKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Direction;", "direction", "getDirection", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Direction;", "setDirection", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Direction;)V", "", "directionValue", "getDirectionValue", "()I", "setDirectionValue", "(I)V", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag;", "clearDirection", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final SessionRecordingV1.Gesture.Drag.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$DragKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$DragKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(SessionRecordingV1.Gesture.Drag.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(SessionRecordingV1.Gesture.Drag.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ SessionRecordingV1.Gesture.Drag _build() {
                SessionRecordingV1.Gesture.Drag dragBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(dragBuild, "_builder.build()");
                return dragBuild;
            }

            public final void clearDirection() {
                this._builder.clearDirection();
            }

            @JvmName(name = "getDirection")
            @NotNull
            public final SessionRecordingV1.Gesture.Direction getDirection() {
                SessionRecordingV1.Gesture.Direction direction = this._builder.getDirection();
                Intrinsics.checkNotNullExpressionValue(direction, "_builder.getDirection()");
                return direction;
            }

            @JvmName(name = "getDirectionValue")
            public final int getDirectionValue() {
                return this._builder.getDirectionValue();
            }

            @JvmName(name = "setDirection")
            public final void setDirection(SessionRecordingV1.Gesture.Direction value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setDirection(value);
            }

            @JvmName(name = "setDirectionValue")
            public final void setDirectionValue(int i) {
                this._builder.setDirectionValue(i);
            }

            public /* synthetic */ Dsl(SessionRecordingV1.Gesture.Drag.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private DragKt() {
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010+\u001a\u00020,H\u0001J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020.J\u0006\u00100\u001a\u00020.J\u0006\u00101\u001a\u00020.J\u0006\u00102\u001a\u00020.J\u0006\u00103\u001a\u00020.J\u0006\u00104\u001a\u00020.J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\u0006\u00108\u001a\u000206J\u0006\u00109\u001a\u000206R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001c8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\"8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\"8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'¨\u0006;"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag;", "drag", "getDrag", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag;", "setDrag", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick;", "flick", "getFlick", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick;", "setFlick", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick;)V", "gestureCase", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$GestureCase;", "getGestureCase", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$GestureCase;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress;", "longPress", "getLongPress", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress;", "setLongPress", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap;", "tap", "getTap", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap;", "setTap", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap;)V", "", "unixTimestampMs", "getUnixTimestampMs", "()J", "setUnixTimestampMs", "(J)V", "viewId", "getViewId", "setViewId", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture;", "clearDrag", "", "clearFlick", "clearGesture", "clearLongPress", "clearTap", "clearUnixTimestampMs", "clearViewId", "hasDrag", "", "hasFlick", "hasLongPress", "hasTap", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.Gesture.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.Gesture.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.Gesture.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.Gesture _build() {
            SessionRecordingV1.Gesture gestureBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(gestureBuild, "_builder.build()");
            return gestureBuild;
        }

        public final void clearDrag() {
            this._builder.clearDrag();
        }

        public final void clearFlick() {
            this._builder.clearFlick();
        }

        public final void clearGesture() {
            this._builder.clearGesture();
        }

        public final void clearLongPress() {
            this._builder.clearLongPress();
        }

        public final void clearTap() {
            this._builder.clearTap();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        public final void clearViewId() {
            this._builder.clearViewId();
        }

        @JvmName(name = "getDrag")
        @NotNull
        public final SessionRecordingV1.Gesture.Drag getDrag() {
            SessionRecordingV1.Gesture.Drag drag = this._builder.getDrag();
            Intrinsics.checkNotNullExpressionValue(drag, "_builder.getDrag()");
            return drag;
        }

        @JvmName(name = "getFlick")
        @NotNull
        public final SessionRecordingV1.Gesture.Flick getFlick() {
            SessionRecordingV1.Gesture.Flick flick = this._builder.getFlick();
            Intrinsics.checkNotNullExpressionValue(flick, "_builder.getFlick()");
            return flick;
        }

        @JvmName(name = "getGestureCase")
        @NotNull
        public final SessionRecordingV1.Gesture.GestureCase getGestureCase() {
            SessionRecordingV1.Gesture.GestureCase gestureCase = this._builder.getGestureCase();
            Intrinsics.checkNotNullExpressionValue(gestureCase, "_builder.getGestureCase()");
            return gestureCase;
        }

        @JvmName(name = "getLongPress")
        @NotNull
        public final SessionRecordingV1.Gesture.LongPress getLongPress() {
            SessionRecordingV1.Gesture.LongPress longPress = this._builder.getLongPress();
            Intrinsics.checkNotNullExpressionValue(longPress, "_builder.getLongPress()");
            return longPress;
        }

        @JvmName(name = "getTap")
        @NotNull
        public final SessionRecordingV1.Gesture.Tap getTap() {
            SessionRecordingV1.Gesture.Tap tap = this._builder.getTap();
            Intrinsics.checkNotNullExpressionValue(tap, "_builder.getTap()");
            return tap;
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        @JvmName(name = "getViewId")
        public final long getViewId() {
            return this._builder.getViewId();
        }

        public final boolean hasDrag() {
            return this._builder.hasDrag();
        }

        public final boolean hasFlick() {
            return this._builder.hasFlick();
        }

        public final boolean hasLongPress() {
            return this._builder.hasLongPress();
        }

        public final boolean hasTap() {
            return this._builder.hasTap();
        }

        @JvmName(name = "setDrag")
        public final void setDrag(SessionRecordingV1.Gesture.Drag value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDrag(value);
        }

        @JvmName(name = "setFlick")
        public final void setFlick(SessionRecordingV1.Gesture.Flick value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFlick(value);
        }

        @JvmName(name = "setLongPress")
        public final void setLongPress(SessionRecordingV1.Gesture.LongPress value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setLongPress(value);
        }

        @JvmName(name = "setTap")
        public final void setTap(SessionRecordingV1.Gesture.Tap value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTap(value);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        @JvmName(name = "setViewId")
        public final void setViewId(long j) {
            this._builder.setViewId(j);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.Gesture.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$FlickKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FlickKt {

        @NotNull
        public static final FlickKt INSTANCE = new FlickKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$FlickKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Direction;", "direction", "getDirection", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Direction;", "setDirection", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Direction;)V", "", "directionValue", "getDirectionValue", "()I", "setDirectionValue", "(I)V", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick;", "clearDirection", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final SessionRecordingV1.Gesture.Flick.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$FlickKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$FlickKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(SessionRecordingV1.Gesture.Flick.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(SessionRecordingV1.Gesture.Flick.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ SessionRecordingV1.Gesture.Flick _build() {
                SessionRecordingV1.Gesture.Flick flickBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(flickBuild, "_builder.build()");
                return flickBuild;
            }

            public final void clearDirection() {
                this._builder.clearDirection();
            }

            @JvmName(name = "getDirection")
            @NotNull
            public final SessionRecordingV1.Gesture.Direction getDirection() {
                SessionRecordingV1.Gesture.Direction direction = this._builder.getDirection();
                Intrinsics.checkNotNullExpressionValue(direction, "_builder.getDirection()");
                return direction;
            }

            @JvmName(name = "getDirectionValue")
            public final int getDirectionValue() {
                return this._builder.getDirectionValue();
            }

            @JvmName(name = "setDirection")
            public final void setDirection(SessionRecordingV1.Gesture.Direction value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setDirection(value);
            }

            @JvmName(name = "setDirectionValue")
            public final void setDirectionValue(int i) {
                this._builder.setDirectionValue(i);
            }

            public /* synthetic */ Dsl(SessionRecordingV1.Gesture.Flick.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private FlickKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$LongPressKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LongPressKt {

        @NotNull
        public static final LongPressKt INSTANCE = new LongPressKt();

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$LongPressKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress$Builder;)V", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress;", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final SessionRecordingV1.Gesture.LongPress.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$LongPressKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$LongPressKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(SessionRecordingV1.Gesture.LongPress.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(SessionRecordingV1.Gesture.LongPress.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ SessionRecordingV1.Gesture.LongPress _build() {
                SessionRecordingV1.Gesture.LongPress longPressBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(longPressBuild, "_builder.build()");
                return longPressBuild;
            }

            public /* synthetic */ Dsl(SessionRecordingV1.Gesture.LongPress.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private LongPressKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$TapKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TapKt {

        @NotNull
        public static final TapKt INSTANCE = new TapKt();

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$TapKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap$Builder;)V", "value", "", "x", "getX", "()I", "setX", "(I)V", "y", "getY", "setY", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap;", "clearX", "", "clearY", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final SessionRecordingV1.Gesture.Tap.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$TapKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$TapKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(SessionRecordingV1.Gesture.Tap.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(SessionRecordingV1.Gesture.Tap.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ SessionRecordingV1.Gesture.Tap _build() {
                SessionRecordingV1.Gesture.Tap tapBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(tapBuild, "_builder.build()");
                return tapBuild;
            }

            public final void clearX() {
                this._builder.clearX();
            }

            public final void clearY() {
                this._builder.clearY();
            }

            @JvmName(name = "getX")
            public final int getX() {
                return this._builder.getX();
            }

            @JvmName(name = "getY")
            public final int getY() {
                return this._builder.getY();
            }

            @JvmName(name = "setX")
            public final void setX(int i) {
                this._builder.setX(i);
            }

            @JvmName(name = "setY")
            public final void setY(int i) {
                this._builder.setY(i);
            }

            public /* synthetic */ Dsl(SessionRecordingV1.Gesture.Tap.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private TapKt() {
        }
    }

    private GestureKt() {
    }

    @JvmName(name = "-initializedrag")
    @NotNull
    /* renamed from: -initializedrag, reason: not valid java name */
    public final SessionRecordingV1.Gesture.Drag m1288initializedrag(Function1<? super DragKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DragKt.Dsl.Companion companion = DragKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Drag.Builder builderNewBuilder = SessionRecordingV1.Gesture.Drag.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        DragKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeflick")
    @NotNull
    /* renamed from: -initializeflick, reason: not valid java name */
    public final SessionRecordingV1.Gesture.Flick m1289initializeflick(Function1<? super FlickKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FlickKt.Dsl.Companion companion = FlickKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Flick.Builder builderNewBuilder = SessionRecordingV1.Gesture.Flick.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FlickKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializelongPress")
    @NotNull
    /* renamed from: -initializelongPress, reason: not valid java name */
    public final SessionRecordingV1.Gesture.LongPress m1290initializelongPress(Function1<? super LongPressKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        LongPressKt.Dsl.Companion companion = LongPressKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.LongPress.Builder builderNewBuilder = SessionRecordingV1.Gesture.LongPress.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        LongPressKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializetap")
    @NotNull
    /* renamed from: -initializetap, reason: not valid java name */
    public final SessionRecordingV1.Gesture.Tap m1291initializetap(Function1<? super TapKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TapKt.Dsl.Companion companion = TapKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Tap.Builder builderNewBuilder = SessionRecordingV1.Gesture.Tap.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        TapKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
