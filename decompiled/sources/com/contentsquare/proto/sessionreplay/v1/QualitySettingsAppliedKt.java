package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt;", "", "()V", "networkValues", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$NetworkValuesKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializenetworkValues", "qualityLevels", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$QualityLevelsKt$Dsl;", "-initializequalityLevels", "Dsl", "NetworkValuesKt", "QualityLevelsKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nQualitySettingsAppliedKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QualitySettingsAppliedKt.kt\ncom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1#2:297\n*E\n"})
/* loaded from: classes3.dex */
public final class QualitySettingsAppliedKt {

    @NotNull
    public static final QualitySettingsAppliedKt INSTANCE = new QualitySettingsAppliedKt();

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020+H\u0001J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010$\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00065"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;", "networkValues", "getNetworkValues", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;", "setNetworkValues", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;", "qualityLevels", "getQualityLevels", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;", "setQualityLevels", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$Reason;", "reason", "getReason", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$Reason;", "setReason", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$Reason;)V", "", "reasonValue", "getReasonValue", "()I", "setReasonValue", "(I)V", "", "unixTimestampMs", "getUnixTimestampMs", "()J", "setUnixTimestampMs", "(J)V", "networkValuesOrNull", "getNetworkValuesOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;", "qualityLevelsOrNull", "getQualityLevelsOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied;", "clearNetworkValues", "", "clearQualityLevels", "clearReason", "clearUnixTimestampMs", "hasNetworkValues", "", "hasQualityLevels", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.QualitySettingsApplied.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.QualitySettingsApplied.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.QualitySettingsApplied.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.QualitySettingsApplied _build() {
            SessionRecordingV1.QualitySettingsApplied qualitySettingsAppliedBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(qualitySettingsAppliedBuild, "_builder.build()");
            return qualitySettingsAppliedBuild;
        }

        public final void clearNetworkValues() {
            this._builder.clearNetworkValues();
        }

        public final void clearQualityLevels() {
            this._builder.clearQualityLevels();
        }

        public final void clearReason() {
            this._builder.clearReason();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        @JvmName(name = "getNetworkValues")
        @NotNull
        public final SessionRecordingV1.QualitySettingsApplied.NetworkValues getNetworkValues() {
            SessionRecordingV1.QualitySettingsApplied.NetworkValues networkValues = this._builder.getNetworkValues();
            Intrinsics.checkNotNullExpressionValue(networkValues, "_builder.getNetworkValues()");
            return networkValues;
        }

        @Nullable
        public final SessionRecordingV1.QualitySettingsApplied.NetworkValues getNetworkValuesOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return QualitySettingsAppliedKtKt.getNetworkValuesOrNull(dsl._builder);
        }

        @JvmName(name = "getQualityLevels")
        @NotNull
        public final SessionRecordingV1.QualitySettingsApplied.QualityLevels getQualityLevels() {
            SessionRecordingV1.QualitySettingsApplied.QualityLevels qualityLevels = this._builder.getQualityLevels();
            Intrinsics.checkNotNullExpressionValue(qualityLevels, "_builder.getQualityLevels()");
            return qualityLevels;
        }

