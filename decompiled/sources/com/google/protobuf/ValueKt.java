package com.google.protobuf;

import com.google.protobuf.Value;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/ValueKt;", "", "()V", "Dsl", "java_kotlin-lite-well_known_protos_kotlin_lite"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValueKt {

    @NotNull
    public static final ValueKt INSTANCE = new ValueKt();

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00104\u001a\u000205H\u0001J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u000207J\u0006\u0010:\u001a\u000207J\u0006\u0010;\u001a\u000207J\u0006\u0010<\u001a\u000207J\u0006\u0010=\u001a\u000207J\u0006\u0010>\u001a\u00020\u0006J\u0006\u0010?\u001a\u00020\u0006J\u0006\u0010@\u001a\u00020\u0006J\u0006\u0010A\u001a\u00020\u0006J\u0006\u0010B\u001a\u00020\u0006J\u0006\u0010C\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001c8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\"8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020(8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020.8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006E"}, d2 = {"Lcom/google/protobuf/ValueKt$Dsl;", "", "_builder", "Lcom/google/protobuf/Value$Builder;", "(Lcom/google/protobuf/Value$Builder;)V", "value", "", "boolValue", "getBoolValue", "()Z", "setBoolValue", "(Z)V", "kindCase", "Lcom/google/protobuf/Value$KindCase;", "getKindCase", "()Lcom/google/protobuf/Value$KindCase;", "Lcom/google/protobuf/ListValue;", "listValue", "getListValue", "()Lcom/google/protobuf/ListValue;", "setListValue", "(Lcom/google/protobuf/ListValue;)V", "Lcom/google/protobuf/NullValue;", "nullValue", "getNullValue", "()Lcom/google/protobuf/NullValue;", "setNullValue", "(Lcom/google/protobuf/NullValue;)V", "", "nullValueValue", "getNullValueValue", "()I", "setNullValueValue", "(I)V", "", "numberValue", "getNumberValue", "()D", "setNumberValue", "(D)V", "", "stringValue", "getStringValue", "()Ljava/lang/String;", "setStringValue", "(Ljava/lang/String;)V", "Lcom/google/protobuf/Struct;", "structValue", "getStructValue", "()Lcom/google/protobuf/Struct;", "setStructValue", "(Lcom/google/protobuf/Struct;)V", "_build", "Lcom/google/protobuf/Value;", "clearBoolValue", "", "clearKind", "clearListValue", "clearNullValue", "clearNumberValue", "clearStringValue", "clearStructValue", "hasBoolValue", "hasListValue", "hasNullValue", "hasNumberValue", "hasStringValue", "hasStructValue", "Companion", "java_kotlin-lite-well_known_protos_kotlin_lite"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Value.Builder _builder;

        public /* synthetic */ Dsl(Value.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Value.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/ValueKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/ValueKt$Dsl;", "builder", "Lcom/google/protobuf/Value$Builder;", "java_kotlin-lite-well_known_protos_kotlin_lite"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(Value.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        @PublishedApi
        public final /* synthetic */ Value _build() {
            Value valueBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(valueBuild, "_builder.build()");
            return valueBuild;
        }

        @JvmName(name = "getNullValue")
        @NotNull
        public final NullValue getNullValue() {
            NullValue nullValue = this._builder.getNullValue();
            Intrinsics.checkNotNullExpressionValue(nullValue, "_builder.getNullValue()");
            return nullValue;
        }

        @JvmName(name = "setNullValue")
        public final void setNullValue(@NotNull NullValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setNullValue(value);
        }

        @JvmName(name = "getNullValueValue")
        public final int getNullValueValue() {
            return this._builder.getNullValueValue();
        }

        @JvmName(name = "setNullValueValue")
        public final void setNullValueValue(int i) {
            this._builder.setNullValueValue(i);
        }

        public final void clearNullValue() {
            this._builder.clearNullValue();
        }

        public final boolean hasNullValue() {
            return this._builder.hasNullValue();
        }

        @JvmName(name = "getNumberValue")
        public final double getNumberValue() {
            return this._builder.getNumberValue();
        }

        @JvmName(name = "setNumberValue")
        public final void setNumberValue(double d) {
            this._builder.setNumberValue(d);
        }

        public final void clearNumberValue() {
            this._builder.clearNumberValue();
        }

        public final boolean hasNumberValue() {
            return this._builder.hasNumberValue();
        }

        @JvmName(name = "getStringValue")
        @NotNull
        public final String getStringValue() {
            String stringValue = this._builder.getStringValue();
            Intrinsics.checkNotNullExpressionValue(stringValue, "_builder.getStringValue()");
            return stringValue;
        }

        @JvmName(name = "setStringValue")
        public final void setStringValue(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setStringValue(value);
        }

        public final void clearStringValue() {
            this._builder.clearStringValue();
        }

        public final boolean hasStringValue() {
            return this._builder.hasStringValue();
        }

        @JvmName(name = "getBoolValue")
        public final boolean getBoolValue() {
            return this._builder.getBoolValue();
        }

        @JvmName(name = "setBoolValue")
        public final void setBoolValue(boolean z) {
            this._builder.setBoolValue(z);
        }

        public final void clearBoolValue() {
            this._builder.clearBoolValue();
        }

        public final boolean hasBoolValue() {
            return this._builder.hasBoolValue();
        }

        @JvmName(name = "getStructValue")
        @NotNull
        public final Struct getStructValue() {
            Struct structValue = this._builder.getStructValue();
            Intrinsics.checkNotNullExpressionValue(structValue, "_builder.getStructValue()");
            return structValue;
        }

        @JvmName(name = "setStructValue")
        public final void setStructValue(@NotNull Struct value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setStructValue(value);
        }

        public final void clearStructValue() {
            this._builder.clearStructValue();
        }

        public final boolean hasStructValue() {
            return this._builder.hasStructValue();
        }

        @JvmName(name = "getListValue")
        @NotNull
        public final ListValue getListValue() {
            ListValue listValue = this._builder.getListValue();
            Intrinsics.checkNotNullExpressionValue(listValue, "_builder.getListValue()");
            return listValue;
        }

        @JvmName(name = "setListValue")
        public final void setListValue(@NotNull ListValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setListValue(value);
        }

        public final void clearListValue() {
            this._builder.clearListValue();
        }

        public final boolean hasListValue() {
            return this._builder.hasListValue();
        }

        @JvmName(name = "getKindCase")
        @NotNull
        public final Value.KindCase getKindCase() {
            Value.KindCase kindCase = this._builder.getKindCase();
            Intrinsics.checkNotNullExpressionValue(kindCase, "_builder.getKindCase()");
            return kindCase;
        }

        public final void clearKind() {
            this._builder.clearKind();
        }
    }

    private ValueKt() {
    }
}
