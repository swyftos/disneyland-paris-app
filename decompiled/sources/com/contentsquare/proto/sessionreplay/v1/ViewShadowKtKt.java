package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.v1.ViewShadowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"viewShadow", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/ViewShadowKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeviewShadow", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewShadowKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewShadowKt.kt\ncom/contentsquare/proto/sessionreplay/v1/ViewShadowKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
/* loaded from: classes3.dex */
public final class ViewShadowKtKt {
    @JvmName(name = "-initializeviewShadow")
    @NotNull
    /* renamed from: -initializeviewShadow, reason: not valid java name */
    public static final SessionRecordingV1.ViewShadow m1774initializeviewShadow(Function1<? super ViewShadowKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ViewShadowKt.Dsl.Companion companion = ViewShadowKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewShadow.Builder builderNewBuilder = SessionRecordingV1.ViewShadow.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ViewShadowKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.ViewShadow copy(SessionRecordingV1.ViewShadow viewShadow, Function1<? super ViewShadowKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(viewShadow, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewShadowKt.Dsl.Companion companion = ViewShadowKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewShadow.Builder builder = viewShadow.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ViewShadowKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
