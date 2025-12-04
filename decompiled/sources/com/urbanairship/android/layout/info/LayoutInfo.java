package com.urbanairship.android.layout.info;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.BasePresentation;
import com.urbanairship.android.layout.EmbeddedPresentation;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/urbanairship/android/layout/info/LayoutInfo;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "version", "", "presentation", "Lcom/urbanairship/android/layout/BasePresentation;", "view", "Lcom/urbanairship/android/layout/info/ViewInfo;", "hash", "(ILcom/urbanairship/android/layout/BasePresentation;Lcom/urbanairship/android/layout/info/ViewInfo;I)V", "embeddedViewId", "", "getEmbeddedViewId", "()Ljava/lang/String;", "getHash", "()I", "isEmbedded", "", "()Z", "getPresentation", "()Lcom/urbanairship/android/layout/BasePresentation;", "getVersion", "getView", "()Lcom/urbanairship/android/layout/info/ViewInfo;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nLayoutInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutInfo.kt\ncom/urbanairship/android/layout/info/LayoutInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,31:1\n44#2,15:32\n44#2,15:47\n44#2,15:62\n*S KotlinDebug\n*F\n+ 1 LayoutInfo.kt\ncom/urbanairship/android/layout/info/LayoutInfo\n*L\n19#1:32,15\n20#1:47,15\n21#1:62,15\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class LayoutInfo {
    private final int hash;
    private final BasePresentation presentation;
    private final int version;
    private final ViewInfo view;

    public static /* synthetic */ LayoutInfo copy$default(LayoutInfo layoutInfo, int i, BasePresentation basePresentation, ViewInfo viewInfo, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = layoutInfo.version;
        }
        if ((i3 & 2) != 0) {
            basePresentation = layoutInfo.presentation;
        }
        if ((i3 & 4) != 0) {
            viewInfo = layoutInfo.view;
        }
        if ((i3 & 8) != 0) {
            i2 = layoutInfo.hash;
        }
        return layoutInfo.copy(i, basePresentation, viewInfo, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final BasePresentation getPresentation() {
        return this.presentation;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final ViewInfo getView() {
        return this.view;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHash() {
        return this.hash;
    }

    @NotNull
    public final LayoutInfo copy(int version, @NotNull BasePresentation presentation, @NotNull ViewInfo view, int hash) {
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(view, "view");
        return new LayoutInfo(version, presentation, view, hash);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayoutInfo)) {
            return false;
        }
        LayoutInfo layoutInfo = (LayoutInfo) other;
        return this.version == layoutInfo.version && Intrinsics.areEqual(this.presentation, layoutInfo.presentation) && Intrinsics.areEqual(this.view, layoutInfo.view) && this.hash == layoutInfo.hash;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.version) * 31) + this.presentation.hashCode()) * 31) + this.view.hashCode()) * 31) + Integer.hashCode(this.hash);
    }

    @NotNull
    public String toString() {
        return "LayoutInfo(version=" + this.version + ", presentation=" + this.presentation + ", view=" + this.view + ", hash=" + this.hash + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public LayoutInfo(int i, @NotNull BasePresentation presentation, @NotNull ViewInfo view, int i2) {
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(view, "view");
        this.version = i;
        this.presentation = presentation;
        this.view = view;
        this.hash = i2;
    }

    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public final BasePresentation getPresentation() {
        return this.presentation;
    }

    @NotNull
    public final ViewInfo getView() {
        return this.view;
    }

    public final int getHash() {
        return this.hash;
    }

    public final boolean isEmbedded() {
        return this.presentation instanceof EmbeddedPresentation;
    }

    @Nullable
    public final String getEmbeddedViewId() {
        BasePresentation basePresentation = this.presentation;
        EmbeddedPresentation embeddedPresentation = basePresentation instanceof EmbeddedPresentation ? (EmbeddedPresentation) basePresentation : null;
        if (embeddedPresentation != null) {
            return embeddedPresentation.getEmbeddedId();
        }
        return null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LayoutInfo(@NotNull JsonMap json) throws JsonException {
        Integer numValueOf;
        JsonMap jsonMapOptMap;
        JsonMap jsonMapOptMap2;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue = json.get("version");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'version" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            numValueOf = (Integer) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            numValueOf = (Integer) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            numValueOf = (Integer) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            numValueOf = (Integer) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            numValueOf = (Integer) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            numValueOf = (Integer) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            numValueOf = Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue.optList();
            if (objOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            numValueOf = (Integer) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue.optMap();
            if (objOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            numValueOf = (Integer) objOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'version" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            numValueOf = (Integer) jsonValue2;
        }
        int iIntValue = numValueOf.intValue();
        JsonValue jsonValue3 = json.get("presentation");
        if (jsonValue3 == null) {
            throw new JsonException("Missing required field: 'presentation" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString3 = jsonValue3.optString();
            if (objOptString3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString3;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString4 = jsonValue3.optString();
            if (objOptString4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString4;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue3.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            jsonMapOptMap = jsonValue3.optMap();
            if (jsonMapOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'presentation" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue4 = jsonValue3.getJsonValue();
            if (jsonValue4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonValue4;
        }
        BasePresentation basePresentationFromJson = BasePresentation.fromJson(jsonMapOptMap);
        Intrinsics.checkNotNullExpressionValue(basePresentationFromJson, "fromJson(...)");
        ViewInfo.Companion companion = ViewInfo.INSTANCE;
        JsonValue jsonValue5 = json.get("view");
        if (jsonValue5 == null) {
            throw new JsonException("Missing required field: 'view" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString5 = jsonValue5.optString();
            if (objOptString5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap2 = (JsonMap) objOptString5;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString6 = jsonValue5.optString();
            if (objOptString6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap2 = (JsonMap) objOptString6;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue5.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue5.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonMapOptMap2 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue5.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonMapOptMap2 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList2 = jsonValue5.optList();
            if (jsonSerializableOptList2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap2 = (JsonMap) jsonSerializableOptList2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            jsonMapOptMap2 = jsonValue5.optMap();
            if (jsonMapOptMap2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'view" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue6 = jsonValue5.getJsonValue();
            if (jsonValue6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap2 = (JsonMap) jsonValue6;
        }
        this(iIntValue, basePresentationFromJson, companion.viewInfoFromJson(jsonMapOptMap2), json.hashCode());
    }
}
