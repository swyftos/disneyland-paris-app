package com.contentsquare.proto.sessionreplay.p023v1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, m1836d2 = {"viewText", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewText;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/ViewTextKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeviewText", "copy", "core_release"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nViewTextKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewTextKt.kt\ncom/contentsquare/proto/sessionreplay/v1/ViewTextKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,169:1\n1#2:170\n*E\n"})
public final class ViewTextKtKt {
    @JvmName(name = "-initializeviewText")
    @NotNull
    /* JADX INFO: renamed from: -initializeviewText, reason: not valid java name */
    public static final SessionRecordingV1.ViewText m4014initializeviewText(Function1<? super ViewTextKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ViewTextKt.Dsl.Companion companion = ViewTextKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewText.Builder builderNewBuilder = SessionRecordingV1.ViewText.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ViewTextKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.ViewText copy(SessionRecordingV1.ViewText viewText, Function1<? super ViewTextKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(viewText, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewTextKt.Dsl.Companion companion = ViewTextKt.Dsl.INSTANCE;
        SessionRecordingV1.ViewText.Builder builder = viewText.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ViewTextKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
