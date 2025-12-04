package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.v1.StyleMutationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"styleChangesOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutationOrBuilder;", "getStyleChangesOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutationOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "styleMutation", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/StyleMutationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializestyleMutation", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStyleMutationKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StyleMutationKt.kt\ncom/contentsquare/proto/sessionreplay/v1/StyleMutationKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n1#2:99\n*E\n"})
/* loaded from: classes3.dex */
public final class StyleMutationKtKt {
    @JvmName(name = "-initializestyleMutation")
    @NotNull
    /* renamed from: -initializestyleMutation, reason: not valid java name */
    public static final SessionRecordingV1.StyleMutation m1770initializestyleMutation(Function1<? super StyleMutationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        StyleMutationKt.Dsl.Companion companion = StyleMutationKt.Dsl.INSTANCE;
        SessionRecordingV1.StyleMutation.Builder builderNewBuilder = SessionRecordingV1.StyleMutation.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        StyleMutationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.StyleMutation copy(SessionRecordingV1.StyleMutation styleMutation, Function1<? super StyleMutationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(styleMutation, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        StyleMutationKt.Dsl.Companion companion = StyleMutationKt.Dsl.INSTANCE;
        SessionRecordingV1.StyleMutation.Builder builder = styleMutation.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        StyleMutationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SessionRecordingV1.ViewStyle getStyleChangesOrNull(SessionRecordingV1.StyleMutationOrBuilder styleMutationOrBuilder) {
        Intrinsics.checkNotNullParameter(styleMutationOrBuilder, "<this>");
        if (styleMutationOrBuilder.hasStyleChanges()) {
            return styleMutationOrBuilder.getStyleChanges();
        }
        return null;
    }
}
