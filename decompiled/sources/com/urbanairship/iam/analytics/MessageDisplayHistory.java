package com.urbanairship.iam.analytics;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "Lcom/urbanairship/json/JsonSerializable;", "lastImpression", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "lastDisplay", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "(Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;)V", "getLastDisplay", "()Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "getLastImpression", "()Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "LastDisplay", "LastImpression", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MessageDisplayHistory implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final LastDisplay lastDisplay;
    private final LastImpression lastImpression;

    public MessageDisplayHistory() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MessageDisplayHistory copy$default(MessageDisplayHistory messageDisplayHistory, LastImpression lastImpression, LastDisplay lastDisplay, int i, Object obj) {
        if ((i & 1) != 0) {
            lastImpression = messageDisplayHistory.lastImpression;
        }
        if ((i & 2) != 0) {
            lastDisplay = messageDisplayHistory.lastDisplay;
        }
        return messageDisplayHistory.copy(lastImpression, lastDisplay);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final LastImpression getLastImpression() {
        return this.lastImpression;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final LastDisplay getLastDisplay() {
        return this.lastDisplay;
    }

    @NotNull
    public final MessageDisplayHistory copy(@Nullable LastImpression lastImpression, @Nullable LastDisplay lastDisplay) {
        return new MessageDisplayHistory(lastImpression, lastDisplay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageDisplayHistory)) {
            return false;
        }
        MessageDisplayHistory messageDisplayHistory = (MessageDisplayHistory) other;
        return Intrinsics.areEqual(this.lastImpression, messageDisplayHistory.lastImpression) && Intrinsics.areEqual(this.lastDisplay, messageDisplayHistory.lastDisplay);
    }

    public int hashCode() {
        LastImpression lastImpression = this.lastImpression;
        int iHashCode = (lastImpression == null ? 0 : lastImpression.hashCode()) * 31;
        LastDisplay lastDisplay = this.lastDisplay;
        return iHashCode + (lastDisplay != null ? lastDisplay.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MessageDisplayHistory(lastImpression=" + this.lastImpression + ", lastDisplay=" + this.lastDisplay + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public MessageDisplayHistory(@Nullable LastImpression lastImpression, @Nullable LastDisplay lastDisplay) {
        this.lastImpression = lastImpression;
        this.lastDisplay = lastDisplay;
    }

    public /* synthetic */ MessageDisplayHistory(LastImpression lastImpression, LastDisplay lastDisplay, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lastImpression, (i & 2) != 0 ? null : lastDisplay);
    }

    @Nullable
    public final LastImpression getLastImpression() {
        return this.lastImpression;
    }

    @Nullable
    public final LastDisplay getLastDisplay() {
        return this.lastDisplay;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "Lcom/urbanairship/json/JsonSerializable;", "date", "", "triggerSessionId", "", "(JLjava/lang/String;)V", "getDate", "()J", "getTriggerSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class LastImpression implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final long date;
        private final String triggerSessionId;

        public static /* synthetic */ LastImpression copy$default(LastImpression lastImpression, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = lastImpression.date;
            }
            if ((i & 2) != 0) {
                str = lastImpression.triggerSessionId;
            }
            return lastImpression.copy(j, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getDate() {
            return this.date;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getTriggerSessionId() {
            return this.triggerSessionId;
        }

        @NotNull
        public final LastImpression copy(long date, @NotNull String triggerSessionId) {
            Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
            return new LastImpression(date, triggerSessionId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LastImpression)) {
                return false;
            }
            LastImpression lastImpression = (LastImpression) other;
            return this.date == lastImpression.date && Intrinsics.areEqual(this.triggerSessionId, lastImpression.triggerSessionId);
        }

        public int hashCode() {
            return (Long.hashCode(this.date) * 31) + this.triggerSessionId.hashCode();
        }

        @NotNull
        public String toString() {
            return "LastImpression(date=" + this.date + ", triggerSessionId=" + this.triggerSessionId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public LastImpression(long j, @NotNull String triggerSessionId) {
            Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
            this.date = j;
            this.triggerSessionId = triggerSessionId;
        }

        public final long getDate() {
            return this.date;
        }

        @NotNull
        public final String getTriggerSessionId() {
            return this.triggerSessionId;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression$Companion;", "", "()V", "KEY_DATE", "", "KEY_TRIGGER_SESSION_ID", "fromJson", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nMessageDisplayHistory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageDisplayHistory.kt\ncom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,114:1\n44#2,15:115\n44#2,15:130\n*S KotlinDebug\n*F\n+ 1 MessageDisplayHistory.kt\ncom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression$Companion\n*L\n30#1:115,15\n31#1:130,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:121:0x02d4  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0174  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.iam.analytics.MessageDisplayHistory.LastImpression fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r21) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 818
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.analytics.MessageDisplayHistory.LastImpression.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.iam.analytics.MessageDisplayHistory$LastImpression");
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("date", Long.valueOf(this.date)), TuplesKt.to("trigger_session_id", this.triggerSessionId)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "Lcom/urbanairship/json/JsonSerializable;", "triggerSessionId", "", "(Ljava/lang/String;)V", "getTriggerSessionId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class LastDisplay implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String triggerSessionId;

        public static /* synthetic */ LastDisplay copy$default(LastDisplay lastDisplay, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = lastDisplay.triggerSessionId;
            }
            return lastDisplay.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getTriggerSessionId() {
            return this.triggerSessionId;
        }

        @NotNull
        public final LastDisplay copy(@NotNull String triggerSessionId) {
            Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
            return new LastDisplay(triggerSessionId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LastDisplay) && Intrinsics.areEqual(this.triggerSessionId, ((LastDisplay) other).triggerSessionId);
        }

        public int hashCode() {
            return this.triggerSessionId.hashCode();
        }

        @NotNull
        public String toString() {
            return "LastDisplay(triggerSessionId=" + this.triggerSessionId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public LastDisplay(@NotNull String triggerSessionId) {
            Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
            this.triggerSessionId = triggerSessionId;
        }

        @NotNull
        public final String getTriggerSessionId() {
            return this.triggerSessionId;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay$Companion;", "", "()V", "KEY_TRIGGER_SESSION_ID", "", "fromJson", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nMessageDisplayHistory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageDisplayHistory.kt\ncom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,114:1\n44#2,15:115\n*S KotlinDebug\n*F\n+ 1 MessageDisplayHistory.kt\ncom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay$Companion\n*L\n52#1:115,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final LastDisplay fromJson(@NotNull JsonValue value) throws JsonException {
                String strOptString;
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("trigger_session_id");
                if (jsonValue == null) {
                    throw new JsonException("Missing required field: 'trigger_session_id" + CoreConstants.SINGLE_QUOTE_CHAR);
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
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'trigger_session_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.toJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
                return new LastDisplay(strOptString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("trigger_session_id", this.triggerSessionId)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$Companion;", "", "()V", "KEY_LAST_DISPLAY", "", "KEY_LAST_IMPRESSION", "fromJson", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final MessageDisplayHistory fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            LastImpression.Companion companion = LastImpression.INSTANCE;
            JsonValue jsonValueRequire = jsonMapRequireMap.require("last_impression");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            LastImpression lastImpressionFromJson = companion.fromJson(jsonValueRequire);
            LastDisplay.Companion companion2 = LastDisplay.INSTANCE;
            JsonValue jsonValueRequire2 = jsonMapRequireMap.require("last_display");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
            return new MessageDisplayHistory(lastImpressionFromJson, companion2.fromJson(jsonValueRequire2));
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("last_impression", this.lastImpression), TuplesKt.to("last_display", this.lastDisplay)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
