package com.urbanairship.featureflag;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlagInfo;", "Lcom/urbanairship/json/JsonSerializable;", "isEligible", "", "variables", "Lcom/urbanairship/featureflag/FeatureFlagVariables;", "reportingMetadata", "Lcom/urbanairship/json/JsonMap;", "(ZLcom/urbanairship/featureflag/FeatureFlagVariables;Lcom/urbanairship/json/JsonMap;)V", "()Z", "getReportingMetadata", "()Lcom/urbanairship/json/JsonMap;", "getVariables", "()Lcom/urbanairship/featureflag/FeatureFlagVariables;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final /* data */ class DeferredFlagInfo implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isEligible;
    private final JsonMap reportingMetadata;
    private final FeatureFlagVariables variables;

    public static /* synthetic */ DeferredFlagInfo copy$default(DeferredFlagInfo deferredFlagInfo, boolean z, FeatureFlagVariables featureFlagVariables, JsonMap jsonMap, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deferredFlagInfo.isEligible;
        }
        if ((i & 2) != 0) {
            featureFlagVariables = deferredFlagInfo.variables;
        }
        if ((i & 4) != 0) {
            jsonMap = deferredFlagInfo.reportingMetadata;
        }
        return deferredFlagInfo.copy(z, featureFlagVariables, jsonMap);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsEligible() {
        return this.isEligible;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FeatureFlagVariables getVariables() {
        return this.variables;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    public final DeferredFlagInfo copy(boolean isEligible, @Nullable FeatureFlagVariables variables, @NotNull JsonMap reportingMetadata) {
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        return new DeferredFlagInfo(isEligible, variables, reportingMetadata);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeferredFlagInfo)) {
            return false;
        }
        DeferredFlagInfo deferredFlagInfo = (DeferredFlagInfo) other;
        return this.isEligible == deferredFlagInfo.isEligible && Intrinsics.areEqual(this.variables, deferredFlagInfo.variables) && Intrinsics.areEqual(this.reportingMetadata, deferredFlagInfo.reportingMetadata);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isEligible) * 31;
        FeatureFlagVariables featureFlagVariables = this.variables;
        return ((iHashCode + (featureFlagVariables == null ? 0 : featureFlagVariables.hashCode())) * 31) + this.reportingMetadata.hashCode();
    }

    @NotNull
    public String toString() {
        return "DeferredFlagInfo(isEligible=" + this.isEligible + ", variables=" + this.variables + ", reportingMetadata=" + this.reportingMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DeferredFlagInfo(boolean z, @Nullable FeatureFlagVariables featureFlagVariables, @NotNull JsonMap reportingMetadata) {
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        this.isEligible = z;
        this.variables = featureFlagVariables;
        this.reportingMetadata = reportingMetadata;
    }

    public final boolean isEligible() {
        return this.isEligible;
    }

    @Nullable
    public final FeatureFlagVariables getVariables() {
        return this.variables;
    }

    @NotNull
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlagInfo$Companion;", "", "()V", "KEY_IS_ELIGIBLE", "", "KEY_REPORTING_METADATA", "KEY_VARIABLES", "fromJson", "Lcom/urbanairship/featureflag/DeferredFlagInfo;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlagInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n44#2,15:219\n79#2,16:234\n44#2,15:251\n1#3:250\n*S KotlinDebug\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlagInfo$Companion\n*L\n202#1:219,15\n203#1:234,16\n204#1:251,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0296  */
        /* JADX WARN: Code duplicated, block: B:105:0x02a4  */
        /* JADX WARN: Code duplicated, block: B:107:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:109:0x02ba  */
        /* JADX WARN: Code duplicated, block: B:110:0x02be  */
        /* JADX WARN: Code duplicated, block: B:112:0x02c4  */
        /* JADX WARN: Code duplicated, block: B:114:0x02ce  */
        /* JADX WARN: Code duplicated, block: B:116:0x02d4  */
        /* JADX WARN: Code duplicated, block: B:117:0x02d8  */
        /* JADX WARN: Code duplicated, block: B:119:0x02de  */
        /* JADX WARN: Code duplicated, block: B:121:0x02ea  */
        /* JADX WARN: Code duplicated, block: B:122:0x02f7  */
        /* JADX WARN: Code duplicated, block: B:124:0x0303  */
        /* JADX WARN: Code duplicated, block: B:125:0x0311  */
        /* JADX WARN: Code duplicated, block: B:127:0x031d  */
        /* JADX WARN: Code duplicated, block: B:128:0x032d  */
        /* JADX WARN: Code duplicated, block: B:130:0x0339  */
        /* JADX WARN: Code duplicated, block: B:131:0x0347  */
        /* JADX WARN: Code duplicated, block: B:133:0x0353  */
        /* JADX WARN: Code duplicated, block: B:134:0x0360  */
        /* JADX WARN: Code duplicated, block: B:136:0x036a  */
        /* JADX WARN: Code duplicated, block: B:137:0x0376  */
        /* JADX WARN: Code duplicated, block: B:139:0x0381  */
        /* JADX WARN: Code duplicated, block: B:140:0x0390  */
        /* JADX WARN: Code duplicated, block: B:142:0x039a  */
        /* JADX WARN: Code duplicated, block: B:144:0x03a0  */
        /* JADX WARN: Code duplicated, block: B:145:0x03a3  */
        /* JADX WARN: Code duplicated, block: B:147:0x03a9  */
        /* JADX WARN: Code duplicated, block: B:149:0x03b3  */
        /* JADX WARN: Code duplicated, block: B:152:0x03ba  */
        /* JADX WARN: Code duplicated, block: B:154:0x03c0  */
        /* JADX WARN: Code duplicated, block: B:156:0x03ca  */
        /* JADX WARN: Code duplicated, block: B:158:0x03d0  */
        /* JADX WARN: Code duplicated, block: B:161:0x03d8  */
        /* JADX WARN: Code duplicated, block: B:163:0x03de  */
        /* JADX WARN: Code duplicated, block: B:165:0x0404  */
        /* JADX WARN: Instruction removed from duplicated block: B:163:0x03de, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:165:0x0404, please report this as an issue */
        @NotNull
        public final DeferredFlagInfo fromJson(@NotNull JsonValue jsonValue) throws JsonException {
            Boolean boolValueOf;
            String str;
            JsonMap jsonMapOptMap;
            FeatureFlagVariables featureFlagVariablesFromJson;
            JsonValue jsonValue2;
            KClass orCreateKotlinClass;
            JsonSerializable jsonValue3;
            JsonMap jsonMapOptMap2;
            JsonSerializable jsonSerializableOptList;
            Object objOptString;
            Object objOptString2;
            Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
            JsonMap jsonMapOptMap3 = jsonValue.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap3, "optMap(...)");
            JsonValue jsonValue4 = jsonMapOptMap3.get("is_eligible");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'is_eligible" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString3 = jsonValue4.optString();
                if (objOptString3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString3;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString4 = jsonValue4.optString();
                if (objOptString4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString4;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                boolValueOf = Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                boolValueOf = (Boolean) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                boolValueOf = (Boolean) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                boolValueOf = (Boolean) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                boolValueOf = (Boolean) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue4.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue4.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'is_eligible" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue5 = jsonValue4.toJsonValue();
                if (jsonValue5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) jsonValue5;
            }
            boolean zBooleanValue = boolValueOf.booleanValue();
            JsonValue jsonValue6 = jsonMapOptMap3.get("variables");
            if (jsonValue6 == null) {
                jsonMapOptMap = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) && !Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue6.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "' for field '";
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue6.getLong(0L));
                    } else {
                        str = "' for field '";
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue6.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            jsonMapOptMap = (JsonMap) jsonValue6.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap = jsonValue6.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "variables" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonMapOptMap = (JsonMap) jsonValue6.toJsonValue();
                        }
                    }
                    featureFlagVariablesFromJson = jsonMapOptMap != null ? FeatureFlagVariables.INSTANCE.fromJson(jsonMapOptMap) : null;
                    jsonValue2 = jsonMapOptMap3.get("reporting_metadata");
                    if (jsonValue2 != null) {
                        throw new JsonException("Missing required field: 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue2.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap2 = (JsonMap) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        objOptString = jsonValue2.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap2 = (JsonMap) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap2 = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap2 = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        jsonSerializableOptList = jsonValue2.optList();
                        if (jsonSerializableOptList != null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap2 = (JsonMap) jsonSerializableOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap2 = jsonValue2.optMap();
                        if (jsonMapOptMap2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue3 = jsonValue2.toJsonValue();
                        if (jsonValue3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap2 = (JsonMap) jsonValue3;
                    }
                    return new DeferredFlagInfo(zBooleanValue, featureFlagVariablesFromJson, jsonMapOptMap2);
                }
                jsonMapOptMap = (JsonMap) jsonValue6.optString();
            }
            str = "' for field '";
            if (jsonMapOptMap != null) {
            }
            jsonValue2 = jsonMapOptMap3.get("reporting_metadata");
            if (jsonValue2 != null) {
                throw new JsonException("Missing required field: 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString2 = jsonValue2.optString();
                if (objOptString2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                objOptString = jsonValue2.optString();
                if (objOptString != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue2.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue2.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap2 = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap2 = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonSerializableOptList = jsonValue2.optList();
                if (jsonSerializableOptList != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap2 = jsonValue2.optMap();
                if (jsonMapOptMap2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue3 = jsonValue2.toJsonValue();
                if (jsonValue3 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) jsonValue3;
            }
            return new DeferredFlagInfo(zBooleanValue, featureFlagVariablesFromJson, jsonMapOptMap2);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() throws JsonException {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("is_eligible", Boolean.valueOf(this.isEligible)), TuplesKt.m1842to("variables", this.variables), TuplesKt.m1842to("reporting_metadata", this.reportingMetadata)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
