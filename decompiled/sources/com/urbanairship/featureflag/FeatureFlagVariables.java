package com.urbanairship.featureflag;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.featureflag.VariablesVariant;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagVariables;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "Companion", "Fixed", "Variant", "Lcom/urbanairship/featureflag/FeatureFlagVariables$Fixed;", "Lcom/urbanairship/featureflag/FeatureFlagVariables$Variant;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FeatureFlagVariables implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ FeatureFlagVariables(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagVariables$Fixed;", "Lcom/urbanairship/featureflag/FeatureFlagVariables;", "data", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getData", "()Lcom/urbanairship/json/JsonMap;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Fixed extends FeatureFlagVariables {
        private final JsonMap data;

        public static /* synthetic */ Fixed copy$default(Fixed fixed, JsonMap jsonMap, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonMap = fixed.data;
            }
            return fixed.copy(jsonMap);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final JsonMap getData() {
            return this.data;
        }

        @NotNull
        public final Fixed copy(@Nullable JsonMap data) {
            return new Fixed(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Fixed) && Intrinsics.areEqual(this.data, ((Fixed) other).data);
        }

        public int hashCode() {
            JsonMap jsonMap = this.data;
            if (jsonMap == null) {
                return 0;
            }
            return jsonMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "Fixed(data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Fixed(@Nullable JsonMap jsonMap) {
            super(null);
            this.data = jsonMap;
        }

        @Nullable
        public final JsonMap getData() {
            return this.data;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() throws JsonException {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", VariableType.FIXED.getJsonValue()), TuplesKt.to("data", this.data)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    private FeatureFlagVariables() {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagVariables$Variant;", "Lcom/urbanairship/featureflag/FeatureFlagVariables;", "variantVariables", "", "Lcom/urbanairship/featureflag/VariablesVariant;", "(Ljava/util/List;)V", "getVariantVariables", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Variant extends FeatureFlagVariables {
        private final List variantVariables;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Variant copy$default(Variant variant, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = variant.variantVariables;
            }
            return variant.copy(list);
        }

        @NotNull
        public final List<VariablesVariant> component1() {
            return this.variantVariables;
        }

        @NotNull
        public final Variant copy(@NotNull List<VariablesVariant> variantVariables) {
            Intrinsics.checkNotNullParameter(variantVariables, "variantVariables");
            return new Variant(variantVariables);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Variant) && Intrinsics.areEqual(this.variantVariables, ((Variant) other).variantVariables);
        }

        public int hashCode() {
            return this.variantVariables.hashCode();
        }

        @NotNull
        public String toString() {
            return "Variant(variantVariables=" + this.variantVariables + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Variant(@NotNull List<VariablesVariant> variantVariables) {
            super(null);
            Intrinsics.checkNotNullParameter(variantVariables, "variantVariables");
            this.variantVariables = variantVariables;
        }

        @NotNull
        public final List<VariablesVariant> getVariantVariables() {
            return this.variantVariables;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() throws JsonException {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", VariableType.VARIANTS.getJsonValue()), TuplesKt.to("variants", this.variantVariables)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagVariables$Companion;", "", "()V", "KEY_DATA", "", "KEY_TYPE", "KEY_VARIANTS", "fromJson", "Lcom/urbanairship/featureflag/FeatureFlagVariables;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFeatureFlagInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/FeatureFlagVariables$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,401:1\n44#2,15:402\n79#2,16:419\n44#2,15:435\n288#3,2:417\n1549#3:450\n1620#3,3:451\n*S KotlinDebug\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/FeatureFlagVariables$Companion\n*L\n54#1:402,15\n62#1:419,16\n66#1:435,15\n56#1:417,2\n66#1:450\n66#1:451,3\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[VariableType.values().length];
                try {
                    iArr[VariableType.FIXED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[VariableType.VARIANTS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeatureFlagVariables fromJson(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            JsonMap jsonMap;
            Object next;
            JsonMap jsonMapOptMap;
            JsonList jsonListOptList;
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
                Object jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            Iterator<E> it = VariableType.getEntries().iterator();
            while (true) {
                jsonMap = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((VariableType) next).getJsonValue(), strOptString)) {
                    break;
                }
            }
            VariableType variableType = (VariableType) next;
            if (variableType == null) {
                throw new JsonException("can't parse type from " + json);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[variableType.ordinal()];
            if (i == 1) {
                JsonValue jsonValue3 = json.get("data");
                if (jsonValue3 != null) {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        jsonMapOptMap = (JsonMap) jsonValue3.optString();
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
                        jsonMapOptMap = (JsonMap) jsonValue3.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap = jsonValue3.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'data" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonMapOptMap = (JsonMap) jsonValue3.toJsonValue();
                    }
                    jsonMap = jsonMapOptMap;
                }
                return new Fixed(jsonMap);
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            JsonValue jsonValue4 = json.get("variants");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'variants" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonList.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonListOptList = (JsonList) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonListOptList = (JsonList) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonListOptList = (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonListOptList = (JsonList) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonListOptList = (JsonList) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonListOptList = (JsonList) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonListOptList = (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonListOptList = jsonValue4.optList();
                if (jsonListOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                JsonSerializable jsonSerializableOptMap = jsonValue4.optMap();
                if (jsonSerializableOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) jsonSerializableOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field 'variants" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                JsonSerializable jsonValue5 = jsonValue4.toJsonValue();
                if (jsonValue5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) jsonValue5;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
            for (JsonValue jsonValue6 : jsonListOptList) {
                VariablesVariant.Companion companion = VariablesVariant.INSTANCE;
                JsonMap jsonMapRequireMap = jsonValue6.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                arrayList.add(companion.fromJson(jsonMapRequireMap));
            }
            return new Variant(arrayList);
        }

        private Companion() {
        }
    }
}
