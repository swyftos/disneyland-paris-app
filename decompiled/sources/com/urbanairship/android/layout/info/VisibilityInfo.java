package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/info/VisibilityInfo;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "invertWhenStateMatcher", "Lcom/urbanairship/json/JsonPredicate;", "default", "", "(Lcom/urbanairship/json/JsonPredicate;Z)V", "getDefault", "()Z", "getInvertWhenStateMatcher", "()Lcom/urbanairship/json/JsonPredicate;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/VisibilityInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:960\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/VisibilityInfo\n*L\n146#1:945,15\n147#1:960,15\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class VisibilityInfo {
    private final boolean default;
    private final JsonPredicate invertWhenStateMatcher;

    public static /* synthetic */ VisibilityInfo copy$default(VisibilityInfo visibilityInfo, JsonPredicate jsonPredicate, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonPredicate = visibilityInfo.invertWhenStateMatcher;
        }
        if ((i & 2) != 0) {
            z = visibilityInfo.default;
        }
        return visibilityInfo.copy(jsonPredicate, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final JsonPredicate getInvertWhenStateMatcher() {
        return this.invertWhenStateMatcher;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    @NotNull
    public final VisibilityInfo copy(@NotNull JsonPredicate invertWhenStateMatcher, boolean z) {
        Intrinsics.checkNotNullParameter(invertWhenStateMatcher, "invertWhenStateMatcher");
        return new VisibilityInfo(invertWhenStateMatcher, z);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisibilityInfo)) {
            return false;
        }
        VisibilityInfo visibilityInfo = (VisibilityInfo) other;
        return Intrinsics.areEqual(this.invertWhenStateMatcher, visibilityInfo.invertWhenStateMatcher) && this.default == visibilityInfo.default;
    }

    public int hashCode() {
        return (this.invertWhenStateMatcher.hashCode() * 31) + Boolean.hashCode(this.default);
    }

    @NotNull
    public String toString() {
        return "VisibilityInfo(invertWhenStateMatcher=" + this.invertWhenStateMatcher + ", default=" + this.default + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VisibilityInfo(@NotNull JsonMap json) throws JsonException {
        JsonValue jsonValue;
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue2 = json.get("invert_when_state_matches");
        if (jsonValue2 == null) {
            throw new JsonException("Missing required field: 'invert_when_state_matches" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            jsonValue = (JsonValue) jsonValue2.optString();
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonValue = (JsonValue) Boolean.valueOf(jsonValue2.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonValue = (JsonValue) Long.valueOf(jsonValue2.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonValue = (JsonValue) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonValue = (JsonValue) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonValue = (JsonValue) Integer.valueOf(jsonValue2.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            jsonValue = (JsonValue) jsonValue2.optList();
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            jsonValue = (JsonValue) jsonValue2.optMap();
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'invert_when_state_matches" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue = jsonValue2.getJsonValue();
        }
        JsonPredicate jsonPredicate = JsonPredicate.parse(jsonValue);
        Intrinsics.checkNotNullExpressionValue(jsonPredicate, "parse(...)");
        JsonValue jsonValue3 = json.get("default");
        if (jsonValue3 == null) {
            throw new JsonException("Missing required field: 'default" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue3.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue3.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            boolValueOf = Boolean.valueOf(jsonValue3.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            boolValueOf = (Boolean) Long.valueOf(jsonValue3.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
            boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            boolValueOf = (Boolean) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            boolValueOf = (Boolean) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
            boolValueOf = (Boolean) Integer.valueOf(jsonValue3.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
            boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue3.optList();
            if (objOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue3.optMap();
            if (objOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) objOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'default" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue4 = jsonValue3.getJsonValue();
            if (jsonValue4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) jsonValue4;
        }
        this(jsonPredicate, boolValueOf.booleanValue());
    }

    public VisibilityInfo(@NotNull JsonPredicate invertWhenStateMatcher, boolean z) {
        Intrinsics.checkNotNullParameter(invertWhenStateMatcher, "invertWhenStateMatcher");
        this.invertWhenStateMatcher = invertWhenStateMatcher;
        this.default = z;
    }

    @NotNull
    public final JsonPredicate getInvertWhenStateMatcher() {
        return this.invertWhenStateMatcher;
    }

    public final boolean getDefault() {
        return this.default;
    }
}
