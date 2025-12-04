package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.GestureKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0018\u001a)\u0010\u0019\u001a\u00020\u0012*\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0086\bø\u0001\u0000\u001a)\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0086\bø\u0001\u0000\u001a)\u0010\u0019\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0086\bø\u0001\u0000\u001a)\u0010\u0019\u001a\u00020\n*\u00020\n2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0086\bø\u0001\u0000\u001a)\u0010\u0019\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"dragOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GestureOrBuilder;", "getDragOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GestureOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Drag;", "flickOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick;", "getFlickOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GestureOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Flick;", "longPressOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress;", "getLongPressOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GestureOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$LongPress;", "tapOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap;", "getTapOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GestureOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture$Tap;", "gesture", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializegesture", "copy", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$DragKt$Dsl;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$FlickKt$Dsl;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$LongPressKt$Dsl;", "Lcom/contentsquare/proto/sessionreplay/v1/GestureKt$TapKt$Dsl;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGestureKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GestureKt.kt\ncom/contentsquare/proto/sessionreplay/v1/GestureKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,370:1\n1#2:371\n*E\n"})
/* loaded from: classes3.dex */
public final class GestureKtKt {
    @JvmName(name = "-initializegesture")
    @NotNull
    /* renamed from: -initializegesture, reason: not valid java name */
    public static final SessionRecordingV1.Gesture m1292initializegesture(Function1<? super GestureKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        GestureKt.Dsl.Companion companion = GestureKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Builder builderNewBuilder = SessionRecordingV1.Gesture.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        GestureKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.Gesture.Drag copy(SessionRecordingV1.Gesture.Drag drag, Function1<? super GestureKt.DragKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(drag, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        GestureKt.DragKt.Dsl.Companion companion = GestureKt.DragKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Drag.Builder builder = drag.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        GestureKt.DragKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.Gesture.Flick copy(SessionRecordingV1.Gesture.Flick flick, Function1<? super GestureKt.FlickKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(flick, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        GestureKt.FlickKt.Dsl.Companion companion = GestureKt.FlickKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Flick.Builder builder = flick.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        GestureKt.FlickKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.Gesture.LongPress copy(SessionRecordingV1.Gesture.LongPress longPress, Function1<? super GestureKt.LongPressKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(longPress, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        GestureKt.LongPressKt.Dsl.Companion companion = GestureKt.LongPressKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.LongPress.Builder builder = longPress.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        GestureKt.LongPressKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.Gesture.Tap copy(SessionRecordingV1.Gesture.Tap tap, Function1<? super GestureKt.TapKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(tap, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        GestureKt.TapKt.Dsl.Companion companion = GestureKt.TapKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Tap.Builder builder = tap.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        GestureKt.TapKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.Gesture copy(SessionRecordingV1.Gesture gesture, Function1<? super GestureKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(gesture, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        GestureKt.Dsl.Companion companion = GestureKt.Dsl.INSTANCE;
        SessionRecordingV1.Gesture.Builder builder = gesture.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        GestureKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SessionRecordingV1.Gesture.Drag getDragOrNull(SessionRecordingV1.GestureOrBuilder gestureOrBuilder) {
        Intrinsics.checkNotNullParameter(gestureOrBuilder, "<this>");
        if (gestureOrBuilder.hasDrag()) {
            return gestureOrBuilder.getDrag();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.Gesture.Flick getFlickOrNull(SessionRecordingV1.GestureOrBuilder gestureOrBuilder) {
        Intrinsics.checkNotNullParameter(gestureOrBuilder, "<this>");
        if (gestureOrBuilder.hasFlick()) {
            return gestureOrBuilder.getFlick();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.Gesture.LongPress getLongPressOrNull(SessionRecordingV1.GestureOrBuilder gestureOrBuilder) {
        Intrinsics.checkNotNullParameter(gestureOrBuilder, "<this>");
        if (gestureOrBuilder.hasLongPress()) {
            return gestureOrBuilder.getLongPress();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.Gesture.Tap getTapOrNull(SessionRecordingV1.GestureOrBuilder gestureOrBuilder) {
        Intrinsics.checkNotNullParameter(gestureOrBuilder, "<this>");
        if (gestureOrBuilder.hasTap()) {
            return gestureOrBuilder.getTap();
        }
        return null;
    }
}
