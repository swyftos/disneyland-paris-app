package com.urbanairship.android.layout.property;

import androidx.annotation.Dimension;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.shape.Shape;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \t2\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle;", "", "type", "Lcom/urbanairship/android/layout/property/ScoreType;", "(Lcom/urbanairship/android/layout/property/ScoreType;)V", "getType", "()Lcom/urbanairship/android/layout/property/ScoreType;", "Binding", "Bindings", "Companion", "NumberRange", "WrappingNumberRange", "Lcom/urbanairship/android/layout/property/ScoreStyle$NumberRange;", "Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ScoreStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final ScoreType type;

    public /* synthetic */ ScoreStyle(ScoreType scoreType, DefaultConstructorMarker defaultConstructorMarker) {
        this(scoreType);
    }

    private ScoreStyle(ScoreType scoreType) {
        this.type = scoreType;
    }

    @NotNull
    public final ScoreType getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$NumberRange;", "Lcom/urbanairship/android/layout/property/ScoreStyle;", ViewProps.START, "", ViewProps.END, "spacing", "bindings", "Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", "(IIILcom/urbanairship/android/layout/property/ScoreStyle$Bindings;)V", "getBindings", "()Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", "getEnd", "()I", "getSpacing", "getStart", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NumberRange extends ScoreStyle {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Bindings bindings;
        private final int end;
        private final int spacing;
        private final int start;

        public static /* synthetic */ NumberRange copy$default(NumberRange numberRange, int i, int i2, int i3, Bindings bindings, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = numberRange.start;
            }
            if ((i4 & 2) != 0) {
                i2 = numberRange.end;
            }
            if ((i4 & 4) != 0) {
                i3 = numberRange.spacing;
            }
            if ((i4 & 8) != 0) {
                bindings = numberRange.bindings;
            }
            return numberRange.copy(i, i2, i3, bindings);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSpacing() {
            return this.spacing;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final Bindings getBindings() {
            return this.bindings;
        }

        @NotNull
        public final NumberRange copy(int start, int end, int spacing, @NotNull Bindings bindings) {
            Intrinsics.checkNotNullParameter(bindings, "bindings");
            return new NumberRange(start, end, spacing, bindings);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NumberRange)) {
                return false;
            }
            NumberRange numberRange = (NumberRange) other;
            return this.start == numberRange.start && this.end == numberRange.end && this.spacing == numberRange.spacing && Intrinsics.areEqual(this.bindings, numberRange.bindings);
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + Integer.hashCode(this.spacing)) * 31) + this.bindings.hashCode();
        }

        @NotNull
        public String toString() {
            return "NumberRange(start=" + this.start + ", end=" + this.end + ", spacing=" + this.spacing + ", bindings=" + this.bindings + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        @Dimension(unit = 0)
        public final int getSpacing() {
            return this.spacing;
        }

        @NotNull
        public final Bindings getBindings() {
            return this.bindings;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NumberRange(int i, int i2, int i3, @NotNull Bindings bindings) {
            super(ScoreType.NUMBER_RANGE, null);
            Intrinsics.checkNotNullParameter(bindings, "bindings");
            this.start = i;
            this.end = i2;
            this.spacing = i3;
            this.bindings = bindings;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$NumberRange$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ScoreStyle;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ScoreStyle fromJson(@NotNull JsonMap json) throws JsonException {
                Intrinsics.checkNotNullParameter(json, "json");
                int i = json.opt(ViewProps.START).getInt(0);
                int i2 = json.opt(ViewProps.END).getInt(10);
                int i3 = json.opt("spacing").getInt(0);
                JsonMap jsonMapOptMap = json.opt("bindings").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                return new NumberRange(i, i2, i3, Bindings.INSTANCE.fromJson(jsonMapOptMap));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ScoreStyle;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nScoreStyle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScoreStyle.kt\ncom/urbanairship/android/layout/property/ScoreStyle$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n44#2,15:168\n79#2,16:184\n1#3:183\n*S KotlinDebug\n*F\n+ 1 ScoreStyle.kt\ncom/urbanairship/android/layout/property/ScoreStyle$Companion\n*L\n149#1:168,15\n153#1:184,16\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ScoreType.values().length];
                try {
                    iArr[ScoreType.NUMBER_RANGE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ScoreStyle fromJson(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            JsonMap jsonMapOptMap;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("type");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            if (WhenMappings.$EnumSwitchMapping$0[ScoreType.INSTANCE.from(strOptString).ordinal()] == 1) {
                JsonValue jsonValue3 = json.get("wrapping");
                if (jsonValue3 == null) {
                    jsonMapOptMap = null;
                } else {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString = jsonValue3.optString();
                        if (objOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString2 = jsonValue3.optString();
                        if (objOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList = jsonValue3.optList();
                        if (jsonSerializableOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap = jsonValue3.optMap();
                        if (jsonMapOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'wrapping" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        JsonSerializable jsonValue4 = jsonValue3.getJsonValue();
                        if (jsonValue4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonValue4;
                    }
                }
                if ((jsonMapOptMap != null ? WrappingNumberRange.Wrapping.INSTANCE.fromJson(jsonMapOptMap) : null) != null) {
                    return WrappingNumberRange.INSTANCE.fromJson(json);
                }
                return NumberRange.INSTANCE.fromJson(json);
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange;", "Lcom/urbanairship/android/layout/property/ScoreStyle;", ViewProps.START, "", ViewProps.END, "spacing", "bindings", "Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", "wrapping", "Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Wrapping;", "(IIILcom/urbanairship/android/layout/property/ScoreStyle$Bindings;Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Wrapping;)V", "getBindings", "()Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", "getEnd", "()I", "getSpacing", "getStart", "getWrapping", "()Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Wrapping;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "Companion", "Wrapping", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WrappingNumberRange extends ScoreStyle {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Bindings bindings;
        private final int end;
        private final int spacing;
        private final int start;
        private final Wrapping wrapping;

        public static /* synthetic */ WrappingNumberRange copy$default(WrappingNumberRange wrappingNumberRange, int i, int i2, int i3, Bindings bindings, Wrapping wrapping, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = wrappingNumberRange.start;
            }
            if ((i4 & 2) != 0) {
                i2 = wrappingNumberRange.end;
            }
            int i5 = i2;
            if ((i4 & 4) != 0) {
                i3 = wrappingNumberRange.spacing;
            }
            int i6 = i3;
            if ((i4 & 8) != 0) {
                bindings = wrappingNumberRange.bindings;
            }
            Bindings bindings2 = bindings;
            if ((i4 & 16) != 0) {
                wrapping = wrappingNumberRange.wrapping;
            }
            return wrappingNumberRange.copy(i, i5, i6, bindings2, wrapping);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSpacing() {
            return this.spacing;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final Bindings getBindings() {
            return this.bindings;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final Wrapping getWrapping() {
            return this.wrapping;
        }

        @NotNull
        public final WrappingNumberRange copy(int start, int end, int spacing, @NotNull Bindings bindings, @NotNull Wrapping wrapping) {
            Intrinsics.checkNotNullParameter(bindings, "bindings");
            Intrinsics.checkNotNullParameter(wrapping, "wrapping");
            return new WrappingNumberRange(start, end, spacing, bindings, wrapping);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WrappingNumberRange)) {
                return false;
            }
            WrappingNumberRange wrappingNumberRange = (WrappingNumberRange) other;
            return this.start == wrappingNumberRange.start && this.end == wrappingNumberRange.end && this.spacing == wrappingNumberRange.spacing && Intrinsics.areEqual(this.bindings, wrappingNumberRange.bindings) && Intrinsics.areEqual(this.wrapping, wrappingNumberRange.wrapping);
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + Integer.hashCode(this.spacing)) * 31) + this.bindings.hashCode()) * 31) + this.wrapping.hashCode();
        }

        @NotNull
        public String toString() {
            return "WrappingNumberRange(start=" + this.start + ", end=" + this.end + ", spacing=" + this.spacing + ", bindings=" + this.bindings + ", wrapping=" + this.wrapping + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        @Dimension(unit = 0)
        public final int getSpacing() {
            return this.spacing;
        }

        @NotNull
        public final Bindings getBindings() {
            return this.bindings;
        }

        @NotNull
        public final Wrapping getWrapping() {
            return this.wrapping;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WrappingNumberRange(int i, int i2, int i3, @NotNull Bindings bindings, @NotNull Wrapping wrapping) {
            super(ScoreType.NUMBER_RANGE, null);
            Intrinsics.checkNotNullParameter(bindings, "bindings");
            Intrinsics.checkNotNullParameter(wrapping, "wrapping");
            this.start = i;
            this.end = i2;
            this.spacing = i3;
            this.bindings = bindings;
            this.wrapping = wrapping;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Wrapping;", "", "maxItemsPerLine", "", "lineSpacing", "(II)V", "getLineSpacing", "()I", "getMaxItemsPerLine", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Wrapping {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final int lineSpacing;
            private final int maxItemsPerLine;

            public static /* synthetic */ Wrapping copy$default(Wrapping wrapping, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = wrapping.maxItemsPerLine;
                }
                if ((i3 & 2) != 0) {
                    i2 = wrapping.lineSpacing;
                }
                return wrapping.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMaxItemsPerLine() {
                return this.maxItemsPerLine;
            }

            /* renamed from: component2, reason: from getter */
            public final int getLineSpacing() {
                return this.lineSpacing;
            }

            @NotNull
            public final Wrapping copy(int maxItemsPerLine, int lineSpacing) {
                return new Wrapping(maxItemsPerLine, lineSpacing);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Wrapping)) {
                    return false;
                }
                Wrapping wrapping = (Wrapping) other;
                return this.maxItemsPerLine == wrapping.maxItemsPerLine && this.lineSpacing == wrapping.lineSpacing;
            }

            public int hashCode() {
                return (Integer.hashCode(this.maxItemsPerLine) * 31) + Integer.hashCode(this.lineSpacing);
            }

            @NotNull
            public String toString() {
                return "Wrapping(maxItemsPerLine=" + this.maxItemsPerLine + ", lineSpacing=" + this.lineSpacing + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Wrapping(int i, int i2) {
                this.maxItemsPerLine = i;
                this.lineSpacing = i2;
            }

            public final int getMaxItemsPerLine() {
                return this.maxItemsPerLine;
            }

            @Dimension(unit = 0)
            public final int getLineSpacing() {
                return this.lineSpacing;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Wrapping$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Wrapping;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final Wrapping fromJson(@NotNull JsonMap json) {
                    Intrinsics.checkNotNullParameter(json, "json");
                    return new Wrapping(json.opt("max_items_per_line").getInt(1), json.opt("line_spacing").getInt(0));
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ScoreStyle;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nScoreStyle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScoreStyle.kt\ncom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,167:1\n44#2,15:168\n*S KotlinDebug\n*F\n+ 1 ScoreStyle.kt\ncom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange$Companion\n*L\n94#1:168,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ScoreStyle fromJson(@NotNull JsonMap json) throws JsonException {
                JsonMap jsonMapOptMap;
                Intrinsics.checkNotNullParameter(json, "json");
                int i = json.opt(ViewProps.START).getInt(0);
                int i2 = json.opt(ViewProps.END).getInt(10);
                int i3 = json.opt("spacing").getInt(0);
                JsonMap jsonMapOptMap2 = json.opt("bindings").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
                Bindings bindingsFromJson = Bindings.INSTANCE.fromJson(jsonMapOptMap2);
                JsonValue jsonValue = json.get("wrapping");
                if (jsonValue == null) {
                    throw new JsonException("Missing required field: 'wrapping" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList = jsonValue.optList();
                    if (jsonSerializableOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap = jsonValue.optMap();
                    if (jsonMapOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'wrapping" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonValue2;
                }
                return new WrappingNumberRange(i, i2, i3, bindingsFromJson, Wrapping.INSTANCE.fromJson(jsonMapOptMap));
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", "", "selected", "Lcom/urbanairship/android/layout/property/ScoreStyle$Binding;", "unselected", "(Lcom/urbanairship/android/layout/property/ScoreStyle$Binding;Lcom/urbanairship/android/layout/property/ScoreStyle$Binding;)V", "getSelected", "()Lcom/urbanairship/android/layout/property/ScoreStyle$Binding;", "getUnselected", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Bindings {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Binding selected;
        private final Binding unselected;

        public static /* synthetic */ Bindings copy$default(Bindings bindings, Binding binding, Binding binding2, int i, Object obj) {
            if ((i & 1) != 0) {
                binding = bindings.selected;
            }
            if ((i & 2) != 0) {
                binding2 = bindings.unselected;
            }
            return bindings.copy(binding, binding2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Binding getSelected() {
            return this.selected;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final Binding getUnselected() {
            return this.unselected;
        }

        @NotNull
        public final Bindings copy(@NotNull Binding selected, @NotNull Binding unselected) {
            Intrinsics.checkNotNullParameter(selected, "selected");
            Intrinsics.checkNotNullParameter(unselected, "unselected");
            return new Bindings(selected, unselected);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bindings)) {
                return false;
            }
            Bindings bindings = (Bindings) other;
            return Intrinsics.areEqual(this.selected, bindings.selected) && Intrinsics.areEqual(this.unselected, bindings.unselected);
        }

        public int hashCode() {
            return (this.selected.hashCode() * 31) + this.unselected.hashCode();
        }

        @NotNull
        public String toString() {
            return "Bindings(selected=" + this.selected + ", unselected=" + this.unselected + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Bindings(@NotNull Binding selected, @NotNull Binding unselected) {
            Intrinsics.checkNotNullParameter(selected, "selected");
            Intrinsics.checkNotNullParameter(unselected, "unselected");
            this.selected = selected;
            this.unselected = unselected;
        }

        @NotNull
        public final Binding getSelected() {
            return this.selected;
        }

        @NotNull
        public final Binding getUnselected() {
            return this.unselected;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Bindings fromJson(@NotNull JsonMap json) throws JsonException {
                Intrinsics.checkNotNullParameter(json, "json");
                JsonMap jsonMapOptMap = json.opt("selected").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                JsonMap jsonMapOptMap2 = json.opt("unselected").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
                Binding.Companion companion = Binding.INSTANCE;
                return new Bindings(companion.fromJson(jsonMapOptMap), companion.fromJson(jsonMapOptMap2));
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$Binding;", "", "shapes", "", "Lcom/urbanairship/android/layout/shape/Shape;", "textAppearance", "Lcom/urbanairship/android/layout/property/TextAppearance;", "(Ljava/util/List;Lcom/urbanairship/android/layout/property/TextAppearance;)V", "getShapes", "()Ljava/util/List;", "getTextAppearance", "()Lcom/urbanairship/android/layout/property/TextAppearance;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Binding {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final List shapes;
        private final TextAppearance textAppearance;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Binding copy$default(Binding binding, List list, TextAppearance textAppearance, int i, Object obj) {
            if ((i & 1) != 0) {
                list = binding.shapes;
            }
            if ((i & 2) != 0) {
                textAppearance = binding.textAppearance;
            }
            return binding.copy(list, textAppearance);
        }

        @NotNull
        public final List<Shape> component1() {
            return this.shapes;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final TextAppearance getTextAppearance() {
            return this.textAppearance;
        }

        @NotNull
        public final Binding copy(@NotNull List<? extends Shape> shapes, @NotNull TextAppearance textAppearance) {
            Intrinsics.checkNotNullParameter(shapes, "shapes");
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            return new Binding(shapes, textAppearance);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Binding)) {
                return false;
            }
            Binding binding = (Binding) other;
            return Intrinsics.areEqual(this.shapes, binding.shapes) && Intrinsics.areEqual(this.textAppearance, binding.textAppearance);
        }

        public int hashCode() {
            return (this.shapes.hashCode() * 31) + this.textAppearance.hashCode();
        }

        @NotNull
        public String toString() {
            return "Binding(shapes=" + this.shapes + ", textAppearance=" + this.textAppearance + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Binding(@NotNull List<? extends Shape> shapes, @NotNull TextAppearance textAppearance) {
            Intrinsics.checkNotNullParameter(shapes, "shapes");
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            this.shapes = shapes;
            this.textAppearance = textAppearance;
        }

        @NotNull
        public final List<Shape> getShapes() {
            return this.shapes;
        }

        @NotNull
        public final TextAppearance getTextAppearance() {
            return this.textAppearance;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreStyle$Binding$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ScoreStyle$Binding;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Binding fromJson(@NotNull JsonMap json) throws JsonException {
                Intrinsics.checkNotNullParameter(json, "json");
                JsonList jsonListOptList = json.opt("shapes").optList();
                Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
                JsonMap jsonMapOptMap = json.opt("text_appearance").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                ArrayList arrayList = new ArrayList();
                int size = jsonListOptList.size();
                for (int i = 0; i < size; i++) {
                    JsonMap jsonMapOptMap2 = jsonListOptList.get(i).optMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
                    Shape shapeFromJson = Shape.fromJson(jsonMapOptMap2);
                    Intrinsics.checkNotNullExpressionValue(shapeFromJson, "fromJson(...)");
                    arrayList.add(shapeFromJson);
                }
                TextAppearance textAppearanceFromJson = TextAppearance.fromJson(jsonMapOptMap);
                Intrinsics.checkNotNullExpressionValue(textAppearanceFromJson, "fromJson(...)");
                return new Binding(arrayList, textAppearanceFromJson);
            }
        }
    }
}
