package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.v1.ViewStyleKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0016\u001a)\u0010\u0017\u001a\u00020\u0010*\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"htmlTextOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyleOrBuilder;", "getHtmlTextOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyleOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText;", "serializedTextOrNull", "getSerializedTextOrNull", "shadowOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;", "getShadowOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyleOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;", "textOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewText;", "getTextOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyleOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewText;", "viewStyle", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeviewStyle", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewStyleKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewStyleKt.kt\ncom/contentsquare/proto/sessionreplay/v1/ViewStyleKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,743:1\n1#2:744\n*E\n"})
/* loaded from: classes3.dex */
public final class ViewStyleKtKt {
    @JvmName(name = "-initializeviewStyle")
    @NotNull
    /* renamed from: -initializeviewStyle, reason: not valid java name */
    public static final SessionRecordingV1.ViewStyle m1775initializeviewStyle(Function1<? super ViewStyleKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ViewStyleKt.Dsl.Companion companion = ViewStyleKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewStyle.Builder builderNewBuilder = SessionRecordingV1.ViewStyle.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ViewStyleKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.ViewStyle copy(SessionRecordingV1.ViewStyle viewStyle, Function1<? super ViewStyleKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(viewStyle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewStyleKt.Dsl.Companion companion = ViewStyleKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewStyle.Builder builder = viewStyle.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ViewStyleKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SessionRecordingV1.ViewHtmlText getHtmlTextOrNull(SessionRecordingV1.ViewStyleOrBuilder viewStyleOrBuilder) {
        Intrinsics.checkNotNullParameter(viewStyleOrBuilder, "<this>");
        if (viewStyleOrBuilder.hasHtmlText()) {
            return viewStyleOrBuilder.getHtmlText();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.ViewHtmlText getSerializedTextOrNull(SessionRecordingV1.ViewStyleOrBuilder viewStyleOrBuilder) {
        Intrinsics.checkNotNullParameter(viewStyleOrBuilder, "<this>");
        if (viewStyleOrBuilder.hasSerializedText()) {
            return viewStyleOrBuilder.getSerializedText();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.ViewShadow getShadowOrNull(SessionRecordingV1.ViewStyleOrBuilder viewStyleOrBuilder) {
        Intrinsics.checkNotNullParameter(viewStyleOrBuilder, "<this>");
        if (viewStyleOrBuilder.hasShadow()) {
            return viewStyleOrBuilder.getShadow();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.ViewText getTextOrNull(SessionRecordingV1.ViewStyleOrBuilder viewStyleOrBuilder) {
        Intrinsics.checkNotNullParameter(viewStyleOrBuilder, "<this>");
        if (viewStyleOrBuilder.hasText()) {
            return viewStyleOrBuilder.getText();
        }
        return null;
    }
}
