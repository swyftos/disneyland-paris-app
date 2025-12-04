package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.ToggleStyle;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010 R\u0014\u0010$\u001a\u0004\u0018\u00010%X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0014\u0010+\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u0004\u0018\u000104X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00067"}, d2 = {"Lcom/urbanairship/android/layout/info/CheckableInfo;", "Lcom/urbanairship/android/layout/info/ViewInfo;", "Lcom/urbanairship/android/layout/info/Checkable;", "Lcom/urbanairship/android/layout/info/View;", "Lcom/urbanairship/android/layout/info/Accessible;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "accessibilityHidden", "", "getAccessibilityHidden", "()Ljava/lang/Boolean;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "enableBehaviors", "", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "()Ljava/util/List;", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "localizedContentDescription", "Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "getLocalizedContentDescription", "()Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "style", "Lcom/urbanairship/android/layout/property/ToggleStyle;", "getStyle", "()Lcom/urbanairship/android/layout/property/ToggleStyle;", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/CheckableInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/CheckableInfo\n*L\n449#1:945,15\n*E\n"})
/* loaded from: classes5.dex */
public class CheckableInfo extends ViewInfo implements Checkable, View, Accessible {
    private final /* synthetic */ View $$delegate_0;
    private final /* synthetic */ Accessible $$delegate_1;
    private final ToggleStyle style;

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public Boolean getAccessibilityHidden() {
        return this.$$delegate_1.getAccessibilityHidden();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Color getBackgroundColor() {
        return this.$$delegate_0.getBackgroundColor();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Border getBorder() {
        return this.$$delegate_0.getBorder();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public CommonViewOverrides getCommonViewOverrides() {
        return this.$$delegate_0.getCommonViewOverrides();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public String getContentDescription() {
        return this.$$delegate_1.getContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EnableBehaviorType> getEnableBehaviors() {
        return this.$$delegate_0.getEnableBehaviors();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EventHandler> getEventHandlers() {
        return this.$$delegate_0.getEventHandlers();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public LocalizedContentDescription getLocalizedContentDescription() {
        return this.$$delegate_1.getLocalizedContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<ThomasStateTrigger> getStateTriggers() {
        return this.$$delegate_0.getStateTriggers();
    }

    @Override // com.urbanairship.android.layout.info.View
    @NotNull
    public ViewType getType() {
        return this.$$delegate_0.getType();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public VisibilityInfo getVisibility() {
        return this.$$delegate_0.getVisibility();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckableInfo(@NotNull JsonMap json) throws JsonException {
        JsonMap jsonMapOptMap;
        super(null);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.view(json);
        this.$$delegate_1 = ViewInfoKt.accessible(json);
        JsonValue jsonValue = json.get("style");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'style" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            jsonMapOptMap = jsonValue.optMap();
            if (jsonMapOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'style" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonValue2;
        }
        ToggleStyle toggleStyleFromJson = ToggleStyle.fromJson(jsonMapOptMap);
        Intrinsics.checkNotNullExpressionValue(toggleStyleFromJson, "fromJson(...)");
        this.style = toggleStyleFromJson;
    }

    @Override // com.urbanairship.android.layout.info.Checkable
    @NotNull
    public ToggleStyle getStyle() {
        return this.style;
    }
}
