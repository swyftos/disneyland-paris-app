package com.contentsquare.proto.sessionreplay.p023v1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, m1836d2 = {"recordingStop", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStop;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/RecordingStopKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializerecordingStop", "copy", "core_release"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nRecordingStopKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordingStopKt.kt\ncom/contentsquare/proto/sessionreplay/v1/RecordingStopKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class RecordingStopKtKt {
    @JvmName(name = "-initializerecordingStop")
    @NotNull
    /* JADX INFO: renamed from: -initializerecordingStop, reason: not valid java name */
    public static final SessionRecordingV1.RecordingStop m3541initializerecordingStop(Function1<? super RecordingStopKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        RecordingStopKt.Dsl.Companion companion = RecordingStopKt.Dsl.INSTANCE;
        SessionRecordingV1.RecordingStop.Builder builderNewBuilder = SessionRecordingV1.RecordingStop.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        RecordingStopKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.RecordingStop copy(SessionRecordingV1.RecordingStop recordingStop, Function1<? super RecordingStopKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(recordingStop, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        RecordingStopKt.Dsl.Companion companion = RecordingStopKt.Dsl.INSTANCE;
        SessionRecordingV1.RecordingStop.Builder builder = recordingStop.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        RecordingStopKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
