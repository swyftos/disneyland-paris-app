package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.v1.StyleMutationKt;
import com.contentsquare.proto.sessionreplay.v1.ViewStyleKt;
import com.google.protobuf.ByteString;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nMutationUpdateEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutationUpdateEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/MutationUpdateEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StyleMutationKt.kt\ncom/contentsquare/proto/sessionreplay/v1/StyleMutationKtKt\n*L\n1#1,43:1\n11#2:44\n1#3:45\n1#3:47\n11#4:46\n*S KotlinDebug\n*F\n+ 1 MutationUpdateEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/MutationUpdateEvent\n*L\n35#1:44\n35#1:45\n36#1:47\n36#1:46\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.h3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0694h3 extends AbstractC0707i6 {
    public final long a;

    @NotNull
    public final SessionRecordingV1.ViewStyle b;

    public C0694h3(long j, long j2, @NotNull ViewLight viewLight) {
        Intrinsics.checkNotNullParameter(viewLight, "updateViewLight");
        this.a = j2;
        setTimestamp(j);
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        ViewStyleKt.Dsl.Companion companion = ViewStyleKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewStyle.Builder builderNewBuilder = SessionRecordingV1.ViewStyle.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ViewStyleKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setX(viewLight.getPosX());
        dsl_create.setY(viewLight.getPosY());
        dsl_create.setWidth(viewLight.getWidth());
        dsl_create.setHeight(viewLight.getHeight());
        String viewBitmapHash = viewLight.getViewBitmapHash();
        if (viewBitmapHash != null) {
            dsl_create.setBitmapHash(viewBitmapHash);
            byte[] encodedBitmap = viewLight.getEncodedBitmap();
            if (encodedBitmap != null) {
                ByteString byteStringCopyFrom = ByteString.copyFrom(encodedBitmap);
                Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom, "copyFrom(encodeBitmap)");
                dsl_create.setBitmap(byteStringCopyFrom);
            }
        } else {
            dsl_create.setBackgroundColorHex(ExtensionsKt.toColorHex(viewLight.getBackgroundColor()));
        }
        dsl_create.setAlpha(viewLight.getViewAlpha());
        dsl_create.setIsVisible(viewLight.getIsVisible());
        dsl_create.setClipChildren(viewLight.getIsClipChildren());
        this.b = dsl_create._build();
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        StyleMutationKt.Dsl.Companion companion = StyleMutationKt.Dsl.INSTANCE;
        SessionRecordingV1.StyleMutation.Builder builderNewBuilder = SessionRecordingV1.StyleMutation.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        StyleMutationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        dsl_create.setViewId(this.a);
        dsl_create.setStyleChanges(this.b);
        dslA.setStyleMutation(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