        @Nullable
        public final SessionRecordingV1.QualitySettingsApplied.QualityLevels getQualityLevelsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return QualitySettingsAppliedKtKt.getQualityLevelsOrNull(dsl._builder);
        }

        @JvmName(name = "getReason")
        @NotNull
        public final SessionRecordingV1.QualitySettingsApplied.Reason getReason() {
            SessionRecordingV1.QualitySettingsApplied.Reason reason = this._builder.getReason();
            Intrinsics.checkNotNullExpressionValue(reason, "_builder.getReason()");
            return reason;
        }

        @JvmName(name = "getReasonValue")
        public final int getReasonValue() {
            return this._builder.getReasonValue();
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        public final boolean hasNetworkValues() {
            return this._builder.hasNetworkValues();
        }

        public final boolean hasQualityLevels() {
            return this._builder.hasQualityLevels();
        }

        @JvmName(name = "setNetworkValues")
        public final void setNetworkValues(SessionRecordingV1.QualitySettingsApplied.NetworkValues value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setNetworkValues(value);
        }

        @JvmName(name = "setQualityLevels")
        public final void setQualityLevels(SessionRecordingV1.QualitySettingsApplied.QualityLevels value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setQualityLevels(value);
        }

        @JvmName(name = "setReason")
        public final void setReason(SessionRecordingV1.QualitySettingsApplied.Reason value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReason(value);
        }

        @JvmName(name = "setReasonValue")
        public final void setReasonValue(int i) {
            this._builder.setReasonValue(i);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.QualitySettingsApplied.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$NetworkValuesKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NetworkValuesKt {

        @NotNull
        public static final NetworkValuesKt INSTANCE = new NetworkValuesKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006 "}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$NetworkValuesKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkStatus;", "current", "getCurrent", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkStatus;", "setCurrent", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkStatus;)V", "", "currentValue", "getCurrentValue", "()I", "setCurrentValue", "(I)V", "previous", "getPrevious", "setPrevious", "previousValue", "getPreviousValue", "setPreviousValue", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues;", "clearCurrent", "", "clearPrevious", "hasPrevious", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final SessionRecordingV1.QualitySettingsApplied.NetworkValues.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$NetworkValuesKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$NetworkValuesKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$NetworkValues$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(SessionRecordingV1.QualitySettingsApplied.NetworkValues.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(SessionRecordingV1.QualitySettingsApplied.NetworkValues.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ SessionRecordingV1.QualitySettingsApplied.NetworkValues _build() {
                SessionRecordingV1.QualitySettingsApplied.NetworkValues networkValuesBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(networkValuesBuild, "_builder.build()");
                return networkValuesBuild;
            }

            public final void clearCurrent() {
                this._builder.clearCurrent();
            }

            public final void clearPrevious() {
                this._builder.clearPrevious();
            }

            @JvmName(name = "getCurrent")
            @NotNull
            public final SessionRecordingV1.NetworkStatus getCurrent() {
                SessionRecordingV1.NetworkStatus current = this._builder.getCurrent();
                Intrinsics.checkNotNullExpressionValue(current, "_builder.getCurrent()");
                return current;
            }

            @JvmName(name = "getCurrentValue")
            public final int getCurrentValue() {
                return this._builder.getCurrentValue();
            }

            @JvmName(name = "getPrevious")
            @NotNull
            public final SessionRecordingV1.NetworkStatus getPrevious() {
                SessionRecordingV1.NetworkStatus previous = this._builder.getPrevious();
                Intrinsics.checkNotNullExpressionValue(previous, "_builder.getPrevious()");
                return previous;
            }

            @JvmName(name = "getPreviousValue")
            public final int getPreviousValue() {
                return this._builder.getPreviousValue();
            }

            public final boolean hasPrevious() {
                return this._builder.hasPrevious();
            }

            @JvmName(name = "setCurrent")
            public final void setCurrent(SessionRecordingV1.NetworkStatus value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCurrent(value);
            }

            @JvmName(name = "setCurrentValue")
            public final void setCurrentValue(int i) {
                this._builder.setCurrentValue(i);
            }

            @JvmName(name = "setPrevious")
            public final void setPrevious(SessionRecordingV1.NetworkStatus value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPrevious(value);
            }

            @JvmName(name = "setPreviousValue")
            public final void setPreviousValue(int i) {
                this._builder.setPreviousValue(i);
            }

            public /* synthetic */ Dsl(SessionRecordingV1.QualitySettingsApplied.NetworkValues.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private NetworkValuesKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$QualityLevelsKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class QualityLevelsKt {

        @NotNull
        public static final QualityLevelsKt INSTANCE = new QualityLevelsKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006 "}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$QualityLevelsKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingQuality;", "current", "getCurrent", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingQuality;", "setCurrent", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingQuality;)V", "", "currentValue", "getCurrentValue", "()I", "setCurrentValue", "(I)V", "previous", "getPrevious", "setPrevious", "previousValue", "getPreviousValue", "setPreviousValue", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels;", "clearCurrent", "", "clearPrevious", "hasPrevious", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final SessionRecordingV1.QualitySettingsApplied.QualityLevels.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$QualityLevelsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/QualitySettingsAppliedKt$QualityLevelsKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied$QualityLevels$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(SessionRecordingV1.QualitySettingsApplied.QualityLevels.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(SessionRecordingV1.QualitySettingsApplied.QualityLevels.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ SessionRecordingV1.QualitySettingsApplied.QualityLevels _build() {
                SessionRecordingV1.QualitySettingsApplied.QualityLevels qualityLevelsBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(qualityLevelsBuild, "_builder.build()");
                return qualityLevelsBuild;
            }

            public final void clearCurrent() {
                this._builder.clearCurrent();
            }

            public final void clearPrevious() {
                this._builder.clearPrevious();
            }

            @JvmName(name = "getCurrent")
            @NotNull
            public final SessionRecordingV1.RecordingQuality getCurrent() {
                SessionRecordingV1.RecordingQuality current = this._builder.getCurrent();
                Intrinsics.checkNotNullExpressionValue(current, "_builder.getCurrent()");
                return current;
            }

            @JvmName(name = "getCurrentValue")
            public final int getCurrentValue() {
                return this._builder.getCurrentValue();
            }

            @JvmName(name = "getPrevious")
            @NotNull
            public final SessionRecordingV1.RecordingQuality getPrevious() {
                SessionRecordingV1.RecordingQuality previous = this._builder.getPrevious();
                Intrinsics.checkNotNullExpressionValue(previous, "_builder.getPrevious()");
                return previous;
            }

            @JvmName(name = "getPreviousValue")
            public final int getPreviousValue() {
                return this._builder.getPreviousValue();
            }

            public final boolean hasPrevious() {
                return this._builder.hasPrevious();
            }

            @JvmName(name = "setCurrent")
            public final void setCurrent(SessionRecordingV1.RecordingQuality value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCurrent(value);
            }

            @JvmName(name = "setCurrentValue")
            public final void setCurrentValue(int i) {
                this._builder.setCurrentValue(i);
            }

            @JvmName(name = "setPrevious")
            public final void setPrevious(SessionRecordingV1.RecordingQuality value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPrevious(value);
            }

            @JvmName(name = "setPreviousValue")
            public final void setPreviousValue(int i) {
                this._builder.setPreviousValue(i);
            }

            public /* synthetic */ Dsl(SessionRecordingV1.QualitySettingsApplied.QualityLevels.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private QualityLevelsKt() {
        }
    }

    private QualitySettingsAppliedKt() {
    }

    @JvmName(name = "-initializenetworkValues")
    @NotNull
    /* renamed from: -initializenetworkValues, reason: not valid java name */
    public final SessionRecordingV1.QualitySettingsApplied.NetworkValues m1299initializenetworkValues(Function1<? super NetworkValuesKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NetworkValuesKt.Dsl.Companion companion = NetworkValuesKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.NetworkValues.Builder builderNewBuilder = SessionRecordingV1.QualitySettingsApplied.NetworkValues.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        NetworkValuesKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializequalityLevels")
    @NotNull
    /* renamed from: -initializequalityLevels, reason: not valid java name */
    public final SessionRecordingV1.QualitySettingsApplied.QualityLevels m1300initializequalityLevels(Function1<? super QualityLevelsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        QualityLevelsKt.Dsl.Companion companion = QualityLevelsKt.Dsl.INSTANCE;
        SessionRecordingV1.QualitySettingsApplied.QualityLevels.Builder builderNewBuilder = SessionRecordingV1.QualitySettingsApplied.QualityLevels.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        QualityLevelsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
