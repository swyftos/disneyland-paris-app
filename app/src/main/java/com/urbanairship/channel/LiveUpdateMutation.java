package com.urbanairship.channel;

import androidx.annotation.RestrictTo;
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
import com.urbanairship.util.Clock;
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
@Metadata(m1835d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0003X¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\b\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, m1836d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation;", "Lcom/urbanairship/json/JsonSerializable;", "action", "", "(Ljava/lang/String;)V", "actionTime", "", "getActionTime", "()J", "name", "getName", "()Ljava/lang/String;", "startTime", "getStartTime", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Remove", "Set", "Lcom/urbanairship/channel/LiveUpdateMutation$Remove;", "Lcom/urbanairship/channel/LiveUpdateMutation$Set;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class LiveUpdateMutation implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String action;

    public /* synthetic */ LiveUpdateMutation(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    protected abstract long getActionTime();

    @NotNull
    protected abstract String getName();

    protected abstract long getStartTime();

    private LiveUpdateMutation(String str) {
        this.action = str;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, m1836d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation$Set;", "Lcom/urbanairship/channel/LiveUpdateMutation;", "name", "", "startTime", "", "actionTime", "(Ljava/lang/String;JJ)V", "getActionTime", "()J", "getName", "()Ljava/lang/String;", "getStartTime", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Set extends LiveUpdateMutation {
        private final long actionTime;
        private final String name;
        private final long startTime;

        @Override // com.urbanairship.channel.LiveUpdateMutation
        @NotNull
        protected String getName() {
            return this.name;
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getStartTime() {
            return this.startTime;
        }

        public /* synthetic */ Set(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, (i & 4) != 0 ? Clock.DEFAULT_CLOCK.currentTimeMillis() : j2);
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getActionTime() {
            return this.actionTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Set(@NotNull String name, long j, long j2) {
            super(AttributeMutation.ATTRIBUTE_ACTION_SET, null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.startTime = j;
            this.actionTime = j2;
        }
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, m1836d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation$Remove;", "Lcom/urbanairship/channel/LiveUpdateMutation;", "name", "", "startTime", "", "actionTime", "(Ljava/lang/String;JJ)V", "getActionTime", "()J", "getName", "()Ljava/lang/String;", "getStartTime", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Remove extends LiveUpdateMutation {
        private final long actionTime;
        private final String name;
        private final long startTime;

        @Override // com.urbanairship.channel.LiveUpdateMutation
        @NotNull
        protected String getName() {
            return this.name;
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getStartTime() {
            return this.startTime;
        }

        public /* synthetic */ Remove(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, (i & 4) != 0 ? Clock.DEFAULT_CLOCK.currentTimeMillis() : j2);
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getActionTime() {
            return this.actionTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Remove(@NotNull String name, long j, long j2) {
            super(AttributeMutation.ATTRIBUTE_ACTION_REMOVE, null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.startTime = j;
            this.actionTime = j2;
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("action", this.action), TuplesKt.m1842to("name", getName()), TuplesKt.m1842to("start_ts_ms", Long.valueOf(getStartTime())), TuplesKt.m1842to("action_ts_ms", Long.valueOf(getActionTime()))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1836d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation$Companion;", "", "()V", "ACTION_REMOVE", "", "ACTION_SET", "KEY_ACTION", "KEY_ACTION_TS", "KEY_NAME", "KEY_START_TS", "fromJson", "Lcom/urbanairship/channel/LiveUpdateMutation;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nLiveUpdateMutation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateMutation.kt\ncom/urbanairship/channel/LiveUpdateMutation$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,90:1\n44#2,15:91\n44#2,15:106\n44#2,15:121\n44#2,15:136\n*S KotlinDebug\n*F\n+ 1 LiveUpdateMutation.kt\ncom/urbanairship/channel/LiveUpdateMutation$Companion\n*L\n77#1:91,15\n78#1:106,15\n79#1:121,15\n80#1:136,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:117:0x029a  */
        /* JADX WARN: Code duplicated, block: B:119:0x02af  */
        /* JADX WARN: Code duplicated, block: B:121:0x02b5  */
        /* JADX WARN: Code duplicated, block: B:124:0x02bc  */
        /* JADX WARN: Code duplicated, block: B:126:0x02c2  */
        /* JADX WARN: Code duplicated, block: B:128:0x02cc  */
        /* JADX WARN: Code duplicated, block: B:130:0x02d2  */
        /* JADX WARN: Code duplicated, block: B:131:0x02d5  */
        /* JADX WARN: Code duplicated, block: B:133:0x02db  */
        /* JADX WARN: Code duplicated, block: B:135:0x02e7  */
        /* JADX WARN: Code duplicated, block: B:136:0x02f3  */
        /* JADX WARN: Code duplicated, block: B:138:0x02ff  */
        /* JADX WARN: Code duplicated, block: B:139:0x030e  */
        /* JADX WARN: Code duplicated, block: B:141:0x031b  */
        /* JADX WARN: Code duplicated, block: B:142:0x032c  */
        /* JADX WARN: Code duplicated, block: B:144:0x0338  */
        /* JADX WARN: Code duplicated, block: B:145:0x0346  */
        /* JADX WARN: Code duplicated, block: B:147:0x0352  */
        /* JADX WARN: Code duplicated, block: B:148:0x035f  */
        /* JADX WARN: Code duplicated, block: B:150:0x0369  */
        /* JADX WARN: Code duplicated, block: B:151:0x0375  */
        /* JADX WARN: Code duplicated, block: B:153:0x0380  */
        /* JADX WARN: Code duplicated, block: B:154:0x038f  */
        /* JADX WARN: Code duplicated, block: B:156:0x0399  */
        /* JADX WARN: Code duplicated, block: B:158:0x039f  */
        /* JADX WARN: Code duplicated, block: B:159:0x03a2  */
        /* JADX WARN: Code duplicated, block: B:161:0x03a8  */
        /* JADX WARN: Code duplicated, block: B:163:0x03b2  */
        /* JADX WARN: Code duplicated, block: B:165:0x03b8  */
        /* JADX WARN: Code duplicated, block: B:166:0x03bb  */
        /* JADX WARN: Code duplicated, block: B:168:0x03c1  */
        /* JADX WARN: Code duplicated, block: B:170:0x03cb  */
        /* JADX WARN: Code duplicated, block: B:172:0x03d1  */
        /* JADX WARN: Code duplicated, block: B:175:0x03df  */
        /* JADX WARN: Code duplicated, block: B:177:0x03f0  */
        /* JADX WARN: Code duplicated, block: B:179:0x03f6  */
        /* JADX WARN: Code duplicated, block: B:180:0x03fa  */
        /* JADX WARN: Code duplicated, block: B:182:0x0400  */
        /* JADX WARN: Code duplicated, block: B:184:0x040a  */
        /* JADX WARN: Code duplicated, block: B:186:0x0410  */
        /* JADX WARN: Code duplicated, block: B:187:0x0414  */
        /* JADX WARN: Code duplicated, block: B:189:0x041a  */
        /* JADX WARN: Code duplicated, block: B:191:0x0426  */
        /* JADX WARN: Code duplicated, block: B:192:0x0433  */
        /* JADX WARN: Code duplicated, block: B:194:0x043f  */
        /* JADX WARN: Code duplicated, block: B:195:0x044b  */
        /* JADX WARN: Code duplicated, block: B:197:0x0456  */
        /* JADX WARN: Code duplicated, block: B:198:0x0468  */
        /* JADX WARN: Code duplicated, block: B:200:0x0474  */
        /* JADX WARN: Code duplicated, block: B:201:0x0482  */
        /* JADX WARN: Code duplicated, block: B:203:0x048e  */
        /* JADX WARN: Code duplicated, block: B:204:0x049b  */
        /* JADX WARN: Code duplicated, block: B:206:0x04a5  */
        /* JADX WARN: Code duplicated, block: B:207:0x04b1  */
        /* JADX WARN: Code duplicated, block: B:209:0x04bc  */
        /* JADX WARN: Code duplicated, block: B:210:0x04cb  */
        /* JADX WARN: Code duplicated, block: B:212:0x04d5  */
        /* JADX WARN: Code duplicated, block: B:214:0x04db  */
        /* JADX WARN: Code duplicated, block: B:215:0x04de  */
        /* JADX WARN: Code duplicated, block: B:217:0x04e4  */
        /* JADX WARN: Code duplicated, block: B:219:0x04ee  */
        /* JADX WARN: Code duplicated, block: B:221:0x04f4  */
        /* JADX WARN: Code duplicated, block: B:222:0x04f7  */
        /* JADX WARN: Code duplicated, block: B:224:0x04fd  */
        /* JADX WARN: Code duplicated, block: B:226:0x0507  */
        /* JADX WARN: Code duplicated, block: B:228:0x050d  */
        /* JADX WARN: Code duplicated, block: B:231:0x051b  */
        /* JADX WARN: Code duplicated, block: B:232:0x0523  */
        /* JADX WARN: Code duplicated, block: B:234:0x052b  */
        /* JADX WARN: Code duplicated, block: B:236:0x0533  */
        /* JADX WARN: Code duplicated, block: B:238:0x054a  */
        /* JADX WARN: Code duplicated, block: B:240:0x0550  */
        /* JADX WARN: Code duplicated, block: B:242:0x0575  */
        /* JADX WARN: Code duplicated, block: B:244:0x0592  */
        /* JADX WARN: Code duplicated, block: B:246:0x0598  */
        /* JADX WARN: Code duplicated, block: B:248:0x05bd  */
        /* JADX WARN: Instruction removed from duplicated block: B:236:0x0533, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:240:0x0550, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:242:0x0575, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:246:0x0598, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:248:0x05bd, please report this as an issue */
        @NotNull
        public final LiveUpdateMutation fromJson(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            String str;
            String str2;
            String str3;
            String strOptString2;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            String str4;
            Object jsonValue2;
            Long lValueOf;
            Object objOptMap;
            Object objOptList;
            Long l;
            Object objOptString;
            long jLongValue;
            JsonValue jsonValue3;
            KClass orCreateKotlinClass2;
            Object jsonValue4;
            Long lValueOf2;
            Object objOptMap2;
            Object objOptList2;
            Object objOptString2;
            long jLongValue2;
            Object objOptString3;
            Object objOptString4;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue5 = json.get("action");
            if (jsonValue5 == null) {
                throw new JsonException("Missing required field: 'action" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue5);
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue5.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue5.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue5.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue5.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList3 = jsonValue5.optList();
                if (objOptList3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList3;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap3 = jsonValue5.optMap();
                if (objOptMap3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap3;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'action" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue6 = jsonValue5.getJsonValue();
                if (jsonValue6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue6;
            }
            JsonValue jsonValue7 = json.get("name");
            if (jsonValue7 == null) {
                throw new JsonException("Missing required field: 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue7);
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString2 = jsonValue7.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str = "' for field '";
                            str2 = (String) Long.valueOf(jsonValue7.getLong(0L));
                        } else {
                            str = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                str2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                str2 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                str2 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                str2 = (String) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                str2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                Object objOptList4 = jsonValue7.optList();
                                if (objOptList4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                str2 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                Object objOptMap4 = jsonValue7.optMap();
                                if (objOptMap4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                str2 = (String) objOptMap4;
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "name" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Object jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                str2 = (String) jsonValue8;
                            }
                        }
                        str3 = str2;
                    }
                    jsonValue = json.get("start_ts_ms");
                    if (jsonValue != null) {
                        throw new JsonException("Missing required field: 'start_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue);
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString4 = jsonValue.optString();
                        if (objOptString4 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        l = (Long) objOptString4;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                l = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str4 = "Missing required field: '";
                                lValueOf = Long.valueOf(jsonValue.getLong(0L));
                            } else {
                                str4 = "Missing required field: '";
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    l = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    l = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    l = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    lValueOf = (Long) Integer.valueOf(jsonValue.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList = jsonValue.optList();
                                    if (objOptList != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                    }
                                    lValueOf = (Long) objOptList;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap = jsonValue.optMap();
                                    if (objOptMap != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                    }
                                    lValueOf = (Long) objOptMap;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "start_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue2 = jsonValue.getJsonValue();
                                    if (jsonValue2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                    }
                                    lValueOf = (Long) jsonValue2;
                                }
                                lValueOf = l;
                            }
                            jLongValue = lValueOf.longValue();
                            jsonValue3 = json.get("action_ts_ms");
                            if (jsonValue3 != null) {
                                throw new JsonException(str4 + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue3);
                            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                objOptString3 = jsonValue3.optString();
                                if (objOptString3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf2 = (Long) objOptString3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                objOptString2 = jsonValue3.optString();
                                if (objOptString2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf2 = (Long) objOptString2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                lValueOf2 = (Long) Boolean.valueOf(jsonValue3.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                lValueOf2 = Long.valueOf(jsonValue3.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                lValueOf2 = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                lValueOf2 = (Long) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                lValueOf2 = (Long) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                lValueOf2 = (Long) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                lValueOf2 = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue3.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf2 = (Long) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue3.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf2 = (Long) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue4 = jsonValue3.getJsonValue();
                                if (jsonValue4 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf2 = (Long) jsonValue4;
                            }
                            jLongValue2 = lValueOf2.longValue();
                            if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_SET)) {
                                return new Set(str3, jLongValue, jLongValue2);
                            }
                            if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_REMOVE)) {
                                return new Remove(str3, jLongValue, jLongValue2);
                            }
                            throw new JsonException("Failed to parse LiveUpdateMutation json: " + json);
                        }
                        objOptString = jsonValue.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        l = (Long) objOptString;
                    }
                    str4 = "Missing required field: '";
                    lValueOf = l;
                    jLongValue = lValueOf.longValue();
                    jsonValue3 = json.get("action_ts_ms");
                    if (jsonValue3 != null) {
                        throw new JsonException(str4 + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue3);
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString3 = jsonValue3.optString();
                        if (objOptString3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptString3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        objOptString2 = jsonValue3.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf2 = (Long) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf2 = Long.valueOf(jsonValue3.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf2 = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf2 = (Long) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf2 = (Long) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        lValueOf2 = (Long) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf2 = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList2 = jsonValue3.optList();
                        if (objOptList2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap2 = jsonValue3.optMap();
                        if (objOptMap2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptMap2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue4 = jsonValue3.getJsonValue();
                        if (jsonValue4 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) jsonValue4;
                    }
                    jLongValue2 = lValueOf2.longValue();
                    if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_SET)) {
                        return new Set(str3, jLongValue, jLongValue2);
                    }
                    if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_REMOVE)) {
                        return new Remove(str3, jLongValue, jLongValue2);
                    }
                    throw new JsonException("Failed to parse LiveUpdateMutation json: " + json);
                }
                strOptString2 = jsonValue7.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            str3 = strOptString2;
            str = "' for field '";
            jsonValue = json.get("start_ts_ms");
            if (jsonValue != null) {
                throw new JsonException("Missing required field: 'start_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue);
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString4 = jsonValue.optString();
                if (objOptString4 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                l = (Long) objOptString4;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        l = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str4 = "Missing required field: '";
                        lValueOf = Long.valueOf(jsonValue.getLong(0L));
                    } else {
                        str4 = "Missing required field: '";
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            l = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            l = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            l = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            lValueOf = (Long) Integer.valueOf(jsonValue.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList = jsonValue.optList();
                            if (objOptList != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap = jsonValue.optMap();
                            if (objOptMap != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptMap;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "start_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue2 = jsonValue.getJsonValue();
                            if (jsonValue2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) jsonValue2;
                        }
                        lValueOf = l;
                    }
                    jLongValue = lValueOf.longValue();
                    jsonValue3 = json.get("action_ts_ms");
                    if (jsonValue3 != null) {
                        throw new JsonException(str4 + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue3);
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString3 = jsonValue3.optString();
                        if (objOptString3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptString3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        objOptString2 = jsonValue3.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf2 = (Long) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf2 = Long.valueOf(jsonValue3.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf2 = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf2 = (Long) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf2 = (Long) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        lValueOf2 = (Long) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf2 = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList2 = jsonValue3.optList();
                        if (objOptList2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap2 = jsonValue3.optMap();
                        if (objOptMap2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) objOptMap2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue4 = jsonValue3.getJsonValue();
                        if (jsonValue4 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) jsonValue4;
                    }
                    jLongValue2 = lValueOf2.longValue();
                    if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_SET)) {
                        return new Set(str3, jLongValue, jLongValue2);
                    }
                    if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_REMOVE)) {
                        return new Remove(str3, jLongValue, jLongValue2);
                    }
                    throw new JsonException("Failed to parse LiveUpdateMutation json: " + json);
                }
                objOptString = jsonValue.optString();
                if (objOptString != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                l = (Long) objOptString;
            }
            str4 = "Missing required field: '";
            lValueOf = l;
            jLongValue = lValueOf.longValue();
            jsonValue3 = json.get("action_ts_ms");
            if (jsonValue3 != null) {
                throw new JsonException(str4 + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue3);
            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString3 = jsonValue3.optString();
                if (objOptString3 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf2 = (Long) objOptString3;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                objOptString2 = jsonValue3.optString();
                if (objOptString2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf2 = (Long) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                lValueOf2 = (Long) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                lValueOf2 = Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                lValueOf2 = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                lValueOf2 = (Long) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                lValueOf2 = (Long) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                lValueOf2 = (Long) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                lValueOf2 = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                objOptList2 = jsonValue3.optList();
                if (objOptList2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf2 = (Long) objOptList2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                objOptMap2 = jsonValue3.optMap();
                if (objOptMap2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf2 = (Long) objOptMap2;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "action_ts_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue4 = jsonValue3.getJsonValue();
                if (jsonValue4 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf2 = (Long) jsonValue4;
            }
            jLongValue2 = lValueOf2.longValue();
            if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_SET)) {
                return new Set(str3, jLongValue, jLongValue2);
            }
            if (Intrinsics.areEqual(strOptString, AttributeMutation.ATTRIBUTE_ACTION_REMOVE)) {
                return new Remove(str3, jLongValue, jLongValue2);
            }
            throw new JsonException("Failed to parse LiveUpdateMutation json: " + json);
        }

        private Companion() {
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.channel.LiveUpdateMutation");
        LiveUpdateMutation liveUpdateMutation = (LiveUpdateMutation) other;
        return Intrinsics.areEqual(this.action, liveUpdateMutation.action) && Intrinsics.areEqual(getName(), liveUpdateMutation.getName()) && getStartTime() == liveUpdateMutation.getStartTime() && getActionTime() == liveUpdateMutation.getActionTime();
    }

    public int hashCode() {
        return (((((this.action.hashCode() * 31) + getName().hashCode()) * 31) + Long.hashCode(getStartTime())) * 31) + Long.hashCode(getActionTime());
    }
}
