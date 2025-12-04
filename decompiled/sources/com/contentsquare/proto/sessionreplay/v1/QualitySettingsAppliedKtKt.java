package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.QualitySettingsAppliedKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"networkValuesOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsAppliedOrBuilder;", "getNetworkValuesOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsAppliedOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;", "qualityLevelsOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;", "getQualityLevelsOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsAppliedOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;", "qualitySettingsApplied", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializequalitySettingsApplied", "copy", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$NetworkValuesKt$Dsl;", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$QualityLevelsKt$Dsl;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nQualitySettingsAppliedKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QualitySettingsAppliedKt.kt\ncom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1#2:297\n*E\n"})
/* loaded from: classes3.dex */
public final class QualitySettingsAppliedKtKt {
    @JvmName(name = "-initializequalitySettingsApplied")
    @NotNull
    /* renamed from: -initializequalitySettingsApplied, reason: not valid java name */
    public static final SessionRecordingV1.QualitySettingsApplied m1301initializequalitySettingsApplied(Function1<? super QualitySettingsAppliedKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        QualitySettingsAppliedKt.Dsl.Companion companion = QualitySettingsAppliedKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.Builder builderNewBuilder = SessionRecordingV1.QualitySettingsApplied.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        QualitySettingsAppliedKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.QualitySettingsApplied.NetworkValues copy(SessionRecordingV1.QualitySettingsApplied.NetworkValues networkValues, Function1<? super QualitySettingsAppliedKt.NetworkValuesKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(networkValues, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        QualitySettingsAppliedKt.NetworkValuesKt.Dsl.Companion companion = QualitySettingsAppliedKt.NetworkValuesKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.NetworkValues.Builder builder = networkValues.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        QualitySettingsAppliedKt.NetworkValuesKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.QualitySettingsApplied.QualityLevels copy(SessionRecordingV1.QualitySettingsApplied.QualityLevels qualityLevels, Function1<? super QualitySettingsAppliedKt.QualityLevelsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(qualityLevels, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        QualitySettingsAppliedKt.QualityLevelsKt.Dsl.Companion companion = QualitySettingsAppliedKt.QualityLevelsKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.QualityLevels.Builder builder = qualityLevels.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        QualitySettingsAppliedKt.QualityLevelsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.QualitySettingsApplied copy(SessionRecordingV1.QualitySettingsApplied qualitySettingsApplied, Function1<? super QualitySettingsAppliedKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(qualitySettingsApplied, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        QualitySettingsAppliedKt.Dsl.Companion companion = QualitySettingsAppliedKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.Builder builder = qualitySettingsApplied.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        QualitySettingsAppliedKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SessionRecordingV1.QualitySettingsApplied.NetworkValues getNetworkValuesOrNull(SessionRecordingV1.QualitySettingsAppliedOrBuilder qualitySettingsAppliedOrBuilder) {
        Intrinsics.checkNotNullParameter(qualitySettingsAppliedOrBuilder, "<this>");
        if (qualitySettingsAppliedOrBuilder.hasNetworkValues()) {
            return qualitySettingsAppliedOrBuilder.getNetworkValues();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.QualitySettingsApplied.QualityLevels getQualityLevelsOrNull(SessionRecordingV1.QualitySettingsAppliedOrBuilder qualitySettingsAppliedOrBuilder) {
        Intrinsics.checkNotNullParameter(qualitySettingsAppliedOrBuilder, "<this>");
        if (qualitySettingsAppliedOrBuilder.hasQualityLevels()) {
            return qualitySettingsAppliedOrBuilder.getQualityLevels();
        }
        return null;
    }
}
