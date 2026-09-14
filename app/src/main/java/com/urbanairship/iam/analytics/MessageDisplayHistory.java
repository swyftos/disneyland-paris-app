package com.urbanairship.iam.analytics;

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
@Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "Lcom/urbanairship/json/JsonSerializable;", "lastImpression", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "lastDisplay", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "(Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;)V", "getLastDisplay", "()Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "getLastImpression", "()Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "LastDisplay", "LastImpression", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final /* data */ class MessageDisplayHistory implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LastImpression getLastImpression() {
        return this.lastImpression;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
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

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "Lcom/urbanairship/json/JsonSerializable;", "date", "", "triggerSessionId", "", "(JLjava/lang/String;)V", "getDate", "()J", "getTriggerSessionId", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class LastImpression implements JsonSerializable {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getDate() {
            return this.date;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
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

        @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression$Companion;", "", "()V", "KEY_DATE", "", "KEY_TRIGGER_SESSION_ID", "fromJson", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nMessageDisplayHistory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageDisplayHistory.kt\ncom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,114:1\n44#2,15:115\n44#2,15:130\n*S KotlinDebug\n*F\n+ 1 MessageDisplayHistory.kt\ncom/urbanairship/iam/analytics/MessageDisplayHistory$LastImpression$Companion\n*L\n30#1:115,15\n31#1:130,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:100:0x026e  */
            /* JADX WARN: Code duplicated, block: B:101:0x0271  */
            /* JADX WARN: Code duplicated, block: B:103:0x0279  */
            /* JADX WARN: Code duplicated, block: B:105:0x0285  */
            /* JADX WARN: Code duplicated, block: B:107:0x028b  */
            /* JADX WARN: Code duplicated, block: B:108:0x028e  */
            /* JADX WARN: Code duplicated, block: B:110:0x0294  */
            /* JADX WARN: Code duplicated, block: B:112:0x029e  */
            /* JADX WARN: Code duplicated, block: B:114:0x02a4  */
            /* JADX WARN: Code duplicated, block: B:117:0x02aa  */
            /* JADX WARN: Code duplicated, block: B:119:0x02b0  */
            /* JADX WARN: Code duplicated, block: B:121:0x02d4  */
            /* JADX WARN: Code duplicated, block: B:61:0x0174  */
            /* JADX WARN: Code duplicated, block: B:63:0x0184  */
            /* JADX WARN: Code duplicated, block: B:66:0x018c  */
            /* JADX WARN: Code duplicated, block: B:68:0x0192  */
            /* JADX WARN: Code duplicated, block: B:70:0x019c  */
            /* JADX WARN: Code duplicated, block: B:73:0x01a4  */
            /* JADX WARN: Code duplicated, block: B:75:0x01aa  */
            /* JADX WARN: Code duplicated, block: B:77:0x01b6  */
            /* JADX WARN: Code duplicated, block: B:78:0x01c3  */
            /* JADX WARN: Code duplicated, block: B:80:0x01cf  */
            /* JADX WARN: Code duplicated, block: B:81:0x01dd  */
            /* JADX WARN: Code duplicated, block: B:83:0x01eb  */
            /* JADX WARN: Code duplicated, block: B:84:0x01fb  */
            /* JADX WARN: Code duplicated, block: B:86:0x0207  */
            /* JADX WARN: Code duplicated, block: B:87:0x0215  */
            /* JADX WARN: Code duplicated, block: B:89:0x0221  */
            /* JADX WARN: Code duplicated, block: B:90:0x022e  */
            /* JADX WARN: Code duplicated, block: B:92:0x0238  */
            /* JADX WARN: Code duplicated, block: B:93:0x0244  */
            /* JADX WARN: Code duplicated, block: B:95:0x024f  */
            /* JADX WARN: Code duplicated, block: B:96:0x025e  */
            /* JADX WARN: Code duplicated, block: B:98:0x0268  */
            /* JADX WARN: Instruction removed from duplicated block: B:119:0x02b0, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:121:0x02d4, please report this as an issue */
            @NotNull
            public final LastImpression fromJson(@NotNull JsonValue value) throws JsonException {
                String str;
                Long lValueOf;
                long jLongValue;
                JsonValue jsonValue;
                KClass orCreateKotlinClass;
                Object jsonValue2;
                String strOptString;
                Object objOptMap;
                Object objOptList;
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue3 = jsonMapRequireMap.get("date");
                if (jsonValue3 == null) {
                    throw new JsonException("Missing required field: 'date" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue3.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue3.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            lValueOf = Long.valueOf(jsonValue3.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            str = "' for field '";
                            lValueOf = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                        } else {
                            str = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                lValueOf = (Long) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                lValueOf = (Long) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                lValueOf = (Long) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                Object objOptList2 = jsonValue3.optList();
                                if (objOptList2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf = (Long) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                Object objOptMap2 = jsonValue3.optMap();
                                if (objOptMap2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf = (Long) objOptMap2;
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "date" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Object jsonValue4 = jsonValue3.toJsonValue();
                                if (jsonValue4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                }
                                lValueOf = (Long) jsonValue4;
                            }
                        }
                        jLongValue = lValueOf.longValue();
                        jsonValue = jsonMapRequireMap.get("trigger_session_id");
                        if (jsonValue != null) {
                            throw new JsonException("Missing required field: 'trigger_session_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
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
                            strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList = jsonValue.optList();
                            if (objOptList != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap = jsonValue.optMap();
                            if (objOptMap != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) objOptMap;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "trigger_session_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue2 = jsonValue.toJsonValue();
                            if (jsonValue2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) jsonValue2;
                        }
                        return new LastImpression(jLongValue, strOptString);
                    }
                    lValueOf = (Long) Boolean.valueOf(jsonValue3.getBoolean(false));
                }
                str = "' for field '";
                jLongValue = lValueOf.longValue();
                jsonValue = jsonMapRequireMap.get("trigger_session_id");
                if (jsonValue != null) {
                    throw new JsonException("Missing required field: 'trigger_session_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
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
                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList = jsonValue.optList();
                    if (objOptList != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap = jsonValue.optMap();
                    if (objOptMap != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "trigger_session_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue2 = jsonValue.toJsonValue();
                    if (jsonValue2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
                return new LastImpression(jLongValue, strOptString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("date", Long.valueOf(this.date)), TuplesKt.m1842to("trigger_session_id", this.triggerSessionId)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "Lcom/urbanairship/json/JsonSerializable;", "triggerSessionId", "", "(Ljava/lang/String;)V", "getTriggerSessionId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class LastDisplay implements JsonSerializable {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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
        /* JADX INFO: renamed from: component1, reason: from getter */
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

        @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay$Companion;", "", "()V", "KEY_TRIGGER_SESSION_ID", "", "fromJson", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory$LastDisplay;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
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
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("trigger_session_id", this.triggerSessionId)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistory$Companion;", "", "()V", "KEY_LAST_DISPLAY", "", "KEY_LAST_IMPRESSION", "fromJson", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("last_impression", this.lastImpression), TuplesKt.m1842to("last_display", this.lastDisplay)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
