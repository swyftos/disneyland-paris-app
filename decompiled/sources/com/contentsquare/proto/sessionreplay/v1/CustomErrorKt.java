package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.urbanairship.channel.AttributeMutation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/CustomErrorKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomErrorKt {

    @NotNull
    public static final CustomErrorKt INSTANCE = new CustomErrorKt();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0001J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020%J#\u0010&\u001a\u00020 *\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b'J3\u0010(\u001a\u00020 *\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b*J7\u0010+\u001a\u00020 *\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070-H\u0007¢\u0006\u0002\b.J+\u0010/\u001a\u00020 *\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010)\u001a\u00020\u0007H\u0007¢\u0006\u0002\b0J4\u00101\u001a\u00020 *\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b2R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u00065"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/CustomErrorKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError$Builder;)V", "customAttributes", "Lcom/google/protobuf/kotlin/DslMap;", "", "Lcom/contentsquare/proto/sessionreplay/v1/CustomErrorKt$Dsl$CustomAttributesProxy;", "getCustomAttributesMap", "()Lcom/google/protobuf/kotlin/DslMap;", "value", "errorSource", "getErrorSource", "()Ljava/lang/String;", "setErrorSource", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "", "relativeTime", "getRelativeTime", "()J", "setRelativeTime", "(J)V", "unixTimestampMs", "getUnixTimestampMs", "setUnixTimestampMs", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError;", "clearErrorSource", "", "clearMessage", "clearRelativeTime", "clearUnixTimestampMs", "hasErrorSource", "", "clear", "clearCustomAttributes", "put", "key", "putCustomAttributes", "putAll", "map", "", "putAllCustomAttributes", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "removeCustomAttributes", AttributeMutation.ATTRIBUTE_ACTION_SET, "setCustomAttributes", "Companion", "CustomAttributesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.CustomError.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/CustomErrorKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/CustomErrorKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.CustomError.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/CustomErrorKt$Dsl$CustomAttributesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CustomAttributesProxy extends DslProxy {
            private CustomAttributesProxy() {
            }
        }

        private Dsl(SessionRecordingV1.CustomError.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.CustomError _build() {
            SessionRecordingV1.CustomError customErrorBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(customErrorBuild, "_builder.build()");
            return customErrorBuild;
        }

        @JvmName(name = "clearCustomAttributes")
        public final /* synthetic */ void clearCustomAttributes(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearCustomAttributes();
        }

        public final void clearErrorSource() {
            this._builder.clearErrorSource();
        }

        public final void clearMessage() {
            this._builder.clearMessage();
        }

        public final void clearRelativeTime() {
            this._builder.clearRelativeTime();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        @JvmName(name = "getCustomAttributesMap")
        public final /* synthetic */ DslMap getCustomAttributesMap() {
            Map<String, String> customAttributesMap = this._builder.getCustomAttributesMap();
            Intrinsics.checkNotNullExpressionValue(customAttributesMap, "_builder.getCustomAttributesMap()");
            return new DslMap(customAttributesMap);
        }

        @JvmName(name = "getErrorSource")
        @NotNull
        public final String getErrorSource() {
            String errorSource = this._builder.getErrorSource();
            Intrinsics.checkNotNullExpressionValue(errorSource, "_builder.getErrorSource()");
            return errorSource;
        }

        @JvmName(name = "getMessage")
        @NotNull
        public final String getMessage() {
            String message = this._builder.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "_builder.getMessage()");
            return message;
        }

        @JvmName(name = "getRelativeTime")
        public final long getRelativeTime() {
            return this._builder.getRelativeTime();
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        public final boolean hasErrorSource() {
            return this._builder.hasErrorSource();
        }

        @JvmName(name = "putAllCustomAttributes")
        public final /* synthetic */ void putAllCustomAttributes(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllCustomAttributes(map);
        }

        @JvmName(name = "putCustomAttributes")
        public final void putCustomAttributes(DslMap<String, String, CustomAttributesProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putCustomAttributes(key, value);
        }

        @JvmName(name = "removeCustomAttributes")
        public final /* synthetic */ void removeCustomAttributes(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removeCustomAttributes(key);
        }

        @JvmName(name = "setCustomAttributes")
        public final /* synthetic */ void setCustomAttributes(DslMap<String, String, CustomAttributesProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putCustomAttributes(dslMap, key, value);
        }

        @JvmName(name = "setErrorSource")
        public final void setErrorSource(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setErrorSource(value);
        }

        @JvmName(name = "setMessage")
        public final void setMessage(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMessage(value);
        }

        @JvmName(name = "setRelativeTime")
        public final void setRelativeTime(long j) {
            this._builder.setRelativeTime(j);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.CustomError.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private CustomErrorKt() {
    }
}
