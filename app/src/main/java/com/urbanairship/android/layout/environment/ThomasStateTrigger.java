package com.urbanairship.android.layout.environment;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
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
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, m1836d2 = {"Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "", "id", "", "triggerWhenStateMatches", "Lcom/urbanairship/json/JsonPredicate;", "resetWhenStateMatches", "onTrigger", "Lcom/urbanairship/android/layout/environment/TriggerActions;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonPredicate;Lcom/urbanairship/json/JsonPredicate;Lcom/urbanairship/android/layout/environment/TriggerActions;)V", "getId", "()Ljava/lang/String;", "getOnTrigger", "()Lcom/urbanairship/android/layout/environment/TriggerActions;", "getResetWhenStateMatches", "()Lcom/urbanairship/json/JsonPredicate;", "getTriggerWhenStateMatches", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final /* data */ class ThomasStateTrigger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final TriggerActions onTrigger;
    private final JsonPredicate resetWhenStateMatches;
    private final JsonPredicate triggerWhenStateMatches;

    public static /* synthetic */ ThomasStateTrigger copy$default(ThomasStateTrigger thomasStateTrigger, String str, JsonPredicate jsonPredicate, JsonPredicate jsonPredicate2, TriggerActions triggerActions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thomasStateTrigger.id;
        }
        if ((i & 2) != 0) {
            jsonPredicate = thomasStateTrigger.triggerWhenStateMatches;
        }
        if ((i & 4) != 0) {
            jsonPredicate2 = thomasStateTrigger.resetWhenStateMatches;
        }
        if ((i & 8) != 0) {
            triggerActions = thomasStateTrigger.onTrigger;
        }
        return thomasStateTrigger.copy(str, jsonPredicate, jsonPredicate2, triggerActions);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JsonPredicate getTriggerWhenStateMatches() {
        return this.triggerWhenStateMatches;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JsonPredicate getResetWhenStateMatches() {
        return this.resetWhenStateMatches;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final TriggerActions getOnTrigger() {
        return this.onTrigger;
    }

    @NotNull
    public final ThomasStateTrigger copy(@NotNull String id, @NotNull JsonPredicate triggerWhenStateMatches, @Nullable JsonPredicate resetWhenStateMatches, @NotNull TriggerActions onTrigger) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(triggerWhenStateMatches, "triggerWhenStateMatches");
        Intrinsics.checkNotNullParameter(onTrigger, "onTrigger");
        return new ThomasStateTrigger(id, triggerWhenStateMatches, resetWhenStateMatches, onTrigger);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThomasStateTrigger)) {
            return false;
        }
        ThomasStateTrigger thomasStateTrigger = (ThomasStateTrigger) other;
        return Intrinsics.areEqual(this.id, thomasStateTrigger.id) && Intrinsics.areEqual(this.triggerWhenStateMatches, thomasStateTrigger.triggerWhenStateMatches) && Intrinsics.areEqual(this.resetWhenStateMatches, thomasStateTrigger.resetWhenStateMatches) && Intrinsics.areEqual(this.onTrigger, thomasStateTrigger.onTrigger);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.triggerWhenStateMatches.hashCode()) * 31;
        JsonPredicate jsonPredicate = this.resetWhenStateMatches;
        return ((iHashCode + (jsonPredicate == null ? 0 : jsonPredicate.hashCode())) * 31) + this.onTrigger.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThomasStateTrigger(id=" + this.id + ", triggerWhenStateMatches=" + this.triggerWhenStateMatches + ", resetWhenStateMatches=" + this.resetWhenStateMatches + ", onTrigger=" + this.onTrigger + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ThomasStateTrigger(@NotNull String id, @NotNull JsonPredicate triggerWhenStateMatches, @Nullable JsonPredicate jsonPredicate, @NotNull TriggerActions onTrigger) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(triggerWhenStateMatches, "triggerWhenStateMatches");
        Intrinsics.checkNotNullParameter(onTrigger, "onTrigger");
        this.id = id;
        this.triggerWhenStateMatches = triggerWhenStateMatches;
        this.resetWhenStateMatches = jsonPredicate;
        this.onTrigger = onTrigger;
    }

    public /* synthetic */ ThomasStateTrigger(String str, JsonPredicate jsonPredicate, JsonPredicate jsonPredicate2, TriggerActions triggerActions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonPredicate, (i & 4) != 0 ? null : jsonPredicate2, triggerActions);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final JsonPredicate getTriggerWhenStateMatches() {
        return this.triggerWhenStateMatches;
    }

    @Nullable
    public final JsonPredicate getResetWhenStateMatches() {
        return this.resetWhenStateMatches;
    }

    @NotNull
    public final TriggerActions getOnTrigger() {
        return this.onTrigger;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/environment/ThomasStateTrigger$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nThomasStateTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasStateTrigger.kt\ncom/urbanairship/android/layout/environment/ThomasStateTrigger$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,41:1\n44#2,15:42\n44#2,15:57\n44#2,15:72\n*S KotlinDebug\n*F\n+ 1 ThomasStateTrigger.kt\ncom/urbanairship/android/layout/environment/ThomasStateTrigger$Companion\n*L\n22#1:42,15\n23#1:57,15\n25#1:72,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0293  */
        /* JADX WARN: Code duplicated, block: B:103:0x0299  */
        /* JADX WARN: Code duplicated, block: B:104:0x029d  */
        /* JADX WARN: Code duplicated, block: B:106:0x02a3  */
        /* JADX WARN: Code duplicated, block: B:108:0x02ad  */
        /* JADX WARN: Code duplicated, block: B:110:0x02b3  */
        /* JADX WARN: Code duplicated, block: B:111:0x02b7  */
        /* JADX WARN: Code duplicated, block: B:113:0x02bd  */
        /* JADX WARN: Code duplicated, block: B:115:0x02c9  */
        /* JADX WARN: Code duplicated, block: B:116:0x02d6  */
        /* JADX WARN: Code duplicated, block: B:118:0x02e2  */
        /* JADX WARN: Code duplicated, block: B:119:0x02f0  */
        /* JADX WARN: Code duplicated, block: B:121:0x02fb  */
        /* JADX WARN: Code duplicated, block: B:122:0x030d  */
        /* JADX WARN: Code duplicated, block: B:124:0x0319  */
        /* JADX WARN: Code duplicated, block: B:125:0x0327  */
        /* JADX WARN: Code duplicated, block: B:127:0x0333  */
        /* JADX WARN: Code duplicated, block: B:128:0x0340  */
        /* JADX WARN: Code duplicated, block: B:130:0x034a  */
        /* JADX WARN: Code duplicated, block: B:131:0x0356  */
        /* JADX WARN: Code duplicated, block: B:133:0x0361  */
        /* JADX WARN: Code duplicated, block: B:134:0x0370  */
        /* JADX WARN: Code duplicated, block: B:136:0x037a  */
        /* JADX WARN: Code duplicated, block: B:138:0x0380  */
        /* JADX WARN: Code duplicated, block: B:139:0x0383  */
        /* JADX WARN: Code duplicated, block: B:141:0x0389  */
        /* JADX WARN: Code duplicated, block: B:143:0x0393  */
        /* JADX WARN: Code duplicated, block: B:146:0x039a  */
        /* JADX WARN: Code duplicated, block: B:148:0x03a0  */
        /* JADX WARN: Code duplicated, block: B:150:0x03aa  */
        /* JADX WARN: Code duplicated, block: B:152:0x03b0  */
        /* JADX WARN: Code duplicated, block: B:155:0x03ba  */
        /* JADX WARN: Code duplicated, block: B:157:0x03c0  */
        /* JADX WARN: Code duplicated, block: B:159:0x03e5  */
        /* JADX WARN: Code duplicated, block: B:99:0x0283  */
        /* JADX WARN: Instruction removed from duplicated block: B:157:0x03c0, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:159:0x03e5, please report this as an issue */
        @NotNull
        public final ThomasStateTrigger fromJson(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            String str;
            JsonValue jsonValue;
            JsonPredicate jsonPredicate;
            JsonPredicate jsonPredicate2;
            TriggerActions.Companion companion;
            JsonValue jsonValue2;
            KClass orCreateKotlinClass;
            JsonSerializable jsonValue3;
            JsonMap jsonMapOptMap;
            JsonSerializable jsonSerializableOptList;
            Object objOptString;
            Object objOptString2;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue4 = json.get("identifier");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue4.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue4.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue4.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue4.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue5 = jsonValue4.getJsonValue();
                if (jsonValue5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue5;
            }
            JsonValue jsonValue6 = json.get("trigger_when_state_matches");
            if (jsonValue6 == null) {
                throw new JsonException("Missing required field: 'trigger_when_state_matches" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) && !Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonValue = (JsonValue) Boolean.valueOf(jsonValue6.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "' for field '";
                    jsonValue = (JsonValue) Long.valueOf(jsonValue6.getLong(0L));
                } else {
                    str = "' for field '";
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonValue = (JsonValue) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonValue = (JsonValue) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonValue = (JsonValue) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        jsonValue = (JsonValue) Integer.valueOf(jsonValue6.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonValue = (JsonValue) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        jsonValue = (JsonValue) jsonValue6.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonValue = (JsonValue) jsonValue6.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + str + "trigger_when_state_matches" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue = jsonValue6.getJsonValue();
                    }
                }
                jsonPredicate = JsonPredicate.parse(jsonValue);
                Intrinsics.checkNotNullExpressionValue(jsonPredicate, "parse(...)");
                jsonPredicate2 = JsonPredicate.parse(json.get("reset_when_state_matches"));
                companion = TriggerActions.INSTANCE;
                jsonValue2 = json.get("on_trigger");
                if (jsonValue2 != null) {
                    throw new JsonException("Missing required field: 'on_trigger" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString2 = jsonValue2.optString();
                    if (objOptString2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString = jsonValue2.optString();
                    if (objOptString != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonSerializableOptList = jsonValue2.optList();
                    if (jsonSerializableOptList != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap = jsonValue2.optMap();
                    if (jsonMapOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "on_trigger" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonValue3;
                }
                return new ThomasStateTrigger(strOptString, jsonPredicate, jsonPredicate2, companion.fromJson(jsonMapOptMap));
            }
            jsonValue = (JsonValue) jsonValue6.optString();
            str = "' for field '";
            jsonPredicate = JsonPredicate.parse(jsonValue);
            Intrinsics.checkNotNullExpressionValue(jsonPredicate, "parse(...)");
            jsonPredicate2 = JsonPredicate.parse(json.get("reset_when_state_matches"));
            companion = TriggerActions.INSTANCE;
            jsonValue2 = json.get("on_trigger");
            if (jsonValue2 != null) {
                throw new JsonException("Missing required field: 'on_trigger" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString2 = jsonValue2.optString();
                if (objOptString2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                objOptString = jsonValue2.optString();
                if (objOptString != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue2.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue2.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonSerializableOptList = jsonValue2.optList();
                if (jsonSerializableOptList != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap = jsonValue2.optMap();
                if (jsonMapOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "on_trigger" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue3 = jsonValue2.getJsonValue();
                if (jsonValue3 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonValue3;
            }
            return new ThomasStateTrigger(strOptString, jsonPredicate, jsonPredicate2, companion.fromJson(jsonMapOptMap));
        }
    }
}
