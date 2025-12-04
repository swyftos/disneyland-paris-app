package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.v1.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"metadataOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewOrBuilder;", "getMetadataOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$GraphMetadata;", "styleOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "getStyleOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "view", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/ViewKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeview", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewKt.kt\ncom/contentsquare/proto/sessionreplay/v1/ViewKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
/* loaded from: classes3.dex */
public final class ViewKtKt {
    @JvmName(name = "-initializeview")
    @NotNull
    /* renamed from: -initializeview, reason: not valid java name */
    public static final SessionRecordingV1.View m1773initializeview(Function1<? super ViewKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ViewKt.Dsl.Companion companion = ViewKt.Dsl.INSTANCE;
        SessionRecordingV1.View.Builder builderNewBuilder = SessionRecordingV1.View.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ViewKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.View copy(SessionRecordingV1.View view, Function1<? super ViewKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewKt.Dsl.Companion companion = ViewKt.Dsl.INSTANCE;
        SessionRecordingV1.View.Builder builder = view.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ViewKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SessionRecordingV1.GraphMetadata getMetadataOrNull(SessionRecordingV1.ViewOrBuilder viewOrBuilder) {
        Intrinsics.checkNotNullParameter(viewOrBuilder, "<this>");
        if (viewOrBuilder.hasMetadata()) {
            return viewOrBuilder.getMetadata();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.ViewStyle getStyleOrNull(SessionRecordingV1.ViewOrBuilder viewOrBuilder) {
        Intrinsics.checkNotNullParameter(viewOrBuilder, "<this>");
        if (viewOrBuilder.hasStyle()) {
            return viewOrBuilder.getStyle();
        }
        return null;
    }
}
