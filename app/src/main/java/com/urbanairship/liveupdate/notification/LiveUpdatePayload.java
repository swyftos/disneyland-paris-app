package com.urbanairship.liveupdate.notification;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.liveupdate.LiveUpdateEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 '2\u00020\u0001:\u0001'B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006("}, m1836d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload;", "", "name", "", "event", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "type", "dismissalDate", "", "timestamp", "content", "Lcom/urbanairship/json/JsonMap;", "(Ljava/lang/String;Lcom/urbanairship/liveupdate/LiveUpdateEvent;Ljava/lang/String;Ljava/lang/Long;JLcom/urbanairship/json/JsonMap;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEvent", "()Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/urbanairship/liveupdate/LiveUpdateEvent;Ljava/lang/String;Ljava/lang/Long;JLcom/urbanairship/json/JsonMap;)Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final /* data */ class LiveUpdatePayload {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonMap content;
    private final Long dismissalDate;
    private final LiveUpdateEvent event;
    private final String name;
    private final long timestamp;
    private final String type;

    public static /* synthetic */ LiveUpdatePayload copy$default(LiveUpdatePayload liveUpdatePayload, String str, LiveUpdateEvent liveUpdateEvent, String str2, Long l, long j, JsonMap jsonMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveUpdatePayload.name;
        }
        if ((i & 2) != 0) {
            liveUpdateEvent = liveUpdatePayload.event;
        }
        LiveUpdateEvent liveUpdateEvent2 = liveUpdateEvent;
        if ((i & 4) != 0) {
            str2 = liveUpdatePayload.type;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            l = liveUpdatePayload.dismissalDate;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            j = liveUpdatePayload.timestamp;
        }
        long j2 = j;
        if ((i & 32) != 0) {
            jsonMap = liveUpdatePayload.content;
        }
        return liveUpdatePayload.copy(str, liveUpdateEvent2, str3, l2, j2, jsonMap);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LiveUpdateEvent getEvent() {
        return this.event;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getDismissalDate() {
        return this.dismissalDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final JsonMap getContent() {
        return this.content;
    }

    @NotNull
    public final LiveUpdatePayload copy(@NotNull String name, @NotNull LiveUpdateEvent event, @Nullable String type, @Nullable Long dismissalDate, long timestamp, @NotNull JsonMap content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(content, "content");
        return new LiveUpdatePayload(name, event, type, dismissalDate, timestamp, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveUpdatePayload)) {
            return false;
        }
        LiveUpdatePayload liveUpdatePayload = (LiveUpdatePayload) other;
        return Intrinsics.areEqual(this.name, liveUpdatePayload.name) && this.event == liveUpdatePayload.event && Intrinsics.areEqual(this.type, liveUpdatePayload.type) && Intrinsics.areEqual(this.dismissalDate, liveUpdatePayload.dismissalDate) && this.timestamp == liveUpdatePayload.timestamp && Intrinsics.areEqual(this.content, liveUpdatePayload.content);
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.event.hashCode()) * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.dismissalDate;
        return ((((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveUpdatePayload(name=" + this.name + ", event=" + this.event + ", type=" + this.type + ", dismissalDate=" + this.dismissalDate + ", timestamp=" + this.timestamp + ", content=" + this.content + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public LiveUpdatePayload(@NotNull String name, @NotNull LiveUpdateEvent event, @Nullable String str, @Nullable Long l, long j, @NotNull JsonMap content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(content, "content");
        this.name = name;
        this.event = event;
        this.type = str;
        this.dismissalDate = l;
        this.timestamp = j;
        this.content = content;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final LiveUpdateEvent getEvent() {
        return this.event;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Long getDismissalDate() {
        return this.dismissalDate;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final JsonMap getContent() {
        return this.content;
    }

    @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/liveupdate/notification/LiveUpdatePayload;", "json", "Lcom/urbanairship/json/JsonMap;", "", "fromJson$urbanairship_live_update_release", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nLiveUpdatePayload.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatePayload.kt\ncom/urbanairship/liveupdate/notification/LiveUpdatePayload$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/liveupdate/util/JsonExtensionsKt\n*L\n1#1,67:1\n1#2:68\n36#3,11:69\n36#3,11:80\n57#3,11:91\n57#3,11:102\n36#3,11:113\n*S KotlinDebug\n*F\n+ 1 LiveUpdatePayload.kt\ncom/urbanairship/liveupdate/notification/LiveUpdatePayload$Companion\n*L\n57#1:69,11\n58#1:80,11\n59#1:91,11\n60#1:102,11\n61#1:113,11\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final LiveUpdatePayload fromJson$urbanairship_live_update_release(@NotNull String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JsonMap map = JsonValue.parseString(json).getMap();
                if (map != null) {
                    return LiveUpdatePayload.INSTANCE.fromJson(map);
                }
                return null;
            } catch (Exception e) {
                UALog.m1756w(e, "Failed to parse live update payload: " + json, new Object[0]);
                return null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0234  */
        /* JADX WARN: Code duplicated, block: B:102:0x0240  */
        /* JADX WARN: Code duplicated, block: B:103:0x024c  */
        /* JADX WARN: Code duplicated, block: B:105:0x0258  */
        /* JADX WARN: Code duplicated, block: B:106:0x0269  */
        /* JADX WARN: Code duplicated, block: B:108:0x0278  */
        /* JADX WARN: Code duplicated, block: B:109:0x0285  */
        /* JADX WARN: Code duplicated, block: B:111:0x028f  */
        /* JADX WARN: Code duplicated, block: B:112:0x029b  */
        /* JADX WARN: Code duplicated, block: B:114:0x02a5  */
        /* JADX WARN: Code duplicated, block: B:116:0x02ab  */
        /* JADX WARN: Code duplicated, block: B:117:0x02ae  */
        /* JADX WARN: Code duplicated, block: B:119:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:121:0x02be  */
        /* JADX WARN: Code duplicated, block: B:123:0x02c4  */
        /* JADX WARN: Code duplicated, block: B:124:0x02c7  */
        /* JADX WARN: Code duplicated, block: B:126:0x02cd  */
        /* JADX WARN: Code duplicated, block: B:128:0x02d7  */
        /* JADX WARN: Code duplicated, block: B:130:0x02dd  */
        /* JADX WARN: Code duplicated, block: B:134:0x02ea  */
        /* JADX WARN: Code duplicated, block: B:135:0x02f0  */
        /* JADX WARN: Code duplicated, block: B:137:0x0301  */
        /* JADX WARN: Code duplicated, block: B:139:0x030c  */
        /* JADX WARN: Code duplicated, block: B:141:0x0318  */
        /* JADX WARN: Code duplicated, block: B:142:0x0324  */
        /* JADX WARN: Code duplicated, block: B:144:0x0330  */
        /* JADX WARN: Code duplicated, block: B:145:0x033e  */
        /* JADX WARN: Code duplicated, block: B:147:0x034d  */
        /* JADX WARN: Code duplicated, block: B:148:0x035a  */
        /* JADX WARN: Code duplicated, block: B:150:0x0364  */
        /* JADX WARN: Code duplicated, block: B:151:0x0370  */
        /* JADX WARN: Code duplicated, block: B:153:0x037a  */
        /* JADX WARN: Code duplicated, block: B:154:0x0381  */
        /* JADX WARN: Code duplicated, block: B:156:0x038b  */
        /* JADX WARN: Code duplicated, block: B:157:0x0392  */
        /* JADX WARN: Code duplicated, block: B:159:0x039c  */
        /* JADX WARN: Code duplicated, block: B:162:0x03a6  */
        /* JADX WARN: Code duplicated, block: B:163:0x03b4  */
        /* JADX WARN: Code duplicated, block: B:166:0x03bf  */
        /* JADX WARN: Code duplicated, block: B:168:0x03d2  */
        /* JADX WARN: Code duplicated, block: B:170:0x03d8  */
        /* JADX WARN: Code duplicated, block: B:171:0x03dc  */
        /* JADX WARN: Code duplicated, block: B:173:0x03e2  */
        /* JADX WARN: Code duplicated, block: B:175:0x03ee  */
        /* JADX WARN: Code duplicated, block: B:176:0x03fb  */
        /* JADX WARN: Code duplicated, block: B:178:0x0407  */
        /* JADX WARN: Code duplicated, block: B:179:0x0413  */
        /* JADX WARN: Code duplicated, block: B:181:0x0421  */
        /* JADX WARN: Code duplicated, block: B:182:0x042e  */
        /* JADX WARN: Code duplicated, block: B:184:0x0438  */
        /* JADX WARN: Code duplicated, block: B:185:0x0444  */
        /* JADX WARN: Code duplicated, block: B:187:0x044e  */
        /* JADX WARN: Code duplicated, block: B:189:0x0454  */
        /* JADX WARN: Code duplicated, block: B:190:0x0457  */
        /* JADX WARN: Code duplicated, block: B:192:0x045d  */
        /* JADX WARN: Code duplicated, block: B:194:0x0467  */
        /* JADX WARN: Code duplicated, block: B:196:0x046d  */
        /* JADX WARN: Code duplicated, block: B:197:0x0470  */
        /* JADX WARN: Code duplicated, block: B:199:0x0476  */
        /* JADX WARN: Code duplicated, block: B:201:0x0480  */
        /* JADX WARN: Code duplicated, block: B:203:0x0486  */
        /* JADX WARN: Code duplicated, block: B:206:0x049d  */
        /* JADX WARN: Code duplicated, block: B:208:0x04a3  */
        /* JADX WARN: Code duplicated, block: B:210:0x04c9  */
        /* JADX WARN: Code duplicated, block: B:212:0x04e5  */
        /* JADX WARN: Code duplicated, block: B:214:0x050d  */
        /* JADX WARN: Code duplicated, block: B:216:0x0513  */
        /* JADX WARN: Code duplicated, block: B:218:0x0539  */
        /* JADX WARN: Code duplicated, block: B:220:0x053f  */
        /* JADX WARN: Code duplicated, block: B:222:0x0565  */
        /* JADX WARN: Code duplicated, block: B:52:0x0134  */
        /* JADX WARN: Code duplicated, block: B:54:0x0145  */
        /* JADX WARN: Code duplicated, block: B:57:0x014f  */
        /* JADX WARN: Code duplicated, block: B:59:0x0155  */
        /* JADX WARN: Code duplicated, block: B:61:0x0161  */
        /* JADX WARN: Code duplicated, block: B:62:0x016d  */
        /* JADX WARN: Code duplicated, block: B:64:0x0179  */
        /* JADX WARN: Code duplicated, block: B:65:0x0189  */
        /* JADX WARN: Code duplicated, block: B:67:0x0197  */
        /* JADX WARN: Code duplicated, block: B:68:0x01a4  */
        /* JADX WARN: Code duplicated, block: B:70:0x01ae  */
        /* JADX WARN: Code duplicated, block: B:71:0x01ba  */
        /* JADX WARN: Code duplicated, block: B:73:0x01c4  */
        /* JADX WARN: Code duplicated, block: B:75:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:76:0x01cd  */
        /* JADX WARN: Code duplicated, block: B:78:0x01d3  */
        /* JADX WARN: Code duplicated, block: B:80:0x01dd  */
        /* JADX WARN: Code duplicated, block: B:82:0x01e3  */
        /* JADX WARN: Code duplicated, block: B:83:0x01e6  */
        /* JADX WARN: Code duplicated, block: B:85:0x01ec  */
        /* JADX WARN: Code duplicated, block: B:87:0x01f6  */
        /* JADX WARN: Code duplicated, block: B:89:0x01fc  */
        /* JADX WARN: Code duplicated, block: B:92:0x020c  */
        /* JADX WARN: Code duplicated, block: B:93:0x0212  */
        /* JADX WARN: Code duplicated, block: B:95:0x0223  */
        /* JADX WARN: Code duplicated, block: B:98:0x022e  */
        /* JADX WARN: Instruction removed from duplicated block: B:208:0x04a3, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:210:0x04c9, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:212:0x04e5, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:216:0x0513, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:220:0x053f, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:222:0x0565, please report this as an issue */
        private final LiveUpdatePayload fromJson(JsonMap json) throws JsonException {
            JsonMap jsonMapOptMap;
            String str;
            String strOptString;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            String str2;
            Object jsonValue2;
            String strOptString2;
            Object objOptMap;
            Object objOptList;
            LiveUpdateEvent liveUpdateEventFrom;
            JsonValue jsonValue3;
            KClass orCreateKotlinClass2;
            String str3;
            String str4;
            Object jsonValue4;
            String strOptString3;
            Object objOptMap2;
            Object objOptList2;
            String str5;
            JsonValue jsonValue5;
            KClass orCreateKotlinClass3;
            LiveUpdateEvent liveUpdateEvent;
            String str6;
            Long lValueOf;
            Long lValueOf2;
            JsonValue jsonValue6;
            KClass orCreateKotlinClass4;
            Object jsonValue7;
            Long lValueOf3;
            Object objOptMap3;
            Object objOptList3;
            Object objOptString;
            JsonValue jsonValueOpt = json.opt("content_state");
            if (jsonValueOpt.isJsonMap()) {
                jsonMapOptMap = jsonValueOpt.optMap();
            } else if (jsonValueOpt.isString()) {
                jsonMapOptMap = JsonValue.parseString(jsonValueOpt.getString()).optMap();
            } else {
                UALog.m1754w("Invalid Live Update content_state: '" + jsonValueOpt + CoreConstants.SINGLE_QUOTE_CHAR, new Object[0]);
                jsonMapOptMap = JsonMap.EMPTY_MAP;
            }
            JsonMap jsonMap = jsonMapOptMap;
            Intrinsics.checkNotNullExpressionValue(jsonMap, "let(...)");
            JsonValue jsonValue8 = json.get("name");
            if (jsonValue8 == null) {
                throw new JsonException("Missing required field: 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue8);
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
            if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "Missing required field: '";
                    strOptString = (String) Long.valueOf(jsonValue8.getLong(0L));
                } else {
                    str = "Missing required field: '";
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue8.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList4 = jsonValue8.optList();
                        if (objOptList4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap4 = jsonValue8.optMap();
                        if (objOptMap4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap4;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue9 = jsonValue8.getJsonValue();
                        if (jsonValue9 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue9;
                    }
                }
                jsonValue = json.get("event");
                if (jsonValue != null) {
                    throw new JsonException(str + "event" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Intrinsics.checkNotNull(jsonValue);
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str2 = str;
                        strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else {
                        str2 = str;
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList = jsonValue.optList();
                            if (objOptList != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap = jsonValue.optMap();
                            if (objOptMap != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptMap;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'event" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue2 = jsonValue.getJsonValue();
                            if (jsonValue2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) jsonValue2;
                        }
                    }
                    liveUpdateEventFrom = LiveUpdateEvent.INSTANCE.from(strOptString2);
                    jsonValue3 = json.get("type");
                    if (jsonValue3 == null) {
                        str3 = "' for field '";
                        str4 = "Invalid type '";
                        str5 = null;
                    } else {
                        Intrinsics.checkNotNull(jsonValue3);
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString3 = jsonValue3.optString();
                            if (strOptString3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str3 = "' for field '";
                                str4 = "Invalid type '";
                                strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                            } else {
                                str3 = "' for field '";
                                str4 = "Invalid type '";
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList2 = jsonValue3.optList();
                                    if (objOptList2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString3 = (String) objOptList2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap2 = jsonValue3.optMap();
                                    if (objOptMap2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString3 = (String) objOptMap2;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str4 + String.class.getSimpleName() + str3 + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue4 = jsonValue3.getJsonValue();
                                    if (jsonValue4 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString3 = (String) jsonValue4;
                                }
                            }
                            str5 = strOptString3;
                        }
                        str3 = "' for field '";
                        str4 = "Invalid type '";
                        str5 = strOptString3;
                    }
                    jsonValue5 = json.get("dismissal_date");
                    if (jsonValue5 == null) {
                        liveUpdateEvent = liveUpdateEventFrom;
                        str6 = str5;
                        lValueOf = null;
                    } else {
                        Intrinsics.checkNotNull(jsonValue5);
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            lValueOf = (Long) jsonValue5.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            lValueOf = (Long) Boolean.valueOf(jsonValue5.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            liveUpdateEvent = liveUpdateEventFrom;
                            str6 = str5;
                            lValueOf = Long.valueOf(jsonValue5.getLong(0L));
                        } else {
                            liveUpdateEvent = liveUpdateEventFrom;
                            str6 = str5;
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                lValueOf = (Long) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                lValueOf = (Long) Integer.valueOf(jsonValue5.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                lValueOf = (Long) jsonValue5.optList();
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                lValueOf = (Long) jsonValue5.optMap();
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "dismissal_date" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                lValueOf = (Long) jsonValue5.getJsonValue();
                            }
                        }
                        liveUpdateEvent = liveUpdateEventFrom;
                        str6 = str5;
                    }
                    if (lValueOf != null) {
                        lValueOf2 = Long.valueOf(lValueOf.longValue() * ((long) 1000));
                    } else {
                        lValueOf2 = null;
                    }
                    jsonValue6 = json.get("timestamp");
                    if (jsonValue6 != null) {
                        throw new JsonException(str2 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue6);
                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString = jsonValue6.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf3 = (Long) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf3 = (Long) Boolean.valueOf(jsonValue6.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf3 = Long.valueOf(jsonValue6.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf3 = (Long) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        lValueOf3 = (Long) Integer.valueOf(jsonValue6.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList3 = jsonValue6.optList();
                        if (objOptList3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf3 = (Long) objOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap3 = jsonValue6.optMap();
                        if (objOptMap3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf3 = (Long) objOptMap3;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue7 = jsonValue6.getJsonValue();
                        if (jsonValue7 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf3 = (Long) jsonValue7;
                    }
                    return new LiveUpdatePayload(strOptString, liveUpdateEvent, str6, lValueOf2, lValueOf3.longValue() * ((long) 1000), jsonMap);
                }
                strOptString2 = jsonValue.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                str2 = str;
                liveUpdateEventFrom = LiveUpdateEvent.INSTANCE.from(strOptString2);
                jsonValue3 = json.get("type");
                if (jsonValue3 == null) {
                    str3 = "' for field '";
                    str4 = "Invalid type '";
                    str5 = null;
                } else {
                    Intrinsics.checkNotNull(jsonValue3);
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue3.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str3 = "' for field '";
                            str4 = "Invalid type '";
                            strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                        } else {
                            str3 = "' for field '";
                            str4 = "Invalid type '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue3.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue3.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str4 + String.class.getSimpleName() + str3 + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue4 = jsonValue3.getJsonValue();
                                if (jsonValue4 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue4;
                            }
                        }
                        str5 = strOptString3;
                    }
                    str3 = "' for field '";
                    str4 = "Invalid type '";
                    str5 = strOptString3;
                }
                jsonValue5 = json.get("dismissal_date");
                if (jsonValue5 == null) {
                    liveUpdateEvent = liveUpdateEventFrom;
                    str6 = str5;
                    lValueOf = null;
                } else {
                    Intrinsics.checkNotNull(jsonValue5);
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        lValueOf = (Long) jsonValue5.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf = (Long) Boolean.valueOf(jsonValue5.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        liveUpdateEvent = liveUpdateEventFrom;
                        str6 = str5;
                        lValueOf = Long.valueOf(jsonValue5.getLong(0L));
                    } else {
                        liveUpdateEvent = liveUpdateEventFrom;
                        str6 = str5;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            lValueOf = (Long) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            lValueOf = (Long) Integer.valueOf(jsonValue5.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            lValueOf = (Long) jsonValue5.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            lValueOf = (Long) jsonValue5.optMap();
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "dismissal_date" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            lValueOf = (Long) jsonValue5.getJsonValue();
                        }
                    }
                    liveUpdateEvent = liveUpdateEventFrom;
                    str6 = str5;
                }
                if (lValueOf != null) {
                    lValueOf2 = Long.valueOf(lValueOf.longValue() * ((long) 1000));
                } else {
                    lValueOf2 = null;
                }
                jsonValue6 = json.get("timestamp");
                if (jsonValue6 != null) {
                    throw new JsonException(str2 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Intrinsics.checkNotNull(jsonValue6);
                orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString = jsonValue6.optString();
                    if (objOptString != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf3 = (Long) Boolean.valueOf(jsonValue6.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf3 = Long.valueOf(jsonValue6.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf3 = (Long) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    lValueOf3 = (Long) Integer.valueOf(jsonValue6.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList3 = jsonValue6.optList();
                    if (objOptList3 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) objOptList3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap3 = jsonValue6.optMap();
                    if (objOptMap3 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) objOptMap3;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue7 = jsonValue6.getJsonValue();
                    if (jsonValue7 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) jsonValue7;
                }
                return new LiveUpdatePayload(strOptString, liveUpdateEvent, str6, lValueOf2, lValueOf3.longValue() * ((long) 1000), jsonMap);
            }
            strOptString = jsonValue8.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            str = "Missing required field: '";
            jsonValue = json.get("event");
            if (jsonValue != null) {
                throw new JsonException(str + "event" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue);
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str2 = str;
                    strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                } else {
                    str2 = str;
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue.optList();
                        if (objOptList != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'event" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) jsonValue2;
                    }
                }
                liveUpdateEventFrom = LiveUpdateEvent.INSTANCE.from(strOptString2);
                jsonValue3 = json.get("type");
                if (jsonValue3 == null) {
                    str3 = "' for field '";
                    str4 = "Invalid type '";
                    str5 = null;
                } else {
                    Intrinsics.checkNotNull(jsonValue3);
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue3.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str3 = "' for field '";
                            str4 = "Invalid type '";
                            strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                        } else {
                            str3 = "' for field '";
                            str4 = "Invalid type '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue3.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue3.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str4 + String.class.getSimpleName() + str3 + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue4 = jsonValue3.getJsonValue();
                                if (jsonValue4 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue4;
                            }
                        }
                        str5 = strOptString3;
                    }
                    str3 = "' for field '";
                    str4 = "Invalid type '";
                    str5 = strOptString3;
                }
                jsonValue5 = json.get("dismissal_date");
                if (jsonValue5 == null) {
                    liveUpdateEvent = liveUpdateEventFrom;
                    str6 = str5;
                    lValueOf = null;
                } else {
                    Intrinsics.checkNotNull(jsonValue5);
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        lValueOf = (Long) jsonValue5.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf = (Long) Boolean.valueOf(jsonValue5.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        liveUpdateEvent = liveUpdateEventFrom;
                        str6 = str5;
                        lValueOf = Long.valueOf(jsonValue5.getLong(0L));
                    } else {
                        liveUpdateEvent = liveUpdateEventFrom;
                        str6 = str5;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            lValueOf = (Long) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            lValueOf = (Long) Integer.valueOf(jsonValue5.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            lValueOf = (Long) jsonValue5.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            lValueOf = (Long) jsonValue5.optMap();
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "dismissal_date" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            lValueOf = (Long) jsonValue5.getJsonValue();
                        }
                    }
                    liveUpdateEvent = liveUpdateEventFrom;
                    str6 = str5;
                }
                if (lValueOf != null) {
                    lValueOf2 = Long.valueOf(lValueOf.longValue() * ((long) 1000));
                } else {
                    lValueOf2 = null;
                }
                jsonValue6 = json.get("timestamp");
                if (jsonValue6 != null) {
                    throw new JsonException(str2 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Intrinsics.checkNotNull(jsonValue6);
                orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString = jsonValue6.optString();
                    if (objOptString != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf3 = (Long) Boolean.valueOf(jsonValue6.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf3 = Long.valueOf(jsonValue6.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf3 = (Long) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    lValueOf3 = (Long) Integer.valueOf(jsonValue6.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList3 = jsonValue6.optList();
                    if (objOptList3 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) objOptList3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap3 = jsonValue6.optMap();
                    if (objOptMap3 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) objOptMap3;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue7 = jsonValue6.getJsonValue();
                    if (jsonValue7 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf3 = (Long) jsonValue7;
                }
                return new LiveUpdatePayload(strOptString, liveUpdateEvent, str6, lValueOf2, lValueOf3.longValue() * ((long) 1000), jsonMap);
            }
            strOptString2 = jsonValue.optString();
            if (strOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            str2 = str;
            liveUpdateEventFrom = LiveUpdateEvent.INSTANCE.from(strOptString2);
            jsonValue3 = json.get("type");
            if (jsonValue3 == null) {
                str3 = "' for field '";
                str4 = "Invalid type '";
                str5 = null;
            } else {
                Intrinsics.checkNotNull(jsonValue3);
                orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString3 = jsonValue3.optString();
                    if (strOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str3 = "' for field '";
                        str4 = "Invalid type '";
                        strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                    } else {
                        str3 = "' for field '";
                        str4 = "Invalid type '";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList2 = jsonValue3.optList();
                            if (objOptList2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString3 = (String) objOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap2 = jsonValue3.optMap();
                            if (objOptMap2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString3 = (String) objOptMap2;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str4 + String.class.getSimpleName() + str3 + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue4 = jsonValue3.getJsonValue();
                            if (jsonValue4 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString3 = (String) jsonValue4;
                        }
                    }
                    str5 = strOptString3;
                }
                str3 = "' for field '";
                str4 = "Invalid type '";
                str5 = strOptString3;
            }
            jsonValue5 = json.get("dismissal_date");
            if (jsonValue5 == null) {
                liveUpdateEvent = liveUpdateEventFrom;
                str6 = str5;
                lValueOf = null;
            } else {
                Intrinsics.checkNotNull(jsonValue5);
                orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    lValueOf = (Long) jsonValue5.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    liveUpdateEvent = liveUpdateEventFrom;
                    str6 = str5;
                    lValueOf = Long.valueOf(jsonValue5.getLong(0L));
                } else {
                    liveUpdateEvent = liveUpdateEventFrom;
                    str6 = str5;
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf = (Long) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        lValueOf = (Long) Integer.valueOf(jsonValue5.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        lValueOf = (Long) jsonValue5.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        lValueOf = (Long) jsonValue5.optMap();
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "dismissal_date" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        lValueOf = (Long) jsonValue5.getJsonValue();
                    }
                }
                liveUpdateEvent = liveUpdateEventFrom;
                str6 = str5;
            }
            if (lValueOf != null) {
                lValueOf2 = Long.valueOf(lValueOf.longValue() * ((long) 1000));
            } else {
                lValueOf2 = null;
            }
            jsonValue6 = json.get("timestamp");
            if (jsonValue6 != null) {
                throw new JsonException(str2 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue6);
            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString = jsonValue6.optString();
                if (objOptString != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf3 = (Long) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                lValueOf3 = (Long) Boolean.valueOf(jsonValue6.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                lValueOf3 = Long.valueOf(jsonValue6.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                lValueOf3 = (Long) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                lValueOf3 = (Long) Integer.valueOf(jsonValue6.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                objOptList3 = jsonValue6.optList();
                if (objOptList3 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf3 = (Long) objOptList3;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                objOptMap3 = jsonValue6.optMap();
                if (objOptMap3 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf3 = (Long) objOptMap3;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException(str4 + Long.class.getSimpleName() + str3 + "timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue7 = jsonValue6.getJsonValue();
                if (jsonValue7 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf3 = (Long) jsonValue7;
            }
            return new LiveUpdatePayload(strOptString, liveUpdateEvent, str6, lValueOf2, lValueOf3.longValue() * ((long) 1000), jsonMap);
        }
    }
}
