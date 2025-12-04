package com.urbanairship.automation.deferred;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/automation/deferred/DeferredScheduleResult;", "", "isAudienceMatch", "", "message", "Lcom/urbanairship/iam/InAppMessage;", "actions", "Lcom/urbanairship/json/JsonValue;", "(ZLcom/urbanairship/iam/InAppMessage;Lcom/urbanairship/json/JsonValue;)V", "getActions", "()Lcom/urbanairship/json/JsonValue;", "()Z", "getMessage", "()Lcom/urbanairship/iam/InAppMessage;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeferredScheduleResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonValue actions;
    private final boolean isAudienceMatch;
    private final InAppMessage message;

    public static /* synthetic */ DeferredScheduleResult copy$default(DeferredScheduleResult deferredScheduleResult, boolean z, InAppMessage inAppMessage, JsonValue jsonValue, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deferredScheduleResult.isAudienceMatch;
        }
        if ((i & 2) != 0) {
            inAppMessage = deferredScheduleResult.message;
        }
        if ((i & 4) != 0) {
            jsonValue = deferredScheduleResult.actions;
        }
        return deferredScheduleResult.copy(z, inAppMessage, jsonValue);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsAudienceMatch() {
        return this.isAudienceMatch;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final InAppMessage getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final JsonValue getActions() {
        return this.actions;
    }

    @NotNull
    public final DeferredScheduleResult copy(boolean isAudienceMatch, @Nullable InAppMessage message, @Nullable JsonValue actions) {
        return new DeferredScheduleResult(isAudienceMatch, message, actions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeferredScheduleResult)) {
            return false;
        }
        DeferredScheduleResult deferredScheduleResult = (DeferredScheduleResult) other;
        return this.isAudienceMatch == deferredScheduleResult.isAudienceMatch && Intrinsics.areEqual(this.message, deferredScheduleResult.message) && Intrinsics.areEqual(this.actions, deferredScheduleResult.actions);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isAudienceMatch) * 31;
        InAppMessage inAppMessage = this.message;
        int iHashCode2 = (iHashCode + (inAppMessage == null ? 0 : inAppMessage.hashCode())) * 31;
        JsonValue jsonValue = this.actions;
        return iHashCode2 + (jsonValue != null ? jsonValue.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "DeferredScheduleResult(isAudienceMatch=" + this.isAudienceMatch + ", message=" + this.message + ", actions=" + this.actions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DeferredScheduleResult(boolean z, @Nullable InAppMessage inAppMessage, @Nullable JsonValue jsonValue) {
        this.isAudienceMatch = z;
        this.message = inAppMessage;
        this.actions = jsonValue;
    }

    public /* synthetic */ DeferredScheduleResult(boolean z, InAppMessage inAppMessage, JsonValue jsonValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : inAppMessage, (i & 4) != 0 ? null : jsonValue);
    }

    public final boolean isAudienceMatch() {
        return this.isAudienceMatch;
    }

    @Nullable
    public final InAppMessage getMessage() {
        return this.message;
    }

    @Nullable
    public final JsonValue getActions() {
        return this.actions;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/deferred/DeferredScheduleResult$Companion;", "", "()V", "ACTIONS", "", "IS_AUDIENCE_MATCH", "MESSAGE", "fromJson", "Lcom/urbanairship/automation/deferred/DeferredScheduleResult;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nDeferredScheduleResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeferredScheduleResult.kt\ncom/urbanairship/automation/deferred/DeferredScheduleResult$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,31:1\n44#2,15:32\n1#3:47\n*S KotlinDebug\n*F\n+ 1 DeferredScheduleResult.kt\ncom/urbanairship/automation/deferred/DeferredScheduleResult$Companion\n*L\n24#1:32,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DeferredScheduleResult fromJson(@NotNull JsonValue value) throws JsonException {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("audience_match");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'audience_match" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                boolValueOf = Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                boolValueOf = (Boolean) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                boolValueOf = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                boolValueOf = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                boolValueOf = (Boolean) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'audience_match" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) jsonValue2;
            }
            boolean zBooleanValue = boolValueOf.booleanValue();
            JsonValue jsonValue3 = jsonMapRequireMap.get("message");
            return new DeferredScheduleResult(zBooleanValue, jsonValue3 != null ? InAppMessage.INSTANCE.parseJson(jsonValue3) : null, jsonMapRequireMap.get("actions"));
        }
    }
}
