package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.QualitySettingsAppliedKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nQualitySettingsAppliedEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QualitySettingsAppliedEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/quality/QualitySettingsAppliedEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 QualitySettingsAppliedKt.kt\ncom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKtKt\n+ 5 QualitySettingsAppliedKt.kt\ncom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt\n*L\n1#1,89:1\n11#2:90\n1#3:91\n1#3:93\n1#3:95\n1#3:97\n11#4:92\n126#5:94\n204#5:96\n*S KotlinDebug\n*F\n+ 1 QualitySettingsAppliedEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/quality/QualitySettingsAppliedEvent\n*L\n44#1:90\n44#1:91\n45#1:93\n48#1:95\n52#1:97\n45#1:92\n48#1:94\n52#1:96\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.k4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0725k4 extends AbstractC0707i6 {

    @NotNull
    public final EnumC0705i4 a;

    @NotNull
    public final QualityLevel b;

    @NotNull
    public final QualityLevel c;

    @NotNull
    public final ConnectionType d;

    @NotNull
    public final ConnectionType e;

    /* renamed from: com.contentsquare.android.sdk.k4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC0705i4.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[QualityLevel.values().length];
            try {
                iArr2[QualityLevel.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[QualityLevel.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[QualityLevel.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr2;
            int[] iArr3 = new int[ConnectionType.values().length];
            try {
                iArr3[ConnectionType.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[ConnectionType.CONNECTIVITY_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ConnectionType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr3;
        }
    }

    public C0725k4(long j, @NotNull EnumC0705i4 changeReason, @NotNull QualityLevel previousQualityLevel, @NotNull QualityLevel currentQualityLevel, @NotNull ConnectionType previousConnectionType, @NotNull ConnectionType currentConnectionType) {
        Intrinsics.checkNotNullParameter(changeReason, "changeReason");
        Intrinsics.checkNotNullParameter(previousQualityLevel, "previousQualityLevel");
        Intrinsics.checkNotNullParameter(currentQualityLevel, "currentQualityLevel");
        Intrinsics.checkNotNullParameter(previousConnectionType, "previousConnectionType");
        Intrinsics.checkNotNullParameter(currentConnectionType, "currentConnectionType");
        this.a = changeReason;
        this.b = previousQualityLevel;
        this.c = currentQualityLevel;
        this.d = previousConnectionType;
        this.e = currentConnectionType;
        setTimestamp(j);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        SessionRecordingV1.QualitySettingsApplied.Reason reason;
        SessionRecordingV1.RecordingQuality recordingQuality;
        SessionRecordingV1.RecordingQuality recordingQuality2;
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        QualitySettingsAppliedKt.Dsl.Companion companion = QualitySettingsAppliedKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.Builder builderNewBuilder = SessionRecordingV1.QualitySettingsApplied.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        QualitySettingsAppliedKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            reason = SessionRecordingV1.QualitySettingsApplied.Reason.REASON_CONFIG_APPLIED;
        } else if (iOrdinal == 1) {
            reason = SessionRecordingV1.QualitySettingsApplied.Reason.REASON_NETWORK_CHANGED;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            reason = SessionRecordingV1.QualitySettingsApplied.Reason.REASON_CPU_USAGE_CHANGED;
        }
        dsl_create.setReason(reason);
        QualitySettingsAppliedKt qualitySettingsAppliedKt = QualitySettingsAppliedKt.INSTANCE;
        QualitySettingsAppliedKt.QualityLevelsKt.Dsl.Companion companion2 = QualitySettingsAppliedKt.QualityLevelsKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.QualityLevels.Builder builderNewBuilder2 = SessionRecordingV1.QualitySettingsApplied.QualityLevels.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
        QualitySettingsAppliedKt.QualityLevelsKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
        QualityLevel qualityLevel = this.b;
        int[] iArr = a.a;
        int i = iArr[qualityLevel.ordinal()];
        if (i == 1) {
            recordingQuality = SessionRecordingV1.RecordingQuality.RECORDING_QUALITY_LOW;
        } else if (i == 2) {
            recordingQuality = SessionRecordingV1.RecordingQuality.RECORDING_QUALITY_MEDIUM;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            recordingQuality = SessionRecordingV1.RecordingQuality.RECORDING_QUALITY_HIGH;
        }
        dsl_create2.setPrevious(recordingQuality);
        int i2 = iArr[this.c.ordinal()];
        if (i2 == 1) {
            recordingQuality2 = SessionRecordingV1.RecordingQuality.RECORDING_QUALITY_LOW;
        } else if (i2 == 2) {
            recordingQuality2 = SessionRecordingV1.RecordingQuality.RECORDING_QUALITY_MEDIUM;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            recordingQuality2 = SessionRecordingV1.RecordingQuality.RECORDING_QUALITY_HIGH;
        }
        dsl_create2.setCurrent(recordingQuality2);
        dsl_create.setQualityLevels(dsl_create2._build());
        QualitySettingsAppliedKt.NetworkValuesKt.Dsl.Companion companion3 = QualitySettingsAppliedKt.NetworkValuesKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.NetworkValues.Builder builderNewBuilder3 = SessionRecordingV1.QualitySettingsApplied.NetworkValues.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder3, "newBuilder()");
        QualitySettingsAppliedKt.NetworkValuesKt.Dsl dsl_create3 = companion3._create(builderNewBuilder3);
        ConnectionType connectionType = this.d;
        int[] iArr2 = a.b;
        int i3 = iArr2[connectionType.ordinal()];
        dsl_create3.setPrevious((i3 == 1 || i3 == 2) ? SessionRecordingV1.NetworkStatus.NETWORK_STATUS_OFFLINE : i3 != 3 ? SessionRecordingV1.NetworkStatus.NETWORK_STATUS_CELLULAR : SessionRecordingV1.NetworkStatus.NETWORK_STATUS_WIFI);
        int i4 = iArr2[this.e.ordinal()];
        dsl_create3.setCurrent((i4 == 1 || i4 == 2) ? SessionRecordingV1.NetworkStatus.NETWORK_STATUS_OFFLINE : i4 != 3 ? SessionRecordingV1.NetworkStatus.NETWORK_STATUS_CELLULAR : SessionRecordingV1.NetworkStatus.NETWORK_STATUS_WIFI);
        dsl_create.setNetworkValues(dsl_create3._build());
        dslA.setQualitySettingsApplied(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
