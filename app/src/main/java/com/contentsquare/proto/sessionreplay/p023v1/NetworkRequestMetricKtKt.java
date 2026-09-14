package com.contentsquare.proto.sessionreplay.p023v1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, m1836d2 = {"networkRequestMetric", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializenetworkRequestMetric", "copy", "core_release"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nNetworkRequestMetricKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkRequestMetricKt.kt\ncom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,767:1\n1#2:768\n*E\n"})
public final class NetworkRequestMetricKtKt {
    @JvmName(name = "-initializenetworkRequestMetric")
    @NotNull
    /* JADX INFO: renamed from: -initializenetworkRequestMetric, reason: not valid java name */
    public static final SessionRecordingV1.NetworkRequestMetric m3535initializenetworkRequestMetric(Function1<? super NetworkRequestMetricKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NetworkRequestMetricKt.Dsl.Companion companion = NetworkRequestMetricKt.Dsl.INSTANCE;
        SessionRecordingV1.NetworkRequestMetric.Builder builderNewBuilder = SessionRecordingV1.NetworkRequestMetric.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        NetworkRequestMetricKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.NetworkRequestMetric copy(SessionRecordingV1.NetworkRequestMetric networkRequestMetric, Function1<? super NetworkRequestMetricKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(networkRequestMetric, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        NetworkRequestMetricKt.Dsl.Companion companion = NetworkRequestMetricKt.Dsl.INSTANCE;
        SessionRecordingV1.NetworkRequestMetric.Builder builder = networkRequestMetric.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        NetworkRequestMetricKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
