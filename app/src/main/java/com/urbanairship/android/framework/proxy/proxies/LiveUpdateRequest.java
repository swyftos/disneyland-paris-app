package com.urbanairship.android.framework.proxy.proxies;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.DateUtils;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "", "()V", "Companion", "End", "List", "Start", "Update", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public abstract class LiveUpdateRequest {

    @Deprecated
    @NotNull
    public static final String CONTENT = "content";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String DISMISSAL_TIMESTAMP = "dismissalTimestamp";

    @Deprecated
    @NotNull
    public static final String NAME = "name";

    @Deprecated
    @NotNull
    public static final String TIMESTAMP = "timestamp";

    @Deprecated
    @NotNull
    public static final String TYPE = "type";

    public /* synthetic */ LiveUpdateRequest(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LiveUpdateRequest() {
    }

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006 "}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class Update extends LiveUpdateRequest {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final JsonMap content;
        private final Long dismissalTimestamp;
        private final String name;
        private final Long timestamp;

        public static /* synthetic */ Update copy$default(Update update, String str, JsonMap jsonMap, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = update.name;
            }
            if ((i & 2) != 0) {
                jsonMap = update.content;
            }
            if ((i & 4) != 0) {
                l = update.timestamp;
            }
            if ((i & 8) != 0) {
                l2 = update.dismissalTimestamp;
            }
            return update.copy(str, jsonMap, l, l2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @NotNull
        public final Update copy(@NotNull String name, @NotNull JsonMap content, @Nullable Long timestamp, @Nullable Long dismissalTimestamp) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(content, "content");
            return new Update(name, content, timestamp, dismissalTimestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Update)) {
                return false;
            }
            Update update = (Update) other;
            return Intrinsics.areEqual(this.name, update.name) && Intrinsics.areEqual(this.content, update.content) && Intrinsics.areEqual(this.timestamp, update.timestamp) && Intrinsics.areEqual(this.dismissalTimestamp, update.dismissalTimestamp);
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + this.content.hashCode()) * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.dismissalTimestamp;
            return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Update(name=" + this.name + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ")";
        }

        public /* synthetic */ Update(String str, JsonMap jsonMap, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jsonMap, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n44#2,15:189\n79#2,16:204\n79#2,16:220\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update$Companion\n*L\n88#1:174,15\n89#1:189,15\n90#1:204,16\n93#1:220,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:100:0x0262  */
            /* JADX WARN: Code duplicated, block: B:101:0x0265  */
            /* JADX WARN: Code duplicated, block: B:103:0x026b  */
            /* JADX WARN: Code duplicated, block: B:105:0x0275  */
            /* JADX WARN: Code duplicated, block: B:108:0x027c  */
            /* JADX WARN: Code duplicated, block: B:110:0x0282  */
            /* JADX WARN: Code duplicated, block: B:112:0x028c  */
            /* JADX WARN: Code duplicated, block: B:114:0x0292  */
            /* JADX WARN: Code duplicated, block: B:117:0x029c  */
            /* JADX WARN: Code duplicated, block: B:118:0x02a1  */
            /* JADX WARN: Code duplicated, block: B:120:0x02af  */
            /* JADX WARN: Code duplicated, block: B:123:0x02b9  */
            /* JADX WARN: Code duplicated, block: B:125:0x02bf  */
            /* JADX WARN: Code duplicated, block: B:127:0x02c9  */
            /* JADX WARN: Code duplicated, block: B:130:0x02d0  */
            /* JADX WARN: Code duplicated, block: B:132:0x02d6  */
            /* JADX WARN: Code duplicated, block: B:134:0x02e2  */
            /* JADX WARN: Code duplicated, block: B:135:0x02ee  */
            /* JADX WARN: Code duplicated, block: B:137:0x02fa  */
            /* JADX WARN: Code duplicated, block: B:138:0x030a  */
            /* JADX WARN: Code duplicated, block: B:140:0x0318  */
            /* JADX WARN: Code duplicated, block: B:141:0x0328  */
            /* JADX WARN: Code duplicated, block: B:143:0x0334  */
            /* JADX WARN: Code duplicated, block: B:144:0x0342  */
            /* JADX WARN: Code duplicated, block: B:146:0x034e  */
            /* JADX WARN: Code duplicated, block: B:147:0x035b  */
            /* JADX WARN: Code duplicated, block: B:149:0x0365 A[ADDED_TO_REGION, REMOVE] */
            /* JADX WARN: Code duplicated, block: B:150:0x0372  */
            /* JADX WARN: Code duplicated, block: B:155:0x0394  */
            /* JADX WARN: Code duplicated, block: B:156:0x03a3  */
            /* JADX WARN: Code duplicated, block: B:158:0x03ad  */
            /* JADX WARN: Code duplicated, block: B:160:0x03b3  */
            /* JADX WARN: Code duplicated, block: B:161:0x03b6  */
            /* JADX WARN: Code duplicated, block: B:163:0x03bc  */
            /* JADX WARN: Code duplicated, block: B:165:0x03c6  */
            /* JADX WARN: Code duplicated, block: B:167:0x03cc  */
            /* JADX WARN: Code duplicated, block: B:168:0x03cf  */
            /* JADX WARN: Code duplicated, block: B:170:0x03d5  */
            /* JADX WARN: Code duplicated, block: B:172:0x03df  */
            /* JADX WARN: Code duplicated, block: B:174:0x03e5  */
            /* JADX WARN: Code duplicated, block: B:176:0x03e9  */
            /* JADX WARN: Code duplicated, block: B:177:0x03f2  */
            /* JADX WARN: Code duplicated, block: B:180:0x03fb  */
            /* JADX WARN: Code duplicated, block: B:181:0x03fe  */
            /* JADX WARN: Code duplicated, block: B:183:0x040c  */
            /* JADX WARN: Code duplicated, block: B:186:0x0414  */
            /* JADX WARN: Code duplicated, block: B:188:0x041a  */
            /* JADX WARN: Code duplicated, block: B:190:0x0424  */
            /* JADX WARN: Code duplicated, block: B:193:0x042c  */
            /* JADX WARN: Code duplicated, block: B:195:0x0432  */
            /* JADX WARN: Code duplicated, block: B:197:0x043e  */
            /* JADX WARN: Code duplicated, block: B:198:0x044b  */
            /* JADX WARN: Code duplicated, block: B:200:0x0457  */
            /* JADX WARN: Code duplicated, block: B:201:0x0465  */
            /* JADX WARN: Code duplicated, block: B:203:0x0472  */
            /* JADX WARN: Code duplicated, block: B:204:0x0482  */
            /* JADX WARN: Code duplicated, block: B:206:0x048e  */
            /* JADX WARN: Code duplicated, block: B:207:0x049c  */
            /* JADX WARN: Code duplicated, block: B:209:0x04a8  */
            /* JADX WARN: Code duplicated, block: B:210:0x04b5  */
            /* JADX WARN: Code duplicated, block: B:212:0x04bf A[ADDED_TO_REGION, REMOVE] */
            /* JADX WARN: Code duplicated, block: B:213:0x04cc  */
            /* JADX WARN: Code duplicated, block: B:218:0x04ee  */
            /* JADX WARN: Code duplicated, block: B:219:0x04fd  */
            /* JADX WARN: Code duplicated, block: B:221:0x0507  */
            /* JADX WARN: Code duplicated, block: B:223:0x050d  */
            /* JADX WARN: Code duplicated, block: B:224:0x0510  */
            /* JADX WARN: Code duplicated, block: B:226:0x0516  */
            /* JADX WARN: Code duplicated, block: B:228:0x0520  */
            /* JADX WARN: Code duplicated, block: B:230:0x0526  */
            /* JADX WARN: Code duplicated, block: B:231:0x0529  */
            /* JADX WARN: Code duplicated, block: B:233:0x052f  */
            /* JADX WARN: Code duplicated, block: B:235:0x0539  */
            /* JADX WARN: Code duplicated, block: B:237:0x053f  */
            /* JADX WARN: Code duplicated, block: B:239:0x0543  */
            /* JADX WARN: Code duplicated, block: B:240:0x054c  */
            /* JADX WARN: Code duplicated, block: B:243:0x0553  */
            /* JADX WARN: Code duplicated, block: B:245:0x0559  */
            /* JADX WARN: Code duplicated, block: B:247:0x0580  */
            /* JADX WARN: Code duplicated, block: B:249:0x0586  */
            /* JADX WARN: Code duplicated, block: B:251:0x05ad  */
            /* JADX WARN: Code duplicated, block: B:253:0x05b3  */
            /* JADX WARN: Code duplicated, block: B:255:0x05d9  */
            /* JADX WARN: Code duplicated, block: B:60:0x0165  */
            /* JADX WARN: Code duplicated, block: B:62:0x0175  */
            /* JADX WARN: Code duplicated, block: B:64:0x017b  */
            /* JADX WARN: Code duplicated, block: B:66:0x0180  */
            /* JADX WARN: Code duplicated, block: B:68:0x0186  */
            /* JADX WARN: Code duplicated, block: B:70:0x0190  */
            /* JADX WARN: Code duplicated, block: B:72:0x0196  */
            /* JADX WARN: Code duplicated, block: B:73:0x0199  */
            /* JADX WARN: Code duplicated, block: B:75:0x019f  */
            /* JADX WARN: Code duplicated, block: B:77:0x01ab  */
            /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
            /* JADX WARN: Code duplicated, block: B:80:0x01c3  */
            /* JADX WARN: Code duplicated, block: B:81:0x01d2  */
            /* JADX WARN: Code duplicated, block: B:83:0x01dd  */
            /* JADX WARN: Code duplicated, block: B:84:0x01ef  */
            /* JADX WARN: Code duplicated, block: B:86:0x01fb  */
            /* JADX WARN: Code duplicated, block: B:87:0x0209  */
            /* JADX WARN: Code duplicated, block: B:89:0x0215  */
            /* JADX WARN: Code duplicated, block: B:90:0x0222  */
            /* JADX WARN: Code duplicated, block: B:92:0x022c  */
            /* JADX WARN: Code duplicated, block: B:93:0x0238  */
            /* JADX WARN: Code duplicated, block: B:95:0x0243  */
            /* JADX WARN: Code duplicated, block: B:96:0x0252  */
            /* JADX WARN: Code duplicated, block: B:98:0x025c  */
            /* JADX WARN: Instruction removed from duplicated block: B:245:0x0559, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:249:0x0586, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:253:0x05b3, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:255:0x05d9, please report this as an issue */
            @NotNull
            public final Update fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                Class cls;
                String strOptString;
                JsonValue jsonValue2;
                KClass orCreateKotlinClass;
                String str;
                JsonSerializable jsonValue3;
                JsonMap jsonMapOptMap;
                JsonSerializable jsonSerializableOptList;
                Object objOptString;
                JsonValue jsonValue4;
                KClass orCreateKotlinClass2;
                String str2;
                Object jsonValue5;
                String strOptString2;
                Object objOptMap;
                Object objOptList;
                Long lValueOf;
                JsonValue jsonValue6;
                KClass orCreateKotlinClass3;
                Object jsonValue7;
                String strOptString3;
                Object objOptMap2;
                Object objOptList2;
                Long lValueOf2;
                Object objOptString2;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                JsonMap jsonMapRequireMap = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue8 = jsonMapRequireMap.get("name");
                if (jsonValue8 == null) {
                    throw new JsonException("Missing required field: 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue8.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            cls = ULong.class;
                            strOptString = (String) Long.valueOf(jsonValue8.getLong(0L));
                        } else {
                            cls = ULong.class;
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                                strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString = (String) Integer.valueOf(jsonValue8.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                Object objOptList3 = jsonValue8.optList();
                                if (objOptList3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString = (String) objOptList3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                Object objOptMap3 = jsonValue8.optMap();
                                if (objOptMap3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString = (String) objOptMap3;
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Object jsonValue9 = jsonValue8.getJsonValue();
                                if (jsonValue9 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString = (String) jsonValue9;
                            }
                        }
                        jsonValue2 = jsonMapRequireMap.get("content");
                        if (jsonValue2 != null) {
                            throw new JsonException("Missing required field: 'content" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            objOptString2 = jsonValue2.optString();
                            if (objOptString2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap = (JsonMap) objOptString2;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue2.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    str = "' for field '";
                                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue2.getLong(0L));
                                } else {
                                    str = "' for field '";
                                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
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
                                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "content" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue3 = jsonValue2.getJsonValue();
                                        if (jsonValue3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                        }
                                        jsonMapOptMap = (JsonMap) jsonValue3;
                                    }
                                }
                                jsonValue4 = jsonMapRequireMap.get("timestamp");
                                if (jsonValue4 == null) {
                                    str2 = "Invalid type '";
                                    strOptString2 = null;
                                } else {
                                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString2 = jsonValue4.optString();
                                        if (strOptString2 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString2 = jsonValue4.optString();
                                        if (strOptString2 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString2 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str2 = "Invalid type '";
                                        strOptString2 = (String) Long.valueOf(jsonValue4.getLong(0L));
                                    } else {
                                        str2 = "Invalid type '";
                                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                            strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            strOptString2 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            strOptString2 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                            strOptString2 = (String) Integer.valueOf(jsonValue4.getInt(0));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                            strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                            objOptList = jsonValue4.optList();
                                            if (objOptList != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                            strOptString2 = (String) objOptList;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                            objOptMap = jsonValue4.optMap();
                                            if (objOptMap != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                            strOptString2 = (String) objOptMap;
                                        } else {
                                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                throw new JsonException(str2 + String.class.getSimpleName() + str + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            jsonValue5 = jsonValue4.getJsonValue();
                                            if (jsonValue5 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                            strOptString2 = (String) jsonValue5;
                                        }
                                    }
                                    str2 = "Invalid type '";
                                }
                                if (strOptString2 != null) {
                                    lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString2));
                                } else {
                                    lValueOf = null;
                                }
                                jsonValue6 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                                if (jsonValue6 == null) {
                                    strOptString3 = null;
                                } else {
                                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString3 = jsonValue6.optString();
                                        if (strOptString3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString3 = jsonValue6.optString();
                                        if (strOptString3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList2 = jsonValue6.optList();
                                        if (objOptList2 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString3 = (String) objOptList2;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap2 = jsonValue6.optMap();
                                        if (objOptMap2 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString3 = (String) objOptMap2;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str2 + String.class.getSimpleName() + str + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue7 = jsonValue6.getJsonValue();
                                        if (jsonValue7 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString3 = (String) jsonValue7;
                                    }
                                }
                                if (strOptString3 != null) {
                                    lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                                } else {
                                    lValueOf2 = null;
                                }
                                return new Update(strOptString, jsonMapOptMap, lValueOf, lValueOf2);
                            }
                            objOptString = jsonValue2.optString();
                            if (objOptString != null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap = (JsonMap) objOptString;
                        }
                        str = "' for field '";
                        jsonValue4 = jsonMapRequireMap.get("timestamp");
                        if (jsonValue4 == null) {
                            str2 = "Invalid type '";
                            strOptString2 = null;
                        } else {
                            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString2 = jsonValue4.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString2 = jsonValue4.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString2 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str2 = "Invalid type '";
                                strOptString2 = (String) Long.valueOf(jsonValue4.getLong(0L));
                            } else {
                                str2 = "Invalid type '";
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                    strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString2 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString2 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString2 = (String) Integer.valueOf(jsonValue4.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList = jsonValue4.optList();
                                    if (objOptList != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString2 = (String) objOptList;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap = jsonValue4.optMap();
                                    if (objOptMap != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString2 = (String) objOptMap;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str2 + String.class.getSimpleName() + str + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue5 = jsonValue4.getJsonValue();
                                    if (jsonValue5 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString2 = (String) jsonValue5;
                                }
                            }
                            str2 = "Invalid type '";
                        }
                        if (strOptString2 != null) {
                            lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString2));
                        } else {
                            lValueOf = null;
                        }
                        jsonValue6 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                        if (jsonValue6 == null) {
                            strOptString3 = null;
                        } else {
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue6.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue6.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str2 + String.class.getSimpleName() + str + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue7 = jsonValue6.getJsonValue();
                                if (jsonValue7 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue7;
                            }
                        }
                        if (strOptString3 != null) {
                            lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                        } else {
                            lValueOf2 = null;
                        }
                        return new Update(strOptString, jsonMapOptMap, lValueOf, lValueOf2);
                    }
                    strOptString = jsonValue8.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
                cls = ULong.class;
                jsonValue2 = jsonMapRequireMap.get("content");
                if (jsonValue2 != null) {
                    throw new JsonException("Missing required field: 'content" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString2 = jsonValue2.optString();
                    if (objOptString2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString2;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue2.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str = "' for field '";
                            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue2.getLong(0L));
                        } else {
                            str = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
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
                                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "content" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue3 = jsonValue2.getJsonValue();
                                if (jsonValue3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                                jsonMapOptMap = (JsonMap) jsonValue3;
                            }
                        }
                        jsonValue4 = jsonMapRequireMap.get("timestamp");
                        if (jsonValue4 == null) {
                            str2 = "Invalid type '";
                            strOptString2 = null;
                        } else {
                            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString2 = jsonValue4.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString2 = jsonValue4.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString2 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str2 = "Invalid type '";
                                strOptString2 = (String) Long.valueOf(jsonValue4.getLong(0L));
                            } else {
                                str2 = "Invalid type '";
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                    strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString2 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString2 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString2 = (String) Integer.valueOf(jsonValue4.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList = jsonValue4.optList();
                                    if (objOptList != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString2 = (String) objOptList;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap = jsonValue4.optMap();
                                    if (objOptMap != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString2 = (String) objOptMap;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str2 + String.class.getSimpleName() + str + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue5 = jsonValue4.getJsonValue();
                                    if (jsonValue5 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString2 = (String) jsonValue5;
                                }
                            }
                            str2 = "Invalid type '";
                        }
                        if (strOptString2 != null) {
                            lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString2));
                        } else {
                            lValueOf = null;
                        }
                        jsonValue6 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                        if (jsonValue6 == null) {
                            strOptString3 = null;
                        } else {
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue6.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue6.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str2 + String.class.getSimpleName() + str + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue7 = jsonValue6.getJsonValue();
                                if (jsonValue7 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue7;
                            }
                        }
                        if (strOptString3 != null) {
                            lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                        } else {
                            lValueOf2 = null;
                        }
                        return new Update(strOptString, jsonMapOptMap, lValueOf, lValueOf2);
                    }
                    objOptString = jsonValue2.optString();
                    if (objOptString != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString;
                }
                str = "' for field '";
                jsonValue4 = jsonMapRequireMap.get("timestamp");
                if (jsonValue4 == null) {
                    str2 = "Invalid type '";
                    strOptString2 = null;
                } else {
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue4.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue4.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str2 = "Invalid type '";
                        strOptString2 = (String) Long.valueOf(jsonValue4.getLong(0L));
                    } else {
                        str2 = "Invalid type '";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                            strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString2 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString2 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString2 = (String) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList = jsonValue4.optList();
                            if (objOptList != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap = jsonValue4.optMap();
                            if (objOptMap != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptMap;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + String.class.getSimpleName() + str + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue5 = jsonValue4.getJsonValue();
                            if (jsonValue5 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) jsonValue5;
                        }
                    }
                    str2 = "Invalid type '";
                }
                if (strOptString2 != null) {
                    lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString2));
                } else {
                    lValueOf = null;
                }
                jsonValue6 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                if (jsonValue6 == null) {
                    strOptString3 = null;
                } else {
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue6.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString3 = jsonValue6.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList2 = jsonValue6.optList();
                        if (objOptList2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap2 = jsonValue6.optMap();
                        if (objOptMap2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptMap2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException(str2 + String.class.getSimpleName() + str + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue7 = jsonValue6.getJsonValue();
                        if (jsonValue7 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) jsonValue7;
                    }
                }
                if (strOptString3 != null) {
                    lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                } else {
                    lValueOf2 = null;
                }
                return new Update(strOptString, jsonMapOptMap, lValueOf, lValueOf2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(@NotNull String name, @NotNull JsonMap content, @Nullable Long l, @Nullable Long l2) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(content, "content");
            this.name = name;
            this.content = content;
            this.timestamp = l;
            this.dismissalTimestamp = l2;
        }
    }

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ<\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006 "}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class End extends LiveUpdateRequest {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final JsonMap content;
        private final Long dismissalTimestamp;
        private final String name;
        private final Long timestamp;

        public static /* synthetic */ End copy$default(End end, String str, JsonMap jsonMap, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = end.name;
            }
            if ((i & 2) != 0) {
                jsonMap = end.content;
            }
            if ((i & 4) != 0) {
                l = end.timestamp;
            }
            if ((i & 8) != 0) {
                l2 = end.dismissalTimestamp;
            }
            return end.copy(str, jsonMap, l, l2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @NotNull
        public final End copy(@NotNull String name, @Nullable JsonMap content, @Nullable Long timestamp, @Nullable Long dismissalTimestamp) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new End(name, content, timestamp, dismissalTimestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof End)) {
                return false;
            }
            End end = (End) other;
            return Intrinsics.areEqual(this.name, end.name) && Intrinsics.areEqual(this.content, end.content) && Intrinsics.areEqual(this.timestamp, end.timestamp) && Intrinsics.areEqual(this.dismissalTimestamp, end.dismissalTimestamp);
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            JsonMap jsonMap = this.content;
            int iHashCode2 = (iHashCode + (jsonMap == null ? 0 : jsonMap.hashCode())) * 31;
            Long l = this.timestamp;
            int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.dismissalTimestamp;
            return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "End(name=" + this.name + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ")";
        }

        public /* synthetic */ End(String str, JsonMap jsonMap, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jsonMap, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n79#2,16:189\n79#2,16:205\n79#2,16:221\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End$Companion\n*L\n112#1:174,15\n113#1:189,16\n114#1:205,16\n117#1:221,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final End fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                String strOptString;
                String str;
                JsonMap jsonMapOptMap;
                String strOptString2;
                String strOptString3;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                JsonMap jsonMapRequireMap = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue2 = jsonMapRequireMap.get("name");
                if (jsonValue2 == null) {
                    throw new JsonException("Missing required field: 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue2.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue2.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue3;
                }
                JsonValue jsonValue4 = jsonMapRequireMap.get("content");
                if (jsonValue4 == null) {
                    str = "null cannot be cast to non-null type kotlin.String";
                    jsonMapOptMap = null;
                } else {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        jsonMapOptMap = (JsonMap) jsonValue4.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "null cannot be cast to non-null type kotlin.String";
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
                    } else {
                        str = "null cannot be cast to non-null type kotlin.String";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            jsonMapOptMap = (JsonMap) jsonValue4.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap = jsonValue4.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'content" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonMapOptMap = (JsonMap) jsonValue4.getJsonValue();
                        }
                    }
                    str = "null cannot be cast to non-null type kotlin.String";
                }
                JsonValue jsonValue5 = jsonMapRequireMap.get("timestamp");
                if (jsonValue5 == null) {
                    strOptString2 = null;
                } else {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue5.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue5.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue5.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue5.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList2 = jsonValue5.optList();
                        if (objOptList2 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap2 = jsonValue5.optMap();
                        if (objOptMap2 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) objOptMap2;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue6 = jsonValue5.getJsonValue();
                        if (jsonValue6 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) jsonValue6;
                    }
                }
                Long lValueOf = strOptString2 != null ? Long.valueOf(DateUtils.parseIso8601(strOptString2)) : null;
                JsonValue jsonValue7 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                if (jsonValue7 == null) {
                    strOptString3 = null;
                } else {
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue7.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString3 = jsonValue7.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString3 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString3 = (String) Long.valueOf(jsonValue7.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString3 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString3 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString3 = (String) Integer.valueOf(jsonValue7.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList3 = jsonValue7.optList();
                        if (objOptList3 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString3 = (String) objOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap3 = jsonValue7.optMap();
                        if (objOptMap3 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString3 = (String) objOptMap3;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue8 = jsonValue7.getJsonValue();
                        if (jsonValue8 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString3 = (String) jsonValue8;
                    }
                }
                return new End(strOptString, jsonMapOptMap, lValueOf, strOptString3 != null ? Long.valueOf(DateUtils.parseIso8601(strOptString3)) : null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public End(@NotNull String name, @Nullable JsonMap jsonMap, @Nullable Long l, @Nullable Long l2) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.content = jsonMap;
            this.timestamp = l;
            this.dismissalTimestamp = l2;
        }
    }

    @Metadata(m1835d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006#"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "name", "", "type", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getTimestamp", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class Start extends LiveUpdateRequest {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final JsonMap content;
        private final Long dismissalTimestamp;
        private final String name;
        private final Long timestamp;
        private final String type;

        public static /* synthetic */ Start copy$default(Start start, String str, String str2, JsonMap jsonMap, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = start.name;
            }
            if ((i & 2) != 0) {
                str2 = start.type;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                jsonMap = start.content;
            }
            JsonMap jsonMap2 = jsonMap;
            if ((i & 8) != 0) {
                l = start.timestamp;
            }
            Long l3 = l;
            if ((i & 16) != 0) {
                l2 = start.dismissalTimestamp;
            }
            return start.copy(str, str3, jsonMap2, l3, l2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @NotNull
        public final Start copy(@NotNull String name, @NotNull String type, @NotNull JsonMap content, @Nullable Long timestamp, @Nullable Long dismissalTimestamp) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(content, "content");
            return new Start(name, type, content, timestamp, dismissalTimestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Start)) {
                return false;
            }
            Start start = (Start) other;
            return Intrinsics.areEqual(this.name, start.name) && Intrinsics.areEqual(this.type, start.type) && Intrinsics.areEqual(this.content, start.content) && Intrinsics.areEqual(this.timestamp, start.timestamp) && Intrinsics.areEqual(this.dismissalTimestamp, start.dismissalTimestamp);
        }

        public int hashCode() {
            int iHashCode = ((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.content.hashCode()) * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.dismissalTimestamp;
            return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Start(name=" + this.name + ", type=" + this.type + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ")";
        }

        public /* synthetic */ Start(String str, String str2, JsonMap jsonMap, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, jsonMap, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n44#2,15:189\n44#2,15:204\n79#2,16:219\n79#2,16:235\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start$Companion\n*L\n137#1:174,15\n138#1:189,15\n139#1:204,15\n140#1:219,16\n143#1:235,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:100:0x0261  */
            /* JADX WARN: Code duplicated, block: B:101:0x0265  */
            /* JADX WARN: Code duplicated, block: B:103:0x026b  */
            /* JADX WARN: Code duplicated, block: B:105:0x0275  */
            /* JADX WARN: Code duplicated, block: B:107:0x027b  */
            /* JADX WARN: Code duplicated, block: B:108:0x027f  */
            /* JADX WARN: Code duplicated, block: B:110:0x0285  */
            /* JADX WARN: Code duplicated, block: B:112:0x028f  */
            /* JADX WARN: Code duplicated, block: B:114:0x0295  */
            /* JADX WARN: Code duplicated, block: B:117:0x02a1  */
            /* JADX WARN: Code duplicated, block: B:119:0x02b1  */
            /* JADX WARN: Code duplicated, block: B:121:0x02b7  */
            /* JADX WARN: Code duplicated, block: B:123:0x02be  */
            /* JADX WARN: Code duplicated, block: B:125:0x02c4  */
            /* JADX WARN: Code duplicated, block: B:127:0x02ce  */
            /* JADX WARN: Code duplicated, block: B:129:0x02d4  */
            /* JADX WARN: Code duplicated, block: B:130:0x02d7  */
            /* JADX WARN: Code duplicated, block: B:132:0x02dd  */
            /* JADX WARN: Code duplicated, block: B:134:0x02e9  */
            /* JADX WARN: Code duplicated, block: B:135:0x02f5  */
            /* JADX WARN: Code duplicated, block: B:137:0x0301  */
            /* JADX WARN: Code duplicated, block: B:139:0x0312  */
            /* JADX WARN: Code duplicated, block: B:141:0x031f  */
            /* JADX WARN: Code duplicated, block: B:142:0x032e  */
            /* JADX WARN: Code duplicated, block: B:144:0x033a  */
            /* JADX WARN: Code duplicated, block: B:145:0x0347  */
            /* JADX WARN: Code duplicated, block: B:147:0x0353  */
            /* JADX WARN: Code duplicated, block: B:148:0x035f  */
            /* JADX WARN: Code duplicated, block: B:150:0x0369  */
            /* JADX WARN: Code duplicated, block: B:151:0x0375  */
            /* JADX WARN: Code duplicated, block: B:153:0x0380  */
            /* JADX WARN: Code duplicated, block: B:154:0x0390  */
            /* JADX WARN: Code duplicated, block: B:156:0x039a  */
            /* JADX WARN: Code duplicated, block: B:158:0x03a0  */
            /* JADX WARN: Code duplicated, block: B:159:0x03a4  */
            /* JADX WARN: Code duplicated, block: B:161:0x03aa  */
            /* JADX WARN: Code duplicated, block: B:163:0x03b4  */
            /* JADX WARN: Code duplicated, block: B:166:0x03bc  */
            /* JADX WARN: Code duplicated, block: B:168:0x03c2  */
            /* JADX WARN: Code duplicated, block: B:170:0x03cc  */
            /* JADX WARN: Code duplicated, block: B:172:0x03d2  */
            /* JADX WARN: Code duplicated, block: B:175:0x03de  */
            /* JADX WARN: Code duplicated, block: B:176:0x03e1  */
            /* JADX WARN: Code duplicated, block: B:178:0x03ef  */
            /* JADX WARN: Code duplicated, block: B:181:0x03f7  */
            /* JADX WARN: Code duplicated, block: B:183:0x03fd  */
            /* JADX WARN: Code duplicated, block: B:185:0x0407  */
            /* JADX WARN: Code duplicated, block: B:188:0x040f  */
            /* JADX WARN: Code duplicated, block: B:190:0x0415  */
            /* JADX WARN: Code duplicated, block: B:192:0x0421  */
            /* JADX WARN: Code duplicated, block: B:193:0x042e  */
            /* JADX WARN: Code duplicated, block: B:195:0x043a  */
            /* JADX WARN: Code duplicated, block: B:196:0x0448  */
            /* JADX WARN: Code duplicated, block: B:198:0x0454  */
            /* JADX WARN: Code duplicated, block: B:199:0x0464  */
            /* JADX WARN: Code duplicated, block: B:201:0x0470  */
            /* JADX WARN: Code duplicated, block: B:202:0x047e  */
            /* JADX WARN: Code duplicated, block: B:204:0x048a  */
            /* JADX WARN: Code duplicated, block: B:205:0x0497  */
            /* JADX WARN: Code duplicated, block: B:207:0x04a1 A[ADDED_TO_REGION, REMOVE] */
            /* JADX WARN: Code duplicated, block: B:208:0x04ae  */
            /* JADX WARN: Code duplicated, block: B:213:0x04d0  */
            /* JADX WARN: Code duplicated, block: B:214:0x04df  */
            /* JADX WARN: Code duplicated, block: B:216:0x04e9  */
            /* JADX WARN: Code duplicated, block: B:218:0x04ef  */
            /* JADX WARN: Code duplicated, block: B:219:0x04f2  */
            /* JADX WARN: Code duplicated, block: B:221:0x04f8  */
            /* JADX WARN: Code duplicated, block: B:223:0x0502  */
            /* JADX WARN: Code duplicated, block: B:225:0x0508  */
            /* JADX WARN: Code duplicated, block: B:226:0x050b  */
            /* JADX WARN: Code duplicated, block: B:228:0x0511  */
            /* JADX WARN: Code duplicated, block: B:230:0x051b  */
            /* JADX WARN: Code duplicated, block: B:232:0x0521  */
            /* JADX WARN: Code duplicated, block: B:234:0x0525  */
            /* JADX WARN: Code duplicated, block: B:235:0x0530  */
            /* JADX WARN: Code duplicated, block: B:238:0x053a  */
            /* JADX WARN: Code duplicated, block: B:239:0x053d  */
            /* JADX WARN: Code duplicated, block: B:241:0x054b  */
            /* JADX WARN: Code duplicated, block: B:244:0x0553  */
            /* JADX WARN: Code duplicated, block: B:246:0x0559  */
            /* JADX WARN: Code duplicated, block: B:248:0x0563  */
            /* JADX WARN: Code duplicated, block: B:251:0x056b  */
            /* JADX WARN: Code duplicated, block: B:253:0x0571  */
            /* JADX WARN: Code duplicated, block: B:255:0x057d  */
            /* JADX WARN: Code duplicated, block: B:256:0x058a  */
            /* JADX WARN: Code duplicated, block: B:258:0x0596  */
            /* JADX WARN: Code duplicated, block: B:259:0x05a4  */
            /* JADX WARN: Code duplicated, block: B:261:0x05b0  */
            /* JADX WARN: Code duplicated, block: B:262:0x05c0  */
            /* JADX WARN: Code duplicated, block: B:264:0x05cc  */
            /* JADX WARN: Code duplicated, block: B:265:0x05da  */
            /* JADX WARN: Code duplicated, block: B:267:0x05e6  */
            /* JADX WARN: Code duplicated, block: B:268:0x05f3  */
            /* JADX WARN: Code duplicated, block: B:270:0x05fd A[ADDED_TO_REGION, REMOVE] */
            /* JADX WARN: Code duplicated, block: B:271:0x060a  */
            /* JADX WARN: Code duplicated, block: B:276:0x062c  */
            /* JADX WARN: Code duplicated, block: B:277:0x063b  */
            /* JADX WARN: Code duplicated, block: B:279:0x0645  */
            /* JADX WARN: Code duplicated, block: B:281:0x064b  */
            /* JADX WARN: Code duplicated, block: B:282:0x064e  */
            /* JADX WARN: Code duplicated, block: B:284:0x0654  */
            /* JADX WARN: Code duplicated, block: B:286:0x065e  */
            /* JADX WARN: Code duplicated, block: B:288:0x0664  */
            /* JADX WARN: Code duplicated, block: B:289:0x0667  */
            /* JADX WARN: Code duplicated, block: B:291:0x066d  */
            /* JADX WARN: Code duplicated, block: B:293:0x0677  */
            /* JADX WARN: Code duplicated, block: B:295:0x067d  */
            /* JADX WARN: Code duplicated, block: B:297:0x0681  */
            /* JADX WARN: Code duplicated, block: B:298:0x068c  */
            /* JADX WARN: Code duplicated, block: B:301:0x0696  */
            /* JADX WARN: Code duplicated, block: B:303:0x069c  */
            /* JADX WARN: Code duplicated, block: B:305:0x06c0  */
            /* JADX WARN: Code duplicated, block: B:307:0x06c6  */
            /* JADX WARN: Code duplicated, block: B:309:0x06ea  */
            /* JADX WARN: Code duplicated, block: B:311:0x06f0  */
            /* JADX WARN: Code duplicated, block: B:313:0x0714  */
            /* JADX WARN: Code duplicated, block: B:315:0x072e  */
            /* JADX WARN: Code duplicated, block: B:317:0x0734  */
            /* JADX WARN: Code duplicated, block: B:319:0x0759  */
            /* JADX WARN: Code duplicated, block: B:61:0x016b  */
            /* JADX WARN: Code duplicated, block: B:63:0x0179  */
            /* JADX WARN: Code duplicated, block: B:66:0x0183  */
            /* JADX WARN: Code duplicated, block: B:68:0x0189  */
            /* JADX WARN: Code duplicated, block: B:70:0x0193  */
            /* JADX WARN: Code duplicated, block: B:73:0x019a  */
            /* JADX WARN: Code duplicated, block: B:75:0x01a0  */
            /* JADX WARN: Code duplicated, block: B:77:0x01ac  */
            /* JADX WARN: Code duplicated, block: B:78:0x01b8  */
            /* JADX WARN: Code duplicated, block: B:80:0x01c4  */
            /* JADX WARN: Code duplicated, block: B:81:0x01d1  */
            /* JADX WARN: Code duplicated, block: B:83:0x01dd  */
            /* JADX WARN: Code duplicated, block: B:84:0x01ec  */
            /* JADX WARN: Code duplicated, block: B:86:0x01f8  */
            /* JADX WARN: Code duplicated, block: B:87:0x0206  */
            /* JADX WARN: Code duplicated, block: B:89:0x0212  */
            /* JADX WARN: Code duplicated, block: B:90:0x021f  */
            /* JADX WARN: Code duplicated, block: B:92:0x0229  */
            /* JADX WARN: Code duplicated, block: B:93:0x0236  */
            /* JADX WARN: Code duplicated, block: B:95:0x0241  */
            /* JADX WARN: Code duplicated, block: B:96:0x0251  */
            /* JADX WARN: Code duplicated, block: B:98:0x025b  */
            /* JADX WARN: Instruction removed from duplicated block: B:303:0x069c, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:307:0x06c6, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:311:0x06f0, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:313:0x0714, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:317:0x0734, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:319:0x0759, please report this as an issue */
            @NotNull
            public final Start fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                Class cls;
                String str;
                String str2;
                String strOptString;
                JsonValue jsonValue2;
                KClass orCreateKotlinClass;
                Object jsonValue3;
                String strOptString2;
                Object objOptMap;
                Object objOptList;
                String str3;
                JsonValue jsonValue4;
                KClass orCreateKotlinClass2;
                String str4;
                JsonSerializable jsonValue5;
                JsonMap jsonMapOptMap;
                JsonSerializable jsonSerializableOptList;
                JsonMap jsonMap;
                JsonMap jsonMap2;
                Object objOptString;
                JsonValue jsonValue6;
                KClass orCreateKotlinClass3;
                Object jsonValue7;
                String strOptString3;
                Object objOptMap2;
                Object objOptList2;
                Long lValueOf;
                JsonValue jsonValue8;
                KClass orCreateKotlinClass4;
                Object jsonValue9;
                String strOptString4;
                Object objOptMap3;
                Object objOptList3;
                Long lValueOf2;
                Object objOptString2;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                JsonMap jsonMapRequireMap = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue10 = jsonMapRequireMap.get("name");
                if (jsonValue10 == null) {
                    throw new JsonException("Missing required field: 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue10.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString = (String) Boolean.valueOf(jsonValue10.getBoolean(false));
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                cls = ULong.class;
                                str = (String) Long.valueOf(jsonValue10.getLong(0L));
                            } else {
                                cls = ULong.class;
                                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls))) {
                                    str = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue10.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    str = (String) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    str = (String) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    str = (String) Integer.valueOf(jsonValue10.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    str = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue10.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    Object objOptList4 = jsonValue10.optList();
                                    if (objOptList4 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    str = (String) objOptList4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    Object objOptMap4 = jsonValue10.optMap();
                                    if (objOptMap4 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    str = (String) objOptMap4;
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Object jsonValue11 = jsonValue10.getJsonValue();
                                    if (jsonValue11 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    str = (String) jsonValue11;
                                }
                            }
                            str2 = str;
                        }
                        jsonValue2 = jsonMapRequireMap.get("type");
                        if (jsonValue2 != null) {
                            throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString2 = jsonValue2.optString();
                            if (strOptString2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString2 = jsonValue2.optString();
                            if (strOptString2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString2 = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString2 = (String) Long.valueOf(jsonValue2.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                            strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString2 = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString2 = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString2 = (String) Integer.valueOf(jsonValue2.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList = jsonValue2.optList();
                            if (objOptList != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap = jsonValue2.optMap();
                            if (objOptMap != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptMap;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue3 = jsonValue2.getJsonValue();
                            if (jsonValue3 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) jsonValue3;
                        }
                        str3 = strOptString2;
                        jsonValue4 = jsonMapRequireMap.get("content");
                        if (jsonValue4 != null) {
                            throw new JsonException("Missing required field: 'content" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            objOptString2 = jsonValue4.optString();
                            if (objOptString2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMap2 = (JsonMap) objOptString2;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    jsonMap2 = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str4 = "' for field '";
                                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
                                    } else {
                                        str4 = "' for field '";
                                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                            jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                            jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                            jsonSerializableOptList = jsonValue4.optList();
                                            if (jsonSerializableOptList != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                            }
                                            jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                            jsonMapOptMap = jsonValue4.optMap();
                                            if (jsonMapOptMap == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                            }
                                        } else {
                                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str4 + "content" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            jsonValue5 = jsonValue4.getJsonValue();
                                            if (jsonValue5 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                            }
                                            jsonMapOptMap = (JsonMap) jsonValue5;
                                        }
                                    }
                                    jsonMap = jsonMapOptMap;
                                }
                                jsonValue6 = jsonMapRequireMap.get("timestamp");
                                if (jsonValue6 == null) {
                                    strOptString3 = null;
                                } else {
                                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString3 = jsonValue6.optString();
                                        if (strOptString3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString3 = jsonValue6.optString();
                                        if (strOptString3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList2 = jsonValue6.optList();
                                        if (objOptList2 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString3 = (String) objOptList2;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap2 = jsonValue6.optMap();
                                        if (objOptMap2 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString3 = (String) objOptMap2;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue7 = jsonValue6.getJsonValue();
                                        if (jsonValue7 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString3 = (String) jsonValue7;
                                    }
                                }
                                if (strOptString3 != null) {
                                    lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                                } else {
                                    lValueOf = null;
                                }
                                jsonValue8 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                                if (jsonValue8 == null) {
                                    strOptString4 = null;
                                } else {
                                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList3 = jsonValue8.optList();
                                        if (objOptList3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString4 = (String) objOptList3;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap3 = jsonValue8.optMap();
                                        if (objOptMap3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString4 = (String) objOptMap3;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue9 = jsonValue8.getJsonValue();
                                        if (jsonValue9 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        strOptString4 = (String) jsonValue9;
                                    }
                                }
                                if (strOptString4 != null) {
                                    lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString4));
                                } else {
                                    lValueOf2 = null;
                                }
                                return new Start(str2, str3, jsonMap, lValueOf, lValueOf2);
                            }
                            objOptString = jsonValue4.optString();
                            if (objOptString != null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMap2 = (JsonMap) objOptString;
                        }
                        jsonMap = jsonMap2;
                        str4 = "' for field '";
                        jsonValue6 = jsonMapRequireMap.get("timestamp");
                        if (jsonValue6 == null) {
                            strOptString3 = null;
                        } else {
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue6.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue6.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue7 = jsonValue6.getJsonValue();
                                if (jsonValue7 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue7;
                            }
                        }
                        if (strOptString3 != null) {
                            lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                        } else {
                            lValueOf = null;
                        }
                        jsonValue8 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                        if (jsonValue8 == null) {
                            strOptString4 = null;
                        } else {
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList3 = jsonValue8.optList();
                                if (objOptList3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString4 = (String) objOptList3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap3 = jsonValue8.optMap();
                                if (objOptMap3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString4 = (String) objOptMap3;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue9 = jsonValue8.getJsonValue();
                                if (jsonValue9 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString4 = (String) jsonValue9;
                            }
                        }
                        if (strOptString4 != null) {
                            lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString4));
                        } else {
                            lValueOf2 = null;
                        }
                        return new Start(str2, str3, jsonMap, lValueOf, lValueOf2);
                    }
                    strOptString = jsonValue10.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
                str2 = strOptString;
                cls = ULong.class;
                jsonValue2 = jsonMapRequireMap.get("type");
                if (jsonValue2 != null) {
                    throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString2 = jsonValue2.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue2.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString2 = (String) Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                    strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList = jsonValue2.optList();
                    if (objOptList != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap = jsonValue2.optMap();
                    if (objOptMap != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptMap;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) jsonValue3;
                }
                str3 = strOptString2;
                jsonValue4 = jsonMapRequireMap.get("content");
                if (jsonValue4 != null) {
                    throw new JsonException("Missing required field: 'content" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString2 = jsonValue4.optString();
                    if (objOptString2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMap2 = (JsonMap) objOptString2;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMap2 = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str4 = "' for field '";
                                jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
                            } else {
                                str4 = "' for field '";
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                    jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    jsonSerializableOptList = jsonValue4.optList();
                                    if (jsonSerializableOptList != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                    }
                                    jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    jsonMapOptMap = jsonValue4.optMap();
                                    if (jsonMapOptMap == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                    }
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str4 + "content" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue5 = jsonValue4.getJsonValue();
                                    if (jsonValue5 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                    }
                                    jsonMapOptMap = (JsonMap) jsonValue5;
                                }
                            }
                            jsonMap = jsonMapOptMap;
                        }
                        jsonValue6 = jsonMapRequireMap.get("timestamp");
                        if (jsonValue6 == null) {
                            strOptString3 = null;
                        } else {
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue6.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue6.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue7 = jsonValue6.getJsonValue();
                                if (jsonValue7 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue7;
                            }
                        }
                        if (strOptString3 != null) {
                            lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                        } else {
                            lValueOf = null;
                        }
                        jsonValue8 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                        if (jsonValue8 == null) {
                            strOptString4 = null;
                        } else {
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList3 = jsonValue8.optList();
                                if (objOptList3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString4 = (String) objOptList3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap3 = jsonValue8.optMap();
                                if (objOptMap3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString4 = (String) objOptMap3;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue9 = jsonValue8.getJsonValue();
                                if (jsonValue9 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString4 = (String) jsonValue9;
                            }
                        }
                        if (strOptString4 != null) {
                            lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString4));
                        } else {
                            lValueOf2 = null;
                        }
                        return new Start(str2, str3, jsonMap, lValueOf, lValueOf2);
                    }
                    objOptString = jsonValue4.optString();
                    if (objOptString != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMap2 = (JsonMap) objOptString;
                }
                jsonMap = jsonMap2;
                str4 = "' for field '";
                jsonValue6 = jsonMapRequireMap.get("timestamp");
                if (jsonValue6 == null) {
                    strOptString3 = null;
                } else {
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue6.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString3 = jsonValue6.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList2 = jsonValue6.optList();
                        if (objOptList2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap2 = jsonValue6.optMap();
                        if (objOptMap2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptMap2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue7 = jsonValue6.getJsonValue();
                        if (jsonValue7 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) jsonValue7;
                    }
                }
                if (strOptString3 != null) {
                    lValueOf = Long.valueOf(DateUtils.parseIso8601(strOptString3));
                } else {
                    lValueOf = null;
                }
                jsonValue8 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                if (jsonValue8 == null) {
                    strOptString4 = null;
                } else {
                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString4 = jsonValue8.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString4 = jsonValue8.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList3 = jsonValue8.optList();
                        if (objOptList3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) objOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap3 = jsonValue8.optMap();
                        if (objOptMap3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) objOptMap3;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str4 + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue9 = jsonValue8.getJsonValue();
                        if (jsonValue9 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) jsonValue9;
                    }
                }
                if (strOptString4 != null) {
                    lValueOf2 = Long.valueOf(DateUtils.parseIso8601(strOptString4));
                } else {
                    lValueOf2 = null;
                }
                return new Start(str2, str3, jsonMap, lValueOf, lValueOf2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Start(@NotNull String name, @NotNull String type, @NotNull JsonMap content, @Nullable Long l, @Nullable Long l2) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(content, "content");
            this.name = name;
            this.type = type;
            this.content = content;
            this.timestamp = l;
            this.dismissalTimestamp = l2;
        }
    }

    @Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class List extends LiveUpdateRequest {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String type;

        public static /* synthetic */ List copy$default(List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = list.type;
            }
            return list.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List copy(@NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new List(type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof List) && Intrinsics.areEqual(this.type, ((List) other).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "List(type=" + this.type + ")";
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List$Companion\n*L\n159#1:174,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final List fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                String strOptString;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                JsonMap jsonMapRequireMap = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue2 = jsonMapRequireMap.get("type");
                if (jsonValue2 == null) {
                    throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue2.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue2.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue3;
                }
                return new List(strOptString);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public List(@NotNull String type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
