package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.InsertionMutationKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"viewOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutationOrBuilder;", "getViewOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutationOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$View;", "insertionMutation", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/InsertionMutationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeinsertionMutation", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInsertionMutationKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InsertionMutationKt.kt\ncom/contentsquare/proto/sessionreplay/v1/InsertionMutationKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
/* loaded from: classes3.dex */
public final class InsertionMutationKtKt {
    @JvmName(name = "-initializeinsertionMutation")
    @NotNull
    /* renamed from: -initializeinsertionMutation, reason: not valid java name */
    public static final SessionRecordingV1.InsertionMutation m1294initializeinsertionMutation(Function1<? super InsertionMutationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        InsertionMutationKt.Dsl.Companion companion = InsertionMutationKt.Dsl.INSTANCE;
        SessionRecordingV1.InsertionMutation.Builder builderNewBuilder = SessionRecordingV1.InsertionMutation.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        InsertionMutationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.InsertionMutation copy(SessionRecordingV1.InsertionMutation insertionMutation, Function1<? super InsertionMutationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(insertionMutation, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        InsertionMutationKt.Dsl.Companion companion = InsertionMutationKt.Dsl.INSTANCE;
        SessionRecordingV1.InsertionMutation.Builder builder = insertionMutation.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        InsertionMutationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SessionRecordingV1.View getViewOrNull(SessionRecordingV1.InsertionMutationOrBuilder insertionMutationOrBuilder) {
        Intrinsics.checkNotNullParameter(insertionMutationOrBuilder, "<this>");
        if (insertionMutationOrBuilder.hasView()) {
            return insertionMutationOrBuilder.getView();
        }
        return null;
    }
}
