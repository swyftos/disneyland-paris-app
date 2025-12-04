package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.GestureKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGestureEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GestureEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/GestureEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 GestureKt.kt\ncom/contentsquare/proto/sessionreplay/v1/GestureKtKt\n+ 5 GestureKt.kt\ncom/contentsquare/proto/sessionreplay/v1/GestureKt\n*L\n1#1,99:1\n11#2:100\n11#2:102\n11#2:108\n11#2:114\n11#2:120\n1#3:101\n1#3:103\n1#3:105\n1#3:107\n1#3:109\n1#3:111\n1#3:113\n1#3:115\n1#3:117\n1#3:119\n1#3:121\n1#3:123\n1#3:125\n11#4:104\n11#4:110\n11#4:116\n11#4:122\n250#5:106\n297#5:112\n227#5:118\n170#5:124\n*S KotlinDebug\n*F\n+ 1 GestureEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/GestureEvent\n*L\n50#1:100\n61#1:102\n71#1:108\n81#1:114\n89#1:120\n50#1:101\n61#1:103\n62#1:105\n65#1:107\n71#1:109\n72#1:111\n75#1:113\n81#1:115\n82#1:117\n85#1:119\n89#1:121\n90#1:123\n93#1:125\n62#1:104\n72#1:110\n82#1:116\n90#1:122\n65#1:106\n75#1:112\n85#1:118\n93#1:124\n*E\n"})
/* loaded from: classes2.dex */
public final class Z1 extends AbstractC0707i6 {

    @NotNull
    public final C0673f2 a;

    @Nullable
    public ViewLight b;
    public final int c;
    public final int d;

    public Z1(long j, @NotNull C0673f2 result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.a = result;
        this.c = result.i;
        this.d = result.j;
        setTimestamp(j);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Z1)) {
            return super.equals(obj);
        }
        String string = toProto().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        String string2 = ((Z1) obj).toProto().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toProto().toString()");
        return Intrinsics.areEqual(string, string2);
    }

    public final int hashCode() {
        String string = toProto().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string.hashCode();
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    public final SessionRecordingV1.Event toProto() {
        switch (this.a.b) {
            case 6:
                EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
                GestureKt.Dsl.Companion companion = GestureKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.Builder builderNewBuilder = SessionRecordingV1.Gesture.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
                GestureKt.Dsl dsl_create = companion._create(builderNewBuilder);
                ViewLight viewLight = this.b;
                dsl_create.setViewId(viewLight != null ? viewLight.getRecordingId() : 0L);
                dsl_create.setUnixTimestampMs(getTimestamp());
                GestureKt gestureKt = GestureKt.INSTANCE;
                GestureKt.TapKt.Dsl.Companion companion2 = GestureKt.TapKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.Tap.Builder builderNewBuilder2 = SessionRecordingV1.Gesture.Tap.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
                GestureKt.TapKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
                dsl_create2.setX(this.c);
                dsl_create2.setY(this.d);
                dsl_create.setTap(dsl_create2._build());
                dslA.setGesture(dsl_create._build());
                return dslA._build();
            case 7:
            default:
                EventKt.Dsl.Companion companion3 = EventKt.Dsl.INSTANCE;
                SessionRecordingV1.Event.Builder builderNewBuilder3 = SessionRecordingV1.Event.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder3, "newBuilder()");
                return companion3._create(builderNewBuilder3)._build();
            case 8:
                EventKt.Dsl dslA2 = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
                GestureKt.Dsl.Companion companion4 = GestureKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.Builder builderNewBuilder4 = SessionRecordingV1.Gesture.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder4, "newBuilder()");
                GestureKt.Dsl dsl_create3 = companion4._create(builderNewBuilder4);
                ViewLight viewLight2 = this.b;
                dsl_create3.setViewId(viewLight2 != null ? viewLight2.getRecordingId() : 0L);
                dsl_create3.setUnixTimestampMs(getTimestamp());
                GestureKt gestureKt2 = GestureKt.INSTANCE;
                GestureKt.LongPressKt.Dsl.Companion companion5 = GestureKt.LongPressKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.LongPress.Builder builderNewBuilder5 = SessionRecordingV1.Gesture.LongPress.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder5, "newBuilder()");
                dsl_create3.setLongPress(companion5._create(builderNewBuilder5)._build());
                dslA2.setGesture(dsl_create3._build());
                return dslA2._build();
            case 9:
                EventKt.Dsl dslA3 = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
                GestureKt.Dsl.Companion companion6 = GestureKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.Builder builderNewBuilder6 = SessionRecordingV1.Gesture.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder6, "newBuilder()");
                GestureKt.Dsl dsl_create4 = companion6._create(builderNewBuilder6);
                dsl_create4.setUnixTimestampMs(getTimestamp());
                ViewLight viewLight3 = this.b;
                dsl_create4.setViewId(viewLight3 != null ? viewLight3.getRecordingId() : 0L);
                GestureKt gestureKt3 = GestureKt.INSTANCE;
                GestureKt.DragKt.Dsl.Companion companion7 = GestureKt.DragKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.Drag.Builder builderNewBuilder7 = SessionRecordingV1.Gesture.Drag.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder7, "newBuilder()");
                GestureKt.DragKt.Dsl dsl_create5 = companion7._create(builderNewBuilder7);
                int i = this.a.d;
                dsl_create5.setDirection(i != 1 ? i != 2 ? i != 3 ? i != 4 ? SessionRecordingV1.Gesture.Direction.UNRECOGNIZED : SessionRecordingV1.Gesture.Direction.DIRECTION_RIGHT : SessionRecordingV1.Gesture.Direction.DIRECTION_LEFT : SessionRecordingV1.Gesture.Direction.DIRECTION_DOWN : SessionRecordingV1.Gesture.Direction.DIRECTION_UP);
                dsl_create4.setDrag(dsl_create5._build());
                dslA3.setGesture(dsl_create4._build());
                return dslA3._build();
            case 10:
                EventKt.Dsl dslA4 = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
                GestureKt.Dsl.Companion companion8 = GestureKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.Builder builderNewBuilder8 = SessionRecordingV1.Gesture.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder8, "newBuilder()");
                GestureKt.Dsl dsl_create6 = companion8._create(builderNewBuilder8);
                dsl_create6.setUnixTimestampMs(getTimestamp());
                ViewLight viewLight4 = this.b;
                dsl_create6.setViewId(viewLight4 != null ? viewLight4.getRecordingId() : 0L);
                GestureKt gestureKt4 = GestureKt.INSTANCE;
                GestureKt.FlickKt.Dsl.Companion companion9 = GestureKt.FlickKt.Dsl.INSTANCE;
                SessionRecordingV1.Gesture.Flick.Builder builderNewBuilder9 = SessionRecordingV1.Gesture.Flick.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder9, "newBuilder()");
                GestureKt.FlickKt.Dsl dsl_create7 = companion9._create(builderNewBuilder9);
                int i2 = this.a.d;
                dsl_create7.setDirection(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? SessionRecordingV1.Gesture.Direction.UNRECOGNIZED : SessionRecordingV1.Gesture.Direction.DIRECTION_RIGHT : SessionRecordingV1.Gesture.Direction.DIRECTION_LEFT : SessionRecordingV1.Gesture.Direction.DIRECTION_DOWN : SessionRecordingV1.Gesture.Direction.DIRECTION_UP);
                dsl_create6.setFlick(dsl_create7._build());
                dslA4.setGesture(dsl_create6._build());
                return dslA4._build();
        }
    }

    @NotNull
    public final String toString() {
        String string = toProto().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
