package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.CustomErrorKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"customError", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/CustomErrorKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializecustomError", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomErrorKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomErrorKt.kt\ncom/contentsquare/proto/sessionreplay/v1/CustomErrorKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,171:1\n1#2:172\n*E\n"})
/* loaded from: classes3.dex */
public final class CustomErrorKtKt {
    @JvmName(name = "-initializecustomError")
    @NotNull
    /* renamed from: -initializecustomError, reason: not valid java name */
    public static final SessionRecordingV1.CustomError m1282initializecustomError(Function1<? super CustomErrorKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        CustomErrorKt.Dsl.Companion companion = CustomErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.CustomError.Builder builderNewBuilder = SessionRecordingV1.CustomError.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CustomErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.CustomError copy(SessionRecordingV1.CustomError customError, Function1<? super CustomErrorKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(customError, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        CustomErrorKt.Dsl.Companion companion = CustomErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.CustomError.Builder builder = customError.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        CustomErrorKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
