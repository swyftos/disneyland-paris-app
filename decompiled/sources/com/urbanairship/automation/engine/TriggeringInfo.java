package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.deferred.DeferredTriggerContext;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/automation/engine/TriggeringInfo;", "Lcom/urbanairship/json/JsonSerializable;", "context", "Lcom/urbanairship/deferred/DeferredTriggerContext;", "date", "", "(Lcom/urbanairship/deferred/DeferredTriggerContext;J)V", "getContext", "()Lcom/urbanairship/deferred/DeferredTriggerContext;", "getDate", "()J", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class TriggeringInfo implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final DeferredTriggerContext context;
    private final long date;

    public static /* synthetic */ TriggeringInfo copy$default(TriggeringInfo triggeringInfo, DeferredTriggerContext deferredTriggerContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            deferredTriggerContext = triggeringInfo.context;
        }
        if ((i & 2) != 0) {
            j = triggeringInfo.date;
        }
        return triggeringInfo.copy(deferredTriggerContext, j);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final DeferredTriggerContext getContext() {
        return this.context;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    @NotNull
    public final TriggeringInfo copy(@Nullable DeferredTriggerContext context, long date) {
        return new TriggeringInfo(context, date);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TriggeringInfo)) {
            return false;
        }
        TriggeringInfo triggeringInfo = (TriggeringInfo) other;
        return Intrinsics.areEqual(this.context, triggeringInfo.context) && this.date == triggeringInfo.date;
    }

    public int hashCode() {
        DeferredTriggerContext deferredTriggerContext = this.context;
        return ((deferredTriggerContext == null ? 0 : deferredTriggerContext.hashCode()) * 31) + Long.hashCode(this.date);
    }

    @NotNull
    public String toString() {
        return "TriggeringInfo(context=" + this.context + ", date=" + this.date + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TriggeringInfo(@Nullable DeferredTriggerContext deferredTriggerContext, long j) {
        this.context = deferredTriggerContext;
        this.date = j;
    }

    @Nullable
    public final DeferredTriggerContext getContext() {
        return this.context;
    }

    public final long getDate() {
        return this.date;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/automation/engine/TriggeringInfo$Companion;", "", "()V", "CONTEXT", "", "DATE", "fromJson", "Lcom/urbanairship/automation/engine/TriggeringInfo;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTriggeringInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TriggeringInfo.kt\ncom/urbanairship/automation/engine/TriggeringInfo$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,38:1\n1#2:39\n44#3,15:40\n*S KotlinDebug\n*F\n+ 1 TriggeringInfo.kt\ncom/urbanairship/automation/engine/TriggeringInfo$Companion\n*L\n28#1:40,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final TriggeringInfo fromJson(@NotNull JsonValue value) throws JsonException {
            Long lValueOf;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("context");
            DeferredTriggerContext deferredTriggerContextFromJson = jsonValue != null ? DeferredTriggerContext.INSTANCE.fromJson(jsonValue) : null;
            JsonValue jsonValue2 = jsonMapRequireMap.get("date");
            if (jsonValue2 == null) {
                throw new JsonException("Missing required field: 'date" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue2.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue2.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                lValueOf = (Long) Boolean.valueOf(jsonValue2.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                lValueOf = Long.valueOf(jsonValue2.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                lValueOf = (Long) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                lValueOf = (Long) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                lValueOf = (Long) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue2.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue2.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'date" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue3 = jsonValue2.toJsonValue();
                if (jsonValue3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) jsonValue3;
            }
            return new TriggeringInfo(deferredTriggerContextFromJson, lValueOf.longValue());
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("context", this.context), TuplesKt.to("date", Long.valueOf(this.date))).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
