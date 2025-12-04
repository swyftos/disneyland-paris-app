package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.JsErrorKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"jsError", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$JsError;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/JsErrorKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializejsError", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJsErrorKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsErrorKt.kt\ncom/contentsquare/proto/sessionreplay/v1/JsErrorKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,192:1\n1#2:193\n*E\n"})
/* loaded from: classes3.dex */
public final class JsErrorKtKt {
    @JvmName(name = "-initializejsError")
    @NotNull
    /* renamed from: -initializejsError, reason: not valid java name */
    public static final SessionRecordingV1.JsError m1295initializejsError(Function1<? super JsErrorKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        JsErrorKt.Dsl.Companion companion = JsErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.JsError.Builder builderNewBuilder = SessionRecordingV1.JsError.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        JsErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.JsError copy(SessionRecordingV1.JsError jsError, Function1<? super JsErrorKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(jsError, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        JsErrorKt.Dsl.Companion companion = JsErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.JsError.Builder builder = jsError.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        JsErrorKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
